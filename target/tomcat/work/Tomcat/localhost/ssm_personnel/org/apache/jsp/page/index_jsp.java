/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-07-07 05:56:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<title>后台登录</title>\n");
      out.write("\t<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi\" />\n");
      out.write("    <meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\n");
      out.write("\n");
      out.write("    <link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/public/logo.ico\" type=\"image/x-icon\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/public/css/font.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/public/css/xadmin.css\">\n");
      out.write("    <script type=\"text/javascript\" src=\"https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/public/lib/layui/layui.js\" charset=\"utf-8\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/public/js/xadmin.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <!-- 顶部开始 -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"logo\"><a href=\"./index.html\">人事管理系统</a></div>\n");
      out.write("        <div class=\"left_open\">\n");
      out.write("            <i title=\"展开左侧栏\" class=\"iconfont\">&#xe699;</i>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <ul class=\"layui-nav right\" lay-filter=\"\">\n");
      out.write("          <li class=\"layui-nav-item\">\n");
      out.write("            <a href=\"javascript:;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.admin.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\n");
      out.write("            <dl class=\"layui-nav-child\"> <!-- 二级菜单 -->\n");
      out.write("              <dd><a onclick=\"x_admin_show('个人信息','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/myupdate')\">个人信息</a></dd>\n");
      out.write("              <dd><a onclick=\"x_admin_show('切换账号','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/logout')\">切换账号</a></dd>\n");
      out.write("              <dd><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/logout\">退出</a></dd>\n");
      out.write("            </dl>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"layui-nav-item to-index\"><a>欢迎登录</a></li>\n");
      out.write("        </ul>\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("    <!-- 顶部结束 -->\n");
      out.write("    <!-- 中部开始 -->\n");
      out.write("     <!-- 左侧菜单开始 -->\n");
      out.write("    <div class=\"left-nav\">\n");
      out.write("      <div id=\"side-nav\">\n");
      out.write("        <ul id=\"nav\">\n");
      out.write("            <li>\n");
      out.write("                <a href=\"javascript:;\">\n");
      out.write("                    <i class=\"iconfont\">&#xe6b8;</i>\n");
      out.write("                    <cite>用户管理</cite>\n");
      out.write("                    <i class=\"iconfont nav_right\">&#xe697;</i>\n");
      out.write("                </a>\n");
      out.write("                <ul class=\"sub-menu\">\n");
      out.write("                    <li>\n");
      out.write("                        <a _href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/list\">\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\n");
      out.write("                            <cite>用户列表</cite>\n");
      out.write("                            \n");
      out.write("                        </a>\n");
      out.write("                    </li >\n");
      out.write("                    <li>\n");
      out.write("                        <a _href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/add\">\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\n");
      out.write("                            <cite>添加用户</cite>\n");
      out.write("                            \n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                   \n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"javascript:;\">\n");
      out.write("                    <i class=\"iconfont\">&#xe723;</i>\n");
      out.write("                    <cite>部门管理</cite>\n");
      out.write("                    <i class=\"iconfont nav_right\">&#xe697;</i>\n");
      out.write("                </a>\n");
      out.write("                <ul class=\"sub-menu\">\n");
      out.write("                    <li>\n");
      out.write("                        <a _href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/dept/list\">\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\n");
      out.write("                            <cite>部门列表</cite>\n");
      out.write("                        </a>\n");
      out.write("                    </li >\n");
      out.write("                    <li>\n");
      out.write("                        <a _href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/dept/add\">\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\n");
      out.write("                            <cite>添加部门</cite>\n");
      out.write("                        </a>\n");
      out.write("                    </li >\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"javascript:;\">\n");
      out.write("                    <i class=\"iconfont\">&#xe723;</i>\n");
      out.write("                    <cite>职位管理</cite>\n");
      out.write("                    <i class=\"iconfont nav_right\">&#xe697;</i>\n");
      out.write("                </a>\n");
      out.write("                <ul class=\"sub-menu\">\n");
      out.write("                    <li>\n");
      out.write("                        <a _href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/job/list\">\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\n");
      out.write("                            <cite>职位列表</cite>\n");
      out.write("                        </a>\n");
      out.write("                    </li >\n");
      out.write("                     <li>\n");
      out.write("                        <a _href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/job/add\">\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\n");
      out.write("                            <cite>添加职位</cite>\n");
      out.write("                        </a>\n");
      out.write("                    </li >\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("           \n");
      out.write("            <li>\n");
      out.write("                <a href=\"javascript:;\">\n");
      out.write("                    <i class=\"iconfont\">&#xe726;</i>\n");
      out.write("                    <cite>员工管理</cite>\n");
      out.write("                    <i class=\"iconfont nav_right\">&#xe697;</i>\n");
      out.write("                </a>\n");
      out.write("                <ul class=\"sub-menu\">\n");
      out.write("                    <li>\n");
      out.write("                        <a _href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/employee/list\">\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\n");
      out.write("                            <cite>员工列表</cite>\n");
      out.write("                        </a>\n");
      out.write("                    </li >\n");
      out.write("                    <li>\n");
      out.write("                        <a _href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/employee/add\">\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\n");
      out.write("                            <cite>添加员工</cite>\n");
      out.write("                        </a>\n");
      out.write("                    </li >\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"javascript:;\">\n");
      out.write("                    <i class=\"iconfont\">&#xe6ce;</i>\n");
      out.write("                    <cite>公告管理</cite>\n");
      out.write("                    <i class=\"iconfont nav_right\">&#xe697;</i>\n");
      out.write("                </a>\n");
      out.write("                <ul class=\"sub-menu\">\n");
      out.write("                    <li>\n");
      out.write("                        <a _href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/notice/list\">\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\n");
      out.write("                            <cite>公告查询</cite>\n");
      out.write("                        </a>\n");
      out.write("                    </li >\n");
      out.write("                    <li>\n");
      out.write("                        <a _href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/notice/add\">\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\n");
      out.write("                            <cite>添加公告</cite>\n");
      out.write("                        </a>\n");
      out.write("                    </li >\n");
      out.write("                   \n");
      out.write("                   \n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"javascript:;\">\n");
      out.write("                    <i class=\"iconfont\">&#xe6b4;</i>\n");
      out.write("                    <cite>下载中心</cite>\n");
      out.write("                    <i class=\"iconfont nav_right\">&#xe697;</i>\n");
      out.write("                </a>\n");
      out.write("                <ul class=\"sub-menu\">\n");
      out.write("                    <li>\n");
      out.write("                        <a _href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/document/list\">\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\n");
      out.write("                            <cite>文档查询</cite>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a _href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/document/add\">\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\n");
      out.write("                            <cite>上传文档</cite>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- <div class=\"x-slide_left\"></div> -->\n");
      out.write("    <!-- 左侧菜单结束 -->\n");
      out.write("    <!-- 右侧主体开始 -->\n");
      out.write("    <div class=\"page-content\">\n");
      out.write("        <div class=\"layui-tab tab\" lay-filter=\"xbs_tab\" lay-allowclose=\"false\">\n");
      out.write("          <ul class=\"layui-tab-title\">\n");
      out.write("            <li class=\"home\"><i class=\"layui-icon\">&#xe68e;</i>我的桌面</li>\n");
      out.write("          </ul>\n");
      out.write("          <div class=\"layui-tab-content\">\n");
      out.write("            <div class=\"layui-tab-item layui-show\">\n");
      out.write("                <iframe src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/welcome' frameborder=\"0\" scrolling=\"yes\" class=\"x-iframe\"></iframe>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"page-content-bg\"></div>\n");
      out.write("    <!-- 右侧主体结束 -->\n");
      out.write("    <!-- 中部结束 -->\n");
      out.write("    <!-- 底部开始 -->\n");
      out.write("    <div class=\"footer\">\n");
      out.write("        <div class=\"copyright\">Copyright ©2019 Rain</div>  \n");
      out.write("    </div>\n");
      out.write("    <!-- 底部结束 -->\n");
      out.write(" \n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /page/index.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /page/index.jsp(4,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/page/index.jsp(4,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
