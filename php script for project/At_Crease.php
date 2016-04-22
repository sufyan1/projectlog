<?php  
 require "init.php";  
 $id=$_POST["id"];
 //$Batting_Team = $_POST["Bat"];  
 //$Scores =  $_POST["Score"];  
 $sql_query = "select batsman,bowler from current_batsman where id like '$id' ;";  
 //where Batting_Team like '$Batting_Team' and Scores like '$Scores';";
 $result = mysqli_query($con,$sql_query);  
 if(mysqli_num_rows($result) >0 )  
 {  
 $row = mysqli_fetch_assoc($result);  
 $batsman =$row["batsman"];
 $bowler =$row["bowler"];
  
echo"        "; 
echo"Batsman At Crease									        ";
echo "                  "      .$batsman;
echo "   On Strike";
echo "                          "      .$bowler;
echo "   Bowler Bowling";  
 }  
 else  
 {   
 echo "Login Failed.......Try Again..";  
 }  
 ?>