package MouseListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.jws.soap.SOAPBinding.Style;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//here we are using applet class so that we dont have to make main in this.
//also no need to setsize,setvisibility,setlayout as in frame.
//also no need to implements WindowListener to close it.
public class Paint extends JApplet implements MouseMotionListener,MouseListener,ActionListener{
	
	int x1,y1,x2,y2;
	JPanel pbottom,pcenter,pcolor,ptype,psize,pt;
	JLabel lbplace;
	Graphics g;
	int rr,gg,bb;
	String type="";
	JButton pencil,brush,highlight,spray,eraser;
	public void init()
	{
		setVisible(true);
		setSize(new Dimension(1500,1000));
		setPreferredSize(new Dimension(1500, 1000));
		setLayout(new BorderLayout());
		rr=gg=bb=0;
		type = "pencil";
		lbplace = new JLabel();
		
		pcenter = new JPanel();
		pbottom = new JPanel();
		pbottom.add(lbplace);
		
		// use icon
		pencil = new JButton("Pencil");
		brush = new JButton("Brush");
		highlight = new JButton("Highlight");
		spray = new JButton("Spray");
		eraser = new JButton("Eraser");
		
		ptype = new JPanel();
		ptype.setLayout(new GridLayout(5,1,0,50));
		ptype.add(pencil);
		ptype.add(brush);
		ptype.add(highlight);
		ptype.add(spray);
		ptype.add(eraser);
		
		psize = new JPanel();
		
		pt = new JPanel();
		pt.setLayout(new GridLayout(2,1,100,0));
		pt.add(ptype);
		pt.add(psize);
		
		add(pcenter,BorderLayout.CENTER);
		add(pt,BorderLayout.WEST);
		add(pbottom,BorderLayout.SOUTH);
		
		
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
		pencil.addActionListener(this);
		brush.addActionListener(this);
		highlight.addActionListener(this);
		spray.addActionListener(this);
		eraser.addActionListener(this);
		style();
		
		validate();
		revalidate();
		
		
	}
	
	public void style() {

		pcenter.setBackground(Color.white);
		lbplace.setFont(new Font("Viner Hand ", Font.ITALIC+Font.BOLD, 16));
		lbplace.setForeground(Color.lightGray);
		pbottom.setBackground(Color.white);
		
		pencil.setForeground(Color.white);
		brush.setForeground(Color.white);
		highlight.setForeground(Color.white);
		spray.setForeground(Color.white);
		eraser.setForeground(Color.white);
		
		
		pencil.setBackground(Color.black);
		brush.setBackground(Color.black);
		highlight.setBackground(Color.black);
		spray.setBackground(Color.black);
		eraser.setBackground(Color.black);
		
		Font f1 = new Font("Courier New", Font.BOLD, 14);
		pencil.setFont(f1);
		brush.setFont(f1);
		highlight.setFont(f1);
		spray.setFont(f1);
		eraser.setFont(f1);
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
		lbplace.setForeground(Color.black);
		lbplace.setText("( X: "+e.getX()+" , Y: "+e.getY()+" )");
		
		g = this.getGraphics();
	
		
		
		Color c1 = new Color(rr, gg, bb);
			g.setColor(c1);
			// same color
			x2 = e.getX();
			y2 = e.getY();
			
			gettype();
			
				
			validate();
			revalidate();
	}
	
	public void gettype() {
		switch (type) {
		case "pencil":
		{
			System.out.println("pencil");
			drawpencil();
		}
			break;
		case "brush":
		{
			System.out.println("brush");
			drawbrush();
		}
			break;
		case "spray":
		{
			System.out.println("spray");
			drawspray();
		}
			break;
		default:
			break;
		}
	}

	public void drawpencil()
	{
		g.drawLine(x1, y1, x2, y2);
		g.
		x1 = x2;
		y1 = y2;
	}

	public void drawbrush() 
	{
		Font fbrush = new Font("Comic sans",Font.PLAIN, 12);
		g.setFont(fbrush);
		drawpencil();
		
		
	}

	
	public void drawspray() 
	{
		g.fillOval(x2-5, y2-5, 10, 10);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
		lbplace.setForeground(Color.lightGray);
		lbplace.setText("( X: "+e.getX()+" , Y: "+e.getY()+" )");
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		
		if(src==pencil)
			type = "pencil";
		else if(src==brush)
			type = "brush";
		else if(src==highlight)
			type = "highlight";
		else if(src==spray)
			type="spray";
		else if(src==eraser)
			type="eraser";
	}

	// making my own color
			// Color c1 = new Color((int)((Math.random()*1000)%256),(int)((Math.random()*1000)%256),(int)((Math.random()*1000)%256));
					/*
					 * Math.random() will give random between 0 to 1 so we multiple it by 1000
					 * and mod 265 to obtain it in between 0-265 rr,gg,bb value in my own color
					 * as Math give and take argument in double typecast it to int for rr,gg,bb values
					 */


}
