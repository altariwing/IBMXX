//package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class HelloGet
 */
public class HelloGet extends HttpServlet {
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");  
    String[] Waifu = req.getParameterValues("Waifu");
    res.setContentType("text/html; charset=Big5");
    PrintWriter out = res.getWriter();
       
    out.println("<HTML>");
    out.println("<HEAD><TITLE>HelloGet</TITLE></HEAD>");
    out.println("<BODY>");   
    
  if (Waifu==null) {
			 out.println("你怎麼可以什麼都不選??每個人都該有老婆"); 
	}		  
	else {
		int size=Waifu.length;
		String[] Waifu2 = Waifu;
		for (int wcount=0;wcount<size;wcount++) 
				  { 
			 		   Waifu2[wcount]=new String(Waifu[wcount].getBytes("ISO-8859-1"),"Big5"); 
				  } 
		if (size==1){
    		out.println(Waifu2[0]+"我老婆!!"); 
    		}
		else{
					out.println("跟你介紹我的老婆們:<BR>"); 
					for (int i=0;i<size;i++) 
				  { 
			 		   out.println(Waifu2[i]+"<BR>"); 
				  } 
				
				} 
		out.println("<TABLE></TABLE>");		
	}
out.println("<BR><BR><BR><form>");
out.println("<input type='Button' value='上一頁' onclick='history.back()'>");
out.println("</form>");
    out.println("</BODY></HTML>");		
	}

	

}
