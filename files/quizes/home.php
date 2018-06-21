<?php
	
	session_start();
	
	$nonavbar = '' ;
	$pageTitle = 'Home' ;
	include 'init.php' ;
		
	?>

		<div class="bg"></div>
		<div class="container">
			<h4 class="title">Welcome To Our Exam System</h4>
		</div>


	<?php
	
	$name = $_SESSION['Username'] ; 

	// Getting User Profile 

	$stmt = $conn->prepare("SELECT * FROM signup WHERE name = ?") ;
	$stmt->execute(array($name)) ; 
	$row = $stmt->fetchAll() ; 

	 // Getting Subjects 


	$stmt1 = $conn->prepare("SELECT * FROM subject") ;
	$stmt1->execute() ;
	$subjects = $stmt1->fetchAll();


	
	// Footer
	include $tpl.'footer.php' ;
	


?>


<div class="container">
	<h2></h2>
	<ul class="nav nav-tabs">
		<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
		<li><a data-toggle="tab" href="#menu1">Profile</a></li>
		<li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
		<li style="float:right"><a href="logout.php">Logout</a></li>
	</ul>

	<div class="tab-content">
		<div id="home" class="tab-pane fade in active">
		  
			
			<center><button type="button" class="starting btn btn-primary" data-toggle="tab" href="#select">Start Exam</button></center>
	
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			
		  <div id="select" class="tab-pane fade">
			  
			  <form action="show_ques.php" method="POST">		
				  <select class="form-control sel-home" id="#select" name="subject">

					  <option>Select Subject ..</option>

					   <?php

							if($stmt1->rowCount() > 0) {

								foreach($subjects as $subject) { ?>

									<option value="<?php echo $subject['id'] ; ?>" ><?php echo $subject['subj_name'] ; ?></option>

								<?php }


							}


						?>




				  </select>
				  <center><input type="submit" class="starting btn btn-primary"
								 value="Let's Go" id="go-btn"/></center>
			  </form>
		  </div>	  
			
	
		</div>

		</div>
		<div id="menu1" class="tab-pane fade">
			<h3>My Profile</h3>
			<table class="table">
				<thead>
				  <tr>
					<th>ID</th>
					<th>Name</th>
					<th>Img</th>
				  </tr>
				</thead>
				<tbody>
					
					<?php
					
						foreach($row as $data) { ?>
					
												
						  <tr>
							<td><?php echo $data['id'] ; ?></td>
							<td><?php echo $data['name'] ; ?></td>
							<td><img src="img/<?php echo $data['img'] ; ?>" width="35px" height="30px" alt="My Pic" /></td>
						  </tr>										
							
							
						<?php }								
					?>
					
					
					

				
				</tbody>
  			</table>
			
		  
		</div>
		<div id="menu2" class="tab-pane fade">
		  <h3>Menu 2</h3>
		  <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
		</div>
		<div id="menu3" class="tab-pane fade">
		  <h3>Menu 3</h3>
		  <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
		</div>
	</div>
</div>
