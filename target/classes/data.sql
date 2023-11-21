CREATE TABLE products (
  product_id INT PRIMARY KEY AUTO_INCREMENT,
  product_name VARCHAR(255) NOT NULL,
  product_description TEXT,
  product_price DECIMAL(10,2) NOT NULL,
  product_image_url VARCHAR(255),
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

INSERT INTO products (product_name, product_description, product_price, product_image_url, product_category) VALUES
('Men T-Shirt', 'A comfortable and stylish T-shirt for men.', 24.99, 'https://www.example.com/images/mens-t-shirt.jpg', 'Apparel'),
('Women Jeans', 'A pair of stylish and comfortable jeans for women.', 49.99, 'https://www.example.com/images/womens-jeans.jpg', 'Apparel'),
('Laptop', 'A powerful and versatile laptop for everyday use.', 799.99, 'https://www.example.com/images/laptop.jpg', 'Electronics'),
('Smartphone', 'A sleek and powerful smartphone with the latest features.', 599.99, 'https://www.example.com/images/smartphone.jpg', 'Electronics'),
('Book', 'A captivating and thought-provoking novel.', 19.99, 'https://www.example.com/images/book.jpg', 'Books'),
('Headphones', 'A pair of high-quality headphones for listening to music.', 49.99, 'https://www.example.com/images/headphones.jpg', 'Electronics'),
('Speakers', 'A pair of powerful speakers for enjoying music and movies.', 99.99, 'https://www.example.com/images/speakers.jpg', 'Electronics'),
('Coffee Maker', 'A convenient and stylish coffee maker for brewing delicious coffee.', 69.99, 'https://www.example.com/images/coffee-maker.jpg', 'Home Goods');

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
