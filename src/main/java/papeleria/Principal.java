package papeleria;

import javax.swing.JFrame;

import papeleria.utils.Apariencia;
import papeleria.view.PanelArticulo;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Principal instance = null;
	
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static Principal getInstance() {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	/**
	 * Constructor.
	 */
	public Principal() {
		super("Gestión Papeleria - JPA");
		
		this.setBounds(100, 100, 600, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		PanelArticulo panelArticulo = new PanelArticulo();
		
		this.getContentPane().add(panelArticulo);
	}

	/**
	 * Método Principal.
	 * @param args
	 */
	public static void main(String[] args) {
		getInstance().setVisible(true);
	}

}
