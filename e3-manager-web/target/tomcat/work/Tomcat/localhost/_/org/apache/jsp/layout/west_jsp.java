/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-08-29 12:16:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class west_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$('#menu').tree({\r\n");
      out.write("\t\t\tonClick: function(node){\r\n");
      out.write("\t\t\t\tif($('#menu').tree(\"isLeaf\",node.target)){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\taddTab({\r\n");
      out.write("\t\t\t\t\t\t\turl : node.attributes.url,\r\n");
      out.write("\t\t\t\t\t\t\ttitle : node.text,\r\n");
      out.write("\t\t\t\t\t\t\ticonCls : node.iconCls\r\n");
      out.write("\t\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t});\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$('#menu1').tree({\r\n");
      out.write("\t\t\tonClick: function(node){\r\n");
      out.write("\t\t\t\tif($('#menu').tree(\"isLeaf\",node.target)){\r\n");
      out.write("\t\t\t\t\t\taddTab({\r\n");
      out.write("\t\t\t\t\t\t\turl : node.attributes.url,\r\n");
      out.write("\t\t\t\t\t\t\ttitle : node.text,\r\n");
      out.write("\t\t\t\t\t\t\ticonCls : node.iconCls\r\n");
      out.write("\t\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t});\r\n");
      out.write("\tfunction addTab(params) {\r\n");
      out.write("\t\tvar iframe = '<iframe src=\"' + params.url + '\" frameborder=\"0\" style=\"border:0;width:100%;height:98%;\"></iframe>';\r\n");
      out.write("\t\tvar t = $('#index_tabs');\r\n");
      out.write("\t\tvar opts = {\r\n");
      out.write("\t\t\ttitle : params.title,\r\n");
      out.write("\t\t\tclosable : true,\r\n");
      out.write("\t\t\ticonCls : params.iconCls,\r\n");
      out.write("\t\t\tcontent : iframe,\r\n");
      out.write("\t\t\tborder : false,\r\n");
      out.write("\t\t\tfit : true\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tif (t.tabs('exists', opts.title)) {\r\n");
      out.write("\t\t\tt.tabs('select', opts.title);\r\n");
      out.write("\t\t\tparent.$.messager.progress('close');\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tt.tabs('add', opts);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<div class=\"easyui-accordion\" data-options=\"fit:true,border:false\">\t\r\n");
      out.write("\t<div title=\"商品管理\" data-options=\"border:false\">\r\n");
      out.write("\t\t<ul id=\"menu\" class=\"easyui-tree\" style=\"margin-top: 10px;margin-left: 5px;\">\r\n");
      out.write("         \t\r\n");
      out.write("\t         \t\t<li data-options=\"attributes:{'url':'item-add'}\">新增商品</li>\r\n");
      out.write("\t         \t\t<li data-options=\"attributes:{'url':'item-list'}\">查询商品</li>\r\n");
      out.write("\t         \t\t<li data-options=\"attributes:{'url':'item-param-list'}\">规格参数</li>\r\n");
      out.write("\t        \r\n");
      out.write("         </ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div title=\"广告管理\" data-options=\"border:false\">\r\n");
      out.write("\t\t<ul id=\"menu1\" class=\"easyui-tree\" style=\"margin-top: 10px;margin-left: 5px;\">\r\n");
      out.write("         \t\r\n");
      out.write("\t         \t\t<li data-options=\"attributes:{'url':'content-category'}\">内容分类管理</li>\r\n");
      out.write("\t         \t\t<li data-options=\"attributes:{'url':'content'}\">内容管理</li>\r\n");
      out.write("\t         \t\t<li data-options=\"attributes:{'url':'index-manager'}\">索引库维护</li>\r\n");
      out.write("\t         \r\n");
      out.write("         </ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div title=\"促销管理\" data-options=\"border:false\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div title=\"订单管理\" data-options=\"border:false\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div title=\"报表统计\" data-options=\"border:false\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div title=\"文章管理\" data-options=\"border:false\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div title=\"会员管理\" data-options=\"border:false\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div title=\"权限管理\" data-options=\"border:false\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div title=\"系统设置\" data-options=\"border:false\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div title=\"短信管理\" data-options=\"border:false\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div title=\"邮件群发管理\" data-options=\"border:false\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div title=\"云服务中心\" data-options=\"border:false\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t\t<li>菜单</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>");
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
}
