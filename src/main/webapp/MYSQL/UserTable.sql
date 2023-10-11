CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(16)  NOT NULL,
                       password VARCHAR(16) NOT NULL,
                       firstName NVARCHAR(16) NOT NULL,
                       lastName NVARCHAR(30) NOT NULL,
                       role VARCHAR(10) NOT NULL,
                       created_at DATE,
                       CHECK (LENGTH(username) >= 6 AND LENGTH(username) <= 16),
                        CHECK (LENGTH(password) >= 8 AND LENGTH(password) <= 16)
);

INSERT INTO users (username, password, firstName, lastName, role, created_at)
VALUES
    ('quancm0406', '12345678', 'Cao', 'Minh Quan', 'admin', CURRENT_DATE),
    ('duynn2007', '12345678', 'Nguyen', 'Ngoc Duy', 'student', CURRENT_DATE);



drop table users