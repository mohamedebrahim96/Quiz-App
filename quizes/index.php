<?php

    session_start();

    $nonavbar = '' ;
    $pageTitle = 'Login' ;
    

    if(isset($_SESSION['Username'])){
       
        header('Location: home.php'); // Redirect to dashboard Page
       exit();
    }
    
    include 'init.php';
    
	// Loign Page

?>

<div class="bg"></div>

<div class="container">
	<h4 class="title">Welcome To Our Exam System</h4>
	<div class="row">
		
		<div class="col-md-6 col-sm-12">
			<div class="login-panel-box">
				<div class="panel panel-danger">
					<div class="panel-heading">Login</div>
					<div class="panel-body">
						
						<?php
						
							if(isset($_GET['run']) && $_GET['run'] == 'faild') {
								
								$faildMsg = "Username Or Password Is Wrong ." ;
							  														
								echo msg("faild" , $faildMsg) ;  
								
							}
						
						
						?>
						
						
						
						<form role="form" class="login" action="signin_sub.php" method="POST">

							
							<input type="text" class="form-control" placeholder="Username" name="user" autocomplete="off" required="required"/>
							<input type="password" class="form-control" placeholder="Password" name="pass" autocomplete="new-password" required="required" />

							<input class="btn btn-primary btn-block" type="submit" value="login" />

					   </form>
					</div>

				</div>
			</div>
		</div>
		<div class="col-md-6 col-sm-12">
			<div class="login-panel-box">
				<div class="panel panel-danger">
					<div class="panel-heading">Register</div>
					<div class="panel-body">
						
						<?php 
	
							if(isset($_GET['run'] )&& $_GET['run'] == 'success'){
								
								$msgSuccess = "SuccessFully Registered .. Will Activated Soon ." ;
							  														
								echo msg("success" , $msgSuccess) ;  }
							 
						?>
						
						<form role="form" class="login" action="signup_sub.php" method="POST" enctype="multipart/form-data">

							
							<input type="text" class="form-control" placeholder="Your Username" name="name" autocomplete="off" required="required"/>
							<input type="password" class="form-control" placeholder="Password" name="pass" autocomplete="new-password"required="required"/>
							<input type="password" class="form-control" placeholder="Confirm Password" name="confirm" autocomplete="new-password" required="required"/>
							<div class="form-group">
								<label>Upload Your Image</label>
								<input type="file" class="form-control" name="img" required="required" />
							</div>

							<input class="btn btn-primary btn-block" type="submit" value="SignUp" />

					   </form>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>








<?php 
    
    include $tpl.'footer.php';
?>










