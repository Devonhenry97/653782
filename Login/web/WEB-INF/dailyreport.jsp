<%-- 
    Document   : dailyreport.jps
    Created on : 22-Nov-2018, 15:18:28
    Author     : devon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><jsp:include page="header.jsp"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DAILY REPORT</title>
        <h1>DAILY REPORT</h1>
    </head>
    <body>
        <%=(String)(request.getAttribute("query"))%>
        <jsp:include page="foot.jsp"/>
    </body>
   
</html>
   