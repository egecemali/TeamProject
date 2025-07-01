

CREATE TABLE IF NOT EXISTS Cups (
id BIGSERIAL PRIMARY KEY,
cup_name VARCHAR(100) NOT NULL,
country VARCHAR(100) NOT NULL

);
CREATE TABLE IF NOT EXISTS PlayerInfo (
                                          id BIGSERIAL PRIMARY KEY,
                                          player_id BIGINT NOT NULL ,
                                          cup_id BIGINT NOT NULL,

                                          count INT NOT NULL,
                                          CONSTRAINT fk_player
                                              FOREIGN KEY (player_id)
                                                  REFERENCES Players(id)
                                                  ON DELETE CASCADE,

                                          CONSTRAINT fk_cups
                                              FOREIGN KEY (cup_id)
                                                  REFERENCES Cups(id)
                                                  ON DELETE CASCADE


);
