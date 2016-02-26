<?php  
 require "init.php";  
 $Batting_Team = $_POST["login_name"];  
 $Scores =  $_POST["login_pass"];  
 $sql_query = "select Batting_Team,Scores,Wickets,Overs from user_info where Batting_Team like '$Batting_Team' and Scores like '$Scores';";  
 $result = mysqli_query($con,$sql_query);  
 if(mysqli_num_rows($result) >0 )  
 {  
 $row = mysqli_fetch_assoc($result);  
 $Overs =$row["Overs"];
 $Batting_Team =$row["Batting_Team"];
 $Scores =$row["Scores"];
 $Wickets =$row["Wickets"]; 
 echo "Current Team batting = ".$Batting_Team;
 echo " Current Scores  = ".$Scores;
 echo " Wickets 		= ".$Wickets;
 echo " overs Bowled	= ".$Overs; 
 }  
 else  
 {   
 echo "Login Failed.......Try Again..";  
 }  
 ?>