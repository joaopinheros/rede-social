CREATE TABLE mensagem(
    id BIGINT PRIMARY KEY NOT NULL UNIQUE ,
    conteudo VARCHAR(255) NOT NULL ,
    emogi VARCHAR(255),
    data_envio DATE NOT NULL ,
    lida BOOLEAN NOT NULL ,
    remetente_id UUID,
    destinatario_id UUID,
    FOREIGN KEY (remetente_id) REFERENCES perfil(id),
    FOREIGN KEY (destinatario_id) REFERENCES perfil(id)
);