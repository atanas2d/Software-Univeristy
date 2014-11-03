<?php
/**
 * Created by PhpStorm.
 * User: atanas2d
 * Date: 10/22/14
 * Time: 4:25 PM
 */

require_once "Room.class.php";

class SingleRoom extends Room {
    const BED_COUNT = 1;

    function __construct($roomNumber, $price)
    {
        parent::__construct($roomNumber, SingleRoom::BED_COUNT, $price, true, false, RoomType::STANDARD);
        $this->addExtras(Extra::TV);
        $this->addExtras(Extra::AIR_CONDITIONER);
    }
}