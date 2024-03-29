package RegisterDatabase;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Loginin extends JApplet implements ActionListener {

	JButton btsubmit ,btclose;
	JTextField txuser;
	JPasswordField txpass;
	
	
	public void init()
	{
		btsubmit = new JButton("Submit");
		btclose = new JButton("Close");
		txuser = new JTextField(20);
		txpass = new JPasswordField(20);
		
		setLayout(new GridLayout(3,2));
		add(new JLabel("Username"));
		add(txuser);
		add(new JLabel("Password"));
		add(txpass);
		
		add(btsubmit);
		add(btclose);
		
		btsubmit.addActionListener(this);
		btclose.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		
		if(src == btsubmit)
		{
			String username = txuser.getText();
			String password = txuser.getText();
			
			try {
					
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
					Statement stmt = con.createStatement();
					stmt.executeUpdate("create database if not exists RegisterDb");
					stmt.execute("Use RegisterDb");
					stmt.executeUpdate("create table if not exists  Worktb( emailid varchar(100),user varchar(100),pass varchar(100),phone varchar(100), dob date ,gender varchar(100),language varchar(100),img longblob)");
					
					PreparedStatement pre = con.prepareStatement("select count(*) from Worktb where user=? and pass=?");

					pre.setString(1, txuser.getText());
					pre.setString(2, txpass.getText());
					
					ResultSet rs = pre.executeQuery();
						
					rs.next();
					int c = rs.getInt(1);
						if(c==1) 
							JOptionPane.showMessageDialog(null, "Correct Pass", "Login Successfull", JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, "Wrong Pass!","Login Failed!!",JOptionPane.ERROR_MESSAGE);
					 
							
						
						con.close();
					} catch (ClassNotFoundException ae) {
						// TODO Auto-generated catch block
						ae.printStackTrace();
					} catch (SQLException ae) {
						// TODO Auto-generated catch block
						ae.printStackTrace();
					}

		}
		else if(src == btclose)
		{
			System.exit(-1);
		}
	}
}
