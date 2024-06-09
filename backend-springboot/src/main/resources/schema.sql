CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL,
    email VARCHAR(50),
    locked TINYINT NOT NULL,
    disabled TINYINT NOT NULL
);

CREATE TABLE IF NOT EXISTS user_role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(20) NOT NULL,
    granted_date DATETIME NOT NULL,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES usuario(id)
);

CREATE TABLE IF NOT EXISTS objeto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT,
    precio DECIMAL(10,2),
    fecha_creacion DATETIME
);
