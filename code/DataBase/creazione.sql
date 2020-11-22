
CREATE DATABASE MyCare; 

USE MyCare;


CREATE TABLE iva(
    statoIva VARCHAR(10) not null default '',
    valore DECIMAL(5,2),
    primary key(statoIva)
);

CREATE TABLE utente(
    codiceFiscale VARCHAR(16) not null default '', 
    username VARCHAR(30) not null default '',
    email VARCHAR(30),
    pass VARCHAR(20),
    nomeUtente VARCHAR(30),
    cognomeUtente VARCHAR(30),
    dataNascita DATE,
    indirizzo VARCHAR(50),
    ruolo VARCHAR(20),
    pathNameFotoU VARCHAR(500),
    primary key(username)
);

CREATE TABLE prodotto(
    idProdotto int not null default 0,
    codProdotto VARCHAR(13) not null default '',
    stato VARCHAR(10) not null default '',
    nomeProdotto VARCHAR(30),
    descrizione VARCHAR(100),
    prezzoProdotto DECIMAL(5,2),
    categoria VARCHAR(30),
    pathNameFotoP VARCHAR(50),
    quantitaMagazzino int,
    primary key(idProdotto,codProdotto),
    FOREIGN KEY(stato) REFERENCES iva(statoIva) 
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

  
CREATE TABLE feedback(

    codiceFeedback int AUTO_INCREMENT,
    stelle int,
    dataFeedback DATE,
    testo VARCHAR(100),
    usern VARCHAR(30) not null default '',
    idPro int not null default 0,
    codPro VARCHAR(13) not null default '',
    
    primary key(codiceFeedback),
    FOREIGN KEY(usern) REFERENCES utente(username)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY(idPro,codPro) REFERENCES prodotto(idProdotto,codProdotto)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE estremi(

    codiceCarta VARCHAR(20) not null default '',
    usern VARCHAR(30) not null default '',
    Intestatario VARCHAR(60),
    scadenza VARCHAR(6),
    cvv VARCHAR(4),
    saldo DECIMAL (5,2),
    primary key(codiceCarta),
    FOREIGN KEY(usern) REFERENCES utente(username)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);





CREATE TABLE ordine(
    codiceOrdine VARCHAR(150) not null default '',
    usern VARCHAR(30) not null default '',
    descrizione VARCHAR(100),
    dataOrdine DATE,
    primary key (codiceOrdine,usern),
    FOREIGN KEY(usern) REFERENCES utente(username)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE voceOrdine(
    codiceVoce int not null  AUTO_INCREMENT,
    quantita int,
    prezzoAcquisto FLOAT(2),
    codiceOrd VARCHAR(150) not null,
    idPro int not null default 0,
    codPro VARCHAR(13) not null default '',
    primary key(codiceVoce,codiceOrd,idPro,codPro),
    FOREIGN KEY (codiceOrd) REFERENCES ordine(codiceOrdine)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY(idPro,codPro) REFERENCES prodotto(idProdotto,codProdotto)
    ON UPDATE CASCADE
    ON DELETE CASCADE
    
);











