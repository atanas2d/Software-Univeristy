<?php


$errorLog = $_GET['errorLog'];

$pattern = '/\s*Exception in thread "[\w]+" java\.([\w-]+[\.\w]*):[\w\s]+[\n]+[\s]+ at [\w-\. ]+\.([\w-]+)\(([\w-\. ]+):([\d]+)\)\s*/';

preg_match_all($pattern,$errorLog,$matches);

$output = "<ul>";

for ($i = 0; $i < count($matches[0]); $i++) {
    $lineNum = intval($matches[4][$i]);

    $exceptionsArr = explode(".",trim($matches[1][$i])) ;
    $exceptionName = array_pop($exceptionsArr) ;

    $fileName = trim($matches[3][$i]) ;
    $methodName = trim($matches[2][$i]) ;

    $output .= "<li>line <strong>" . htmlspecialchars($lineNum) . "</strong> - <strong>"
        . htmlspecialchars($exceptionName) . "</strong> in <em>"
        . htmlspecialchars($fileName) . ":" . htmlspecialchars($methodName)
        . "</em></li>";
}

$output .= "</ul>";

echo $output;