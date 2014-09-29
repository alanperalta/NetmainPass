-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.34 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para pass
CREATE DATABASE IF NOT EXISTS `pass` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pass`;

-- Volcando estructura para tabla pass.grupo_usuarios
CREATE TABLE IF NOT EXISTS `grupo_usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pass.grupo_usuarios: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `grupo_usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupo_usuarios` ENABLE KEYS */;


-- Volcando estructura para tabla pass.grupos_accesos
CREATE TABLE IF NOT EXISTS `grupos_accesos` (
  `FK_grupo_usuarios` int(11) NOT NULL,
  `FK_accesos` int(11) NOT NULL,
  PRIMARY KEY (`FK_grupo_usuarios`,`FK_accesos`),
  KEY `FK_accesos` (`FK_accesos`),
  CONSTRAINT `FK2_grupo_usuarios` FOREIGN KEY (`FK_grupo_usuarios`) REFERENCES `grupo_usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_accesos` FOREIGN KEY (`FK_accesos`) REFERENCES `accesos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pass.grupos_accesos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `grupos_accesos` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupos_accesos` ENABLE KEYS */;


-- Volcando estructura para tabla pass.tipo_accesos
CREATE TABLE IF NOT EXISTS `tipo_accesos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pass.tipo_accesos: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_accesos` DISABLE KEYS */;
INSERT INTO `tipo_accesos` (`id`, `nombre`) VALUES
	(2, 'E-mail'),
	(3, 'Red Social'),
	(4, 'FTP'),
	(5, 'Base de datos'),
	(6, 'Panel Web'),
	(7, 'Homebanking'),
	(8, 'Otras webs'),
	(9, 'Códigos'),
	(10, 'Combinación'),
	(11, 'Administración Web');
/*!40000 ALTER TABLE `tipo_accesos` ENABLE KEYS */;


-- Volcando estructura para tabla pass.tipo_usuario
CREATE TABLE IF NOT EXISTS `tipo_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pass.tipo_usuario: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` (`id`, `nombre`) VALUES
	(1, 'Admin'),
	(2, 'Normal');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;


-- Volcando estructura para tabla pass.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `FK_tipo_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario` (`usuario`),
  KEY `FK__tipo_usuario` (`FK_tipo_usuario`),
  CONSTRAINT `FK__tipo_usuario` FOREIGN KEY (`FK_tipo_usuario`) REFERENCES `tipo_usuario` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pass.usuarios: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id`, `usuario`, `pass`, `FK_tipo_usuario`) VALUES
	(1, 'admin', 'admin', 1),
	(2, 'alan', 'alan', 2);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;


-- Volcando estructura para tabla pass.usuarios_grupos
CREATE TABLE IF NOT EXISTS `usuarios_grupos` (
  `FK_usuarios` int(11) NOT NULL,
  `FK_grupo_usuarios` int(11) NOT NULL,
  PRIMARY KEY (`FK_usuarios`,`FK_grupo_usuarios`),
  KEY `FK_grupo_usuarios` (`FK_grupo_usuarios`),
  CONSTRAINT `FK_usuarios` FOREIGN KEY (`FK_usuarios`) REFERENCES `usuarios` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_grupo_usuarios` FOREIGN KEY (`FK_grupo_usuarios`) REFERENCES `grupo_usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pass.usuarios_grupos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios_grupos` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_grupos` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

-- Volcando estructura para tabla pass.accesos
CREATE TABLE IF NOT EXISTS `accesos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `FK_usuarios` int(11) NOT NULL,
  `FK_tipo_accesos` int(11) NOT NULL,
  `URL` varchar(50) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `servidor` varchar(50) DEFAULT NULL,
  `puerto` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2_usuarios` (`FK_usuarios`),
  KEY `FK_tipo_accesos` (`FK_tipo_accesos`),
  CONSTRAINT `FK2_usuarios` FOREIGN KEY (`FK_usuarios`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_tipo_accesos` FOREIGN KEY (`FK_tipo_accesos`) REFERENCES `tipo_accesos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla pass.accesos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `accesos` DISABLE KEYS */;
/*!40000 ALTER TABLE `accesos` ENABLE KEYS */;