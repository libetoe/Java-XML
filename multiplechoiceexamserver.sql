-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 07, 2021 at 10:55 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `multiplechoiceexamserver`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminuser`
--

CREATE TABLE `adminuser` (
  `userId` int(10) NOT NULL,
  `FirstName` varchar(10) NOT NULL,
  `LastName` varchar(10) NOT NULL,
  `UserName` varchar(10) NOT NULL,
  `UserType` varchar(10) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adminuser`
--

INSERT INTO `adminuser` (`userId`, `FirstName`, `LastName`, `UserName`, `UserType`, `Password`) VALUES
(201500, 'Liau', 'Libetoe', 'libetoel', 'admin', 'liau1234'),
(201501, 'Venuste', 'Vill', 'docvill', 'admin', 'vill1234');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `CourseId` int(10) NOT NULL,
  `CourseName` varchar(50) NOT NULL,
  `NoOfQuestions` int(10) NOT NULL,
  `MarksPerQuestion` int(10) NOT NULL,
  `ExamDuration` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`CourseId`, `CourseName`, `NoOfQuestions`, `MarksPerQuestion`, `ExamDuration`) VALUES
(100, 'Design Project ', 40, 2, '2.3'),
(101, 'Engineering', 30, 3, '1.2'),
(110, 'Programming ', 30, 3, '2.4'),
(111, 'Engineering Maths 1', 20, 1, '0.3'),
(123, 'Drawing', 30, 3, '1.2'),
(234, 'Networking', 20, 1, '0.3'),
(300, 'Data Structures', 50, 3, '3.0'),
(301, 'Engineering', 20, 2, '1.50'),
(302, 'Engineering', 20, 2, '1.50'),
(303, 'Engineering', 20, 2, '1.50'),
(304, 'Engineering', 20, 2, '1.50'),
(305, 'Engineering', 20, 2, '1.50'),
(306, 'Engineering', 20, 2, '1.50'),
(307, 'Engineering', 20, 2, '1.50'),
(542, 'Photoshop', 40, 3, '2.1');

-- --------------------------------------------------------

--
-- Table structure for table `lectures`
--

CREATE TABLE `lectures` (
  `lectureID` int(10) UNSIGNED NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `course` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lectures`
--

INSERT INTO `lectures` (`lectureID`, `firstname`, `lastname`, `username`, `course`, `password`) VALUES
(20010000, 'Kopano', 'Tapole', 'tapolek', 'Data Structures', '12345'),
(20010001, 'Tau', 'Bohloko', 'bohlokot', 'Visual Programming', '54321'),
(20010002, 'Raliete', 'Thibello', 'thibellor', 'Microcontroller Applications', '24680'),
(20010003, 'Lekhanya', 'Lekhanya', 'lekhanyal', 'Digital Electronics', '13579,'),
(20010004, 'Shoepane', 'Panyane', 'shoepanep', 'Introduction to Programming', '097531'),
(20010005, 'FirstName', 'LastName', 'UserName', 'Course', 'PassWord'),
(20010006, 'liau', 'libetoe', 'venuste', 'Data Structures', '2190321'),
(20010007, 'Mareabetsoe', 'Chabalala', 'chabalalam', 'Web technologies', '123456'),
(20010008, 'Mareabetsoe', 'Chabalala', 'chabalalam', 'Web technologies', '123456'),
(20010009, 'Mareabetsoe', 'Chabalala', 'chabalalam', 'Web technologies', '123456'),
(20010010, 'Mareabetsoe', 'Chabalala', 'chabalalam', 'Web technologies', '123456'),
(20010011, 'Mareabetsoe', 'Chabalala', 'chabalalam', 'Web technologies', '123456'),
(20010012, 'Mareabetsoe', 'Chabalala', 'chabalalam', 'Web technologies', '123456'),
(20010013, 'Mareabetsoe', 'Chabalala', 'chabalalam', 'Web technologies', '123456'),
(20010014, 'Mareabetsoe', 'Chabalala', 'chabalalam', 'Web technologies', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `questionID` int(10) UNSIGNED NOT NULL,
  `course` varchar(50) NOT NULL,
  `questionString` varchar(255) NOT NULL,
  `option1` varchar(255) NOT NULL,
  `option2` varchar(255) NOT NULL,
  `option3` varchar(255) NOT NULL,
  `option4` varchar(255) NOT NULL,
  `correctOption` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`questionID`, `course`, `questionString`, `option1`, `option2`, `option3`, `option4`, `correctOption`) VALUES
(2, 'Design Project ', 'What is the most difficult thing in programming', 'Logic', 'coding', 'Problem Anaysis', 'Nothing', 'option1'),
(3, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(4, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(5, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(6, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(7, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(8, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(9, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(10, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(11, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(12, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(13, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(14, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(15, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(16, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(17, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(18, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(19, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(20, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(21, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(22, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4'),
(23, 'Design Project', 'What is Design Project?', 'Simply means Project Design', 'Project realated course', 'Course Focused on Project', 'Design projects and includes software engineering', 'option4');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `QuestionID` int(10) UNSIGNED NOT NULL,
  `course` varchar(50) NOT NULL,
  `questionString` varchar(255) NOT NULL,
  `option1` varchar(255) NOT NULL,
  `option2` varchar(255) NOT NULL,
  `option3` varchar(255) NOT NULL,
  `option4` varchar(255) NOT NULL,
  `correctOption` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`QuestionID`, `course`, `questionString`, `option1`, `option2`, `option3`, `option4`, `correctOption`) VALUES
(1, 'Data Structures', 'What is an Algorithm', 'A', 'B', 'C', 'D', 'B'),
(2, 'Programming ', 'What is 1+1?', '2', '3', '4', '5', '2'),
(3, 'Engineering', 'What is engineering', 'A', 'B', 'C', 'D', 'A'),
(4, 'Design Project ', 'What is my name', 'unkwon', 'Nobody', 'Liau', 'Everyone', 'Liau'),
(5, 'Engineering Maths 1', ' What is 12 - 24', ' 24', ' 12', ' -12', ' -24', ' -12'),
(9, 'Engineering Maths 1', 'what 45 / 45', 'undefined', '0', '1', '45', '1'),
(10, 'Engineering Maths 1', ' what is 56 * 0', ' 0', ' 56', ' 560', ' undefined', ' 0'),
(11, 'Engineering Maths 1', ' what is an obsolute value -1000', ' 0', ' 1000', ' -1000', ' 1', ' 1000'),
(13, 'Engineering Maths 1', ' what is the factorial of 5', ' 2000', ' 100', ' 0', ' 120', ' 120'),
(14, 'Photoshop', 'What is the benefit of learning photoshop', 'no benefit', 'For financial benefit', 'To edit, design  and make pictures logos and videos', 'There is a lot of fun in learning photoshop', 'There is a lot of fun in learning photoshop');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `studentId` int(10) UNSIGNED NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `course` varchar(50) NOT NULL,
  `lecture` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`studentId`, `firstname`, `lastname`, `username`, `course`, `lecture`, `password`) VALUES
(201500407, 'Kofi', 'Anal', 'Kofi', 'Programming', 'Mosuoe Tichere', 'pass123'),
(201500408, 'Tau', 'libe', 'libe', 'Programming', 'Mosuoe Tichere', 'my1234'),
(201500409, 'Tlou', 'Liphapang', 'tomas', 'Programming', 'Mosuoe Tichere', 'password1'),
(201500410, 'Tjobe', 'Tumo', 'aggie', 'Programming', 'Mosuoe Tichere', 'tmaggg'),
(201500411, 'Fofotho', 'Fofotho', 'paul', 'Programming', 'Mosuoe Tichere', 'f0f0th0'),
(201500412, 'Makafane', 'Tokelo', 'tkMakafane', 'Programming', 'Mosuoe Tichere', 'tkmf4n3'),
(201500413, 'Liau', 'Libetoe', 'libetoel', 'Design and Technology', 'Lekhanya Lekhanya', 'pass123'),
(201500414, 'Tsotang', 'Letele', 'letelet', 'Networking', 'Raliete Thibello', '54321'),
(201500415, 'liau', 'libetoe', 'liaul', 'Engineering', 'Raliete Thibello', 'libetoe'),
(201500416, 'Kolisang ', 'Maliehe', 'kolisangm', 'Engineering', 'Lekhanya Lekhanya', '654321'),
(201500417, 'Kolisang ', 'Maliehe', 'kolisangm', 'Engineering', 'Lekhanya Lekhanya', '654321'),
(201500418, 'Polilane', 'puli', 'pulip', 'Web Technologies', 'Tau Bohloko', '543210');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminuser`
--
ALTER TABLE `adminuser`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`CourseId`);

--
-- Indexes for table `lectures`
--
ALTER TABLE `lectures`
  ADD PRIMARY KEY (`lectureID`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`questionID`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`QuestionID`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`studentId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adminuser`
--
ALTER TABLE `adminuser`
  MODIFY `userId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201502;

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `CourseId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=543;

--
-- AUTO_INCREMENT for table `lectures`
--
ALTER TABLE `lectures`
  MODIFY `lectureID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20010015;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `questionID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `QuestionID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `studentId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201500419;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
