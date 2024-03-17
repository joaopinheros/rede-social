CREATE TABLE compartilhamento (
    id UUID PRIMARY KEY NOT NULL UNIQUE,
    curtida BOOLEAN NOT NULL,
    publicacao_id UUID,
    perfil_id UUID,
    FOREIGN KEY (publicacao_id) REFERENCES publicacao(id),
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);
