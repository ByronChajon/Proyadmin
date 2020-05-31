<%@page import="java.util.List"%>
<%@page import="entidadesproyecto.Mercaderia"%>
<%@page import="daoproyecto.DAOMercaderia"%>
<%
    DAOMercaderia dao;
    Mercaderia mer = null;
    String msj = "";

    //1. Mostrar datos de la categoria elegida
    if (request.getParameter("cod") != null) {
        mer = new Mercaderia();
        mer.setCodigoproducto(Integer.parseInt(request.getParameter("cod")));
        dao = new DAOMercaderia();
        try {
            mer = dao.leer(mer);
            if (mer == null) {
                msj = "No se pudo encontrar la mercaderia solicitada";
            }
        } catch (Exception e) {
            msj = "No se pudo leer la mercaderia";
        } finally {
            dao = null;
        }
    } else {
        //2. Actualizar la base con los nuevos datos
        if (request.getParameter("hCodigo") != null
                && request.getParameter("txtProducto") != null) {

            mer = new Mercaderia();
            mer.setCodigoproducto(Integer.parseInt(request.getParameter("hCodigo")));
            mer.setProducto(request.getParameter("txtProducto"));
            mer.setPresentacion(request.getParameter("txtPresentacion"));
            mer.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
            
            dao = new DAOMercaderia();
            try {
                dao.actualizar(mer);
                response.sendRedirect("Mercaderia.jsp");
            } catch (Exception e) {
                msj = e.getMessage()+ "No se pudo realizar la actualizaci�n";
            } finally {
                dao = null;
                mer = null;
            }
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
                <div class="sidebar-heading">Control Abarroter�a</div>
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
                    <button class="btn btn-secondary" id="menu-toggle">Ocultar Men�</button>

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
                    <h1 class="mt-4" align="center"> Mercader�a </h1>
                    <h4>Actualice el producto en el sistema</h4>
                    <br>
                    <%
                        if (msj.length() > 0) {
                            out.print("div class=\"error\">" + msj + "</div>");
                        }
                    %>
                    <form name="frmMercaderia" action="editarmercaderias.jsp" method ="post">
                        <div class="form-group">
                            <input Type="hidden" name="hCodigo"
                                   value ="<%= (mer != null ? mer.getCodigoproducto() : "")%>">
                            <label>Producto</label>
                            <input type="text" class="form-control" name="txtProducto" placeholder="Ingrese nombre del producto"
                                   value ="<%= (mer != null ? mer.getProducto() : "")%>">
                        </div>
                        <div class="form-group">
                            <label>Presentaci�n</label>
                            <input type="text" class="form-control" name="txtPresentacion" placeholder="Lbs., Arroba, Litros, etc."
                                   value ="<%= (mer != null ? mer.getPresentacion() : "")%>">
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" class="form-control" name="txtPrecio" placeholder=" 0.00"
                                   value ="<%= (mer != null ? mer.getPrecio() : "")%>">
                        </div>
                        <button type="submit" class="btn btn-success">Actualizar</button>
                            <a href="Mercaderia.jsp" class="btn btn-danger">Regresar</a>
                    </form>

                    <div>
                        <div class="col-md-12">
                            <br>
                            <h4>Listado de Productos</h4>
                            <div class="table-responsive">                                 
                                <table class="table table-hover table-striped table-bordered">
                                    <thead  class="brn btn-secondary">
                                        <tr>
                                            <th class="text-center">N�</th>
                                            <th class="text-center">Producto</th>
                                            <th class="text-center">Presentacion</th>
                                            <th class="text-center">Precio</th>
                                            <th class="text-center">Acci�n</th>
                                        </tr>
                                    </thead>  
                                    <%
                                        DAOMercaderia daomerca = new DAOMercaderia();
                                        List<Mercaderia> mercaderias = null;
                                        int i = 1;

                                        try {
                                            mercaderias = daomerca.listar();
                                            for (Mercaderia merc : mercaderias) {
                                                out.print("<tr>"
                                                        + "<td class=\"text-center\">" + i + "</td>"
                                                        + "<td>" + merc.getProducto() + "</td>"
                                                        + "<td>" + merc.getPresentacion() + "</td>"
                                                        + "<td class=\"text-right\">" + merc.getPrecio() + "</td>"
                                                        + "<td class=\"text-center\"><a class=\"btn btn-warning btn-sm\" href=\"editarmercaderias.jsp?cod="
                                                        + merc.getCodigoproducto() + "\"> Editar</a></td>"
                                                        + "</tr>");
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



