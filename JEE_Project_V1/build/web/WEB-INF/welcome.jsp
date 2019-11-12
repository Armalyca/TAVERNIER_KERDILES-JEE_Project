<%-- 
    Document   : welcome
    Created on : 20 sept. 2019, 10:33:43
    Author     : Mathilde Kerdiles and Emilie Tavernier
--%>

<%@page import="se.m1.model.User"%>
<%@page import="se.m1.model.Employee"%>
<%@page import="se.m1.model.DBActions"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees list</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css" media="screen">
    </head>
    
        <%@include file="/WEB-INF/nav_bar.jsp" %>
        <h1>List of Employees</h1>
        <%     
            ArrayList<Employee> listEmployees = (ArrayList<Employee>) request.getAttribute("employees"); // CHANGE TODO
            
            out.print("<form  name ='employeesForm' action='Controller' method='post'>");
            if( listEmployees.size() == 0 ) { // If there is no employee
                out.print("<p>The company has no employee!</p>");
            }
            else{
                out.print("<table id='customers'>" +
                                "<tr>"+
                                    "<th>Sél</th>"+
                                    "<th>NAME</th>"+
                                    "<th>FIRST NAME</th>"+
                                    "<th>HOME PHONE</th>"+
                                    "<th>MOBILE PHONE</th>"+
                                    "<th>WORK PHONE</th>"+
                                    "<th>ADDRESS</th>"+
                                    "<th>POSTAL CODE</th>"+
                                    "<th>CITY</th>"+
                                    "<th>EMAIL</th>"+
                                "</tr>"
                        );
            }

            for (int i=0; i<listEmployees.size(); i++ ) {
                String checked = "";
                if( i == 0 ) checked = "checked";
                Employee employeeBase = listEmployees.get(i);
                out.println(    "<tr>"+
                                    "<td>"
                                        + "<input type='radio' name='employeeID' value='" 
                                        + employeeBase.getId() + "' " + checked + ">" + 
                                    "</td>"+
                                    "<td>" + employeeBase.getName()       + "</td>" +
                                    "<td>" + employeeBase.getFirst_name() + "</td>" +
                                    "<td>" + employeeBase.getHome_phone() + "</td>" +
                                    "<td>" + employeeBase.getMobi_phone() + "</td>" +
                                    "<td>" + employeeBase.getWork_phone() + "</td>" +
                                    "<td>" + employeeBase.getAddress()    + "</td>" +
                                    "<td>" + employeeBase.getPostal_code()+ "</td>" +
                                    "<td>" + employeeBase.getCity()       + "</td>" +
                                    "<td>" + employeeBase.getEmail()      + "</td>" +
                                "</tr>"
                            );            
            }
            
            out.println("</table>");
                       
            if( listEmployees.size() != 0 && request.getSession().getAttribute("user").equals("admin") ){
                // If there is employee and the user is admin, we display the "Delete" button
                out.println("<input type='submit' name='submitAction' value='Delete'>");
            } 
                
            if( listEmployees.size() != 0 )
                // If there is employee we display the "Details" button
                out.println("<input type='submit' name='submitAction' value='Details'>");
            
            if( request.getSession().getAttribute("user").equals("admin") ){
                // If the user is admin, we display the "Add" button
                out.println("<input type='submit' name='submitAction' value='Add'>");
            } 
            out.println("</form>");

        %>
    
</html>
