(ns basic-clojure-webpage.db.quotes
  (:require [hugsql.core :as hugsql]))

(def db-spec {:classname "org.sqlite.JDBC"
              :subprotocol "SQLite"
              :subname "/home/not-much-io/Projects/basic_clojure_webpage/resources/basic_db.db"})

(hugsql/def-db-fns "basic_clojure_webpage/db/quotes.sql")