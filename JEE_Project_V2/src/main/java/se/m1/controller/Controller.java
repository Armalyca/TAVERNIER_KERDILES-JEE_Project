/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.m1.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se.m1.model.Credentials;
import se.m1.model.CredentialsSB;
import se.m1.model.Employees;
import se.m1.model.EmployeesSB;
import se.m1.utils.Constants;

/**
 * Controller of our application
 * @author Mathilde Kerdiles and Emilie Tavernier
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    @EJB
    private CredentialsSB credentialsSB;
    @EJB
    private EmployeesSB employeesSB;
    
    String submitAction;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // MANAGE THE DATA FlOW
        // SubmitAction indicates which input submit button was last press in the .jsp files (= where we come from)
        submitAction = request.getParameter("submitAction");

        if( request.getParameterMap().isEmpty() || submitAction.equals("BackHome") ){ 
            // If we are connected (session "user" attributes not null ), redirect to WelcomePage
            if ( request.getSession().getAttribute("user") != null ){
                try {
                    request.setAttribute("employees", employeesSB.getEmployees());
                    request.getRequestDispatcher(Constants.WELCOMEPAGE_PATH).forward(request, response);
                } catch (Exception ex) {
                    request.setAttribute("errorSource", Constants.EX_EMPLOYEES);
                    request.setAttribute("exceptionMsg", ex.getMessage());
                    request.getRequestDispatcher(Constants.ERROR_PATH).forward(request, response);
                }
            }
            // Else -> first time we arrived on the home page : no parameters posted
            // Or last user disconnected and close the last session
            else {
                request.getRequestDispatcher(Constants.HOMEPAGE_PATH).forward(request, response);
            }
        }
        else if( request.getSession().getAttribute("user") == null ){
            // If no user connected redirect to error page
            request.setAttribute( "errorSource", Constants.ACCESS_VIOLATION );
            request.setAttribute( "exceptionMsg", Constants.CONN_SUGGESTION );
            request.getRequestDispatcher(Constants.ERROR_PATH).forward(request, response);
        }
        else if( submitAction.equals("Details") ){
            try {
                // Find the selected employee by ID.
                request.setAttribute("employee", employeesSB.getEmployeeByID( request.getParameter("employeeID") ));
                request.getRequestDispatcher(Constants.EMPLOYEEPAGE_PATH).forward(request, response);
            } catch ( Exception ex ) {
                request.setAttribute("errorSource", Constants.EX_EMPLOYEE);
                request.setAttribute("exceptionMsg", ex.getMessage());
                request.getRequestDispatcher(Constants.ERROR_PATH).forward(request, response);
            }
        }      
        else if( submitAction.equals("Delete") ){
            // First we check that the current user as the right to do so
            if( !request.getSession().getAttribute("user").equals("admin") ){
                request.setAttribute("errorSource", Constants.RIGHT_VIOLATION);
                request.setAttribute("exceptionMsg", Constants.SUGGESTION);
                request.getRequestDispatcher(Constants.ERROR_PATH).forward(request, response);
            }
            try {
                // Delete the employee by ID
                employeesSB.deleteEmployee( request.getParameter("employeeID") );
                request.setAttribute("employees", employeesSB.getEmployees());
                request.getRequestDispatcher(Constants.WELCOMEPAGE_PATH).forward(request, response);
            } catch ( Exception ex ) {
                request.setAttribute("errorSource", Constants.EX_DELETE);
                request.setAttribute("exceptionMsg", ex.getMessage());
                request.getRequestDispatcher(Constants.ERROR_PATH).forward(request, response);
            }
        }
        else if( submitAction.equals("Add") ){
            // First we check that the current user as the right to do so
            if( !request.getSession().getAttribute("user").equals("admin") ){
                request.setAttribute("errorSource", Constants.RIGHT_VIOLATION);
                request.setAttribute("exceptionMsg", Constants.SUGGESTION);
                request.getRequestDispatcher(Constants.ERROR_PATH).forward(request, response);
            }
            // Create an empty employee bean and open its details page (with all input text fields empty)
            Employees newEmployee = new Employees();
            request.setAttribute("employee", newEmployee);
            request.getRequestDispatcher(Constants.EMPLOYEEPAGE_PATH).forward(request, response);
        }
        else if ( submitAction.equals("Goodbye") ){
            // Get the current session
            HttpSession session = request.getSession();
            // Store the user name in request parameter (login used in goodbye message)
            request.setAttribute("user", session.getAttribute("user"));
            // Close the session
            session.invalidate();
            request.getRequestDispatcher(Constants.GOODBYE_PATH).forward(request, response);
        }    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // MANAGE THE DATA FlOW
        // SubmitAction indicates which input submit button was last press in the .jsp files (= where we come from)
        submitAction = request.getParameter("submitAction");
        
        if( submitAction.equals("Login")  ){
            //We store in Credantial Bean the credentials entered by the user
            Credentials creds = new Credentials();

            creds.setLogin(request.getParameter("loginField"));
            creds.setPwd(request.getParameter("pwdField"));

            if ( creds.getLogin().equals("") ||
                    creds.getPwd().equals("") ){
                // Empty input field generate an error message ("" is the default value for credentials) 
                request.setAttribute("errKey", Constants.ERR_MSG_EMPY_FIELD);
                request.getRequestDispatcher(Constants.HOMEPAGE_PATH).forward(request, response);
            }
            else try {
                if ( credentialsSB.isValid( creds ) ) { // Valid credentials
                    // Store the user login in session attribute
                    request.getSession().setAttribute("user", creds.getLogin());
                    // Store the list of all employees in database in request attributes
                    request.setAttribute("employees", employeesSB.getEmployees());
                    // And dispatch to the "welcome.jsp" page (which display the list of all employees)
                    request.getRequestDispatcher(Constants.WELCOMEPAGE_PATH).forward(request, response);
                }
                else { // Unvalid credentials
                    request.setAttribute("errKey", Constants.ERR_MSG_INVALID_CRED);
                    request.getRequestDispatcher(Constants.HOMEPAGE_PATH).forward(request, response);
                }
            } catch ( Exception ex  ) {
                request.setAttribute("errorSource", Constants.EX_CREDS);
                request.setAttribute("exceptionMsg", ex.getMessage());
                request.getRequestDispatcher(Constants.ERROR_PATH).forward(request, response);
            }
        }
        else if( request.getSession().getAttribute("user") == null ){
            // If no user connected redirect to error page
            request.setAttribute( "errorSource", Constants.ACCESS_VIOLATION );
            request.setAttribute( "exceptionMsg", Constants.CONN_SUGGESTION );
            request.getRequestDispatcher(Constants.ERROR_PATH).forward(request, response);
        }
        else if( submitAction.equals("Cancel") ){
            try {
                // Go back to welcome.jsp with no modification in database
                request.setAttribute("employees", employeesSB.getEmployees());
            } catch ( Exception ex ) {
                request.setAttribute("errorSource", Constants.EX_EMPLOYEES);
                request.setAttribute("exceptionMsg", ex.getMessage());
                request.getRequestDispatcher(Constants.ERROR_PATH).forward(request, response);
            }
            request.getRequestDispatcher(Constants.WELCOMEPAGE_PATH).forward(request, response);       
        }
        else if( submitAction.equals("Save") ){
            // First we check that the current user as the right to do so
            if( !request.getSession().getAttribute("user").equals("admin") ){
                request.setAttribute("errorSource", Constants.RIGHT_VIOLATION);
                request.setAttribute("exceptionMsg", Constants.SUGGESTION);
                request.getRequestDispatcher(Constants.ERROR_PATH).forward(request, response);
            }
            // Create and employee bean and feed it with the data in request parameters
            Employees employee = new Employees();

            employee.setName( request.getParameter("lastname") );
            employee.setFirstname( request.getParameter("firstname") );
            employee.setTelhome( request.getParameter("homephone") );
            employee.setTelmob( request.getParameter("mobiphone") );
            employee.setTelpro( request.getParameter("workphone") );
            employee.setAdress( request.getParameter("address") );
            employee.setPostalcode( request.getParameter("zipcode") );
            employee.setCity( request.getParameter("city") );
            employee.setEmail( request.getParameter("email") );

            // Update the database
            try {
                if( request.getParameter("id").equals("") ){ 
                        // No ID : we add a new employee to the database
                        employeesSB.add( employee );
                }
                else{
                    employee.setId( Integer.parseInt(request.getParameter("id")) );
                    // Already an ID : we update the employee details in the database
                    employeesSB.update( employee );
                }
            } catch ( Exception ex ) {
                request.setAttribute("errorSource", Constants.EX_SAVE);
                request.setAttribute("exceptionMsg", ex.getMessage());
                request.getRequestDispatcher(Constants.ERROR_PATH).forward(request, response);
            }

            try {
                request.setAttribute("employees", employeesSB.getEmployees());
                request.getRequestDispatcher(Constants.WELCOMEPAGE_PATH).forward(request, response);       
            } catch ( Exception ex ) {
                request.setAttribute("errorSource", Constants.EX_EMPLOYEES);
                request.setAttribute("exceptionMsg", ex.getMessage());
                request.getRequestDispatcher(Constants.ERROR_PATH).forward(request, response);
            }

        }  
        else if (submitAction.equals("Goodbye") ){
            // Get the current session
            HttpSession session = request.getSession();
            // Store the user name in request parameter (login used in goodbye message)
            request.setAttribute("user", session.getAttribute("user"));
            // Close the session
            session.invalidate();
            request.getRequestDispatcher(Constants.GOODBYE_PATH).forward(request, response);
        }  
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
