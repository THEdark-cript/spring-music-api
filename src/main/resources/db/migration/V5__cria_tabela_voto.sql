CREATE TABLE voto (
    id SERIAL PRIMARY KEY,
    id_espectador INT NOT NULL,
    id_artista INT NOT NULL,
    id_evento INT NOT NULL,
    data_voto TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_espectador) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (id_artista) REFERENCES artista(id) ON DELETE CASCADE,
    FOREIGN KEY (id_evento) REFERENCES evento(id) ON DELETE CASCADE,
    UNIQUE (id_espectador, id_artista, id_evento)
);