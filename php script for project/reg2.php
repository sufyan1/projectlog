<?php  
 require "init.php";  
 $id =$_POST["id"]; 
 $team1 =$_POST["team1"];  
 $team2 =$_POST["team2"];  
 $toss =$_POST["toss"];  
 $batting =$_POST["batting"]; 
 $bowling =$_POST["bowling"]; 
$type =$_POST["type"];  
 
 
  
 if($type=='i') 
 {
	  $sql_query = "insert into match_details values('$id','$team1','$team2','$toss','$batting','$bowling');"; 
	 
 }
 if($type=='d') 
 {
	  $sql_query ="DELETE FROM match_details WHERE id='$id';";
	 
 }
 if($type=='u') 
 {
	 $sql_query = "UPDATE match_details SET id='$id',team1='$team1',team2='$team2',toss='$toss'
 ,bat='$batting',bowl='$bowling'WHERE id='$id';"; 
	 
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
