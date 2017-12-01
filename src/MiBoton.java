import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MiBoton extends JButton {
	
	int fila;
	int columna;
	Interfaz ventana;

	public MiBoton(int fila, int columna, Interfaz v) {
		this.fila = fila;
		this.columna = columna;
		ventana = v;
		
		this.setText(fila +"-"+columna);
		this.setFont(new Font("ITALIC", Font.BOLD, 10));
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(MiBoton.this, ((JButton) e.getSource()).getText());

				Graphics grafico = ventana.getGraficos();
				grafico.setColor(ventana.obtenerColorBoton(fila, columna));
				grafico.fillRect(columna*100,fila*100,100, 100);
				grafico.dispose();
				
				ventana.repintar();
			}
		});
	}
	
	

}
