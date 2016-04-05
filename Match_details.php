<?php  
 require "init.php";  
 $id=$_POST["id"];
 //$Batting_Team = $_POST["Bat"];  
 //$Scores =  $_POST["Score"];  
 $sql_query = "select team1,team2,toss,bat,bowl from match_details where id like '$id' ;";  
 //where Batting_Team like '$Batting_Team' and Scores like '$Scores';";
 $result = mysqli_query($con,$sql_query);  
 if(mysqli_num_rows($result) >0 )  
 {  
 $row = mysqli_fetch_assoc($result);  
 $team1 =$row["team1"];
 $team2 =$row["team2"];
 $toss =$row["toss"];
 $bat =$row["bat"];
$bowl =$row["bowl"]; 
echo"        "; 
echo"Match Details									        ";
echo $team1;echo"       vs";
echo "               "      .$team2;
echo "		"      .$toss;
echo "   Won the toss";
echo "                  "      .$bat;
echo "   Batting first";
echo "                  "      .$bowl;
echo "   Bowling first";  
 }  
 else  
 {   
 echo "Login Failed.......Try Again..";  
 }  
 ?>