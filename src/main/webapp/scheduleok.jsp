<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dao.DBConnect, java.sql.*, dao.*" %>
    <jsp:useBean id="db" class="dao.DBConnect" scope="page"/>
    <jsp:useBean id="bDto" class="attendance.dto.DBto" scope="page" />
    <jsp:setProperty name="bDto" property="*"/>
    <%
    String id = request.getParameter("id");
    String title = request.getParameter("title");
    String name = request.getParameter("name");
    String week = request.getParameter("week");
    String code = request.getParameter("code");
    String sc = request.getParameter("sc");
 
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2 class="text-center mb-5 mt-3"></h2>
        <div class="box-1">
        </div>
    </div>
</body>
</html>