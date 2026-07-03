ALTER TABLE usuario ALTER COLUMN tipo_usuario TYPE VARCHAR(20)
USING tipo_usuario::text; -- converte os registro de enum para text, preservando os dados

DROP TYPE tipo_usuario;