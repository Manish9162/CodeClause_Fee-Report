package FeeReportManagement;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewAccountant extends JFrame
{
  String x[]={"Name","Password","Email","Contact","Address"};
  JButton bt;
  String y[][]=new String[20][5];
  int i=0,j=0;
  JTable t;
  Font f;
  
  ViewAccountant()
  {
      super("Customer Information");
      setLocation(1,1);
      setSize(800,400);
      
      f=new Font("MS UI Gothic",Font.BOLD,15);
      
      try
        {
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FeeReport","root","vyshu");
          Statement stm=con.createStatement();
          String q="select * from accountant";
          ResultSet rest=stm.executeQuery(q);
          while(rest.next())
          {
              y[i][j++]=rest.getString("Name");
              y[i][j++]=rest.getString("Password");
              y[i][j++]=rest.getString("Email");
              y[i][j++]=rest.getString("Contact");
              y[i][j++]=rest.getString("Address");
              i++;
              j=0;
          }
          t=new JTable(y,x);
          t.setFont(f);
        }
      catch(Exception ex)
      {
       ex.printStackTrace();
      }
      JScrollPane sp=new JScrollPane(t);
      add(sp);
  }
  public static void main(String[] args)
  {
      new ViewAccountant().setVisible(true);
  }
   
}
