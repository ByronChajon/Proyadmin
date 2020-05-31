package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editarclienteso_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<script src=\"bootstrap/js/chart.js\" type=\"text/javascript\"></script>\n");
      out.write("<title>Chart.js</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h1>Chart.js</h1>\n");
      out.write("<h4>Comparacion de navegadores</h4>\n");
      out.write("<canvas id=\"myChart\"></canvas>\n");
      out.write("<br>\n");
      out.write("<h4>Gráfico de barras</h4>\n");
      out.write("<canvas id=\"myChart1\"></canvas>\n");
      out.write("<br>\n");
      out.write("<h4>Gráfico de líneas</h4>\n");
      out.write("<canvas id=\"myChart2\"></canvas>\n");
      out.write("<br>\n");
      out.write("<script src=\"chart.js\"></script>\n");
      out.write("<script>\n");
      out.write("var ctx = document.getElementById('myChart').getContext('2d');\n");
      out.write("var chart = new Chart(ctx, {\n");
      out.write("    type: 'bar',\n");
      out.write("    data: {\n");
      out.write("        labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],\n");
      out.write("        datasets: [{\n");
      out.write("            label: 'Ingresos',\n");
      out.write("            backgroundColor: '#42a5f5',\n");
      out.write("            borderColor: 'gray',\n");
      out.write("            data: [7, 8, 5, 2, 8, 10, 7,-7,4,9,-8,5]\n");
      out.write("        },{\n");
      out.write("            label: 'Gastos',\n");
      out.write("            backgroundColor: '#ffab91',\n");
      out.write("            borderColor: 'yellow',\n");
      out.write("            data: [5, -8, 10, 3,-7,6,8,-2,-6,9,-7,2]\n");
      out.write("        }\t\t\n");
      out.write("\t\t]},\n");
      out.write("    options: {responsive: true}\n");
      out.write("});\n");
      out.write("var ctx1 = document.getElementById('myChart1').getContext('2d');\n");
      out.write("var chart = new Chart(ctx1, {\n");
      out.write("    type: 'line',\n");
      out.write("    data: {\n");
      out.write("        labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],\n");
      out.write("        datasets: [{\n");
      out.write("            label: 'Ganancias',\n");
      out.write("            backgroundColor: '#42a5f5',\n");
      out.write("            borderColor: 'gray',\n");
      out.write("            data: [7, 8, 5, 2, 8, 10, 7,-7,4,9,-8,5]\n");
      out.write("        }\t\t\n");
      out.write("\t\t]},\n");
      out.write("    options: {}\n");
      out.write("});\n");
      out.write("var ctx2 = document.getElementById('myChart2').getContext('2d');\n");
      out.write("var chart = new Chart(ctx2, {\n");
      out.write("    type: 'doughnut',\n");
      out.write("    data: \t\n");
      out.write("\t{\n");
      out.write("\t\t\t\tdatasets: [{\n");
      out.write("\t\t\t\t\t data: [60,18,10, 8, 4],\n");
      out.write("\t\t\t\t\tbackgroundColor: ['#42a5f5', 'red', 'green','blue','violet'],\n");
      out.write("\t\t\t\t\tlabel: 'Comparacion de navegadores'\n");
      out.write("\t\t\t\t}],\n");
      out.write("\t\t\t\tlabels: [\n");
      out.write("\t\t\t\t\t'Google Chrome',\n");
      out.write("\t\t\t\t\t'Safari',\n");
      out.write("\t\t\t\t\t'Edge',\n");
      out.write("\t\t\t\t\t'Firefox',\n");
      out.write("\t\t\t\t\t'Opera'\n");
      out.write("\t\t\t\t]},\n");
      out.write("    options: {}\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>    ");
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
