DROP DATABASE IF EXISTS activejdbc;

CREATE DATABASE activejdbc;

\c activejdbc;

CREATE TABLE people (
  id  serial PRIMARY KEY,
  first_name VARCHAR(56) NOT NULL,
  last_name VARCHAR(56),
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);
