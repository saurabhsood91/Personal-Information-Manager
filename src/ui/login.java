package ui;

import javax.swing.*;
import static java.lang.System.out;
import java.awt.event.*;
import java.awt.GridLayout;
import service.user;
import java.awt.*;

public class login extends JFrame implements ActionListener
{
    private JTextField txtUname;
    private JPasswordField txtPasswd;
    private JLabel lblUname,lblPasswd;
    private JButton btLogin,btReset,btSignup;
    JPanel logoPanel;
    JPanel loginPanel;
    //Image

    public login()
    {
        super("Login Page");
        txtUname=new JTextField(30);
        txtPasswd=new JPasswordField(20);
        lblUname=new JLabel("Username: ");
        lblPasswd=new JLabel("Password: ");
        btLogin=new JButton("Login");
        btLogin.addActionListener(this);
        btReset=new JButton("Reset");
        btReset.addActionListener(this);
        btSignup=new JButton("Sign Up");
        logoPanel=new JPanel();
        loginPanel=new JPanel();
        logoPanel.add(btSignup);
        JPanel mainpanel=new JPanel();
        GridLayout gridobj=new GridLayout(3,2);
        loginPanel.setLayout(gridobj);

        loginPanel.add(lblUname);
        loginPanel.add(txtUname);
        loginPanel.add(lblPasswd);
        loginPanel.add(txtPasswd);
        loginPanel.add(btLogin);
        loginPanel.add(btReset);

        mainpanel.add(loginPanel);

        //this.add(logoPanel);
        this.add(mainpanel);
        this.setSize(150, 150);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }


    public static void main(String args[])
    {
        new login();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btReset)
        {
            txtUname.setText("");
            txtPasswd.setText("");
        }
        else if(e.getSource()==btLogin)
        {
            user userlogin=new user(txtUname.getText(),txtPasswd.getText());
            boolean res=userlogin.exquery();
            if(res){
                JOptionPane.showMessageDialog(this, "Logged on Successfully");
                new mainpage(userlogin.getuid());
                login.this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Failed to Login");
            }
        }
    }
}