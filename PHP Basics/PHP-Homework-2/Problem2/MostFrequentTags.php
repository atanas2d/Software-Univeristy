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
<form action="" method="post">
    <label for="txt">Enter Tags:</label><br/>
    <input type="text" name="text-box" placeholder="Enter tags here" id="txt"/>
    <input type="submit" name="submit-btn"/><br/>
    <?php
    if(isset($_REQUEST['submit-btn'])) {
        $txtBox = htmlentities($_POST["text-box"]);
        if ($txtBox == "") {
            echo 'No tags entered.';
        } else {
            $tags = explode(",", $txtBox);
            foreach ($tags as $key => &$tag) {
                $tag = trim($tag);
            }
            $sortedTags = array_count_values($tags);
            arsort($sortedTags);
            foreach ($sortedTags as $key => $value) {
                echo $key . ' : ' . $value . ' times' . '<br/>';
            }
            echo '<br/>';
            $firstVal = array_values($sortedTags)[0];
            if ($firstVal < 2) {
                echo 'There is no repeating tags.';
            } else if ($firstVal > array_values($sortedTags)[1]) {
                $key = array_search($firstVal, $sortedTags);
                echo 'Most Frequent Tag is: ' . $key;
            } else {
                $key = array_search(array_values($sortedTags)[0], $sortedTags);
                echo 'Most Frequent Tag are: "' . $key . '"';

                foreach ($sortedTags as $k => $v) {
                    if ($k != $key && $v == $firstVal) {
                        echo ' and "' . $k . '"';
                    }
                }

            }
        }
    }
    ?>
</form>
</body>
</html>