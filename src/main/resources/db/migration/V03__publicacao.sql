CREATE TABLE publicacao(
    id UUID PRIMARY KEY NOT NULL UNIQUE ,
    legendaPublicacao VARCHAR(255) ,
    imagemPublicacao VARCHAR(255) ,
    dataPublicacao DATE NOT NULL ,
    perfil_id UUID ,
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);