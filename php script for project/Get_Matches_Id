<?php  
 require "init.php";  
 $id=$_POST["id"];
 //$Batting_Team = $_POST["Bat"];  
 //$Scores =  $_POST["Score"];  
 $sql_query = "select n1,n2,n3,n4,n5 from teams where id like '$id' ;";  
 //where Batting_Team like '$Batting_Team' and Scores like '$Scores';";
 $result = mysqli_query($con,$sql_query);  
 if(mysqli_num_rows($result) >0 )  
 {  
 $row = mysqli_fetch_assoc($result);  
 $p1 =$row["n1"];
 $p2 =$row["n2"];
 $p3 =$row["n3"];
 $p4 =$row["n4"]; 
 $p5 =$row["n5"]; 
 echo "Team  = ".$p1;
 echo "				".$p2;
 echo "				".$p3;
 echo "				".$p4; 
 echo "				".$p5; 
 }  
 else  
 {   
 echo "Login Failed.......Try Again..";  
 }  
 ?>