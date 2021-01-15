package mx.ipn.upiicsa.poo._2019600721.practica_05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Cuadrado extends Figura {
	private int side;

	private static final int DEFAULT_SIDE = 100;
	private static final Color DEFAULT_BORDER_COLOR = new Color(0, 0, 0);
	private static final Color DEFAULT_FILL_COLOR = Color.GREEN;

	protected Cuadrado(int x, int y) {
		super(x, y);
		this.fillColor = DEFAULT_FILL_COLOR;
		this.borderColor = DEFAULT_BORDER_COLOR;
		this.setSide(DEFAULT_SIDE);
		tamaño = 0;
		stroke = 1;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	@Override
	public void paint(Graphics g) {
		side = DEFAULT_SIDE + tamaño;
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.borderColor);
		g2d.drawRect(this.x - stroke, this.y - stroke, this.side + stroke * 2, this.side + stroke * 2);
		g2d.fillRect(this.x - stroke, this.y - stroke, this.side + stroke * 2, this.side + stroke * 2);
		g2d.setColor(this.fillColor);
		g2d.fillRect(this.x, this.y, this.side, this.side);
		if (selected == true) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(this.x - 10 - stroke, this.y - 10 - stroke, 10, 10);
			g2d.fillRect(this.x + side + stroke, this.y - 10 - stroke, 10, 10);
			g2d.fillRect(this.x + side + stroke, this.y + side + stroke, 10, 10);
			g2d.fillRect(this.x - 10 - stroke, this.y + side + stroke, 10, 10);
		}
	}

	@Override
	public boolean limits(int x, int y) {
		boolean limits;
		if (x >= this.x && x <= this.x + side && y >= this.y && y <= this.y + side) {
			limits = true;
		} else {
			limits = false;
		}
		selected = limits;
		return limits;
	}

	public static Cuadrado getDefault(int x, int y) {
		return new Cuadrado(x, y);
	}

}
