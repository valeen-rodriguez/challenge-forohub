CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL,
    clave VARCHAR(300) NOT NULL,
    perfil_id BIGINT,
    PRIMARY KEY (id),
    UNIQUE KEY (login),
    FOREIGN KEY (perfil_id) REFERENCES perfiles(id)
);

CREATE TABLE perfiles (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);