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
-- Table `mydb`.`Tema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tema` (
  `id_Tema` BIGINT NOT NULL AUTO_INCREMENT,
  `hashtag` VARCHAR(45) NULL,
  `assunto` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(200) NULL,
  PRIMARY KEY (`id_Tema`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `id_Usuario` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_Usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Postagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Postagem` (
  `id_Postagem` BIGINT NOT NULL AUTO_INCREMENT,
  `texto` VARCHAR(1000) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `data` DATETIME NOT NULL,
  `foto` VARCHAR(400) NULL,
  `fk_id_tema` BIGINT NOT NULL,
  `fk_id_usuario` BIGINT NOT NULL,
  PRIMARY KEY (`id_Postagem`),
  INDEX `fk_id_tema_idx` (`fk_id_tema` ASC) VISIBLE,
  INDEX `fk_id_usuario_idx` (`fk_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_id_tema`
    FOREIGN KEY (`fk_id_tema`)
    REFERENCES `mydb`.`Tema` (`id_Tema`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_usuario`
    FOREIGN KEY (`fk_id_usuario`)
    REFERENCES `mydb`.`Usuario` (`id_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
