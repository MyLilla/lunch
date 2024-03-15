ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password, admin)
VALUES ('User', 'user@yandex.ru', 'password', false),
       ('Admin', 'admin@gmail.com', 'admin', true);

INSERT INTO restaurant (name)
VALUES ('rest1'),
       ('rest2');

INSERT INTO meal (id, name, price, date, restaurant_id)
VALUES (DEFAULT, 'Food1', 12, '2024-03-06', 100002),
       (DEFAULT, 'Food2', 3, '2024-03-06', 100002);
