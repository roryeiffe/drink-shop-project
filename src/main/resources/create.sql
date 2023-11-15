CREATE TABLE IF NOT EXISTS product (
    name VARCHAR(255) PRIMARY KEY,
    price DECIMAL(10,2),
    calories INT,
    category VARCHAR(255)
);