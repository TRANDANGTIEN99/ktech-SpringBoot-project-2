
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


INSERT INTO Board (name) VALUES ('hi');
INSERT INTO Board (name) VALUES ('개발 게시판');
INSERT INTO Board (name) VALUES ('일상 게시판');
INSERT INTO Board (name) VALUES ('사건사고 게시판');