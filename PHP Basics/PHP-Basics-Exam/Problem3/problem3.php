<?php
$text = $_GET['text'];
header('Content-Type: text/html; charset=utf-8');

//$text = 'The dangers of smoking%Dr. Elliot Hawking;13-06-2014-Recent research has proven that about 80% of all smokers, who smoke on a regular daily basis, are developing...
//Writing a quality CV%  Dr. Svetlin Nakov      ;18-12-2014-  Curriculum half-day free seminar to search and apply for a job(CV + cover letter) as a software engineer or IT specialist includes the most important issues involving the search for jobs, prepare application documents , application, preparation for interview and sitting for a job interview';

preg_match_all('|([\w\s-]+)%([\w\s\.-]+);(\d\d\-\d\d\-\d\d\d\d)-(.[^\n]+)|',
    $text, $out, PREG_SET_ORDER);


foreach ($out as $set) {
    $set[1] = trim($set[1]);
    $set[2] = trim($set[2]);
    $set[3] = trim($set[3]);

    $set[3] = new DateTime($set[3]);
    $set[3] = $set[3]->format('F');

    $set[4] = trim($set[4]);
    if (strlen($set[4]) > 100) {
        $l = strlen($set[4]);
        $set[4] = substr($set[4], -$l, 100);
    }
    $set[4] = $set[4]."...";

    echo "<div>\n<b>Topic:</b> <span>" . htmlspecialchars($set[1])  . "</span>\n";
    echo "<b>Author:</b> <span>" . htmlspecialchars($set[2]) . "</span>\n";
    echo "<b>When:</b> <span>" . htmlentities($set[3]) . "</span>\n";
    echo "<b>Summary:</b> <span>" . htmlspecialchars($set[4]) . "</span>\n";
    echo "</div>\n";
}
?>