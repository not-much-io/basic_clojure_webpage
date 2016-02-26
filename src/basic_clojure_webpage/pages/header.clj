(ns basic-clojure-webpage.pages.header
  (:require [hiccup.element :refer [link-to]]))

(defn header []
  [:ol
   [:li (link-to "/" "Home")]
   [:li (link-to "/add" "Add")]])