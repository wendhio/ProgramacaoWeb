<%-- 
    Document   : response
    Created on : 13/07/2018, 21:05:28
    Author     : wendhio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Response</title>
    </head>
    <body>
        <jsp:useBean id = "mybean" scope= "session" class="pacote.ComissaoBean"/>
        <jsp:setProperty name="mybean" property="*"/>
        <h1>Hello World!<jsp:getProperty name="mybean" property="vendas"/></h1>
    </body>
</html>
