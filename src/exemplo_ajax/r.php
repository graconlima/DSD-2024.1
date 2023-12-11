<?php
	$a = fopen("a.txt", "r");
	$i = fgets($a);
	$i = ($i + 1);
	fclose($a);

	$a = fopen("a.txt", "w");
	fwrite($a, $i);
	fclose($a);

	$_POST["parametro"] = $i;
	echo json_encode($_POST);
?>