CREATE DATABASE workwave;
CREATE USER 'workwave'@'localhost' IDENTIFIED BY 'WorkWave123';
GRANT ALL PRIVILEGES ON workwave.* TO 'workwave'@'localhost';
FLUSH PRIVILEGES;