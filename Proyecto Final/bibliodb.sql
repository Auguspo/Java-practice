-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-11-2023 a las 17:02:43
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
-- Base de datos: `bibliodb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE `ejemplar` (
  `id` int(11) NOT NULL,
  `libro_isbn` varchar(20) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`id`, `libro_isbn`, `estado`, `cantidad`) VALUES
(1, 'ISBN001', 'Disponible', 5),
(2, 'ISBN002', 'Disponible', 3),
(3, 'ISBN003', 'Prestado', 2),
(4, 'ISBN004', 'Disponible', 8),
(5, 'ISBN005', 'Prestado', 1),
(6, 'ISBN006', 'Disponible', 4),
(7, 'ISBN007', 'Disponible', 6),
(8, 'ISBN008', 'Prestado', 3),
(9, 'ISBN009', 'Disponible', 7),
(10, 'ISBN010', 'Disponible', 2),
(11, 'ISBN011', 'Prestado', 1),
(12, 'ISBN012', 'Disponible', 5),
(13, 'ISBN013', 'Prestado', 2),
(14, 'ISBN014', 'Disponible', 3),
(15, 'ISBN015', 'Prestado', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lector`
--

CREATE TABLE `lector` (
  `DNI` varchar(20) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `domicilio` varchar(200) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lector`
--

INSERT INTO `lector` (`DNI`, `nombre`, `domicilio`, `telefono`, `activo`) VALUES
('101010', 'Pedro Hernández', 'Avenida J #2223', '555-8901', 0),
('111111', 'Ana Rodríguez', 'Calle A #123', '555-1234', 1),
('1111111', 'Marta Jiménez', 'Calle K #2425', '555-2345', 1),
('121212', 'Ricardo Torres', 'Avenida L #2627', '555-6789', 0),
('131313', 'Elena Ruiz', 'Calle M #2829', '555-0123', 1),
('141414', 'Francisco Castro', 'Avenida N #3031', '555-4567', 1),
('151515', 'Isabel Soto', 'Calle O #3233', '555-8901', 0),
('222222', 'Juan Pérez', 'Avenida B #456', '555-5678', 1),
('333333', 'María García', 'Calle C #789', '555-9012', 0),
('444444', 'Luis Martínez', 'Avenida D #1011', '555-3456', 1),
('555555', 'Laura Fernández', 'Calle E #1213', '555-7890', 0),
('666666', 'Carlos Sánchez', 'Avenida F #1415', '555-2345', 1),
('777777', 'Lucía Gómez', 'Calle G #1617', '555-6789', 1),
('888888', 'Jorge Vargas', 'Avenida H #1819', '555-0123', 0),
('999999', 'Silvia López', 'Calle I #2021', '555-4567', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `ISBN` varchar(20) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `editorial` varchar(50) DEFAULT NULL,
  `autor` varchar(100) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`ISBN`, `nombre`, `genero`, `editorial`, `autor`, `estado`) VALUES
('ISBN001', 'La Sombra del Viento', 'Literatura', 'Penguin Random House', 'Carlos Ruiz Zafón', 'Disponible'),
('ISBN002', 'Cien años de soledad', 'Literatura', 'Gabriel García Márquez', 'Editorial Sudamericana', 'Disponible'),
('ISBN003', 'The Hitchhiker\'s Guide to the Galaxy', 'Ciencia Ficción', 'Douglas Adams', 'Random House', 'Disponible'),
('ISBN004', '1984', 'Ciencia Ficción', 'George Orwell', 'Secker & Warburg', 'Prestado'),
('ISBN005', 'To Kill a Mockingbird', 'Novela', 'Harper Lee', 'J.B. Lippincott & Co.', 'Disponible'),
('ISBN006', 'Harry Potter and the Philosopher\'s Stone', 'Fantasía', 'J.K. Rowling', 'Bloomsbury', 'Disponible'),
('ISBN007', 'The Great Gatsby', 'Novela', 'F. Scott Fitzgerald', 'Charles Scribner\'s Sons', 'Disponible'),
('ISBN008', 'Pride and Prejudice', 'Romance', 'Jane Austen', 'T. Egerton', 'Prestado'),
('ISBN009', 'The Catcher in the Rye', 'Novela', 'J.D. Salinger', 'Little, Brown and Company', 'Disponible'),
('ISBN010', 'The Lord of the Rings', 'Fantasía', 'J.R.R. Tolkien', 'George Allen & Unwin', 'Disponible'),
('ISBN011', 'Crime and Punishment', 'Novela', 'Fyodor Dostoevsky', 'The Russian Messenger', 'Prestado'),
('ISBN012', 'Moby-Dick', 'Aventura', 'Herman Melville', 'Harper & Brothers', 'Disponible'),
('ISBN013', 'One Hundred Years of Solitude', 'Literatura', 'Gabriel García Márquez', 'Harper & Row', 'Disponible'),
('ISBN014', 'The Hobbit', 'Fantasía', 'J.R.R. Tolkien', 'George Allen & Unwin', 'Prestado'),
('ISBN015', 'Brave New World', 'Ciencia Ficción', 'Aldous Huxley', 'Chatto & Windus', 'Disponible'),
('ISBN016', 'The Da Vinci Code', 'Misterio', 'Dan Brown', 'Doubleday', 'Prestado'),
('ISBN017', 'The Shining', 'Terror', 'Stephen King', 'Doubleday', 'Disponible'),
('ISBN018', 'The Hunger Games', 'Ciencia Ficción', 'Suzanne Collins', 'Scholastic Corporation', 'Disponible'),
('ISBN019', 'The Alchemist', 'Ficción', 'Paulo Coelho', 'HarperOne', 'Prestado'),
('ISBN020', 'The Chronicles of Narnia', 'Fantasía', 'C.S. Lewis', 'Geoffrey Bles', 'Disponible'),
('ISBN021', 'The Road', 'Ficción', 'Cormac McCarthy', 'Alfred A. Knopf', 'Prestado'),
('ISBN022', 'The Picture of Dorian Gray', 'Novela', 'Oscar Wilde', 'Ward, Lock and Company', 'Disponible'),
('ISBN023', 'The Girl with the Dragon Tattoo', 'Misterio', 'Stieg Larsson', 'Norstedts Förlag', 'Disponible'),
('ISBN024', 'The Odyssey', 'Épica', 'Homer', 'Varios', 'Prestado'),
('ISBN025', 'The Divine Comedy', 'Poema Épico', 'Dante Alighieri', 'Various', 'Disponible'),
('ISBN026', 'The Adventures of Sherlock Holmes', 'Detective', 'Arthur Conan Doyle', 'George Newnes', 'Disponible'),
('ISBN027', 'The War of the Worlds', 'Ciencia Ficción', 'H.G. Wells', 'Pearson\'s Magazine', 'Prestado'),
('ISBN028', 'The Grapes of Wrath', 'Ficción', 'John Steinbeck', 'The Viking Press', 'Disponible'),
('ISBN029', 'The Old Man and the Sea', 'Novela', 'Ernest Hemingway', 'Charles Scribner\'s Sons', 'Disponible'),
('ISBN030', 'Les Misérables', 'Novela', 'Victor Hugo', 'A. Lacroix, Verboeckhoven & Cie.', 'Prestado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `id` int(11) NOT NULL,
  `lector_dni` varchar(20) DEFAULT NULL,
  `ejemplar_id` int(11) DEFAULT NULL,
  `fecha_prestamo` date DEFAULT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`id`, `lector_dni`, `ejemplar_id`, `fecha_prestamo`, `fecha_devolucion`, `estado`) VALUES
(1, '111111', 1, '2023-01-01', '2023-01-10', 'Devuelto'),
(2, '111111', 2, '2023-02-01', '2023-02-15', 'Devuelto'),
(3, '222222', 3, '2023-03-01', '2023-03-10', 'Pendiente'),
(4, '333333', 4, '2023-04-01', '2023-04-12', 'Devuelto'),
(5, '444444', 5, '2023-05-01', '2023-05-20', 'Pendiente'),
(6, '555555', 6, '2023-06-01', '2023-06-08', 'Devuelto'),
(7, '666666', 7, '2023-07-01', '2023-07-14', 'Pendiente'),
(8, '777777', 8, '2023-08-01', '2023-08-18', 'Devuelto'),
(9, '888888', 9, '2023-09-01', '2023-09-24', 'Pendiente'),
(10, '999999', 10, '2023-10-01', '2023-10-05', 'Devuelto'),
(11, '101010', 11, '2023-11-01', '2023-11-11', 'Pendiente'),
(12, '1111111', 12, '2023-12-01', '2023-12-16', 'Devuelto'),
(13, '121212', 13, '2024-01-01', '2024-01-09', 'Pendiente'),
(14, '131313', 14, '2024-02-01', '2024-02-22', 'Devuelto'),
(15, '141414', 15, '2024-03-01', '2024-03-07', 'Pendiente');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `libro_isbn` (`libro_isbn`);

--
-- Indices de la tabla `lector`
--
ALTER TABLE `lector`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `lector_dni` (`lector_dni`),
  ADD KEY `ejemplar_id` (`ejemplar_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD CONSTRAINT `ejemplar_ibfk_1` FOREIGN KEY (`libro_isbn`) REFERENCES `libro` (`ISBN`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`lector_dni`) REFERENCES `lector` (`DNI`),
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`ejemplar_id`) REFERENCES `ejemplar` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
