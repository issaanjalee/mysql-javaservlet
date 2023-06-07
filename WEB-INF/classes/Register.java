import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class Register extends GenericServlet
{
    public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Register</title>");
        out.println("<style>");
        out.println("body{font-family: cursive;background-color: #f5f5f5}");
        out.println("div{width: 400px;margin: 0px auto;box-shadow: 0px 1px 10px #a8a8a8;background-color: #fff;padding-bottom: 10px;position: absolute;top: 50%;left: 50%;transform: translate(-50%,-50%)}");
        out.println("h1{background-color: #222222;text-align: center;margin-top: 0;padding: 20px;color: #fff}");
        out.println("p{text-align: center;font-size: 20px;color: #6a595b;margin;0}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div>");
       
        Connection con=null;
        Statement stm=null;
        String name=req.getParameter("name");
        int roll=Integer.parseInt(req.getParameter("roll"));
        String email=req.getParameter("email");
        String course=req.getParameter("course");
        String pass=req.getParameter("pass");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:4306/demo","root","");
            String query = "insert into student values('"+name+"',"+roll+",'"+email+"','"+pass+"','"+course+"')";
            stm= con.createStatement();
            int count=stm.executeUpdate(query);
            if(count==0)
                out.println("<h1 style='background-color: #eb1616'>Registration Failed</h1>");
            else{
                out.println("<h1>Registration sucessfull</h1>");
            }
               
        }
        catch(ClassNotFoundException e){
            out.println(e);
        }
        catch(SQLException e){
            out.println(e);
        }
        finally
        {
            try
            {
                stm.close();
                con.close();
            }
            catch(SQLException e){
            out.println(e);
            }
        }
        out.println("<p><a href='register.html'>Back</a></p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        
    }
}