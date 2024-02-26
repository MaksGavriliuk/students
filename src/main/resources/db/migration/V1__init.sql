CREATE TABLE specialties
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE groups
(
    id                BIGSERIAL PRIMARY KEY,
    group_number      VARCHAR(255) NOT NULL,
    specialization_id INT          NOT NULL,
    FOREIGN KEY (specialization_id) REFERENCES specialties (id)
);

CREATE TABLE students
(
    id            BIGSERIAL PRIMARY KEY,
    surname       VARCHAR(255) NOT NULL,
    name          VARCHAR(255) NOT NULL,
    patronymic    VARCHAR(255) NOT NULL,
    gender        VARCHAR(255) NOT NULL,
    date_of_birth DATE         NOT NULL,
    group_id      INT          NOT NULL,
    FOREIGN KEY (group_id) REFERENCES groups (id)
);

CREATE TABLE student_activities
(
    id            BIGSERIAL PRIMARY KEY,
    description   VARCHAR(255) NOT NULL,
    activity_date DATE         NOT NULL,
    student_id    INT          NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students (id)
);

CREATE TABLE scientific_publications
(
    id                BIGSERIAL PRIMARY KEY,
    journal           VARCHAR(255) NOT NULL,
    publication_title VARCHAR(255) NOT NULL,
    publication_date  DATE         NOT NULL,
    student_id        INT          NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students (id)
);

