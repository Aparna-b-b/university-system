package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
      
	About(){
		
		setSize(700,500);
		setLocation(400,150);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading = new JLabel("<html>University<br/>Management System</html>");
    	heading.setBounds(70,20,300,130);
    	heading.setFont(new Font("Tohona",Font.BOLD,30));
    	add(heading);
    	
    	ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("WhatsApp Image 2024-09-11 at 11.30.27 AM.jpeg"));
		Image i2 =i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
		ImageIcon i3 =new ImageIcon(i2);
		JLabel image =new JLabel(i3);
		image.setBounds(350,0,300,200);
		add(image);
    	
		JLabel name = new JLabel("Developed By:Aparna B B");
    	name.setBounds(70,220,500,40);
    	name.setFont(new Font("Tohona",Font.BOLD,30));
    	add(name);
    	
    	JLabel usn = new JLabel("USN:4SU22CS012");
    	usn.setBounds(70,280,550,40);
    	usn.setFont(new Font("Tohona",Font.PLAIN,30));
    	add(usn);
    	
    	JLabel contact = new JLabel("Contact:aparnabbaparnabb@gmail.com");
    	contact.setBounds(70,340,550,40);
    	contact.setFont(new Font("Tohona",Font.PLAIN,20));
    	add(contact);
    	
		setLayout(null);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new About();
	}

}
