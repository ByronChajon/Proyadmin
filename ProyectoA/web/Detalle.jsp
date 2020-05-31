<%@page import="entidadesproyecto.Venta"%>
<%@page import="java.util.List"%>
<%@page import="daoproyecto.DAOMercaderia"%>
<%@page import="entidadesproyecto.Mercaderia"%>
<%@page import="entidadesproyecto.Detalle"%>
<%@page import="daoproyecto.DAODetalle"%>
<%
    String msje = "";
    DAODetalle daoDet;
    Detalle det = null;
    Mercaderia merc;
    Venta ven;
    
    /*if (request.getParameter("txtProducto") != null) {
        buscar = request.getParameter("txtProducto");
    }*/

    if (request.getParameter("cboProducto") != null
            && request.getParameter("txtUnidades") != null
            && request.getParameter("txtSubtotal") != null ){
            
        det = new Detalle();
        det.setUnidades(Integer.parseInt("txtUnidades"));
        det.setSubtotal(Double.parseDouble(request.getParameter("txtSubtotal")));
        merc = new Mercaderia();
        merc.setCodigoproducto(Integer.parseInt(request.getParameter("cboProducto")));
        ven = new Venta();
        ven.setVenta(Integer.parseInt(request.getParameter("txtVenta")));
        
        
        det.setVenta(ven);
        det.setCodigoproducto(merc);
        daoDet = new DAODetalle();
        try {
            daoDet.Registrar(det);
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
                    <h1 class="mt-4"> Detalle </h1>
                    <p>Agregar productos a su venta</p>
                    <form name="frmVentas" action="Ventas.jsp" method="post">
                        <div class="form-group">
                            <label>Venta No.</label>
                            <input type="text" class="form-control col-md-2" name="txtVenta" placeholder="Ingrese enteros"
                                   >
                        </div>
                        <div class="form-group">
                            <label>Producto</label>
                            <div>
                                <select class="form-control" name="cboProducto">
                                    <option>Elija el tipo de producto</option>
                                    <%
                                                    DAOMercaderia dao = new DAOMercaderia();
                                                    List<Mercaderia> mercaderias = null;

                                                    try {
                                                        mercaderias = dao.listar();
                                                        for (Mercaderia mer : mercaderias) {
                                                            out.print("<option value=\"" + mer.getCodigoproducto() + "\" "
                                                                    + (det != null
                                                                    && mer.getCodigoproducto() == det.getCodigoproducto().getCodigoproducto()
                                                                    ? "selected" : "") + ">"
                                                                    + mer.getProducto() + "</option>");
                                                        }
                                                    } catch (Exception e) {
                                                        out.print("<option value=\"0\">No se pudo listar"
                                                                + "las categorías</option>");
                                                    } finally {
                                                        mercaderias = null;
                                                        dao = null;
                                                    }
                                                %>
                                    
                                </select>

                                </div>
                            <input type="text" class="form-control col-md-4" name="txtCliente" placeholder="Elija el cliente"
                                   >
                             <label>Precio</label>
                            <input type="text" class="form-control col-md-2" name="txtPrecio" placeholder=" 0.00"
                                   >
                        </div>
                        <div class="form-group">
                            <label>Unidades</label>
                            <input type="number" class="form-control col-md-2" name="txtUnidades" placeholder="Ingrese enteros"
                                   >
                        </div>
                        <div class="form-group">
                            <label>Subtotal</label>
                            <input type="text" class="form-control col-md-2" name="txtSubtotal" placeholder="Automatico"
                                   >
                        </div>
                        <input type="submit" class="btn btn-success" value="Agregar al carrito">
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
