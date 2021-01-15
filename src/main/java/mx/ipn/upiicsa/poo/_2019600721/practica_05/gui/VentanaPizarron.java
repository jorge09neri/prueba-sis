package mx.ipn.upiicsa.poo._2019600721.practica_05.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import mx.ipn.upiicsa.poo._2019600721.practica_05.exception.DrawingException;
import mx.ipn.upiicsa.poo._2019600721.practica_05.model.Circle;
import mx.ipn.upiicsa.poo._2019600721.practica_05.model.Cuadrado;
import mx.ipn.upiicsa.poo._2019600721.practica_05.model.Figura;
import mx.ipn.upiicsa.poo._2019600721.practica_05.model.Image;
import mx.ipn.upiicsa.poo._2019600721.practica_05.model.Line;
import mx.ipn.upiicsa.poo._2019600721.practica_05.model.Pencil;
import mx.ipn.upiicsa.poo._2019600721.practica_05.model.Poligon;
import mx.ipn.upiicsa.poo._2019600721.practica_05.model.Rectangulo;
import mx.ipn.upiicsa.poo._2019600721.practica_05.model.Texto;
import mx.ipn.upiicsa.poo._2019600721.practica_05.model.Triangle;

public class VentanaPizarron extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel toolPanel;
	private JPanel dashboardPanel;
	private JPanel logPanel;

	private JButton btnCircle;
	private JButton btnTriangle;
	private JButton btnSquare;
	private JButton btnRectangle;
	private JButton btnPoligon;
	private JButton btnText;
	private JButton btnImage;
	private JButton btnPencil;
	private JButton btnSelect;
	private JButton btnLine;

	private static final int TOOL_UNSELECT = -1;
	private static final int TOOL_CIRCLE = 1;
	private static final int TOOL_TRIANGLE = 2;
	private static final int TOOL_SQUARE = 3;
	private static final int TOOL_RECTANGLE = 4;
	private static final int TOOL_POLIGON = 5;
	private static final int TOOL_TEXT = 6;
	private static final int TOOL_IMAGE = 7;
	private static final int TOOL_PENCIL = 8;
	private static final int TOOL_LINE = 9;
	private static final int TOOL_SELECT = 10;
	private static final int DRAWING_ACTIVE = 1;
	private static final int DRAWING_INACTIVE = 2;
	private static final int SELECT_ACTIVE = 1;
	private static final int SELECT_INACTIVE = 0;

	private int selectedTool;
	private int drawingState;
	private int selectState;

	private Figura pencilTemp;
	private Figura figuraTemp;
	private List<Figura> figuras;

	Color color;
	Color colorLapiz;
	@SuppressWarnings("unused")
	private int stroke;
	@SuppressWarnings("unused")
	private int tamaño;

	public VentanaPizarron() {
		initComponents();
		selectedTool = TOOL_UNSELECT;
		drawingState = DRAWING_INACTIVE;
		selectState = SELECT_INACTIVE;
	}

	public void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		instantiateComponents();
		buildLayout();
		initializeListener();

		setVisible(true);
	}

	private void initializeListener() {
		btnCircle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_CIRCLE;

			}
		});
		btnTriangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_TRIANGLE;
			}
		});
		btnSquare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_SQUARE;
			}
		});
		btnRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_RECTANGLE;
			}
		});
		btnPoligon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_POLIGON;
			}
		});
		btnText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_TEXT;
			}
		});
		btnImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_IMAGE;
			}
		});
		btnPencil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorLapiz = color = JColorChooser.showDialog(null, "Seleccione un Color de Lápiz", Color.BLUE);
				selectedTool = TOOL_PENCIL;
			}
		});
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_SELECT;
			}
		});
		btnLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorLapiz = color = JColorChooser.showDialog(null, "Seleccione un Color de línea", Color.BLUE);
				selectedTool = TOOL_LINE;
				JOptionPane.showMessageDialog(null, "Arrastre y suelte para dibujar una línea");
			}
		});
		dashboardPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (selectedTool != TOOL_SELECT && drawingState == DRAWING_ACTIVE) {
					@SuppressWarnings("unused")
					Figura figura = getFigure(e.getX(), e.getY());
				} else if (selectedTool == TOOL_SELECT) {
					figuraTemp = selectFigure(e.getX(), e.getY());
					if (figuraTemp != null) {
						if (selectState == SELECT_ACTIVE) {
							modifyFigure(e.getX(), e.getY(), figuraTemp);
						}
						selectState = SELECT_ACTIVE;

					} else {
						selectState = SELECT_INACTIVE;
					}
					dashboardPanel.repaint();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				drawingState = DRAWING_ACTIVE;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				drawingState = DRAWING_INACTIVE;

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (drawingState == DRAWING_ACTIVE && selectedTool == TOOL_PENCIL
						|| drawingState == DRAWING_ACTIVE && selectedTool == TOOL_LINE) {
					pencilTemp = getFigure(e.getX(), e.getY());
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (drawingState == DRAWING_ACTIVE && selectedTool == TOOL_PENCIL) {
					pencilTemp = null;
				}
				if (drawingState == DRAWING_ACTIVE && selectedTool == TOOL_LINE) {
					Line line = (Line) pencilTemp;
					line.addPoint(e.getX(), e.getY());
					line.paint(dashboardPanel.getGraphics());
				}

			}

		});

		dashboardPanel.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				if (drawingState == DRAWING_ACTIVE && selectedTool == TOOL_PENCIL) {
					Pencil pencil = (Pencil) pencilTemp;
					pencil.addPoint(e.getX(), e.getY());
					pencil.paint(dashboardPanel.getGraphics());
				}
				if (selectState == SELECT_ACTIVE) {
					moveFigure(e.getX(), e.getY(), figuraTemp);
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {

			}

		});

	}

	public Figura getFigure(int x, int y) {
		Figura figura = null;
		try {
			figura = getFigureDraw(x, y);
			figura.paint(dashboardPanel.getGraphics());
			figuras.add(figura);
		} catch (DrawingException e1) {
		} finally {

		}
		return figura;
	}

	private Figura getFigureDraw(int x, int y) throws DrawingException {
		Figura figura = null;
		if (selectedTool == TOOL_UNSELECT) {
			throw new DrawingException();
		} else if (selectedTool == TOOL_CIRCLE) {
			figura = Circle.getDefault(x, y);
		} else if (selectedTool == TOOL_IMAGE) {
			String ruta = JOptionPane.showInputDialog("Ingrese la ruta de la imagen");
			figura = Image.getDefault(x, y, ruta);
		} else if (selectedTool == TOOL_LINE) {
			figura = Line.getDefault(x, y, colorLapiz);
		} else if (selectedTool == TOOL_PENCIL) {
			figura = Pencil.getDefault(x, y, colorLapiz);
		} else if (selectedTool == TOOL_POLIGON) {
			figura = Poligon.getDefault(x, y);
		} else if (selectedTool == TOOL_RECTANGLE) {
			figura = Rectangulo.getDefault(x, y);
		} else if (selectedTool == TOOL_SELECT) {

		} else if (selectedTool == TOOL_SQUARE) {
			figura = Cuadrado.getDefault(x, y);
		} else if (selectedTool == TOOL_TEXT) {
			String value = JOptionPane.showInputDialog("Ingrese el texto");
			figura = Texto.getDefault(x, y, value);
		} else if (selectedTool == TOOL_TRIANGLE) {
			figura = Triangle.getDefault(x, y);
		}
		return figura;
	}

	private void moveFigure(int x, int y, Figura figura) {
		if (figura != null) {
			figura.setX(x);
			figura.setY(y);
			repaint();
		}
	}

	private void modifyFigure(int x, int y, Figura figura) {
		String[] options = { "Borde", "Fondo", "Grosor", "Tamaño" };
		int opc = JOptionPane.showOptionDialog(null, "¿Que quieres modificar?", "Modificar figura",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		switch (opc) {
		case 0:
			figura.setBorderColor(color = JColorChooser.showDialog(null, "Seleccione un Color de borde", Color.BLUE));
			break;
		case 1:
			figura.setFillColor(color = JColorChooser.showDialog(null, "Seleccione un color de relleno", Color.BLACK));
			break;
		case 2:
			figura.setStroke(
					stroke = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un tamaño de borde")));
			break;
		case 3:
			figura.setTamaño(tamaño = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Introduce un tamaño que quieras aumentar")));
			break;
		default:
			break;
		}
		repaint();
	}

	private Figura selectFigure(int x, int y) {
		Figura figuraSeleccionada = null;
		System.out.println("Verificando estado");
		for (Figura figura : figuras) {
			if (figura.limits(x, y)) {
				figuraSeleccionada = figura;
			}
		}
		return figuraSeleccionada;
	}

	private void buildLayout() {
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());

		// grid dentro del panel de herramientas
		toolPanel.setLayout(new GridLayout(5, 2));
		// botones que se agregan al tool
		toolPanel.add(btnCircle);
		toolPanel.add(btnTriangle);
		toolPanel.add(btnSquare);
		toolPanel.add(btnRectangle);
		toolPanel.add(btnPoligon);
		toolPanel.add(btnText);
		toolPanel.add(btnImage);
		toolPanel.add(btnPencil);
		toolPanel.add(btnSelect);
		toolPanel.add(btnLine);

		pane.add(toolPanel, BorderLayout.WEST);
		pane.add(dashboardPanel, BorderLayout.CENTER);
		pane.add(logPanel, BorderLayout.SOUTH);
	}

	private void instantiateComponents() {
		toolPanel = new JPanel();
		dashboardPanel = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				System.out.println("Actualizando pizarron");
				figuras.forEach(figura -> {
					figura.paint(g);
				});
			}

		};
		dashboardPanel.setBackground(Color.WHITE);
		logPanel = new JPanel();

		figuras = new ArrayList<Figura>();

//		 agregar imagen
//		C:\Users\Adrian\Pictures\dogeTaco.jpg
//		 ImageIcon icon = new ImageIcon("C://Users//Adrian//Pictures//dogeTaco.png");
//		 Image image = icon.getImage();
//		 image = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

		// btnCircle = new JButton(new ImageIcon(image));
		btnCircle = new JButton("O");
		btnTriangle = new JButton("▲");
		btnSquare = new JButton("■");
		btnRectangle = new JButton("█");
		btnPoligon = new JButton("♦");
		btnText = new JButton("abc");
		btnImage = new JButton("░");
		btnPencil = new JButton("==►");
		btnSelect = new JButton("SEL");
		btnLine = new JButton("──");

	}
}
