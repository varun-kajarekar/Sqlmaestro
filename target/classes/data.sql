CREATE TABLE products (
  product_id INT PRIMARY KEY AUTO_INCREMENT,
  product_name VARCHAR(255) NOT NULL,
  product_price DECIMAL(10,2) NOT NULL,
  product_category VARCHAR(50) NOT NULL
);

CREATE TABLE orders (
  order_id INT PRIMARY KEY AUTO_INCREMENT,
  customer_id INT NOT NULL,
  order_date DATETIME NOT NULL,
  order_status VARCHAR(20) NOT NULL
);

CREATE TABLE order_items (
  order_item_id INT PRIMARY KEY AUTO_INCREMENT,
  order_id INT NOT NULL,
  product_id INT NOT NULL,
  quantity INT NOT NULL
);

CREATE TABLE customers (
  customer_id INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(255) NOT NULL,
  shipping_address VARCHAR(255) NOT NULL
);

INSERT INTO products (product_name,  product_price,  product_category) VALUES
('Men T-Shirt',  24.99,  'Apparel'),
('Women Jeans',  49.99,  'Apparel'),
('Laptop', 799.99,  'Electronics'),
('Smartphone',  599.99,  'Electronics'),
('Book',  19.99, 'Books'),
('Headphones', 49.99,  'Electronics'),
('Speakers', 99.99,  'Electronics'),
('Coffee Maker',  69.99,  'Home Goods');

INSERT INTO orders (customer_id, order_date, order_status) VALUES
(1, '2023-11-20', 'Processing'),
(2, '2023-11-21', 'Shipped'),
(3, '2023-11-22', 'Delivered'),
(4, '2023-11-23', 'Pending'),
(5, '2023-11-24', 'Processing'),
(6, '2023-11-25', 'Shipped');

INSERT INTO order_items (order_id, product_id, quantity) VALUES
(1, 1, 2),
(1, 3, 1),
(2, 2, 1),
(2, 4, 1),
(3, 5, 1),
(4, 2, 1),
(4, 5, 1),
(5, 1, 2),
(5, 3, 1),
(6, 4, 1),
(6, 6, 1);
INSERT INTO customers (first_name, last_name, email, shipping_address) VALUES
('John', 'Doe', 'johndoe@example.com', '123 Main Street, Anytown, CA 12345'),
('Jane', 'Smith', 'janesmith@example.com', '456 Elm Street, Anytown, CA 12345'),
('Peter', 'Jones', 'peterjones@example.com', '789 Oak Street, Anytown, CA 12345'),
('Mary', 'Johnson', 'maryjohnson@example.com', '123 Main Street, Anytown, CA 98765'),
('David', 'Williams', 'davidwilliams@example.com', '456 Elm Street, Anytown, CA 98765'),
('Susan', 'Miller', 'susanmiller@example.com', '789 Oak Street, Anytown, CA 98765');
