package mx.ipn.upiicsa.poo._2019600721.practica_05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Pencil extends Figura {
	protected static final int DEFAULT_WIDTH = 1;
	protected static final Color DEFAULT_BORDER_COLOR = Color.BLACK;
	protected static final Color DEFAULT_FILL_COLOR = Color.BLACK;

	protected List<Point> points;

	protected Pencil(int x, int y, Color color) {
		super(x, y);
		borderColor = color;
		fillColor = color;
		stroke = DEFAULT_WIDTH + stroke;
		points = new ArrayList<Point>();
		points.add(new Point(x, y));
	}

	@Override
	public void paint(Graphics g) {
		if (points.size() > 2) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(borderColor);
			Point a = points.get(0);
			for (int i = 1; i <= points.size() - 1; i++) {
				Point b = points.get(i);
				g2d.drawLine((int) a.getX(), (int) a.getY(), (int) b.getX(), (int) b.getY());
				a = b;
			}
		}
	}

	public void addPoint(int x, int y) {
		points.add(new Point(x, y));
	}

	public static Pencil getDefault(int x, int y, Color color) {
		return new Pencil(x, y, color);
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	@Override
	public boolean limits(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
