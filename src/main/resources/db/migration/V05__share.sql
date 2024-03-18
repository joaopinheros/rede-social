CREATE TABLE share (
    id UUID PRIMARY KEY NOT NULL UNIQUE,
    compartilhar BOOLEAN NOT NULL,
    legenda_compartilhacao VARCHAR(255),
    imagem_compartilhacao VARCHAR(255),
    publicacao_id UUID,
    perfil_id UUID,
    comentario_id
    FOREIGN KEY (publicacao_id) REFERENCES publicacao(id),
    FOREIGN KEY (perfil_id) REFERENCES perfil(id),
    FOREIGN KEY (comentario_id) REFERENCES comentario(id)

);
