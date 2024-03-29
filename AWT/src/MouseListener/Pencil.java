package MouseListener;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//here we are using applet class so that we dont have to make main in this.
//also no need to setsize,setvisibility,setlayout as in frame.
//also no need to implements WindowListener to close it.
public class Pencil extends Applet implements MouseMotionListener,MouseListener{
	
	int x1,y1,x2,y2;
	Label l;
	public void init()
	{
		l = new Label();
		l.setSize(new Dimension(90, 20));
		l.setPreferredSize(new Dimension(90, 20));
		l.setBackground(Color.cyan);
		l.setForeground(Color.red);
		
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		add(l);
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
		Graphics g = this.getGraphics();
		// making my own color
		Color c1 = new Color((int)((Math.random()*1000)%256),(int)((Math.random()*1000)%256),(int)((Math.random()*1000)%256));
				/*
				 * Math.random() will give random between 0 to 1 so we multiple it by 1000
				 * and mod 265 to obtain it in between 0-265 rr,gg,bb value in my own color
				 * as Math give and take argument in double typecast it to int for rr,gg,bb values
				 */
			g.setColor(c1);
			// same color
		//	g.setColor(Color.orange);
			x2 = e.getX();
			y2 = e.getY();
			g.drawLine(x1, y1, x2, y2);
			
			x1 = x2;
			y1 = y2;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
