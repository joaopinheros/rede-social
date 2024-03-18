CREATE TABLE amigos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    somos_amigos BOOLEAN NOT NULL,
    aceita BOOLEAN NOT NULL,
    remetente_id UUID,
    destinatario_id UUID,
    FOREIGN KEY (remetente_id) REFERENCES perfil(id),
    FOREIGN KEY (destinatario_id) REFERENCES perfil(id)
);
