package Frame;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameDialogueActionListener extends Frame implements ActionListener,WindowListener{
	
	// Making panel card then putting it into 
	Button b1,b2,b3;
	Dialog d;
	
	public FrameDialogueActionListener()
	{
		
		setVisible(true);
		setSize(800, 800);
		setLayout(new FlowLayout());
		
		b1 = new Button("AOPForm");
		b2 = new Button("CircleForm");
		b3 = new Button("MaxMainForm");
		
		add(b1);
		add(b2);
		add(b3);
	

		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		this.addWindowListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object src = e.getSource();
		
		if(d != null)
			d.dispose();
		
		if(src == b1)
		{
			d = new AOPForm(this);  // Frame super class
									// need parametric constructor
		}
		else if(src == b2)
		{
			d = new CircleForm(this);
		}
		else if(src == b3)
		{
			d = new MaxMinForm(this);
		}
			d.addWindowListener(this);	
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent we) {
		// TODO Auto-generated method stub
		
		Object src = we.getSource();
		if(src == d)
		{
			d.dispose();
		}
		else
		this.dispose();
		// if we are using multiple frames in same system
		// System.exit(-1);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
