package mx.ipn.upiicsa.poo._2019600721.practica_05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Triangle extends Figura {
	private int width;
	private int height;

	private static final Color DEFAULT_BORDER_COLOR = new Color(0, 0, 0);
	private static final Color DEFAULT_FILL_COLOR = Color.ORANGE;
	private static final int DEFAULT_WIDTH = 120;
	private static final int DEFAULT_HEIGHT = 80;

	protected Triangle(int x, int y) {
		super(x, y);
		this.fillColor = DEFAULT_FILL_COLOR;
		this.borderColor = DEFAULT_BORDER_COLOR;
		width = DEFAULT_WIDTH;
		height = DEFAULT_HEIGHT;
		stroke = 1;
		tamaño = 0;
	}

	@Override
	public void paint(Graphics g) {
		width = DEFAULT_WIDTH + tamaño;
		height = DEFAULT_HEIGHT + tamaño;
		int x[] = { this.x - stroke * 2, this.x + (width / 2), this.x + width + stroke * 2 };
		int borderX[] = { this.x, this.x + (width / 2), this.x + width };
		int y[] = { this.y + stroke, this.y - height - stroke, this.y + stroke };
		int borderY[] = { this.y, this.y - (height - 2), this.y };

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.borderColor);
		g2d.drawPolygon(x, y, 3);
		g2d.fillPolygon(x, y, 3);
		g2d.setColor(this.fillColor);
		g2d.fillPolygon(borderX, borderY, 3);
		if (selected == true) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(this.x - 10 - stroke, this.y - 10, 10, 10);
			g2d.fillRect(this.x + width + stroke, this.y - 10, 10, 10);
			g2d.fillRect(this.x + width + stroke, this.y - height - stroke, 10, 10);
			g2d.fillRect(this.x - 10 - stroke, this.y - height - stroke, 10, 10);
		}
	}

	@Override
	public boolean limits(int x, int y) {
		boolean limits;
		if (x >= this.x && x <= this.x + width && y <= this.y && y >= this.y - height) {
			limits = true;
		} else {
			limits = false;
		}
		selected = limits;
		return limits;
	}

	public static Triangle getDefault(int x, int y) {
		return new Triangle(x, y);
	}

}
