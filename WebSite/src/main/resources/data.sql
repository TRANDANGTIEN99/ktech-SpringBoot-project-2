DELETE FROM Article;
DELETE FROM Board;

CREATE TABLE IF NOT EXISTS Board (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL
);


CREATE TABLE IF NOT EXISTS Article (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    content TEXT NOT NULL,
    password TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    board_id INTEGER NOT NULL,
    FOREIGN KEY (board_id) REFERENCES Board(id)
);

CREATE TABLE IF NOT EXISTS Comment (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    content TEXT NOT NULL,
    password TEXT NOT NULL,
    article_id INTEGER NOT NULL,
    FOREIGN KEY (article_id) REFERENCES Article(id)
);



INSERT INTO Board (name) VALUES ('Free Board');
INSERT INTO Board (name) VALUES ('Development Board');
INSERT INTO Board (name) VALUES ('Daily Life Board');
INSERT INTO Board (name) VALUES ('Incident Board');