<?php
	
	session_start() ;
	include 'init.php' ;


	$answers = $_POST ;

		echo "<pre>" ;
	print_r($answers) ;
	echo "</pre>" ; 


	// Getting Answers

//	$stmt = $conn->prepare("SELECT * FROM questions WHERE subj_id = ?");
//	$stmt->execute(array($subject)) ;
//	$questions = $stmt->fetchAll() ;


?>