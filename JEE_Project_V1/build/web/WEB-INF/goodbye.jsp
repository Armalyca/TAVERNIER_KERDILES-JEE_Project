<%-- 
    Document   : goodbye
    Created on : 23 oct. 2019, 11:20:54
    Author     : Mathilde Kerdiles and Emilie Tavernier
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
        <h1>Goodbye <% out.println(request.getAttribute("user")); %></h1>
        <form action="Controller" method='post'>
            Your session has been closed.
            <button type="submit" name="submitAction" value="BackHome">
                <img src="./ressources/home.png" height="20"/>
            </button>
        </form>
    </body>
</html>
