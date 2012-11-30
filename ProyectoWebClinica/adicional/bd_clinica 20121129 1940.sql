-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.16


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bd_clinica
--

CREATE DATABASE IF NOT EXISTS bd_clinica;
USE bd_clinica;

--
-- Definition of table `tbl_atencion_dia`
--

DROP TABLE IF EXISTS `tbl_atencion_dia`;
CREATE TABLE `tbl_atencion_dia` (
  `numero` int(11) NOT NULL,
  `codigo` char(6) NOT NULL,
  `estado` int(11) NOT NULL,
  `cod_historiaclinica` char(6) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_atencion_dia`
--

/*!40000 ALTER TABLE `tbl_atencion_dia` DISABLE KEYS */;
INSERT INTO `tbl_atencion_dia` (`numero`,`codigo`,`estado`,`cod_historiaclinica`,`fecha`) VALUES 
 (1,'E00001',1,'HE0002','2012-11-28'),
 (2,'E00002',1,'HA0001','2012-11-28'),
 (3,'E00003',1,'HE0002','2012-11-28'),
 (4,'E00004',1,'HA0001','2012-11-28');
/*!40000 ALTER TABLE `tbl_atencion_dia` ENABLE KEYS */;


--
-- Definition of table `tbl_boletas`
--

DROP TABLE IF EXISTS `tbl_boletas`;
CREATE TABLE `tbl_boletas` (
  `cod_boleta` char(12) COLLATE utf8_spanish_ci NOT NULL,
  `fecha` date NOT NULL,
  `monto` double NOT NULL,
  PRIMARY KEY (`cod_boleta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_boletas`
--

/*!40000 ALTER TABLE `tbl_boletas` DISABLE KEYS */;
INSERT INTO `tbl_boletas` (`cod_boleta`,`fecha`,`monto`) VALUES 
 ('0001-0000001','2012-10-10',30),
 ('0001-0000002','2013-11-10',30),
 ('0001-0000003','2012-11-28',30),
 ('0001-0000004','2011-12-15',30),
 ('0001-0000005','2012-11-28',30),
 ('0001-0000006','2012-11-28',30),
 ('0004-0000001','2013-11-28',30),
 ('0004-0000002','2012-11-28',30),
 ('0004-0000003','2012-10-28',30),
 ('0004-0000004','2012-12-15',30),
 ('0004-0000005','2011-11-28',30);
/*!40000 ALTER TABLE `tbl_boletas` ENABLE KEYS */;


--
-- Definition of table `tbl_consultas`
--

DROP TABLE IF EXISTS `tbl_consultas`;
CREATE TABLE `tbl_consultas` (
  `cod_consulta` char(6) COLLATE utf8_spanish_ci NOT NULL,
  `fecha` date NOT NULL,
  `tipo_consulta` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `cod_boleta` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `estado` int(11) NOT NULL,
  `cod_historiaclinica` char(6) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cod_consulta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_consultas`
--

/*!40000 ALTER TABLE `tbl_consultas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_consultas` ENABLE KEYS */;


--
-- Definition of table `tbl_examenes`
--

DROP TABLE IF EXISTS `tbl_examenes`;
CREATE TABLE `tbl_examenes` (
  `cod_examen` char(6) COLLATE utf8_spanish_ci NOT NULL,
  `estado` int(11) NOT NULL,
  `cod_boleta` char(12) COLLATE utf8_spanish_ci NOT NULL,
  `fecha` date NOT NULL,
  `cod_historiaclinica` char(6) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cod_examen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_examenes`
--

/*!40000 ALTER TABLE `tbl_examenes` DISABLE KEYS */;
INSERT INTO `tbl_examenes` (`cod_examen`,`estado`,`cod_boleta`,`fecha`,`cod_historiaclinica`) VALUES 
 ('E00001',1,'0004-0000001','2012-09-28','HE0002'),
 ('E00002',1,'0004-0000002','2012-10-28','HA0001'),
 ('E00003',1,'0001-0000005','2012-11-28','HE0002'),
 ('E00004',1,'0001-0000006','2012-12-28','HA0001');
/*!40000 ALTER TABLE `tbl_examenes` ENABLE KEYS */;


--
-- Definition of table `tbl_historiasclinicas`
--

DROP TABLE IF EXISTS `tbl_historiasclinicas`;
CREATE TABLE `tbl_historiasclinicas` (
  `cod_historiaclinica` char(6) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_emision` date NOT NULL,
  PRIMARY KEY (`cod_historiaclinica`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_historiasclinicas`
--

/*!40000 ALTER TABLE `tbl_historiasclinicas` DISABLE KEYS */;
INSERT INTO `tbl_historiasclinicas` (`cod_historiaclinica`,`fecha_emision`) VALUES 
 ('HA0001','2012-10-26'),
 ('HA0003','2012-10-26'),
 ('HA0004','2012-10-26'),
 ('HA0007','2012-11-28'),
 ('HA0008','2012-11-28'),
 ('HA0009','2012-11-28'),
 ('HE0002','2012-10-26'),
 ('HE0005','2012-10-26'),
 ('HE0006','2012-11-13'),
 ('HE0010','2012-11-28');
/*!40000 ALTER TABLE `tbl_historiasclinicas` ENABLE KEYS */;


--
-- Definition of table `tbl_medicinag`
--

DROP TABLE IF EXISTS `tbl_medicinag`;
CREATE TABLE `tbl_medicinag` (
  `cod_diagmedicina` char(7) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `diagpresun_medicina` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `diagdef_medicina` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `indicacion_medic` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `cod_personal` char(4) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cod_diagmedicina`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_medicinag`
--

/*!40000 ALTER TABLE `tbl_medicinag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_medicinag` ENABLE KEYS */;


--
-- Definition of table `tbl_odontologia`
--

DROP TABLE IF EXISTS `tbl_odontologia`;
CREATE TABLE `tbl_odontologia` (
  `cod_diagodontologia` char(7) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `diagpresun_odontologia` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `diagdef_odontologia` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `indicacion_odon` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `cod_personal` char(4) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cod_diagodontologia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_odontologia`
--

/*!40000 ALTER TABLE `tbl_odontologia` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_odontologia` ENABLE KEYS */;


--
-- Definition of table `tbl_pacientes`
--

DROP TABLE IF EXISTS `tbl_pacientes`;
CREATE TABLE `tbl_pacientes` (
  `dni_paciente` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `cod_historiaclinica` char(6) COLLATE utf8_spanish_ci NOT NULL,
  `nombres` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `sexo` char(1) COLLATE utf8_spanish_ci NOT NULL,
  `ocupacion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `procedencia` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `estado_civil` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`dni_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_pacientes`
--

/*!40000 ALTER TABLE `tbl_pacientes` DISABLE KEYS */;
INSERT INTO `tbl_pacientes` (`dni_paciente`,`cod_historiaclinica`,`nombres`,`apellidos`,`sexo`,`ocupacion`,`procedencia`,`fecha_nacimiento`,`estado_civil`,`direccion`,`telefono`) VALUES 
 ('00002222','HE0010','AAAAAA','AAAAAAAA SSSSSSSSS','M','ASSSSSSSSS','AASSSSSSSSS','2012-01-02','CASADO','sssssssssssssssss','333333333'),
 ('08736529','HE0006','MARIA','HORA ROERJA','F','DDDDDDDD','PIURA','1989-04-14','CASADO','piura-piura','124578'),
 ('10101010','HE0002','KARLA','PEÑA APONTE','F','PROFESORA','MANCORA','1992-10-15','CASADO','piura','101214142'),
 ('11111111','HA0009','JUAN','VALDEZ','F','ESTUDIANTE','ASDASD','1992-12-02','CASADO','PIURA','213456'),
 ('12121212','HA0001','SIMON','LAZO ACARO','M','ESTUDIANTE','PIURA','1992-10-14','SOLTERO','castilla','235645781'),
 ('23674892','HA0004','VICTOR FRANCO','ZEVALLOS PALACIOS','M','ESTUDIANTE','PIURA','1993-10-01','SOLTERO','santa rosa piura','969610053'),
 ('70353606','HA0007','JUAN','MERINO RUIZ','M','ESTUDIANTE','PIURA','1993-01-11','SOLTERO','piura-piura','235645895'),
 ('78963321','HA0008','CARMEN','PEÑA MARTINEZ','F','ESTUDIANTE','PIURA','1992-01-05','SOLTERO','piura',''),
 ('82732912','HE0005','ALICIA','MONZON GAMBOA','F','ABOGADA','SULLANA','1994-10-13','SOLTERO','los geranios','941401020');
/*!40000 ALTER TABLE `tbl_pacientes` ENABLE KEYS */;


--
-- Definition of table `tbl_pacientesalumnos`
--

DROP TABLE IF EXISTS `tbl_pacientesalumnos`;
CREATE TABLE `tbl_pacientesalumnos` (
  `dni_paciente` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_univ` char(10) COLLATE utf8_spanish_ci NOT NULL,
  `escuela` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `año_ingreso` int(11) DEFAULT NULL,
  `ciclo` char(4) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=FIXED;

--
-- Dumping data for table `tbl_pacientesalumnos`
--

/*!40000 ALTER TABLE `tbl_pacientesalumnos` DISABLE KEYS */;
INSERT INTO `tbl_pacientesalumnos` (`dni_paciente`,`codigo_univ`,`escuela`,`año_ingreso`,`ciclo`) VALUES 
 ('12121212','2101121245','SISTEMAS',2010,'VI'),
 ('23674892','1232134567','SISTEMAS',2010,'I'),
 ('70353606','2101140081','SISTEMAS',2012,'II'),
 ('78963321','2345784512','MARKETING',2012,'II'),
 ('22222222','2222222222','ADMINISTRACION',2011,'IV');
/*!40000 ALTER TABLE `tbl_pacientesalumnos` ENABLE KEYS */;


--
-- Definition of table `tbl_personal`
--

DROP TABLE IF EXISTS `tbl_personal`;
CREATE TABLE `tbl_personal` (
  `cod_personal` char(4) COLLATE utf8_spanish_ci NOT NULL,
  `nombres` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `sexo` char(1) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `cod_tipo_personal` int(11) NOT NULL,
  `dni_personal` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `num_user` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY (`cod_personal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_personal`
--

/*!40000 ALTER TABLE `tbl_personal` DISABLE KEYS */;
INSERT INTO `tbl_personal` (`cod_personal`,`nombres`,`apellidos`,`sexo`,`fecha_nacimiento`,`cod_tipo_personal`,`dni_personal`,`num_user`,`estado`) VALUES 
 ('P001','MARIA','SALAZAR LAZO','F','1986-10-15',5,'11111111',1,1),
 ('P002','JUAN','VARGAS LOZA','M','1986-10-09',2,'22222222',2,1),
 ('P003','LUISA','RUIZ SETA','F','1985-10-10',3,'33333333',3,1),
 ('P004','SIMON','PEÑA LAZO','M','1985-10-18',4,'44444444',4,1),
 ('P005','LINDA','LAZO ACARO','F','1983-10-06',5,'55555555',5,1),
 ('P006','MANUEL','ZAPATA PEREZ','M','1984-10-19',4,'66666666',6,1);
/*!40000 ALTER TABLE `tbl_personal` ENABLE KEYS */;


--
-- Definition of table `tbl_psicologia`
--

DROP TABLE IF EXISTS `tbl_psicologia`;
CREATE TABLE `tbl_psicologia` (
  `cod_diagpsicologia` char(7) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `diagpresun_psicologia` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `diagdef_psicologia` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `indicacion_psico` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `cod_personal` char(4) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cod_diagpsicologia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_psicologia`
--

/*!40000 ALTER TABLE `tbl_psicologia` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_psicologia` ENABLE KEYS */;


--
-- Definition of table `tbl_resultados_consulta`
--

DROP TABLE IF EXISTS `tbl_resultados_consulta`;
CREATE TABLE `tbl_resultados_consulta` (
  `cod_consulta` char(6) COLLATE utf8_spanish_ci NOT NULL,
  `cod_diagodontologia` char(7) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cod_diagpsicologia` char(7) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cod_diagmedicina` char(7) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_resultados_consulta`
--

/*!40000 ALTER TABLE `tbl_resultados_consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_resultados_consulta` ENABLE KEYS */;


--
-- Definition of table `tbl_resultados_examenes`
--

DROP TABLE IF EXISTS `tbl_resultados_examenes`;
CREATE TABLE `tbl_resultados_examenes` (
  `cod_examen` char(6) NOT NULL,
  `hemoglobina` varchar(6) NOT NULL,
  `peso` varchar(6) NOT NULL,
  `talla` varchar(6) NOT NULL,
  `presion` varchar(6) NOT NULL,
  `cod_diagpsicologia` char(7) NOT NULL,
  `cod_diagmedicina` char(7) NOT NULL,
  `cod_diagodontologia` char(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_resultados_examenes`
--

/*!40000 ALTER TABLE `tbl_resultados_examenes` DISABLE KEYS */;
INSERT INTO `tbl_resultados_examenes` (`cod_examen`,`hemoglobina`,`peso`,`talla`,`presion`,`cod_diagpsicologia`,`cod_diagmedicina`,`cod_diagodontologia`) VALUES 
 ('E00001','','','','','','','');
/*!40000 ALTER TABLE `tbl_resultados_examenes` ENABLE KEYS */;


--
-- Definition of table `tbl_tipo`
--

DROP TABLE IF EXISTS `tbl_tipo`;
CREATE TABLE `tbl_tipo` (
  `cod_tipo` int(11) NOT NULL,
  `descripcion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cod_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `tbl_tipo`
--

/*!40000 ALTER TABLE `tbl_tipo` DISABLE KEYS */;
INSERT INTO `tbl_tipo` (`cod_tipo`,`descripcion`) VALUES 
 (1,'Admin'),
 (2,'User');
/*!40000 ALTER TABLE `tbl_tipo` ENABLE KEYS */;


--
-- Definition of table `tbl_tipo_personal`
--

DROP TABLE IF EXISTS `tbl_tipo_personal`;
CREATE TABLE `tbl_tipo_personal` (
  `cod_tipo_personal` int(11) NOT NULL,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cod_tipo_personal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_tipo_personal`
--

/*!40000 ALTER TABLE `tbl_tipo_personal` DISABLE KEYS */;
INSERT INTO `tbl_tipo_personal` (`cod_tipo_personal`,`nombre`) VALUES 
 (1,'MEDICINA'),
 (2,'PSICOLOGIA'),
 (3,'ODONTOLOGIA'),
 (4,'LABORATORIO'),
 (5,'SECRETARIA');
/*!40000 ALTER TABLE `tbl_tipo_personal` ENABLE KEYS */;


--
-- Definition of table `tbl_usuarios`
--

DROP TABLE IF EXISTS `tbl_usuarios`;
CREATE TABLE `tbl_usuarios` (
  `num_user` int(11) NOT NULL,
  `nombre_usuario` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `clave` text COLLATE utf8_spanish_ci NOT NULL,
  `cod_tipo` int(11) NOT NULL,
  PRIMARY KEY (`num_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `tbl_usuarios`
--

/*!40000 ALTER TABLE `tbl_usuarios` DISABLE KEYS */;
INSERT INTO `tbl_usuarios` (`num_user`,`nombre_usuario`,`clave`,`cod_tipo`) VALUES 
 (1,'msalazarl','e10adc3949ba59abbe56e057f20f883e',1),
 (2,'jvargasl','e10adc3949ba59abbe56e057f20f883e',2),
 (3,'lruizs','e10adc3949ba59abbe56e057f20f883e',2),
 (4,'speñal','e10adc3949ba59abbe56e057f20f883e',2),
 (5,'llazoa','e10adc3949ba59abbe56e057f20f883e',2),
 (6,'mzapatap','d464716d183952b50a1eafb3271ce6fb',2);
/*!40000 ALTER TABLE `tbl_usuarios` ENABLE KEYS */;


--
-- Definition of procedure `sp_actualizaralumno`
--

DROP PROCEDURE IF EXISTS `sp_actualizaralumno`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizaralumno`(IN nom_e varchar(30),IN ape_e varchar(40) ,IN cod_uni char(10),
 IN escuela_e varchar(20),in ciclo_e char(4),in dni_e char(8) ,in cod_histo char(6))
BEGIN
declare h1 char(6);
select dni_paciente into h1 from tbl_pacientes where cod_historiaclinica=cod_histo;

update tbl_pacientesalumnos set codigo_univ=cod_uni, escuela=upper(escuela_e), ciclo=upper(ciclo_e) where dni_paciente=h1;

update tbl_pacientes set nombres=nom_e, apellidos=ape_e, dni_paciente=dni_e where cod_historiaclinica=cod_histo;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_actualizarpaciente`
--

DROP PROCEDURE IF EXISTS `sp_actualizarpaciente`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarpaciente`(IN nom_e varchar(30),IN ape_e varchar(40) ,IN tel_e  varchar(9), IN dir_e varchar(50),in fec_e date,in dni_e char(8),in cod_histo char(6))
BEGIN
update tbl_pacientes set nombres=upper(nom_e), apellidos=upper(ape_e), telefono=tel_e, direccion=upper(dir_e), fecha_nacimiento=fec_e,dni_paciente=dni_e
 where cod_historiaclinica=cod_histo;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_actualizar_contraseña_usuario`
--

DROP PROCEDURE IF EXISTS `sp_actualizar_contraseña_usuario`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_contraseña_usuario`(in nom_usuario varchar(20),
in clave_e text,in dato_e text)
BEGIN
declare n1 int;
declare n2 int;
select count(*) into n1 from tbl_usuarios where nombre_usuario=nom_usuario
and clave=md5(clave_e);

if(n1=1) then
  update tbl_usuarios set clave=md5(dato_e) where nombre_usuario=nom_usuario;
end if;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_actualizar_estado_personal`
--

DROP PROCEDURE IF EXISTS `sp_actualizar_estado_personal`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_estado_personal`(in codigo char(4),in var int)
BEGIN

update tbl_personal set estado=var where cod_persona=codigo;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_actualizar_tipo_usuario`
--

DROP PROCEDURE IF EXISTS `sp_actualizar_tipo_usuario`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_tipo_usuario`(in num_usuario int,in dato_e int)
BEGIN
declare n1 int;
select count(*) into n1 from tbl_usuarios where num_user=num_usuario;

if (n1=1) then
  update tbl_usuarios set cod_tipo=dato_e where num_user=num_usuario;
end if;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_atencion_dia`
--

DROP PROCEDURE IF EXISTS `sp_atencion_dia`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_atencion_dia`(in codigo_e char(6),
in codi char(6))
BEGIN

declare cod char(6);

SELECT (ifnull(Max(SUBSTRING(numero,1)),0)+1) into cod FROM tbl_atencion_dia;

insert into tbl_atencion_dia(numero,codigo,estado,cod_historiaclinica,fecha)
values(cod,codigo_e,1,codi,curdate());

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_atender_medicinag_con`
--

DROP PROCEDURE IF EXISTS `sp_atender_medicinag_con`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_atender_medicinag_con`(in dni_e char(8),in diagpresun_e varchar(70),
in diagdef_e varchar(70), in indicacion_e varchar(70),in cod_personal_e char(4))
BEGIN

declare codigo_g char(7);
declare cod_con char(6);

SELECT CONCAT('M',LPAD(ifnull(Max(SUBSTRING(cod_diagmedicina,2)),0)+1,6,'0')) into codigo_g FROM tbl_medicinag;

insert into tbl_medicinag(cod_diagmedicina,diagpresun_medicina,diagdef_medicina,indicacion_medic,cod_personal)
values (codigo_g,upper(diagpresun_e),upper(diagdef_e),upper(indicacion_e),upper(cod_personal_e));

select  c.cod_consulta into cod_con from tbl_consultas c inner join tbl_historiasclinicas h
on c.cod_historiaclinica=h.cod_historiaclinica inner join tbl_pacientes p
on h.cod_historiaclinica=p.cod_historiaclinica where p.dni_paciente=dni_e and c.estado=2 and c.fecha=curdate();

update tbl_resultados_consulta set cod_diagmedicina=codigo_g where cod_consulta=cod_con;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_atender_medicinag_ex`
--

DROP PROCEDURE IF EXISTS `sp_atender_medicinag_ex`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_atender_medicinag_ex`(in dni_e char(8),in diagpresun_e varchar(70),in diagdef_e varchar(70),
in indicacion_e varchar(70),in cod_personal_e char(4))
BEGIN

declare codigo_g char(7);
declare cod_ex char(6);

SELECT CONCAT('M',LPAD(ifnull(Max(SUBSTRING(cod_diagmedicina,2)),0)+1,6,'0')) into codigo_g
FROM tbl_medicinag;

insert into tbl_medicinag(cod_diagmedicina,diagpresun_medicina,diagdef_medicina,indicacion_medic,cod_personal)
values (codigo_g,upper(diagpresun_e),upper(diagdef_e),upper(indicacion_e),upper(cod_personal_e));

select  e.cod_examen into cod_ex from tbl_examenes e inner join tbl_historiasclinicas h
on e.cod_historiaclinica=h.cod_historiaclinica inner join tbl_pacientes p
on h.cod_historiaclinica=p.cod_historiaclinica where p.dni_paciente=dni_e and e.estado=2 and e.fecha=curdate();

update tbl_resultados_examenes set cod_diagmedicina=codigo_g where cod_examen=cod_ex;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_atender_odontologia_con`
--

DROP PROCEDURE IF EXISTS `sp_atender_odontologia_con`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_atender_odontologia_con`(in dni_e char(8),in diagpresun_e varchar(70),
in diagdef_e varchar(70), in indicacion_e varchar(70),in cod_personal_e char(4))
BEGIN

declare codigo_g char(7);
declare cod_con char(6);

SELECT CONCAT('O',LPAD(ifnull(Max(SUBSTRING(cod_diagodontologia,2)),0)+1,6,'0')) into codigo_g FROM tbl_odontologia;

insert into tbl_odontologia(cod_diagodontologia,diagpresun_odontologia,diagdef_odontologia,indicacion_odon,cod_personal)
values (codigo_g,upper(diagpresun_e),upper(diagdef_e),upper(indicacion_e),upper(cod_personal_e));

select  c.cod_consulta into cod_con from tbl_consultas c inner join tbl_historiasclinicas h
on c.cod_historiaclinica=h.cod_historiaclinica inner join tbl_pacientes p
on h.cod_historiaclinica=p.cod_historiaclinica where p.dni_paciente=dni_e and c.estado=2 and c.fecha=curdate();

update tbl_resultados_consulta set cod_diagodontologia=codigo_g where cod_consulta=cod_con;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_atender_odontologia_ex`
--

DROP PROCEDURE IF EXISTS `sp_atender_odontologia_ex`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_atender_odontologia_ex`(in dni_e char(8),in diagpresun_e varchar(70),in diagdef_e varchar(70),
in indicacion_e varchar(70),in cod_personal_e char(4))
BEGIN

declare codigo_g char(7);
declare cod_ex char(6);

SELECT CONCAT('O',LPAD(ifnull(Max(SUBSTRING(cod_diagodontologia,2)),0)+1,6,'0')) into codigo_g
FROM tbl_odontologia;

insert into tbl_odontologia(cod_diagodontologia,diagpresun_odontologia,diagdef_odontologia,indicacion_odon,cod_personal)
values (codigo_g,upper(diagpresun_e),upper(diagdef_e),upper(indicacion_e),upper(cod_personal_e));


select  e.cod_examen into cod_ex from tbl_examenes e inner join tbl_historiasclinicas h
on e.cod_historiaclinica=h.cod_historiaclinica inner join tbl_pacientes p
on h.cod_historiaclinica=p.cod_historiaclinica where p.dni_paciente=dni_e and e.estado=2 and e.fecha=curdate();

update tbl_resultados_examenes set cod_diagodontologia=codigo_g where cod_examen=cod_ex;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_atender_paciente`
--

DROP PROCEDURE IF EXISTS `sp_atender_paciente`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_atender_paciente`(in  cod_e char(6))
BEGIN

declare aux char(1);
declare cod char(6);

select substring(at.codigo,1,1) into aux from tbl_atencion_dia at where at.codigo=cod_e and at.estado=1;

select at.codigo into cod from tbl_atencion_dia at where at.codigo=cod_e and at.estado=1;


if(aux='C')then
  insert into tbl_resultados_consulta(cod_consulta,cod_diagodontologia,cod_diagpsicologia,cod_diagmedicina)
  values(cod,'','','');
  update tbl_consultas set estado=2 where cod_consulta=cod;
  update tbl_atencion_dia set estado=2 where codigo=cod;
  else if(aux='E')then
    insert into tbl_resultados_examenes(cod_examen,hemoglobina,peso,talla,presion,cod_diagpsicologia,cod_diagmedicina,cod_diagodontologia)
    values(cod,'','','','','','','');
    update tbl_examenes set estado=2 where cod_examen=cod;
    update tbl_atencion_dia set estado=2 where codigo=cod;
  end if;
end if;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_atender_psicologia_con`
--

DROP PROCEDURE IF EXISTS `sp_atender_psicologia_con`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_atender_psicologia_con`(in dni_e char(8),in diagpresun_e varchar(70),
in diagdef_e varchar(70), in indicacion_e varchar(70),in cod_personal_e char(4))
BEGIN

declare codigo_g char(7);
declare cod_con char(6);

SELECT CONCAT('P',LPAD(ifnull(Max(SUBSTRING(cod_diagpsicologia,2)),0)+1,6,'0')) into codigo_g FROM tbl_psicologia;

insert into tbl_psicologia(cod_diagpsicologia,diagpresun_psicologia,diagdef_psicologia,indicacion_psico,cod_personal)
values (codigo_g,upper(diagpresun_e),upper(diagdef_e),upper(indicacion_e),upper(cod_personal_e));

select  c.cod_consulta into cod_con from tbl_consultas c inner join tbl_historiasclinicas h
on c.cod_historiaclinica=h.cod_historiaclinica inner join tbl_pacientes p
on h.cod_historiaclinica=p.cod_historiaclinica where p.dni_paciente=dni_e and c.estado=2 and c.fecha=curdate();

update tbl_resultados_consulta set cod_diagpsicologia=codigo_g where cod_consulta=cod_con;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_atender_psicologia_ex`
--

DROP PROCEDURE IF EXISTS `sp_atender_psicologia_ex`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_atender_psicologia_ex`(in dni_e char(8),in diagpresun_e varchar(70),
in diagdef_e varchar(70), in indicacion_e varchar(70),in cod_personal_e char(4))
BEGIN

declare codigo_g char(7);
declare cod_ex char(6);

SELECT CONCAT('P',LPAD(ifnull(Max(SUBSTRING(cod_diagpsicologia,2)),0)+1,6,'0')) into codigo_g FROM tbl_psicologia;

insert into tbl_psicologia(cod_diagpsicologia,diagpresun_psicologia,diagdef_psicologia,indicacion_psico,cod_personal)
values (codigo_g,upper(diagpresun_e),upper(diagdef_e),upper(indicacion_e),upper(cod_personal_e));

select  e.cod_examen into cod_ex from tbl_examenes e inner join tbl_historiasclinicas h
on e.cod_historiaclinica=h.cod_historiaclinica inner join tbl_pacientes p
on h.cod_historiaclinica=p.cod_historiaclinica where p.dni_paciente=dni_e and e.estado=2 and e.fecha=curdate();


update tbl_resultados_examenes set cod_diagpsicologia=codigo_g where cod_examen=cod_ex;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_buscarpaciente`
--

DROP PROCEDURE IF EXISTS `sp_buscarpaciente`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarpaciente`(in dni_paciente_e char(8))
BEGIN
select cod_historiaclinica,dni_paciente,nombres,apellidos
from tbl_pacientes where dni_paciente=dni_paciente_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_cerrar_ex_con`
--

DROP PROCEDURE IF EXISTS `sp_cerrar_ex_con`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cerrar_ex_con`(in codigo_e char(6))
BEGIN

declare aux char(1);

select substring(codigo_e,1,1) into aux;

if(aux='C')then
  update tbl_consultas set estado=0 where cod_consulta=codigo_e;
  update tbl_atencion_dia set estado=0 where codigo=codigo_e;
  else if(aux='E')then
    update tbl_examenes set estado=0 where cod_examen=codigo_e;
    update tbl_atencion_dia set estado=0 where codigo=codigo_e;
  end if;
end if;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_crearconsulta`
--

DROP PROCEDURE IF EXISTS `sp_crearconsulta`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crearconsulta`(in dni_e char(8), in tipo_consulta_e varchar(20),
in cod_boleta_e char(5), out cod_consulta_s char(6))
BEGIN
declare cod_consulta_g char(6);
declare n1 int;
declare n2 int;
declare n3 int;
declare n4 int;
declare he char (6);

select count(*) into n1 from tbl_consultas where fecha=curdate();
select count(*) into n2 from tbl_examenes where fecha=curdate();
select count(*) into n3 from tbl_consultas where cod_boleta=cod_boleta_e;
select count(*) into n4 from tbl_examenes where cod_boleta=cod_boleta_e;

if((n1+n2)<=20 and n3+n4=0) then
  SELECT CONCAT('C',LPAD(ifnull(Max(SUBSTRING(cod_consulta,2)),0)+1,5,'0')) into cod_consulta_g
  FROM tbl_consultas;

  select cod_historiaclinica into he from tbl_pacientes where dni_paciente=dni_e;

  insert into tbl_consultas(cod_consulta,fecha,tipo_consulta,cod_boleta,estado,cod_historiaclinica)
  values(cod_consulta_g,curdate(),upper(tipo_consulta_e),cod_boleta_e,1,he);

  call sp_atencion_dia(cod_consulta_g);
  set cod_consulta_s=cod_consulta_g;
end if;



END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_crearexamen`
--

DROP PROCEDURE IF EXISTS `sp_crearexamen`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_crearexamen`(in dni_e char(8),
in cod_boleta_e char(12),in monto_e double, out cod_examen_s char(6))
BEGIN
declare cod_examen_g char(6);
declare n1 int;
declare n2 int;
declare n3 int;
declare n4 int;
declare he char (6);

select count(*) into n1 from tbl_consultas where fecha=curdate();
select count(*) into n2 from tbl_examenes where fecha=curdate();
select count(*) into n3 from tbl_examenes where cod_boleta=cod_boleta_e;
select count(*) into n4 from tbl_consultas where cod_boleta=cod_boleta_e;

if((n1+n2)<=20 and n3+n4=0) then

  SELECT CONCAT('E',LPAD(ifnull(Max(SUBSTRING(cod_examen,2)),0)+1,5,'0')) into cod_examen_g
  FROM tbl_examenes;

  call sp_registrarpago(cod_boleta_e,monto_e,@s);
  select cod_historiaclinica into he from tbl_pacientes where dni_paciente=dni_e;
  
  insert into tbl_examenes(cod_examen,estado,cod_boleta,fecha,cod_historiaclinica)
  values(cod_examen_g,1,@s,curdate(),he);

  call sp_atencion_dia(cod_examen_g,he);

  set cod_examen_s=cod_examen_g;

end if;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ficharesultado_consulta`
--

DROP PROCEDURE IF EXISTS `sp_ficharesultado_consulta`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ficharesultado_consulta`(in dni_e char(8))
BEGIN

declare est int;
declare hc char(6);

select e.estado into est from tbl_consultas c
inner join tbl_historiasclinicas h on c.cod_historiaclinica=h.cod_historiaclinica
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica
where p.dni_paciente=dni_e;


if (est=0) then
select p.nombres,p.apellidos,a.escuela,a.ciclo,p.sexo,
(year(curdate())-year(fecha_nacimiento))+if(DATE_FORMAT(curdate(),'%m-%d') < DATE_FORMAT(fecha_nacimiento,'%m-%d'), 0, -1) as Edad,
p.direccion,m.diagdef_medicina,o.diagdef_odontologia,s.diagdef_psicologia
from tbl_resultados_consultas r inner join tbl_consultas c on r.cod_consulta =c.cod_consulta
inner join tbl_medicinag m  on r.cod_diagmedicina=m.cod_diagmedicina
inner join tbl_odontologia o on r.cod_diagodontologia=o.cod_diagodontologia
inner join tbl_psicologia s on r.cod_diagpsicologia=s.cod_diagpsicologia
inner join tbl_historiasclinicas h on e.cod_historiaclinica=h.cod_historiaclinica
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica
where p.dni_paciente=dni_e;
end if;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ficharesultado_examen`
--

DROP PROCEDURE IF EXISTS `sp_ficharesultado_examen`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ficharesultado_examen`(in dni_e char(8))
BEGIN

declare est int;
declare hc char(6);

select e.estado into est from tbl_examenes e
inner join tbl_historiasclinicas h on e.cod_historiaclinica=h.cod_historiaclinica
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica
where p.dni_paciente=dni_e;


if (est=0) then
select p.nombres,p.apellidos,a.escuela,a.ciclo ,a.año_ingreso, p.sexo,
(year(curdate())-year(fecha_nacimiento))+if(DATE_FORMAT(curdate(),'%m-%d') < DATE_FORMAT(fecha_nacimiento,'%m-%d'), 0, -1) as Edad,
p.direccion,m.diagdef_medicina,o.diagdef_odontologia,
s.diagdef_psicologia,r.hemoglobina,r.peso,r.talla,r.presion
from tbl_resultados_examenes r inner join tbl_examenes e on r.cod_examen =e.cod_examen
inner join tbl_medicinag m  on r.cod_diagmedicina=m.cod_diagmedicina
inner join tbl_odontologia o on r.cod_diagodontologia=o.cod_diagodontologia
inner join tbl_psicologia s on r.cod_diagpsicologia=s.cod_diagpsicologia
inner join tbl_historiasclinicas h on e.cod_historiaclinica=h.cod_historiaclinica
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica
inner join tbl_pacientesalumnos a on p.dni_paciente=a.dni_paciente where p.dni_paciente=dni_e;
end if;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_generarhistoriapaciente_al`
--

DROP PROCEDURE IF EXISTS `sp_generarhistoriapaciente_al`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_generarhistoriapaciente_al`(in dni_paciente_e char(8),out cod_historia_s char(6))
BEGIN

declare cod_historia_g char(6);
declare h1 bool;
declare h2 bool;

select count(h.cod_historiaclinica) into h1 from tbl_historiasclinicas h
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica and p.dni_paciente=dni_paciente_e;

select count(dni_paciente) into h2 from tbl_pacientes where dni_paciente=dni_paciente_e;
if(h2=1 and h1=0 ) then
  SELECT CONCAT('HA',LPAD(ifnull(Max(SUBSTRING(cod_historiaclinica,3)),0)+1,4,'0')) into cod_historia_g
  FROM tbl_historiasclinicas;
  insert into tbl_historiasclinicas (cod_historiaclinica,fecha_emision)
  values(cod_historia_g,curdate());
  set cod_historia_s=cod_historia_g;

end if;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_generarhistoriapaciente_ex`
--

DROP PROCEDURE IF EXISTS `sp_generarhistoriapaciente_ex`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_generarhistoriapaciente_ex`(in dni_paciente_e char(8),out cod_historia_s char(6))
BEGIN

declare cod_historia_g char(6);
declare h1 bool;
declare h2 bool;

select count(h.cod_historiaclinica) into h1 from tbl_historiasclinicas h
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica and p.dni_paciente=dni_paciente_e;

select count(dni_paciente) into h2 from tbl_pacientes where dni_paciente=dni_paciente_e;

if(h1=0) then
    SELECT CONCAT('HE',LPAD(ifnull(Max(SUBSTRING(cod_historiaclinica,3)),0)+1,4,'0')) into cod_historia_g
    FROM tbl_historiasclinicas;
    insert into tbl_historiasclinicas (cod_historiaclinica,fecha_emision)
    values(cod_historia_g,curdate());
    set cod_historia_s=cod_historia_g;
end if;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarconsultashoy`
--

DROP PROCEDURE IF EXISTS `sp_listarconsultashoy`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarconsultashoy`()
BEGIN

select c.cod_consulta,h.cod_historiaclinica,p.nombres,p.apellidos,
c.estado from tbl_consultas c inner join tbl_historiasclinicas h on c.cod_historiaclinica=h.cod_historiaclinica
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica where c.fecha=curdate();

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarconsultas_atender`
--

DROP PROCEDURE IF EXISTS `sp_listarconsultas_atender`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarconsultas_atender`()
BEGIN

select c.cod_consulta,h.cod_historiaclinica,c.tipo_consulta,p.nombres,p.apellidos
from tbl_consultas c inner join tbl_historiasclinicas h on c.cod_historiaclinica=h.cod_historiaclinica
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica where c.fecha=curdate() and c.estado=1;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarconsulta_fecha`
--

DROP PROCEDURE IF EXISTS `sp_listarconsulta_fecha`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarconsulta_fecha`(in fecha_e date)
BEGIN

select c.*,p.nombres,p.apellidos
from tbl_consultas c inner join tbl_historiasclinicas h on c.cod_historiaclinica=h.cod_historiaclinica
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica and c.fecha=fecha_e;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarconsulta_paciente`
--

DROP PROCEDURE IF EXISTS `sp_listarconsulta_paciente`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarconsulta_paciente`(in dni_paciente_e char(8))
BEGIN

select p.cod_historiaclinica,c.cod_consulta,p.dni_paciente,p.nombres,p.apellidos,c.fecha,b.monto
from tbl_boletas b inner join tbl_consultas c  on b.cod_boleta=c.cod_boleta
inner join tbl_historiasclinicas h on c.cod_historiaclinica=h.cod_historiaclinica
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica
where p.dni_paciente=dni_paciente_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarexameneshoy`
--

DROP PROCEDURE IF EXISTS `sp_listarexameneshoy`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarexameneshoy`()
BEGIN
select e.cod_examen,h.cod_historiaclinica,p.nombres,p.apellidos,
e.estado from tbl_examenes e inner join tbl_historiasclinicas h on e.cod_historiaclinica=h.cod_historiaclinica
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica where e.fecha=curdate()
order by e.cod_examen;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarexamenes_atender`
--

DROP PROCEDURE IF EXISTS `sp_listarexamenes_atender`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarexamenes_atender`()
BEGIN
select e.cod_examen,h.cod_historiaclinica,p.nombres,p.apellidos
from tbl_examenes e inner join tbl_historiasclinicas h on e.cod_historiaclinica=h.cod_historiaclinica
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica where e.fecha=curdate() and e.estado=1;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarexamen_fecha`
--

DROP PROCEDURE IF EXISTS `sp_listarexamen_fecha`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarexamen_fecha`(in fecha_e date)
BEGIN

select e.*,concat(p.nombres,' ',p.apellidos) as nombres
from tbl_examenes e inner join tbl_historiasclinicas h on e.cod_historiaclinica=h.cod_historiaclinica
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica where e.fecha=fecha_e;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarexamen_paciente`
--

DROP PROCEDURE IF EXISTS `sp_listarexamen_paciente`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarexamen_paciente`(in dni_paciente_e char(8))
BEGIN

select e.cod_examen,h.cod_historiaclinica,p.dni_paciente,p.nombres,p.apellidos,e.fecha,b.cod_boleta,b.monto
from  tbl_boletas b inner join tbl_examenes e on b.cod_boleta=e.cod_boleta
inner join tbl_historiasclinicas h on e.cod_historiaclinica=h.cod_historiaclinica
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica
where p.dni_paciente=dni_paciente_e;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarhistoriales`
--

DROP PROCEDURE IF EXISTS `sp_listarhistoriales`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarhistoriales`()
BEGIN
select h.cod_historiaclinica,DATE_FORMAT(h.fecha_emision,'%d/%c/%Y') as fecha_emision2,h.fecha_emision,p.dni_paciente,p.nombres,p.apellidos from tbl_historiasclinicas h
inner join tbl_pacientes p on h.cod_historiaclinica=p.cod_historiaclinica order by h.cod_historiaclinica;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarpacientealumno`
--

DROP PROCEDURE IF EXISTS `sp_listarpacientealumno`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarpacientealumno`()
BEGIN
select p.dni_paciente,p.cod_historiaclinica,p.nombres,p.apellidos,p.sexo,p.ocupacion,p.procedencia,
DATE_FORMAT(p.fecha_nacimiento,'%d/%c/%Y') as fecha_nacimiento2,p.fecha_nacimiento,p.estado_civil,
p.direccion,p.telefono,pa.codigo_univ,pa.escuela,pa.año_ingreso,pa.ciclo from tbl_pacientesalumnos pa
inner join tbl_pacientes p on pa.dni_paciente=p.dni_paciente;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarpacientes`
--

DROP PROCEDURE IF EXISTS `sp_listarpacientes`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarpacientes`()
BEGIN
SELECT t.`dni_paciente`, t.`cod_historiaclinica`, t.`nombres`,
t.`apellidos`, t.`sexo`, t.`ocupacion`, t.`procedencia`,
DATE_FORMAT(t.`fecha_nacimiento`,'%d/%c/%Y') as fecha_nacimiento2,fecha_nacimiento, t.`estado_civil`, t.`direccion`,
 t.`telefono` FROM tbl_pacientes t where ocupacion !='ESTUDIANTE';
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarpagos`
--

DROP PROCEDURE IF EXISTS `sp_listarpagos`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarpagos`()
BEGIN
select * from tbl_boletas;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarpagos_consultas`
--

DROP PROCEDURE IF EXISTS `sp_listarpagos_consultas`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarpagos_consultas`()
BEGIN
select c.cod_consulta,c.tipo_consulta,p.nombres,p.apellidos,b.* from tbl_boletas b
inner join tbl_consultas c on c.cod_boleta=b.cod_boleta inner join tbl_historiasclinicas h
on c.cod_historiaclinica=h.cod_historiaclinica inner join tbl_pacientes p
on h.cod_historiaclinica=p.cod_historiaclinica;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarpagos_examenes`
--

DROP PROCEDURE IF EXISTS `sp_listarpagos_examenes`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarpagos_examenes`()
BEGIN
select e.cod_examen,p.nombres,p.apellidos,b.* from tbl_boletas b
inner join tbl_examenes e on b.cod_boleta=e.cod_boleta inner join tbl_historiasclinicas h
on e.cod_historiaclinica=h.cod_historiaclinica inner join tbl_pacientes p
on h.cod_historiaclinica=p.cod_historiaclinica;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarpersonal`
--

DROP PROCEDURE IF EXISTS `sp_listarpersonal`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarpersonal`()
BEGIN
select per.cod_personal,per.dni_personal,per.nombres,per.apellidos,per.sexo,DATE_FORMAT(per.fecha_nacimiento,'%d/%c/%Y') as fecha_nacimiento2,per.fecha_nacimiento,tp.nombre,us.nombre_usuario,per.estado
from tbl_personal per inner join tbl_tipo_personal tp on per.cod_tipo_personal=tp.cod_tipo_personal
inner join tbl_usuarios us on per.num_user=us.num_user;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listarresultadosxpaciente`
--

DROP PROCEDURE IF EXISTS `sp_listarresultadosxpaciente`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarresultadosxpaciente`(in dni_paciente_e char(8))
BEGIN

select h.cod_historiaclinica,concat(p.nombres,' ',p.apellidos) AS Paciente,m.diagdef_medicina as Diagnostico_Medico,o.diagdef_odontologia as Diagnostico_Odontologico,
s.diagdef_psicologia as Diagnostico_Psicologico,e.hemoglobina,e.peso,e.talla,e.presion
from tbl_examenes e inner join tbl_consultas c on e.cod_consulta =c.cod_consulta
inner join tbl_medicinag m  on m.cod_diagmedicina=e.cod_diagmedicina
inner join tbl_odontologia o on o.cod_diagodontologia=e.cod_diagodontologia
inner join tbl_psicologia s on s.cod_diagpsicologia=e.cod_diagpsicologia
inner join tbl_historiasclinicas h on c.cod_historiaclinica=h.cod_historiaclinica
inner join tbl_pacientes p on h.dni_paciente=p.dni_paciente
inner join tbl_pacientesalumnos a on p.dni_paciente=a.dni_paciente where a.dni_paciente=dni_paciente_e;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listartipo_personal`
--

DROP PROCEDURE IF EXISTS `sp_listartipo_personal`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listartipo_personal`()
BEGIN

select * from tbl_tipo_personal;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listartipo_user`
--

DROP PROCEDURE IF EXISTS `sp_listartipo_user`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listartipo_user`()
BEGIN
select * from tbl_tipo;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_afiliados`
--

DROP PROCEDURE IF EXISTS `sp_listar_afiliados`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_afiliados`()
BEGIN
select cod_historiaclinica,dni_paciente,nombres,apellidos,
sexo,ocupacion,telefono,procedencia,DATE_FORMAT(fecha_nacimiento,'%d/%c/%Y') as fecha_nacimiento2,fecha_nacimiento,estado_civil,direccion from tbl_pacientes
order by cod_historiaclinica;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_atender`
--

DROP PROCEDURE IF EXISTS `sp_listar_atender`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_atender`()
BEGIN

select p.nombres, p.apellidos, at.* from tbl_atencion_dia at
inner join tbl_examenes e on e.cod_examen=at.codigo where estado=1 order by numero;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_atender1`
--

DROP PROCEDURE IF EXISTS `sp_listar_atender1`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_atender1`()
BEGIN

select * from tbl_atencion_dia where estado=1 or estado=2 order by numero;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_examenes_xmes_año`
--

DROP PROCEDURE IF EXISTS `sp_listar_examenes_xmes_año`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_examenes_xmes_año`(in fech char(4))
BEGIN

select date_format(fecha,'%M') as mes,count(*) as examenes
from tbl_examenes
where year(fecha)=fech
group by month(fecha);

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_examenes_xmes_año_actual`
--

DROP PROCEDURE IF EXISTS `sp_listar_examenes_xmes_año_actual`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_examenes_xmes_año_actual`()
BEGIN

select date_format(fecha,'%M') as mes,count(*) as examenes
from tbl_examenes
where year(fecha)=year(curdate())
group by month(fecha);

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_imgreso_xaño`
--

DROP PROCEDURE IF EXISTS `sp_listar_imgreso_xaño`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_imgreso_xaño`()
BEGIN

select year(fecha)as año,sum(monto) as monto from tbl_boletas
group by year(fecha);

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_ingreso_xmes_año`
--

DROP PROCEDURE IF EXISTS `sp_listar_ingreso_xmes_año`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_ingreso_xmes_año`(in fech char(4))
BEGIN

select DATE_FORMAT(b.fecha,'%M') as mes,count(month(b.fecha)) as cant_bol,
sum(b.monto) as monto
from tbl_boletas b
where year(b.fecha)=fech
group by month(b.fecha);

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_ingreso_xmes_año_actual`
--

DROP PROCEDURE IF EXISTS `sp_listar_ingreso_xmes_año_actual`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_ingreso_xmes_año_actual`()
BEGIN

select DATE_FORMAT(b.fecha,'%M') as mes,count(month(b.fecha)) as cant_bol,
sum(b.monto) as monto
from tbl_boletas b
where year(b.fecha)=year(curdate())
group by month(b.fecha);

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_pacientes_atender`
--

DROP PROCEDURE IF EXISTS `sp_listar_pacientes_atender`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_pacientes_atender`()
BEGIN

select a.numero,a.codigo, p.cod_historiaclinica,concat(p.nombres,' ',p.apellidos) as nombres
 from tbl_atencion_dia a
inner join tbl_pacientes p
on a.cod_historiaclinica=p.cod_historiaclinica where a.estado=1
order by numero ;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listar_pagos_fecha`
--

DROP PROCEDURE IF EXISTS `sp_listar_pagos_fecha`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_pagos_fecha`(IN fecha1 date, IN fecha2 date)
BEGIN

select substring(cod_boleta,1,4) as cod_boleta,sum(monto) as monto from tbl_boletas
where fecha between fecha1 and fecha2
group by substring(cod_boleta,1,4);

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_pagos_fechas`
--

DROP PROCEDURE IF EXISTS `sp_pagos_fechas`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pagos_fechas`()
BEGIN
select  substring(b.cod_boleta,1,4) as h1, count(b.cod_boleta) as cant,count(e.cod_examen) as n, sum(b.monto) as monto, e.fecha
from tbl_boletas b  inner join tbl_examenes e on b.cod_boleta=e.cod_boleta group by h1='0001', h1='0004',e.fecha;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_pagos_fechascon`
--

DROP PROCEDURE IF EXISTS `sp_pagos_fechascon`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pagos_fechascon`()
BEGIN
select  substring(b.cod_boleta,1,4) as h1, count(b.cod_boleta) as cant,count(c.cod_consulta) as n, sum(b.monto) as monto,c.fecha
from tbl_boletas b  inner join tbl_consultas c on b.cod_boleta=c.cod_boleta group by h1='0001', h1='0004',c.fecha;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_pago_dia`
--

DROP PROCEDURE IF EXISTS `sp_pago_dia`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pago_dia`()
BEGIN

select substring(b.cod_boleta,1,4) as h1, count(b.cod_boleta) as cant,count(e.cod_examen) as n, sum(b.monto) as monto from tbl_boletas b  inner join tbl_examenes e on b.cod_boleta=e.cod_boleta
group by h1='0001', h1='0004',e.fecha=curdate();

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_pago_diacons`
--

DROP PROCEDURE IF EXISTS `sp_pago_diacons`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pago_diacons`()
BEGIN

select substring(b.cod_boleta,1,4) as h1, count(b.cod_boleta) as cant,count(c.cod_consulta) as n, sum(b.monto) as monto from tbl_boletas b  inner join tbl_consultas c on b.cod_boleta=c.cod_boleta
group by h1='0001', h1='0004',c.fecha=curdate();

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrarpaciente`
--

DROP PROCEDURE IF EXISTS `sp_registrarpaciente`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarpaciente`(in dni_paciente_e char(8),
in nombres_e varchar(30),in apellidos_e varchar(40),in sexo_e char(1),in ocupacion_e varchar(30),
in procedencia_e varchar(40),in fecha_nacimiento_e date ,in estado_civil_e varchar(10),
in direccion_e varchar(50),in telefono_e varchar(9))
BEGIN

declare h1 bool;
select count(dni_paciente) into h1 from tbl_pacientes where dni_paciente=dni_paciente_e;

if(h1=0) then
  insert into tbl_pacientes (dni_paciente,cod_historiaclinica,nombres,apellidos,sexo,ocupacion,procedencia,fecha_nacimiento,
  estado_civil,direccion,telefono)
  values(dni_paciente_e,'',upper(nombres_e),upper(apellidos_e),upper(sexo_e),upper(ocupacion_e),
  upper(procedencia_e),fecha_nacimiento_e,upper(estado_civil_e),upper(direccion_e),telefono_e);

  CALL sp_generarhistoriapaciente_ex(dni_paciente_e,@s);

  update tbl_pacientes set cod_historiaclinica=@s where dni_paciente=dni_paciente_e;

end if;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrarpacientealumno`
--

DROP PROCEDURE IF EXISTS `sp_registrarpacientealumno`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarpacientealumno`(in dni_paciente_e char(8),
in nombres_e varchar(30),in apellidos_e varchar(40),in sexo_e char(1),
in procedencia_e varchar(40),in fecha_nacimiento_e date ,in estado_civil_e varchar(10),
in direccion_e varchar(50),in telefono_e varchar(9), in escuela_e varchar(20), in año_ingreso_e int,
in ciclo_e char(4),in codigo_univ_e char(10))
BEGIN

declare h1 bool;
select count(dni_paciente) into h1 from tbl_pacientes where dni_paciente=dni_paciente_e;


if(h1=0) then
  insert into tbl_pacientes (dni_paciente,cod_historiaclinica,nombres,apellidos,sexo,ocupacion,procedencia,fecha_nacimiento,
  estado_civil,direccion,telefono)
  values(dni_paciente_e,'',upper(nombres_e),upper(apellidos_e),upper(sexo_e),'ESTUDIANTE',
  upper(procedencia_e),fecha_nacimiento_e,upper(estado_civil_e),upper(direccion_e),telefono_e);

  if(dni_paciente_e is not null) then
    insert into tbl_pacientesalumnos (dni_paciente,codigo_univ,escuela,año_ingreso,ciclo)
    values(dni_paciente_e,codigo_univ_e,upper(escuela_e),año_ingreso_e,upper(ciclo_e));

    CALL sp_generarhistoriapaciente_al(dni_paciente_e,@s);

    update tbl_pacientes set cod_historiaclinica=@s where dni_paciente=dni_paciente_e;

   end if;

  end if;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrarpago`
--

DROP PROCEDURE IF EXISTS `sp_registrarpago`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarpago`(in cod_boleta_e char(12),in monto_e double,out codigo char(12))
BEGIN
declare n int;
select count(cod_boleta) into n from tbl_boletas where cod_boleta=cod_boleta_e;
if(n=0) then
  insert into tbl_boletas(cod_boleta,fecha,monto) values(cod_boleta_e,curdate(),monto_e);
  set codigo=cod_boleta_e;
end if;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrarpersonal`
--

DROP PROCEDURE IF EXISTS `sp_registrarpersonal`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarpersonal`(IN nom_e varchar(20), IN apel_e  varchar(30),
IN sexo_e char(1),IN fecnac_e date,IN tipo_e int, IN dni_trabajador_e char(8),in tipo_user int, out codigo_trab char(4))
BEGIN

declare codigo_g char(4);
declare h1 bool;

select count(*) into h1 from tbl_personal where dni_personal=dni_trabajador_e;
if(h1=0) then
  SELECT CONCAT('P',LPAD(ifnull(Max(SUBSTRING(cod_personal,2)),0)+1,3,'0')) into codigo_g  FROM tbl_personal;


  INSERT INTO tbl_personal (cod_personal,nombres, apellidos,
  sexo,fecha_nacimiento,cod_tipo_personal,dni_personal,num_user,estado)
  VALUES (codigo_g,upper(nom_e), upper(apel_e),
  upper(sexo_e),fecnac_e,tipo_e,dni_trabajador_e,'',1);

  call sp_registrar_usuario(codigo_g,'123456',tipo_user,@s);

  update tbl_personal set num_user=@s where dni_personal=dni_trabajador_e;

  set codigo_trab=codigo_g;

end if;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_hemoglobina_ex`
--

DROP PROCEDURE IF EXISTS `sp_registrar_hemoglobina_ex`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_hemoglobina_ex`(in dni_e char(8),in hemoglobina_e varchar(6))
BEGIN

declare cod_ex char(6);

select  e.cod_examen into cod_ex from tbl_examenes e inner join tbl_historiasclinicas h
on e.cod_historiaclinica=h.cod_historiaclinica inner join tbl_pacientes p
on h.cod_historiaclinica=p.cod_historiaclinica where p.dni_paciente=dni_e and e.estado=2 and e.fecha=curdate();

update tbl_resultados_examenes set hemoglobina=hemoglobina_e where cod_examen=cod_ex;


END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_triaje_ex`
--

DROP PROCEDURE IF EXISTS `sp_registrar_triaje_ex`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_triaje_ex`(in dni_e char(8),in peso_e varchar(6),in talla_e varchar(6),in presion_e varchar(6))
BEGIN

declare cod_ex char(6);

select  e.cod_examen into cod_ex from tbl_examenes e inner join tbl_historiasclinicas h
on e.cod_historiaclinica=h.cod_historiaclinica inner join tbl_pacientes p
on h.cod_historiaclinica=p.cod_historiaclinica where p.dni_paciente=dni_e and e.estado=2 and e.fecha=curdate();

update tbl_resultados_examenes set peso=peso_e, talla=talla_e, presion=presion_e
where cod_examen=cod_ex;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrar_usuario`
--

DROP PROCEDURE IF EXISTS `sp_registrar_usuario`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_usuario`(in cod_personal_e char(4),in clave_e varchar(20),in tipo_e int,out numero int)
BEGIN
declare numero_g int;
declare usuario_g varchar(20);

SELECT (ifnull(Max(num_user),0)+1) into numero_g  FROM tbl_usuarios;
SELECT CONCAT(SUBSTRING(nombres,1,1),SUBSTRING(apellidos,1,locate(' ',apellidos)-1),  SUBSTRING(apellidos,locate(' ',apellidos)+1,1)   ) INTO usuario_g FROM tbl_personal where cod_personal=cod_personal_e;

insert into tbl_usuarios (num_user,nombre_usuario,clave,cod_tipo)
values(numero_g,lower(usuario_g),lower(clave_e),tipo_e);


set numero=numero_g;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_validar_acceso`
--

DROP PROCEDURE IF EXISTS `sp_validar_acceso`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validar_acceso`(in usuario_e varchar(20),
in contra_e text)
BEGIN


select u.num_user,u.nombre_usuario as nombre_usu,u.clave,u.cod_tipo,t.descripcion,
tp.cod_tipo_personal as cod_tipo_p,tp.nombre as nombre_p,
concat(p.nombres,' ',p.apellidos) as personal
from tbl_usuarios u
inner join tbl_tipo t on u.cod_tipo=t.cod_tipo
inner join tbl_personal p on p.num_user=u.num_user
inner join tbl_tipo_personal tp on p.cod_tipo_personal=tp.cod_tipo_personal
where nombre_usuario=lower(usuario_e)
and clave=contra_e;

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
