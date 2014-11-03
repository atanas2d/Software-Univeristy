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
    <fieldset>
        <legend>Personal Information</legend>
        <input type="text" name="fname" placeholder="First Name"/><br/>
        <input type="text" name="lname" placeholder="Last Name"/><br/>
        <input type="email" name="email" placeholder="Email"/><br/>
        <input type="tel" name="tel" placeholder="Phone Number"/><br/>
        <label for="female">Female</label>
        <input type="radio" name="sex" value="f" id="female"/>
        <label for="male">Male</label>
        <input type="radio" name="sex" value="m" id="male"/><br/>
        <label for="bday">Birth Date</label><br/>
        <input type="date" name="bday" id="bday"/><br/>
        <label for="nationality">Nationality</label><br/>
        <select name="nationality" id="nationality">
            <option value="bg" selected>Bulgarian</option>
            <option value="us">American</option>
            <option value="ger">German</option>
        </select>
    </fieldset>
    <fieldset>
        <legend>Last Work Position</legend>
        <label for="company-name">Company Name</label>
        <input type="text" id="company-name" name="companyName"/><br/>
        <label for="work-from">From</label>
        <input type="date" id="work-from" name="workFrom"/><br/>
        <label for="work-to">To</label>
        <input type="date" id="work-to" name="workTo"/><br/>
    </fieldset>
    <fieldset>
        <legend>Computer Skills</legend>
        <label for="programming-skills">Programming Skills</label><br/>
        <input type="text" name="programmingSkill-1" id="programming-skills"/>
        <select name="skillLevel[]">
            <option value="beginner" selected>Beginner</option>
            <option value="average">Average</option>
            <option value="expert">Expert</option>
        </select><br/>
        <input type="button" value="Remove Language" name="removeSkill"/>
        <input type="button" value="Add Language" name="addSkill"/>

    </fieldset>
    <fieldset>
        <legend>Other Skills</legend>
        <label for="langs">Languages</label>
        <input type="text" id="langs" name="lang-1"/>
        <select name="langComprehension">
            <option selected>-Comprehension-</option>
            <option value="a">A</option>
            <option value="b">B</option>
            <option value="c">C</option>
        </select>
        <select name="langComprehension">
            <option selected>-Reading-</option>
            <option value="a">A</option>
            <option value="b">B</option>
            <option value="c">C</option>
        </select>
        <select name="langComprehension">
            <option selected>-Writing-</option>
            <option value="a">A</option>
            <option value="b">B</option>
            <option value="c">C</option>
        </select><br/>
        <input type="button" value="Remove Language" name="removeLang"/>
        <input type="button" value="Add Language" name="addLang"/><br/>

        Driver License <br/>
        <label for="drv-B">B</label><input type="radio" name="drvLicense" value="B" id="drv-B"/>
        <laAel for="drv-A">A</laAel><input type="radio" name="drvLicense" value="A" id="drv-A"/>
        <laCel for="drv-C">C</laCel><input type="radio" name="drvLicense" value="C" id="drv-C"/>

    </fieldset>
    <input type="submit" value="Generate CV" name="genCvBtn"/>
    <?php

    if(isset($_REQUEST['genCvBtn'])) {
        function isNameValid($name) {
            if (strlen($name) < 2 || strlen($name) > 20) {
                return false;
            }
            if (preg_match('/[^A-Za-z]/', $name)) {
                return false;
            } else {
                return true;
            }
        }
        function isCNameValid($cName) {
            if (strlen($cName) < 2 || strlen($cName) > 20) {
                return false;
            }
            if (preg_match('/[^A-Za-z0-9]/', $cName)) {
                return false;
            } else {
                return true;
            }
        }
        function isPhoneValid($phone) {
            if (!preg_match('/[0-9+ -]+/', $phone)) {
                return false;
            } else {
                return true;
            }
        }
        function isEmailValid($email) {

        }
        $fieldsPInfo = [
            'first name' => $_POST['fname'],
            'last name' => $_POST['lname'],
            'email' => $_POST['email'],
            'phone number' => $_POST['tel']
        ];
        $fieldsOther = [
            'company name' => $_POST['fname'],
            'work from' => $_POST['lname'],
            'work to' => $_POST['email'],
        ];
        $filled = true;
        foreach ($fieldsPInfo as $key => $value) {

        }

        if(isNameValid($fieldsPInfo['first name'])) {
            echo '<br/> valid name';
        }
        echo $fieldsPInfo['phone number'];

        if(isPhoneValid($fieldsPInfo['phone number'])) {
            echo '<br/> valid tel';
        }

    }
    ?>
</form>
</body>
</html>