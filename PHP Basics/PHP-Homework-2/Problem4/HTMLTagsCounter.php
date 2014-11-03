<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Problem 2: Most Frequent Tags</title>
    <style>
        body {
            font-family: sans-serif, Ariel;
        }
        body>form {
            border: 1px solid gray;
            padding: 10px;
            background: lightgray;
        }
        body>form>input {
            margin: 10px 0;
        }
    </style>
</head>
<body>
<form action="" method="post" id="my-form">
    <label for="txt">Enter HTML Tags:</label><br/>
    <input type="text" name="text-box" placeholder="Enter tags here" id="txt"/>
    <input type="submit" name="submit-btn"/><br/>
    <?php
    session_start();
    if (!isset($_SESSION["points"])) {
        $_SESSION['points'] = 0;
    }
    if(isset($_REQUEST['submit-btn'])) {
        $txtBox = htmlentities($_POST["text-box"]);
        if ($txtBox == "") {
            echo 'No tags entered.';
        } else {
            $validTags = [
                'body','html','head','br','table','div','section','article','label','form','input','a'.
                '!DOCTYPE','abbr','address','object','area','aside','audio','b','base','bdi','bdo',
                'blockquote','button','canvas','caption','cite','code','col','row','colgroup','datailist',
                'dd','del','details','dfn','dialog','dl','dt','em','embed','fieldest','figcaption','figure',
                'footer','form','h1','h2','h3','h4','h5','h6','header','hr','html','i','iframe','img',
                'ins','kbd','keygen','legend','li','link','main','map','mark','menu','menuitem','meta',
                'meter','nav','noscript','ol','optgroup','p','param','pre','progress','q','rp','rt',
                'ruby','s','samp','script','select','small','source','span','strong','style','sub',
                'summary','sup','tbody','td','textarea','tfoot','th','thead','time','title','tr','u',
                'ul','var','video','wbr'
            ];
            $valid = true;
            $multi = false;
            $tags = explode(",", $txtBox);
            if (count($tags) > 1) {
                $multi = true;
            }
            foreach ($tags as $key => &$tag) {
                $tag = trim($tag);
                if (!in_array($tag, $validTags)) {
                    $valid = false;
                }
            }
            if ($valid) {
                if ($multi) {
                    echo '<div> Valid HTML tags! </div>';
                    $_SESSION["points"] += count($tags);
                } else {
                    echo '<div> Valid HTML tag! </div>';
                    $_SESSION["points"] += count($tags);
                }
            } else {
                if ($multi) {
                    echo '<div> Invalid HTML tags! </div>';
                } else {
                    echo '<div> Invalid HTML tag! </div>';
                }
            }
        }
    }
    echo '<div><br/> Score: ' . $_SESSION["points"] . '</div>';
    ?>
</form>
</body>
</html>