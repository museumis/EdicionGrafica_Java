import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interfaz {

	JFrame frame = new JFrame();
	GridBagConstraints data;
	JPanel panelDerecha, panelIzquierda;

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
		// PANEL DERECHA
		// -------------
		panelDerecha = new JPanel();
		panelDerecha.setLayout(new GridLayout());
		panelDerecha.setBackground(Color.GRAY);
		data = new GridBagConstraints();
		data.gridx = 0;
		data.gridy = 0;
		data.weightx = 2;
		data.weighty = 2;
		data.fill = GridBagConstraints.BOTH;
		frame.add(panelDerecha, data);

		// PANEL IZQUIERDA
		// ---------------
		panelIzquierda = new JPanel();
		panelIzquierda.setLayout(new GridLayout(2, 1));
		panelIzquierda.setBackground(Color.BLUE);
		data = new GridBagConstraints();
		data.gridx = 1;
		data.gridy = 0;
		data.weightx = 1;
		data.weighty = 1;
		data.fill = GridBagConstraints.BOTH;
		frame.add(panelIzquierda, data);
		
		//

	}

	public void iniciarListened() {
	}
}
