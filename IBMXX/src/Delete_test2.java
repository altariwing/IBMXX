//package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileSystems;

/**
 * Servlet implementation class HelloGet
 */
public class Delete_test2 extends HttpServlet {
	
   
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
			 out.println("然而並沒有檔案可刪"); 
	}		  
	else {
		
		
		
		int size=Waifu.length;
		String[] Waifu2 = Waifu;
		for (int wcount=0;wcount<size;wcount++) 
				  { 
			 		   Waifu2[wcount]=new String(Waifu[wcount].getBytes("ISO-8859-1"),"Big5"); 
				  } 
		
					out.println("被刪除的檔案:<BR>"); 
					for (int i=0;i<size;i++) 
				  { 
			 		   out.println(Waifu2[i]+"<BR>"); 
			 		   
			 		   
			 		   Path path = FileSystems.getDefault().getPath("D:/BA104_WebAPP/apache-tomcat-7.0.75/webapps/IBMXX/images_uploaded",Waifu2[i]);

        // delete if exists
        try {
            boolean success = Files.deleteIfExists(path);
            System.out.println("Delete status: " + success);
        } catch (IOException | SecurityException e) {
            System.err.println(e);
        }
			 		   
				  } 
				
				 
		out.println("<TABLE></TABLE>");		
	}
out.println("<BR><BR><BR><form>");
out.println("</form>");
    out.println("</BODY></HTML>");		
	}//end doget

	




}
