-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-11-2023 a las 20:52:34
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `universidadejemplo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL,
  `dni` int(10) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `activo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `activo`) VALUES
(4, 0, 'López', 'Juan', '1990-05-15', 1),
(5, 0, 'Gómez', 'María', '1992-09-22', 0),
(6, 0, 'Martínez', 'Carlos', '1995-03-10', 1),
(7, 0, 'Rodríguez', 'Laura', '1988-11-30', 0),
(8, 0, 'Pérez', 'Andrés', '1997-07-14', 1),
(9, 0, 'González', 'Ana', '1993-02-05', 0),
(10, 0, 'Fernández', 'Pedro', '1994-06-20', 1),
(11, 0, 'Díaz', 'Sofía', '1991-12-03', 0),
(12, 0, 'López', 'Miguel', '1996-08-25', 1),
(13, 0, 'Sánchez', 'Elena', '1989-04-17', 0),
(14, 0, 'Romero', 'Lucas', '1998-01-28', 1),
(15, 0, 'Gómez', 'Carla', '1990-07-09', 0),
(16, 0, 'Martínez', 'Daniel', '1992-03-18', 1),
(17, 0, 'Rodríguez', 'Luis', '1994-10-12', 0),
(18, 0, 'Pérez', 'Silvia', '1997-06-08', 1),
(19, 0, 'González', 'Javier', '1987-09-05', 0),
(20, 0, 'Fernández', 'Lorena', '1991-11-26', 1),
(21, 0, 'Díaz', 'Manuel', '1995-05-01', 0),
(22, 0, 'López', 'Carmen', '1988-12-14', 1),
(23, 0, 'Sánchez', 'Ricardo', '1993-10-29', 0),
(24, 0, 'Romero', 'Paula', '1996-02-21', 1),
(25, 0, 'Gómez', 'Felipe', '1998-04-06', 0),
(26, 0, 'Martínez', 'Alicia', '1990-06-16', 1),
(27, 0, 'Rodríguez', 'Diego', '1994-08-08', 0),
(28, 0, 'Pérez', 'Natalia', '1992-01-25', 1),
(29, 0, 'González', 'Rosa', '1997-03-30', 0),
(30, 0, 'Fernández', 'Juan', '1989-09-03', 1),
(31, 0, 'Díaz', 'Isabel', '1993-04-07', 0),
(32, 0, 'López', 'Pablo', '1995-01-19', 1),
(33, 0, 'Sánchez', 'Lourdes', '1991-07-02', 0),
(34, 0, 'Romero', 'Eduardo', '1996-05-26', 1),
(35, 0, 'Gómez', 'Marcela', '1998-11-15', 0),
(36, 0, 'Martínez', 'Hugo', '1992-08-09', 1),
(37, 0, 'Rodríguez', 'Liliana', '1990-03-12', 0),
(38, 0, 'Pérez', 'Roberto', '1988-12-30', 1),
(39, 0, 'González', 'Cecilia', '1994-04-18', 0),
(40, 0, 'Fernández', 'Federico', '1997-02-23', 1),
(41, 0, 'Díaz', 'Marta', '1993-06-14', 0),
(42, 0, 'López', 'Rafael', '1995-09-28', 1),
(43, 0, 'Sánchez', 'Victoria', '1990-11-08', 0),
(44, 0, 'Romero', 'Jorge', '1992-12-22', 1),
(45, 0, 'Gómez', 'Alejandra', '1989-08-25', 0),
(46, 0, 'Martínez', 'Samuel', '1994-01-10', 1),
(47, 0, 'Rodríguez', 'Gloria', '1996-07-05', 0),
(48, 0, 'Pérez', 'Ramón', '1998-03-02', 1),
(49, 0, 'González', 'Mariana', '1991-04-19', 0),
(50, 0, 'Fernández', 'Eva', '1993-11-27', 1),
(51, 0, 'Díaz', 'Roberto', '1988-06-08', 0),
(52, 0, 'López', 'Clara', '1995-10-14', 1),
(53, 0, 'Sánchez', 'Antonio', '1997-09-06', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `idInscripto` int(11) NOT NULL,
  `nota` tinyint(11) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`idInscripto`, `nota`, `idAlumno`, `idMateria`) VALUES
(131, 85, 4, 7),
(132, 72, 5, 8),
(133, 94, 6, 9),
(134, 65, 7, 10),
(135, 78, 8, 11),
(136, 91, 9, 12),
(137, 89, 10, 13),
(138, 76, 11, 14),
(139, 93, 12, 15),
(140, 80, 13, 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `idMateria` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `año` int(11) NOT NULL,
  `activo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`idMateria`, `nombre`, `año`, `activo`) VALUES
(7, 'Matemáticas', 1, 1),
(8, 'Ciencias Sociales', 2, 0),
(9, 'Lengua y Literatura', 3, 1),
(10, 'Ciencias Naturales', 4, 0),
(11, 'Historia', 5, 1),
(12, 'Educación Física', 6, 0),
(13, 'Arte', 1, 1),
(14, 'Música', 2, 0),
(15, 'Inglés', 3, 1),
(16, 'Tecnología', 4, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idAlumno`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`idInscripto`),
  ADD UNIQUE KEY `idAlumno` (`idAlumno`),
  ADD UNIQUE KEY `idMateria` (`idMateria`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idMateria`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `idInscripto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=141;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`),
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
