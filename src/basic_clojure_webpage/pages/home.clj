(ns basic-clojure-webpage.pages.home
  (:require [hiccup.core :as h]
            [hiccup.form :as f]
            [basic-clojure-webpage.db.quotes :as db]))

(defn add-quote-form []
  [:h3 "Add new quote"]
  (f/form-to [:post "/"]
             (f/label "quote" "What quote do you have?")
             [:br]
             (f/text-field "quote" "Your awesome quote!")
             [:br]
             (f/submit-button "Add Quote")))


(defn delete-quote-button [id]
  (f/form-to [:post "/"]
             [:input {:type  "hidden"
                      :name  "id"
                      :value id} ]
             (f/submit-button "Delete")))

(defn quotes-list []
  [:h3 "Quotes"
   [:ol
    (for [{:keys [id quote]} (db/get-quotes)]
      [:li quote
       (delete-quote-button id)])]])

(defn home-page []
  (h/html
    [:div
     [:h1 "Home page"]
     (add-quote-form)
     (quotes-list)]))
