-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 05, 2013 at 06:19 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `risduo`
--

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE IF NOT EXISTS `exam` (
  `examId` int(11) NOT NULL AUTO_INCREMENT,
  `examStartTime` bigint(20) NOT NULL,
  `examEndTime` bigint(20) DEFAULT NULL,
  `examReport` blob,
  `examPatientComplaint` mediumtext COLLATE utf8_unicode_ci,
  `examPatientId` int(11) DEFAULT NULL,
  `examReservationId` int(11) DEFAULT NULL,
  `examCreator` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `examRoomId` int(11) DEFAULT NULL,
  PRIMARY KEY (`examId`),
  KEY `fk_Patient_Have_Exam_idx` (`examPatientId`),
  KEY `fk_Reservation_Be_Exam_idx` (`examReservationId`),
  KEY `fk_Operator_Do_Exam_idx` (`examCreator`),
  KEY `fk_Modality_Carryout_Exam_idx` (`examRoomId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`examId`, `examStartTime`, `examEndTime`, `examReport`, `examPatientComplaint`, `examPatientId`, `examReservationId`, `examCreator`, `examRoomId`) VALUES
(8, 1372995297, 1372995310, NULL, 'test', 5, 16, NULL, 3);

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE IF NOT EXISTS `images` (
  `imageId` int(11) NOT NULL,
  `ImageFile` longblob NOT NULL,
  `imageExamId` int(11) DEFAULT NULL,
  PRIMARY KEY (`imageId`),
  KEY `fk_Exam_Images_idx` (`imageExamId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `patientId` int(11) NOT NULL AUTO_INCREMENT,
  `patientFName` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `patientMName` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `patientLName` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `patientNID` bigint(14) DEFAULT NULL COMMENT 'National ID',
  `patientSex` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `patientBDate` date DEFAULT NULL,
  `patientAddress` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `patientTelephone` int(11) DEFAULT NULL,
  PRIMARY KEY (`patientId`),
  UNIQUE KEY `patientTelephone` (`patientTelephone`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patientId`, `patientFName`, `patientMName`, `patientLName`, `patientNID`, `patientSex`, `patientBDate`, `patientAddress`, `patientTelephone`) VALUES
(4, 'gad', 'masry', 'adel', NULL, 'Male', '2016-06-20', '7 Arab El-Shorafa', 1004723366),
(5, 'Mustafa', 'Saadony', 'Kamel', 0, 'Male', '2016-06-20', '7 Arab El-Shorafa', 1004723399),
(6, 'hany', 'adel', 'mahmoud', 0, 'Male', '2017-06-20', 'hena', 185259703),
(7, 'fares', 'hamdy', 'motayaser', NULL, 'Male', '2027-06-20', 'thrwat street', 1111677358),
(8, 'ahmed', 'hany', 'abdallah', NULL, 'Male', '2015-06-20', '7 Arab El-Shorafa', 1003456789);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `r_Id` int(11) NOT NULL AUTO_INCREMENT,
  `reservationExamTime` bigint(20) NOT NULL,
  `reservationReferringPhysician` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reservationAttendanceTime` bigint(20) DEFAULT NULL,
  `reservationPatientId` int(11) DEFAULT NULL,
  `reservationUserName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reservationRoomId` int(11) NOT NULL,
  `reservationBillingType` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Cash/Credit Card..etc',
  `reservationBillingData` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Credit Card number/ Insurance SSN... etc',
  `reservationPatientStatus` int(1) NOT NULL DEFAULT '0' COMMENT '0 = booked\\n1= attended\\n2=having exam\\n3=finished exam\\n4=reported\\n5=report approved',
  PRIMARY KEY (`r_Id`),
  KEY `fk_Patient_Make_Reservation_idx` (`reservationPatientId`),
  KEY `fK_User_Create_Reservation_idx` (`reservationUserName`),
  KEY `fK_Reservation_Reserve_Modality_idx` (`reservationRoomId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=17 ;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`r_Id`, `reservationExamTime`, `reservationReferringPhysician`, `reservationAttendanceTime`, `reservationPatientId`, `reservationUserName`, `reservationRoomId`, `reservationBillingType`, `reservationBillingData`, `reservationPatientStatus`) VALUES
(1, 1372261097, NULL, NULL, 4, 'mustafadagher', 1, '', '', 0),
(2, 1372331097, NULL, NULL, 5, 'mustafadagher', 2, '', '', 0),
(3, 1372261497, NULL, NULL, 6, 'mustafadagher', 3, '', '', 0),
(5, 1372579200, 'sawsan badr', NULL, 4, NULL, 1, 'cash', 'n/a', 0),
(6, 1372584600, 'lara mahmoud', 1372615156, 4, NULL, 1, 'cash', 'n/a', 1),
(7, 1372572000, 'Ramy ', 1372613661, 4, NULL, 1, 'null', '21012248848455', 1),
(8, 1372582800, '', 1372614965, 4, NULL, 3, 'null', '', 1),
(9, 1372584600, 'mosa ahmed', 1372612788, 8, NULL, 2, 'cash', 'n/a', 1),
(10, 1372602600, '', 1372629686, 8, NULL, 2, 'null', '', 1),
(11, 1372572000, '', 1372614873, 8, NULL, 2, 'null', '', 1),
(12, 1372543200, '', 1372629175, 8, NULL, 3, 'null', '', -1),
(13, 1372586400, '', NULL, 4, NULL, 2, 'null', '', 0),
(14, 1372660200, '', 1372679031, 7, NULL, 2, 'null', '', 1),
(15, 1372732200, NULL, NULL, 7, NULL, 2, NULL, NULL, 2),
(16, 1373007600, NULL, NULL, 5, NULL, 3, NULL, NULL, 3);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE IF NOT EXISTS `room` (
  `roomId` int(11) NOT NULL AUTO_INCREMENT,
  `roomName` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `roomScanArea` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `roomScanDuration` int(11) DEFAULT NULL COMMENT 'duration per minutes',
  `roomCreator` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`roomId`),
  KEY `fk_Operator_Operate_Modality_idx` (`roomCreator`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`roomId`, `roomName`, `roomScanArea`, `roomScanDuration`, `roomCreator`) VALUES
(1, 'Chest MRI', 'Chest', 30, 'mustafadagher'),
(2, 'Abdomen X-Ray', 'Abdomen', 30, 'mustafadagher'),
(3, 'Brain CT', 'Brain', 30, 'mustafadagher');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE IF NOT EXISTS `schedule` (
  `scheduleRoomId` int(11) NOT NULL,
  `scheduleTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `scheduleAvail` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`scheduleRoomId`,`scheduleTime`),
  KEY `fk_Schedule_Modalities1_idx` (`scheduleRoomId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`scheduleRoomId`, `scheduleTime`, `scheduleAvail`) VALUES
(1, '2013-06-24 19:56:36', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `userPassword` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `userFullName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `userSex` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userTel` int(11) DEFAULT NULL,
  `userRole` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userName`, `userPassword`, `userFullName`, `userSex`, `userTel`, `userRole`) VALUES
('mustafadagher', '1781991', 'MustafaDagher', 'Male', 1004723366, 'Admin');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `fk_Modality_Carryout_Exam` FOREIGN KEY (`examRoomId`) REFERENCES `room` (`roomId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Operator_Do_Exam` FOREIGN KEY (`examCreator`) REFERENCES `user` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Patient_Have_Exam` FOREIGN KEY (`examPatientId`) REFERENCES `patient` (`patientId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Reservation_Be_Exam` FOREIGN KEY (`examReservationId`) REFERENCES `reservation` (`r_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `images`
--
ALTER TABLE `images`
  ADD CONSTRAINT `fk_Exam_Images` FOREIGN KEY (`imageExamId`) REFERENCES `exam` (`examId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `fk_Patient_Make_Reservation` FOREIGN KEY (`reservationPatientId`) REFERENCES `patient` (`patientId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fK_Reservation_Reserve_Modality` FOREIGN KEY (`reservationRoomId`) REFERENCES `room` (`roomId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fK_User_Create_Reservation` FOREIGN KEY (`reservationUserName`) REFERENCES `user` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `fk_Operator_Operate_Modality` FOREIGN KEY (`roomCreator`) REFERENCES `user` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `fk_Schedule_Modalities1` FOREIGN KEY (`scheduleRoomId`) REFERENCES `room` (`roomId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
