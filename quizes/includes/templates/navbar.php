        <nav class="navbar navbar-inverse">
          <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#app-navigation"expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">Hi</a> 
            </div>
            <div class="collapse navbar-collapse" id="app-navigation">
              <ul class="nav navbar-nav">
                  
                <li><a href="categories.php"><?php echo lang('CATEGORIES')?></a></li>
                <li><a href="items.php"><?php echo lang('ITEMS')?></a></li>
                <li><a href="members.php"><?php echo lang('MEMBERS')?></a></li>
                <li><a href="#"><?php echo lang('STATISTICS')?></a></li>
                <li><a href="#"><?php echo lang('LOGS')?></a></li>       
                
              </ul>

              <ul class="nav navbar-nav navbar-right">
               
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="brand-left">HeshamElalawy</span> <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="members.php?do=Edit&UserID=<?php echo $_SESSION['ID']?>">Edit Profile</a></li>
                    <li><a href="#">Settings</a></li>
                    <li><a href="logout.php">Logout</a></li>
                    <li><a href="logout.php">Home</a></li>
                    <li><a href="logout.php">Categoo</a></li>

                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </nav>