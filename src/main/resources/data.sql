INSERT INTO users (name, email, password, admin)
VALUES ('User', 'user@yandex.ru', 'password', false),
       ('Admin', 'admin@gmail.com', 'admin', true);

INSERT INTO restaurant (name, rating)
VALUES ('rest1', 0),
       ('rest2', 0);

INSERT INTO meal (name, price, date, available, restaurant_id)
VALUES ('Food1', 12, '2024-03-06', false, 1),
       ('Food2', 3, '2024-03-06', false, 2);
