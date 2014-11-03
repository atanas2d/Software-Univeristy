<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Problem 7: Form Data</title>
</head>
<body>
<h1>Form Data:</h1>

<form action="" method="get">
    <input type="text" name="name" placeholder="Name.."/><br/>
    <input type="number" name="age" placeholder="Age..."/><br/>
    <input type="radio" name="sex" value="male" id="m"/><label for="m">Male</label><br/>
    <input type="radio" name="sex" value="female" id="f"/><label for="f">Female</label><br/>
    <input type="submit"/>
</form>
<?php

if(isset($_GET["name"]) && isset($_GET["age"]) && isset($_GET["sex"])) { ?>
<p>My name is <?php echo $_GET["name"] . ". I am " . $_GET["age"] . "years old. I am " . $_GET["sex"] ?>.</p>

<?php } ?>

</body>
</html>