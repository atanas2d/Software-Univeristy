<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Problem 5 - Sum of Digits</title>
</head>
<body>
<form action="" method="post">
    <label for="digits">Input string:</label>
    <input type="text" id="digits" name="digits" placeholder="..."/>
    <input type="submit" value="Show result" name="submitBtn"/> <br/> <br/>
</form>

<?php
if(isset($_REQUEST["submitBtn"])) {
    $digitsStr = htmlentities($_POST["digits"]);
    $digitsStr = trim($digitsStr);
    if ($digitsStr == "") {
        echo "No string entered.";
    } else {
        $digits = explode(",", $digitsStr);
        echo "<table>
        <tbody>";

        foreach ($digits as $digit) {
            $digit = trim($digit);
            echo "<tr> <td>". $digit ."</td>";
            if (!is_numeric($digit)) {
                echo "<td> I cannot sum that </td>";
            } else {
                $sum = 0;
                for ($ii = 0; $ii < strlen($digit); $ii++) {
                    $sum += (int)$digit[$ii];
                }
                echo "<td>". $sum ."</td>";
            }
            echo "</tr>";

        }

        echo "
        </tbody>
        </table>";
    }
}
?>
</body>
</html>