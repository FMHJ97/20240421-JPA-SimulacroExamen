package papeleria.controladores;

import papeleria.entities.Proveedor;

public class ControladorProveedor extends SuperControladorJPA {

	private static ControladorProveedor instance = null;
	
	/**
	 * 
	 */
	public ControladorProveedor() {
		super("proveedor", Proveedor.class);
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorProveedor getInstance() {
		if (instance == null) {
			instance = new ControladorProveedor();
		}
		return instance;
	}

}
