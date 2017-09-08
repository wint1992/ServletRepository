package ru.chuchalin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.chuchalin.files.FileWritter;
import ru.ithex.model.Application;

public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static void main(String ...args){
		Application app = new Application();
		app.setAppTimestamp(new Date());
		System.out.println(app.toString());
		FileWritter file = FileWritter.newReletiveFileWritter("logs", "ApiServlet.log");
		file.write("test");
	}

//	@Override
//	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
//		Application app = new Application();
//		app.setAppTimestamp(new Date());
//		resp.setContentType("text/html");
//		PrintWriter pw = resp.getWriter();
//		FileWritter file = new FileWritter("/opt/tomcat/webapps/myserv/logs/ApiServlet.log");
//		file.write("test");
//		pw.println("<p>" + app.toString() + "</p>");
//		pw.close();
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Application app = new Application();
		app.setAppTimestamp(new Date());
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		FileWritter file = new FileWritter("/opt/tomcat/webapps/myserv/logs/ApiServlet.log");
		file.write("GET");
		pw.println("<p>" + app.toString() + "</p>");
		pw.println("<p>GET</p>");
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Application app = new Application();
		app.setAppTimestamp(new Date());
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		FileWritter file = new FileWritter("/opt/tomcat/webapps/myserv/logs/ApiServlet.log");
		file.write("POST\n" + req.getParameter("login"));
		pw.println("<p>" + app.toString() + "</p>");
		pw.println("<p>POST</p>");
		pw.close();
	}
}
