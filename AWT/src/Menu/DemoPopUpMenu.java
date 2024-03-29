package Menu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Polygon;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DemoPopUpMenu extends Frame implements WindowListener,ActionListener,MouseListener{
	
	
 	MenuBar MB;
	// Like button
 	PopupMenu PM; 
 	Menu MColor; 
 	
	MenuItem MIRectangle,MISquare,MIOval,MICircle,MITriangle; 
	MenuItem MIRed,MIPink,MIBlack,MICyan,MIBlue,MIGreen; 
	
	int choice1=0; // for Shape
	int choice2=0; // for Color
	
	public DemoPopUpMenu()
	{
	
		setVisible(true);
		setSize(500, 500);
		setLayout(new FlowLayout()); // as default of Frame is BorderLayout
		
		// Menu items for menu shape
		MIRectangle = new MenuItem("Rectangle",new  MenuShortcut(KeyEvent.VK_R,true)); 
		MISquare = new MenuItem("Square"); 
		MIOval = new MenuItem("Oval");
		MICircle = new MenuItem("Circle");
		MITriangle = new MenuItem("Triangle");
		
		// Menu items for menu color
		MIRed = new MenuItem("Red");
		MIPink = new MenuItem("Pink");
		MIBlack = new MenuItem("Black");
		MICyan = new MenuItem("Cyan");
		MIBlue = new MenuItem("Blue");
		MIGreen= new MenuItem("Green");
		
		// Add Shortcuts For MenuItems
		
		//MIRectangle.setShortcut(new  MenuShortcut(KeyEvent.VK_R));
		MISquare.setShortcut(new MenuShortcut(KeyEvent.VK_S));
		MIOval.setShortcut(new MenuShortcut(KeyEvent.VK_O));
		MICircle.setShortcut(new MenuShortcut(KeyEvent.VK_C));
		MITriangle.setShortcut(new MenuShortcut(KeyEvent.VK_T));
		 
		// As there are menu items of pop up menu it is not applied here
		// it can only be used if menu items is of menu
		// as name suggest new MenuShortcut not new PopUpMenuShortcut
		
		// is for Menu Items of Menu
		MIRed.setShortcut(new MenuShortcut(KeyEvent.VK_R, true)); // as r is used already we can add shift operation
		// Ctrl + Shift + R
		MIPink.setShortcut(new MenuShortcut(KeyEvent.VK_P,false));
		MIBlack.setShortcut(new MenuShortcut(KeyEvent.VK_B)); // default shift modifier is false
		MICyan.setShortcut(new MenuShortcut(KeyEvent.VK_C, true));
		MIBlue.setShortcut(new MenuShortcut(KeyEvent.VK_B,true));
		MIGreen.setShortcut(new MenuShortcut(KeyEvent.VK_G,false));

		
		MColor = new Menu("Color");
		
		MColor.add(MIRed);
		MColor.add(MIPink);
		MColor.addSeparator();
		MColor.add(MIBlack);
		MColor.add(MICyan);
		MColor.addSeparator();
		MColor.add(MIBlue);
		MColor.add(MIGreen);
		
		
		
		MB = new MenuBar();
		PM = new PopupMenu();
		// How to add two Popup Menu 
		// How to add shortcut in Pop Menu
		
		MB.add(MColor); // add only menu
		
		PM.add(MIRectangle);
		PM.add(MISquare);
		PM.addSeparator(); // adding line
		PM.add(MIOval);
		PM.add(MICircle);
		PM.addSeparator();
		PM.add(MITriangle);
	

		add(PM); // it is popup menu
		setMenuBar(MB); // it is menubar
		
		
		this.addWindowListener(this);
		this.addMouseListener(this);
		
		
		// making them as buttons 
		// so we have to use action listener
		MIRectangle.addActionListener(this);
		MISquare.addActionListener(this);
		MIOval.addActionListener(this);
		MICircle.addActionListener(this);
		MITriangle.addActionListener(this);
		
		MIRed.addActionListener(this);
		MIPink.addActionListener(this);
		MIBlack.addActionListener(this);
		MICyan.addActionListener(this);
		MIBlue.addActionListener(this);
		MIGreen.addActionListener(this);
		
	}
	
	
	// Frame class overwriting applet class function paint
	public void paint(Graphics g) 
	{
		
		// Color
		switch(choice2) 
		{
			case 0:{
						// Do nothing
						break;
					}
			case 1:{
						g.setColor(Color.red);
						break;
					}
			case 2:{
						g.setColor(Color.pink);
						break;
					}
			case 3:{
						g.setColor(Color.black);
						break;
					}			
			case 4:{
						g.setColor(Color.cyan);
						break;
					}			
			case 5:{
						g.setColor(Color.blue);
						break;
					}
			case 6:{
						g.setColor(Color.green);
						break;
					}
			
		}
		
		// Shape
		switch(choice1)
		{
			case 0 :{
					 // do nothing
						break;
					}
			
			case 1 :{// Rectangle
							g.fillRect(100, 100, 200, 100);
							break;
					}
			
			case 2 :{// Square
							g.fillRect(100, 100, 100, 100);
							break;
					}
			
			case 3:{// Oval
							g.fillOval(100, 100, 200, 100);
							break;
					}
			
			case 4 :{// Circle
							g.fillOval(100, 100, 100, 100);
							break;
					}
			case 5:{//Triangle
							int []xpoint = { 125,200,275 };
							int []ypoint = { 250,100,250 };
							Polygon P = new Polygon(xpoint,ypoint,3);
							g.fillPolygon(P);
							break;
					}
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		Object src = ae.getSource();
		
		// Color
		if(src == MIRed)
			choice2 = 1;
		else if(src == MIPink)
			choice2 = 2;
		else if(src == MIBlack)
			choice2 = 3;
		else if(src == MICyan)
			choice2 = 4;
		else if(src == MIBlue)
			choice2 = 5;
		else if(src == MIGreen)
			choice2 = 6;
		
		// Shape
		if(src == MIRectangle)
			choice1 = 1;
		else if(src == MISquare)
			choice1 = 2;
		else if(src == MIOval)
			choice1 = 3;
		else if(src == MICircle)
			choice1 = 4;
		else if(src == MITriangle)
			choice1 = 5;
		
				repaint(); // to make paint again
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(-1);
		
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


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
		if(e.isPopupTrigger())
			PM.show(this, e.getX(), e.getY());
		// this is for frame class so that it will show this popup menu in this frame class
		// getX() and getY() is for coordinates of x and y 
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.isPopupTrigger())
			PM.show(this, e.getX(), e.getY());
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
