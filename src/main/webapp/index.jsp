<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()  
+":"+request.getServerPort()+path+"/";  
%>  
<html>  
  <body>  
    <%  
    String mypath = "HelloFreeMarkerServlet";  
    response.sendRedirect(basePath + mypath);  
    %>  
  </body>  
</html>  
