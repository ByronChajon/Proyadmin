<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Content-Type" content="text/html;">



        <title>SISTEMA DE VENTAS</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/simple-sidebar.css" rel="stylesheet">

    </head>

    <body>

        <div class="d-flex" id="wrapper">

            <!-- Sidebar -->
            <div class="bg-light border-right" id="sidebar-wrapper">
                <div class="sidebar-heading">Control Abarrotería</div>
                <div class="list-group list-group-flush">
                    <a href="index.html" class="list-group-item list-group-item-action bg-light">Inicio</a>
                    <a href="Clientes.jsp" class="list-group-item list-group-item-action bg-light">Clientes</a>
                    <a href="Mercaderia.jsp" class="list-group-item list-group-item-action bg-light">Mercaderia</a>
                    <a href="Ventas.jsp" class="list-group-item list-group-item-action bg-light">Ventas</a>
                    <!--<a href="#" class="list-group-item list-group-item-action bg-light"></a>
                                <a href="#" class="list-group-item list-group-item-action bg-light"></a>-->
                </div>
            </div>
            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div id="page-content-wrapper">

                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <button class="btn btn-secondary" id="menu-toggle">Ocultar Menú</button>

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                            <li class="nav-item active">
                                <a class="nav-link" href="index.html">Inicio <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="#"> <span class="sr-only">(current)</span></a>
                            </li>

                        </ul>
                    </div>
                </nav>

                <div class="container-fluid">
                    <h1 class="mt-4"> Base de Datos SQL Server </h1>
                    <p>Sistema de control de ventas Abarrotería</p>


                </div>
                <script src="bootstrap/js/chart.js" type="text/javascript"></script>
                <br>                
                <h4>Ventas por cliente</h4>
                <canvas id="myChart2"></canvas>
                <br>
                <script src="chart.js"></script>

                <script>
                    var ctx2 = document.getElementById('myChart2').getContext('2d');
                    var chart = new Chart(ctx2, {
                        type: 'doughnut',
                        data:
                                {
                                    datasets: [{
                                            data: [60, 18, 10, 8, 4],
                                            backgroundColor: ['#42a5f5', 'red', 'green', 'blue', 'violet'],
                                            label: 'Compras por cliente'
                                        }],
                                    labels: [
                                        'Cliente 1',
                                        'Cliene 2',
                                        'Cliente 3',
                                        'Cliente 4',
                                        'Cliente 5'
                                    ]},
                        options: {}
                    });
                </script>

            </div>
            <!-- /#page-content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Menu Toggle Script -->
        <script>
                    $("#menu-toggle").click(function (e) {
                        e.preventDefault();
                        $("#wrapper").toggleClass("toggled");
                    });
        </script>

    </body>

</html>
