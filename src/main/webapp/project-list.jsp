<%@ page import="model.Project" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: pooya
  Date: 2019-02-26
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Project> projects = (ArrayList<Project>) request.getAttribute("projects"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Projects</title>
    <style>
        table {
            text-align: center;
            margin: 0 auto;
        }
        td {
            min-width: 300px;
            margin: 5px 5px 5px 5px;
            text-align: center;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>budget</th>
    </tr>
    <% for(Project project : projects) { %>
        <tr>
            <td><%= project.getId() %></td>
            <td><%= project.getTitle() %></td>
            <td><%= project.getBudget() %></td>
            <td><a href="project/<%=project.getId()%>">link</a></td>
        </tr>
    <% } %>
</table>
</body>
</html>