<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Problem 4: Non-Repeating Digits</title>
</head>
<body>
<?php
$N = 199;
echo "<p> N = " . $N . "</p><br>";

function areDigitsUnique($num) {
    $strNum = (string)$num;
    if ($strNum[0] != $strNum[1] && $strNum[1] != $strNum[2] && $strNum[0] != $strNum[2]) {
        return true;
    } else {
        return false;
    }
}
$isThereResult = false;
if ($N > 99 && $N < 1000) {
    for ($i = 100; $i <= $N; $i++) {
        if (areDigitsUnique($i)) {
            if (!$isThereResult) {
                echo $i;
                $isThereResult = true;
            } else {
                echo ", " . $i;
            }
        }
    }
} else if ($N > 99) {
    for ($i = 100; $i < 1000; $i++) {
        if (areDigitsUnique($i)) {
            if (!$isThereResult) {
                echo $i;
                $isThereResult = true;
            } else {
                echo ", " . $i;
            }
        }
    }
}
if (!$isThereResult) {
    echo "no";
}
?>
</body>
</html>