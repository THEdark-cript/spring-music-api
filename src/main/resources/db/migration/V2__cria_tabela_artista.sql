CREATE TABLE artista (
    id SERIAL PRIMARY KEY,
    nome_grupo VARCHAR(150) NOT NULL,
    descricao_apresentacao VARCHAR NOT NULL,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE
);