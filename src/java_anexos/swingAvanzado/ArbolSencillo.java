package java_anexos.swingAvanzado;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ArbolSencillo {

	public static void main(String[] args) {

		JFrame marco = new MarcoArbol();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}

}


class MarcoArbol extends JFrame {
	
	public MarcoArbol() {
		setTitle("Arbol sencillo");
		
		setBounds(2000, 300, 600, 200);
		
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Mundo");
		
		DefaultMutableTreeNode pais = new DefaultMutableTreeNode("Ecuador");
		
		raiz.add(pais);
		
		DefaultMutableTreeNode provincia = new DefaultMutableTreeNode("Pichincha");
		
		pais.add(provincia);
		
		DefaultMutableTreeNode quito = new DefaultMutableTreeNode("Quito");
		
		DefaultMutableTreeNode cayambe = new DefaultMutableTreeNode("Cayambe");
		
		provincia.add(quito);
		
		provincia.add(cayambe);
		
		provincia = new DefaultMutableTreeNode("Manabi");
		
		DefaultMutableTreeNode portoviejo = new DefaultMutableTreeNode("Portoviejo");
		
		provincia.add(portoviejo);
		
		pais.add(provincia);
		
		//ALEMANIA 
		
		pais = new DefaultMutableTreeNode("Alemania");
		
		provincia = new DefaultMutableTreeNode("Baviera");
		
		DefaultMutableTreeNode munich = new DefaultMutableTreeNode("Munich");
		
		provincia.add(munich);
		
		pais.add(provincia);
		
		raiz.add(pais);
		
		JTree arbol = new JTree(raiz);
		
		//add(new LaminaArbol(arbol));
		
		Container laminaContenido = getContentPane();
		
		laminaContenido.add(new JScrollPane(arbol));
		
	}
}






