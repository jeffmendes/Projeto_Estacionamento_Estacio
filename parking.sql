CREATE DATABASE parking;

USE parking;

-- -----------------------------------------------------
-- Table `UsuarioOperacional`
-- -----------------------------------------------------
CREATE TABLE UsuarioOperacional(
  ID_usuario INT AUTO_INCREMENT,
  Nome VARCHAR(45) NOT NULL,
  Telefone CHAR(13) NOT NULL,
  Endereco VARCHAR(250) NOT NULL,
  NivelDeAcesso VARCHAR(13) NOT NULL,
  PRIMARY KEY (ID_usuario)
);
SELECT * FROM UsuarioOperacional;
-- -----------------------------------------------------
-- Table `Valores`
-- -----------------------------------------------------
CREATE TABLE Valores(
  ID_Valor INT AUTO_INCREMENT,
  ValorAvulso DECIMAL NOT NULL,
  ValorMensalidade_A DECIMAL NOT NULL,
  ValorMensalidade_B DECIMAL NOT NULL,
  ValorMensalidade_C DECIMAL NOT NULL,
  PRIMARY KEY (ID_Valor)
);
SELECT * FROM Valores;

INSERT INTO Valores (ValorAvulso,  ValorMensalidade_A, ValorMensalidade_B,  ValorMensalidade_C) 	VALUE (12.00, 110.00, 130.00, 150.00);
-- -----------------------------------------------------
-- Table `Veiculo`
-- -----------------------------------------------------
CREATE TABLE Veiculo(
  Placa VARCHAR(8) NOT NULL,
  Modelo VARCHAR(45) NOT NULL,
  FK_ID_Cliente INT NULL,
  PRIMARY KEY (Placa),
  FOREIGN KEY (FK_ID_Cliente) 
  REFERENCES Cliente (ID_Cliente)
);

SELECT * FROM Veiculo;

INSERT INTO Veiculo (Placa, Modelo) VALUE ('XYZ1234', 'Ford KA');

-- -----------------------------------------------------
-- Table `Cliente`
-- -----------------------------------------------------
CREATE TABLE Cliente(
  ID_Cliente INT  AUTO_INCREMENT,
  Nome VARCHAR(45) NOT NULL,
  Telefone VARCHAR(13) NOT NULL,
  Endereco VARCHAR(100) NOT NULL,
  FK_ID_Valor INT NOT NULL,
  Placa VARCHAR (10) NOT NULL,
  Modelo VARCHAR(45) NOT NULL,
  PRIMARY KEY (ID_Cliente),
    FOREIGN KEY (FK_ID_Valor)
    REFERENCES Valores (ID_Valor), 
	FOREIGN KEY (Placa)
    REFERENCES Veiculo (Placa)    
);

SELECT * FROM Cliente;
-- -----------------------------------------------------
-- Table `ControleDeAcesso`
-- -----------------------------------------------------
CREATE TABLE ControleDeAcesso(
  ID_Acesso INT AUTO_INCREMENT,
  HoraEntrada DATETIME NOT NULL,
 HoraSaida DATETIME NULL,
  FK_ID_Usuario INT NULL,
  FK_ID_Valor INT NULL,
  ID_Placa VARCHAR (10) NOT NULL,
  PRIMARY KEY (ID_Acesso),
    FOREIGN KEY (FK_ID_Usuario)
    REFERENCES UsuarioOperacional (ID_usuario),
    FOREIGN KEY (FK_ID_Valor)
    REFERENCES Valores (ID_Valor),
    FOREIGN KEY (ID_Placa)
    REFERENCES Veiculo (Placa)
);

SELECT * FROM ControleDeAcesso;
ALTER TABLE ControleDeAcesso ADD Valores DECIMAL NOT NULL;
ALTER TABLE ControleDeAcesso ADD  Modelo VARCHAR(45) NOT NULL;
/*INSERT INTO  ControleDeAcesso (HoraEntrada, ID_Placa) VALUE (NOW(), NOW(), (SELECT Placa FROM Veiculo));*/
/*INSERT INTO  ControleDeAcesso (HoraEntrada, ID_Placa) VALUE (NOW(),  (SELECT Placa FROM Veiculo));*/
/*INSERT INTO  ControleDeAcesso (HoraEntrada, ID_Placa, Valores) VALUE (NOW(), (SELECT Placa FROM Veiculo) ,(SELECT ValorAvulso FROM Valores));*/
INSERT INTO  ControleDeAcesso (HoraEntrada, ID_Placa, Valores, Modelo) VALUE (NOW(),
	(SELECT Placa FROM Veiculo),
    (SELECT ValorAvulso FROM Valores), 
    (SELECT Modelo FROM Veiculo)
);

/*Verificar a possibilidade de adicionar em multiplas tabelas, exemplo  ControleDeAcesso e Veiculo*/




