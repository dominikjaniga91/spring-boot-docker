CREATE TABLE users (
   id serial PRIMARY KEY,
   username VARCHAR(50) NOT NULL,
   amount_of_posts INTEGER NOT NULL
);

INSERT INTO users (id, username, amount_of_posts) values (1, 'Dominik', 0);