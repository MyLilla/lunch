DROP TABLE IF EXISTS meal;
DROP TABLE IF EXISTS restaurant;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE public.users
(
    id                   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name                 VARCHAR                           NOT NULL,
    email                VARCHAR                           NOT NULL,
    password             VARCHAR                           NOT NULL,
    admin                BOOL                DEFAULT FALSE NOT NULL,
    last_vote_date_time  TIMESTAMP           DEFAULT ((now()) - INTERVAL '1 DAY'),
    last_vote_restaurant INTEGER             DEFAULT 0
);

CREATE TABLE restaurant
(
    id     INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name   VARCHAR NOT NULL,
    rating INTEGER NOT NULL    DEFAULT 0
);

CREATE TABLE meal
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name          VARCHAR NOT NULL,
    price         INTEGER NOT NULL,
    date          DATE    NOT NULL    DEFAULT now(),
    restaurant_id INTEGER,
    FOREIGN KEY (restaurant_id) REFERENCES restaurant (id)
);
