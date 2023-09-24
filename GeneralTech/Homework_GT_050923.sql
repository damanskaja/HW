-- 1. Describe the shippers table using Spanish. Mechanism Constraints

-- CREATE TABLE shippers (
-- ShipperID INT PRIMARY KEY,
-- ShipperName VARCHAR(255) NOT NULL,
-- Phone VARCHAR(20) UNIQUE
-- );


-- 2. Display orders made from May 1, 2022 to May 20, 2022
-- SELECT *
-- FROM Orders
-- WHERE OrderDate >= '2022-05-01' AND OrderDate <= '2022-05-20';


-- 3.Describe an "online testing" database design using an online database design tool. It is necessary to provide for user registration and the choice of topics for testing.

-- CREATE TABLE users (
-- id serial PRIMARY KEY,
-- first_name varchar(50),
-- last_name varchar(50),
-- email varchar(124) UNIQUE
-- );

-- CREATE TABLE tests (
-- id serial PRIMARY KEY,
-- title varchar(128) UNIQUE,
-- description varchar(128),
-- default_points int
-- );

-- CREATE TABLE questions (
-- id serial PRIMARY KEY,
-- test_id integer REFERENCES tests(id),
-- title varchar(256),
-- max_points int
-- );

-- CREATE TABLE answers (
-- id serial PRIMARY KEY,
-- question_id integer REFERENCES questions(id),
-- text varchar(245),
-- is_correct boolean
-- );

-- CREATE TABLE results (
-- id serial PRIMARY KEY,
-- user_id integer REFERENCES users(id),
-- test_id integer REFERENCES tests(id),
-- count_points integer
-- );

