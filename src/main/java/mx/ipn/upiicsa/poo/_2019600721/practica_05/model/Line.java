package mx.ipn.upiicsa.poo._2019600721.practica_05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Line extends Pencil {

	protected Line(int x, int y, Color color) {
		super(x, y, color);
		borderColor = color;
		fillColor = color;
		stroke = 2;
	}

	@Override
	public void paint(Graphics g) {
		if (points.size() == 2) {
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

	public static Line getDefault(int x, int y, Color color) {
		return new Line(x, y, color);
	}

}
