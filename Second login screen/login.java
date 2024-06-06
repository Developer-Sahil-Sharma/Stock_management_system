import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class login extends JFrame implements ActionListener {

	JLabel k,k1;
	Connection con;PreparedStatement st;ResultSet rs;
    JTextField u;
    JPasswordField p;
    JButton btn,bt;
    private JPanel contentPane;  
    login()
	{
	setSize(1350,800);
	setLayout(null);
	
	
	
	 contentPane = new JPanel() {  
         public void paintComponent(Graphics g) {  
              Image img = Toolkit.getDefaultToolkit().getImage(  
                        login.class.getResource("ssss.png"));  
              g.drawImage(img,  0, 0, 1350, 800, this);  
         }  
    }; 
    
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
    contentPane.setLayout(new BorderLayout(10, 10));  
    setContentPane(contentPane);  
    setVisible(true);
	
	
   
    u= new JTextField();
    u.setBounds(830, 295, 360, 80);
    u.setFont(new Font("Arial",Font.BOLD,40));
    add(u);
    u.setOpaque(false);
    u.setBackground(Color.getColor(getName()));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
    contentPane.setLayout(new BorderLayout(10, 10));
    
    p= new JPasswordField();
    p.setBounds(830, 387,360, 80);
    add(p);
    p.setOpaque(false);
    p.setBackground(Color.getColor(getName()));
    p.setFont(new Font("Arial",Font.BOLD,40));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
    contentPane.setLayout(new BorderLayout(10, 10));


    btn=new JButton("Close");
	btn.setBounds(855, 570, 300, 40);
	add(btn);
	btn.addActionListener(this);
    btn.setBackground(Color.orange);
    btn.setFont(new Font("Arial",Font.BOLD,30));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
    contentPane.setLayout(new BorderLayout(10, 10));

	
	bt=new JButton("Login");
	bt.setBounds(830 ,500 , 350,50);
	add(bt);
	bt.addActionListener(this);
    bt.setBackground(Color.green);
    bt.setFont(new Font("Arial",Font.BOLD,40));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
    contentPane.setLayout(new BorderLayout(10, 10));


	
	
	
	 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
	    contentPane.setLayout(new BorderLayout(10, 10));  
	    setContentPane(contentPane);  
	    setVisible(true);
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	}
	
	public static void main(String[] args) {
		new login();
		
		  EventQueue.invokeLater(new Runnable() {  
              public void run() {  
                   try {  
//                        hiii frame = new hiii();  
//                        frame.setVisible(true);  
                   } catch (Exception e) {  
//                        e.printStackTrace();  
                   }  
              }  
         }); 
		  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btn)
		this.hide();

		if (e.getSource()==bt)
		{
			try
			{
			 Class.forName("oracle.jdbc.OracleDriver");
			 con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			 String sql="select * from users where loginid=? and passwords=?";
			 st=con.prepareStatement(sql);
			 st.setString(1, u.getText());
			 st.setString(2, p.getText());
			 rs=st.executeQuery();
			 if (rs.next())
			 {
				 new Stockmanagement();
			 }
			 else
			 {
				 JOptionPane.showMessageDialog(this, "Record Not Found..");
			 }
			
			}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}
		
	}
		
	
		}

	

}
