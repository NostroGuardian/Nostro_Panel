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

		$connection = mysqli_connect(host, user, password, db) or die("Unable to connect");

		$query = "SELECT * FROM users WHERE login = '$login' AND password = '$password'";
		$result = mysqli_query($connection, $query);
		$data = mysqli_fetch_array($result);

		if (isset($data)) {
			echo "login";
		}
		else {
			echo "fail";
		}

		mysqli_close($connection);

	}

?>