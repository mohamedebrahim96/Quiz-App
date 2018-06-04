-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 04, 2018 at 07:00 AM
-- Server version: 5.7.21
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quizes`
--

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
CREATE TABLE IF NOT EXISTS `answers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ans1` varchar(100) NOT NULL,
  `ans2` varchar(100) NOT NULL,
  `ans3` varchar(100) NOT NULL,
  `ans4` varchar(100) NOT NULL,
  `correct_ans` varchar(100) NOT NULL,
  `questions_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`questions_id`),
  KEY `fk_answers_questions1_idx` (`questions_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`id`, `ans1`, `ans2`, `ans3`, `ans4`, `correct_ans`, `questions_id`) VALUES
(1, 'Yes', 'No', 'Maybe', 'None of Them', 'Yes', 1),
(2, 'mohamed', 'ahmed', 'mona ', 'fred', 'ahmed', 4),
(4, '55', '', '13', '12', '13', 2),
(5, 'true', '', 'false', '', 'true', 5),
(6, 'El niny', 'Hegazy', 'Mo salah', 'Shekabala', 'Mo salah', 7);

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
CREATE TABLE IF NOT EXISTS `courses` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `grade_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`course_id`),
  KEY `fk_courses_grade_idx` (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`course_id`, `grade_id`, `name`) VALUES
(1, 1, 'English'),
(2, 1, 'Math'),
(3, 1, 'Intro To CS'),
(4, 2, 'Math 2'),
(5, 3, 'Math 3');

-- --------------------------------------------------------

--
-- Table structure for table `courses_has_exam`
--

DROP TABLE IF EXISTS `courses_has_exam`;
CREATE TABLE IF NOT EXISTS `courses_has_exam` (
  `courses_idf` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  PRIMARY KEY (`courses_idf`,`exam_id`),
  KEY `fk_courses_has_exam_exam1_idx` (`exam_id`),
  KEY `fk_courses_has_exam_courses1_idx` (`courses_idf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
CREATE TABLE IF NOT EXISTS `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`id`, `name`, `start_date`) VALUES
(1, 'Math For The First Group', '2018-03-24'),
(2, 'English For The First Group', '2018-03-25');

-- --------------------------------------------------------

--
-- Table structure for table `exam_has_questions`
--

DROP TABLE IF EXISTS `exam_has_questions`;
CREATE TABLE IF NOT EXISTS `exam_has_questions` (
  `exam_id` int(11) NOT NULL,
  `questions_id` int(11) NOT NULL,
  PRIMARY KEY (`exam_id`,`questions_id`),
  KEY `fk_exam_has_questions_questions1_idx` (`questions_id`),
  KEY `fk_exam_has_questions_exam1_idx` (`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `exam_has_questions`
--

INSERT INTO `exam_has_questions` (`exam_id`, `questions_id`) VALUES
(2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `exam_results`
--

DROP TABLE IF EXISTS `exam_results`;
CREATE TABLE IF NOT EXISTS `exam_results` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total_points` int(11) NOT NULL,
  `correct_ans` int(11) NOT NULL,
  `wrong_ans` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`student_id`,`exam_id`),
  KEY `fk_exam_results_student1_idx` (`student_id`),
  KEY `fk_exam_results_exam1_idx` (`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
CREATE TABLE IF NOT EXISTS `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `desc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `grade`
--

INSERT INTO `grade` (`id`, `name`, `desc`) VALUES
(1, 'First Group', NULL),
(2, 'Second Group', NULL),
(3, 'Third Group', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
CREATE TABLE IF NOT EXISTS `professor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `last_login_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
CREATE TABLE IF NOT EXISTS `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `question`) VALUES
(1, 'Is PHP A Programing Language ?'),
(2, 'Is 5 + 5 = 10 ?'),
(3, 'is tan b = 120 ?'),
(4, 'What Is The Present Tense ? '),
(5, 'why NASA keep lying to us?'),
(7, 'who is the best player in Egypt ?\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
CREATE TABLE IF NOT EXISTS `results` (
  `result_id` int(11) NOT NULL AUTO_INCREMENT,
  `cardnumber` int(11) NOT NULL,
  `name` text NOT NULL,
  `total_degree` text NOT NULL,
  PRIMARY KEY (`result_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `results`
--

INSERT INTO `results` (`result_id`, `cardnumber`, `name`, `total_degree`) VALUES
(11, 55, 'tgrthrty', '100/25');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `cardnumber` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `g` int(11) NOT NULL,
  `division` text NOT NULL,
  PRIMARY KEY (`student_id`,`g`),
  KEY `g` (`g`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `cardnumber`, `email`, `password`, `name`, `dob`, `phone`, `g`, `division`) VALUES
(27, 666, '666', '666', 'momo', NULL, NULL, 1, 'شعبة نظم المعلومات الإدارية'),
(28, 11, '11', '11', 'mo', NULL, NULL, 1, 'علوم حاسب'),
(29, 55, 'hdbf', 'bdbf', 'bfbf', NULL, NULL, 1, 'محاسبة'),
(30, 6, 'vsbd', 'bdbd', 'fbf', NULL, NULL, 2, 'إدارة الأعمال'),
(31, 33, 'gdbdv', 'bdbd', 'hdbfb', NULL, NULL, 1, 'علوم حاسب'),
(32, 36, 'hfb', 'bd', 'bf', NULL, NULL, 1, 'علوم حاسب');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answers`
--
ALTER TABLE `answers`
  ADD CONSTRAINT `fk_answers_questions1` FOREIGN KEY (`questions_id`) REFERENCES `questions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `fk_courses_grade` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `courses_has_exam`
--
ALTER TABLE `courses_has_exam`
  ADD CONSTRAINT `fk_courses_has_exam_courses1` FOREIGN KEY (`courses_idf`) REFERENCES `courses` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_courses_has_exam_exam1` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `exam_has_questions`
--
ALTER TABLE `exam_has_questions`
  ADD CONSTRAINT `fk_exam_has_questions_exam1` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_exam_has_questions_questions1` FOREIGN KEY (`questions_id`) REFERENCES `questions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `exam_results`
--
ALTER TABLE `exam_results`
  ADD CONSTRAINT `fk_exam_results_exam1` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_exam_results_student1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `fk_student_grade1` FOREIGN KEY (`g`) REFERENCES `grade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
