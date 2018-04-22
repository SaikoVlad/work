<%--
  Created by IntelliJ IDEA.
  User: prostrmk
  Date: 04/02/18
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>


    <br><br>
    <div align="center">
        <form method="POST" action='<%= response.encodeURL("submit") %>' >
            <table border="0" cellspacing="5">
                <tr>
                    <th align="right">Username:</th>
                    <td align="left"><input type="text" name="username"></td>
                </tr>
                <tr>
                    <th align="right">Password:</th>
                    <td align="left"><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td align="right"><input type="submit" value="Controller.jdbc.Log In"></td>
                    <td align="left"><input type="reset"></td>
                </tr>
                <button type="button"><a href="registration.jsp">Registration</a></button>
            </table>
        </form>
    </div>

</body>
</html>
