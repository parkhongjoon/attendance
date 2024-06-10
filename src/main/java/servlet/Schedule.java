package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnect;

/**
 * Servlet implementation class Schedule
 */
@WebServlet("/schedule")
public class Schedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection conn = null;
	DBConnect db = new DBConnect();
       

    public Schedule() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");	
        request.setCharacterEncoding("utf-8");
        String sc = "schedule";
        PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String week = request.getParameter("week");
		String code = request.getParameter("code");
		
		System.out.println(sc);
	}

}
