import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class MibotonColor extends JButton {
	int fila;
	int columna;
	Interfaz ventana;

	public MibotonColor(int fila, int columna, Interfaz v) {
		this.fila = fila;
		this.columna = columna;
		ventana = v;

		this.setText(fila + "-" + columna);
		this.setFont(new Font("ITALIC", Font.BOLD, 10));
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Color color = JColorChooser.showDialog(MibotonColor.this,"Selecciona Color",Color.BLACK);			
				MibotonColor.this.setForeground(color);
			}
		});
	}
}