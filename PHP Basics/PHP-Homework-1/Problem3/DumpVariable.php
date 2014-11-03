<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Problem 3: Dump Variable</title>
</head>
<body>
<h1>4 variables dumped: </h1>
<?php
$var1 = 5;
$var2 = "haha";
$var3 = [1,2,3];
$var4 = (object) "hello obj";
echo "First var: "; var_dump($var1);
echo 'Second var: ';  var_dump($var2);
echo 'Third var: '; var_dump($var3);
echo 'Fourth var: '; var_dump($var4);
?>
</body>
</html>