<?php

    session_start();

    $nonavbar = '' ;
    $pageTitle = 'Admin Login' ;
    

    if(isset($_SESSION['Admin_Username'])){
//       
//        header('Location: dashboard.php'); // Redirect to dashboard Page
//        exit();
    }
    
    include 'init.php';
    


    // Checking if User coming from http Request

    if($_SERVER['REQUEST_METHOD'] == 'POST'){
        
        $username = $_POST['user'];
        $password = $_POST['pass'];
        $hashedPass = sha1($password);
        
        // Check IF The User Exist In The DB
        
        $stmt = $conn->prepare("SELECT 
                                        id , fname , password 
                                FROM 
                                        professor 
                                WHERE 
                                        fname = ? 
                                AND 
                                        password = ? 
                                
                                LIMIT   1 ");
        
        $stmt->execute(array($username , $hashedPass));
        $row = $stmt->fetch();
        $count = $stmt->rowCount();
        
          
        
        // The User Exist If Count > 0 
        
        if($count > 0) {
            //echo 'Welcome '.$username;
            $_SESSION['Admin_Username'] = $username; // Register Session 
            $_SESSION['Admin_ID'] = $row['UserID'] ;
            header('Location: dashboard.php'); // Redirect to dashboard Page
            exit();
        }
        
    }

?>

    

    <form class="login" action="<?php echo $_SERVER['PHP_SELF'] ?>" method="POST">
        
        <input class="form-control" type="text" name="user" placeholder="Username" autocomplete="off" />
        <input class="form-control" type=password name="pass" placeholder="Password" autocomplete="new-password" />
        <input class="btn btn-primary btn-block" type="submit" value="Login" />    
        
        
    </form>





<?php 
    
    include $tpl.'footer.php';
?>