CREATE TABLE IF NOT EXISTS todos (
    todo_id IDENTITY,
    todo_title VARCHAR(30),
    finished BOOLEAN,
    created_at TIMESTAMP
);
