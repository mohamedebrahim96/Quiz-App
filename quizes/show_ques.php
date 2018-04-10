<?php

	session_start() ;

	$nonavbar = '' ;

	include 'init.php' ;

	$subject =  $_POST['subject'] ;


	// Getting The Question According To Subject ID

	$stmt = $conn->prepare("SELECT * FROM questions WHERE subj_id = ?");
	$stmt->execute(array($subject)) ;
	$questions = $stmt->fetchAll() ;

//	echo "<pre>" ;
//	print_r($questions) ;
//	echo "</pre>" ; 

?> 


<div class="bg"></div>
<div class="container">
	<h4 class="title">Welcome To Our Exam System</h4>
</div>


<div class="container">
	
	
	
	<div class="col-sm-2"></div>	
	<div class="col-sm-8">
	</br>
	
	<form action="answers.php" method="POST">
	<?php
		
		$counter = 1 ;
		
		foreach($questions as $question) {  ?>
		
			
	
			<table class="table table-bordered">		
				<thead>
				  <tr class="ques">
					<th><?php echo $counter . ' - ' . $question['question'] ; ?></th>
				  </tr>
				</thead>
				<tbody>
					<?php if(isset($question['ans1'])) { ?>
		  			<tr class="ques-ans">
						<td>&nbsp;<span class="qno">1</span>&emsp;<input type="radio"
								   value="0" name="<?php echo $question['id'] ;?>" /> 
								   &nbsp;<?php echo $question['ans1'] ;  ?>
						</td>
				  	</tr>
					
					<?php } ?>
					
					<?php if(isset($question['ans2'])) { ?>
					<tr class="ques-ans">
						<td>&nbsp;<span class="qno">2</span>&emsp;<input type="radio"
								   value="1" name="<?php echo $question['id'] ;?>" /> 
								   &nbsp;<?php echo $question['ans2'] ;  ?>
						</td>
				  	</tr>
					<?php } ?>
					
					<?php if(isset($question['ans3'])) { ?>
					<tr class="ques-ans">
						<td>&nbsp;<span class="qno">3</span>&emsp;<input type="radio"
								   value="2" name="<?php echo $question['id'] ;?>" /> 
								   &nbsp;<?php echo $question['ans3'] ;  ?>
						</td>
				  	</tr>
					<?php } ?>
					
					<?php if(isset($question['ans4'])) { ?>
					<tr class="ques-ans">
						<td>&nbsp;<span class="qno">4</span>&emsp;<input type="radio"
								   value="3" name="<?php echo $question['id'] ;?>" /> 
								   &nbsp;<?php echo $question['ans4'] ;  ?>
						</td>
				  	</tr>
					<?php } ?>
					
					<tr class="ques-ans">
						<td><input type="radio" checked="checked" style="display:none"
								   value="no_attempts" name="<?php echo $question['id'] ;?>" /> 
								  
						</td>
				  	</tr>					
					
				</tbody>
			</table>
			
			
			
		<?php  $counter = $counter + 1 ; }
	?>
	
		<center><input type="submit" value="End Exam" class="starting btn btn-primary"/></center>
	                    
	</form>
	</div>			
</div>






	


?>