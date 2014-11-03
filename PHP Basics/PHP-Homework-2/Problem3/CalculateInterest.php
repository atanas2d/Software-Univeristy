<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Problem 3: Calculate Interest</title>
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
            margin: 10px 5px;
            min-height: 20px;
            display: inline-block;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<form action="" method="post">
    <label for="amount">Enter Amount</label>
    <input type="number" name="amount" placeholder="Enter amount..." id="amount"/> <br/>
    
    <input type="radio" name="currency-type" value="usd" id="usd"/><label for="usd">USD</label>
    <input type="radio" name="currency-type" value="eur" id="eur"/><label for="eur">EUR</label>
    <input type="radio" name="currency-type" value="bgn" id="bgn"/><label for="bgn">BGN</label><br/>

    <label for="interest">Compound Interest Amount </label>
    <input type="number" name="interest" id="interest" placeholder="Interest amount..."/><br/>

    <select name="period" id="period">
        <option value="6" selected>6 Months</option>
        <option value="12" >1 Year</option>
        <option value="24" >2 Years</option>
        <option value="60" >5 Years</option>
    </select>
    <input type="submit" name="submit-btn" value="Calculate"/>
    <?php
    if(isset($_REQUEST['submit-btn'])) {
        $fields = [
            'amount' => $_POST["amount"],
            'currency type' => $_POST["currency-type"],
            'interest' => $_POST["interest"]
        ];
        $filled = true;
        $amount = 0;
        $cType = 'usd';
        $interest = 0;
        $period = $_POST['period'];
        foreach ($fields as $key => $field) {
            if ($filled) {
                if ($field != '' && $field != null) {
                    switch ($key) {
                        case 'amount':
                            $amount = $field;
                            break;
                        case 'currency type':
                            $cType = $field;
                            break;
                        case 'interest':
                            $interest = $field;
                            break;
                    }
                } else {
                    echo ' Please enter ' . $key . ".<br/>";
                    $filled = false;
                }
            }
        }
        if ($filled) {
            $months = (int)$period;
            $interestPerMonth = $interest/12;
            $result = $amount;
            for ($i = 0; $i < $months; $i++) {
                $result += (($result/100) * $interestPerMonth);
            }
            switch ($cType) {
                case 'usd': echo 'USD '; break;
                case 'eur': echo 'EUR '; break;
                case 'bgn': echo 'BGN '; break;
            }
            echo round($result, 2);
        }

    }
    ?>
</form>
</body>
</html>