-- :name _create-quote-table :!
CREATE TABLE IF NOT EXISTS quotes (
  id INTEGER PRIMARY KEY,
  quote TEXT
);

-- :name _insert-quote :! :n
INSERT INTO quotes (quote)
VALUES (:quote);

-- :name _delete-quote-with-id :! :n
DELETE FROM quotes WHERE id = :id;

-- :name _drop-quotes-table :!
DROP TABLE IF EXISTS quotes;

-- :name _get-quotes
SELECT * FROM quotes;
