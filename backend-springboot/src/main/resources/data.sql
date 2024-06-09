-- USUARIO ADMIN
INSERT INTO usuario (username, password, email, locked, disabled)
SELECT 'admin', '$2y$10$FgwVgyMFTWq7UKpaWUCsHuk2jLfmfWO88pvEMTMlB0Iko24K35kwC', 'admin@example.com', 0, 0
WHERE NOT EXISTS (SELECT 1 FROM usuario WHERE username = 'admin');
-- ROL DE ADMIN
INSERT INTO user_role (role, granted_date, user_id)
SELECT 'ADMIN', NOW(), (SELECT id FROM usuario WHERE username = 'admin')
WHERE NOT EXISTS (SELECT 1 FROM user_role WHERE role = 'ADMIN' AND user_id = (SELECT id FROM usuario WHERE username = 'admin'));
-- DATOS DE PRUEBA ENTIDAD
INSERT INTO objeto (nombre, descripcion, precio, fecha_creacion) 
SELECT 'Objeto 1', 'Descripcion del Objeto 1', 10.50, '2024-06-01 10:00:00' 
WHERE NOT EXISTS (SELECT 1 FROM objeto WHERE nombre = 'Objeto 1' AND descripcion = 'Descripcion del Objeto 1');
INSERT INTO objeto (nombre, descripcion, precio, fecha_creacion) 
SELECT 'Objeto 2', 'Descripcion del Objeto 2', 20.75, '2024-06-02 11:00:00' 
WHERE NOT EXISTS (SELECT 1 FROM objeto WHERE nombre = 'Objeto 2' AND descripcion = 'Descripcion del Objeto 2');
INSERT INTO objeto (nombre, descripcion, precio, fecha_creacion) 
SELECT 'Objeto 3', 'Descripcion del Objeto 3', 30.00, '2024-06-03 12:00:00' 
WHERE NOT EXISTS (SELECT 1 FROM objeto WHERE nombre = 'Objeto 3' AND descripcion = 'Descripcion del Objeto 3');
INSERT INTO objeto (nombre, descripcion, precio, fecha_creacion) 
SELECT 'Objeto 4', 'Descripcion del Objeto 4', 40.25, '2024-06-04 13:00:00' 
WHERE NOT EXISTS (SELECT 1 FROM objeto WHERE nombre = 'Objeto 4' AND descripcion = 'Descripcion del Objeto 4');
INSERT INTO objeto (nombre, descripcion, precio, fecha_creacion) 
SELECT 'Objeto 5', 'Descripcion del Objeto 5', 50.50, '2024-06-05 14:00:00' 
WHERE NOT EXISTS (SELECT 1 FROM objeto WHERE nombre = 'Objeto 5' AND descripcion = 'Descripcion del Objeto 5');
INSERT INTO objeto (nombre, descripcion, precio, fecha_creacion) 
SELECT 'Objeto 6', 'Descripcion del Objeto 6', 60.75, '2024-06-06 15:00:00' 
WHERE NOT EXISTS (SELECT 1 FROM objeto WHERE nombre = 'Objeto 6' AND descripcion = 'Descripcion del Objeto 6');
INSERT INTO objeto (nombre, descripcion, precio, fecha_creacion) 
SELECT 'Objeto 7', 'Descripcion del Objeto 7', 70.00, '2024-06-07 16:00:00' 
WHERE NOT EXISTS (SELECT 1 FROM objeto WHERE nombre = 'Objeto 7' AND descripcion = 'Descripcion del Objeto 7');
INSERT INTO objeto (nombre, descripcion, precio, fecha_creacion) 
SELECT 'Objeto 8', 'Descripcion del Objeto 8', 80.25, '2024-06-08 17:00:00' 
WHERE NOT EXISTS (SELECT 1 FROM objeto WHERE nombre = 'Objeto 8' AND descripcion = 'Descripcion del Objeto 8');
INSERT INTO objeto (nombre, descripcion, precio, fecha_creacion) 
SELECT 'Objeto 9', 'Descripcion del Objeto 9', 90.50, '2024-06-09 18:00:00' 
WHERE NOT EXISTS (SELECT 1 FROM objeto WHERE nombre = 'Objeto 9' AND descripcion = 'Descripcion del Objeto 9');
INSERT INTO objeto (nombre, descripcion, precio, fecha_creacion) 
SELECT 'Objeto 10', 'Descripcion del Objeto 10', 100.75, '2024-06-10 19:00:00' 
WHERE NOT EXISTS (SELECT 1 FROM objeto WHERE nombre = 'Objeto 10' AND descripcion = 'Descripcion del Objeto 10');
