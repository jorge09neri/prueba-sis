package mx.ipn.upiicsa.poo._2019600721.practica_05.model;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {
	protected int x;
	protected int y;
	protected int stroke;

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	protected int tamaño;
	protected Color borderColor;
	protected Color fillColor;
	protected Boolean selected;

	protected Figura(int x, int y) {
		this.x = x;
		this.y = y;
		this.selected = false;
	}

	// Getter y Setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	// no se puede instanciar por si sola
	public abstract void paint(Graphics g);

	public abstract boolean limits(int x, int y);

}