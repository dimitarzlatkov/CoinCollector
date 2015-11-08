/*
* A file defining the schema of the coins table.
*/

CREATE TABLE coins (
  _id INTEGER PRIMARY KEY AUTOINCREMENT,
  country_code TEXT NOT NULL,
  facial_value INTEGER NOT NULL,
  value DOUBLE NOT NULL,
  image TEXT,
  description TEXT,
  shape TEXT,
  weight DOUBLE,
  diameter DOUBLE,
  thickness TEXT,
  commemorative BOOLEAN NOT NULL,
  have_it BOOLEAN NOT NULL default false,
  currency_type TEXT,
  memo TEXT,
  FOREIGN KEY(country_code) REFERENCES countries(code)
 );
