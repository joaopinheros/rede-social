CREATE TABLE perfil(
    id UUID PRIMARY KEY NOT NULL UNIQUE,
    nome VARCHAR(50) NOT NULL,
    biografia VARCHAR(100) NOT NULL,
    foto VARCHAR(255) NOT NULL,
    usuario_id UUID,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);