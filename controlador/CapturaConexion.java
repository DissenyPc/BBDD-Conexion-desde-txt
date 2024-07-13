package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import inicio.AplicacionUniversal;



public class CapturaConexion  {

	public static void Captura() {
		FileReader entrada = null;
		try {
			entrada = new FileReader("src/ConfiguraConexion.txt");
			
		} catch (IOException e) {
			System.out.println ("falloo");
			JOptionPane.showMessageDialog(null, "El Fichero no se ha encontrado, Por favor elijalo en la siguiente Ventana");
			JFileChooser chose = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter( "Archivos de Texto", "txt");
			chose.setFileFilter(filter);
			int retunrVal = chose.showOpenDialog(null);
			if(retunrVal == JFileChooser.APPROVE_OPTION) {
				try {
					entrada = new FileReader  (chose.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					System.out.println ("fallooo");
					e1.printStackTrace();
				} 
			}
		}
		
			BufferedReader miBuffer = new BufferedReader(entrada);
			try {
				ParametrosConexion = miBuffer.readLine();
				nombreBBDD = miBuffer.readLine();
				UsuarioBBDD = miBuffer.readLine();
				ContrasenyaBBDD = miBuffer.readLine();
				if (ContrasenyaBBDD == null) { ContrasenyaBBDD = "";}
				entrada.close();
				
			} catch (IOException e) {
				System.out.println ("fallo");
				e.printStackTrace();
			}
						
		} 
		
		
	
	
	public static String ParametrosConexion, UsuarioBBDD, ContrasenyaBBDD, nombreBBDD;
}

