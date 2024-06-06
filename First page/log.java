import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.sql.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class log extends JFrame implements ActionListener {

	 private JPanel contentPane; 
	JButton t1,t2;
	
	log()
	{
		setSize(1370,800);
		setLayout(null);
		
		
		
	
		
	 contentPane = new JPanel() {  
	         public void paintComponent(Graphics g) {  
	              Image img = Toolkit.getDefaultToolkit().getImage(  
	                        login.class.getResource("screen1.png"));  
	              g.drawImage(img, 0, 0, 1360, 700, this);  
	         }  
	    }; 
	    setContentPane(contentPane);  
	    setVisible(true);
		
	    
	    t1=new JButton("Owner");
	    t1.setBounds(110, 350, 100, 30);
	    add(t1);
	    t1.setBackground(Color.CYAN);
	    t1.setForeground(Color.white);
	    t1.setOpaque(false);
	    t1.addActionListener(this);
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
	    contentPane.setLayout(new BorderLayout(10, 10));
	    t2=new JButton("Worker");
	    t2.setBounds(230, 350, 100, 30);
	    add(t2);
	    t2.setForeground(Color.white);
	    t2.setOpaque(false);
	    t2.setBackground(Color.green);
	    t2.addActionListener(this);
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
	    contentPane.setLayout(new BorderLayout(10, 10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {

		new log();
		
		 EventQueue.invokeLater(new Runnable() {  
             public void run() {  
                  try {  
//                       hiii frame = new hiii();  
//                       frame.setVisible(true);  
                  } catch (Exception e) {  
//                       e.printStackTrace();  
                  }  
             }  
        }); 
		
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==t1)
		{
			new login();
		}
		if (e.getSource()==t2)
		{
			new login2();
		}
		
	}

}
