import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Retrieve extends HttpServlet 
{
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
     {  
         response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	try {
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gitam", "root", ""); // gets a new connection
	      Statement stmt = c.createStatement();
              ResultSet rs = stmt.executeQuery("select first,last,email,uid,mobile from reg");              
              out.println("<table border = '1'>");
              out.println("<tr><td>First Name</td><td>Last Name</td><td>Email ID</td><td>User ID</td><td>Mobile No</td></tr>");
              while (rs.next()) 
              {
                out.println("<tr><td>"+rs.getString("first")+"</td><td>"+rs.getString("last")+"</td><td>"+rs.getString("email")+"</td><td>"+rs.getString("uid")+"</td><td>"+rs.getString("mobile")+"</td></tr>");
			
              }
              out.println("</table>");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}