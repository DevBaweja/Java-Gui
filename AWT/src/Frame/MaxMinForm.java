package Frame;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaxMinForm  extends Dialog implements ActionListener{
	
	Label lbfirstnumber,lbsecondnumber,lbthirdnumber,lbresult;
	TextField txfirstnumber,txsecondnumber,txthirdnumber,txresult;
	Button btmax,btmin;
	Button btrefresh,btclose;
	
	public MaxMinForm(Frame F)
	{
		super(F);
		setVisible(true);
		setSize(500, 500);
		super.setBackground(Color.pink); // absolute background color

		lbfirstnumber = new Label("First Number");
		lbsecondnumber = new Label("Second Number");
		lbthirdnumber = new Label("Third Number");
		lbresult = new Label("Result");

		
		txfirstnumber = new TextField(20);
		txsecondnumber = new TextField(20);
		txthirdnumber = new TextField(20);
		txresult = new TextField(20);
		txresult.setEnabled(false);
		
		
		btmax = new Button("Max");
		btmin = new Button("Min");
		
		btrefresh = new Button("Refresh");
		btclose = new Button("Close");
	
		
style();

print();


	btmax.addActionListener(this);
	btmin.addActionListener(this);
	btrefresh.addActionListener(this);
	btclose.addActionListener(this);
		

	}
	
	public void style()
	{
		
		// Background Color
		lbfirstnumber.setBackground(Color.cyan);
		lbsecondnumber.setBackground(Color.gray);
		lbthirdnumber.setBackground(Color.green);
		lbresult.setBackground(Color.blue);
	
		txfirstnumber.setBackground(Color.lightGray);
		txsecondnumber.setBackground(Color.lightGray);
		txthirdnumber.setBackground(Color.lightGray);
		txresult.setBackground(Color.lightGray);
		
		btmax.setBackground(Color.magenta);
		btmin.setBackground(Color.magenta);
		btclose.setBackground(Color.red);
		
		// Font
		Font f1 = new Font("comic sans",Font.ITALIC,30);
		super.setFont(f1);
		/* lbfirstnumber.setFont(f1);
		lbsecondnumber.setFont(f1);
		lbthirdnumber.setFont(f1);
		
		btmax.setFont(f1);
		btmin.setFont(f1);
		btrefresh.setFont(f1);
		btclose.setFont(f1); */
		
		// Foreground color
		
		Color c1 = new Color(200,210,75);
		lbfirstnumber.setForeground(c1);
		lbsecondnumber.setForeground(c1);
		lbthirdnumber.setForeground(c1);
	}
	
	public void print()
	{
		
		GridLayout g = new GridLayout(5,4,50,50);
		super.setLayout(g);
		
		add(lbfirstnumber);
		add(new Label());
		add(txfirstnumber);
		add(new Label());
		
		add(lbsecondnumber);
		add(new Label());
		add(txsecondnumber);
		add(new Label());
		
		add(lbthirdnumber);
		add(new Label());
		add(txthirdnumber);
		add(new Label());
		
		add(lbresult);
		add(new Label());
		add(txresult);
		add(new Label());
		
		add(btmax);
		add(btmin);
		
		add(btrefresh);
		add(btclose);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object src = e.getSource();
		

		
		if(src == btmax)
		{
			int a = Integer.parseInt(txfirstnumber.getText());
			int b = Integer.parseInt(txsecondnumber.getText());
			int c = Integer.parseInt(txthirdnumber.getText());
			if(a>b && a>c)
				txresult.setText(Integer.toString(a));
			else if(b>c)
				txresult.setText(Integer.toString(b));
			else 
				txresult.setText(Integer.toString(c));
		}
		else
		if(src == btmin)
		{
			int a = Integer.parseInt(txfirstnumber.getText());
			int b = Integer.parseInt(txsecondnumber.getText());
			int c = Integer.parseInt(txthirdnumber.getText());
			if(a<b && a<c)
				txresult.setText(Integer.toString(a));
			else if(b<c)
				txresult.setText(Integer.toString(b));
			else 
				txresult.setText(Integer.toString(c));
		}
		else
		if(src == btrefresh)
		{
			int a = Integer.parseInt(txfirstnumber.getText());
			int b = Integer.parseInt(txsecondnumber.getText());
			int c = Integer.parseInt(txthirdnumber.getText());
			txfirstnumber.setText("");
			txsecondnumber.setText("");
			txthirdnumber.setText("");
			txresult.setText("");
		}
		else
		{
			System.exit(-1);
		}
		
		
	}
	
}
