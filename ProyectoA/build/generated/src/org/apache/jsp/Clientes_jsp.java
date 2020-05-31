package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import entidadesproyecto.Cliente;
import daoproyecto.DAOCliente;

public final class Clientes_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <title>SISTEMA DE VENTAS</title>\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"bootstrap/js/jquery-3.5.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom styles for this template -->\n");
      out.write("        <link href=\"css/simple-sidebar.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"d-flex\" id=\"wrapper\">\n");
      out.write("\n");
      out.write("            <!-- Sidebar -->\n");
      out.write("            <div class=\"bg-light border-right\" id=\"sidebar-wrapper\">\n");
      out.write("                <div class=\"sidebar-heading\">Control Abarrotería</div>\n");
      out.write("                <div class=\"list-group list-group-flush\">\n");
      out.write("                    <a href=\"SQLserver.jsp\" class=\"list-group-item list-group-item-action bg-light\">Cambiar Base de datos</a>\n");
      out.write("                    <a href=\"Clientes.jsp\" class=\"list-group-item list-group-item-action bg-light\">Clientes</a>\n");
      out.write("                    <a href=\"Mercaderia.jsp\" class=\"list-group-item list-group-item-action bg-light\">Mercaderia</a>\n");
      out.write("                    <a href=\"Ventas.jsp\" class=\"list-group-item list-group-item-action bg-light\">Ventas</a>\n");
      out.write("                    <!--<a href=\"#\" class=\"list-group-item list-group-item-action bg-light\"></a>\n");
      out.write("                    <a href=\"#\" class=\"list-group-item list-group-item-action bg-light\"></a>-->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /#sidebar-wrapper -->\n");
      out.write("\n");
      out.write("            <!-- Page Content -->\n");
      out.write("            <div id=\"page-content-wrapper\">\n");
      out.write("\n");
      out.write("                <nav class=\"navbar navbar-expand-lg navbar-light bg-light border-bottom\">\n");
      out.write("                    <button class=\"btn btn-secondary\" id=\"menu-toggle\">Ocultar Menú</button>\n");
      out.write("\n");
      out.write("                    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                    </button>\n");
      out.write("\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                        <ul class=\"navbar-nav ml-auto mt-2 mt-lg-0\">\n");
      out.write("                            <li class=\"nav-item active\">\n");
      out.write("                                <a class=\"nav-link\" href=\"index.html\">Inicio <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item active\">\n");
      out.write("                                <a class=\"nav-link\" href=\"#\"> <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <h1 class=\"mt-4\" align =\"center\"> Clientes </h1>\n");
      out.write("                    <h4>Ingrese un nuevo cliente</h4>\n");
      out.write("                    <br>\n");
      out.write("                    ");

                        if (msj.length() > 0) {
                            out.print("div class=\"error\">" + msj + "</div>");
                        }
                    
      out.write("\n");
      out.write("                    <form name=\"frmClientes\" action=\"Clientes.jsp\" method =\"post\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Nombre Cliente</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"txtNombre\" placeholder=\"Ingrese nombre cliente\"\n");
      out.write("                                   value =\"");
      out.print( (cli != null ? cli.getNombre() : ""));
      out.write("\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Apellido Cliente</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"txtApellido\" placeholder=\"Apellido cliente\"\n");
      out.write("                                       value =\"");
      out.print( (cli != null ? cli.getApellido() : ""));
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Nit Cliente</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"txtNit\" placeholder=\"Ingrese nit del cliente\"\n");
      out.write("                                       value =\"");
      out.print( (cli != null ? cli.getNit() : ""));
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Dirección</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"txtDireccion\" placeholder=\"Ingrese la dirección\"\n");
      out.write("                                       value =\"");
      out.print( (cli != null ? cli.getDireccion() : ""));
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label>Teléfono</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"txtTelefono\" placeholder=\"Numero de teléfono\"\n");
      out.write("                                       value =\"");
      out.print( (cli != null ? cli.getTelefono() : ""));
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-success\">Insertar</button>\n");
      out.write("                    </form>\n");
      out.write("                    <!-- Arraylist para presentar los datos en pantalla -->\n");
      out.write("                    <div>\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <br>\n");
      out.write("                            <h4>Listado de Clientes</h4>\n");
      out.write("                            <div class=\"table-responsive\">                                 \n");
      out.write("                                <table class=\"table table-hover table-striped table-bordered\">\n");
      out.write("                                    <thead class=\"brn btn-secondary\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th class=\"text-center\">N°</th>\n");
      out.write("                                            <th class=\"text-center\">Nombre</th>\n");
      out.write("                                            <th class=\"text-center\">Apellido</th>\n");
      out.write("                                            <th class=\"text-center\">Nit</th>\n");
      out.write("                                            <th class=\"text-center\">Direccion</th>\n");
      out.write("                                            <th class=\"text-center\">Telefono</th>\n");
      out.write("                                            <th class=\"text-center\">Acción</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>  \n");
      out.write("                                    ");

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
                                    
      out.write("                                                          \n");
      out.write("                                    <!-- <a class=\"icon-pencil2\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Editar\" href=\"Controlador\"></a>\n");
      out.write("                                    </td>-->\n");
      out.write("                                </table>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /#page-content-wrapper -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- /#wrapper -->\n");
      out.write("\n");
      out.write("            <!-- Bootstrap core JavaScript -->\n");
      out.write("            <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("            <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("            <!-- Menu Toggle Script -->\n");
      out.write("            <script>\n");
      out.write("                $(\"#menu-toggle\").click(function (e) {\n");
      out.write("                    e.preventDefault();\n");
      out.write("                    $(\"#wrapper\").toggleClass(\"toggled\");\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
