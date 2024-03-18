CREATE TABLE notificacao (
    id BIGINT PRIMARY KEY NOT NULL UNIQUE ,
    mensagem VARCHAR(255) NOT NULL,
    tipo_evento VARCHAR(30) NOT NULL,
    lida BOOLEAN DEFAULT FALSE,
    data_hora DATE NOT NULL,
    perfil_id UUID,
    publicacao_id UUID,
    comentario_id UUID,
    like_id UUID,
    share_id UUID,
    amizade_id BIGINT,
    FOREIGN KEY (perfil_id) REFERENCES perfil(id),
    FOREIGN KEY (publicacao_id) REFERENCES publicacao(id),
    FOREIGN KEY (comentario_id) REFERENCES comentario(id),
    FOREIGN KEY (like_id) REFERENCES like(id),
    FOREIGN KEY (share_id) REFERENCES share(id),
    FOREIGN KEY (amizade_id) REFERENCES amizade(id)
);
