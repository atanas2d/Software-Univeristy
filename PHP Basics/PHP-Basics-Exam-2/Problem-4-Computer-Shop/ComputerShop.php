<?php
// for testing:
ini_set('display_errors',1);
ini_set('display_startup_errors',1);
error_reporting(-1);

$productListInput = $_GET['list'];

$minPrice = floatval($_GET['minPrice']);

$maxPrice = floatval($_GET['maxPrice']);

$filter = trim($_GET['filter']);

$order = trim($_GET['order']);

$productList = preg_split('/\r?\n/', $productListInput, -1, PREG_SPLIT_NO_EMPTY);

$prObjects = [];
foreach ($productList as $product) {

    $currentProduct = new stdClass();

    $pattern = '/(.+)\|\s*(\w+)\s*\|(.+)\|\s*([\d\.]+)\s*/';

    preg_match_all($pattern, $product, $matches);

    $prName = trim($matches[1][0]);
    $prType = trim($matches[2][0]);
    $prComponents = trim($matches[3][0]);
    $prPrice = floatval(trim($matches[4][0]));

    // split components:
    $splittedComponents = preg_split('/\s*,\s*/', $prComponents,-1, PREG_SPLIT_NO_EMPTY);

    $currentProduct->name = $prName;
    $currentProduct->type = $prType;
    $currentProduct->components = $splittedComponents;
    $currentProduct->price = $prPrice;

    $prObjects[] = $currentProduct;
}

$productsToPrint = [];

foreach ($prObjects as $prObj) {
    if ($prObj->price >= $minPrice && $prObj->price <= $maxPrice && $prObj->type == $filter) {
        $productsToPrint[] = $prObj;
    }
}

usort($productsToPrint, 'sort_objects_by_price');

function sort_objects_by_price($a, $b) {
    if($a->price == $b->price){
        if ($a->)

    }
    return ($a->total_posts < $b->total_posts) ? -1 : 1;
}