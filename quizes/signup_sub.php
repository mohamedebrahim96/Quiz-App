<?php


 $pageTitle = 'SignUp' ;
 $noNavBar = '' ;

	include 'init.php' ;


	if($_SERVER['REQUEST_METHOD'] == 'POST') {
		
		
		extract($_POST) ;

		$formErrors = array() ;


		if(empty($name)) {

			$formErrors[] = 'User Name Can\'t Be <strong>Empty</Strong>' ;

		}	

		if(strlen($name) < 4) {
				$formErrors[] = 'User Name Can\'t Be Less Than <strong>4 Chars</Strong>' ;
			}


		if(empty($pass)) {
			$formErrors[] = 'Empty <strong>Pass</strong>' ;
		}

		if(strlen($pass) < 6) {

			$formErrors[] = 'Pass Less Than <strong>6</strong> Digits' ;

		}

		if(empty($confirm)) {
			$formErrors[] = 'Empty <strong>Pass</strong>' ;
		}

		if(strlen($confirm) < 6) {

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


			$img_name = $_FILES['img']['name'] ;
			$tmp_name = $_FILES['img']['tmp_name'];
			move_uploaded_file($tmp_name,'img/'.$img_name) ;
			
			
			$hashedPass = sha1($pass) ;

			$query = "INSERT INTO signup VALUES ('','$name','$hashedPass','$img_name')" ;


			$stmt = $conn->prepare($query) ;
			$stmt->execute();


			if($stmt->rowCount() > 0) {

				header('Location: index.php?run=success'); // Redirect to dashboard Page
				exit();

			}

		}

	}

	




?>