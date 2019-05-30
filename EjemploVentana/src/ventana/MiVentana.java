package ventana;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiVentana extends JFrame{
	private JLabel lblUsuario, lblPassword;
	private JTextField txtUsuario, txtPassword;
	private JButton btnAceptar, btnSalir;

	public MiVentana() {
		configurar();
		asignarEventos();
	}

	private void configurar() {
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(3, 2)); // creo un grid layout con 3 columnas y 2 filas que subdivide el contenedor

		// Paso a crear todo los componentes
		lblUsuario = new JLabel("Usuario");
		lblPassword = new JLabel("Password");
		txtUsuario = new JTextField();
		txtPassword = new JTextField();
		btnAceptar = new JButton("Aceptar");
		btnSalir = new JButton("Salir");

		// Los elementos en el layout se agregan en orden en vez de hacerlo como una
		// matriz. De izq a derecha de arriba abajo
		c.add(lblUsuario);
		c.add(txtUsuario);
		c.add(lblPassword);
		c.add(txtPassword);
		c.add(btnAceptar);
		c.add(btnSalir);
	}

	private void asignarEventos() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Deja de correr el programa cuando se lo cierra
		ManejoBotonInterna mb = new ManejoBotonInterna();
		btnAceptar.addActionListener(mb);
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});

	}

	class ManejoBotonInterna implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent btn) {
			if (btn.getActionCommand() == "Salir") {
				System.exit(0);

			} else {

				// JOptionPane es un metodo de clase estatico, por eso lo puedo llamar sin crear
				// el objeto
				// Crea una ventana modal, no puedo hacer nada mas hasta que no le de una
				// respuesta a la ventana
				JOptionPane.showMessageDialog(null, "Ingresamos " + txtUsuario.getText()); // componente para que
																							// aparezca
																							// un pop-up
			}

		}

	}

}
