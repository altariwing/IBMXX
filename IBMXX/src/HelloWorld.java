//package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {
	
	int count=0;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setHeader("Cache-Control","no-store"); //HTTP 1.1
    res.setHeader("Pragma","no-cache");        //HTTP 1.0
    res.setDateHeader ("Expires", 0);

		res.setContentType("text/html; charset=Big5");
		PrintWriter out = res.getWriter();

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<BIG>Hello World , 世界你好 !</BIG>" + (++count));
		out.println("</BODY></HTML>");
		
		
		try{
			int a = 1;
		int b = 1/0;
			}
		catch(ArithmeticException ae) {
			log("你的程式出錯了 錯誤是: ",ae);
			}
			
			
		
	}
}
