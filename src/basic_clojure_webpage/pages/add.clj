(ns basic-clojure-webpage.pages.add
  (:require [hiccup.core :as h]
            [hiccup.form :as f]
            [basic-clojure-webpage.pages.header :refer [header]]))

(defn add-page []
  (h/html
    [:div
     [:h1 "Add new quote"]
     (header)
     (f/form-to [:post "/post-quote"]
                (f/label "quote" "What quote do you have?")
                (f/text-field "quote" "Your awesome quote!")
                (f/submit-button "Add Quote"))]))
