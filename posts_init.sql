CREATE TABLE posts (
    id        serial PRIMARY KEY,
    author_id INTEGER UNIQUE NOT NULL,
    text      VARCHAR(255)   NOT NULL,
    posted_at TIMESTAMP      NOT NULL
);