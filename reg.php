<?php

	define('host', 'localhost');
	define('user', 'nostro');
	define('password', '***');
	define('db', '***');

	if ($_SERVER['REQUEST_METHOD'] == 'POST') {

		$login = $_POST['login'];
		$password = $_POST['password'];

		if ($login == '' || $password == '') {
			exit("fail");
		}

		$connection = mysqli_connect(host, user, password, db) or die("Unable to connect with mysql");

		$query = "INSERT INTO users(login, password) VALUES('$login', '$password')";
		$result = mysqli_query($connection, $query);
		$data = mysql_fetch_array($result);

		if (isset($data)) {
			echo "success";
		}
		else {
			echo "fail";
		}

		mysqli_close();

	}

?>