<?php

header('Content-Type: text/html; charset=utf-8');
date_default_timezone_set('Europe/Sofia');

$currentTime = $_GET['currentDate'];
$messages = $_GET['messages'];

//$currentTime = '29-08-1999 15:33:11';
//$messages = "Kaji na mama che q obicham / 29-08-2014 15:32:23 \n Zdravey, kak mina izpita? / 29-08-2014 15:30:32 \n Brat sgashtiha me da prepisvam i me karat v raionnoto... / 29-08-2014 15:30:58";

$messages = explode("\n",$messages);
$mArr = array();

foreach ($messages as $key => $message) {

    $message = trim($message);
    if (preg_match("/[\\/]/", $message)) {
        $arr = explode(" / ", $message);
        $arr[0] = trim($arr[0]);
        $arr[1] = trim($arr[1]);
        $mArr[$arr[1]] = $arr[0];
    }

}

ksort($mArr);

end($mArr);

$lastKey = key($mArr);
reset($mArr);
$currentTime = trim($currentTime);
// determine last message:
$date1 = new DateTime($currentTime);
$date2 = new DateTime($lastKey);
$interval = date_diff($date1,$date2);


if (($date1->format('Y') - $date2->format('Y') == 0) && // check for yesterday
    ($date1->format('m') - $date2->format('m') == 0) &&
    ($date1->format('d') - $date2->format('d') == 1)) {
    $timeStamp = 'yesterday';
} else if ($interval->y == 0 && $interval->m == 0 &&
    $interval->d == 0 && $interval->h == 0 && $interval->i == 0) { // check for a few moments ago
    $timeStamp = 'a few moments ago';
} else if ($interval->y == 0 && $interval->m == 0 &&
    $interval->d == 0 && $interval->h == 0) {               // check * minute(s) ago
    $timeStamp = $interval->i . ' minute(s) ago';
} else if ($interval->y == 0 && $interval->m == 0 &&
    $interval->d == 0) {                                  // check * hour(s) ago
    $timeStamp = $interval->h . ' hour(s) ago';
} else {                                      // date in dd-mm-YYYY
    $timeStamp = $date2->format("d-m-Y");
}
foreach ($mArr as $date => $message) {
    echo "<div>".htmlspecialchars(utf8_encode($message))."</div>\n";
}
echo "<p>Last active: <time>" . $timeStamp . "</time></p>";