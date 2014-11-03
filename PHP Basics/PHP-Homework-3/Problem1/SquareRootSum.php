<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Problem 1 - Square Root Sum</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Numbers</th>
        <th>Square</th>
    </tr>
    </thead>
    <tbody>
    <?php
        $sum = 0;
        for ($i = 0; $i <= 100; $i += 2) {
            echo "<tr>"
                . "<td>" . $i . "</td>"
                . "<td>" . round(sqrt($i),2) . "</td>"
                ."</tr>";
            $sum += round(sqrt($i),2);
        }
    ?>
    </tbody>
    <tfoot>
    <tr>
        <th>
            Total:
        </th>
        <td>
            <?php
                echo $sum;
            ?>
        </td>
    </tr>
    </tfoot>
</table>

</body>
</html>