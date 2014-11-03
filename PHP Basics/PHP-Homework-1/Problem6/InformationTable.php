<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Problem 6: HTML Table</title>
    <style>
        body > table {
            border: 3px solid darkgray;
        }
        body > table td {
            background: lightgray;
            margin: 3px;
            padding: 3px;
        }
    </style>
</head>
<body>
<?php
$name = "Gosho";
$tel = "0882-321-423";
$age = 24;
$address = "Hadji Dimitar";
?>
<table>
    <tr>
        <td><b>Name</b></td>
        <td><?php echo $name ?></td>
    </tr>
    <tr>
        <td><b>Phone number </b></td>
        <td><?php echo $tel ?></td>
    </tr>
    <tr>
        <td><b>Age</b></td>
        <td><?php echo $age ?></td>
    </tr>
    <tr>
        <td><b>Address</b></td>
        <td><address><?php echo $address ?></address></td>
    </tr>
</table>
</body>
</html>