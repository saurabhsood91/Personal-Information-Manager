package service;
import db.dbconnect;
import java.sql.*;
public class user
{
    private String username;
    private String password;
    private int uid;

    public user(String username,String password)
    {
        this.username=username;
        this.password=password;
    }

    public boolean exquery()
    {
        String query="select * from \"tblUsers\"";
        dbconnect conn=new dbconnect(query);
        boolean result=false;
        System.out.println("In users exquery");
        ResultSet res=conn.exquery();
        int found=0;
        try{
            while(res.next()){
                String uname=res.getString("username");
                String pass=res.getString("password");
                if(this.username.compareTo(uname)==0 && this.password.compareTo(pass)==0){
                    found=1;
                    this.uid=res.getInt("uid");
                    break;
                }
            }
            if(found==0)
                result=false;
            else result=true;
        }

        catch(SQLException e){
            
        }

        return result;
    }

    public int getuid(){
        return this.uid;
    }

}
