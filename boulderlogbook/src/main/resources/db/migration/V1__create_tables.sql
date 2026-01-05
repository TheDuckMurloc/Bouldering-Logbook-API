CREATE TABLE style_tag (
  tag_id BIGINT PRIMARY KEY,
  name TEXT NOT NULL,
  description TEXT
);

CREATE TABLE location (
  location_id BIGINT PRIMARY KEY,
  name TEXT NOT NULL,
  type TEXT,
  region TEXT,
  address TEXT,
  map_url TEXT
);

CREATE TABLE app_user (
  user_id BIGINT PRIMARY KEY,
  name TEXT NOT NULL,
  email TEXT NOT NULL,
  password_hash TEXT NOT NULL,
  join_date TIMESTAMP NOT NULL,
  profile_photo TEXT
);

CREATE TABLE climb (
  climb_id BIGINT PRIMARY KEY,
  location_id BIGINT NOT NULL REFERENCES location(location_id),
  date TIMESTAMP NOT NULL,
  grade TEXT NOT NULL,
  photo TEXT
);

CREATE TABLE user_climb (
  user_id BIGINT NOT NULL REFERENCES app_user(user_id),
  climb_id BIGINT NOT NULL REFERENCES climb(climb_id),
  attempts INT,
  ascent_type TEXT,
  notes TEXT,
  duration TEXT,
  logged_at TIMESTAMP,
  PRIMARY KEY (user_id, climb_id)
);

-- NOTE: The following CSVs were empty/unparseable (no headers), so no tables/inserts were generated:
-- dbo_ClimbStyleTag.csv, dbo_Goal.csv, dbo_Session.csv, dbo_SessionClimb.csv, dbo_Statistic.csv
