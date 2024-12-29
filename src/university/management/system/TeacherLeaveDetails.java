package university.management.system;

import java.awt.Choice;
import java.awt.Color;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TeacherLeaveDetails extends JFrame implements ActionListener{
	
	Choice cempid;
	JTable table;
	JButton search,print,cancel;
	
	TeacherLeaveDetails(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Search by Employee Id");
		heading.setBounds(20,20,150,20);
		add(heading);
		
		cempid = new Choice();
		cempid.setBounds(180,20,150,20);
		add(cempid);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from  teacherleave");
			while(rs.next()) {
				cempid.add(rs.getString("empid"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		table = new JTable();
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from  teacherleave");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0,100,900,600);
		add(jsp);
		
		search = new JButton("Search");
		search.setBounds(20,70,80,20);
		search.addActionListener(this);
		add(search);
		
		print = new JButton("print");
		print.setBounds(120,70,80,20);
		print.addActionListener(this);
		add(print);
	
		cancel = new JButton("Cancel");
		cancel.setBounds(220,70,80,20);
		cancel.addActionListener(this);
		add(cancel);
		
		setSize(900,700);
		setLocation(300,100);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == search) {
			String query = "select * from teacherleave where empid ='"+cempid.getSelectedItem()+"'";
			
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == print) {
			try {
				table.print();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             new TeacherLeaveDetails();
	}

}
