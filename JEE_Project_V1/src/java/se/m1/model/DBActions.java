package se.m1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class managing all actions on database
 * @author Mathilde Kerdiles and Emilie Tavernier
 */
public class DBActions {
    boolean test = false;
    Connection conn;
    PreparedStatement pStmt;
    ResultSet rs;
    User userBean;
    ArrayList<User> listUsers;
    Employee employeeBean;

    /**
     * Connection to database
     * @param dbUrl The location of database
     * @param dbUser The user name
     * @param dbPwd The password
     * @throws SQLException
     */
    public DBActions(String dbUrl, String dbUser, String dbPwd) throws SQLException {
        conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
    }
    
    /**
     * Get the result set of a query
     * @param query 
     * @return the result set
     * @throws SQLException
     */
    public ResultSet getResultSet( String query ) throws SQLException {
        pStmt = conn.prepareStatement(query);
        rs = pStmt.executeQuery();
        return rs;
    }

    /**
     * Get the list of all users in Credentials table
     * @return the list of users
     * @throws SQLException
     */
    public ArrayList<User> getUsers() throws SQLException {
        listUsers = new ArrayList<>();
        rs = getResultSet( "SELECT * from CREDENTIALS" );
        while (rs.next()) {
            userBean = new User();
            userBean.setLogin(rs.getString("LOGIN"));
            userBean.setPwd(rs.getString("PWD"));

            listUsers.add(userBean);
        }

        return listUsers;
    }
    
    /**
     * Check if input credentials are valid
     * @param userInput
     * @return true if userInput credentials are found in database (valid), false otherwise 
     * @throws SQLException
     */
    public boolean checkCredentials(User userInput) throws SQLException {
        test = false;
        listUsers = getUsers();

        for (User userBase : listUsers) {
            if (userBase.getLogin().equals(userInput.getLogin())
                    && userBase.getPwd().equals(userInput.getPwd())) {
                test = true;
            }
        }
        return test;
    }
    
    /**
     * Get the list of all employees
     * @return the list of employees
     * @throws SQLException
     */
    public ArrayList<Employee> getEmployees() throws SQLException {
        ArrayList<Employee> listEmployees = new ArrayList<>();
        rs = getResultSet( "SELECT * from EMPLOYEES" );

        while (rs.next()) {
            employeeBean = fillEmployeeInstance();
            listEmployees.add(employeeBean);
        }
        return listEmployees;
    }
    
    /**
     * Get an employee by its ID
     * @param id
     * @return the employee if found, null otherwise
     * @throws SQLException
     */
    public Employee getEmployeeById(String id) throws SQLException {
        pStmt = conn.prepareStatement("SELECT * from EMPLOYEES where id = ?");
        pStmt.setString(1, id);
        rs = pStmt.executeQuery();

        while (rs.next()) {
            employeeBean = fillEmployeeInstance();
            return employeeBean;
        }
        return null;
    }
    
    /**
     * Fill an employee bean with corresponding values in database
     * @return the employee bean
     * @throws SQLException
     */
    public Employee fillEmployeeInstance() throws SQLException{
        employeeBean = new Employee();

        employeeBean.setId         (rs.getString("ID"         ));
        employeeBean.setName       (rs.getString("NAME"       ));
        employeeBean.setFirst_name (rs.getString("FIRSTNAME"  ));
        employeeBean.setHome_phone (rs.getString("TELHOME"    ));
        employeeBean.setMobi_phone (rs.getString("TELMOB"     ));
        employeeBean.setWork_phone (rs.getString("TELPRO"     ));
        employeeBean.setAddress    (rs.getString("ADRESS"     ));
        employeeBean.setPostal_code(rs.getString("POSTALCODE" ));
        employeeBean.setCity       (rs.getString("CITY"       ));
        employeeBean.setEmail      (rs.getString("EMAIL"      ));

        return employeeBean;
    }
    
    /**
     * Delete an employee by ID
     * @param id
     * @throws SQLException
     */
    public void deleteEmployee(String id) throws SQLException {
        pStmt = conn.prepareStatement("DELETE from EMPLOYEES where id = ?");
        pStmt.setString(1, id);
        pStmt.executeUpdate();
    }

    /**
     * Add and employee to the database
     * @param employee
     * @throws SQLException
     */
    public void addEmployee( Employee employee ) throws SQLException {
        pStmt = conn.prepareStatement("INSERT into EMPLOYEES " + 
                    "(NAME, FIRSTNAME, TELHOME, TELMOB, TELPRO, ADRESS, POSTALCODE, CITY, EMAIL) " +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pStmt.setString(1, employee.getName());
        pStmt.setString(2, employee.getFirst_name());
        pStmt.setString(3, employee.getHome_phone());
        pStmt.setString(4, employee.getMobi_phone());
        pStmt.setString(5, employee.getWork_phone());
        pStmt.setString(6, employee.getAddress());
        pStmt.setString(7, employee.getPostal_code());
        pStmt.setString(8, employee.getCity());
        pStmt.setString(9, employee.getEmail());
        
        pStmt.executeUpdate();           
    }
    
    /**
     * Update existing an employee in database
     * @param employee
     * @throws SQLException
     */
    public void updateEmployee( Employee employee ) throws SQLException {
        pStmt = conn.prepareStatement("UPDATE EMPLOYEES " + 
                    "SET NAME = ?, FIRSTNAME = ?, TELHOME = ?, TELMOB = ?, TELPRO = ?, " +
                    "ADRESS = ?, POSTALCODE = ?, CITY = ?, EMAIL = ? WHERE ID = ?");
        pStmt.setString(1, employee.getName());
        pStmt.setString(2, employee.getFirst_name());
        pStmt.setString(3, employee.getHome_phone());
        pStmt.setString(4, employee.getMobi_phone());
        pStmt.setString(5, employee.getWork_phone());
        pStmt.setString(6, employee.getAddress());
        pStmt.setString(7, employee.getPostal_code());
        pStmt.setString(8, employee.getCity());
        pStmt.setString(9, employee.getEmail());
        pStmt.setString(10, employee.getId());
        
        pStmt.executeUpdate();
    }
}
