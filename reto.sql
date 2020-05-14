-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-05-2020 a las 12:39:32
-- Versión del servidor: 8.0.17
-- Versión de PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `reto`
--
CREATE DATABASE IF NOT EXISTS `reto` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `reto`;

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_alta_url` (IN `ancho` INT, IN `url_larga` VARCHAR(128), OUT `id_corto` VARCHAR(8))  BEGIN
	SET id_corto = left(uuid(),ancho);
	INSERT INTO urls VALUES(null,url_larga,id_corto,0);
	END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `id` int(12) NOT NULL,
  `fechaInicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fechaFin` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE `transaccion` (
  `ticket` int(12) NOT NULL,
  `url` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `urls`
--

CREATE TABLE `urls` (
  `id` int(120) NOT NULL,
  `url` varchar(128) COLLATE utf8_spanish2_ci NOT NULL,
  `shortUrl` varchar(12) COLLATE utf8_spanish2_ci NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `urls`
--

INSERT INTO `urls` (`id`, `url`, `shortUrl`, `status`) VALUES
(1, 'pepe', 'abcder', 1),
(2, 'pepeun1234543', '5a77d952-8fc', 1),
(3, 'url_larga', '9437', 0),
(4, 'url_larga2', 'df5b', 1),
(5, 'some_url_larga', 'cafc', 0),
(6, 'watch?ajhdkjashd', 'dff5', 0),
(7, 'url_larga_3', '3915', 1),
(8, 'url_larga_4', '9edc', 1),
(9, 'url_larga_5', 'd77a', 0),
(10, 'otra_url_larga_XD', '459c', 0),
(11, 'url_larga_6', '740d', 0),
(12, 'url_larga_7', 'a49e', 1),
(13, 'lkmwatch?dlm123elsws', '2a35', 0),
(14, 'tch?dlm123elsws', 'f821', 0),
(15, 'mdlm123elsws234', 'b626', 0),
(16, 'watch?dlm123elsws457', '75b4', 0),
(17, 'watch?dlm123elsws45', 'd215', 0),
(18, '?dlm2123elsws', '2f2b', 1),
(19, 'search?dlm123elsws', '67fb', 0),
(20, 'watch?dlm12sd3elsws', '69cb', 0),
(21, 'watch?asdskdhasdh', '7be6', 0),
(22, 'some_url', '986832408810', 0),
(24, 'prueba2', '76c8', 0),
(28, 'una_url_muy_larga', 'ebfe', 0),
(29, 'una_tremenda_url_larga', 'a1f2', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `urls`
--
ALTER TABLE `urls`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Long_urls_unique` (`url`),
  ADD UNIQUE KEY `pruebaAutomatico` (`shortUrl`(8));

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(12) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `urls`
--
ALTER TABLE `urls`
  MODIFY `id` int(120) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
