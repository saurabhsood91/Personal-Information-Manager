package ui;

import javax.swing.*;
import java.awt.event.*;
import java.util.regex.*;
import service.contacts;

public class addcontacts extends JFrame implements ActionListener {

    private int uid;
    private JLabel lblname,lblhphone,lblwphone,lblmobno,lblemail;
    private JTextField txtname,txthphone,txtwphone,txtmobno,txtemail;
    private JButton buttonsubmit;

    public addcontacts(int uid){
        this.uid=uid;
        lblname=new JLabel("Name");
        lblhphone=new JLabel("Home Phone");
        lblwphone=new JLabel("Work Phone");
        lblmobno=new JLabel("Mobile Number");
        lblemail=new JLabel("Email Address");

        txtname=new JTextField(30);
        txthphone=new JTextField(10);
        txtwphone=new JTextField(10);
        txtmobno=new JTextField(10);
        txtemail=new JTextField(40);

        buttonsubmit=new JButton("Add Contact");
        buttonsubmit.addActionListener(this);
        JPanel panel=new JPanel();
        panel.add(lblname);
        panel.add(txtname);
        panel.add(lblwphone);
        panel.add(txtwphone);
        panel.add(lblhphone);
        panel.add(txthphone);
        panel.add(lblmobno);
        panel.add(txtmobno);
        panel.add(lblemail);
        panel.add(txtemail);
        panel.add(buttonsubmit);
        this.add(panel);
        this.pack();
        this.setTitle("Add a Contact");
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(validation()){
            contacts cn=new contacts(uid,txtname.getText(),Long.parseLong(txtwphone.getText()),Long.parseLong(txthphone.getText())
                    ,Long.parseLong(txtmobno.getText()),txtemail.getText());
            int res=cn.insertdb();
             if(res==1){
                JOptionPane.showMessageDialog(this, "Contact Added","PIM",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "Failed to Add Contact","PIM",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public boolean validation(){
        Pattern p1=Pattern.compile("[A-Za-z ]+");
        Matcher m1=p1.matcher(txtname.getText());
        boolean val1=m1.matches();

        Pattern p2=Pattern.compile("[0-9]{10}");
        Matcher m2=p2.matcher(txtwphone.getText());
        boolean val2=m2.matches();

        Pattern p3=Pattern.compile("[0-9]{10}");
        Matcher m3=p3.matcher(txthphone.getText());
        boolean val3=m3.matches();

        Pattern p4=Pattern.compile("[0-9]{10}");
        Matcher m4=p4.matcher(txtmobno.getText());
        boolean val4=m4.matches();

        Pattern p5=Pattern.compile("[A-Za-z0-9._%+-]{1,}@[A-Za-z0-9.-]+\\.[a-z]{2,4}");
        Matcher m5=p5.matcher(txtemail.getText());
        boolean val5=m5.matches();

        if(!val1){
            JOptionPane.showMessageDialog(this, "Enter Valid Name","PIM",JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if(!val2){
            JOptionPane.showMessageDialog(this, "Enter Work Phone","PIM",JOptionPane.WARNING_MESSAGE);
            return false;
        }


        if(!val3){
            JOptionPane.showMessageDialog(this, "Enter Valid Home Phone","PIM",JOptionPane.WARNING_MESSAGE);
            return false;
        }


        if(!val4){
            JOptionPane.showMessageDialog(this, "Enter Valid Mobile Number","PIM",JOptionPane.WARNING_MESSAGE);
            return false;
        }


        if(!val5){
            JOptionPane.showMessageDialog(this, "Enter Valid Email Address","PIM",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

}
