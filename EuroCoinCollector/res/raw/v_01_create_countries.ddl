/*
* A file defining the schema of the countries table.
*/

CREATE TABLE countries (
  _id INTEGER PRIMARY KEY AUTOINCREMENT,
  code TEXT UNIQUE NOT NULL,
  country_name TEXT UNIQUE NOT NULL,
  country_flag TEXT NOT NULL
 );
