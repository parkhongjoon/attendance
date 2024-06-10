<%@page import="com.google.protobuf.Parser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="java.util.*, 
attendance.dto.*,
dao.*, java.sql.*" %>
    <%
    HttpSession sess = request.getSession(true);
    String username = (String)sess.getAttribute("name");

    DBConnect db = new DBConnect();
    Connection conn = db.getConnection(); 
    MemberDao dao = new MemberDao(conn);

    String code = "1";
    ArrayList<SCDto> list = dao.schedule(code);
    String id = null;
    String name = null;
    String title = null;
    String time = null;
    String week = null;
    String lecturecode = null;
    
    for(int i=0; i<list.size(); i++){
    	SCDto dto = new SCDto();
    	dto = list.get(i);
    	
    	title = dto.getTitle(); 
    	name = dto.getName(); 
    	time = dto.getTime();
    	week = dto.getWeek();
    	lecturecode = dto.getlecturecode();
    	
    	System.out.println(id+"|"+name+"|"+title+"|"+time+"|"+week+"|"+lecturecode);
    }

    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>출석부</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <form action="scheduleok.jsp">
        <div class="container-schedule">
            <h3 class="text-center mb-5">출석부</h3>
                 <p class="text-right"><%=username %>님<a href="index.jsp"> 로그아웃</a></p>
            <table class="table list-tb">
                <colgroup>
                   <col width="10%">
                   <col width="20%">
                   <col width="20%">
                   <col width="10%">
                   <col width="10%">
                   <col width="10%">
                   <col width="10%">
                   <col width="10%">
                </colgroup>
                <thead class="text-center">       
  <tr>
    <th>번호</th>
    <th>과목</th>
    <th>이름</th>
    <th>시간</th>
    <th>요일</th>
    <th>출석</th>
    <th>결석</th>
    <th>지각</th>
  </tr>
  <%for(int i=0; i<list.size(); i++){
 		SCDto dto = new SCDto();
 		dto = list.get(i);
 		%>
  <tr>
    <td><%=dto.getId() %></td>
    <td><%=dto.getTitle() %></td>
    <td><%=dto.getName() %></td>
    <td><%=dto.getTime() %></td>
    <td><%=dto.getWeek() %></td>
    
   
	<td><input type="radio" name="attendance" value="present"></td>
	<td><input type="radio" name="attendance" value="absent"></td>
	<td><input type="radio" name="attendance" value="late"></td>
    
  </tr>
   <%} %>
      </tbody>
       </table>
    </div>
        <button type="submit" class="btn btn-primary sub">전송</button> 
          <input type="hidden" name="mode" value=""/>
    </form>

    
</body>
</html>