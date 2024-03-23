-- Create the database
CREATE DATABASE IF NOT EXISTS supermarket;

-- Use the created database
USE supermarket;

-- Create tables
CREATE TABLE IF NOT EXISTS client (
    client_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    fname VARCHAR(50) NOT NULL,
    lname VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS driver (
    driver_id INT AUTO_INCREMENT PRIMARY KEY,
    drivername VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS supplier (
    supplier_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    driver_id INT,
    FOREIGN KEY (driver_id) REFERENCES driver(driver_id)
);

CREATE TABLE IF NOT EXISTS employee (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(50) NOT NULL,
    lname VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS item (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    itemname VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    supplier_id INT,
    FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id)
);

CREATE TABLE IF NOT EXISTS purchase (
    purchase_id INT AUTO_INCREMENT PRIMARY KEY,
    date DATETIME NOT NULL,
    totalprice DECIMAL(10, 2) NOT NULL,
    client_id INT,
    employee_id INT,
    FOREIGN KEY (client_id) REFERENCES client(client_id),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

CREATE TABLE IF NOT EXISTS purchase_item (
    purchase_item_id INT AUTO_INCREMENT PRIMARY KEY,
    purchase_id INT,
    item_id INT,
    FOREIGN KEY (purchase_id) REFERENCES purchase(purchase_id),
    FOREIGN KEY (item_id) REFERENCES item(item_id)
);

-- Insert data into tables
INSERT INTO client (email, fname, lname)
VALUES ('john@example.com', 'John', 'Doe'),
       ('jane@example.com', 'Jane', 'Smith');

INSERT INTO driver (drivername)
VALUES ('James'),
       ('Emily');

INSERT INTO supplier (name, driver_id)
VALUES ('Supplier X', 1),
       ('Supplier Y', 2);

INSERT INTO employee (fname, lname)
VALUES ('Michael', 'Johnson'),
       ('Sarah', 'Williams');

INSERT INTO item (itemname, price, stock, supplier_id)
VALUES ('Item A', 10.99, 100, 1),
       ('Item B', 15.99, 50, 2),
       ('Item C', 5.99, 200, 2);

INSERT INTO purchase (date, totalprice, client_id, employee_id)
VALUES ('2023-05-01 09:00:00', 35.97, 1, 1),
       ('2023-05-02 13:30:00', 15.99, 2, 2),
       ('2023-05-03 16:45:00', 21.98, 1, 2);

INSERT INTO purchase_item (purchase_id, item_id)
VALUES (1, 1),
       (1, 1),
       (2, 2),
       (3, 3),
       (3, 3);
