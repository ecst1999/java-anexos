package java_anexos.swingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class UsoJTable2 {

	public static void main(String[] args) {
		JFrame mimarco = new MarcoTablaPersonalizado();
		
		mimarco.setVisible(true);
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoTablaPersonalizado extends JFrame {
	
	public MarcoTablaPersonalizado() {
		
		setTitle("Tabla personalizada");
		
		setBounds(2500, 300, 400, 200);
		
		TableModel mimodelo = new ModeloTablaPersonalizada();
		
		JTable tabla = new JTable(mimodelo);

		add(new JScrollPane(tabla));
	}

}
	

class ModeloTablaPersonalizada extends AbstractTableModel {

	@Override
	public int getRowCount() {		
		return 3;
	}

	@Override
	public int getColumnCount() {		
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		int z = rowIndex + 1;
		
		int y = columnIndex + 2;
		
		return " " + z + " " + y;
	}
	
	@Override
	public String getColumnName(int c) {
		return "Columna " + c;
	}
	
}
	
	
	
	
	
