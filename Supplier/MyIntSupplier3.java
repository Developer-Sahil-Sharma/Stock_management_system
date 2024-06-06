import java.sql.*;
import java.util.Scanner.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyIntSupplier3 extends JFrame implements ActionListener ,FocusListener{

	JLabel k,msg1;
	int x=0;
	 private JPanel contentPane;
	JTextField tt,t1,t2,t3,t4,t5,t6;
	JButton btn,btn1;

	public MyIntSupplier3()
	{
		setSize(1370,800);
		
		
		contentPane = new JPanel() {  
	        public void paintComponent(Graphics g) {  
	             Image img = Toolkit.getDefaultToolkit().getImage(  
	                       login.class.getResource("suplll.jpg"));  
	             g.drawImage(img, 0, 0, 1920, 1050, this);  
	             
	        }  
	   };
	   setContentPane(contentPane);  
	    setVisible(true);
		
		setLayout(null);
		k=new JLabel("Supplier ID :-");
		k.setBounds(400,150,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));

	    msg1=new JLabel("Status.... :-");
		  msg1.setBounds(850, 150, 600, 90);
		  add(msg1);
		    msg1.setFont(new Font("Gerogia",Font.BOLD,20));
		    
		k=new JLabel("Supplier Name :-");
		k.setBounds(400,200,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));

		k=new JLabel("Supplier Address :-");
		k.setBounds(400,250,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));

		k=new JLabel("Supplier City :-");
		k.setBounds(400,300,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));

		k=new JLabel("Supplier Email :-");
		k.setBounds(400,350,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));

	

		k=new JLabel("Item iD  :-");
		k.setBounds(400,400,600,90);
		add(k);
	    k.setFont(new Font("Impact",Font.BOLD,20));

		t1=new JTextField();
		t1.setBounds(600,180,200,25);
		add(t1);
	    t1.setFont(new Font("Book Antiqua",Font.BOLD,18));
	    t1.setBackground(Color.white);
		t1.addFocusListener(this);
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
		
		    btn1=new JButton("Save");
			btn1.setBounds(450,500,100,30);
			add(btn1);
			btn1.addActionListener(this);
		    btn1.setFont(new Font("Georgia",Font.BOLD,15));
		    btn1.setBackground(Color.GREEN);
			btn=new JButton("Close");
			btn.setBounds(600,500,100,30);
			add(btn);
			btn.addActionListener(this);
		    btn.setFont(new Font("Georgia",Font.BOLD,15));
		    btn.setBackground(Color.RED);
		 

		    tt=new JTextField("      Insert SUPPLIER");
		    tt.setBounds(380,20,600,70);
			add(tt);
		    tt.setFont(new Font("Georgia",Font.BOLD,50));
		    tt.setBackground(Color.LIGHT_GRAY);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
	public static void main(String[] args) {
		new MyIntSupplier3();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn1)
		{
		String a1=t1.getText();
		String b1=t2.getText();
		String c1=t3.getText();
		String d1=t4.getText();
		String e1=t5.getText();
		String f1=t6.getText();
		
		if (a1.length()==0 || b1.length()==0 || c1.length()==0 || d1.length()==0 || e1.length()==0|| f1.length()==0 )
		{
			JOptionPane.showMessageDialog(this, "Check All...");
		}
		else
		{


		Connection c;PreparedStatement st;ResultSet rs;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String sql="insert into supplier3 values(?,?,?,?,?,?)";
			
			st=c.prepareStatement(sql);
		
			st.setString(1,a1);
			st.setString(2,b1);

			st.setString(3,c1);

			st.setString(4,d1);
			
			st.setString(5,e1);
			st.setString(6,f1);
			
			int f=st.executeUpdate();
			JOptionPane.showMessageDialog(this, "Record Saved.");
			c.close();
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			
		}
		catch(Exception ex)

		{
			System.out.println("some issue..."+ex.toString());
		}
		}
	}
		if (e.getSource()==btn)
		{
		    this.hide();
		}
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource()==t1)
		{
			
			String a1=t1.getText();
			if (a1.length()==0)
			{
				msg1.setText("Please Enter your Supplier ID ");
				msg1.setForeground(Color.RED);
			
				t1.grabFocus(); // wait 
			}
			else
			{
				msg1.setText("Access Grante");
				msg1.setForeground(Color.GREEN);
				t2.grabFocus();
			
			}
		}							
	}}	
