ALTER TABLE tasks
    ADD COLUMN difficulty DOUBLE PRECISION,
    ADD COLUMN created_at timestamp,
    ADD COLUMN expired_at DATE;