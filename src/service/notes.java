package service;

import java.sql.*;
import db.*;

public class notes {

    private String title;
    private String desc;
    private int uid;
    public notes(String title,String desc,int uid){
        this.title=title;
        this.desc=desc;
        this.uid=uid;
    }

    public notes(int uid){
        this.uid=uid;
    }

    public int insertdb(){
        String query="insert into \"tblNotes\" (title,description,uid) values('"+title+"','"+desc+","+uid+"')";
        dbconnect conn=new dbconnect(query);
        int res=conn.insquery();
        return res;
    }

    public ResultSet getNotes(){
        String query="select id,title,description from \"tblNotes\" where uid="+uid;
        dbconnect conn=new dbconnect(query);
        ResultSet res=conn.exquery();
        return res;
    }

}
