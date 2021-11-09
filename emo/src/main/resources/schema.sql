DROP TABLE IF EXISTS Reaction_Notice;
DROP TABLE IF EXISTS friend_Notice;
DROP TABLE IF EXISTS Friend;
DROP TABLE IF EXISTS Feedback;
DROP TABLE IF EXISTS Memo;
DROP TABLE IF EXISTS Member;

CREATE TABLE Member (
    id      INT          PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(100),
    email   VARCHAR(255) NOT NULL,
    name  VARCHAR(50)  NOT NULL,
    nickname VARCHAR(100) NOT NULL,
    profile_photo_url VARCHAR(999),
    password text NOT NULL,
    role VARCHAR(20),
    date TIMESTAMP  DEFAULT NOW()
);

CREATE TABLE Memo (
    id      INT          PRIMARY KEY AUTO_INCREMENT,
    member_id INT,
    emotion   VARCHAR(50) NOT NULL,
    emotion_scope  TINYINT(1)  NOT NULL,
    detail text,
    detail_scope TINYINT(1),
    date TIMESTAMP  DEFAULT NOW(),
    FOREIGN KEY (member_id)
    REFERENCES Member(id) On DELETE CASCADE
);

CREATE TABLE Feedback (
    id        INT          PRIMARY KEY AUTO_INCREMENT,
    member_id INT,
    memo_id   INT,
    reaction  VARCHAR(100) ,
    date TIMESTAMP  DEFAULT NOW(),
    status    TINYINT(1) DEFAULT true,
    FOREIGN KEY (member_id)
        REFERENCES Member(id) On DELETE CASCADE,
    FOREIGN KEY (memo_id)
        REFERENCES Memo(id) On DELETE CASCADE
);

CREATE TABLE Friend (
    id      INT          PRIMARY KEY AUTO_INCREMENT,
    me_id   INT,
    you_id  INT,
    FOREIGN KEY (me_id)
        REFERENCES Member(id) On DELETE CASCADE,
    FOREIGN KEY (you_id)
        REFERENCES Member(id) On DELETE CASCADE
);

CREATE TABLE Friend_Notice (
    id      INT          PRIMARY KEY AUTO_INCREMENT,
    receive_id INT,
    send_id   INT,
    type  VARCHAR(20) NOT NULL,
    status TINYINT(1) DEFAULT false,
    date TIMESTAMP  DEFAULT NOW(),
    FOREIGN KEY (receive_id)
        REFERENCES Member(id) On DELETE CASCADE,
    FOREIGN KEY (send_id)
        REFERENCES Member(id) On DELETE CASCADE
);

CREATE TABLE Reaction_Notice (
    id      INT          PRIMARY KEY AUTO_INCREMENT,
    receive_id INT,
    send_id   INT,
    reaction_id INT,
    type  VARCHAR(20) NOT NULL,
    status TINYINT(1) DEFAULT false,
    date TIMESTAMP  DEFAULT NOW(),
    FOREIGN KEY (reaction_id)
        REFERENCES Feedback(id) On DELETE CASCADE,
    FOREIGN KEY (receive_id)
        REFERENCES Member(id) On DELETE CASCADE,
    FOREIGN KEY (send_id)
        REFERENCES Member(id) On DELETE CASCADE
);
--CREATE TABLE reaction_status (
--    id INT PRIMARY KEY AUTO_INCREMENT,
--    reaction_id INT,
--    memo_id INT,
--    member_id INT,
--    status TINYINT(10) DEFAULT 1,
--    FOREIGN KEY (reaction_id)
--            REFERENCES feedback(id) ON DELETE CASCADE,
--    FOREIGN KEY (member_id)
--        REFERENCES member(id) ON DELETE CASCADE,
--    FOREIGN KEY (memo_id)
--        REFERENCES memo(id) ON DELETE CASCADE
--);


