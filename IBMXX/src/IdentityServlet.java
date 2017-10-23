
import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class IdentityServlet extends HttpServlet {

	/**亂數字元字典*/ 
    public static final char[] CHARS={ '2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z'};

	/** public static Random random */
	public static Random random = new Random();

	/** 六位亂數 */
	public static String getRandomString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}// end getRandomString()

	/** get random color */
	public static Color getRandomColor() {
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}

	/** get reversed color */
	public static Color getReverseColor(Color c) {
		return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("image/jpeg");

		String randomString = getRandomString();// 隨機字串
		request.getSession(true).setAttribute("randomString", randomString);// 放到Session中
		int width = 100;
		int height = 30;

		Color color = getRandomColor();// 隨機顏色(背景)
		Color reverse = getReverseColor(color);// 隨機色的反色(前景)

		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);// 建立一個彩色圖片
		Graphics2D g = bi.createGraphics();
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));// 設定字體
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		g.setColor(reverse);
		g.drawString(randomString, 18, 20);
		for (int i = 0, n = random.nextInt(100); i < n; i++) {
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		} // 隨機100個噪音點

		ServletOutputStream out = response.getOutputStream();
		// 轉JPEG
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		// 編碼器
		encoder.encode(bi);
		out.flush();// 衝出去到用戶端
	}
}
