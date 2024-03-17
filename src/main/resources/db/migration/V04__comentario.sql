CREATE TABLE comentario(
    id UUID PRIMARY KEY NOT NULL UNIQUE ,
    legendaComentario VARCHAR(255),
    imagemComentario VARCHAR(255),
    dataComentario DATE NOT NULL,
    publicacao_id UUID UNIQUE ,
    perfil_id UUID UNIQUE ,
    FOREIGN KEY (publicacao_id) REFERENCES publicacao(id)
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);