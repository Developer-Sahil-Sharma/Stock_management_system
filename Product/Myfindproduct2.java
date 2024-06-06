import java.sql.*;
import java.util.EventObject;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Myfindproduct2 extends JFrame implements ActionListener {
JComboBox t1;
	JTextField t2,t3,tt;
	JLabel k;
	JButton btn,btn1,btn2;
    private JPanel contentPane;  

	public  Myfindproduct2 ()
	{
		 setSize(1370,800);
			setBackground(Color.ORANGE);

				
				contentPane = new JPanel() {  
			        public void paintComponent(Graphics g) {  
			             Image img = Toolkit.getDefaultToolkit().getImage(  
			                       login.class.getResource("pro.jpg"));  
			             g.drawImage(img, 0, 0, 1370, 700, this);  
			             
			        }  
			   };
			   setContentPane(contentPane);  
			    setVisible(true);
				
				setLayout(null);	
	
				k=new JLabel("Store ID :");
				k.setBounds(400,150,600,90);
				add(k);
			    k.setFont(new Font("Impact",Font.BOLD,20));

				k=new JLabel("Store Name :");
				k.setBounds(400,200,600,90);
				add(k);
			    k.setFont(new Font("Impact",Font.BOLD,20));

				k=new JLabel("Store Address :");
				k.setBounds(400,250,600,90);
				add(k);
			    k.setFont(new Font("Impact",Font.BOLD,20));

			    t1=new JComboBox();
				t1.setBounds(600,180,200,25);
				add(t1);
			    t1.setFont(new Font("Book Antiqua",Font.BOLD,18));
			    t1.setBackground(Color.white);
				filldata();
				
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
		    btn1=new JButton("Find");
		    btn1.setBounds(620,380,100,22);
		    add(btn1);
		    btn1.addActionListener(this);
		    btn1.setFont(new Font("Georgia",Font.BOLD,15));
		    btn1.setBackground(Color.GREEN);
		    btn=new JButton("Close");
		    btn.setBounds(700,420,100,22);
		    add(btn);
		    btn.addActionListener(this);
		    btn.setFont(new Font("Georgia",Font.BOLD,15));
		    btn.setBackground(Color.RED);
		    btn2=new JButton("Clear");
		    btn2.setBounds(760,380,100,22);
		    add(btn2);
		    btn2.addActionListener(this);
		    btn2.setFont(new Font("Georgia",Font.BOLD,15));
		    btn2.setBackground(Color.GREEN);
			tt=new JTextField("       Find PRODUCT ");
			tt.setBounds(380,20,600,70);
			add(tt);
		    tt.setFont(new Font("Georgia",Font.BOLD,50));
		    tt.setBackground(Color.LIGHT_GRAY);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		new  Myfindproduct2 ();
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
				String sql="select * from product2 where proid=?";
				st=c.prepareStatement(sql);
				st.setString(1, f);
				rs=st.executeQuery();
				rs.next();
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(3));
                
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
		 
		
		
		if (e.getSource()==btn2)
		{
			t2.setText("");
			t3.setText("");
			
		}
	}
	public void filldata()
	{
	Connection c;PreparedStatement st;ResultSet rs;
	
		try
		{
		 Class.forName("oracle.jdbc.OracleDriver");
		 c= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		 String sql="select proid from product2";
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
