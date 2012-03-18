package ui;
import javax.swing.*;
import java.awt.event.*;
import service.notes;

public class addnote extends JFrame implements ActionListener{
    private JTextField txtTitle;
    private JTextField txtDesc;
    private JButton buttonAdd;
    private int uid;

    public addnote(int uid){
        this.uid=uid;
        txtTitle=new JTextField(20);
        txtDesc=new JTextField(30);
        buttonAdd=new JButton("Add Note");
        JPanel mainpanel=new JPanel();
        mainpanel.add(txtTitle);
        mainpanel.add(txtDesc);
        mainpanel.add(buttonAdd);
        buttonAdd.addActionListener(this);
        this.add(mainpanel);
        this.setTitle("Add a Note");
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonAdd){
            if(validation()){
            notes note=new notes(txtTitle.getText(),txtDesc.getText(),uid);
            
            int res=note.insertdb();
            if(res==1){
                JOptionPane.showMessageDialog(this, "Note Added","PIM",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "Failed to Add Note","PIM",JOptionPane.ERROR_MESSAGE);
            }
            }
        }
      }

    public boolean validation(){
        if(txtTitle.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Title Cannot be Empty", "PIM",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(txtDesc.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Description Cannot be Empty","PIM",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
