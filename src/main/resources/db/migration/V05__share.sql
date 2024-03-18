CREATE TABLE compartilhamento (
    id UUID PRIMARY KEY NOT NULL UNIQUE,
    compartilhar BOOLEAN NOT NULL,
    legenda_compartilhacao VARCHAR(255),
    imagem_compartilhacao VARCHAR(255),
    publicacao_id UUID,
    perfil_id UUID,
    FOREIGN KEY (publicacao_id) REFERENCES publicacao(id),
FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);
