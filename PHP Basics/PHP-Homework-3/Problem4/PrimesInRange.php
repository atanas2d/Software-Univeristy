<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Problem 4 - Find Primes in Range </title>
</head>
<body>
<form action="" method="post">
    <label for="start">Starting index:</label>
    <input type="text" id="start" name="start" placeholder="..."/>
    <label for="end">End:</label>
    <input type="text" id="end" name="end" placeholder="..."/>
    <input type="submit" value="Show result" name="submitBtn"/> <br/> <br/>
</form>

<?php
if(isset($_REQUEST["submitBtn"])) {
    $start = htmlentities($_POST["start"]);
    $start = trim($start);
    $end = htmlentities($_POST["end"]);
    $end = trim($end);

    function isPrime($num) {
        for($i = 2; $i < $num; $i++) {
            	   //if $i is a divisor of $num, then the number is not prime
           if($num % $i == 0) {
                 return false;
           }
        }
        return true;
    }
    if ((!is_numeric($start) || $start < 1) || (!is_numeric($end) || $end < 1) || $start > $end) {
        echo "Wrong input.";
    } else {
        for ($i = $start; $i <= $end; $i++ ) {
            if (isPrime($i)) {
                echo "<b>" . $i . "</b>";
            } else {
                echo $i;
            }
            if ($i < $end) {
                echo ", ";
            }
        }
    }
}
?>
</body>
</html>