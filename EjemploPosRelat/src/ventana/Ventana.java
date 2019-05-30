package ventana;

import javax.swing.JFrame;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

public class Ventana extends JFrame {

	private JButton btnAccion, btnMovido;

	public Ventana() {
		configurar();
		eventos();
	}

	private void eventos() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		btnAccion.addActionListener(new ManejoAccion());
			
		
	}

	private void configurar() {
		Container c = this.getContentPane();
		c.setLayout(null);
		this.setSize(300, 600);
		btnAccion = new JButton("Accion");
		btnMovido = new JButton("Moviendome...");

		btnMovido.setBounds(10, 10, 100, 30);
		btnAccion.setBounds(180, 510, 100, 30);
		c.add(btnAccion);
		c.add(btnMovido);

	}
	
	class ManejoAccion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
//			Random r = new Random();
//			int x = 10 + r.nextInt(181);
//			int y = 10 + r.nextInt(451);
//			btnMovido.setBounds(x, y, 100, 30);
			int x = btnMovido.getX() + 10;
			int y = btnMovido.getY() + 10;
			btnMovido.setBounds(x, y, 100, 30);	
		}
	}
}
