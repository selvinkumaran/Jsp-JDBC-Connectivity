<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html lang="en">
    <meta charset="UTF-8">
    <title>Register</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <body>
     <h1>Register</h1>
      <form action="register" method="post">
      <label for="email"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="email" required><br><br>
      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" required><br><br>
<label for="Confirm-password"><b>Confirm Password</b></label>
      <input type="password" placeholder="Enter Confirm Password" name="Confirm-password" required><br><br>
      <button type="submit">Register</button>

  </form>
    </body>
    </html>

