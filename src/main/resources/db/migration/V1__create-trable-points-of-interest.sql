CREATE TABLE points_of_interest (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    x_coordinate INT NOT NULL,
    y_coordinate INT NOT NULL,
    created_at DATETIME,
    active TINYINT(1) NOT NULL
);
