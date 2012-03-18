package ui;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import service.contacts;

public class viewcontacts extends JFrame {
    
    private JTable table;
    private int uid;
    
        public viewcontacts(int uid){
        this.uid=uid;
        contacts con=new contacts(uid);
        ResultSet res=con.getContacts();
        String cols[]={"ID","Name","Home Phone","Work Phone","Email Address","Mobile Address"};
        Object obj[][]=new Object[20][6];
        int i=0;
        try{
            while(res.next()){
                obj[i]=new Object[6];
                obj[i][0]=res.getInt("id");
                obj[i][1]=res.getString("name");
                obj[i][2]=res.getInt("homephone");
                obj[i][3]=res.getInt("workphone");
                obj[i][4]=res.getString("email");
                //obj[i][5]=res.getInt("mobileno");
                
                i++;
            }
        }
               catch(SQLException e){e.printStackTrace();}

        table=new JTable(obj,cols);
        this.add(table);
        this.setTitle("My Contacts");
        this.pack();
        this.setVisible(true);
    
}
}
