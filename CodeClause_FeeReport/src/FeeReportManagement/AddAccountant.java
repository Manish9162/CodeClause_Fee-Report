package FeeReportManagement;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddAccountant extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField tf1,tf2,tf3,tf4;
    JPasswordField pf;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f,f1;
    AddAccountant()
    {
       super("Accountant Section");
        setLocation(100,100);
        setSize(900,400);
        
        l1=new JLabel("Add Accountant");
        l2=new JLabel("Name");
        l3=new JLabel("Password");
        l4=new JLabel("Email");
        l5=new JLabel("Contact");
        l6=new JLabel("Address");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.BLUE);
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        
        pf=new JPasswordField();
        
        bt1=new JButton("Add Accountant");
        bt2=new JButton("Back");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        
        f=new Font("Arial",Font.BOLD,20);
        f1=new Font("Arial",Font.BOLD,15);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        bt1.setFont(f1);
        bt2.setFont(f1);
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        pf.setFont(f1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(6,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(pf);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(bt1);
        p2.add(bt2);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
             String Name=tf1.getText();
             String Password=pf.getText();
             String Email=tf2.getText();
             String Contact=tf3.getText();
             String Address=tf4.getText();
     
            try
            {
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FeeReport","root","vyshu");
                 Statement stm=con.createStatement();
                 String q="insert into accountant(Name,Password,Email,Contact,Address) value('"+Name+"','"+Password+"','"+Email+"','"+Contact+"','"+Address+"')";
                 int a=stm.executeUpdate(q);
                 if(a==1)
                 {
                    JOptionPane.showMessageDialog(null, "your data is successfully Inserted");
                    this.setVisible(false);
                 }
                 else
                 {
                    JOptionPane.showMessageDialog(null, "your data is successfully Inserted");
                    this.setVisible(true);
                 }
            }
              catch(Exception ee)
              {
                 ee.printStackTrace();
              }
        }
        if(e.getSource()==bt2)
                {
                   new AdminSection().setVisible(true);
                   this.setVisible(false);
                }
     
    }
    public static void main(String[] args)
    {
        new AddAccountant().setVisible(true);
    }
}

