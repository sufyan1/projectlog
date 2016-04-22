<?php  
require "init.php";  
$id=$_POST["id"];
$bat =$_POST["bat"];  
$bowl =$_POST["bowl"]; 
$type =$_POST["type"];  
 
  

 
 if($type=='i') 
 {
	$sql_query = "insert into current_batsman values('$bat','$bowl','$id');";  
	 
 }
 if($type=='d') 
 {
	  $sql_query ="DELETE FROM current_batsman WHERE id='$id';";
	 
 }
  if($type=='u') 
 {
	 $sql_query ="UPDATE current_batsman SET id='$id',batsman='$bat',bowler='$bowl'WHERE id=$id;";
	 
 }
	 
 if(mysqli_query($con,$sql_query))  
 // if(mysqli_query($con,$sql_query2)) 
 {  
 
 echo "data inserted ";  
 }  
 else  
 {   
 echo "Failed.......Try Again..".mysqli_error($con);  
 }  
 ?>  
