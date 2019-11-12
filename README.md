# TAVERNIER_KERDILES-JEE_Project

Link to our Github Repository : https://github.com/Armalyca/TAVERNIER_KERDILES-JEE_Project

The IDE used was Netbeans.

Launch instructions :

Version 1 :
1 - Import the project on your IDE
2 - Create a Java DB named JEEPRJ with username 'jee' and password 'jee'.
3 - You may check in /WEB-INF/db.properties file that dbUrl hold the valid path to JEEPRJ database
4 - Run /WEB-INF/EmployeesSQL.sql and /WEB-INF/CredentialsSQL.sql scripts on your database to create
    and populate new EMPLOYEES and CREDENTIALS table
     -> If the tables EMPLOYEES and CREDENTIALS don't exist in your database, 
  	please comment the "DROP TABLE" statements before running the script 
  	("DROP TABLE IF EXISTS" wasn't supported by our version of SQL)  
5 - The project should be ready to build and run
6 - You can login with 'admin' 'admin', or 'empl' 'empl' Credentials on the opened webpage


Version 2 :
1 - Import The project on your IDE
2 - Create a MySQL database named JEEPRJ on phpMyAdmin (you may want to use WampServer or XAMPP)
    -> username 'jee' and password 'jee'
3 - Create a new connection to  on your database on your IDE
4 - Run /WEB-INF/EmployeesSQL.sql and /WEB-INF/UsersSQL.sql scripts on your database to create
    and populate new EMPLOYEES and CREDENTIALS table
5 - The project should be ready to build and run
6 - You can login with 'admin' 'admin', or 'empl' 'empl' Credentials on the opened webpage

_________________________________

About the version 3 :
We couldn't finish it with the RESTful Web Services. But we were able to use the Sonarqube and to link it to our project (via netbeans but also via the website and the terminal). To use Sonarqube we have to be careful to instal a maven plugin and changin the pom file according to what we need.
