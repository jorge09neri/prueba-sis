package mx.ipn.upiicsa.poo._2019600721.practica_05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Figura {
	private static final int DEFAULT_RADIUS = 80;
	private static final Color DEFAULT_BORDER_COLOR = new Color(0, 0, 0);
	private static final Color DEFAULT_FILL_COLOR = Color.YELLOW;

	private int radius;

	protected Circle(int x, int y) {
		super(x, y);
		this.fillColor = DEFAULT_FILL_COLOR;
		this.borderColor = DEFAULT_BORDER_COLOR;
		this.radius = DEFAULT_RADIUS;
		tamaño = 0;
		stroke = 1;
	}

	@Override
	public void paint(Graphics g) {
		radius = DEFAULT_RADIUS + tamaño;
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.borderColor);
		g2d.drawOval(this.x, this.y, this.radius + stroke, this.radius + stroke);
		g2d.fillOval(this.x, this.y, this.radius + stroke, this.radius + stroke);
		g2d.setColor(this.fillColor);
		g2d.fillOval(this.x + stroke, this.y + stroke, this.radius - stroke, this.radius - stroke);
		if (selected == true) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(this.x - 10 - stroke, this.y - 10 - stroke, 10, 10);
			g2d.fillRect(this.x + radius + stroke, this.y - 10 - stroke, 10, 10);
			g2d.fillRect(this.x + radius + stroke, this.y + radius + stroke, 10, 10);
			g2d.fillRect(this.x - 10 - stroke, this.y + radius + stroke, 10, 10);
		}
	}

	@Override
	public boolean limits(int x, int y) {
		boolean limits;
		if (x >= this.x && x <= this.x + radius && y >= this.y && y <= this.y + radius) {
			limits = true;
		} else {
			limits = false;
		}
		selected = limits;
		return limits;
	}

	public static Circle getDefault(int x, int y) {
		return new Circle(x, y);
	}
}
