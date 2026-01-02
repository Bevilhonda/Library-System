create TABLE IF NOT EXISTS autor (
    id_autor           INT         NOT NULL AUTO_INCREMENT,
    nome               VARCHAR(50) NOT NULL,
    sobrenome          VARCHAR(50) NOT NULL,
    data_nascimento    DATE    NOT NULL,
    PRIMARY KEY        (id_autor)
);