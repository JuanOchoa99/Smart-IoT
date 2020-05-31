<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Sebastián Enrique Villanueva Navarro, Juan José Ochoa Ortiz">

    <title>PIICO - Ingresar Plataforma de Analitica</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" href="img/icono.ico">
    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/landing-page.min.css" rel="stylesheet">


</head>
<style>
    .main-head {
        height: 150px;
        background: #4CA2FE;
    }

    .sidenav {
        height: 100%;
        background-color: #4CA2FE;
        overflow-x: hidden;
        padding-top: 20px;
    }

    .main {
        padding: 0px 10px;
    }

    @media screen and (max-height: 450px) {
        .sidenav {
            padding-top: 15px;
        }
    }

    @media screen and (max-width: 450px) {
        .login-form {
            margin-top: 10%;
        }

        .register-form {
            margin-top: 10%;
        }
    }

    @media screen and (min-width: 768px) {
        .main {
            margin-left: 40%;
        }

        .sidenav {
            width: 30%;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
        }

        .login-form {
            margin-top: 40%;
        }

        .register-form {
            margin-top: 20%;
        }
    }

    .login-main-text {
        margin-top: 10%;
        padding: 60px;
        color: #fff;
    }

    .login-main-text h2 {
        font-weight: 300;
    }

    .btn-black {
        background-color: #4CA2FE !important;
    }

    html {
        scroll-behavior: smooth;
    }

    ::-webkit-scrollbar {
        width: 5px;
    }

    /* Track */
    ::-webkit-scrollbar-track {
        box-shadow: inset 0 0 5px grey;
        border-radius: 10px;
    }

    /* Handle */
    ::-webkit-scrollbar-thumb {
        background: #4CA2FE;
        border-radius: 5px;
    }

    /* Handle on hover */
    ::-webkit-scrollbar-thumb:hover {
        background: #4CA2FE;
    }
</style>

<body>
    <nav class="navbar navbar-expand-sm navbar-dark bg-primary static-top fixed-top">
        <a class="navbar-brand" href="/">
            <img src="img/iconoPiico.png" alt="Logo" style="width:50px">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false" aria-label="Toggle navigation" data-target="#navbarPiico">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarPiico">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="btn text-white btn-md" href="/#semilleros">Semilleros<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="btn text-white btn-md" href="/#introduccion">Proyecto</a>
                </li>
                <li class="nav-item">
                    <a class="btn text-white btn-md" href="/#conocenos">Conocenos</a>
                </li>
                <li class="nav-item">
                    <a class="btn text-white btn-md" href="galeria.php">Galeria</a>
                </li>
                <li class="nav-item">
                    <a class="btn text-white btn-md" href="contactanos.php">Contactanos</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right mr-2">
                <li class="nav-item">
                    <div class="dropdown">
                        <a class="btn btn-warning text-white dropdown-toggle btn-sm" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-eye"></i> Demos
                        </a>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="PIICODS/index3.html" target="blank">CLOUD</a>
                            <a class="dropdown-item" href="login.html" target="blank">GATEWAY</a>
                            <a class="dropdown-item" href="PIICODS_ND/estacion.html" target="blank">ESTACÍON</a>
                        </div>
                    </div>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right mr-2">
                <li class="nav-item">
                    <a class="btn text-white btn-success btn-sm" href="login.php"><i class="fas fa-sign-in-alt"></i> Ingresar</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="sidenav">
        <div class="login-main-text text-center">
            <img src="img/iconoPiico.png" alt="Piico" style="width:150px">
            <h1>PIICO<br>Ingreso a la Plataforma de Analítica</h1>
        </div>
    </div>
    <div class="main">
        <div class="col-md-6 col-sm-12">
            <div class="login-form">
                <form>
                    <div class="form-group">
                        <label>Nombre</label>
                        <input type="text" class="form-control" placeholder="Nombre">
                    </div>
                    <div class="form-group">
                        <label>Apellido</label>
                        <input type="text" class="form-control" placeholder="Apellido">
                    </div>
                    <div class="form-group">
                        <label>Usuario</label>
                        <input type="text" class="form-control" placeholder="Usuario">
                    </div>
                    <div class="form-group">
                        <label>Contreseña</label>
                        <input type="password" class="form-control" placeholder="Contraseña">
                    </div>
                    <div class="form-group">
                        <label>Confirmar Contreseña</label>
                        <input type="password" class="form-control" placeholder="Confirmar Contreseña">
                    </div>
                    <a type="button" class="btn btn-success" href="../PIICODS/index3.html">Registrar</a>
                    <a type="button" class="btn btn-warning text-white" href="login.php">Iniciar Sesión</a>
                </form>
            </div>
            <hr>
        </div>
    </div>
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>

</html>