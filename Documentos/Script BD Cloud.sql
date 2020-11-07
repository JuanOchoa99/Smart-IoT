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
  `pass` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `usuariocol` VARCHAR(45) NOT NULL,
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
  `direccion_logica` VARCHAR(60) NOT NULL,
  `puerto_de_servicio` VARCHAR(10) NOT NULL,
  `prot_comun_ext` VARCHAR(45) NOT NULL,
  `usuario_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `usuario_id`),
  INDEX `fk_puerta_de_enlace_usuario_idx` (`usuario_id` ASC) ,
  CONSTRAINT `fk_puerta_de_enlace_usuario`
    FOREIGN KEY (`usuario_id`)
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
  INDEX `fk_Sensor_nodo_idx` (`nodo` ASC) ,
  CONSTRAINT `fk_Sensor_nodo`
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
  CONSTRAINT `fk_mensajes_puerta_de_enlace`
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
-- Table `ingusbbo_piico`.`usuario_rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ingusbbo_piico`.`usuario_rol` (
  `usuario` VARCHAR(45) NOT NULL,
  `rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`usuario`, `rol`),
  INDEX `fk_usuario_roles_rol_idx` (`rol` ASC) ,
  INDEX `fk_usuario_roles_usuario_idx` (`usuario` ASC) ,
  CONSTRAINT `fk_usuario_roles_usuario`
    FOREIGN KEY (`usuario`)
    REFERENCES `ingusbbo_piico`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_roles_rol`
    FOREIGN KEY (`rol`)
    REFERENCES `ingusbbo_piico`.`rol` (`nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `orden_id` VARCHAR(45) NOT NULL,
  `actuador_id` VARCHAR(45) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `confirmacion` TINYINT NOT NULL,
  PRIMARY KEY (`orden_id`, `actuador_id`),
  INDEX `fk_orden_actuador_actuador_idx` (`actuador_id` ASC) ,
  INDEX `fk_orden_actuador_orden_idx` (`orden_id` ASC) ,
  CONSTRAINT `fk_orden_has_actuador_orden`
    FOREIGN KEY (`orden_id`)
    REFERENCES `ingusbbo_piico`.`orden` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_has_actuador_actuador`
    FOREIGN KEY (`actuador_id`)
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
  PRIMARY KEY (`id`),
  INDEX `fk_auth_puerta_de_enlace_idx` (`puerta_de_enlace` ASC) ,
  CONSTRAINT `fk_auth_puerta_de_enlace`
    FOREIGN KEY (`puerta_de_enlace`)
    REFERENCES `ingusbbo_piico`.`puerta_de_enlace` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
