<?php  
 require "init.php";  
 //$id=$_POST["id"];
 //$Batting_Team = $_POST["Bat"];  
 //$Scores =  $_POST["Score"];  
 $sql_query = "select team1,team2,id from match_details ;";  
 //where Batting_Team like '$Batting_Team' and Scores like '$Scores';";
 $result = mysqli_query($con,$sql_query);  
 if(mysqli_num_rows($result) >1 )  
 { 
 for($i=0;$i<mysqli_num_rows($result);$i++)
 {
 //if(mysqli_num_rows($result) >1 )  
 //{  
 $row = mysqli_fetch_assoc($result);  
 $team1 =$row["team1"];
 $team2 =$row["team2"];
 $id =$row["id"];
 
//echo"        "; 
//echo"Match Details									        						";
echo"        ";
echo $team1;
echo"      ";
echo"vs".PHP_EOL;
echo "    "      .$team2;
echo "		ID = 	"      .$id;
echo"        ";
 
 } 
 }
 else  
 {   
 echo "Login Failed.......Try Again..";  
 }  
 ?>