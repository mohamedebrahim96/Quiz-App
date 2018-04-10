<?php

	 session_start();
	include 'init.php' ;




?>

		<div class="home-stats">
            <div class="container">
                 <h1 class="text-center h1-members">Dashboard</h1>
                 <div class="row">
                     <div class="col-md-3">
                         <div class="stat st-members">
                             Total Students
                             <span><a href="members.php">50</a></span>
                         </div>
                     </div>
                     <div class="col-md-3">
                         <div class="stat st-pending">
                             Pending Students
                             <span><a href="members.php?do=Manage&page=Pending">
                                120
                             </a></span>
                         </div>
                     </div>
                     <div class="col-md-3">
                         <div class="stat st-items">
                             Subjetcs
                             <span>15</span>
                         </div>
                     </div>
                     <div class="col-md-3">
                         <div class="stat st-comments">
                             Total Questions
                             <span>260</span>
                         </div>
                     </div>
                 </div>
            </div>
       </div>


<div class="latest">
            <div class="container">
             
                 <div class="row">
                     <div class="col-sm-6">
                         <div class="panel panel-default">                         
                             <div class="panel-heading">
                                 <i class="fa fa-users"></i> Latest 5 Registered Students
                             </div>
                             <div class="panel-body">
                                <ul class="list-unstyled latest-user">
                                   
                                </ul>
                             </div>
                         </div>
                     </div>
                     
                     <div class="col-sm-6">
                         <div class="panel panel-default">
                             <div class="panel-heading">
                                 <i class="fa fa-tag"></i> Latest Exams
                             </div>
                             <div class="panel-body">
                                 <ul class="list-unstyled latest-user">
                                                                       
                                 </ul>
                             </div>
                         </div>
                     </div>
                     
                 </div>
                 
             
            </div>
       </div>
       











<?php 
    
    include $tpl.'footer.php';
?>