-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 07:04 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gadgetbadget`
--

-- --------------------------------------------------------

--
-- Table structure for table `buyers`
--

CREATE TABLE `buyers` (
  `bId` int(30) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `pnumber` varchar(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buyers`
--

INSERT INTO `buyers` (`bId`, `fname`, `lname`, `pnumber`, `email`, `password`) VALUES
(3, 'bs', 'we', '233321', 'sd@gmail.com', 'roror'),
(5, 'kopopk', 'ssf', '1456', 'wes@gmail.com', 'yuyeu'),
(6, 'rfs', 'sf', '432424', 'dssd', 'eghhfh');

-- --------------------------------------------------------

--
-- Table structure for table `funder`
--

CREATE TABLE `funder` (
  `fId` int(20) NOT NULL,
  `funderName` varchar(30) NOT NULL,
  `funderPnumber` varchar(11) NOT NULL,
  `projID` int(6) NOT NULL,
  `fundAmount` int(30) NOT NULL,
  `description` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `funder`
--

INSERT INTO `funder` (`fId`, `funderName`, `funderPnumber`, `projID`, `fundAmount`, `description`) VALUES
(1, 'funder1', '0778945612', 3, 10000, 'this fund is for innovative AI project'),
(2, 'funder2', '0778943422', 2, 5000, 'this fund is for innovative maven project');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `id` int(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `product_name` varchar(20) DEFAULT NULL,
  `product_id` varchar(20) DEFAULT NULL,
  `amount` varchar(20) DEFAULT NULL,
  `payment_type` varchar(20) DEFAULT NULL,
  `card_no` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`id`, `name`, `product_name`, `product_id`, `amount`, `payment_type`, `card_no`) VALUES
(103, 'kan', 'ment', '34101', '340', 'cash', '354340'),
(104, 'Nive', 'ment', '34105', '34034', 'Debit', '354380'),
(105, 'Nive', 'School', '34102', '3402', 'DebitCard', '35434220'),
(106, 'Nive', 'ment', '34105', '34034', 'Debit', '354380');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `projID` int(6) NOT NULL,
  `projName` varchar(25) NOT NULL,
  `description` varchar(100) NOT NULL,
  `area` varchar(25) NOT NULL,
  `resID` varchar(25) NOT NULL,
  `resName` varchar(25) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`projID`, `projName`, `description`, `area`, `resID`, `resName`, `price`) VALUES
(2, 'AI update', 'Food update', 'IT', 'update', 'Amal', 15000.5),
(9, 'New AI PC', 'Research on AI', 'Computer Science', 'res177', 'sadun', 54515.5);

-- --------------------------------------------------------

--
-- Table structure for table `researcher_details`
--

CREATE TABLE `researcher_details` (
  `id` int(100) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `researcher_details`
--

INSERT INTO `researcher_details` (`id`, `firstname`, `lastname`, `gender`, `email`, `password`) VALUES
(11111, 'Roy', 'John', 'Male', 'johnroy@gmail.com', '12345'),
(11112, 'Kamal', 'Singh', 'Male', 'kamalsingh@gmail.com', '12346');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buyers`
--
ALTER TABLE `buyers`
  ADD PRIMARY KEY (`bId`);

--
-- Indexes for table `funder`
--
ALTER TABLE `funder`
  ADD PRIMARY KEY (`fId`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`projID`);

--
-- Indexes for table `researcher_details`
--
ALTER TABLE `researcher_details`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buyers`
--
ALTER TABLE `buyers`
  MODIFY `bId` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `funder`
--
ALTER TABLE `funder`
  MODIFY `fId` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=107;

--
-- AUTO_INCREMENT for table `researcher_details`
--
ALTER TABLE `researcher_details`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11115;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
