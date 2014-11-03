<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Problem 5: Lazy Sundays</title>
</head>
<body>
<?php
$year = 2014;
$currentMonth = date('F');
$daysNum = date('t');
$today = date ('jS');
function getWeekDay($day,$month,$year){
    return date("l",strtotime($day.'-'.$month.'-'.$year));
}
for ($i = 1; $i <= $daysNum; $i++) {
    if (getWeekDay($i, $currentMonth, $year) == "Sunday") {
        echo date('jS', strtotime($i.'-'.$currentMonth.'-'.$year)). ' ' . $currentMonth . ', '. $year ."<br>\n";
    }
}

?>
</body>
</html>