(defproject basic_clojure_webpage "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [hiccup "1.0.5"]
                 [org.xerial/sqlite-jdbc "3.7.2"]
                 [com.layerware/hugsql "0.4.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler basic-clojure-webpage.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
