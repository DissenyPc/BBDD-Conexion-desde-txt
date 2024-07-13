package modelo;

import java.sql.*;
import controlador.*;

public class Conexion {
	
	Connection miConexion = null;

	public Conexion() {
		CapturaConexion.Captura();
	}
	
	public Connection dameConexion() {
		
		try {
			// 1. CREAR CONEXION CON LA BASE DE DATOS
			// LE DAMOS LA DIRECCION, EL USUARIO Y LA CONTRASEÑA
			// EL PUERTO NO SERIA OBLIGATORIO PERO SI LO HUBIERAN CAMBIADO EN EL SERVIDOR, NO FUNCIONARIA.
			//CONNECTION ES UNA INTERFACE
			miConexion = DriverManager.getConnection(CapturaConexion.ParametrosConexion + CapturaConexion.nombreBBDD, CapturaConexion.UsuarioBBDD, CapturaConexion.ContrasenyaBBDD);
			

		} catch (Exception e) {
			System.out.println("fallooo");
		}
		
		return miConexion;
	}
		
	//public Connection miConexion;	
}
