CREATE TABLE Book (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    isbn VARCHAR(20) UNIQUE,
    price DECIMAL(8,2),
    published_date DATE,
    in_stock INT DEFAULT 1
);

INSERT INTO Book (title, isbn, price, published_date, in_stock)
VALUES
('C Programming', 'ISBN001', 450.00, '2019-05-10', 1),
('Operating Systems', 'ISBN002', 550.00, '2021-08-15', 1),
('Computer Networks', 'ISBN003', 350.00, '2018-03-20', 0),
('Data Structures', 'ISBN004', 600.00, '2022-01-12', 1);

INSERT INTO Book (title, isbn, price, published_date)
VALUES
('Machine Learning', 'ISBN005', 400.00, '2017-11-25');

ALTER TABLE Book
RENAME COLUMN title TO book_title;

ALTER TABLE Book
MODIFY COLUMN price FLOAT;

ALTER TABLE Book
ADD COLUMN author_name VARCHAR(50) NOT NULL DEFAULT 'Unknown';

UPDATE Book
SET price = price * 0.9
WHERE book_id IN(1,3,5);

DELETE FROM Book
WHERE book_id= 3;

ALTER TABLE Book
AUTO_INCREMENT = 101;

SELECT book_title, price, published_date
FROM Book
WHERE book_title LIKE '%Programming%'
AND price > 300
ORDER BY price DESC;

CREATE TABLE Members (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    member_name VARCHAR(100) NOT NULL,
    join_date DATE NOT NULL DEFAULT (CURDATE())
);

SELECT *
FROM Members
WHERE YEAR(join_date) = 2025
ORDER BY member_name ASC;