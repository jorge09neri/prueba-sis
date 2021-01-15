package mx.ipn.upiicsa.poo._2019600721.practica_05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangulo extends Figura {
	private int width;
	private int height;

	private static final int DEFAULT_WIDTH = 150;
	private static final int DEFAULT_HEIGHT = 75;
	private static final Color DEFAULT_BORDER_COLOR = Color.PINK;
	private static final Color DEFAULT_FILL_COLOR = Color.BLACK;

	protected Rectangulo(int x, int y) {
		super(x, y);
		width = DEFAULT_WIDTH;
		height = DEFAULT_HEIGHT;
		borderColor = DEFAULT_BORDER_COLOR;
		fillColor = DEFAULT_FILL_COLOR;
		stroke = 1;
		tamaño = 0;
	}

	@Override
	public void paint(Graphics g) {
		width = DEFAULT_WIDTH + tamaño*2;
		height = DEFAULT_HEIGHT + tamaño;
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.borderColor);
		g2d.drawRect(this.x - stroke, this.y - stroke, this.width + stroke * 2, this.height + stroke * 2);
		g2d.fillRect(this.x - stroke, this.y - stroke, this.width + stroke * 2, this.height + stroke * 2);
		g2d.setColor(this.fillColor);
		g2d.fillRect(this.x + 1, this.y + 1, this.width - 1, this.height - 1);
		if (selected == true) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(this.x - 10 - stroke, this.y - 10 - stroke, 10, 10);
			g2d.fillRect(this.x + width + stroke, this.y - 10 - stroke, 10, 10);
			g2d.fillRect(this.x + width + stroke, this.y + height + stroke, 10, 10);
			g2d.fillRect(this.x - 10 - stroke, this.y + height + stroke, 10, 10);
		}
	}

	@Override
	public boolean limits(int x, int y) {
		boolean limits;
		if (x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height) {
			limits = true;
		} else {
			limits = false;
		}
		selected = limits;
		return limits;
	}

	public static Rectangulo getDefault(int x, int y) {
		return new Rectangulo(x, y);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
