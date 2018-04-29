<?php
	$con = mysql_connect("localhost","root", "0", "ItNews") 

	if (mysql_connect_errno($con)){
		echo "Failed to connect to Mysql: " . mysql_connect_error();
		exit();
	}

	if (!$con->set_charset("utf8")){
		printf("Mistake with charset", $mysqli->error);
		exit();
	}

	$id = $_POST['id'];
	