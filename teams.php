<?php  
 require "init.php";  
 $id =$_POST["id"]; 
 $type =$_POST["type"];  
 $n1 =$_POST["n1"];  
 $n2 =$_POST["n2"];  
 $n3 =$_POST["n3"]; 
 $n4 =$_POST["n4"]; 
$n5 =$_POST["n5"];  
 
 // $sql_query = "insert into teams values('$id','$type','$n1','$n2','$n3','$n4','$n5');"; 
	 
 if($type=='i') 
 {
	  $sql_query = "insert into teams values('$id','$type','$n1','$n2','$n3','$n4','$n5');";  
	 
 }
 if($type=='d') 
 {
	  $sql_query ="DELETE FROM teams WHERE id='$id';";
	 
 }
 if($type=='u') 
 {
	 $sql_query = "UPDATE teams SET id='$id',type='$type',n1='$n1',n2='$n2',n3='$n3'
 ,n4='$n4',n5='$n5'WHERE id='$id';"; 
	 
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
