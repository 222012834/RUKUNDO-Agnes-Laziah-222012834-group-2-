-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 19, 2024 at 10:47 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `furnituremanagementsystems`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) NOT NULL,
  `Lastname` varchar(200) NOT NULL,
  `Email` varchar(225) NOT NULL,
  `Location` varchar(220) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(222) NOT NULL,
  `usertype` varchar(230) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `firstname`, `Lastname`, `Email`, `Location`, `username`, `password`, `usertype`) VALUES
(1, 'lazi', 'milembe', 'milembe@gmail.com', 'kigal', 'lazi', '234656', 'manager'),
(2, 'isimbi', 'nickita', 'nick@gmail.com', 'huye', 'nick', '123', 'admin'),
(3, 'nelly', 'ngabo', 'ngabo@gmail.com', 'muhanga', 'nelly', '123', 'user'),
(4, 'vee', 'ntwari', 'vee@gmail.com', 'muhanga', 've', '12', 'user'),
(5, 'laziah', 'rukundo', 'laz@gmail.com', 'huye', 'lazi', '12', 'admin'),
(24, 'ere', 'erer', 'erer@gmail.com', 'muhanga', 'lala', '1234', 'manager'),
(32, 'rara', 'fati', 'milembelazia@gmail.com', 'kigal', 'funny', 'lazia', 'manager');

-- --------------------------------------------------------

--
-- Table structure for table `customer_orders`
--

CREATE TABLE IF NOT EXISTS `customer_orders` (
  `order_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) NOT NULL,
  `product_name` varchar(200) NOT NULL,
  `quantity` int(20) NOT NULL,
  `amounts` int(20) NOT NULL,
  `Dateorder` varchar(200) NOT NULL,
  `phone` varchar(222) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=235 ;

--
-- Dumping data for table `customer_orders`
--

INSERT INTO `customer_orders` (`order_id`, `customer_name`, `product_name`, `quantity`, `amounts`, `Dateorder`, `phone`) VALUES
(1, 'rukundoi', 'computer', 40000, 5000000, '2023/09/5', '0783234567'),
(2, 'dar', 'chair', 234, 2000000, '2024/2/17', '07822345678'),
(5, 'laziah', 'chairs', 246, 200000, '2024/2/14', '0789753421'),
(8, 'nana', 'chairs', 9000, 100000, '2024/2/19', '079435621'),
(32, 'rer', 'chair', 345, 2456700, '2024/2/19', '0789654321'),
(43, 'nana', 'chair', 45, 600000, '2024/02/15', '07834564556'),
(234, 'shadia ', 'chair', 222, 200000, '2024/2/19', '078245672');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` int(10) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(100) NOT NULL,
  `phone` varchar(200) NOT NULL,
  `salary` varchar(225) NOT NULL,
  `position` varchar(220) NOT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `emp_name`, `phone`, `salary`, `position`) VALUES
(1, 'lazi', '0789753891', '1000000', 'manager'),
(13, 'gagd', '0784356721', '2300000', 'admin'),
(21, 'fatu', '0784356274', '2000000', 'store keeper'),
(23, 'bit', '0784536789', '3000000', 'manager'),
(27, 'fatu', '0784356274', '2000000', 'store keeper'),
(34, 'gad', '0786954543', '20000000', 'cleaner'),
(35, 'das', '0786954536', '200000', 'manager'),
(38, 'das', '0786954536', '200000', 'manager'),
(45, 'mulisa', '0786543213', '11110000', '');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE IF NOT EXISTS `payments` (
  `payment_id` int(10) NOT NULL AUTO_INCREMENT,
  `Transaction_name` varchar(100) NOT NULL,
  `Amount` int(12) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=68 ;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`payment_id`, `Transaction_name`, `Amount`, `Date`) VALUES
(3, 'ewre', 2788, '2024-02-14'),
(21, 'momo', 1000000, '2024-02-10'),
(23, 'momo pay', 30000, '2024-02-19'),
(32, 'momo pay', 2000000000, '2024-02-19'),
(34, 'momopay', 3456, '2024-02-14'),
(67, 'momo', 4444000, '2024-02-19');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `productid` int(10) NOT NULL AUTO_INCREMENT,
  `productname` varchar(255) NOT NULL,
  `quantity` int(12) NOT NULL,
  `Unitprice` int(15) NOT NULL,
  `totalprice` int(20) NOT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=44 ;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productid`, `productname`, `quantity`, `Unitprice`, `totalprice`, `description`) VALUES
(1, 'laptop', 1200, 3000, 64000, 'agnes'),
(12, 'kaka', 324, 10000, 100000, 'timbers'),
(43, 'arime', 345, 2777, 234567, 'timber');

-- --------------------------------------------------------

--
-- Table structure for table `stocks`
--

CREATE TABLE IF NOT EXISTS `stocks` (
  `stock_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_id` int(15) NOT NULL,
  `quantity_in` int(12) NOT NULL,
  `quantity_out` int(11) NOT NULL,
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3424 ;

--
-- Dumping data for table `stocks`
--

INSERT INTO `stocks` (`stock_id`, `product_id`, `quantity_in`, `quantity_out`) VALUES
(2, 3, 3, 3),
(3, 6, 9, 5),
(4, 3, 4, 6),
(22, 65, 65, 76),
(23, 54, 345, 3456),
(135, 166, 18888, 10000),
(3423, 23, 234, 2345);

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE IF NOT EXISTS `suppliers` (
  `sup_id` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `telephone` varchar(200) NOT NULL,
  `quantity` int(20) NOT NULL,
  `product_id` int(15) NOT NULL,
  `stoct_id` int(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`sup_id`, `name`, `telephone`, `quantity`, `product_id`, `stoct_id`) VALUES
(1, 'lucky', '078324563', 324, 12, 4),
(2, 'fat', '0789756891', 34, 2, 2),
(32, 'fsa', '0786543213', 30000, 43, 34),
(65, 'rara', '0789534213', 4000, 4, 6);
