CREATE TABLE IF NOT EXISTS members (
                                     username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(68) NOT NULL,
    enabled SMALLINT NOT NULL DEFAULT 1
    );

CREATE TABLE IF NOT EXISTS roles (
                                           username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES members(username) ON DELETE CASCADE,
    CONSTRAINT authorities_idx_1 UNIQUE (username, authority)
    );

INSERT INTO members (username, password, enabled) VALUES
                                                    ('admin', '{bcrypt}$2a$10$3RF1QKS1PNxFWpvjaZLjBO2H/TFbBc90LUFGE1zsYIrt.dyKpS0hm', 1),
                                                    ('ege', '{bcrypt}$2a$10$xW7WvogL/t6nAlK96B/eiunyco4LHkke50qmqOdlhPHdJQtY4Pv8W', 1),
                                                    ('cem', '{bcrypt}$2a$10$NCGQMNHSCRUP5BNpqwr3Z.hW03batVJcVPa.SKUTkjtr4vIsPQ4lq', 1);

INSERT INTO roles (username, authority) VALUES
                                                  ('ege', 'ROLE_USER'),
                                                  ('cem', 'ROLE_MANAGER'),
                                                  ('cem', 'ROLE_USER'),
                                                  ('admin', 'ROLE_ADMIN'),
('admin', 'ROLE_USER'),
('admin','ROLE_MANAGER');


