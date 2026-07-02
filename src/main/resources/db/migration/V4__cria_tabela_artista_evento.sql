CREATE TABLE artista_evento (
    id SERIAL PRIMARY KEY,
    id_artista INT NOT NULL,
    id_evento INT NOT NULL,
    FOREIGN KEY (id_artista) REFERENCES artista(id) ON DELETE CASCADE,
    FOREIGN KEY (id_evento) REFERENCES evento(id) ON DELETE CASCADE
);