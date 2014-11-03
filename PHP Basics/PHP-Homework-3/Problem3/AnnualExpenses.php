<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Problem 3 - Show Annual Expanses </title>
</head>
<body>
<form action="" method="post">
    <label for="nYears">Enter number of years:</label>
    <input type="text" id="nYears" name="nYears" placeholder="..."/>
    <input type="submit" value="Show result" name="submitBtn"/> <br/> <br/>
</form>

<?php
if(isset($_REQUEST["submitBtn"])) {
    $n = htmlentities($_POST["nYears"]);
    $n = trim($n);
    if (!is_numeric($n) || $n < 1) {
        echo "Wrong input.";
    } else {
        $n = (int)$n;

        echo "<table>
        <thead>
        <tr>
        <th>Year</th>
        <th>January</th>
        <th>February</th>
        <th>March</th>
        <th>April</th>
        <th>May</th>
        <th>June</th>
        <th>July</th>
        <th>August</th>
        <th>September</th>
        <th>October</th>
        <th>November</th>
        <th>December</th>
        <th>Total</th>
        </tr>
        </thead>
        <tbody>";

        $thisYear = date(Y);
        $thisYear = (int)$thisYear;
        for ($i = 0; $i < $n; $i++) {
            $sum = 0;
            echo "<tr>
                <td>". $thisYear-- ."</td>";
            for ($ii = 0; $ii < 12; $ii++) {
                $expens = rand(0,999);
                $sum += $expens;
                echo "<td>". $expens ."</td>";
            }
            echo "<td>". $sum ."</td>";
        }


        echo "
        </tbody>
        </table>";
    }
}
?>
</body>
</html>