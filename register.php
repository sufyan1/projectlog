<?php  
 require "init.php";  
 $name =$_POST["user"];  
 $team_score =$_POST["team_score"];  
 $team_wickets =$_POST["team_wickets"]; 
 $Get_overs =$_POST["Get_overs"];  
 //$team1 =$_POST["team1"];  
 //$team2 =$_POST["team2"];  
 
 $sql_query = "insert into user_info values('$name','$team_score','$team_wickets','$Get_overs');";  
 //$sql_query = "insert into teams values('$team1','$team2');"; 
 if(mysqli_query($con,$sql_query))  
  
 {  
 
 echo "data inserted ";  
 }  
 else  
 {   
 echo "Failed.......Try Again..".mysqli_error($con);  
 }  
 ?>  
