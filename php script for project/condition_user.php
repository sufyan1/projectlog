<?php  
 require "init.php";  
 $id=$_POST["id"];
 
 $sql_query = "select Weather,Pitch,Venue from conditions where id like '$id' ;";  
 //where Batting_Team like '$Batting_Team' and Scores like '$Scores';";
 $result = mysqli_query($con,$sql_query);  
 if(mysqli_num_rows($result) >0 )  
 {  
 $row = mysqli_fetch_assoc($result);  
 
 $Weather =$row["Weather"];
 $Pitch =$row["Pitch"]; 
 $Venue =$row["Venue"]; 
 //echo new line space;
echo"        											
																						
											";
echo "Weather Forcast =";
echo $Weather;
echo"        											
																						
											"; 
echo "Pitch Condition =";
echo $Pitch;
 //echo new line space;
echo"        											
																						
											"; 
echo "Live From =";
echo $Venue;
//echo new line space;

 }  
 else  
 {   
 echo"        																																	
											";
echo "Login Failed.......";
echo"        																																	
											";
echo "No Conditions Available for this Id Check Id and Try Again";
 }   
   
 ?>