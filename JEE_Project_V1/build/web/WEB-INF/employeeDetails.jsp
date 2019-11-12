<%-- 
    Document   : employeeDetails
    Created on : 22 oct. 2019, 09:43:43
    Author     : Mathilde Kerdiles and Emilie Tavernier
--%>

<%@page import="se.m1.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Details</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css" media="screen">
    </head>
    <body>
        <%@include file="/WEB-INF/nav_bar.jsp" %>

        <%
            String disabled = "";
            // If the user is an employee, we shall disabled text input fields (he has no right to update)
            if( request.getSession().getAttribute("user").equals("empl") ){
                disabled = "disabled";
            } 
        %>
        <% Employee employee = (Employee) request.getAttribute("employee"); %>
        
        <h1>Details of employee: <% out.println(employee.getFirst_name()); %> <% out.println(employee.getName()); %></h1>
        <form  name ='employeeForm' action='Controller' method='post'>
            <table>
                <tr class='displayNone'>
                    <th>ID</th>
                    <td colspan='3'>
                        <input type='text' maxlength="25" name='id' 
                               value='<% out.println(employee.getId()); %>' 
                               <% out.println(disabled); %> >
                    </td>
                </tr>
                <tr>
                    <th>Last name</th>
                    <td colspan='3'>
                        <input type='text' maxlength="25" name='lastname' 
                               value='<% out.println(employee.getName()); %>' required 
                               <% out.println(disabled); %> >
                    </td>
                </tr>
                <tr>
                    <th>First name</th>
                    <td colspan='3'>
                        <input type='text' maxlength="25" name='firstname' 
                               value='<% out.println(employee.getFirst_name()); %>' required 
                               <% out.println(disabled); %> >
                    </td>
                </tr>
                <tr>
                    <th>Home phone</th>
                    <td colspan='3'>
                        <input type='text' maxlength="10" name='homephone' 
                               value='<% out.println(employee.getHome_phone()); %>' required 
                               <% out.println(disabled); %> >
                    </td>
                </tr>
                <tr>
                    <th>Mobile phone</th>
                    <td colspan='3'>
                        <input type='text' maxlength="10" name='mobiphone' 
                               value='<% out.println(employee.getMobi_phone()); %>' required 
                               <% out.println(disabled); %> >
                    </td>
                </tr>
                <tr>
                    <th>Work phone</th>
                    <td colspan='3'>
                        <input type='text' maxlength="10" name='workphone' 
                               value='<% out.println(employee.getWork_phone()); %>' required 
                               <% out.println(disabled); %> >
                    </td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td colspan='3'>
                        <input type='text' maxlength="150" name='address' 
                               value='<% out.println(employee.getAddress()); %>' required 
                               <% out.println(disabled); %> >
                    </td>
                </tr>
                <tr>
                    <th>Zip code</th>
                    <td colspan='3'>
                        <input type='text' maxlength="5" name='zipcode' 
                               value='<% out.println(employee.getPostal_code()); %>' required 
                               <% out.println(disabled); %> >
                    </td>
                </tr>
                <tr>
                    <th>City</th>
                    <td colspan='1'>
                        <input class="shortInput" type='text' maxlength="25" name='city' 
                               value='<% out.println(employee.getCity()); %>' required 
                               <% out.println(disabled); %> >
                    </td>
                    <th>e-mail</th>
                    <td colspan='1'>
                        <input class="shortInput" type='text' maxlength="64" name='email' 
                               value='<% out.println(employee.getEmail()); %>' required 
                               <% out.println(disabled); %> >
                    </td>
                </tr>
            </table>
            <%
                // Only admin has the right to save updates
                if( request.getSession().getAttribute("user").equals("admin") ){
                    out.println("<input type='submit' name='submitAction' value='Save'>");
                } 
            %>
            <input type='submit' name='submitAction' value='Cancel' formnovalidate>
        </form>
    </body>
</html>
