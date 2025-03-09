package java_anexos.swingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class TablaProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mimarco = new MarcoProducto();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);
	}

}


class MarcoProducto extends JFrame {
	
	public MarcoProducto() {
		
		setTitle("Productos");
		
		setBounds(2500, 300, 800, 400);
		
		JPanel superior = new JPanel();
		
		nombresTablas = new JComboBox<String>();
		
		try {
			
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_curso", "root", "Java1234*");
			datosMetaBBDD = cn.getMetaData();
			
			rs = datosMetaBBDD.getTables("java_curso", null, null, null);
			
			while(rs.next()) {
				nombresTablas.addItem(rs.getString("TABLE_NAME"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		nombresTablas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String tablaSeleccionada = (String) nombresTablas.getSelectedItem();
				
				String consulta = "SELECT * FROM " + tablaSeleccionada;
				
				try {
					st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					
					rs = st.executeQuery(consulta);															
					
					modelo = new ResultSetModeloTabla(rs);
					
					JTable tabla = new JTable(modelo);
					
					add(new JScrollPane(tabla), BorderLayout.CENTER);
					
					validate();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		superior.add(nombresTablas);
		
		add(superior, BorderLayout.NORTH);
		
	}
	
	private JComboBox<String> nombresTablas;
	
	private DatabaseMetaData datosMetaBBDD;
	private ResultSet rs;
	private Connection cn;
	private Statement st;
	private ResultSetModeloTabla modelo;
	
}


class ResultSetModeloTabla extends AbstractTableModel{
	
	public ResultSetModeloTabla(ResultSet registros) {
		rsRegistros = registros;
		
		try {
			rsMetaData = rsRegistros.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getRowCount() {				
		
		try {
			rsRegistros.last();
			
			return rsRegistros.getRow();
		} catch (SQLException e) {			
			e.printStackTrace();
			
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		
		try {
			return rsMetaData.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
			
			return 0;
		}
		
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		try {
			rsRegistros.absolute(rowIndex + 1);
			
			return rsRegistros.getObject(columnIndex + 1);
			
		}catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
	public String getColumnName(int c) {
		
		try {
			return rsMetaData.getColumnName(c + 1);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private ResultSet rsRegistros;
	
	private ResultSetMetaData rsMetaData;
	
}















