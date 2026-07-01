CREATE TYPE tipo_usuario AS ENUM ('espectador', 'artista', 'admin');

CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome_completo VARCHAR(150) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo_usuario tipo_usuario NOT NULL
);