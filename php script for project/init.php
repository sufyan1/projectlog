<?php  
 $db_name = "webappdb";  
 $mysql_user = "root";  
 $mysql_pass = "sufi6321656";  
 $server_name = "localhost";  
 $con = mysqli_connect($server_name,$mysql_user,$mysql_pass,$db_name);  
 if(!$con)
 {
	 echo"error";
	 
	 
 }
 else
 {
	 echo"Live match Scores        			";
	 
 }
 ?>  