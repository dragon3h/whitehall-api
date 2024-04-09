CREATE TABLE IF NOT EXISTS `drinks` (
    `id` INT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255),
    `price` DOUBLE,
    `volume` INT,
    `category` VARCHAR(255),
    `image` VARCHAR(255),
    `date_added` timestamp,
    `date_modified` timestamp,
    `order_id` INT
    );