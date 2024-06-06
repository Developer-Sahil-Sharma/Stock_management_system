import java.sql.*;
import java.util.EventObject;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class history extends JFrame implements ActionListener {
JComboBox t1;
JTextField tt;
JLabel t2,t3,t4,t5,t6,t7;
	JLabel k;
	JButton btn,btn1;
	private JPanel contentPane;
	public  history()
	{
setSize(1370,800);
		
		
		contentPane = new JPanel() {  
	        public void paintComponent(Graphics g) {  
	             Image img = Toolkit.getDefaultToolkit().getImage(  
	                       login.class.getResource("hiss.jpg"));  
	             g.drawImage(img, 0, 0, 1940, 990, this);  
	             
	        }  
	   };
	   setContentPane(contentPane);  
	    setVisible(true);
		
		setLayout(null);
			
		k=new JLabel("Dispatch :");
		k.setBounds(400,150,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));
	    k.setForeground(Color.WHITE);
		k=new JLabel("Order ID :");
		k.setBounds(400,200,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));
	    k.setForeground(Color.WHITE);
		k=new JLabel("Customer ID :");
		k.setBounds(400,250,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));
	    k.setForeground(Color.WHITE);
		k=new JLabel("Item ID :");
		k.setBounds(400,300,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));
	    k.setForeground(Color.WHITE);
		k=new JLabel("Dispatch Quantity :");
		k.setBounds(400,350,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));
	    k.setForeground(Color.WHITE);
		k=new JLabel("Price :");
		k.setBounds(400,400,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));
	    k.setForeground(Color.WHITE);
		k=new JLabel("Bill :");
		k.setBounds(400,450,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));
	    k.setForeground(Color.WHITE);
		t1=new JComboBox();
		t1.setBounds(600,180,200,25);
		add(t1);
	    t1.setFont(new Font("Book Antiqua",Font.BOLD,18));
	    t1.setBackground(Color.white);
		filldata();
		
		t1.addActionListener(this);
		t2=new JLabel();
		t2.setBounds(600,230,200,25);
		add(t2);
		 t2.setFont(new Font("Book Antiqua",Font.BOLD,15));
		    t2.setBackground(Color.white);
		t3=new JLabel();
		t3.setBounds(600,280,200,25);
		add(t3);
		 t3.setFont(new Font("Book Antiqua",Font.BOLD,15));
		    t3.setBackground(Color.white);
		t4=new JLabel();
		t4.setBounds(600,330,200,25);
		add(t4);
		 t4.setFont(new Font("Book Antiqua",Font.BOLD,15));
		    t4.setBackground(Color.white);
		t5=new JLabel();
		t5.setBounds(600,380,200,25);
		add(t5);
		 t5.setFont(new Font("Book Antiqua",Font.BOLD,15));
		    t5.setBackground(Color.white);
		t6=new JLabel();
		t6.setBounds(600,430,200,25);
		add(t6);
		t6.setFont(new Font("Book Antiqua",Font.BOLD,15));
		t6.setBackground(Color.white);
		t7=new JLabel();
		t7.setBounds(600,480,200,25);
		add(t7);
		 t7.setFont(new Font("Book Antiqua",Font.BOLD,15));
		    t7.setBackground(Color.white);
		    
		    t2.setForeground(Color.WHITE);
		    t3.setForeground(Color.WHITE);
		    t4.setForeground(Color.WHITE);
		    t5.setForeground(Color.WHITE);
		    t6.setForeground(Color.WHITE);
		    t7.setForeground(Color.WHITE);
		    t2.setFont(new Font("Impact",Font.BOLD,20));
		    t3.setFont(new Font("Impact",Font.BOLD,20));
		    t4.setFont(new Font("Impact",Font.BOLD,20));
		    t5.setFont(new Font("Impact",Font.BOLD,20));
		    t6.setFont(new Font("Impact",Font.BOLD,20));
		    t7.setFont(new Font("Impact",Font.BOLD,20));
		    
		    
		    
		btn1=new JButton("Find");
		btn1.setBounds(450,550,100,30);
		add(btn1);
		btn1.addActionListener(this);
	    btn1.setFont(new Font("Georgia",Font.BOLD,15));
	    btn1.setBackground(Color.GREEN);
		btn=new JButton("Close");
		btn.setBounds(600,550,100,30);
		add(btn);
		btn.addActionListener(this);
	    btn.setFont(new Font("Georgia",Font.BOLD,15));
	    btn.setBackground(Color.RED);
		tt=new JTextField("       HISTORY");
		tt.setBounds(380,20,600,70);
		add(tt);
	    tt.setFont(new Font("Georgia",Font.BOLD,50));
	    tt.setBackground(Color.LIGHT_GRAY);
			
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		new  history ();
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
				String sql="select * from history where dispatch=?";
				st=c.prepareStatement(sql);
				st.setString(1, f);
				rs=st.executeQuery();
				rs.next();
				 t2.setText(rs.getString(2));
	                t3.setText(rs.getString(3));
	                t4.setText(rs.getString(4));
	                t5.setText(String.valueOf(rs.getInt(5)));
	                t6.setText(String.valueOf(rs.getInt(6)));
                
                
                int dq=Integer.parseInt(t5.getText());
                int pr=Integer.parseInt(t6.getText());
                int bill=(dq*pr);
     
                t7.setText(String.valueOf(bill));
                              
                
			}
			catch(Exception ex)
			{
				System.out.println("some issue..."+ex.toString());
			}
			
		}
		 if (e.getSource()==btn)
			{
			    this.hide();
			}
		 
	}
	public void filldata()
	{
	Connection c;PreparedStatement st;ResultSet rs;
	
		try
		{
		 Class.forName("oracle.jdbc.OracleDriver");
		 c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		 String sql="select dispatch from history";
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