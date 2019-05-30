package ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ManejoBoton implements ActionListener {
	
	private JTextField aux;
	public ManejoBoton(JTextField aux) {
		this.aux = aux;
	}

	public void actionPerformed(ActionEvent btn) {

		if (btn.getActionCommand() == "Salir") {
			System.exit(0);

		} else {

			// JOptionPane es un metodo de clase estatico, por eso lo puedo llamar sin crear
			// el objeto
			// Crea una ventana modal, no puedo hacer nada mas hasta que no le de una
			// respuesta a la ventana
			JOptionPane.showMessageDialog(null, "Ingresamos " + aux.getText()); // componente para que aparezca
																						// un pop-up
		}

	}

}
