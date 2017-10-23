

import java.io.*;
import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



@WebServlet("Delete_test.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
// ��ƾڶq�j��fileSizeThreshold�ȮɡA���e�N�Q�g�J�Ϻ�
// �W�ǹL�{���L�׬O��Ӥ��W�LmaxFileSize�ȡA�Ϊ̤W�Ǫ��`�q�j��maxRequestSize �ȳ��|�ߥXIllegalStateException ���`
// maxFileSize = (5MB) �]�o���קK���A�w�гQ���z
public class Delete_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String saveDirectory = "/images_uploaded"; // �W���ɮת��ئa�ؿ�;
											   // �N�ѩ��U����27~31��� java.io.File �� ContextPath ���U, �۰ʫإߥئa�ؿ�

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
				
				
		int meow =0;
		req.setCharacterEncoding("Big5"); // �B�z�����ɦW
		res.setContentType("text/html; charset=Big5");
		PrintWriter out = res.getWriter();
		System.out.println("ContentType="+req.getContentType()); // ���ե�

		String realPath = getServletContext().getRealPath(saveDirectory);
		System.out.println("realPath="+realPath); // ���ե�
		File fsaveDirectory = new File(realPath);
		if (!fsaveDirectory.exists())
			 fsaveDirectory.mkdirs(); // �� ContextPath ���U,�۰ʫإߥئa�ؿ�

		Collection<Part> parts = req.getParts(); // Servlet3.0�s�W�FPart�����A���ڭ̤�K���i���ɮפW�ǳB�z
		out.write("<h2> Total parts : " + parts.size() + "</h2>");

//write here	
ArrayList<String> fileList = new ArrayList<>();

		for (Part part : parts) {
			if (getFileNameFromPart(part) != null && part.getContentType()!=null) {
				out.println("<PRE>");
				String name = part.getName();
				String filename = getFileNameFromPart(part);
				String ContentType = part.getContentType();
				long size = part.getSize();
				File f = new File(fsaveDirectory, filename);
				meow++;
				out.println("name: " + name);
				out.println("filename: " + filename);
				out.println("ContentType: " + ContentType);
				out.println("size: " + size);
				out.println("File: " + f);

//write here
fileList.add(filename);
				// �Q��File����,�g�J�ئa�ؿ�,�W�Ǧ��\
				part.write(f.toString());

				// �B�~���� InputStream �P byte[] (���N��model��VO�w�@�ǳ�)
				InputStream in = part.getInputStream();
				byte[] buf = new byte[in.available()];
				in.read(buf);
				in.close();
				out.println("buffer length: " + buf.length);
				
				// �B�~���ըq��
				out.println("<br><img src=\""+req.getContextPath()+saveDirectory+"/"+filename+"\">");

				out.println();
				out.println("</PRE>");
			}
		}

out.println("<br><br>�n�R������?<br>");
out.println("<form method='get' action='Delete_test2'>");


		
for(int countfile=0;countfile<meow;countfile++){
	
	out.println("<input type='checkbox' name='Waifu' value='"+fileList.get(countfile)+"'>"+fileList.get(countfile)+ "<br>");

	}		
		
		
out.println("<input type ='submit' value='���U�h'/>");	
out.println("</form>");		
		
	}//end doPost

	// ���X�W�Ǫ��ɮצW�� (�]��API������method,�ҥH�����ۦ漶�g)
	public String getFileNameFromPart(Part part) {
		String header = part.getHeader("content-disposition");
		System.out.println("header=" + header); // ���ե�
		String filename = new File(header.substring(header.lastIndexOf("=") + 2, header.length() - 1)).getName();
		System.out.println("filename=" + filename); // ���ե�
		if (filename.length() == 0) {
			return null;
		}
		return filename;
	}
}