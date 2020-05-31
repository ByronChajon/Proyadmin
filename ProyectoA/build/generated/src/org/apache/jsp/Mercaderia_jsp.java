package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import entidadesproyecto.Mercaderia;
import daoproyecto.DAOMercaderia;

public final class Mercaderia_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    DAOMercaderia dao;
    Mercaderia mer = null;

    String msj = "";

    if (request.getParameter("txtProducto") != null
            && request.getParameter("txtPresentacion") != null
            && request.getParameter("txtPrecio") != null) {
        mer = new Mercaderia();
        mer.setProducto(request.getParameter("txtProducto"));
        mer.setPresentacion(request.getParameter("txtPresentacion"));
        mer.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));

        dao = new DAOMercaderia();
        try {
            dao.Registrar(mer);
            response.sendRedirect("Mercaderia.jsp");
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
      out.write("                    <h1 class=\"mt-4\" align=\"center\"> Mercadería </h1>\n");
      out.write("                    <h4>Ingrese un nuevo producto al sistema</h4>\n");
      out.write("                    <br>\n");
      out.write("                    ");

                        if (msj.length() > 0) {
                            out.print("div class=\"error\">" + msj + "</div>");
                        }
                    
      out.write("\n");
      out.write("                    <form>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Producto</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"txtProducto\" placeholder=\"Ingrese nombre del producto\"\n");
      out.write("                                   value =\"");
      out.print( (mer != null ? mer.getProducto() : ""));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Presentación</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"txtPresentacion\" placeholder=\"Lbs., Arroba, Litros, etc.\"\n");
      out.write("                                   value =\"");
      out.print( (mer != null ? mer.getPresentacion() : ""));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Precio</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"txtPrecio\" placeholder=\" 0.00\"\n");
      out.write("                                   value =\"");
      out.print( (mer != null ? mer.getPrecio() : ""));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-success\">Insertar</button>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <div>\n");
      out.write("                        <div class=\"col-md-12\">\n");
      out.write("                            <br>\n");
      out.write("                            <h4>Listado de Productos</h4>\n");
      out.write("                            <div class=\"table-responsive\">                                 \n");
      out.write("                                <table class=\"table table-hover table-striped table-bordered\">\n");
      out.write("                                    <thead  class=\"brn btn-secondary\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th class=\"text-center\">N°</th>\n");
      out.write("                                            <th class=\"text-center\">Producto</th>\n");
      out.write("                                            <th class=\"text-center\">Presentacion</th>\n");
      out.write("                                            <th class=\"text-center\">Precio</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>  \n");
      out.write("                                    ");

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
                                    
      out.write("                                                          \n");
      out.write("                                    <!-- <a class=\"icon-pencil2\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Editar\" href=\"Controlador\"></a>\n");
      out.write("                                    </td>-->\n");
      out.write("                                </table>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /#page-content-wrapper -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- /#wrapper -->\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript -->\n");
      out.write("        <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Menu Toggle Script -->\n");
      out.write("        <script>\n");
      out.write("            $(\"#menu-toggle\").click(function (e) {\n");
      out.write("                e.preventDefault();\n");
      out.write("                $(\"#wrapper\").toggleClass(\"toggled\");\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
