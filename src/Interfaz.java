import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Interfaz {

	// Interfaz
	JFrame frame = new JFrame();
	GridBagConstraints data;
	JPanel panelDerecha, panelIzquierda, panelArriba, panelAbajo;
	JLabel lienzo;
	BufferedImage canvas;
	Graphics grafico;
	ImageIcon imagenIcon;
	// Botones panel arriba derecha
	MiBoton[][] botones = new MiBoton[4][4];
	MibotonColor[][] botonesColor = new MibotonColor[4][4];

	public Interfaz() {
		frame = new JFrame();
		frame.setBounds(230, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void iniciar() {
		iniciarComponentes();
		iniciarListened();
		frame.setVisible(true);
	}

	public void iniciarComponentes() {
		frame.setLayout(new GridBagLayout());
		// PANEL IZQUIERDA
		// -------------
		panelDerecha = new JPanel();
		panelDerecha.setLayout(new GridBagLayout());
		panelDerecha.setBackground(Color.GRAY);
		data = new GridBagConstraints();
		data.gridx = 0;
		data.gridy = 0;
		data.weightx = 2;
		data.weighty = 2;
		data.fill = GridBagConstraints.BOTH;
		frame.add(panelDerecha, data);
		// Dibujo
		lienzo = new JLabel();
		canvas = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
		grafico = canvas.getGraphics();
		grafico.setColor(Color.WHITE);
		grafico.fillRect(0, 0, canvas.getHeight(), canvas.getWidth());
		lienzo.setIcon(new ImageIcon(canvas));
		grafico.dispose();
		lienzo.repaint();
		panelDerecha.add(lienzo);
		// PANEL DERECHA ARRIBA
		// ---------------
		panelDerecha = new JPanel();
		panelDerecha.setLayout(new GridLayout(2, 1));
		panelDerecha.setBackground(Color.BLUE);
		data = new GridBagConstraints();
		data.gridx = 1;
		data.gridy = 0;
		data.weightx = 1;
		data.weighty = 1;
		data.fill = GridBagConstraints.BOTH;
		frame.add(panelDerecha, data);

		// PANEL DERECHA ARRIBA
		// ---------------
		panelArriba = new JPanel();
		panelArriba.setLayout(new GridLayout(4, 4, 4, 4));
		panelArriba.setBackground(Color.CYAN);
		panelArriba.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20),
				BorderFactory.createTitledBorder("Botones")));
		panelDerecha.add(panelArriba);
		// botones 4x4 cursiva y negrita
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				botones[i][j] = new MiBoton(i, j, this);
				panelArriba.add(botones[i][j]);
			}
		}
		// PANEL DERECHA ABAJO
		// ---------------
		panelAbajo = new JPanel();
		panelAbajo.setLayout(new GridLayout(4, 4,5,5));
		// botones 4x4 cursiva y negrita
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				botonesColor[i][j] = new  MibotonColor(i, j,this);
				panelAbajo.add(botonesColor[i][j]);
			}
		}
		panelDerecha.add(panelAbajo);

	}

	public void iniciarListened() {

	}

	public Graphics getGraficos() {
		return canvas.getGraphics();
	}

	public void repintar() {
		lienzo.repaint();
	}
	
	public Color obtenerColorBoton(int fila,int columna) {
		return botonesColor[fila][columna].getForeground();
	}
}
