CREATE TABLE pollution
(
    ID                 UUID PRIMARY KEY,
    creation_timestamp DATE NOT NULL
);

CREATE TABLE "user"
(
    ID                 UUID PRIMARY KEY,
    creation_timestamp DATE         NOT NULL,
    first_name         VARCHAR(255) NOT NULL,
    last_name          VARCHAR(255) NOT NULL,
    patronymic         VARCHAR(255),
    birth_date         DATE         NOT NULL
);