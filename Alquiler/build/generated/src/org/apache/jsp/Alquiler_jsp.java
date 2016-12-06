package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import negocio.LineaObj;
import negocio.AlquilerObj;

public final class Alquiler_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/styls/plantilla-part01.jsp");
    _jspx_dependants.add("/styls/plantilla-part02.jsp");
    _jspx_dependants.add("/styls/plantilla-part03.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_x_submit_value_styleClass_property_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_x_form_action;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_x_submit_value_styleClass_property_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_x_form_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_x_submit_value_styleClass_property_nobody.release();
    _jspx_tagPool_x_form_action.release();
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
      out.write("\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("  <link rel=\"shortcut icon\" href=\"styls/favicon.ico\" />\n");
      out.write("  <title>Sistema Alquiler</title>\n");
      out.write("\n");
      out.write("  <link href=\"styls/vendors/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("  <link href=\"styls/vendors/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("  <link href=\"styls/build/css/custom.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 AlquilerObj alq = (AlquilerObj) session.getAttribute("alqObj");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("<body class=\"nav-md\">\n");
      out.write("    <div class=\"container body\">\n");
      out.write("        <div class=\"main_container\">\n");
      out.write("            <div class=\"col-md-3 left_col\">\n");
      out.write("                <div class=\"left_col scroll-view\">\n");
      out.write("                    <div class=\"navbar nav_title\" style=\"border: 0;\">\n");
      out.write("                        <a href=\"home.jsp\" class=\"site_title\"><i class=\"fa fa-car\" aria-hidden=\"true\"></i><span> Alquiler!</span></a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"clearfix\"></div>\n");
      out.write("                    <br />\n");
      out.write("                    <!-- sidebar menu -->\n");
      out.write("                    <div id=\"sidebar-menu\" class=\"main_menu_side hidden-print main_menu\">\n");
      out.write("                        <div class=\"menu_section\">\n");
      out.write("                            <h3>Mantenimiento</h3>\n");
      out.write("                            <ul class=\"nav side-menu\">\n");
      out.write("                                <!-- Menu 01-->\n");
      out.write("                                <li><a href=\"home.jsp\"><i class=\"fa fa-home\"></i> Home</a>\n");
      out.write("                                </li>\n");
      out.write("                                <!-- END Menu 01-->\n");
      out.write("                                <!-- Menu 02-->\n");
      out.write("                                <li><a><i class=\"fa fa-edit\"></i> Empleado <span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                    <ul class=\"nav child_menu\">\n");
      out.write("                                        <li><a href=\"GrabarEmpleado.jsp\">Agregar uno nuevo</a></li>\n");
      out.write("                                        <li><a href=\"BuscarEmpleado.jsp\">Listar</a></li>\n");
      out.write("                                        \n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("\n");
      out.write("                                <li><a><i class=\"fa fa-edit\"></i> Vehiculo <span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                    <ul class=\"nav child_menu\">\n");
      out.write("                                        <li><a href=\"GrabarVehiculo.jsp\">Agregar uno nuevo</a></li>\n");
      out.write("                                        <li><a href=\"BuscarVehiculo.jsp\">Listar</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                \n");
      out.write("                                <li><a><i class=\"fa fa-edit\"></i> Ruta <span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                    <ul class=\"nav child_menu\">\n");
      out.write("                                        <li><a href=\"GrabarRuta.jsp\">Agregar uno nuevo</a></li>\n");
      out.write("                                        <li><a href=\"BuscarRuta.jsp\">Listar</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                                \n");
      out.write("                                <!-- END Menu 02-->\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"menu_section\">\n");
      out.write("                            <h3>Live On</h3>\n");
      out.write("                            <ul class=\"nav side-menu\">\n");
      out.write("                                <li><a><i class=\"fa fa-bug\"></i> Additional Pages <span class=\"fa fa-chevron-down\"></span></a>\n");
      out.write("                                    <ul class=\"nav child_menu\">\n");
      out.write("                                        <li><a href=\"#\">E-commerce</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /sidebar menu -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- top navigation -->\n");
      out.write("            <div class=\"top_nav\">\n");
      out.write("                <div class=\"nav_menu\">\n");
      out.write("                    <nav>\n");
      out.write("                        <div class=\"nav toggle\">\n");
      out.write("                            <a id=\"menu_toggle\"><i class=\"fa fa-bars\"></i></a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                            <li class=\"\">\n");
      out.write("                                <a href=\"javascript:;\" class=\"user-profile dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                                    <i class=\"fa fa-cogs\" aria-hidden=\"true\"></i>  SISTEMA\n");
      out.write("                                    <span class=\" fa fa-angle-down\"></span>\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu dropdown-usermenu pull-right\">\n");
      out.write("                                    <li><a href=\"javascript:;\"> Profile</a></li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"javascript:;\">\n");
      out.write("                                            <span class=\"badge bg-red pull-right\">50%</span>\n");
      out.write("                                            <span>Settings</span>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li><a href=\"javascript:;\">Help</a></li>\n");
      out.write("                                    <li><a href=\"login.jsp\"><i class=\"fa fa-sign-out pull-right\"></i> Log Out</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- /top navigation -->\n");
      out.write("            <!-- page content -->\n");
      out.write("            <div class=\"right_col\" role=\"main\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- CUERPO DE LA PÁGINA -->\n");
      out.write("        <div class=\"\">\n");
      out.write("            <div class=\"page-title\">\n");
      out.write("                <div class=\"title_left\">\n");
      out.write("                    <h3>Alquiler!!</h3>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12 col-sm-12 col-xs-12\">\n");
      out.write("                    <div class=\"x_panel\">\n");
      out.write("\n");
      out.write("                        <div class=\"x_content\">\n");
      out.write("                            <span class=\"section\">Datos Alquiler</span>\n");
      out.write("\n");
      out.write("                            <div class=\"form-horizontal form-label-left\" >\n");
      out.write("\n");
      out.write("                                <div class=\"item form-group\">\n");
      out.write("                                    <label class=\"control-label col-md-1 col-sm-3 col-xs-6\" >Número</label>\n");
      out.write("                                    <div class=\"col-md-2 col-sm-2 col-xs-2\">\n");
      out.write("                                        <input id=\"name\" class=\"form-control col-md-7 col-xs-12\" value='");
      out.print( alq.getNumAlq() + "");
      out.write("' type=\"text\" readonly=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <label class=\"control-label col-md-1 col-sm-3 col-xs-3\" >Fecha</label>\n");
      out.write("                                    </label>\n");
      out.write("                                    <div class=\"col-md-2 col-sm-2 col-xs-2\">\n");
      out.write("                                        <input id=\"name\" class=\"form-control col-md-7 col-xs-6\" value='");
      out.print( alq.getFecAlq());
      out.write("' type=\"text\" readonly=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <label class=\"control-label col-md-1 col-sm-3 col-xs-6\" >Hora</label>\n");
      out.write("                                    </label>\n");
      out.write("                                    <div class=\"col-md-2 col-sm-2 col-xs-4\">\n");
      out.write("                                        <input id=\"name\" class=\"form-control col-md-7 col-xs-6\" value='");
      out.print( alq.getHora());
      out.write("' type=\"text\" readonly=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <span class=\"section\">Datos Empleado</span>\n");
      out.write("\n");
      out.write("                                <div class=\"item form-group\">\n");
      out.write("                                    <label class=\"control-label col-md-1 col-sm-3 col-xs-12\" >Código</label>\n");
      out.write("                                    <div class=\"col-md-2 col-sm-2 col-xs-4\">\n");
      out.write("                                        <input id=\"name\" class=\"form-control col-md-7 col-xs-12\" value='");
      out.print( alq.getCodEmp().getCodEmp());
      out.write("' type=\"text\" readonly=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <label class=\"control-label col-md-1 col-sm-3 col-xs-12\" >Nombre</label>\n");
      out.write("                                    <div class=\"col-md-4 col-sm-4 col-xs-8\">\n");
      out.write("                                        <input id=\"name\" class=\"form-control col-md-7 col-xs-12\" value='");
      out.print( alq.getCodEmp().getNomEmp());
      out.write("' type=\"text\" readonly=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <span class=\"section\">Datos Vehículo</span>\n");
      out.write("\n");
      out.write("                                <div class=\"item form-group\">\n");
      out.write("                                    <label class=\"control-label col-md-1 col-sm-3 col-xs-12\" >Código <span class=\"required\">*</span>\n");
      out.write("                                    </label>\n");
      out.write("                                    <div class=\"col-md-2 col-sm-2 col-xs-4\">\n");
      out.write("                                        <input id=\"name\" class=\"form-control col-md-7 col-xs-12\" value='");
      out.print( alq.getCodVeh().getCodVeh());
      out.write("' type=\"text\" readonly=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <label class=\"control-label col-md-1 col-sm-3 col-xs-12\" for=\"name\">Modelo</label>\n");
      out.write("                                    <div class=\"col-md-3 col-sm-3 col-xs-6\">\n");
      out.write("                                        <input id=\"name\" class=\"form-control col-md-7 col-xs-12\" value='");
      out.print( alq.getCodVeh().getModelVeh());
      out.write("' type=\"text\" readonly=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <label class=\"control-label col-md-2 col-sm-3 col-xs-12\">Costo x día</label>\n");
      out.write("                                    <div class=\"col-md-2 col-sm-2 col-xs-4\">\n");
      out.write("                                        <input id=\"name\" class=\"form-control col-md-7 col-xs-12\" value='");
      out.print( alq.getCodVeh().getPrecVeh() + "");
      out.write("' type=\"text\" readonly=\"\">\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                ");
      if (_jspx_meth_x_form_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"title_left\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12 col-sm-12 col-xs-12\">\n");
      out.write("                    <div class=\"x_panel\">\n");
      out.write("\n");
      out.write("                        <div class=\"x_content\">\n");
      out.write("                            <div class=\"form-horizontal form-label-left\" >\n");
      out.write("                                <table class=\"table\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Codigo</th>\n");
      out.write("                                            <th>Nombre</th>\n");
      out.write("                                            <th>Precio</th>\n");
      out.write("                                            <th>Día</th>\n");
      out.write("                                            <th></th>\n");
      out.write("                                        </tr>    \n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody class=\"table\">\n");
      out.write("                                        ");

                                            for (int i = 0; i < alq.getCesta().size(); i++) {
                                                LineaObj li = (LineaObj) alq.getCesta().get(i);
                                        
      out.write("\n");
      out.write("                                        <tr> \n");
      out.write("                                            <td><span class=\"label label-primary\">");
      out.print( li.getCodRut().getCodRut());
      out.write("</span></td>\n");
      out.write("                                            <td>");
      out.print( li.getCodRut().getParadAut());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print( li.getCodRut().getPrecRut());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print( li.getDia());
      out.write("</td>\n");
      out.write("                                            <td></td>                                    \n");
      out.write("                                        </tr>\n");
      out.write("                                        ");
 }
      out.write("\n");
      out.write("                                    </tbody>\n");
      out.write("\n");
      out.write("                                </table>\n");
      out.write("                                ");
      if (_jspx_meth_x_form_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                <table class=\"table\" style=\"width: 30%; margin-left: 67%;\">\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr> \n");
      out.write("                                            <td style=\"background-color: rgba(255, 235, 59, 0.39)\">Rutas (S/.):</td>\n");
      out.write("                                            <td style=\"text-align: center\">");
      out.print( alq.getImporteVehículo());
      out.write("</td>                                \n");
      out.write("                                        </tr>   \n");
      out.write("                                        <tr> \n");
      out.write("                                            <td style=\"background-color: rgba(255, 235, 59, 0.39)\">Vehículo/d (S/.):</td>\n");
      out.write("                                            <td style=\"text-align: center\">");
      out.print( alq.getImporteRutas());
      out.write("</td>                                \n");
      out.write("                                        </tr>     \n");
      out.write("                                        <tr> \n");
      out.write("                                            <td style=\"background-color: rgba(255, 235, 59, 0.39)\">Descuento (S/.):</td>\n");
      out.write("                                            <td style=\"text-align: center\">");
      out.print( alq.getDesct());
      out.write("</td>                                \n");
      out.write("                                        </tr>        \n");
      out.write("                                        <tr> \n");
      out.write("                                            <td style=\"background-color: rgba(255, 235, 59, 0.39)\">Importe Total (S/.):</td>\n");
      out.write("                                            <td style=\"background-color: red; color: white; text-align: center\"><samp>");
      out.print( alq.getTotal());
      out.write("</samp></td>                                \n");
      out.write("                                        </tr>     \n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <div class=\"col-md-6 col-md-offset-3\">\n");
      out.write("                            ");
      if (_jspx_meth_x_form_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- FIN CUERPO DE LA PÁGINA-->\n");
      out.write("\n");
      out.write("        ");
      out.write("</div>\n");
      out.write("<!-- /page content -->\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script src=\"styls/vendors/jquery/dist/jquery.min.js\"></script>\n");
      out.write("<script src=\"styls/vendors/bootstrap/dist/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"styls/build/js/custom.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_x_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  x:form
    org.apache.struts.taglib.html.FormTag _jspx_th_x_form_0 = (org.apache.struts.taglib.html.FormTag) _jspx_tagPool_x_form_action.get(org.apache.struts.taglib.html.FormTag.class);
    _jspx_th_x_form_0.setPageContext(_jspx_page_context);
    _jspx_th_x_form_0.setParent(null);
    _jspx_th_x_form_0.setAction("/ListarVehiculoAction");
    int _jspx_eval_x_form_0 = _jspx_th_x_form_0.doStartTag();
    if (_jspx_eval_x_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    ");
        if (_jspx_meth_x_submit_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_x_form_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_x_form_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_x_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_x_form_action.reuse(_jspx_th_x_form_0);
      return true;
    }
    _jspx_tagPool_x_form_action.reuse(_jspx_th_x_form_0);
    return false;
  }

  private boolean _jspx_meth_x_submit_0(javax.servlet.jsp.tagext.JspTag _jspx_th_x_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  x:submit
    org.apache.struts.taglib.html.SubmitTag _jspx_th_x_submit_0 = (org.apache.struts.taglib.html.SubmitTag) _jspx_tagPool_x_submit_value_styleClass_property_nobody.get(org.apache.struts.taglib.html.SubmitTag.class);
    _jspx_th_x_submit_0.setPageContext(_jspx_page_context);
    _jspx_th_x_submit_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_x_form_0);
    _jspx_th_x_submit_0.setStyleClass("btn btn-warning");
    _jspx_th_x_submit_0.setProperty("lisVeh");
    _jspx_th_x_submit_0.setValue("Buscar Vehículo");
    int _jspx_eval_x_submit_0 = _jspx_th_x_submit_0.doStartTag();
    if (_jspx_th_x_submit_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_x_submit_value_styleClass_property_nobody.reuse(_jspx_th_x_submit_0);
      return true;
    }
    _jspx_tagPool_x_submit_value_styleClass_property_nobody.reuse(_jspx_th_x_submit_0);
    return false;
  }

  private boolean _jspx_meth_x_form_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  x:form
    org.apache.struts.taglib.html.FormTag _jspx_th_x_form_1 = (org.apache.struts.taglib.html.FormTag) _jspx_tagPool_x_form_action.get(org.apache.struts.taglib.html.FormTag.class);
    _jspx_th_x_form_1.setPageContext(_jspx_page_context);
    _jspx_th_x_form_1.setParent(null);
    _jspx_th_x_form_1.setAction("/ListarRutaAction");
    int _jspx_eval_x_form_1 = _jspx_th_x_form_1.doStartTag();
    if (_jspx_eval_x_form_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    ");
        if (_jspx_meth_x_submit_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_x_form_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_x_form_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_x_form_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_x_form_action.reuse(_jspx_th_x_form_1);
      return true;
    }
    _jspx_tagPool_x_form_action.reuse(_jspx_th_x_form_1);
    return false;
  }

  private boolean _jspx_meth_x_submit_1(javax.servlet.jsp.tagext.JspTag _jspx_th_x_form_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  x:submit
    org.apache.struts.taglib.html.SubmitTag _jspx_th_x_submit_1 = (org.apache.struts.taglib.html.SubmitTag) _jspx_tagPool_x_submit_value_styleClass_property_nobody.get(org.apache.struts.taglib.html.SubmitTag.class);
    _jspx_th_x_submit_1.setPageContext(_jspx_page_context);
    _jspx_th_x_submit_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_x_form_1);
    _jspx_th_x_submit_1.setStyleClass("btn btn-warning");
    _jspx_th_x_submit_1.setProperty("lisRut");
    _jspx_th_x_submit_1.setValue("Buscar Ruta");
    int _jspx_eval_x_submit_1 = _jspx_th_x_submit_1.doStartTag();
    if (_jspx_th_x_submit_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_x_submit_value_styleClass_property_nobody.reuse(_jspx_th_x_submit_1);
      return true;
    }
    _jspx_tagPool_x_submit_value_styleClass_property_nobody.reuse(_jspx_th_x_submit_1);
    return false;
  }

  private boolean _jspx_meth_x_form_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  x:form
    org.apache.struts.taglib.html.FormTag _jspx_th_x_form_2 = (org.apache.struts.taglib.html.FormTag) _jspx_tagPool_x_form_action.get(org.apache.struts.taglib.html.FormTag.class);
    _jspx_th_x_form_2.setPageContext(_jspx_page_context);
    _jspx_th_x_form_2.setParent(null);
    _jspx_th_x_form_2.setAction("/GrabarAlquilerAction");
    int _jspx_eval_x_form_2 = _jspx_th_x_form_2.doStartTag();
    if (_jspx_eval_x_form_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_x_submit_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_x_form_2, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_x_form_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_x_form_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_x_form_action.reuse(_jspx_th_x_form_2);
      return true;
    }
    _jspx_tagPool_x_form_action.reuse(_jspx_th_x_form_2);
    return false;
  }

  private boolean _jspx_meth_x_submit_2(javax.servlet.jsp.tagext.JspTag _jspx_th_x_form_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  x:submit
    org.apache.struts.taglib.html.SubmitTag _jspx_th_x_submit_2 = (org.apache.struts.taglib.html.SubmitTag) _jspx_tagPool_x_submit_value_styleClass_property_nobody.get(org.apache.struts.taglib.html.SubmitTag.class);
    _jspx_th_x_submit_2.setPageContext(_jspx_page_context);
    _jspx_th_x_submit_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_x_form_2);
    _jspx_th_x_submit_2.setStyleClass("btn btn-danger  btn-lg");
    _jspx_th_x_submit_2.setProperty("gra");
    _jspx_th_x_submit_2.setValue("Grabar");
    int _jspx_eval_x_submit_2 = _jspx_th_x_submit_2.doStartTag();
    if (_jspx_th_x_submit_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_x_submit_value_styleClass_property_nobody.reuse(_jspx_th_x_submit_2);
      return true;
    }
    _jspx_tagPool_x_submit_value_styleClass_property_nobody.reuse(_jspx_th_x_submit_2);
    return false;
  }
}
