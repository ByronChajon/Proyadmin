package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SQLserver_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html;\">\n");
      out.write("\n");
      out.write("\n");
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
      out.write("                <div class=\"sidebar-heading\">Control Abarrotería</div>\n");
      out.write("                <div class=\"list-group list-group-flush\">\n");
      out.write("                    <a href=\"index.html\" class=\"list-group-item list-group-item-action bg-light\">Inicio</a>\n");
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
      out.write("                    <h1 class=\"mt-4\"> Base de Datos SQL Server </h1>\n");
      out.write("                    <p>Sistema de control de ventas Abarrotería</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <h4>Comparacion de navegadores</h4>\n");
      out.write("                <canvas id=\"myChart\"></canvas>\n");
      out.write("                <br>\n");
      out.write("                <h4>Gráfico de barras</h4>\n");
      out.write("                <canvas id=\"myChart1\"></canvas>\n");
      out.write("                <br>\n");
      out.write("                <h4>Gráfico de líneas</h4>\n");
      out.write("                <canvas id=\"myChart2\"></canvas>\n");
      out.write("                <br>\n");
      out.write("                <script src=\"chart.js\"></script>\n");
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    var ctx = document.getElementById('myChart').getContext('2d');\n");
      out.write("                    var chart = new Chart(ctx, {\n");
      out.write("                        type: 'bar',\n");
      out.write("                        data: {\n");
      out.write("                            labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],\n");
      out.write("                            datasets: [{\n");
      out.write("                                    label: 'Ingresos',\n");
      out.write("                                    backgroundColor: '#42a5f5',\n");
      out.write("                                    borderColor: 'gray',\n");
      out.write("                                    data: [7, 8, 5, 2, 8, 10, 7, -7, 4, 9, -8, 5]\n");
      out.write("                                }, {\n");
      out.write("                                    label: 'Gastos',\n");
      out.write("                                    backgroundColor: '#ffab91',\n");
      out.write("                                    borderColor: 'yellow',\n");
      out.write("                                    data: [5, -8, 10, 3, -7, 6, 8, -2, -6, 9, -7, 2]\n");
      out.write("                                }\n");
      out.write("                            ]},\n");
      out.write("                        options: {responsive: true}\n");
      out.write("                    });\n");
      out.write("                    var ctx1 = document.getElementById('myChart1').getContext('2d');\n");
      out.write("                    var chart = new Chart(ctx1, {\n");
      out.write("                        type: 'line',\n");
      out.write("                        data: {\n");
      out.write("                            labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],\n");
      out.write("                            datasets: [{\n");
      out.write("                                    label: 'Ganancias',\n");
      out.write("                                    backgroundColor: '#42a5f5',\n");
      out.write("                                    borderColor: 'gray',\n");
      out.write("                                    data: [7, 8, 5, 2, 8, 10, 7, -7, 4, 9, -8, 5]\n");
      out.write("                                }\n");
      out.write("                            ]},\n");
      out.write("                        options: {}\n");
      out.write("                    });\n");
      out.write("                    var ctx2 = document.getElementById('myChart2').getContext('2d');\n");
      out.write("                    var chart = new Chart(ctx2, {\n");
      out.write("                        type: 'doughnut',\n");
      out.write("                        data:\n");
      out.write("                                {\n");
      out.write("                                    datasets: [{\n");
      out.write("                                            data: [60, 18, 10, 8, 4],\n");
      out.write("                                            backgroundColor: ['#42a5f5', 'red', 'green', 'blue', 'violet'],\n");
      out.write("                                            label: 'Comparacion de navegadores'\n");
      out.write("                                        }],\n");
      out.write("                                    labels: [\n");
      out.write("                                        'Google Chrome',\n");
      out.write("                                        'Safari',\n");
      out.write("                                        'Edge',\n");
      out.write("                                        'Firefox',\n");
      out.write("                                        'Opera'\n");
      out.write("                                    ]},\n");
      out.write("                        options: {}\n");
      out.write("                    });\n");
      out.write("                </script>\n");
      out.write("\n");
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
      out.write("    $(\"#menu-toggle\").click(function (e) {\n");
      out.write("        e.preventDefault();\n");
      out.write("        $(\"#wrapper\").toggleClass(\"toggled\");\n");
      out.write("    });\n");
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
