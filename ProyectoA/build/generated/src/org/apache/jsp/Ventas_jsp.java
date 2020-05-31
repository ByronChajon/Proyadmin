package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entidadesproyecto.Mercaderia;
import entidadesproyecto.Detalle;
import entidadesproyecto.Venta;
import daoproyecto.DAOVenta;
import entidadesproyecto.Cliente;
import java.util.List;
import daoproyecto.DAOCliente;

public final class Ventas_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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
      out.write("        <!-- Minified Bootstrap CSS -->\n");
      out.write("\n");
      out.write("        <link href=\"css/bootstrap-datetimepicker.min.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"js/bootstrap-datetimepicker.min.js\"></script>\n");
      out.write("\n");
      out.write("        <title>SISTEMA DE VENTAS</title>\n");
      out.write("\n");
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
      out.write("                <div class=\"sidebar-heading\">Está usando SQL Server</div>\n");
      out.write("                <div class=\"list-group list-group-flush\">\n");
      out.write("                    <a href=\"SQLserver.jsp\" class=\"list-group-item list-group-item-action bg-light\">Cambiar Base de datos</a>\n");
      out.write("                    <a href=\"Clientes.jsp\" class=\"list-group-item list-group-item-action bg-light\">Clientes</a>\n");
      out.write("                    <a href=\"Mercaderia.jsp\" class=\"list-group-item list-group-item-action bg-light\">Mercaderia</a>\n");
      out.write("                    <a href=\"Ventas.jsp\" class=\"list-group-item list-group-item-action bg-light\">Ventas</a>\n");
      out.write("                    <!--<a href=\"#\" class=\"list-group-item list-group-item-action bg-light\"></a>\n");
      out.write("                                <a href=\"#\" class=\"list-group-item list-group-item-action bg-light\"></a>-->\n");
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
      out.write("                    <h1 class=\"mt-4\"> Ventas </h1>\n");
      out.write("                    <p>Registrar una nueva venta ventas</p>\n");
      out.write("                    <form name=\"frmVentas\" action=\"Ventas.jsp\" method=\"post\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Cliente</label>\n");
      out.write("                            <div>\n");
      out.write("                                <select class=\"form-control\" name=\"cboCliente\">\n");
      out.write("                                    <option>Elija el cliente</option>\n");
      out.write("                                    ");

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
                                    
      out.write("\n");
      out.write("\n");
      out.write("                                </select>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Fecha</label>\n");
      out.write("                            <input type=\"date\" class=\"form-control  col-md-4\" name=\"txtFecha\" placeholder=\"\"\n");
      out.write("                                   >\n");
      out.write("                        </div> \n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"submit\" class=\"btn btn-success\" value=\"Registrar\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Total</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control col-md-2\" name=\"txtTotal\" placeholder=\"Automatico\"\n");
      out.write("                                   >\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"submit\" class=\"btn btn-success\" value=\"Registrar\">\n");
      out.write("                    </form>\n");
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
