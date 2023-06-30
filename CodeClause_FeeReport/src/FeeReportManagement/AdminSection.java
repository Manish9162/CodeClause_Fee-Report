package FeeReportManagement;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AdminSection extends JFrame implements ActionListener
{
    JLabel l1;
    JButton bt1,bt2,bt3;
    JPanel p1;
    Font f,f1;
    
 AdminSection()
 {
   super("Admin Section");
        setLocation(100,100);
        setSize(400,200);
        
        l1=new JLabel("Admin Section");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.BLUE);
        
        bt1=new JButton("Add Accountant");
        bt2=new JButton("View Accountant");
        bt3=new JButton("Logout Admin");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        
        f=new Font("Arial",Font.BOLD,20);
        f1=new Font("Arial",Font.BOLD,15);
        
        l1.setFont(f);
        bt1.setFont(f1);
        bt2.setFont(f1);
        bt3.setFont(f1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(4,1,10,10));
        p1.add(l1);
        p1.add(bt1);
        p1.add(bt2);
        p1.add(bt3);
        
        setLayout(new BorderLayout(0,0));
        add(p1,"Center");
 }
 public void actionPerformed(ActionEvent e)
 {
  if(e.getSource()==bt1)
  {
    new AddAccountant().setVisible(true);  
  }
  if(e.getSource()==bt2)
  {
    new ViewAccountant().setVisible(true); 
  }
  if(e.getSource()==bt3)
  {
    this.setVisible(false);
    new Index().setVisible(true);
  }
 }
 public static void main(String[] args)
    {
        new AdminSection().setVisible(true);
    }
}

