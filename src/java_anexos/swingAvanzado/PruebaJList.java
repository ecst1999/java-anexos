package java_anexos.swingAvanzado;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PruebaJList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame marco = new MarcoDeLista();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}

class MarcoDeLista extends JFrame {
	
	public MarcoDeLista() {
		setTitle("Prueba de lista");
		
		setBounds(400, 300, 400, 300);
		
		String[] meses = {
	            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
	            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
	        };
		
		listaMeses = new JList<String>(meses);
		
		listaMeses.setVisibleRowCount(4);
		
		JScrollPane barraDesplazamiento = new JScrollPane(listaMeses);
		
		laminaDeLista = new JPanel();
		
		laminaDeLista.add(barraDesplazamiento);
		
		
		listaMeses.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				List<String> valores = listaMeses.getSelectedValuesList();
				
				StringBuilder texto = new StringBuilder("Mes seleccionado: ");
				
				for(String elm: valores) {
					String palabra = elm;
					
					texto.append(palabra);
					texto.append(" ");
				}
				
				rotulo.setText(texto.toString());
			}
		});
		
		
		laminaDeTexto = new JPanel();
		
		rotulo = new JLabel("Mes seleccionado: ");
		
		laminaDeTexto.add(rotulo);
		
		add(laminaDeLista, BorderLayout.NORTH);
		
		add(laminaDeTexto, BorderLayout.SOUTH);
	}
	
	private JList<String> listaMeses;
	
	private JPanel laminaDeLista, laminaDeTexto;
	
	private JLabel rotulo;
}