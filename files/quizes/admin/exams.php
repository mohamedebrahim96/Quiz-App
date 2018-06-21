<?php

session_start();
$pageTitle = 'Exams' ;


	if (isset($_SESSION['Admin_Username'])) {


		include 'init.php' ;
		
		
		$query = "SELECT 
				  		 cr.course_name , cr.course_id , exam.exam_name , grade_name , exam.exam_id , exam.exam_duration , exam.exam_status ,division.division_name
				  FROM courses AS cr 
				  INNER JOIN courses_has_exam AS courses_exams 
				  ON cr.course_id = courses_exams.courses_id 
				  INNER JOIN exam ON exam.exam_id = courses_exams.exam_id
				  INNER JOIN grade ON cr.grade_id = grade.grade_id
				  INNER JOIN division ON cr.division_id = division.division_id" ; 
		
		$stmt = $conn->prepare($query) ; 
		$stmt->execute() ;
		
		$rows = $stmt->fetchAll();
		
		
		
		$do = isset($_GET['do']) ? $_GET['do'] : 'Manage' ;
		
		if($do == 'Manage'){ ?>
			
			<div class="container">
				<h2 style="color:gray;"><i class="fa fa-edit"></i> Manage Exam</h2>
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#home">
						<i class="fa fa-align-justify fa-lg"></i> Exam List</a>
					</li>
					<li><a data-toggle="tab" href="#add-exam">
						<i class="fa fa-plus fa-lg"></i> Add Exam</a>
					</li>
					<li style="float:right"><a href="logout.php">Logout</a></li>
				</ul>
				<div class="tab-content">
					
					<div id="home" class="tab-pane fade in active">
						
						<h1 class="text-center">Manage Exams</h1>
						<div class="table-responsive">
							<table class="main-table text-center table table-bordered" id="exams-table">
								<tr>
									<td>ExamID</td>
									<td>Course</td>
									<td>Division</td>
									<td>Grade</td>
									<td>Exam Name</td>
									<td>Duration</td>
									<td>Availablity</td>
									<td>Options</td>
									
								</tr>
								
								<?php
								
									foreach($rows as $row) {
										
										echo "<tr>" ;							
											echo "<td>" . $row['exam_id'] . "</td>" ;
											echo "<td>" . $row['course_name'] . "</td>" ;
											echo "<td>" . $row['division_name'] . "</td>" ;
											echo "<td>" . $row['grade_name'] . "</td>" ;
											echo "<td>" . $row['exam_name'] . "</td>" ;
											echo "<td>" 
													. $row['exam_duration']
													."<span id='duration-span'> Mins</span>" 
												. "</td>" ;
											echo "<td>" . $row['exam_status'] . "</td>" ;
											echo "<td>
											
												<a href='exams.php?do=Add&examID=".$row['exam_id']."' class='btn btn-primary'><i class='fa fa-plus fa-lg'> Add Question</i></a>
												
												<a href='exams.php?do=Edit&examID=".$row['exam_id']."' class='btn btn-success'><i class='fa fa-edit fa-lg'></i></a>
												
												<a href='exams.php?do=Delete&examID=".$row['exam_id']."' class='btn btn-danger confirm'><i class='fa fa-close fa-lg'></i></a> " ;
										
											if($row['exam_status'] == 0) {
												echo " <a href='exams.php?do=Activate&examID=".$row['exam_id']."' class='btn btn-info'><i class='fa fa-check fa-lg'></i> Activate</a>" ;
											} 
										
											if($row['exam_status'] == 1) {
												echo " <a href='exams.php?do=DeActivate&examID=".$row['exam_id']."' class='btn btn-info'><i class='fa fa-close fa-lg'></i> Activate</a>" ;
											} 
										
											echo "</td>" ;
										echo "</tr>" ;
									
									}
							
								?>
						
							</table>						
						</div>
					
						
						
					</div>
					<div id="add-exam" class="tab-pane fade">
						
						<h1 class="text-center page-title">Add New Exam</h1>
						<div class="container">
							<form class="form-horizontal" action="?do=Insert" method="POST">
								
								<?php
										$stmt = $conn->prepare("SELECT max(exam_id) 
																FROM exam LIMIT 1 ");
										$stmt->execute();
										$lastExamId = $stmt->fetch();
											
									?>
								
								<input type="hidden" name="last-exam-id" value="<?php echo $lastExamId[0] ?>" />
								
									<!--Courese Name-->
								
								<div class="form-group">
									<label class="col-sm-2 control-label">Course Name</label>
									<div class="col-xs-2">
										<select class="form-control" name="selected-course">
											<option value="0">none</option>
											<?php
												$allCourses = getAllFrom("*" , "courses" ,"","" ,"course_id", "ASC");
												foreach($allCourses as $course) {
												echo "<option value='" 
													. $course['course_id'] . "'>" . $course['course_name'] . "</option>";
												}	
											
											?>
										</select>
									</div>
								</div>	
								
								<!--Exam Name-->
								
								<div class="form-group">
									
									<label class="col-sm-2 control-label">Exam Name</label>
									<div class="col-xs-2">
										<input type="text" name="exam-name" class="form-control" autocomplete="off" placeholder="Exam Name" required="required" />
									</div>
								</div>
								
								<!--Date-->
								
								<div class="form-group">
									<label class="col-sm-2 control-label">Date</label>
									<div class="col-xs-2">
										<input id="datepicker" type="text" class="form-control" placeholder="Date" name="exam-date">
									</div>
								</div>
							<!--Exam Duration-->
								
								<div class="form-group">
									<label class="col-sm-2 control-label">
										Duration(Minutes)
									</label>
									<div class="col-xs-2">
										<input type="text" name="exam-duration" class="form-control" placeholder="Duration">
									</div>
								</div>
								
						 <!--Exam Visibility--> 
							   <div class="form-group">
									<label class="col-sm-2 control-label">Visibility</label>
									<div class="col-md-6">
										<div>
											<input id="vis-yes" type="radio" 
												   name="exam-visib" value = "1" checked />
											<label for="vis-yes">Yes</label>
										</div>
										<div>
											<input id="vis-no" type="radio" 
												   name="exam-visib" value="0" />
											<label for="vis-no">No</label>
										</div>
									</div>
							   </div>
								
							   <div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<input type="submit" value="Add Exam" class="btn btn-primary" />
									</div>
							   </div>
                   
							</form>
						
						</div>
<!--						Ending Add Exam Page	-->
					</div>
					
				</div>
		
			</div>
			
			
			
			
			
			
			
		 <?php }elseif($do == 'Add') { // Starting Add Page
			
			
			
			
			
			
		}elseif($do == 'Insert') {
			
			if($_SERVER['REQUEST_METHOD'] == 'POST') {
				
				echo "<h1 class='text-center'>Insert Category</h1>";
				echo "<div class='container'>";
				
				// Getting All Variables From The Form 
				
				$courseID = $_POST['selected-course'];
				$examName = $_POST['exam-name'];
				$examDate = $_POST['exam-date'];
				$examDuration = $_POST['exam-duration'];
				$examVisib = $_POST['exam-visib'];
				$lastExamID = $_POST['last-exam-id'];
				
				
					 
					
				
				// Check If The Exam Exists in Database
				
				$check = checkItem("exam_name" , "exam" , $examName) ;
				
				if($check == 1) {
					
					
					$theMsg = '<div class="alert alert-danger">Sorry This Exam Not Exist</div>';
					redirect($theMsg, 'back');
				}else {
					
					// Insert The Exam 
					
					$query = "INSERT INTO
								exam(exam_name,exam_start_date,exam_duration,exam_status)
								VALUES(:zname,:zdate,:zduration,:zstatus)" ;
					
					$stmt = $conn->prepare($query);
					$stmt->execute(array(
					
						'zname' => $examName,
						'zdate' => $examDate,
						'zduration' => $examDuration,
						'zstatus' => $examVisib
					
					));
					
					
					$lastExamID += 1 ;
					
				
					
					
					// insert into Courses_has_exams
					
					
					$query2 = "INSERT INTO courses_has_exam(courses_id, exam_id) 
								VALUES (?,?)" ;
					
					$stmt2 = $conn->prepare($query2);
					$stmt2->execute(array($courseID,$lastExamID));
					
					
					
					
					
					$theMsg = "<div class='alert alert-success'>" . $stmt->rowCount() . ' Record Inserted</div>';
					redirect($theMsg, 'back');

					
				}
			
				echo "</div>";
			
			}
			
			
			
			
		}elseif($do == 'Update') {
			
			
		}elseif($do =='Delete') {
			
			
		}




	}else {


		header('Location: index.php');
		exit();	

	}









include $tpl.'footer.php' ;



?>