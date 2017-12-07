

<%@page import="encriptacion.Hash"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrando...</title>
    </head>
    <%
        String ID = request.getParameter("ID");
        String PASS = request.getParameter("ID2");
        Hash hs = new Hash();
        if(ID!=null&&PASS!=null){
            PASS = hs.sha1(request.getParameter("ID2"));
    %>
    <body>
        <form id="llevar" method="POST" action="ValidaAcceso">
            <input type="hidden" value="<%=ID%>" name="ID">
            <input type="hidden" value="<%=PASS%>" name="ID2">
        </form>
        <script>
        var go = document.getElementById('llevar');
        go.submit();
        </script>
    </body>
    <%
        }else{
            response.sendRedirect("http://localhost:8084/SASME");
        }
    %>
</html>
