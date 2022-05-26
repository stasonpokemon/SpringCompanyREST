DROP DATABASE IF EXISTS my_company;
CREATE DATABASE my_company;
use my_company;

CREATE TABLE details
(
    id               INT AUTO_INCREMENT,
    name             VARCHAR(50),
    surname          VARCHAR(50),
    patronymic       VARCHAR(50),
    age              int,
    date_of_birthday VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE employees
(
    id         INT AUTO_INCREMENT,
    user_name  VARCHAR(50),
    department VARCHAR(50),
    detail_id  INT,
    PRIMARY KEY (id),
    FOREIGN KEY (detail_id) REFERENCES details (id)
);

INSERT INTO details(name, surname, patronymic, age, date_of_birthday)
    VALUE ('Stanislau','Trebnikau','Andreevich',20,'13.07.2001');
INSERT INTO employees(user_name, department, detail_id)
    VALUE ('stason420','IT',1);
INSERT INTO details(name, surname, patronymic, age, date_of_birthday)
    VALUE ('Anastasia','Demeshenko','Urievna',21,'04.05.2001');
INSERT INTO employees(user_name, department, detail_id)
    VALUE ('nestydem','Design',2);

SELECT * FROM employees;
SELECT * FROM details;