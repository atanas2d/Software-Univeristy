<?php


//$text = 'Hi PHP5';
//$minFontSize = 4;
//$maxFontSize = 8;
//$step = 3;

$text = $_GET['text'];
$minFontSize = $_GET['minFontSize'];
$maxFontSize = $_GET['maxFontSize'];
$step = $_GET['step'];

    $textStr = str_split($text);
    $fontSize = 0;
    $direction = 'up';
    for ($i = 0; $i < count($textStr); $i++) {
        $char = $textStr[$i];
        ?><span style='font-size:<?php
            if($i == 0) {
                $fontSize = $minFontSize;
                echo $fontSize . ';';
                $fontSize += $step;

            } else if(ctype_alpha($char) && $maxFontSize>$minFontSize ) { // Not first char and letter:
                echo $fontSize . ';';
                // Determine fontSize:
                if ($fontSize < $maxFontSize && $direction == 'up') {
                    // increase font size
                    $fontSize += $step;
                } else {
                    // decrease font size
                    $direction = 'down';
                    $fontSize -= $step;
                    if ($fontSize == $minFontSize) {
                        // increase again
                        $direction = 'up';
                    }
                }
            } else {
                echo $fontSize . ';';
            }

        // Determine ASCII code to check if stroke is needed
        if (ord($char) % 2 == 0) { // even ASCII code
            echo 'text-decoration:line-through;';
        }

        ?>'><?php echo htmlspecialchars($textStr[$i])  ?></span><?php
    }

?>