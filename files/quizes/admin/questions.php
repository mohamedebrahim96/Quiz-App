<?php

	session_start();
	$pageTitle = 'Questions' ;

	if (isset($_SESSION['Admin_Username'])) {
		
		
		include 'init.php' ;
		
		$do = isset($_GET['do']) ? $_GET['do'] : 'Manage' ;
		
		if($do == 'Manage') { // Starting Manage Page ?>
			
			
		<div class="question-stats">
            <div class="container">
                 <h1 class="text-center h1-members">Questions</h1>
                 <div class="row">
                     <div class="col-md-4">
						 
                         <div class="stat st-add-question">
                             <span><a href="questions.php?do=Add">
								 
								 <i class="fa fa-plus fa-lg"></i><br>
                             	 Add Question
								 
								 </a></span>
                         </div>
                     </div>
                     <div class="col-md-4">
                         <div class="stat st-view-question">
                             <span><a href="questions.php?do=Add">
								 <i class="fa fa-plus fa-lg"></i><br>
                             	 Add Question
								 </a></span>
                         </div>
                     </div>
                     <div class="col-md-4">
                         <div class="stat st-add-question">
                             <span><a href="questions.php?do=Add">
								 
								 <i class="fa fa-plus fa-lg"></i><br>
                             	 Add Question
								 
								 </a></span>
                         </div>
                     </div>
                 </div>
            </div>
       </div>

			
			
			
		<?php } elseif($do == 'Add') { // Starting Add Page
			
			
			?>
				<h1 class="text-center page-title">Add New Question</h1>
				<div class="container">
					<form class="form-horizontal" action="?do=Insert" method="POST">
						<div class="form-group">                    
							<label class="col-sm-2 control-label">Question</label>
							<div class="col-sm-10 col-md-8">                         
								<input type="text" name="question-name" class="form-control" autocomplete="off" placeholder="Text Of Question" required="required" />
							</div>
						</div>
						<div class="form-group">                    
							<label class="col-sm-2 control-label">Answer 1</label>
							<div class="col-sm-10 col-md-8">                         
								<input type="text" name="ans1" class="form-control" autocomplete="off" placeholder="Text Of Answer" required="required" />
							</div>
						</div>
				   		<div class="form-group">                    
							<label class="col-sm-2 control-label">Answer 2</label>
							<div class="col-sm-10 col-md-8">                         
								<input type="text" name="ans2" class="form-control" autocomplete="off" placeholder="Text Of Answer" required="required" />
							</div>
						</div>
				   		<div class="form-group">                    
							<label class="col-sm-2 control-label">Answer 3</label>
							<div class="col-sm-10 col-md-8">                         
								<input type="text" name="ans3" class="form-control" autocomplete="off" placeholder="Text Of Answer" required="required" />
							</div>
						</div>
				   		<div class="form-group">                    
							<label class="col-sm-2 control-label">Answer 4</label>
							<div class="col-sm-10 col-md-8">                         
								<input type="text" name="ans4" class="form-control" autocomplete="off" placeholder="Text Of Answer" required="required" />
							</div>
						</div>
						<div class="form-group">                    
							<label class="col-sm-2 control-label">Right Answer</label>
							<div class="col-sm-10 col-md-8">                         
								<input type="text" name="right-ans" class="form-control" autocomplete="off" placeholder="Text Of Right Answer" required="required" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" value="Add Question" class="btn btn-primary " />
							</div>
                   		</div>
                   
				   
					
					</form>
				</div>
			
			
		<?php }
		
		elseif($do == 'Insert') { // Starting Insert Page
			
			
			echo "<div class='container'>" ;
			
			
			if($_SERVER['REQUEST_METHOD'] == 'POST') {
				
				// Getting Data From The Question Form 
				
				$questionName = $_POST['question-name'] ;
				$answer1 = $_POST['ans1'] ;
				$answer2 = $_POST['ans2'] ;
				$answer3 = $_POST['ans3'] ;
				$answer4 = $_POST['ans4'] ;
				$rightAnswer = $_POST['right-ans'] ;
				
				
				$stmt = $conn->prepare("INSERT INTO
												 questions(question)
											VALUES(?)") ;
				$stmt->execute(array($questionName)) ;
				$questionID = $conn->lastInsertId();
				
				echo $questionID ;
				
				$stmt2 = $conn->prepare("INSERT INTO 
											answers (ans1,ans2,ans3,ans4,correct_ans,questions_id)
										 VALUES 	(?,?,?,?,?,?)") ;
				$stmt2->execute(array($answer1,$answer2,$answer3,$answer4,$rightAnswer,$questionID)) ;
				
				
				
				
				
				
				
				
			}
		
			echo "</div>" ;
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}




?>