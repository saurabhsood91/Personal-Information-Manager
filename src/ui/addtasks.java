package ui;

import javax.swing.*;
import java.awt.event.*;
import service.tasks;

public class addtasks extends JFrame implements ActionListener {
    private int uid;
    private JLabel lbltitle;
    private JLabel lbldesc;
    private JLabel lbltime;
    private JLabel lbldate;
    private JTextField txttitle;
    private JTextField txtdesc;
    private JTextField txttime;
    private JTextField txtdate;
    private JButton submit;
    public addtasks(int uid)
    {
        this.uid=uid;
        lbltitle=new JLabel("Title");
        lbldesc=new JLabel("Description");
        lbltime=new JLabel("Time");
        lbldate=new JLabel("Date");
        txttitle=new JTextField(20);
        txtdesc=new JTextField(20);
        txttime=new JTextField(20);
        txtdate=new JTextField(20);
        submit=new JButton("Add Task");
        JPanel panel=new JPanel();
        panel.add(lbltitle);
        panel.add(txttitle);
        panel.add(lbldesc);
        panel.add(txtdesc);
        panel.add(lbltime);
        panel.add(txttime);
        panel.add(lbldate);
        panel.add(txtdate);
        panel.add(submit);
        submit.addActionListener(this);
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(validation())
        {
            tasks tsk=new tasks(txttitle.getText(),txtdesc.getText(),uid,txttime.getText(),txtdate.getText());
            int res=tsk.insertdb();
            if(res==1){
                JOptionPane.showMessageDialog(this, "Task Added","PIM",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "Failed to Add Task","PIM",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean validation(){
                if(txttitle.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Title Cannot be Empty", "PIM",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(txtdesc.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Description Cannot be Empty","PIM",JOptionPane.ERROR_MESSAGE);
            return false;
        }
           if(txttime.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Enter Valid Time","PIM",JOptionPane.ERROR_MESSAGE);
            return false;
        }
                        if(txtdate.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Enter Valid Date","PIM",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
}
