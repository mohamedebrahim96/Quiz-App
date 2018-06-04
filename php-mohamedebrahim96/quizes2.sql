-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2018 at 09:31 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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

CREATE TABLE `answers` (
  `id` int(11) NOT NULL,
  `ans1` varchar(100) NOT NULL,
  `ans2` varchar(100) NOT NULL,
  `ans3` varchar(100) NOT NULL,
  `ans4` varchar(100) NOT NULL,
  `correct_ans` varchar(100) NOT NULL,
  `questions_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`id`, `ans1`, `ans2`, `ans3`, `ans4`, `correct_ans`, `questions_id`) VALUES
(1, '4', '8', '2', '3', '8', 1),
(2, '20', '22', '23', '25', '20', 2),
(3, '18', '20', '22', '24', '18', 3),
(4, '18', '20', '22', '24', '18', 4),
(5, '14000', '200', '150', '20000', '14000', 5),
(6, '14000', '200', '150', '20000', '14000', 6);

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `course_id` int(11) NOT NULL,
  `grade_id` int(11) NOT NULL,
  `division_id` int(11) NOT NULL,
  `course_name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`course_id`, `grade_id`, `division_id`, `course_name`) VALUES
(11, 1, 1, 'English'),
(12, 2, 1, 'Software Engineering'),
(13, 2, 1, 'Physics'),
(14, 4, 4, 'Management'),
(15, 3, 3, 'chess24');

-- --------------------------------------------------------

--
-- Table structure for table `courses_has_exam`
--

CREATE TABLE `courses_has_exam` (
  `courses_id` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `courses_has_exam`
--

INSERT INTO `courses_has_exam` (`courses_id`, `exam_id`) VALUES
(11, 20);

-- --------------------------------------------------------

--
-- Table structure for table `division`
--

CREATE TABLE `division` (
  `division_id` int(11) NOT NULL,
  `division_name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `division`
--

INSERT INTO `division` (`division_id`, `division_name`) VALUES
(1, 'علوم الحاسب'),
(2, 'محاسبه'),
(3, 'تجاره'),
(4, 'نظم معلومات');

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `exam_id` int(11) NOT NULL,
  `exam_name` varchar(45) NOT NULL,
  `exam_start_date` date DEFAULT NULL,
  `exam_duration` int(11) NOT NULL,
  `exam_status` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`exam_id`, `exam_name`, `exam_start_date`, `exam_duration`, `exam_status`) VALUES
(5, 'Dr / Lobna 1', '2018-04-08', 3, 1),
(7, 'Dr / Lobna 2', '2018-04-08', 3, 1),
(8, 'Dr mofreh 1', '2018-04-08', 3, 0),
(9, 'mof 3', '2018-04-08', 55, 0),
(10, 'mof55', '2018-04-08', 33, 0),
(12, 'ph1', '2018-04-08', 21, 0),
(13, 'mofreh14', '2018-04-08', 13, 1),
(14, 'phy4', '2018-04-17', 444, 1),
(15, 'phy5', '2018-04-10', 55, 1),
(16, 'phy6', '2018-04-20', 6, 1),
(17, 'sdfsdf', '2018-04-10', 45, 1),
(18, 'hjhjghj', '2018-04-16', 0, 1),
(19, 'fghfgh', '2018-04-10', 4565, 1),
(20, 'dd', '2018-05-08', 20, 1);

-- --------------------------------------------------------

--
-- Table structure for table `exam_has_questions`
--

CREATE TABLE `exam_has_questions` (
  `exam_id` int(11) NOT NULL,
  `questions_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `exam_has_questions`
--

INSERT INTO `exam_has_questions` (`exam_id`, `questions_id`) VALUES
(5, 2),
(5, 3),
(5, 4),
(5, 5),
(7, 2),
(7, 3),
(7, 4),
(7, 5),
(7, 6),
(13, 1),
(13, 2),
(13, 3),
(13, 4),
(13, 5),
(13, 6),
(14, 1),
(14, 2),
(14, 3),
(14, 4),
(14, 5),
(14, 6),
(20, 1),
(20, 2),
(20, 3),
(20, 4),
(20, 5),
(20, 6);

-- --------------------------------------------------------

--
-- Table structure for table `exam_results`
--

CREATE TABLE `exam_results` (
  `id` int(11) NOT NULL,
  `total_points` int(11) NOT NULL,
  `correct_ans` int(11) NOT NULL,
  `wrong_ans` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

CREATE TABLE `grade` (
  `grade_id` int(11) NOT NULL,
  `grade_name` varchar(45) NOT NULL,
  `grade_desc` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `grade`
--

INSERT INTO `grade` (`grade_id`, `grade_name`, `grade_desc`) VALUES
(1, 'الفرقه الأولي', NULL),
(2, 'الفرقه الثانيه', NULL),
(3, 'الفرقه الثالثه', NULL),
(4, 'الفرقه الرابعه', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `professor`
--

CREATE TABLE `professor` (
  `id` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `last_login_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `professor`
--

INSERT INTO `professor` (`id`, `email`, `password`, `fname`, `lname`, `dob`, `phone`, `last_login_date`) VALUES
(1, 'hesham.elalawy@gmail.com', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'h', 'h', '1996-04-22', '01287712483', '2018-04-24');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` int(11) NOT NULL,
  `question` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `question`) VALUES
(1, '5 + 3 = ?'),
(2, '8 + 12 '),
(3, '600+300'),
(4, '15 + 3 '),
(5, '5000 + 9000'),
(6, '5000 + 9000');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `card_id` int(32) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `grade_id` int(11) NOT NULL,
  `division_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `card_id`, `email`, `password`, `fname`, `lname`, `grade_id`, `division_id`) VALUES
(1, 512430, 'mahmoud@gmail.com', 'f7c3bc1d808e04732adf679965ccc34ca7ae3441', 'Mahmoud', 'Samir', 4, 1),
(2, 502145, 'hesham@elalawy.com', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'Hesham', 'Elalawy', 4, 1),
(3, 6777, 'heshamzz@info.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'm', 'Ebrahim', 4, 1),
(4, 1245, 'Elkholy@a.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'Fred', 'Elkhloy', 4, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`id`,`questions_id`),
  ADD KEY `fk_answers_questions1_idx` (`questions_id`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`course_id`),
  ADD KEY `fk_courses_grade_idx` (`grade_id`),
  ADD KEY `fk_courses_division1_idx` (`division_id`);

--
-- Indexes for table `courses_has_exam`
--
ALTER TABLE `courses_has_exam`
  ADD PRIMARY KEY (`courses_id`,`exam_id`),
  ADD KEY `fk_courses_has_exam_exam1_idx` (`exam_id`),
  ADD KEY `fk_courses_has_exam_courses1_idx` (`courses_id`);

--
-- Indexes for table `division`
--
ALTER TABLE `division`
  ADD PRIMARY KEY (`division_id`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`exam_id`);

--
-- Indexes for table `exam_has_questions`
--
ALTER TABLE `exam_has_questions`
  ADD PRIMARY KEY (`exam_id`,`questions_id`),
  ADD KEY `fk_exam_has_questions_questions1_idx` (`questions_id`),
  ADD KEY `fk_exam_has_questions_exam1_idx` (`exam_id`);

--
-- Indexes for table `exam_results`
--
ALTER TABLE `exam_results`
  ADD PRIMARY KEY (`id`,`student_id`,`exam_id`),
  ADD KEY `fk_exam_results_student1_idx` (`student_id`),
  ADD KEY `fk_exam_results_exam1_idx` (`exam_id`);

--
-- Indexes for table `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`grade_id`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`,`grade_id`),
  ADD KEY `fk_student_grade1_idx` (`grade_id`),
  ADD KEY `fk_student_division1_idx` (`division_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answers`
--
ALTER TABLE `answers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `course_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `division`
--
ALTER TABLE `division`
  MODIFY `division_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
  MODIFY `exam_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `exam_results`
--
ALTER TABLE `exam_results`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `grade`
--
ALTER TABLE `grade`
  MODIFY `grade_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `professor`
--
ALTER TABLE `professor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `answers`
--
ALTER TABLE `answers`
  ADD CONSTRAINT `fk_answers_questions1` FOREIGN KEY (`questions_id`) REFERENCES `questions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `fk_courses_division1` FOREIGN KEY (`division_id`) REFERENCES `division` (`division_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_courses_grade` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`grade_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `courses_has_exam`
--
ALTER TABLE `courses_has_exam`
  ADD CONSTRAINT `fk_courses_has_exam_courses1` FOREIGN KEY (`courses_id`) REFERENCES `courses` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_courses_has_exam_exam1` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `exam_has_questions`
--
ALTER TABLE `exam_has_questions`
  ADD CONSTRAINT `fk_exam_has_questions_exam1` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_exam_has_questions_questions1` FOREIGN KEY (`questions_id`) REFERENCES `questions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `exam_results`
--
ALTER TABLE `exam_results`
  ADD CONSTRAINT `fk_exam_results_exam1` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_exam_results_student1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `fk_student_division1` FOREIGN KEY (`division_id`) REFERENCES `division` (`division_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_student_grade1` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`grade_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
