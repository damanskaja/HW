-- Social network scheme

CREATE TABLE users (
  user_id serial PRIMARY KEY,
  username varchar(32),
  email varchar(32),
  registration_date timestamp,
  avatar_url varchar(256),
  bio text,
  country varchar(32),
  is_blocked bool
);

CREATE TABLE videos (
 video_id serial PRIMARY KEY,
 user_id int,
 title varchar(256),
 description text,
 upload_date timestamp,
 views int,
 thumbnail_url varchar(256),
 video_url varchar(256),
 duration int,
 is_blocked bool
);

CREATE TABLE comments (
  comment_id serial PRIMARY KEY,
  video_id int,
  user_id int,
  comment_date timestamp,
  parent_comment_id int,
  is_deleted bool
);

CREATE TABLE likes (
  like_id serial PRIMARY KEY,
  user_id int,
  video_id int,
  liked_date timestamp,
  is_deleted bool
);

CREATE TABLE tags (
  tag_id serial PRIMARY KEY,
  tag_name varchar(32),
  video_id int,
  tagged_date timestamp,
  is_deleted bool
);
