<?php

	session_start();

	$pageTitle = 'SignUp' ;
 	$nonavbar = '' ;

	include 'init.php' ;

	

	if($_SERVER['REQUEST_METHOD'] == 'POST') {
		
		
		extract($_POST) ;
		
		
		$formErrors = array() ;


		if(empty($user)) {

			$formErrors[] = 'User Name Can\'t Be <strong>Empty</Strong>' ;

		}	

		if(strlen($user) < 4) {
				$formErrors[] = 'User Name Can\'t Be Less Than <strong>4 Chars</Strong>' ;
			}


		if(empty($pass)) {
			$formErrors[] = 'Empty <strong>Pass</strong>' ;
		}

		if(strlen($pass) < 6) {

			$formErrors[] = 'Pass Less Than <strong>6</strong> Digits' ;

		}

		if(!empty($formErrors)) { ?>


			<div class="container">
				
				<div class="row">					
						<div class="login-panel-box center">
						<div class="panel panel-danger">
							<div class="panel-heading">Register Form Errors</div>
							<div class="panel-body">

								<?php

										 foreach($formErrors as $error) {

											echo '<div class="alert alert-danger">'.$error.'</div>';

										}
										redirect("Redirecting ..");

								?>

							</div>
						</div>
					</div>					
				</div>
			</div>



			
		<?php }
		
		if(empty($formErrors))	 {
			
			
			// Checking The User 
			
			$stmt = $conn->prepare("SELECT 
											id , name , pass
									FROM
											signup
									WHERE
											name= ?
									AND
											pass= ?
									LIMIT 1") ;
			
			$hashedPass = sha1($pass) ;
			
			$stmt->execute(array($user , $hashedPass)) ;
			$row = $stmt->fetch();
			$count = $stmt->rowCount();
			
			
			// if User Exists
			
			if($count > 0) {
				
			  
				$_SESSION['Username'] = $user; // Register Session 
				$_SESSION['ID'] = $row['UserID'] ;
				header('Location: home.php'); // Redirect to dashboard Page
				exit();
				
				
			}else {
				
				header('Location: index.php?run=faild') ;
				
			}

			

			

			

		}


		
		
		
		
	}


	





?>