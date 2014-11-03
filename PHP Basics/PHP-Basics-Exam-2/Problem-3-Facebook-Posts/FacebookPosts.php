<?php
//for test
//ini_set('display_errors',1);
//ini_set('display_startup_errors',1);
//error_reporting(-1);

date_default_timezone_set('Europe/Sofia');

$postsText = $_GET['text'];

// divide posts \n

$postsArray = preg_split('/\r?\n/',$postsText, -1, PREG_SPLIT_NO_EMPTY);

$output = '';

$postObjects = [];

foreach ($postsArray as $post) {

    $post = trim($post);

    $currentPost = new stdClass();

    $pattern = '/\s*(.+)\s*;\s*(\d{1,2}-\d{1,2}-\d{4})\s*;\s*(.+)\s*;\s*(\d{1,4})\s*;\s*(.*)\s*/';

    preg_match_all($pattern, $post, $matches);

    $author = trim($matches[1][0]);

    $dateInputStr = trim($matches[2][0]);
    $date = DateTime::createFromFormat('d-m-Y', $dateInputStr);
    $dateOutputStr = $date->format('j F Y');

    $postMsg = trim($matches[3][0]);

    $likesNum = intval(trim($matches[4][0]));

    $comments = trim($matches[5][0]);

    $currentPost->author = $author;
    $currentPost->date = $date;
    $currentPost->post = $postMsg;
    $currentPost->likes = $likesNum;
    $currentPost->comments = $comments;

    $postObjects[] = $currentPost;
}

usort($postObjects, 'sort_objects_by_date');


foreach ($postObjects as $post) {

    $output .= '<article>';

    $dateOutputStr = $post->date->format('j F Y');
    $output .= "<header><span>". htmlspecialchars($post->author) ."</span><time>"
        . htmlspecialchars($dateOutputStr) ."</time></header>";

    $output .= "<main><p>". htmlspecialchars($post->post)  ."</p></main>";

    if ($post->comments == '') {
        $output .= "<footer><div class=\"likes\">". htmlspecialchars($post->likes) ." people like this</div></footer>";
    } else {
        $output .= "<footer><div class=\"likes\">". htmlspecialchars($post->likes) ." people like this</div><div class=\"comments\">";

        $parsedComments = preg_split('/\//', $post->comments, -1, PREG_SPLIT_NO_EMPTY);

        foreach ($parsedComments as $comment) {
            $output .= "<p>". htmlspecialchars(trim($comment)) ."</p>";
        }

        $output .= '</div></footer>';
    }

    $output .= '</article>';
}

echo $output;

function sort_objects_by_date($a, $b) {
    return ($a->date < $b->date) ? 1 : -1;
}