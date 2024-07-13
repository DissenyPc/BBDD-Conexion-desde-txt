package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;

import modelo.Conexion;

import vista.*;


public class ListarTabla implements ActionListener {
	
	Conexion miConexion = new Conexion();
	
	public void actionPerformed(ActionEvent e) {
		
		Connection conecta = miConexion.dameConexion(); // INSTANCIAMOS EL METODO DE DENTRO DE CONEXION QUE NOS DA LA CONEXION
		
		try {
			
			Statement miStatement = conecta.createStatement(); //CREAMOS EL STATEMENT
			ResultSet rs = miStatement.executeQuery("SELECT * FROM " + LaminaDDBB.Desplegable.getSelectedItem()); // CREAMOS EL RESULTSET

			try { // Recorrer el ResultSet y añadir los datos al modelo

                String [] cols = new String[rs.getMetaData().getColumnCount()];
                for (int i = 0; i < cols.length; i++) {
                    cols[i] = rs.getMetaData().getColumnName(i + 1); // EL i + 1 ES POR QUE LOS RESULTSET NO EMPIEZAN EN IDICE 0 SI NO EN 1
                }
                List<Object[]> lData = new ArrayList<>();
                while(rs.next()){
                    Object[] row = new Object[cols.length];
                    for (int i = 0; i < cols.length; i++) {
                        row[i] = rs.getObject(i + 1);
                    }
                    lData.add(row);
                }
 
                Object [][] data = new Object [lData.size()][cols.length];
                for (int i = 0; i < data.length; i++) {
                    data[i] = lData.get(i);
                }
                MarcoBBDD.miLamina.table.setModel(new DefaultTableModel(data, cols));
                
			} catch (SQLException e1) {
			    e1.printStackTrace();
			}
			
		} catch (Exception e1) {
			System.out.println("Fallo");
		}finally {
            try {
                if (conecta != null && !conecta.isClosed()) {
                    conecta.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
	}
	
	
}