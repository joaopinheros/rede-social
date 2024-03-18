CREATE TABLE post_like (
    id UUID PRIMARY KEY NOT NULL UNIQUE,
    curtida BOOLEAN NOT NULL,
    publicacao_id UUID,
    perfil_id UUID,
    comentario_id UUID,
    FOREIGN KEY (publicacao_id) REFERENCES publicacao(id),
    FOREIGN KEY (perfil_id) REFERENCES perfil(id),
    FOREIGN KEY (comentario_id) REFERENCES comentario(id),
);
