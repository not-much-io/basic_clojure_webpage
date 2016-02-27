(ns basic-clojure-webpage.db.quotes
  (:require [hugsql.core :as hugsql]))

(def db-spec {:classname "org.sqlite.JDBC"
              :subprotocol "SQLite"
              :subname "/home/not-much-io/Projects/basic_clojure_webpage/resources/basic_db.db"})

(hugsql/def-db-fns "basic_clojure_webpage/db/quotes.sql")

(defn create-quote-table []
  (_create-quote-table db-spec))

(defn insert-quote [quote]
  (_insert-quote db-spec quote))

(defn get-quotes []
  (_get-quotes db-spec))

(defn delete-quote-with-id [quote-id]
  (_delete-quote-with-id db-spec quote-id))