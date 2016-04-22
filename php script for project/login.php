<?php  
 require "init.php";  
 $id=$_POST["id"];
 //$Batting_Team = $_POST["Bat"];  
 //$Scores =  $_POST["Score"];  
 $sql_query = "select Team,Scores,Wickets,Overs from live_score where id like '$id' ;";  
 //where Batting_Team like '$Batting_Team' and Scores like '$Scores';";
 $result = mysqli_query($con,$sql_query);  
 if(mysqli_num_rows($result) >0 )  
 {  
 $row = mysqli_fetch_assoc($result);  
 $Overs =$row["Overs"];
 $Team =$row["Team"];
 $Scores =$row["Scores"];
 $Wickets =$row["Wickets"]; 
 echo "Current Team batting = ".$Team;
 echo " Current Scores  = ".$Scores;
 echo " Wickets 		= ".$Wickets;
 echo " overs Bowled	= ".$Overs; 
 }  
 else  
 {   
 echo "Login Failed.......Try Again..";  
 }  
 ?>