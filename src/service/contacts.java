package service;

import java.sql.*;
import db.dbconnect;

public class contacts {

    private int uid;
    private String name;
    private long hphone;
    private long wphone;
    private long mobno;
    private String email;

    public contacts(int uid,String name,long hphone,long wphone,long mobno,String email){
        this.uid=uid;
        this.name=name;
        this.hphone=hphone;
        this.wphone=wphone;
        this.mobno=mobno;
        this.email=email;
    }

    public contacts(int uid){
        this.uid=uid;
    }

    public int insertdb(){
        String query="insert into \"tblContacts\"(name,homephone,workphone,mobileno,email,uid) values('"+
                name+"',"+hphone+","+wphone+","+mobno+",'"+email+"',"+uid+")";
        System.out.println(query);
        dbconnect conn=new dbconnect(query);
        int res=conn.insquery();
        return res;
    }
    
        public ResultSet getContacts(){
        String query="select * from \"tblContacts\" where uid="+uid;
        System.err.println(query);
        dbconnect conn=new dbconnect(query);
        ResultSet res=conn.exquery();
        return res;
    }

}
