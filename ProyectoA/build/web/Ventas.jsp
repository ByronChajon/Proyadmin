<%@page import="entidadesproyecto.Mercaderia"%>
<%@page import="entidadesproyecto.Detalle"%>
<%@page import="entidadesproyecto.Venta"%>
<%@page import="daoproyecto.DAOVenta"%>
<%@page import="entidadesproyecto.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="daoproyecto.DAOCliente"%>

<%
    String msje = "";
    DAOVenta daoVen;
    Venta ven = null;
    Cliente clie;
    Detalle det;
    Mercaderia mer;

    /*if (request.getParameter("txtProducto") != null) {
        buscar = request.getParameter("txtProducto");
    }*/
    if (request.getParameter("cboCliente") != null
            && request.getParameter("txtFecha") != null
            && request.getParameter("cboDetalle") != null
            && request.getParameter("cboProducto") != null /*txtProducto, txtPresentacion, txtPrecio*/
            && request.getParameter("txtTotal") != null) {

        ven = new Venta();
        ven.setFecha(request.getParameter("txtFecha"));
        ven.setTotal(Double.parseDouble(request.getParameter("txtTotal")));
        clie = new Cliente();
        clie.setCliente(Integer.parseInt(request.getParameter("cboCliente")));
        mer = new Mercaderia();
        mer.setCodigoproducto(Integer.parseInt(request.getParameter("cboProducto")));
        det = new Detalle();
        det.setDetalle(Integer.parseInt(request.getParameter("cboDetalle")));

        ven.setCliente(clie);
        ven.setMercaderia(mer);
        daoVen = new DAOVenta();
        try {
            daoVen.Registrar(ven);
            response.sendRedirect("Ventas.jsp");
        } catch (Exception e) {
            msje = e.getMessage() + "No se pudo registrar el producto algo esta mal aquí";
        } finally {
        }
    }
%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Minified Bootstrap CSS -->

        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
        <script src="js/bootstrap-datetimepicker.min.js"></script>

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
                <div class="sidebar-heading">Está usando SQL Server</div>
                <div class="list-group list-group-flush">
                    <a href="SQLserver.jsp" class="list-group-item list-group-item-action bg-light">Cambiar Base de datos</a>
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
                    <h1 class="mt-4"> Ventas </h1>
                    <p>Registrar una nueva venta ventas</p>
                    <form name="frmVentas" action="Ventas.jsp" method="post">
                        <div class="form-group">
                            <label>Cliente</label>
                            <div>
                                <select class="form-control" name="cboCliente">
                                    <option>Elija el cliente</option>
                                    <%
                                        DAOCliente dao = new DAOCliente();
                                        List<Cliente> clientes = null;

                                        try {
                                            clientes = dao.listar();
                                            for (Cliente cli : clientes) {
                                                out.print("<option value=\"" + cli.getCliente() + "\" "
                                                        + (ven != null
                                                        && cli.getCliente() == ven.getCliente().getCliente()
                                                        ? "selected" : "") + ">"
                                                        + cli.getNombre() + "</option>");
                                            }
                                        } catch (Exception e) {
                                            out.print("<option value=\"0\">No se pudo listar"
                                                    + "las categorías</option>");
                                        } finally {
                                            clientes = null;
                                            dao = null;
                                        }
                                    %>

                                </select>

                            </div>

                        </div>

                        <div class="form-group">
                            <label>Fecha</label>
                            <input type="date" class="form-control  col-md-4" name="txtFecha" placeholder=""
                                   >
                        </div> 
                        <br>
                        <a href="Detalle.jsp" class="btn btn-secondary">Agregar al carrito</a>
                        <br>
                        <div class="form-group">
                            <label>Total</label>
                            <input type="text" class="form-control col-md-2" name="txtTotal" placeholder="Automatico"
                                   >
                        </div>
                        <input type="submit" class="btn btn-success" value="Registrar">
                    </form>
                </div>
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
