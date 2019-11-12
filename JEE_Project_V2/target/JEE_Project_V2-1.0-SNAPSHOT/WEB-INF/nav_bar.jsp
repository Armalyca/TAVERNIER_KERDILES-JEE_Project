<%-- 
    Document   : nav_bar
    Created on : 23 oct. 2019, 11:10:38
    Author     : Mathilde Kerdiles and Emilie Tavernier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NavBar</title>
    </head>
    <body>
        <form action="Controller" method="post">
            <ul>
                <li>
                    <button id="logOut" type="submit" name="submitAction" value="Goodbye">
                        <img src="./ressources/shutdown.png" height="20"/>
                    </button>
                </li>
                <li>                    
                    Hello ${user} !
                    Your session is active.
                </li>
            </ul>
        </form>
    </body>
</html>
