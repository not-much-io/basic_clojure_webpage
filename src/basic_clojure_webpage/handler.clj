(ns basic-clojure-webpage.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [basic-clojure-webpage.pages.home :refer [home-page]]
            [basic-clojure-webpage.pages.add :refer [add-page]]
            [basic-clojure-webpage.db.quotes :as db]))

(defroutes app-routes
           (GET "/" []
             (home-page))
           (GET "/add" []
             (add-page))
           (POST "/post-quote" {params :params}
             (do
               (db/insert-quote db/db-spec params)
               (home-page)))
           (route/not-found "Not Found"))

(def app
  (let [my-site-defaults (assoc-in site-defaults
                                   [:security :anti-forgery] false)]
    (wrap-defaults app-routes my-site-defaults)))
