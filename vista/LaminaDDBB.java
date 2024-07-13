package vista;

import modelo.*;
import controlador.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.*;

public class LaminaDDBB extends JPanel {

	public LaminaDDBB () {
		
	
		setLayout(new BorderLayout());
        Desplegable = new JComboBox();
        Blistar = new JButton("Listar");
        JPanel LaminaMenu = new JPanel();
        LaminaMenu.setLayout(new FlowLayout());
        ListarTabla ListarT = new ListarTabla(); // INSTANCIAMOS EL METODO QUE LE DA LA ACCION AL BOTON
        Blistar.addActionListener(ListarT); //AL BOTON LE DAMOS SU ACCION
        Desplegable.setPreferredSize(new Dimension(220, 30));
        Blistar.setPreferredSize(new Dimension(100, 30));
        RellenaDesplegable.Rellena(); //LLAMAMOS AL METODO QUE NOS RELLENA EL DESPLEGABLE
        LaminaMenu.add(Desplegable);
        LaminaMenu.add(Blistar);
        add(LaminaMenu, BorderLayout.NORTH);
 
        DefaultTableModel model = new DefaultTableModel(new String []{"COLUMNAS"}, 0);
        table = new JTable(model);
        

        
        JScrollPane scrollPane;
        scrollPane = new JScrollPane(table);// Crear el scroll pane con la tabla
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);// ELEJIMOS CUANDO APARECE EL SCROLL
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);
        		
	}

static public JComboBox Desplegable;
static public JButton Blistar;
static public JTable table;
}
