-- 1)
-- Create database streaming;

-- 2)
-- Add to each of the database tables several records; 
 
-- CREATE TABLE users (
-- user_id int primary key auto_increment,
-- created_at timestamp,
-- username varchar(32),
-- country varchar(32),
-- is_blocked bool
-- );

-- insert into users (created_at, username, country, is_blocked) value ('2010-10-10 00:30:30', 'Alex', 'Germany', false);
-- insert into users (created_at, username, country, is_blocked) value ('2009-11-01 01:11:55', 'Helena', 'France', false);
-- insert into users (created_at, username, country, is_blocked) value ('2010-07-11 03:01:05', 'Mike', 'Italy', false);
-- insert into users (created_at, username, country, is_blocked) value ('2009-12-19 00:02:24', 'John', 'Monaco', true);
-- insert into users (created_at, username, country, is_blocked) value ('2009-12-20 00:01:24', 'Jane', 'Bali', true);
-- insert into users (created_at, username, country, is_blocked) value ('2011-10-23 00:01:24', 'Anita', 'Spain', true);
-- insert into users (created_at, username, country, is_blocked) value ('2010-11-21 00:01:24', 'Stefan', 'England', false);


-- CREATE TABLE streams (
-- stream_id int primary key auto_increment,
-- created_at timestamp,
-- author_id int,
-- title varchar(128),
-- is_completed bool
-- );

-- insert into streams (created_at, author_id, title, is_completed) values ('2011-01-05 00:30:30', 1, 'Stream 1', true);
-- insert into streams (created_at, author_id, title, is_completed) values ('2011-12-22 00:30:30', 1, 'Stream 3', true);
-- insert into streams (created_at, author_id, title, is_completed) values ('2013-05-04 00:30:30', 3, 'Stream 4', true);
-- insert into streams (created_at, author_id, title, is_completed) values ('2015-06-29 00:30:30', 2, 'Stream 6', true);
-- insert into streams (created_at, author_id, title, is_completed) values ('2011-04-24 00:30:30', 5, 'Stream 7', true);
-- insert into streams (created_at, author_id, title, is_completed) values ('2014-09-30 00:30:30', 5, 'Stream 8', true);
-- insert into streams (created_at, author_id, title, is_completed) values ('2012-02-03 00:30:30', 3, 'Stream 9', true);
-- insert into streams (created_at, author_id, title, is_completed) values ('2011-06-05 00:30:30', 5, 'Stream 10', true);


-- CREATE TABLE reactions (
-- reaction_id int primary key auto_increment,
-- created_at timestamp,
-- author_id int,
-- stream_id int,
-- value int
-- );

-- insert into reactions (created_at,author_id,stream_id, values ('2011-01-05 00:30:30', 4, 1, 0);
-- insert into reactions (created_at,author_id,stream_id, values ('2013-06-05 00:30:30', 4, 3, 8);
-- insert into reactions (created_at,author_id,stream_id, values ('2012-02-03 00:30:30', 5, 9, 5);

-- CREATE TABLE donations (
-- donation_id int primary key auto_increment,
-- created_at timestamp,
-- stream_id int,
-- donator_id int,
-- amount float
-- );

 -- insert into donations (created_at, stream_id, donator_id, amount ('2011-01-05 00:30:30', 2, 1, 100.55);
 -- insert into donations (created_at, stream_id, donator_id, amount ('2013-06-05 00:30:30', 6, 2, 5.06);
 -- insert into donations (created_at, stream_id, donator_id, amount ('2012-02-03 00:30:30', 8, 3, 20.25);

-- 3)
-- Display data about streams;

-- select
-- t1.title,
-- t2.username
-- from streams t1
-- inner join users t2
-- on t1.author_id = t2.user_id;

-- 4)
-- Display users who have'nt streams;

-- select
-- users.username
-- from users 
-- left join streams
-- where streams.title is null;

