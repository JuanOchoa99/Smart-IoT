<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Sebastián Enrique Villanueva Navarro, Juan José Ochoa Ortiz">

  <title>PIICO - Universidad San Buenaventura</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link rel="icon" href="img/icono.ico">
  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="css/landing-page.css" rel="stylesheet">


</head>
<style>
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
    background: #007bff;
    border-radius: 5px;
  }

  /* Handle on hover */
  ::-webkit-scrollbar-thumb:hover {
    background: #007bff;
  }
</style>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-sm navbar-dark bg-primary static-top fixed-top">
    <a class="navbar-brand" href="#">
      <img src="img/iconoPiico.png" alt="Logo" style="width:50px">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false" aria-label="Toggle navigation" data-target="#navbarPiico">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarPiico">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="btn text-white btn-md" href="#semilleros">Semilleros<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="btn text-white btn-md" href="#introduccion">Proyecto</a>
        </li>
        <li class="nav-item">
          <a class="btn text-white btn-md" href="#conocenos">Conocenos</a>
        </li>
        <li class="nav-item">
          <a class="btn text-white btn-md" href="#galeria">Galeria</a>
        </li>
      </ul>
      <ul class="navbar-nav ml-3">
        <li class="nav-item">
        <div class="dropdown md-5">
            <button class="btn btn-warning text-white dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Demos
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
              <a class="dropdown-item" href="PIICODS/index3.html">CLOUD</a>
              <a class="dropdown-item" href="PIICODS_GDP/devices.html">GATEWAY</a>
              <a class="dropdown-item" href="PIICODS_ND/estacion.html">ESTACÍON</a>
            </div>
          </div>
        </li>
      <ul class="navbar-nav ml-3">
        <li class="nav-item ">
          <a class="btn text-white btn-success" href="login.php">Ingresar</a>
        </li>
        </ul>
    </div>
  </nav>

  <!-- Masthead -->
  <header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-xl-9 mx-auto">
          <h1 class="mb-5">PIICO: Plataforma para la Interoperabilidad de dispositivos del Internet de las Cosas (IoT) heterogéneos</h1>
        </div>
      </div>
    </div>
  </header>

  <!-- Icons Grid -->
  <section class="features-icons bg-light text-center" id="semilleros">
    <div class="container">
      <H2>Proyectos de Semilleros</H2>
      <div class="row">
        <div class="col-lg-6">
          <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
            <div class="features-icons-icon d-flex">
              <i class="icon-screen-desktop m-auto text-primary"></i>
            </div>
            <h3>Semillero DatAn</h3>
            <p class="lead mb-0">Ingeniería de Sistemas</p>
            <p class="lead mb-0">PWIADA</p>
            <p class="lead mb-0">Ingeniero Andrés Armando Sanchéz Martin</p>

          </div>
        </div>
        <div class="col-lg-6">
          <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
            <div class="features-icons-icon d-flex">
              <i class="icon-layers m-auto text-primary"></i>
            </div>
            <h3>Semillero SATIC</h3>
            <p class="lead mb-0">Ingeniería Electrónica</p>
            <p class="lead mb-0">Proyecto implemetación caso de estudio</p>
            <p class="lead mb-0">Ingeniero Luis Carlos Luis</p>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Image Showcases -->
  <section class="showcase" id="introduccion">
    <div class="container-fluid p-0">
      <div class="row no-gutters">

        <div class="col-lg-6   order-lg-2 text-white showcase-img" style="background-image: url('img/Introduccion_opt.jpg');"></div>
        <div class="col-lg-6 order-lg-1 my-auto showcase-text bg-primary text-white">
          <h2>Introducción</h2>
          <p class="lead mb-0">En este proyecto se pretende diseñar e implementar una plataforma de IoT que permita la interconexión y la interoperabilidad entre dispositivos heterogéneos. Algunas de las características que reunirá la plataforma será la integración de los componentes de sensado, conectividad, analítica de datos y dispositivos actuadores, lo cual otorgará flexibilidad a la hora de la implementación de una aplicación IoT. Además, para evaluar la funcionalidad de la plataforma planteada,
            se realizará la construcción de un sistema de monitoreo ambiental aplicado a la agricultura.</p>
        </div>
      </div>
      <div class="row no-gutters">
        <div class="col-lg-6 text-white showcase-img" style="background-image: url('img/objetivo.jpg');"></div>
        <div class="col-lg-6 my-auto showcase-text bg-primary text-white">
          <h2>Objetivos</h2>
          <p class="lead mb-0">Objetivo General: Desarrollar una plataforma que permita la interoperabilidad de dispositivos heterogéneos en aplicaciones de IoT</p>
          <p class="lead mb-0">Objetivos Específicos: </p>
          <p class="lead mb-0">Establecer un modelo de arquitectura para diseñar una plataforma IoT con los componentes necesarios para la interconexión de dispositivos a través de diferentes protocolos de comunicación</p>
          <p class="lead mb-0">implementar la arquitectura planteada mediante la integración del hardware y el software requerido para lograr la funcionalidad entre los diferentes componentes del modelo</p>
        </div>
      </div>
  </section>

  <!-- Testimonials -->
  <section class="testimonials text-center bg-light" id="conocenos">
    <div class="container">
      <h2 class="mb-5">Lideres de proyecto</h2>
      <div class="row">
        <div class="col-lg-4">
          <div class="testimonial-item mx-auto mb-5 mb-lg-0">
            <img class="img-fluid rounded-circle mb-4" src="img/as4.jpg" alt="">
            <h5>Andrés Sanchéz</h5>
            <p class="font-weight-light mb-5">Ingeniero de Sistemas</p>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="testimonial-item mx-auto mb-5 mb-lg-0">
            <img class="img-fluid rounded-circle mb-3" src="img/ec.png" alt="">
            <h5>Eduardo Castellanos</h5>
            <p class="font-weight-light mb-0">Ingeniero Electronico</p>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="testimonial-item mx-auto mb-5 mb-lg-0">
            <img class="img-fluid rounded-circle mb-3" src="img/jda.png" alt="">
            <h5>Jose David Alvarado</h5>
            <p class="font-weight-light mb-0">Ingeniero Electronico</p>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="testimonial-item mx-auto mb-5 mb-lg-0">
            <img class="img-fluid rounded-circle mb-3" src="img/yg_opt.png" alt="">
            <h5>Yimi García</h5>
            <p class="font-weight-light mb-0">Ingeniero Electronico</p>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="testimonial-item mx-auto mb-6 mb-lg-0">
            <img class="img-fluid rounded-circle mb-3" src="img/Avatar.png" alt="">
            <h5>Luis Carlos Luis</h5>
            <p class="font-weight-light mb-0">Ingeniero Electronico</p>
          </div>
        </div>
      </div>
      <h2 class="mb-5">Asistentes de proyecto</h2>
      <div class="row">
        <div class="col-lg-4">
          <div class="testimonial-item mx-auto mb-5 mb-lg-0">
            <img class="img-fluid rounded-circle mb-3" src="img/jjoo.png" alt="">
            <h5>Juan José Ochoa</h5>
            <p class="font-weight-light mb-5">Estudiante de Ingeniería de Sistemas</p>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="testimonial-item mx-auto mb-5 mb-lg-0">
            <img class="img-fluid rounded-circle mb-3" src="img/am.png" alt="">
            <h5>Andres Macias</h5>
            <p class="font-weight-light mb-5">Estudiante de Ingeniería Electrónica</p>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="testimonial-item mx-auto mb-5 mb-lg-0">
            <img class="img-fluid rounded-circle mb-3" src="img/sevin.png" alt="">
            <h5>Sebastián Villanueva</h5>
            <p class="font-weight-light mb-5">Estudiante de Ingeniería de Sistemas</p>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="testimonial-item mx-auto mb-5 mb-lg-0">
            <img class="img-fluid rounded-circle mb-3" src="img/dp.jpeg" alt="">
            <h5>David Santiago Pachon</h5>
            <p class="font-weight-light mb-0">Estudiante de Ingeniería Electrónica</p>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="testimonial-item mx-auto mb-5 mb-lg-0">
            <img class="img-fluid rounded-circle mb-3" src="img/Avatar.png" alt="">
            <h5>Harold Pinilla</h5>
            <p class="font-weight-light mb-0">Estudiante de Ingeniería Electrónica</p>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--
  <section class="testimonials text-center bg-light"id="galeria">	
    <div class="container">
    	<h2 class="mb-5">Comienzos</h2>
      	<div class="row">
        		<div class="testimonial-item mx-auto mb-5 mb-lg-0" data-aos="fade" data-src="img/inicios.jpeg" >
          			<img src="img/inicios.jpeg" alt="IMage" class="img-fluid">
        		</div>
        		<div class="testimonial-item mx-auto mb-5 mb-lg-0" data-aos="fade" data-src="img/inicios1.jpg">
          			<img src="img/inicios1.jpg" alt="IMage" class="img-fluid">
        		</div>
        		<div class="testimonial-item mx-auto mb-5 mb-lg-0" data-aos="fade" data-src="img/inicios2.jpg">
          			<img src="img/inicios2.jpg" alt="IMage" class="img-fluid">
        		</div>
        </div> 
    </div>
        <div class="container">
    	<h2 class="mb-5">Prototipo Version 1
      	<div class="row">
        		<div class="testimonial-item mx-auto mb-5 mb-lg-0" data-aos="fade" data-src="img/pv1.jpg" >
          			<img src="img/pv1.jpg" alt="IMage" class="img-fluid">
        		</div>
        		<div class="testimonial-item mx-auto mb-5 mb-lg-0" data-aos="fade" data-src="img/pv1.1.jpg">
          			<img src="img/pv1.1.jpg" alt="IMage" class="img-fluid">
        		</div>
        		<div class="testimonial-item mx-auto mb-5 mb-lg-0" data-aos="fade" data-src="img/pv1.2.jpg">
          			<img src="img/pv1.2.jpg" alt="IMage" class="img-fluid">
        		</div>
        </div> 
    </div>
        </div>
        <div class="container">
    	<h2 class="mb-5">Prototipo Version 2
      	<div class="row">
        		<div class="testimonial-item mx-auto mb-5 mb-lg-0" data-aos="fade" data-src="img/pvf.jpg" >
          			<img src="img/pvf.jpg" alt="IMage" class="img-fluid">
        		</div>
        		<div class="testimonial-item mx-auto mb-5 mb-lg-0" data-aos="fade" data-src="img/pvf.1.jpg">
          			<img src="img/pvf.1.jpg" alt="IMage" class="img-fluid">
        		</div>
        		<div class="testimonial-item mx-auto mb-5 mb-lg-0" data-aos="fade" data-src="img/pvf.2.jpg">
          			<img src="img/pvf.2.jpg" alt="IMage" class="img-fluid">
        		</div>
        </div> 
    </div>
  </section>
-->

  <!-- Call to Action -->
  <!-- Footer -->
  <footer class="footer bg-primary text-white">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
          <ul class="list-inline mb-2">
            <li class="list-inline-item">
              <a href="#" class="text-white">Conocenos</a>
            </li>
            <li class="list-inline-item">&sdot;</li>
            <p class=" text-white small mb-4 mb-lg-0">&copy; Universidad de San Buenaventura 2019. Todos los derechos reservados.</p>
        </div>
      </div>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>