(ns basic-clojure-webpage.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [basic-clojure-webpage.pages.home :refer [home-page]]
            [basic-clojure-webpage.db.quotes :as db]))

(defn handle-post-to-home [params]
  (let [id    (:id params)
        quote (:quote params)]
    (cond id    (db/delete-quote-with-id params)
          quote (db/insert-quote params)
          :else "Error!")))

(defroutes app-routes
           (GET "/" []
             (home-page))
           (POST "/" {params :params}
             (do
               (handle-post-to-home params)
               (home-page)))
           (route/not-found "Not Found"))

(def app
  (let [my-site-defaults (assoc-in site-defaults
                                   [:security :anti-forgery] false)]
    (wrap-defaults app-routes my-site-defaults)))
