<?php

$word = $_GET['text'];
$red = intval($_GET['red']);
$green = intval($_GET['green']);
$blue = intval($_GET['blue']);
$nth = intval($_GET['nth']);

$output = '<p>';

$hexColor = RGBToHex($red, $green, $blue);

$wordLength = strlen($word);

for ($i = 0; $i < $wordLength; $i++) {
    if (($i + 1) % $nth == 0) { // color the letter
        $output .= "<span style=\"color: " . $hexColor . "\">" . htmlspecialchars($word[$i]) . "</span>";
    } else { // do nothing
        $output .= htmlspecialchars($word[$i]);
    }
}

$output .= '</p>';

function RGBToHex($r, $g, $b) {
    //String padding bug found and the solution put forth by Pete Williams (http://snipplr.com/users/PeteW)
    $hex = "#";
    $hex.= str_pad(dechex($r), 2, "0", STR_PAD_LEFT);
    $hex.= str_pad(dechex($g), 2, "0", STR_PAD_LEFT);
    $hex.= str_pad(dechex($b), 2, "0", STR_PAD_LEFT);

    return $hex;
}
echo $output;
