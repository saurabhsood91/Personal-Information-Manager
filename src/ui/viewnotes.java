package ui;

import javax.swing.*;
import java.awt.event.*;
import service.notes;
import java.sql.*;

public class viewnotes extends JFrame {

    private JTable table;
    private int uid;

    public viewnotes(int uid){
        this.uid=uid;
        notes note=new notes(uid);
        ResultSet res=note.getNotes();
        String cols[]={"ID","Title","Description"};
        Object obj[][]=new Object[20][3];
        int i=0;
        try{
            while(res.next()){
                obj[i]=new Object[3];
                obj[i][0]=res.getInt("id");
                obj[i][1]=res.getString("title");
                obj[i][2]=res.getString("description");
                i++;
            }
        }
        catch(SQLException e){}

        table=new JTable(obj,cols);
        this.add(table);
        this.setTitle("My Notes");
        this.pack();
        this.setVisible(true);
    }
}
