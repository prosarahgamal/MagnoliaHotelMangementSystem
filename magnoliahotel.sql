-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 27, 2019 at 12:36 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `magnoliahotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` int(100) NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `salary` double(10,2) NOT NULL,
  `ismanager` int(5) DEFAULT NULL,
  `bio` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `profilepicture` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isdeactivated` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `username`, `password`, `firstname`, `lastname`, `email`, `phone`, `address`, `salary`, `ismanager`, `bio`, `profilepicture`, `isdeactivated`) VALUES
(1, 'admin', 'admin', 'admin', 'admin', 'admin', '123', 'admin', 123.12, NULL, NULL, NULL, NULL),
(2, 'owner', 'owner', 'owner', 'owner', 'owner@gmail.com', '0123456789', 'address', 10000.00, 1, 'null', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE `cars` (
  `id` int(10) NOT NULL,
  `type` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `cost` double(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`id`, `type`, `cost`) VALUES
(1, 'bmw', 100.00),
(2, 'infiniti', 90.00),
(3, 'audi', 110.00),
(4, 'mercedes', 150.00),
(5, 'nissan', 120.00),
(6, 'porsche', 130.00),
(7, 'toyota', 80.00);

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `id` int(10) NOT NULL,
  `type` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `cost` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`id`, `type`, `cost`) VALUES
(1, 'breakfast', 50.00),
(2, 'breakfast, lunch and dinner', 150.00),
(3, 'breakfast and dinner', 150.00);

-- --------------------------------------------------------

--
-- Table structure for table `guests`
--

CREATE TABLE `guests` (
  `id` int(100) NOT NULL,
  `roomid` int(100) NOT NULL,
  `firstname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `middlename` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `idcard` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `numofdays` int(10) NOT NULL,
  `gender` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `arrivedate` date NOT NULL,
  `checkoutdate` date DEFAULT NULL,
  `foodid` int(10) NOT NULL,
  `carid` int(10) NOT NULL,
  `privatedriver` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `guests`
--

INSERT INTO `guests` (`id`, `roomid`, `firstname`, `middlename`, `lastname`, `idcard`, `numofdays`, `gender`, `email`, `phone`, `status`, `address`, `arrivedate`, `checkoutdate`, `foodid`, `carid`, `privatedriver`) VALUES
(3, 1, 'sara', 'gamal', 'eisa', '123456789653', 6, 'female', 'sara@gmail.com', '1234567896', 'Single', 'cairo egypt', '2019-04-27', '2019-04-27', 3, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `id` int(100) NOT NULL,
  `type` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `view` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `issmokingavailable` tinyint(1) NOT NULL,
  `isreserved` tinyint(1) NOT NULL,
  `rate` double(2,2) NOT NULL,
  `costpernight` double(5,2) NOT NULL,
  `timesofreservation` int(10) NOT NULL,
  `lastcheckin` date NOT NULL,
  `photo` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isdeactivated` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`id`, `type`, `view`, `issmokingavailable`, `isreserved`, `rate`, `costpernight`, `timesofreservation`, `lastcheckin`, `photo`, `isdeactivated`) VALUES
(1, 'single', 'green', 0, 1, 0.99, 25.50, 1, '2019-04-27', NULL, 0),
(2, 'single', 'green', 0, 0, 0.99, 25.50, 0, '2019-04-01', NULL, 0),
(3, 'single', 'green', 0, 0, 0.99, 25.50, 0, '2019-04-01', NULL, 0),
(4, 'single', 'green', 0, 0, 0.99, 25.50, 0, '2019-04-01', NULL, 0),
(5, 'single', 'green', 0, 0, 0.99, 25.50, 0, '2019-04-01', NULL, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `guests`
--
ALTER TABLE `guests`
  ADD PRIMARY KEY (`id`),
  ADD KEY `roomidFK` (`roomid`),
  ADD KEY `foodidFK` (`foodid`),
  ADD KEY `caridFK` (`carid`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `guests`
--
ALTER TABLE `guests`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `guests`
--
ALTER TABLE `guests`
  ADD CONSTRAINT `caridFK` FOREIGN KEY (`carid`) REFERENCES `cars` (`id`),
  ADD CONSTRAINT `foodidFK` FOREIGN KEY (`foodid`) REFERENCES `food` (`id`),
  ADD CONSTRAINT `roomidFK` FOREIGN KEY (`roomid`) REFERENCES `rooms` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
