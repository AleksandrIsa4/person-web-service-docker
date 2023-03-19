CREATE TABLE IF NOT EXISTS people (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
  name VARCHAR(255) NOT NULL,
  age BIGINT NOT NULL,
  russian BOOLEAN,
  CONSTRAINT pk_person PRIMARY KEY (id)
);