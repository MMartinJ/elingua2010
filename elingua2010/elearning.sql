--
-- Creació del Schema elearning
--
CREATE DATABASE elearning;
USE elearning;
--
-- Creació de la taula `usuaris`
--
DROP TABLE IF EXISTS `usuaris`;
CREATE TABLE `usuaris`(
	`id_usuari` int(11) NOT NULL default 0,
	`nom_usuari` varchar(15) NOT NULL default '',
	`psswd` varchar(15) NOT NULL default '',
	`tipus` varchar(15) NOT NULL default 'basic',
	`privacitat` boolean,
	PRIMARY KEY(`id_usuari`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Creació de la taula `administradors`
--
DROP TABLE IF EXISTS `administradors`;
CREATE TABLE `administradors`(
	`id_administrador` int(11) NOT NULL default 0,
	`usuari` int(11) NOT NULL default 0,
	PRIMARY KEY(`id_administrador`),
	KEY `FK_administradors_usuaris`(`usuari`),
	CONSTRAINT `FK_administradors_usuaris` FOREIGN KEY(`usuari`) REFERENCES `usuaris`(`id_usuari`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Creació de la taula `collaboradors`
--
DROP TABLE IF EXISTS `collaboradors`;
CREATE TABLE `collaboradors`(
	`id_collaborador` int(11) NOT NULL default 0,
	`usuari` int(11) NOT NULL default 0,
	`nom` varchar(15) NOT NULL default '',
	`cognom1` varchar(15) NOT NULL default '',
	`cognom2` varchar(15) NOT NULL default '',
	`sexe` varchar(1) NOT NULL default '',
	`data_naix` date,
	`email` varchar(30) NOT NULL default '',
	PRIMARY KEY(`id_collaborador`),
	KEY `FK_collaboradors_usuaris`(`usuari`),
	CONSTRAINT `FK_collaboradors_usuaris` FOREIGN KEY(`usuari`) REFERENCES `usuaris`(`id_usuari`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Creació de la taula `basics`
--
DROP TABLE IF EXISTS `basics`;
CREATE TABLE `basics`(
	`id_basic` int(11) NOT NULL default 0,
	`usuari` int(11) NOT NULL default 0,
	`nom` varchar(15) NOT NULL default '',
	`cognom1` varchar(15) NOT NULL default '',
	`cognom2` varchar(15) NOT NULL default '',
	`sexe` varchar(1) NOT NULL default '',
	`data_naix` date,
	`email` varchar(30) NOT NULL default '',	
	PRIMARY KEY(`id_basic`),
	KEY `FK_basics_usuaris`(`usuari`),
	CONSTRAINT `FK_basics_usuaris` FOREIGN KEY(`usuari`) REFERENCES `usuaris`(`id_usuari`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Creació de la taula `estadistiques`
--
DROP TABLE IF EXISTS `estadistiques`;
CREATE TABLE `estadistiques`(
	`id_estadistiques` int(11) NOT NULL default 0,
	`usuari` int(11) NOT NULL default 0,
	`ultim_log` date,
	`curs_pub` int(45),
	`curs_con` int(45),
	`msm_env` int(45),
	`msm_reb` int(45),
	PRIMARY KEY(`id_estadistiques`),
	KEY `FK_estadistiques_usuaris`(`usuari`),
	CONSTRAINT `FK_estadistiques_usuaris` FOREIGN KEY(`usuari`) REFERENCES `usuaris`(`id_usuari`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Creació de la taula `idiomes`
--
DROP TABLE IF EXISTS `idiomes`;
CREATE TABLE `idiomes`(
	`id_idioma` int(11) NOT NULL default 0,
	`nom` varchar(15) NOT NULL default '',
	PRIMARY KEY(`id_idioma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Creació de la taula `cursos`
--
DROP TABLE IF EXISTS `cursos`;
CREATE TABLE `cursos`(
	`id_curs` int(11) NOT NULL default 0,
	`titol` varchar(30) NOT NULL default '',
	`contingut` text ,
	`usuari` int(11) NOT NULL default 0,
	`idioma` int(11) NOT NULL default 0,
	PRIMARY KEY(`id_curs`),
	KEY `FK_cursos_usuaris`(`usuari`),
	KEY `FK_cursos_idiomes`(`idioma`),
	CONSTRAINT `FK_cursos_usuaris` FOREIGN KEY(`usuari`) REFERENCES `usuaris`(`id_usuari`) ON DELETE CASCADE,
	CONSTRAINT `FK_cursos_idiomes` FOREIGN KEY(`idioma`) REFERENCES `idiomes`(`id_idioma`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Creació de la taula `missatges`
--
DROP TABLE IF EXISTS `missatges`;
CREATE TABLE `missatges`(
	`id_missatge` int(11) NOT NULL default 0,
	`assumpte` varchar(50) NOT NULL default '',
	`contingut` varchar(500) NOT NULL default '',
	`emissor` int(11) NOT NULL default 0,
	`receptor` int(11) NOT NULL default 0,
	PRIMARY KEY(`id_missatge`),
	KEY `FK_missatges_emissor`(`emissor`),
	KEY `FK_missatges_receptor`(`receptor`),
	CONSTRAINT `FK_missatges_emissor` FOREIGN KEY(`emissor`) REFERENCES `usuaris`(`id_usuari`) ON DELETE CASCADE,
	CONSTRAINT `FK_missatges_receptor` FOREIGN KEY(`receptor`) REFERENCES `usuaris`(`id_usuari`) ON DELETE CASCADE

) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Creació de la taula `usuari_idioma_estudiat`
--
DROP TABLE IF EXISTS `usuari_idioma_estudiat`;
CREATE TABLE `usuari_idioma_estudiat`(
	`id_usuari_idioma_estudiat` int(11) NOT NULL default 0,
	`usuari` int(11) NOT NULL default 0,
	`idioma` int(11) NOT NULL default 0,
	PRIMARY KEY(`id_usuari_idioma_estudiat`),
	KEY `FK_estudiat_usuaris`(`usuari`),
  KEY `FK_estudiat_idiomes`(`idioma`),  
	CONSTRAINT `FK_estudiat_usuaris` FOREIGN KEY(`usuari`) REFERENCES `usuaris`(`id_usuari`) ON DELETE CASCADE,
  CONSTRAINT `FK_estudiat_idiomes` FOREIGN KEY(`idioma`) REFERENCES `idiomes`(`id_idioma`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Creació de la taula `usuari_idioma_parlat`
--
DROP TABLE IF EXISTS `usuari_idioma_parlat`;
CREATE TABLE `usuari_idioma_parlat`(
	`id_usuari_idioma_parlat` int(11) NOT NULL default 0,
	`usuari` int(11) NOT NULL default 0,
	`idioma` int(11) NOT NULL default 0,
	PRIMARY KEY(`id_usuari_idioma_parlat`),
  KEY `FK_parlat_idiomes`(`idioma`),  
	KEY `FK_parlat_usuaris`(`usuari`),
	CONSTRAINT `FK_parlat_usuaris` FOREIGN KEY(`usuari`) REFERENCES `usuaris`(`id_usuari`) ON DELETE CASCADE,
  CONSTRAINT `FK_parlat_idiomes` FOREIGN KEY(`idioma`) REFERENCES `idiomes`(`id_idioma`) ON DELETE CASCADE  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Creació de la taula `historial_curs_visitat`
--
DROP TABLE IF EXISTS `historial_curs_visitat`;
CREATE TABLE `historial_curs_visitat`(
	`id_usuari_curs_visitat` int(11) NOT NULL default 0,
	`usuari` int(11) NOT NULL default 0,
	`curs` int(11) NOT NULL default 0,
	PRIMARY KEY(`id_usuari_curs_visitat`),
  	KEY `FK_historial_curs`(`curs`),  
	KEY `FK_historial_usuaris`(`usuari`),
	CONSTRAINT `FK_historial_usuaris` FOREIGN KEY(`usuari`) REFERENCES `usuaris`(`id_usuari`) ON DELETE CASCADE,
  	CONSTRAINT `FK_historial_curs` FOREIGN KEY(`curs`) REFERENCES `cursos`(`id_curs`) ON DELETE CASCADE  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO usuaris VALUES (1,"admin","admin","administrador",true);
INSERT INTO administradors VALUES (1,1);
INSERT INTO estadistiques VALUES (1,1,'2010-12-27',0,0,0,0);

INSERT INTO idiomes VALUES (1,"catala");
INSERT INTO idiomes VALUES (2,"castellano");
INSERT INTO idiomes VALUES (3,"english");
INSERT INTO idiomes VALUES (4,"nihongo");

GRANT all ON elearning.* TO root IDENTIFIED BY "admin";
