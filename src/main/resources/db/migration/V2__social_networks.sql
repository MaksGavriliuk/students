CREATE TABLE social_networks
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(255)  NOT NULL UNIQUE,
    picture VARCHAR(1024) NOT NULL
);

CREATE TABLE student_social_networks
(
    id                BIGSERIAL PRIMARY KEY,
    social_network_id BIGINT       NOT NULL,
    student_id        BIGINT       NOT NULL,
    link              VARCHAR(512) NOT NULL,
    FOREIGN KEY (social_network_id) REFERENCES social_networks (id),
    FOREIGN KEY (student_id) REFERENCES students (id)
);

ALTER TABLE students
    ADD COLUMN hometown VARCHAR(255) NOT NULL;
ALTER TABLE students
    ADD COLUMN address VARCHAR(255) NOT NULL;

ALTER TABLE students
    ADD COLUMN phone_number VARCHAR(255) NOT NULL;

ALTER TABLE students
    ADD COLUMN photo BYTEA;