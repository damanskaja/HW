CREATE TABLE `customers` (
  `customer_id` integer PRIMARY KEY NOT NULL,
  `name` varchar(255) UNIQUE NOT NULL,
  `email` varchar(255) UNIQUE NOT NULL,
  `age` varchar(255) NOT NULL,
  `created_at` timestamp,
  `average_bill` float,
  `number_of_views` integer,
  `is_blocked` bool DEFAULT "false"
);

CREATE TABLE `movies` (
  `movie_id` integer PRIMARY KEY NOT NULL,
  `name` varchar(255),
  `schedule_id` integer,
  `order_id` integer,
  `days_at_the_box_office` integer,
  `session_time` timestamp,
  `notes` text,
  `created_at` timestamp
);

CREATE TABLE `halls` (
  `hall_id` integer PRIMARY KEY NOT NULL,
  `movie_id` integer,
  `staff_id` integer,
  `status` varchar(255),
  `created_at` timestamp
);

CREATE TABLE `orders` (
  `order_id` integer PRIMARY KEY NOT NULL,
  `movie_id` integer,
  `price` integer,
  `created_at` timestamp
);

CREATE TABLE `staff` (
  `staff_id` integer PRIMARY KEY NOT NULL,
  `employee_id` integer,
  `hall_id` integer
);

CREATE TABLE `employees` (
  `employee_id` integer PRIMARY KEY NOT NULL,
  `name` varchar(255) NOT NULL,
  `position` varchar(255),
  `hire_date` timestamp,
  `salary` integer
);

CREATE TABLE `schedule` (
  `schedule_id` integer PRIMARY KEY NOT NULL,
  `movie_id` integer,
  `hall_id` integer
);

ALTER TABLE `halls` ADD FOREIGN KEY (`hall_id`) REFERENCES `staff` (`staff_id`);

ALTER TABLE `halls` ADD FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`);

ALTER TABLE `movies` ADD FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`);

ALTER TABLE `employees` ADD FOREIGN KEY (`employee_id`) REFERENCES `staff` (`employee_id`);
