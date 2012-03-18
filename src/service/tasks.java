package service;
import db.*;
import java.sql.*;

public class tasks {
    private String title;
    private String desc;
    private int uid;
    private String time;
    private String date;
    
    public tasks(String title,String desc,int uid,String time,String date)
    {
        this.title=title;
        this.desc=desc;
        this.uid=uid;
        this.time=time;
        this.date=date;
    }
    
    public tasks(int uid){
        this.uid=uid;
    }
    
        public ResultSet getTasks(){
        String query="select * from \"tbltasks\" where uid="+uid+" order by taskdate";
        dbconnect conn=new dbconnect(query);
        ResultSet res=conn.exquery();
        return res;
        }
        
        public int insertdb(){
        String query="insert into \"tbltasks\" (title,description,uid,taskdate,tasktime) values('"+title+"','"+desc+"',"+uid+",'"+date+"','"+time+"')";
        System.out.println(query);
        dbconnect conn=new dbconnect(query);
        int res=conn.insquery();
        return res;
    }
}
