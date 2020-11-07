<?php
$servername = "ingusb.com:3306";
$database = "ingusb_piico";
$username = "ingusb_piico";
$password = "piico-2020-2";

//  Create a new connection to the MySQL database using PDO
$conn = new mysqli($servername, $username, $password, $database);
// Check connection
if ( $conn -> connect_error) {
    die("fallo conexion " . $conn->connect_error);
}

//Optencion de las variable a trabes del metodo post
$username=$_POST['usuario'];
$pass=$_POST['pass'];
$passE=md5($pass);
$sql="SELECT * FROM usuarios WHERE usuario = '".$username."'";

$result=$conn->query($sql);

if($result->num_rows > 0){
    $user=$result->fetch_assoc();
    if($username =="" || $pass == ""){
        header('location: https://https://piico.ingusb.com/PIICODS/index3.html');
    }
  }

$conn->close();
?>