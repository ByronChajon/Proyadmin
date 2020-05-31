<%@page import="java.util.List"%>
<%@page import="entidadesproyecto.Mercaderiao"%>
<%@page import="daoproyecto.DAOMercaderiao"%>
<%
    DAOMercaderiao dao;
    Mercaderiao mer = null;

    String msj = "";

    if (request.getParameter("txtCodigo") != null
            && request.getParameter("txtProducto") != null
            && request.getParameter("txtPresentacion") != null
            && request.getParameter("txtPrecio") != null) {
        mer = new Mercaderiao();
        mer.setCodigoproducto(Integer.parseInt(request.getParameter("txtCodigo")));
        mer.setProducto(request.getParameter("txtProducto"));
        mer.setPresentacion(request.getParameter("txtPresentacion"));
        mer.setPrecio(Integer.parseInt(request.getParameter("txtPrecio")));

        dao = new DAOMercaderiao();
        try {
            dao.Registro(mer);
            response.sendRedirect("MercaderiaO.jsp");
        } catch (Exception e) {
            msj = "No se pudo registrar el producto";
            if (e != null && e.getMessage() != null) {
                msj = e.getMessage();
            } else {
                msj = "Valor nulo";
            }
        } finally {
            dao = null;
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

        <title>SISTEMA DE VENTAS</title>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/jquery-3.5.1.min.js" type="text/javascript"></script>
        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/simple-sidebar.css" rel="stylesheet">

    </head>

    <body>

        <div class="d-flex" id="wrapper">

            <!-- Sidebar -->
            <div class="bg-light border-right" id="sidebar-wrapper">
                <div class="sidebar-heading">Está usando Oracle</div>
                <div class="list-group list-group-flush">
                    <a href="Oracle.jsp" class="list-group-item list-group-item-action bg-light">Cambiar Base de datos</a>
                    <a href="ClientesO.jsp" class="list-group-item list-group-item-action bg-light">Clientes</a>
                    <a href="MercaderiaO.jsp" class="list-group-item list-group-item-action bg-light">Mercaderia</a>
                    <a href="VentasO.jsp" class="list-group-item list-group-item-action bg-light">Ventas</a>
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
                    <h1 class="mt-4" align="center"> Mercadería </h1>
                    <h4>Ingrese un nuevo producto al sistema</h4>
                    <br>
                    <%
                        if (msj.length() > 0) {
                            out.print("div class=\"error\">" + msj + "</div>");
                        }
                    %>
                    <form>
                        <div class="form-group">
                            <label>Codigo producto</label>
                            <input type="text" class="form-control" name="txtCodigo" placeholder="Ingrese el codigo de producto"
                                   value ="<%= (mer != null ? mer.getCodigoproducto() : "")%>">
                        </div>
                        <div class="form-group">
                            <label>Producto</label>
                            <input type="text" class="form-control" name="txtProducto" placeholder="Ingrese nombre del producto"
                                   value ="<%= (mer != null ? mer.getProducto() : "")%>">
                        </div>
                        <div class="form-group">
                            <label>Presentación</label>
                            <input type="text" class="form-control" name="txtPresentacion" placeholder="Lbs., Arroba, Litros, etc."
                                   value ="<%= (mer != null ? mer.getPresentacion() : "")%>">
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" class="form-control" name="txtPrecio" placeholder=" 0.00"
                                   value ="<%= (mer != null ? mer.getPrecio() : "")%>">
                        </div>
                        <button type="submit" class="btn btn-success">Insertar</button>
                    </form>

                    <div>
                        <div class="col-md-12">
                            <br>
                            <h1>Listado de Productos</h1>
                            <div class="table-responsive">                                 
                                <table class="table table-hover table-striped table-bordered">
                                    <thead  class="brn btn-secondary">
                                        <tr>
                                            <th class="text-center">N°</th>
                                            <th class="text-center">Producto</th>
                                            <th class="text-center">Presentacion</th>
                                            <th class="text-center">Precio</th>
                                        </tr>
                                    </thead>  
                                    <%
                                        DAOMercaderiao daomerca = new DAOMercaderiao();
                                        List<Mercaderiao> mercaderias = null;
                                        int i = 1;

                                        try {
                                            mercaderias = daomerca.listar();
                                            for (Mercaderiao merc : mercaderias) {
                                                out.print("<tr>"
                                                        + "<td class=\"text-center\">" + i + "</td>"
                                                        + "<td>" + merc.getProducto() + "</td>"
                                                        + "<td>" + merc.getPresentacion() + "</td>"
                                                        + "<td class=\"text-right\">" + merc.getPrecio() + "</td>");
                                                i++;
                                            }

                                        } catch (Exception e) {
                                            out.print("<tr><td colspan=\"3\">"
                                                    + e.getMessage() + "No se pudo listar las categorias</td></tr>");
                                        } finally {
                                            dao = null;
                                            if (mercaderias != null) {
                                                mercaderias.clear();
                                            }
                                            mercaderias = null;
                                        }
                                    %>                                                          
                                    <!-- <a class="icon-pencil2" data-toggle="tooltip" data-placement="right" title="Editar" href="Controlador"></a>
                                    </td>-->
                                </table>
                            </div>


                        </div>

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
