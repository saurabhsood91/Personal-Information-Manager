package ui;

import javax.swing.*;
import java.awt.event.*;
import service.tasks;
import java.sql.*;

public class viewtasks extends JFrame {
        
    private JTable table;
    private int uid;
    
        public viewtasks(int uid){
        this.uid=uid;
        tasks con=new tasks(uid);
        ResultSet res=con.getTasks();
        String cols[]={"ID","Title","Description","Time","Date"};
        Object obj[][]=new Object[20][5];
        int i=0;
        try{
            while(res.next()){
                obj[i]=new Object[5];
                obj[i][0]=res.getInt("id");
                obj[i][1]=res.getString("title");
                obj[i][2]=res.getString("description");
                obj[i][3]=res.getString("taskdate");
                obj[i][4]=res.getString("tasktime");
                i++;
            }
        }
               catch(SQLException e){}

        table=new JTable(obj,cols);
        this.add(table);
        this.setTitle("My Tasks");
        this.pack();
        this.setVisible(true);
    
}
}
