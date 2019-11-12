<%-- 
    Document   : index
    Created on : 20 sept. 2019, 09:31:27
    Author     : Mathilde Kerdiles and Emilie Tavernier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css" media="screen">
    </head>
    <body>
        
        <p>${errKey}</p>
        
        <form  name ='myform' action='Controller' method='post'>
            <table id="login_form">
                <tr>
                    <th>Login</th>
                </tr>
                <tr>
                    <td><input class="normalSizeInput" type='text' name='loginField' placeholder='Username'></td>
                </tr>
                <tr>
                    <td><input class="normalSizeInput" type='password' name='pwdField' placeholder='Password'></td>
                </tr>
                <tr>
                    <td><input type='submit' name='submitAction' value='Login'></td>      
                </tr>
            </table>
        </form>


    </body>
</html>
