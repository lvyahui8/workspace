import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

class  HelloServlet extends HttpServlet
{
	public void service(HttpServletRequest req,
		HttpServletResponse resp)
		 throws ServletException,java.io.IOException
	{
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<font size='30' color='red'>lvyahui</font><br>");
		out.println("<marquee>"+new java.util.Date() + "</marquee>");
		out.println("</html>");
	}
}
