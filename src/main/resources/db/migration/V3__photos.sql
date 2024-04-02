CREATE TABLE photos
(
    id     BIGSERIAL PRIMARY KEY,
    name   VARCHAR(255) NOT NULL,
    photo  BYTEA        NOT NULL,
    format VARCHAR(255) NOT NULL
);

ALTER TABLE students DROP COLUMN photo;

ALTER TABLE students
    ADD COLUMN photo_id BIGINT;

ALTER TABLE students
    ADD CONSTRAINT fk_photo FOREIGN KEY (photo_id) REFERENCES photos (id);
