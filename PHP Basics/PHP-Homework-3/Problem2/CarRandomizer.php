<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Problem 2 - Rich People's Problems</title>
</head>
<body>
<form action="" method="post">
    <label for="carsInput">Enter cars:</label>
    <input type="text" id="carsInput" name="carsInput" placeholder="Band1, Brand2..."/>
    <input type="submit" value="Show result" name="submitBtn"/> <br/> <br/>
</form>

<?php
if(isset($_REQUEST["submitBtn"])) {
    $carsStr = htmlentities($_POST["carsInput"]);
    $carsStr = trim($carsStr);
    if ($carsStr == "") {
        echo "No cars entered.";
    } else {
        $colors = ['black', 'blue', 'purple', 'white', 'yellow'];
        $cars = explode(",", $carsStr);
        echo "<table>
        <thead>
        <tr>
        <th>Car</th>
        <th>Color</th>
        <th>Count</th>
        </tr>
        </thead>
        <tbody>";


        foreach ($cars as $car) {
            $car = trim($car);
            $color = array_rand($colors,1);
            echo "<tr>
            <td>" . $car . "</td>
            <td>". $colors[$color] ."</td>
            <td>". rand(1,5) ."</td>
            </tr>";
        }


        echo "
        </tbody>
        </table>";


    }

}
?>
</body>
</html>