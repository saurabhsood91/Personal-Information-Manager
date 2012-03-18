package ui;
import javax.swing.*;
import java.awt.event.*;

public class mainpage extends JFrame implements ActionListener{

    private JButton addContact;
    private JButton viewcon;
    private JButton addNotes;
    private JButton viewNotes;
    private JButton addTask;
    private JButton viewTask;
    private JButton viewcontacts;
    JPanel mainpanel=new JPanel();
    private int uid;
    public mainpage(int uid)
    {
        this.uid=uid;
        this.setTitle("Personal Information Manager");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addContact=new JButton("Add a Contact");
        addContact.addActionListener(this);
        addContact.addActionListener(this);
        viewcon=new JButton("View Contacts");
        addNotes=new JButton("Add a Note");
        addNotes.addActionListener(this);
        viewNotes=new JButton("View Notes");
        viewNotes.addActionListener(this);
        addTask=new JButton("Add a Task");
        addTask.addActionListener(this);
        viewTask=new JButton("View Tasks");
        viewTask.addActionListener(this);
        viewcon.addActionListener(this);
        mainpanel.add(addContact);
        mainpanel.add(viewcon);
        mainpanel.add(viewNotes);
        mainpanel.add(addNotes);
        mainpanel.add(viewNotes);
        mainpanel.add(addTask);
        mainpanel.add(viewTask);
        this.add(mainpanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addContact){
            addcontacts ac=new addcontacts(uid);
        }

 else if(e.getSource()==viewcon){
             viewcontacts vc=new viewcontacts(uid);
 }
 else if(e.getSource()==addNotes){
     addnote an=new addnote(uid);
     
 }
         else if(e.getSource()==viewNotes){
         viewnotes vn=new viewnotes(uid);
 }
         else if(e.getSource()==addTask){
          addtasks at=new addtasks(uid);
 }
         else if(e.getSource()==viewTask){
         viewtasks vt=new viewtasks(uid);
 }

    }

}
