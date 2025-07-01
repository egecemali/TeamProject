CREATE TABLE IF NOT EXISTS Teams (
    id bigserial NOT NULL PRIMARY KEY,
    name varchar(100) NOT NULL,
    stadium varchar(100) NOT NULL,
    founded_year int NOT NULL
);

CREATE TABLE IF NOT EXISTS Players (
   id bigserial NOT NULL PRIMARY KEY,
   name varchar(100) NOT NULL,
    surname varchar(100) NOT NULL,
    age int NOT NULL,
    nationality varchar(255) NOT NULL,
    market_value int NOT NULL,
    team_id bigint,
         CONSTRAINT fk_team
           FOREIGN KEY (team_id)
            REFERENCES Teams(id)
              ON DELETE SET NULL
);
