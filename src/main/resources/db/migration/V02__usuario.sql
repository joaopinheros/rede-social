CREATE TABLE usuario(
    id UUID PRIMARY KEY NOT NULL UNIQUE ,
    email VARCHAR(50) NOT NULL UNIQUE ,
    senha VARCHAR(20) NOT NULL,
    role VARCHAR(10) NOT NULL
);