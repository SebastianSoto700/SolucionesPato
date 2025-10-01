INSERT INTO usuarios (nombre, apellido, dni, correo, contrasena, rol, estado, fecha_creacion)
VALUES (
    'Nuevo',
    'Usuario',
    '87654321', -- Asegúrate de que este DNI sea único
    'nuevo.usuario@example.com',
    '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG',
    'USER',
    true,
    CURRENT_TIMESTAMP
);