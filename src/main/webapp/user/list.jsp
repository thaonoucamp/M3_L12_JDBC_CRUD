<%--
  Created by IntelliJ IDEA.
  User: thaodangxuan
  Date: 02/07/2021 sau CN
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>USER-MANAGEMENT-APPLICATION</title>
</head>
<body>
<center>
    <h1>USER-MANAGEMENT</h1>
    <h2>
        <a href="/UserServlet?action=create">ADD-NEW-USER</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption>LIST-OF-USERS</caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.address}"/></td>
                <td>
                    <a href="/UserServlet?action=edit&id=${user.id}">Edit</a>
                    <a href="/UserServlet?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
