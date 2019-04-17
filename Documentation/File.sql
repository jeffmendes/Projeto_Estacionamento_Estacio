-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`UsuarioOperacional`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`UsuarioOperacional` (
  `ID_usuario` INT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Telefone` CHAR(13) NOT NULL,
  `Endereco` VARCHAR(250) NOT NULL,
  `NivelDeAcesso` VARCHAR(13) NOT NULL,
  PRIMARY KEY (`ID_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Valores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Valores` (
  `ID_Valor` INT NULL AUTO_INCREMENT,
  `ValorAvulso` DECIMAL NOT NULL,
  `ValorMensalidade_A` DECIMAL NOT NULL,
  `ValorMensalidade_B` DECIMAL NOT NULL,
  `ValorMensalidade_C` DECIMAL NOT NULL,
  PRIMARY KEY (`ID_Valor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `ID_Cliente` INT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Telefone` VARCHAR(13) NOT NULL,
  `Endereco` VARCHAR(100) NOT NULL,
  `FK_ID_Valor` INT NULL,
  PRIMARY KEY (`ID_Cliente`),
  INDEX `FK_ID_Valor_idx` (`FK_ID_Valor` ASC) VISIBLE,
  CONSTRAINT `FK_ID_Valor`
    FOREIGN KEY (`FK_ID_Valor`)
    REFERENCES `mydb`.`Valores` (`ID_Valor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Veiculo` (
  `ID_Veiculo` INT NULL AUTO_INCREMENT,
  `Placa` VARCHAR(8) NOT NULL,
  `Modelo` VARCHAR(45) NOT NULL,
  `FK_ID_Cliente` INT NULL,
  PRIMARY KEY (`ID_Veiculo`),
  INDEX `FK_ID_Cliente_idx` (`FK_ID_Cliente` ASC) VISIBLE,
  CONSTRAINT `FK_ID_Cliente`
    FOREIGN KEY (`FK_ID_Cliente`)
    REFERENCES `mydb`.`Cliente` (`ID_Cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ControleDeAcesso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ControleDeAcesso` (
  `ID_Acesso` INT NULL AUTO_INCREMENT,
  `HoraSaida` DATETIME NOT NULL,
  `HoraEntrada` DATETIME NOT NULL,
  `FK_ID_Usuario` INT NULL,
  `FK_ID_Valor` INT NULL,
  `FK_ID_Veiculo` INT NULL,
  PRIMARY KEY (`ID_Acesso`),
  INDEX `FK_ID_Usuario_idx` (`FK_ID_Usuario` ASC) VISIBLE,
  INDEX `FK_ID_Valor_idx` (`FK_ID_Valor` ASC) VISIBLE,
  INDEX `FK_ID_Veiculo_idx` (`FK_ID_Veiculo` ASC) VISIBLE,
  CONSTRAINT `FK_ID_Usuario`
    FOREIGN KEY (`FK_ID_Usuario`)
    REFERENCES `mydb`.`UsuarioOperacional` (`ID_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ID_Valor`
    FOREIGN KEY (`FK_ID_Valor`)
    REFERENCES `mydb`.`Valores` (`ID_Valor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ID_Veiculo`
    FOREIGN KEY (`FK_ID_Veiculo`)
    REFERENCES `mydb`.`Veiculo` (`ID_Veiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
