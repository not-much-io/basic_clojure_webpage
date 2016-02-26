-- :name create-quote-table :!
CREATE TABLE IF NOT EXISTS quotes (
  id INTEGER PRIMARY KEY,
  quote TEXT
);

-- :name insert-quote :! :n
INSERT INTO quotes (quote)
VALUES (:quote);

-- :name delete-quote-with-id :! :n
DELETE FROM quotes WHERE id = :id;

-- :name drop-quotes-table :!
DROP TABLE IF EXISTS quotes;

-- :name get-quotes
SELECT * FROM quotes;
