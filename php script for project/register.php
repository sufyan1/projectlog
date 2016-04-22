<?php  
 require "init.php";  
 $id=$_POST["id"];
 $name =$_POST["user"];  
 $team_score =$_POST["team_score"];  
 $team_wickets =$_POST["team_wickets"]; 
 $Get_overs =$_POST["Get_overs"];
$Totalovers =$_POST["Totalovers"]; 
$type =$_POST["type"]; 
  


if($type=='i') 
 {
	  $sql_query = "insert into live_score values('$id','$name','$team_score','$team_wickets','$Get_overs','$Totalovers');"; 
	 
 }
   
 if($type=='d') 
 {
	  $sql_query ="DELETE FROM live_score WHERE id='$id';";
	 
 }
 if($type=='u') 
 {
	 $sql_query = "UPDATE live_score SET id='$id',Total_overs='$Totalovers',Overs='$Get_overs',Team='$name'
 ,Scores='$team_score',Wickets='$team_wickets'WHERE id=$id;"; 
	 
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
