<?php
/**
 * Created by PhpStorm.
 * User: atanas2d
 * Date: 10/22/14
 * Time: 4:46 PM
 */

class EReservationException extends LogicException {

    function __construct($roomNumber, Reservation $reservation)
    {
        $this->message = "Room ". $roomNumber ." is already occupied for period from "
            . $reservation->getStartDate()->format("d-m-y"). " to "
            . $reservation->getEndDate()->format("d-m-y") . PHP_EOL;
    }
}