<%-- 
    Document   : exceptionCaught
    Created on : 12 nov. 2019, 09:05:14
    Author     : Mathilde Kerdiles et Emilie Tavernier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Goodbye</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css" media="screen">
    </head>
    <body>
        <h1>An error occurred</h1>
        <form action="Controller" method='post'>
            Sorry,  <% out.println(request.getAttribute("errorSource")); %>
            <br>
            Exception message: <% out.println(request.getAttribute("exceptionMsg")); %>
            <br>
            <button type="submit" name="submitAction" value="BackHome">
                <img src="./ressources/home.png" height="20"/>
            </button>
        </form>
    </body>
</html>
