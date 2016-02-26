(ns basic-clojure-webpage.pages.home
  (:require [hiccup.core :as h]
            [basic-clojure-webpage.pages.header :refer [header]]
            [basic-clojure-webpage.db.quotes :as db]))

(defn quotes-list []
  [:h3 "Quotes"
   [:ol
    (for [quote (db/get-quotes db/db-spec)]
      [:li (str (:quote quote))])]])

(defn home-page []
  (h/html
    [:div
     [:h1 "Home page"]
     (header)
     (quotes-list)]))
