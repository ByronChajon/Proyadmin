<%@page import="java.util.List"%>
<%@page import="entidadesproyecto.Cliente"%>
<%@page import="daoproyecto.DAOCliente"%>
<%
    DAOCliente dao;
    Cliente cli = null;
    String msj = "";

    if (request.getParameter("txtNombre") != null
            && request.getParameter("txtApellido") != null
            && request.getParameter("txtNit") != null
            && request.getParameter("txtDireccion") != null
            && request.getParameter("txtTelefono") != null) {
        cli = new Cliente();
        cli.setNombre(request.getParameter("txtNombre"));
        cli.setApellido(request.getParameter("txtApellido"));
        cli.setNit(request.getParameter("txtNit"));
        cli.setDireccion(request.getParameter("txtDireccion"));
        cli.setTelefono(Integer.parseInt(request.getParameter("txtTelefono")));

        dao = new DAOCliente();
        try {
            dao.Registrar(cli);
            response.sendRedirect("Clientes.jsp");
        } catch (Exception e) {
            msj = "No se pudo registrar el cliente";
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
                    <h1 class="mt-4" align ="center"> Clientes </h1>
                    <h4>Ingrese un nuevo cliente</h4>
                    <br>
                    <%
                        if (msj.length() > 0) {
                            out.print("div class=\"error\">" + msj + "</div>");
                        }
                    %>
                    <form name="frmClientes" action="Clientes.jsp" method ="post">
                        <div class="form-group">
                            <label>Nombre Cliente</label>
                            <input type="text" class="form-control" name="txtNombre" placeholder="Ingrese nombre cliente"
                                   value ="<%= (cli != null ? cli.getNombre() : "")%>">
                            <div class="form-group">
                                <label>Apellido Cliente</label>
                                <input type="text" class="form-control" name="txtApellido" placeholder="Apellido cliente"
                                       value ="<%= (cli != null ? cli.getApellido() : "")%>">
                            </div>
                            <div class="form-group">
                                <label>Nit Cliente</label>
                                <input type="text" class="form-control" name="txtNit" placeholder="Ingrese nit del cliente"
                                       value ="<%= (cli != null ? cli.getNit() : "")%>">
                            </div>
                            <div class="form-group">
                                <label>Dirección</label>
                                <input type="text" class="form-control" name="txtDireccion" placeholder="Ingrese la dirección"
                                       value ="<%= (cli != null ? cli.getDireccion() : "")%>">
                            </div>
                            <div class="form-group">
                                <label>Teléfono</label>
                                <input type="text" class="form-control" name="txtTelefono" placeholder="Numero de teléfono"
                                       value ="<%= (cli != null ? cli.getTelefono() : "")%>">
                            </div>
                            <button type="submit" class="btn btn-success">Insertar</button>
                    </form>
                    <!-- Arraylist para presentar los datos en pantalla -->
                    <div>
                        <div class="col-md-12">
                            <br>
                            <h4>Listado de Clientes</h4>
                            <div class="table-responsive">                                 
                                <table class="table table-hover table-striped table-bordered">
                                    <thead class="brn btn-secondary">
                                        <tr>
                                            <th class="text-center">N°</th>
                                            <th class="text-center">Nombre</th>
                                            <th class="text-center">Apellido</th>
                                            <th class="text-center">Nit</th>
                                            <th class="text-center">Direccion</th>
                                            <th class="text-center">Telefono</th>
                                            <th class="text-center">Acción</th>
                                        </tr>
                                    </thead>  
                                    <%
                                        DAOCliente daoclien = new DAOCliente();
                                        List<Cliente> clientes = null;
                                        int i = 1;

                                        try {
                                            clientes = daoclien.listar();
                                            for (Cliente clie : clientes) {
                                                out.print("<tr>"
                                                        + "<td>" + i + "</td>"
                                                        + "<td>" + clie.getNombre() + "</td>"
                                                        + "<td>" + clie.getApellido() + "</td>"
                                                        + "<td class=\"text-center\">" + clie.getNit() + "</td>"
                                                        + "<td class=\"text-center\">" + clie.getDireccion() + "</td>"
                                                        + "<td class=\"text-center\">" + clie.getTelefono() + "</td>"        
                                                        + "<td class=\"text-center\"><a class=\"btn btn-warning btn-sm\" href=\"editarclientes.jsp?cod="
                                                        + clie.getCliente()+ "\"> Editar</a></td>"
                                                        + "</tr>");
                                                i++;
                                            }

                                        } catch (Exception e) {
                                            out.print("<tr><td colspan=\"3\">"
                                                    + e.getMessage() + "No se pudo listar las categorias</td></tr>");
                                        } finally {
                                            dao = null;
                                            if (clientes != null) {
                                                clientes.clear();
                                            }
                                            clientes = null;
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
