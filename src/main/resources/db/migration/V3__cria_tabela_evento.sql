CREATE TABLE evento (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    descricao VARCHAR NOT NULL,
    estado VARCHAR(2) NOT NULL,
    cidade VARCHAR(150) NOT NULL,
    logradouro VARCHAR NOT NULL,
    bairro VARCHAR NOT NULL,
    data_evento TIMESTAMP NOT NULL,
    prazo_votacao DATE NOT NULL
);