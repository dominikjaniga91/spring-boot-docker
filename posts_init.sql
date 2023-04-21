CREATE TABLE posts (
    id        serial PRIMARY KEY,
    author_id INTEGER UNIQUE NOT NULL,
    text      VARCHAR(255)   NOT NULL,
    posted_at TIMESTAMP      NOT NULL
);

INSERT INTO posts (id, author_id, text, posted_at) values (1, 1, 'Post text', '02-10-2022');