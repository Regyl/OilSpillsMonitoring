CREATE TABLE pollution
(
    ID                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    creation_timestamp DATE NOT NULL    default current_date,
    company_name       TEXT,
    company_inn        BIGINT,
    hazard_type        VARCHAR(100)
);

CREATE TABLE "user"
(
    ID                 UUID PRIMARY KEY      DEFAULT gen_random_uuid(),
    creation_timestamp DATE         NOT NULL default current_date,
    first_name         VARCHAR(255) NOT NULL,
    last_name          VARCHAR(255) NOT NULL,
    patronymic         VARCHAR(255),
    birth_date         DATE         NOT NULL
);