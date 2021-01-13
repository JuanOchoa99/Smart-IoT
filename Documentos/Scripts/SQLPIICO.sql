-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ingusbbo_piico
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ingusbbo_piico
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ingusbbo_piico` DEFAULT CHARACTER SET utf8 ;
USE `ingusbbo_piico` ;

-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`usuario` (
  `id` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(60) NOT NULL,
  `apellidos` VARCHAR(60) NOT NULL,
  `pass` VARCHAR(220) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`puerta_de_enlace`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`puerta_de_enlace` (
  `id` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(80) NOT NULL,
  `estado` TINYINT NOT NULL,
  `direccion_logica` VARCHAR(45) NOT NULL,
  `puerto_de_servicio` VARCHAR(10) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_puerta_de_enlace_usuario1_idx` (`usuario` ASC) ,
  CONSTRAINT `fk_puerta_de_enlace_usuario1`
    FOREIGN KEY (`usuario`)
    REFERENCES `ingusbbo_piico`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`nodo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`nodo` (
  `id` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(80) NOT NULL,
  `estado` TINYINT NOT NULL,
  `protocolo_comunicacion` VARCHAR(45) NOT NULL,
  `puerta_de_enlace` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_nodo_puerta_de_enlace_idx` (`puerta_de_enlace` ASC) ,
  CONSTRAINT `fk_nodo_puerta_de_enlace`
    FOREIGN KEY (`puerta_de_enlace`)
    REFERENCES `ingusbbo_piico`.`puerta_de_enlace` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`sensor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`sensor` (
  `id` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(80) NOT NULL,
  `estado` TINYINT NOT NULL,
  `tipo` VARCHAR(80) NOT NULL,
  `magnitud` VARCHAR(50) NOT NULL,
  `frecuencia` INT NOT NULL,
  `nodo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sensor_nodo_idx` (`nodo` ASC) ,
  CONSTRAINT `fk_sensor_nodo`
    FOREIGN KEY (`nodo`)
    REFERENCES `ingusbbo_piico`.`nodo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`actuador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`actuador` (
  `id` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `estado` TINYINT NOT NULL,
  `tipo` VARCHAR(80) NOT NULL,
  `nodo` VARCHAR(45) NOT NULL,
  `sensor` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_actuador_nodo_idx` (`nodo` ASC) ,
  INDEX `fk_actuador_sensor_idx` (`sensor` ASC) ,
  CONSTRAINT `fk_actuador_nodo`
    FOREIGN KEY (`nodo`)
    REFERENCES `ingusbbo_piico`.`nodo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actuador_sensor`
    FOREIGN KEY (`sensor`)
    REFERENCES `ingusbbo_piico`.`sensor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`log` (
  `id` VARCHAR(45) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `mensaje` LONGTEXT NOT NULL,
  `estado` TINYINT NOT NULL,
  `puerta_de_enlace` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_mensajes_puerta_de_enlace_idx` (`puerta_de_enlace` ASC) ,
  CONSTRAINT `fk_mensajes_puerta_enlace`
    FOREIGN KEY (`puerta_de_enlace`)
    REFERENCES `ingusbbo_piico`.`puerta_de_enlace` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`rol` (
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nombre`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`orden` (
  `id` VARCHAR(45) NOT NULL,
  `accion` LONGTEXT NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`orden_actuador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`orden_actuador` (
  `id` VARCHAR(45) NOT NULL,
  `actuador` VARCHAR(45) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `confirmacion` TINYINT NOT NULL,
  PRIMARY KEY (`id`, `actuador`),
  INDEX `fk_orden_actuador_actuador_idx` (`actuador` ASC) ,
  INDEX `fk_orden_actuador_orden_idx` (`id` ASC) ,
  CONSTRAINT `fk_orden_actuador_orden`
    FOREIGN KEY (`id`)
    REFERENCES `ingusbbo_piico`.`orden` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_actuador_actuador`
    FOREIGN KEY (`actuador`)
    REFERENCES `ingusbbo_piico`.`actuador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`auth`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`auth` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(80) NOT NULL,
  `pass` VARCHAR(512) NOT NULL,
  `topic` VARCHAR(45) NOT NULL,
  `puerta_de_enlace` VARCHAR(45) NOT NULL,
  `puerto` VARCHAR(45) NULL,
  `qos` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_auth_puerta_de_enlace_idx` (`puerta_de_enlace` ASC) ,
  CONSTRAINT `fk_auth_puerta_de_enlace`
    FOREIGN KEY (`puerta_de_enlace`)
    REFERENCES `ingusbbo_piico`.`puerta_de_enlace` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`rol_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`rol_usuario` (
  `rombre` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`rombre`, `usuario`),
  INDEX `fk_rol_usuario_rol1_idx` (`rombre` ASC) ,
  INDEX `fk_rol_usuario_usuario1_idx` (`usuario` ASC) ,
  CONSTRAINT `fk_rol_usuario_rol1`
    FOREIGN KEY (`rombre`)
    REFERENCES `ingusbbo_piico`.`rol` (`nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol_usuario_usuario1`
    FOREIGN KEY (`usuario`)
    REFERENCES `ingusbbo_piico`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`protocolo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`protocolo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `estandar` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`puerta_de_enlace_protocolo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`puerta_de_enlace_protocolo` (
  `puerta_de_enlace` VARCHAR(45) NOT NULL,
  `protocolo` INT NOT NULL,
  PRIMARY KEY (`puerta_de_enlace`, `protocolo`),
  INDEX `fk_puerta_de_enlace_protocolo_protocolo1_idx` (`protocolo` ASC) ,
  INDEX `fk_puerta_de_enlace_protocolo_puerta_de_enlace1_idx` (`puerta_de_enlace` ASC) ,
  CONSTRAINT `fk_puerta_de_enlace_protocolo_puerta_de_enlace1`
    FOREIGN KEY (`puerta_de_enlace`)
    REFERENCES `ingusbbo_piico`.`puerta_de_enlace` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_puerta_de_enlace_protocolo_protocolo1`
    FOREIGN KEY (`protocolo`)
    REFERENCES `ingusbbo_piico`.`protocolo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`nodo_protocolo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`nodo_protocolo` (
  `nodo` VARCHAR(45) NOT NULL,
  `protocolo` INT NOT NULL,
  PRIMARY KEY (`nodo`, `protocolo`),
  INDEX `fk_nodo_protocolo_Protocolo1_idx` (`protocolo` ASC) ,
  INDEX `fk_nodo_protocolo_nodo1_idx` (`nodo` ASC) ,
  CONSTRAINT `fk_nodo_protocolo_nodo1`
    FOREIGN KEY (`nodo`)
    REFERENCES `ingusbbo_piico`.`nodo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nodo_protocolo_Protocolo1`
    FOREIGN KEY (`protocolo`)
    REFERENCES `ingusbbo_piico`.`protocolo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ingusbbo_piico`.`historial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`historial` (
  `id` INT NOT NULL,
  `evento` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_historial_usuario1_idx` (`usuario` ASC) ,
  CONSTRAINT `fk_historial_usuario1`
    FOREIGN KEY (`usuario`)
    REFERENCES `ingusbbo_piico`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
