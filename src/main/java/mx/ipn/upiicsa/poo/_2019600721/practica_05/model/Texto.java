package mx.ipn.upiicsa.poo._2019600721.practica_05.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Texto extends Figura {
	private static final Color TEXT_COLOR = Color.BLUE;
//	private static String DEFAULT_TEXT = "some text";
	private String value;
	private int length;

	protected Texto(int x, int y, String value) {
		super(x, y);
		this.value = value;
		fillColor = TEXT_COLOR;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(fillColor);
		g2d.drawString(value, this.x, this.y);
		if (selected == true) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(this.x - 10, this.y - 20, 10, 10);
			g2d.fillRect(this.x + (length * 6) + 10, this.y - 20, 10, 10);
			g2d.fillRect(this.x + (length * 6) + 10, this.y, 10, 10);
			g2d.fillRect(this.x - 10, this.y, 10, 10);
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static Texto getDefault(int x, int y, String value) {
		return new Texto(x, y, value);
	}

	@Override
	public boolean limits(int x, int y) {
		length = value.length();
		boolean limits;
		if (x >= this.x && x <= this.x + (length * 12) && y <= this.y && y >= this.y - 12) {
			limits = true;
		} else {
			limits = false;
		}
		selected = limits;
		return limits;
	}

}
