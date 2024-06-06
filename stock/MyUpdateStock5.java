import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class MyUpdateStock5 extends JFrame implements ActionListener {

	JLabel k;
	JComboBox t1;
    JTextField tt,t2,t3,t4,t5,t6,t7;
    JButton btn,btn1,btn2;
    private JPanel contentPane; 
MyUpdateStock5()
	{
	 setSize(1370,800);
		
		
		contentPane = new JPanel() {  
	        public void paintComponent(Graphics g) {  
	             Image img = Toolkit.getDefaultToolkit().getImage(  
	                       login.class.getResource("stokkk.jpg"));  
	             g.drawImage(img, 0, 0, 1940, 990, this);  
	             
	        }  
	   };
	   setContentPane(contentPane);  
	    setVisible(true);
		
		setLayout(null);


		k=new JLabel("Stock ID :" );
		k.setBounds(400,150,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));

		k=new JLabel("Item ID:");
		k.setBounds(400,200,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));

		k=new JLabel("Product category :");
		k.setBounds(400,250,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));

		k=new JLabel("Supplier ID:");
		k.setBounds(400,300,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));

		k=new JLabel("Date :");
		k.setBounds(400,350,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));

		k=new JLabel("Quantity :");
		k.setBounds(400,400,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));

	
	   

		t1=new JComboBox();
		t1.setBounds(600,180,200,25);
		add(t1);
		filldata();
	    t1.setFont(new Font("Book Antiqua",Font.BOLD,18));
	    t1.setBackground(Color.white);
		
		t1.addActionListener(this);
		t2=new JTextField();
		t2.setBounds(600,230,200,25);
		add(t2);
		 t2.setFont(new Font("Book Antiqua",Font.BOLD,15));
		    t2.setBackground(Color.white);
		t3=new JTextField();
		t3.setBounds(600,280,200,25);
		add(t3);
		 t3.setFont(new Font("Book Antiqua",Font.BOLD,15));
		    t3.setBackground(Color.white);
		t4=new JTextField();
		t4.setBounds(600,330,200,25);
		add(t4);
		 t4.setFont(new Font("Book Antiqua",Font.BOLD,15));
		    t4.setBackground(Color.white);
		t5=new JTextField();
		t5.setBounds(600,380,200,25);
		add(t5);
		 t5.setFont(new Font("Book Antiqua",Font.BOLD,15));
		    t5.setBackground(Color.white);
		t6=new JTextField();
		t6.setBounds(600,430,200,25);
		add(t6);
		t6.setFont(new Font("Book Antiqua",Font.BOLD,15));
		t6.setBackground(Color.white);
		
			
			
		btn1=new JButton("Find");
		btn1.setBounds(450,500,100,30);
		add(btn1);
		btn1.addActionListener(this);
	    btn1.setFont(new Font("Georgia",Font.BOLD,15));
	    btn1.setBackground(Color.GREEN);
		btn=new JButton("Close");
		btn.setBounds(530,550,100,30);
		add(btn);
		btn.addActionListener(this);
	    btn.setFont(new Font("Georgia",Font.BOLD,15));
	    btn.setBackground(Color.RED);
	    btn2=new JButton("Update");
	    btn2.setBounds(600,500,100,30);
	    add(btn2);
	    btn2.addActionListener(this);
	    btn2.setFont(new Font("Georgia",Font.BOLD,15));
	    btn2.setBackground(Color.GREEN);
		tt=new JTextField("       Update Stock");
		tt.setBounds(380,20,600,70);
		add(tt);
	    tt.setFont(new Font("Georgia",Font.BOLD,50));
	    tt.setBackground(Color.LIGHT_GRAY);
		
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyUpdateStock5();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn1)
		{
			String f=t1.getSelectedItem().toString();
			Connection c; PreparedStatement st; ResultSet rs;
			try
			{
				Class.forName("oracle.jdbc.OracleDriver");
				c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String sql="select * from stock5 where stockid=?";
				st=c.prepareStatement(sql);
				st.setString(1, f);
				rs=st.executeQuery();
				rs.next();
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(3));
                t4.setText(rs.getString(4));
                t5.setText(rs.getString(5));
                t6.setText(rs.getString(6));
                
			}
			catch(Exception ex)
			{
				System.out.println("some issue..."+ex.toString());
			}
			
		}
		if (e.getSource()==btn)
		this.hide();

		if(e.getSource()==btn2)
		{
			String f=t1.getSelectedItem().toString();

			String b1=t2.getText();
			String c1=t3.getText();
			String d1=t4.getText();
			String e1=t5.getText();
			String f1=t6.getText();
			if ( b1.length()==0 || c1.length()==0 || d1.length()==0 ||e1.length()==0 || f1.length()==0 )
			{
				JOptionPane.showMessageDialog(this, "Check All...");
			}
			
			else
			{
			Connection c;PreparedStatement st;ResultSet rs;
			try
			{
				Class.forName("oracle.jdbc.OracleDriver");
		    	c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		    	String sql="update stock5 set itmid=?,procat=?,suppid=?,dates=?,quantity=? where stockid=?";
		    	st=c.prepareStatement(sql);
		    	st.setString(1, b1);
				st.setString(2, c1);
				st.setString(3, d1);              
				st.setString(4, e1);
				st.setString(5, f1);
				st.setString(6, f);
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record Updated");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				c.close();
				
			}
			catch(Exception ex)
			{
				System.out.println("some issue..."+ex.toString());
				
			}
			}
		}
		}

		public void filldata()
		{
		Connection c;PreparedStatement st;ResultSet rs;

			try
			{
			 Class.forName("oracle.jdbc.OracleDriver");
			 c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			 String sql="select stockid from stock5";
			 st=c.prepareStatement(sql);
			 rs=st.executeQuery();
			 while(rs.next())
			 {
				 t1.addItem(rs.getString(1)); 
			 }
			
			}
			catch(Exception ex)
			{
				System.out.println(ex.toString());
			}
		
	}
		
		
		
		

}
