package mx.ipn.upiicsa.poo._2019600721.practica_05.model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Image extends Figura {
	private BufferedImage image;

	private int side;
	private String ruta;

	private static final int DEFAULT_SIDE = 200;

	protected Image(int x, int y, String ruta) {
		super(x, y);
		this.setSide(DEFAULT_SIDE);
		this.setRuta(ruta);

	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		ImageIcon img = new ImageIcon(getClass().getResource(ruta));
		g2d.drawImage(img.getImage(), this.x, this.y, 200, 200, null);
		
	}

	public static Image getDefault(int x, int y, String ruta) {
		return new Image(x, y, ruta);
	}

	@Override
	public boolean limits(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
}
