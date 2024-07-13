package modelo;

import java.sql.*;

import controlador.CapturaConexion;
import vista.*;

public class RellenaDesplegable {
	
	public static  void  Rellena() {
		miConexion = new Conexion(); //INSTANCIAMOS EL METODO DE LA CONEXION
		Connection accesoBBDD = miConexion.dameConexion(); // INSTANCIAMOS EL METODO DE DENTRO DE CONEXION QUE NOS DA LA CONEXION
		
		try {
			
			DatabaseMetaData datosBBDD = accesoBBDD.getMetaData(); // METEMOS EN datosBBDD LOS METADATOS DE LA BASE DE DATOS
			miResulset = datosBBDD.getTables(CapturaConexion.nombreBBDD, null, null, null); // CREAMOS LA TABLA VIRTUAL "RESULTSET" CON LAS TABLAS DE LA BBDD
			while ( miResulset.next()) { // RECORREMOS EL RESULTSET 
				LaminaDDBB.Desplegable.addItem(miResulset.getString("TABLE_NAME")); // METEMOS EN EL DESPLEGABLE TODAS LAS TABLAS
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            try {
                if (accesoBBDD != null && !accesoBBDD.isClosed()) {
                	accesoBBDD.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
		}
	}

	static Conexion miConexion;
	public static ResultSet miResulset;
}
