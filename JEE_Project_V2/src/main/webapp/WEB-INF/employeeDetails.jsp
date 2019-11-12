<%-- 
    Document   : employeeDetails
    Created on : 22 oct. 2019, 09:43:43
    Author     : Mathilde Kerdiles and Emilie Tavernier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Details</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css" media="screen">
    </head>
    <body>
        <c:import url="/WEB-INF/nav_bar.jsp"/>
               
        <h1>Details of employee: ${employee.firstname} ${employee.name}</h1>
        <form  name ='employeeForm' action='Controller' method="post">
            <table>
                <tr class='displayNone'>
                    <th>ID</th>
                    <td colspan='3'>
                        <input type='text' maxlength="25" name='id' 
                               value='${employee.id}' 
                               ${ sessionScope.user eq 'empl' ? 'disabled' : '' } 
                        >                     
                        <!-- Employees can't update employees' data (disabled text input fields) -->
                    </td>
                </tr>
                <tr>
                    <th>Last name</th>
                    <td colspan='3'>
                        <input type='text' maxlength="25" name='lastname' 
                               value='${employee.name}' required 
                               ${ sessionScope.user eq 'empl' ? 'disabled' : '' } 
                        >
                    </td>
                </tr>
                <tr>
                    <th>First name</th>
                    <td colspan='3'>
                        <input type='text' maxlength="25" name='firstname' 
                               value='${employee.firstname}' required 
                               ${ sessionScope.user eq 'empl' ? 'disabled' : '' } 
                        >
                    </td>
                </tr>
                <tr>
                    <th>Home phone</th>
                    <td colspan='3'>
                        <input type='text' maxlength="10" name='homephone' 
                               value='${employee.telhome}' required 
                               ${ sessionScope.user eq 'empl' ? 'disabled' : '' } 
                        >
                    </td>
                </tr>
                <tr>
                    <th>Mobile phone</th>
                    <td colspan='3'>
                        <input type='text' maxlength="10" name='mobiphone' 
                               value='${employee.telmob}' required 
                               ${ sessionScope.user eq 'empl' ? 'disabled' : '' } 
                        >
                    </td>
                </tr>
                <tr>
                    <th>Work phone</th>
                    <td colspan='3'>
                        <input type='text' maxlength="10" name='workphone' 
                               value='${employee.telpro}' required 
                               ${ sessionScope.user eq 'empl' ? 'disabled' : '' } 
                        >
                    </td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td colspan='3'>
                        <input type='text' maxlength="150" name='address' 
                               value='${employee.adress}' required 
                               ${ sessionScope.user eq 'empl' ? 'disabled' : '' } 
                        >
                    </td>
                </tr>
                <tr>
                    <th>Zip code</th>
                    <td colspan='3'>
                        <input type='text' maxlength="5" name='zipcode' 
                               value='${employee.postalcode}' required 
                               ${ sessionScope.user eq 'empl' ? 'disabled' : '' } 
                        >
                    </td>
                </tr>
                <tr>
                    <th>City</th>
                    <td colspan='1'>
                        <input class='shortInput' type='text' maxlength="25" name='city' 
                               value='${employee.city}' required 
                               ${ sessionScope.user eq 'empl' ? 'disabled' : '' } 
                        >
                    </td>
                    <th>e-mail</th>
                    <td colspan='1'>
                        <input class='shortInput' type='text' maxlength="64" name='email' 
                               value='${employee.email}' required 
                               ${ sessionScope.user eq 'empl' ? 'disabled' : '' } 
                        >
                    </td>
                </tr>
            </table>
            ${ sessionScope.user eq "admin" ? "<input type='submit' name='submitAction' value='Save'>" : "" } 
            <input type='submit' name='submitAction' value='Cancel' formnovalidate>
        </form>
    </body>
</html>
