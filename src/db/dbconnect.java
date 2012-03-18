package db;
import java.sql.*;

public class dbconnect {
    public String query;

    public dbconnect(String query)
    {
        this.query=query;
    }
    public ResultSet exquery()
    {
        ResultSet res=null;
        System.out.println("In db exquery"+query);
        try
        {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/pim";
            String dbusername="postgres";
            String dbpasswd="doggierules";
            Connection conn=DriverManager.getConnection(url,dbusername,dbpasswd);
            Statement st=conn.createStatement();
            System.out.println("Created");
            res=st.executeQuery(query);

        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }

        catch(ClassNotFoundException e)
        {
        }

        return res;
    }

    public int insquery()
    {
        int res=0;
        try
        {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/pim";
            String dbusername="postgres";
            String dbpasswd="doggierules";
            Connection conn=DriverManager.getConnection(url,dbusername,dbpasswd);
            Statement st=conn.createStatement();
            res=st.executeUpdate(query);
            System.out.println(res);
        }

        catch(SQLException e)
        {
        }

        catch(ClassNotFoundException e)
        {
        }
            return res;
    }

}