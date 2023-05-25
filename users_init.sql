CREATE TABLE users (
   id serial PRIMARY KEY,
   username VARCHAR(50) NOT NULL,
   amount_of_posts INTEGER NOT NULL
);