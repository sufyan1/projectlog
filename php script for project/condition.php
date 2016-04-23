<?php  
 require "init.php";  
 $id =$_POST["id"]; 
 $type =$_POST["type"];
 $weather =$_POST["weather"];
 $pitch =$_POST["pitch"];  
 $venue =$_POST["venue"];  
   
 
 // $sql_query = "insert into teams values('$id','$type','$n1','$n2','$n3','$n4','$n5');"; 
	 
 if($type=='i') 
 {
	  $sql_query = "insert into conditions values('$id','$type','$weather','$pitch','$venue');";  
	 
 }
 if($type=='d') 
 {
	  $sql_query ="DELETE FROM conditions WHERE id='$id';";
	 
 }
 if($type=='u') 
 {
	 $sql_query = "UPDATE conditions SET id='$id',type='$type',weather='$weather',pitch='$pitch',venue='$venue';"; 
	 
 } 
 
 if(mysqli_query($con,$sql_query))  
 {  
 
 echo "data inserted ";  
 }  
 else  
 {   
 echo "Failed.......Try Again..".mysqli_error($con);  
 }  
 ?>  
