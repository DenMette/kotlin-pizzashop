CREATE TABLE ${schema-name}.pizza
(
    id       UUID         NOT NULL,
    name     VARCHAR(255) NOT NULL,
    price    DOUBLE PRECISION,
    toppings VARCHAR(255),
    CONSTRAINT pk_pizza PRIMARY KEY (id)
);

ALTER TABLE ${schema-name}.pizza
    ADD CONSTRAINT uc_pizza_id UNIQUE (id);