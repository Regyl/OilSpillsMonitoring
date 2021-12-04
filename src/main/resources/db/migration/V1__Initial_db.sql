CREATE TABLE location
(
    ID                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    creation_timestamp DATE   NOT NULL  DEFAULT current_date,
    latitude           BIGINT NOT NULL,
    longitude          BIGINT NOT NULL
);

CREATE TABLE pollution
(
    ID                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    creation_timestamp DATE NOT NULL    DEFAULT current_date,
    company_name       TEXT,
    company_inn        BIGINT,
    start_location     UUID NOT NULL,
    end_location       UUID NOT NULL,
    date               DATE,
    hazard_type        VARCHAR(100),
    additional_info    TEXT,
    FOREIGN KEY (start_location) REFERENCES location (ID),
    FOREIGN KEY (end_location) REFERENCES location (ID)
);

CREATE TABLE uav_route
(
    ID                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    creation_timestamp DATE   NOT NULL  DEFAULT current_date,
    flight_altitude    BIGINT NOT NULL
);

CREATE TABLE uav_route_location
(
    ID                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    creation_timestamp DATE NOT NULL    DEFAULT current_date,
    uav_route_id       UUID NOT NULL,
    location_id        UUID NOT NULL,
    FOREIGN KEY (uav_route_id) REFERENCES uav_route (ID),
    FOREIGN KEY (location_id) REFERENCES location (ID)
);

CREATE TABLE "user"
(
    ID                 UUID PRIMARY KEY      DEFAULT gen_random_uuid(),
    creation_timestamp DATE         NOT NULL DEFAULT current_date,
    first_name         VARCHAR(255) NOT NULL,
    last_name          VARCHAR(255) NOT NULL,
    patronymic         VARCHAR(255),
    birth_date         DATE         NOT NULL
);