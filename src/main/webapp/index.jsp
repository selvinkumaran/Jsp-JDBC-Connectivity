<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html lang="en">
    <meta charset="UTF-8">
    <title>Login</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <body>
     <h1>Login</h1>
      <form action="login" method="post">
      <label for="email"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="email" required><br><br>
      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" required>
      <p>Not an user <a href="register.jsp">Register</a></p>
      <%
           if(request.getAttribute("error") != null){
                out.print("<p>Invalid Credential</p>");
              }
           %>
      <button type="submit">Login</button>
  </form>
    </body>
    </html>

