<?php  
 require "init.php";  
 $Match_Number =$_POST["Match_Number"]; 
 $team1 =$_POST["team1"];  
 $team2 =$_POST["team2"];  
 $toss =$_POST["toss"];  
 $batting =$_POST["batting"]; 
 $bowling =$_POST["bowling"];  
 
 
 $sql_query = "insert into teams values('$team1','$team2','$Match_Number','$toss','$batting','$bowling');";  
 if(mysqli_query($con,$sql_query))  
  
 {  
 
 echo "data inserted ";  
 }  
 else  
 {   
 echo "Failed.......Try Again..".mysqli_error($con);  
 }  
 ?>  
