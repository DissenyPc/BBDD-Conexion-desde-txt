package vista;

import javax.swing.JFrame;

public class MarcoBBDD extends JFrame {

	public MarcoBBDD() {
		//setBounds(300,300,700,700);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		miLamina = new LaminaDDBB();
		setTitle("Aplicacion Universal mostrar datos de BBDD");
		add(miLamina);
	}
	public static LaminaDDBB miLamina;
}
