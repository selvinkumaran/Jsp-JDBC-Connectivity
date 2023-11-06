Jsp-JDBC-Connectivity
---------------------

Webapp Directory:
----------------
index.jsp: The main entry point of the web application.
login.jsp: The login page for users.
register.jsp: The registration page for new users.
logout.jsp: The page for logging out.

Controller Directory:
--------------------
AuthController: Handles user authentication and login operations.
RegisterController: Manages user registration and account creation.
TodoController: Handles the to-do list functionality.

DAO (Data Access Object) Directory:
----------------------------------
TodoDao: Manages interactions with the database related to the to-do list items.
UserDao: Manages interactions with the database related to user information.
com.kumaran.dao: The package containing the DAO classes.

Controller Overview
--------------------
The AuthController class is designed to process user login requests. Here's an overview of its functionality:

When a user submits their email and password via an HTML form, the doPost method of the AuthController is invoked.

The controller retrieves the user's email and password from the HTTP request parameters.

It calls the loginUser method from the UserDao class to attempt to authenticate the user by checking their credentials in the database.

If the authentication is successful (i.e., the user is found in the database with the provided credentials), the user is considered logged in. Their user ID is stored in a session to maintain their login state.

If authentication fails, an error attribute is set in the request to indicate a failed login attempt. The user is then redirected back to the login page (typically index.jsp) with the error message.

Dependencies
------------
This controller class relies on the following components and dependencies:

UserDao: The UserDao class is responsible for interacting with the database to authenticate users. It provides the loginUser method used by the AuthController for user authentication.

Database Connection: The web application requires a working database connection, which should be configured in the DatabaseConnection class.

Usage
-----
To use the AuthController in your web application, you should consider the following:

Ensure that the UserDao and DatabaseConnection classes are correctly implemented and configured.

Deploy your web application, including the AuthController class, to a servlet container (e.g., Apache Tomcat).

Create HTML pages for user login (e.g., login.jsp) and a landing page (e.g., todo.jsp) for authenticated users.

Configure the form action in your login page to submit user credentials to the AuthController when the user tries to log in.

Customize the error handling and redirection logic as needed based on your web application's requirements.

Implement user registration and logout functionality as required for your application.
