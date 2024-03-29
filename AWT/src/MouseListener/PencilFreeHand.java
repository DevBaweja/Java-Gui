package MouseListener;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//here we are using applet class so that we dont have to make main in this.
//also no need to setsize,setvisibility,setlayout as in frame.
//also no need to implements WindowListener to close it.
public class PencilFreeHand extends Applet implements MouseMotionListener, MouseListener {

	int x, y;
	// for starting point

	public void init() {
		this.addMouseMotionListener(this);
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

		Graphics g = this.getGraphics();
		// making my own color
		Color c1 = new Color((int) ((Math.random() * 1000) % 256), (int) ((Math.random() * 1000) % 256),
				(int) ((Math.random() * 1000) % 256));
		/*
		 * Math.random() will give random between 0 to 1 so we multiple it by 1000 and
		 * mod 265 to obtain it in between 0-265 rr,gg,bb value in my own color as Math
		 * give and take argument in double typecast it to int for rr,gg,bb values
		 */
		g.setColor(c1);
		// same color
		g.setColor(Color.orange);
		g.drawLine(e.getX() - 1, e.getY() - 1, e.getX(), e.getY());
		// to give it color we use filloval instead of drawoval

		// draw line while dragging
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
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
