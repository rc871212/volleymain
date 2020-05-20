<?php
// array for JSON response

$con = mysql_connect("localhost","root",null);
if (!$con) {
die('Could not connect:'.mysql_error() );
}
mysql_select_db("volleyprojet", $con);
$response = array();
include("conn.php");
// check for required fields
if (isset($_POST['time']) && isset($_POST['lat']) && isset($_POST['lon'])&& isset($_POST['encyptiontype'])&& isset($_POST['rssi'])&& isset($_POST['name'])) {
$time = $_POST['time'];
$lat = $_POST['lat'];
$lon = $_POST['lon'];
$encyptiontype = $_POST['encyptiontype'];
$rssi = $_POST['rssi'];
$name = $_POST['name'];
$result = mysql_query("INSERT INTO wifi_state(time, lat, lon,encyptiontype,rssi,name) VALUES('$time', '$lat', '$lon','$encyptiontype','$rssi','$name')");
echo $result;
// check if row inserted or not
if ($result) {
// successfully inserted into database
$response["success"] = 1;
$response["message"] = "Product successfully created.";
// echoing JSON response
echo json_encode($response);
} else {
// failed to insert row
$response["success"] = 0;
$response["message"] = "Oops! An error occurred.";
// echoing JSON response
echo json_encode($response);
}
} else {
// required field is missing
$response["success"] = 0;
$response["message"] = "Required field(s) is missing";
// echoing JSON response
echo json_encode($response);
}
?>