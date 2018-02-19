package checker.gui;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Dessiner extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int IDEAL_WIDTH=22;
	private static final int IDEAL_HEIGHT=22;
	private ArrayList<Point> al=new ArrayList<Point>();
	private ArrayList<Point> alBlue=new ArrayList<Point>();
	private ArrayList<Point> alRed=new ArrayList<Point>();
	private ArrayList<Point> alBlack=new ArrayList<Point>();
	private ArrayList<Point> alYellow=new ArrayList<Point>();

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//   = (Graphics2D) g;
		int i=0;
		//creates uncolored cases
		for(i=0;i<al.size();i++) {
			g.setColor(Color.lightGray);
			g.fillOval((int)al.get(i).getX(), (int)al.get(i).getY(), IDEAL_WIDTH, IDEAL_HEIGHT);	
		}
		//creates colored cases 
		for(i=0;i<alBlue.size();i++) {
			
			g.setColor(Color.black);
			g.fillOval((int)alBlack.get(i).getX(), (int)alBlack.get(i).getY(), IDEAL_WIDTH, IDEAL_HEIGHT);
			
			g.setColor(Color.red);
			g.fillOval((int)alRed.get(i).getX(), (int)alRed.get(i).getY(), IDEAL_WIDTH, IDEAL_HEIGHT);
			
			g.setColor(Color.blue);
			g.fillOval((int)alBlue.get(i).getX(), (int)alBlue.get(i).getY(), IDEAL_WIDTH, IDEAL_HEIGHT);
			
			g.setColor(Color.yellow);
			g.fillOval((int)alYellow.get(i).getX(), (int)alYellow.get(i).getY(), IDEAL_WIDTH, IDEAL_HEIGHT);
		}	
	}
	public void addArrayList(Point point) {
		al.add(point);
	}
	public void addBlueArrayList(Point point) {
		alBlue.add(point);
	}
	public void addRedArrayList(Point point) {
		alRed.add(point);
	}
	public void addBlackArrayList(Point point) {
		alBlack.add(point);
	}
	public void addYellowArrayList(Point point) {
		alYellow.add(point);
	}
}