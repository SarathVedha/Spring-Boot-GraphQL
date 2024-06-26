CREATE TABLE countries
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name       VARCHAR(255),
    code       VARCHAR(255),
    capital    VARCHAR(255),
    currency   VARCHAR(255),
    aws_region VARCHAR(255),
    CONSTRAINT pk_countries PRIMARY KEY (id)
);