
package ItemListener;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoListAddRemove extends Applet implements ActionListener{

	Label lbitem,lbshop;
	List l1;
	Panel P1,P2,P3,P4;
	Button b1,b2,b3;
	TextField t;
	
	public void init()
	{
		
		lbshop = new Label("Shopping List");
		lbitem = new Label("Items");
		t = new TextField();
		
		l1 = new List();

		l1.add("Butter");
		l1.add("Honey");
		l1.add("Milk");
		l1.add("Water");
		
		b1 = new Button("ADD");
		b2 = new Button("REMOVE");
		b3 = new Button("REMOVE SELECTED ITEM");
		
		
		P1 = new Panel();
		P2 = new Panel();
		P3 = new Panel();
		P4 = new Panel();
				
		print();
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		 
	}

	public void print()
	{
		P1.setLayout(new GridLayout(2,1));
		P1.add(lbshop);
		lbshop.setFont(new Font("comic sans",Font.BOLD,30));
		P1.add(l1);
		
		P2.setLayout(new GridLayout(2,2));
		P2.add(lbitem);
		P2.add(t);
		P2.add(b1);
		P2.add(b2);

		
		P3.setLayout(new GridLayout(2,1));
		P3.add(P2);
		P3.add(b3);
		
		P4.setLayout(new GridLayout(1,2));
		P4.add(P1);
		P4.add(P3);
		setLayout(new BorderLayout());
		add(P4,BorderLayout.CENTER);
		
		
	}
	


	
	public void actionPerformed(ActionEvent e) {
		
		Object src = e.getSource();
		
		if(src == b1)
		{//Add
			if(t.getText().equals(""))
				return; // removing addition of null
			
				l1.add( t.getText() );
				
		}
		else if(src == b2)
		{//Remove
			
			
		//	if(t.getText().equals("")
		//		return;
		//		l1.remove( t.getText() );
			
			
			// what if we want to remove even when .compareToIgnoreCase(String s) 
			// must use loop and search itself
				
			String a = t.getText();
			for(int i=0;i<l1.getItemCount();i++)
				{
					// int b = l1.getItem(i).compareToIgnoreCase(a);
					
					// compare will return ascii value difference between two strings
					 // will return zero if same string as difference in zero
					
					// if(b==0)
					// l1.remove(i);
				
					if(l1.getItem(i).equalsIgnoreCase(a)) // equal case return boolean
						l1.remove(i);
				}
			
		}
		else if(src == b3)
		{//Selected Remove
			if(l1.getSelectedIndex()==-1) // default selection is -1
				return;
			int i = l1.getSelectedIndex();
			l1.remove(i);
		}
			
	}
	
}
