<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Problem 1: Print Tags</title>
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
                echo $key . ': ' . $tag . '<br/>';
            }
        }
    }
    ?>
</form>
</body>
</html>


