<%-- 
    Document   : welcome
    Created on : 20 sept. 2019, 10:33:43
    Author     : Mathilde Kerdiles and Emilie Tavernier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees list</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css" media="screen">
    </head>
    
        <c:import url="/WEB-INF/nav_bar.jsp"/>
        <h1>List of Employees</h1>
        
        <form  name ='employeesForm' action='Controller' method="get">
            <c:if test="${empty employees}">
                <p>The company has no employee!</p>
            </c:if>

            <c:if test="${not empty employees}">
                <table id='customers'>
                    <tr>
                        <th>Sél</th>
                        <th>NAME</th>
                        <th>FIRST NAME</th>
                        <th>HOME PHONE</th>
                        <th>MOBILE PHONE</th>
                        <th>WORK PHONE</th>
                        <th>ADDRESS</th>
                        <th>POSTAL CODE</th>
                        <th>CITY</th>
                        <th>EMAIL</th>
                    </tr>
                    <c:forEach items="${ employees }" var="employee" varStatus="status"> 
                        <tr>
                            <td>
                                <input type='radio' name='employeeID' value='${employee.id}'  
                                    ${ status.count eq 1 ? 'checked' : '' } >
                                    <!-- We checked by default the radio button of the first employee in the list -->
                            </td>
                            <td>${employee.name}</td>
                            <td>${employee.firstname}</td>
                            <td>${employee.telhome}</td>
                            <td>${employee.telmob}</td>
                            <td>${employee.telpro}</td>
                            <td>${employee.adress}</td>
                            <td>${employee.postalcode}</td>
                            <td>${employee.city}</td>
                            <td>${employee.email}</td>
                        </tr>
                    </c:forEach>
                </table>
                <!-- only admin can see the delete submit button -->
                ${ sessionScope.user eq "admin" ? "<input type='submit' name='submitAction' value='Delete'>" : "" } 
                <input type='submit' name='submitAction' value='Details'>
            </c:if>
                
            <!-- Only admin can see the add submit button -->
            <!-- The add buttonappear even if there is no employee -->
            ${ sessionScope.user eq "admin" ? "<input type='submit' name='submitAction' value='Add'>" : "" } 
        </form>
        
</html>
