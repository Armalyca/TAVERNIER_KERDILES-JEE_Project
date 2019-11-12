/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.m1.utils;

/**
 * Constants container
 * @author Mathilde Kerdiles and Emilie Tavernier
 */
public class Constants {
    // PATH TO DB.PROPERTIES FILE
    public static final String PROP_FILE_PATH = "/WEB-INF/db.properties";

    // PATHS TO .JSP FILES
    public static final String HOMEPAGE_PATH      = "/WEB-INF/home.jsp";
    public static final String WELCOMEPAGE_PATH   = "/WEB-INF/welcome.jsp";
    public static final String EMPLOYEEPAGE_PATH  = "/WEB-INF/employeeDetails.jsp";
    public static final String GOODBYE_PATH       = "/WEB-INF/goodbye.jsp";
    public static final String ERROR_PATH         = "/WEB-INF/exceptionCaught.jsp";

    // ERROR MESSAGES
    public static final String ERR_MSG_INVALID_CRED = "Connection failed! Verify your login/password and try again";
    public static final String ERR_MSG_EMPY_FIELD = "You must enter value in both field";
    
    // EXCEPTION CAUGHT MESSAGES
    public static final String EX_DBACCESS  =  "An error occured when trying to connect the database";
    public static final String EX_CREDS     = "An error occured when trying to access Credentials table in database";
    public static final String EX_EMPLOYEE  = "An error occured when trying to access Employees table in database";
    public static final String EX_DELETE    = "An error occured when trying to delete an employee in database";
    public static final String EX_SAVE      = "An error occured when trying to add or update an employee in database";
    public static final String EX_EMPLOYEES = "An error occured when trying to select Employees full list in database";

    // ACCESS VIOLATION
    public static final String ACCESS_VIOLATION = "you must connect first.";
    public static final String CONN_SUGGESTION  = "please identify yourself.";
    public static final String RIGHT_VIOLATION  = "you have no right to do this action.";
    public static final String SUGGESTION       = "We suggest you to go back home.";

}
