package papeleria.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;

import papeleria.controladores.ControladorArticulo;
import papeleria.controladores.ControladorProveedor;
import papeleria.entities.Articulo;
import papeleria.entities.Proveedor;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelArticulo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfCodigo;
	private JTextField jtfDescripcion;
	private JTextField jtfColor;
	private JTextField jtfStock;
	private JTextField jtfPrecio;
	JComboBox<Proveedor> jcbProveedor;
	
	// Variable para poder gestionar el PanelArticulo.
	private JPanel panelArt;
	
	// El componente JColorChooser y el color a aplicar.
	private JColorChooser jColorChooser;
	private Color colorPanel;

	/**
	 * Create the panel.
	 */
	public PanelArticulo() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showFirst();
			}
		});
		btnFirst.setIcon(new ImageIcon(PanelArticulo.class.getResource("/papeleria/res/gotostart.png")));
		toolBar.add(btnFirst);
		
		JButton btnPrevious = new JButton("");
		btnPrevious.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showPrevious();
			}
		});
		btnPrevious.setIcon(new ImageIcon(PanelArticulo.class.getResource("/papeleria/res/previous.png")));
		toolBar.add(btnPrevious);
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showNext();
			}
		});
		btnNext.setIcon(new ImageIcon(PanelArticulo.class.getResource("/papeleria/res/next.png")));
		toolBar.add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showLast();
			}
		});
		btnLast.setIcon(new ImageIcon(PanelArticulo.class.getResource("/papeleria/res/gotoend.png")));
		toolBar.add(btnLast);
		
		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newArticulo();
			}
		});
		btnNew.setIcon(new ImageIcon(PanelArticulo.class.getResource("/papeleria/res/nuevo.png")));
		toolBar.add(btnNew);
		
		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveArticulo();
			}
		});
		btnSave.setIcon(new ImageIcon(PanelArticulo.class.getResource("/papeleria/res/guardar.png")));
		toolBar.add(btnSave);
		
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteArticulo();
			}
		});
		btnDelete.setIcon(new ImageIcon(PanelArticulo.class.getResource("/papeleria/res/eliminar.png")));
		toolBar.add(btnDelete);
		
		panelArt = new JPanel();
		add(panelArt, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelArt.setLayout(gbl_panel);
		
		JLabel lblTitle = new JLabel("Gestión de Items de Papelería");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 4;
		gbc_lblTitle.insets = new Insets(10, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		panelArt.add(lblTitle, gbc_lblTitle);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		panelArt.add(lblId, gbc_lblId);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		jtfId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panelArt.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 2;
		panelArt.add(lblCdigo, gbc_lblCdigo);
		
		jtfCodigo = new JTextField();
		jtfCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfCodigo.setColumns(10);
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 2;
		panelArt.add(jtfCodigo, gbc_jtfCodigo);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 3;
		panelArt.add(lblDescripcin, gbc_lblDescripcin);
		
		jtfDescripcion = new JTextField();
		jtfDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfDescripcion.setColumns(10);
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 2;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 3;
		panelArt.add(jtfDescripcion, gbc_jtfDescripcion);
		
		JLabel lblUnidadesEnStock = new JLabel("Unidades en stock:");
		lblUnidadesEnStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblUnidadesEnStock = new GridBagConstraints();
		gbc_lblUnidadesEnStock.anchor = GridBagConstraints.EAST;
		gbc_lblUnidadesEnStock.insets = new Insets(0, 5, 5, 5);
		gbc_lblUnidadesEnStock.gridx = 0;
		gbc_lblUnidadesEnStock.gridy = 4;
		panelArt.add(lblUnidadesEnStock, gbc_lblUnidadesEnStock);
		
		jtfStock = new JTextField();
		jtfStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfStock.setColumns(10);
		GridBagConstraints gbc_jtfStock = new GridBagConstraints();
		gbc_jtfStock.insets = new Insets(0, 0, 5, 5);
		gbc_jtfStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfStock.gridx = 1;
		gbc_jtfStock.gridy = 4;
		panelArt.add(jtfStock, gbc_jtfStock);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 5;
		panelArt.add(lblPrecio, gbc_lblPrecio);
		
		jtfPrecio = new JTextField();
		jtfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfPrecio.setColumns(10);
		GridBagConstraints gbc_jtfPrecio = new GridBagConstraints();
		gbc_jtfPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrecio.gridx = 1;
		gbc_jtfPrecio.gridy = 5;
		panelArt.add(jtfPrecio, gbc_jtfPrecio);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 6;
		panelArt.add(lblColor, gbc_lblColor);
		
		jtfColor = new JTextField();
		jtfColor.setEnabled(false);
		jtfColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfColor.setColumns(10);
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 6;
		panelArt.add(jtfColor, gbc_jtfColor);
		
		JButton btnSeleccionaUnColor = new JButton("Selecciona un Color");
		btnSeleccionaUnColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chooseColor();
			}
		});
		btnSeleccionaUnColor.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnSeleccionaUnColor = new GridBagConstraints();
		gbc_btnSeleccionaUnColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeleccionaUnColor.gridx = 2;
		gbc_btnSeleccionaUnColor.gridy = 6;
		panelArt.add(btnSeleccionaUnColor, gbc_btnSeleccionaUnColor);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblProveedor = new GridBagConstraints();
		gbc_lblProveedor.anchor = GridBagConstraints.EAST;
		gbc_lblProveedor.insets = new Insets(0, 0, 0, 5);
		gbc_lblProveedor.gridx = 0;
		gbc_lblProveedor.gridy = 7;
		panelArt.add(lblProveedor, gbc_lblProveedor);
		
		jcbProveedor = new JComboBox<Proveedor>();
		jcbProveedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_jcbProveedor = new GridBagConstraints();
		gbc_jcbProveedor.insets = new Insets(0, 0, 0, 5);
		gbc_jcbProveedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProveedor.gridx = 1;
		gbc_jcbProveedor.gridy = 7;
		panelArt.add(jcbProveedor, gbc_jcbProveedor);
		
		JButton btnProveedor = new JButton("Gestión Proveedor");
		btnProveedor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showJDialogProveedor();
			}
		});
		btnProveedor.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnProveedor = new GridBagConstraints();
		gbc_btnProveedor.gridx = 2;
		gbc_btnProveedor.gridy = 7;
		panelArt.add(btnProveedor, gbc_btnProveedor);

		// Precarga de Datos.
		loadAllProveedores();
		showFirst();
	}
	
	/**
	 * 
	 * @param panel
	 */
	private void showJDialogProveedor() {
		int idActual = Integer.parseInt(this.jtfId.getText());
		
		JDialog dialogo = new JDialog();
		// El usuario no puede redimensionar el diálogo
		dialogo.setResizable(true);
		// título del díalogo
		dialogo.setTitle("JDialog - Gestión Proveedor");
		// Introducimos el panel creado sobre el diálogo.
		dialogo.setContentPane(new PanelProveedor(idActual));
		// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
		dialogo.pack();
		// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
		dialogo.setModal(true);
		// Centro el di�logo en pantalla
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		// Muestro el di�logo en pantalla
		dialogo.setVisible(true);
	}
	
	/**
	 * 
	 */
	private void chooseColor() {
		this.colorPanel = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (this.colorPanel != null) {
			String strColor = "#"+Integer.toHexString(this.colorPanel.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			this.panelArt.setBackground(this.colorPanel);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isStockValid() {
		String strStock = this.jtfStock.getText();
		
		try {
			Integer.parseInt(strStock);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isPrecioValid() {
		String strPrecio = this.jtfPrecio.getText();
		
		try {
			Float.parseFloat(strPrecio);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isDescripcionValid() {
		String strDescrip = this.jtfDescripcion.getText();
		
		if (strDescrip.matches(".{6,}")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Codigo debe tener mínimo 6 números.
	 * @return
	 */
	private boolean isCodigoValid() {
		String strCodigo = this.jtfCodigo.getText();
		
		if (strCodigo.matches("[0-9]{6,}")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 */
	private void saveArticulo() {
		
		/// VALIDACION CONDICIONES ///
		if (!isCodigoValid()) {
			JOptionPane.showMessageDialog(null,
					"Error. El código debe tener una longitud mínima de 6 NÚMEROS");
			return;
		}
		
		if (!isDescripcionValid()) {
			JOptionPane.showMessageDialog(null,
					"Error. La descripción debe tener una longitud mínima "
					+ "de 6 caracteres cualesquiera");
			return;
		}
		
		if (!isPrecioValid()) {
			JOptionPane.showMessageDialog(null,
					"Error. El precio debe ser un número (float)");
			return;
		}
		
		if (!isStockValid()) {
			JOptionPane.showMessageDialog(null,
					"Error. El stock debe ser un número entero (int)");
			return;
		}
		
		/// PROCESO DE GUARDADO ///
		Articulo a = new Articulo();
		
		a.setCodigo(this.jtfCodigo.getText());
		a.setDescripcion(this.jtfDescripcion.getText());
		a.setStock(Integer.parseInt(this.jtfStock.getText()));
		a.setPrecio(Float.parseFloat(this.jtfPrecio.getText()));
		
		// Guardamos el color.
		if (!this.jtfColor.getText().trim().equals("")) {
			a.setColor(this.jtfColor.getText());
		} else {
			a.setColor(null);
		}
		
		// Como el item seleccionado del comboBox es tipo Object, realizamos
		// un casteo TipologiaSexo para obtener un objeto TipologiaSexo.
		// A continuación, obtenemos el id TipologiaSexo respectivo.
		int idProveedor = ((Proveedor) this.jcbProveedor.getSelectedItem()).getId();
		a.setIdProveedor(idProveedor);
		
		// Comprobamos si debemos hacer un insert o update.
		String str = this.jtfId.getText();
		if (!str.trim().equals("")) {
			a.setId(Integer.parseInt(str));
			ControladorArticulo.getInstance().updateArticulo(a);
		} else {
			ControladorArticulo.getInstance().insertArticulo(a);
			showArticulo(a);
		}
	}
	
	/**
	 * 
	 */
	private void deleteArticulo() {
		String respuestas[] = new String[] { "Sí", "No" };
		int opcionElegida = JOptionPane.showOptionDialog(null,
				"¿Realmente desea eliminar el artículo?",
				"Eliminación de Artículo", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null,
				respuestas, respuestas[1]);
		
		// Puntero para seleccionar el posible siguiente o anterior
		// registro a mostrar.
		Articulo actual = null;

		if (opcionElegida == 0) {	// Si la opción es 0 (= Si).
			
			String str = this.jtfId.getText();
			if (!str.trim().equals("")) {
				int idActual = Integer.parseInt(str);
				ControladorArticulo.getInstance()
					.deleteArticulo(idActual);
				
				// A continuación, mostraremos en pantalla el registro
				// siguiente.
				actual = (Articulo) ControladorArticulo
						.getInstance().findNext(idActual);
				
				// Si hay registro, es decir, el registro borrado es
				// ocupado por su siguiente registro (id).
				if (actual != null) {
					showArticulo(actual);
				} else {
					// Si hay no registro, miramos si hay registro anterior
					// al registro borrado.
					actual = (Articulo) ControladorArticulo
							.getInstance().findPrevious(idActual);
					if (actual != null) {
						showArticulo(actual);
					} else {
						// Llegados a este punto, no hay registros previos
						// ni posteriores.
						newArticulo();
					}
					
				}
			}
		}
	}
	
	/**
	 * 
	 */
	private void newArticulo() {
		this.jtfId.setText("");
		this.jtfCodigo.setText("");
		this.jtfDescripcion.setText("");
		this.jtfStock.setText("");
		this.jtfPrecio.setText("");
		this.jtfColor.setText("");
		this.panelArt.setBackground(null);
		this.jcbProveedor.setSelectedIndex(0);
	}
	
	/**
	 * 
	 */
	private void showNext() {
		String str = this.jtfId.getText();
		if (!str.trim().equals("")) {
			int idArticulo = Integer.parseInt(str);
			Articulo a = (Articulo) ControladorArticulo
					.getInstance().findNext(idArticulo);
			showArticulo(a);
		}
	}
	
	/**
	 * 
	 */
	private void showPrevious() {
		String str = this.jtfId.getText();
		if (!str.trim().equals("")) {
			int idArticulo = Integer.parseInt(str);
			Articulo a = (Articulo) ControladorArticulo
					.getInstance().findPrevious(idArticulo);
			showArticulo(a);
		}
	}
	
	/**
	 * 
	 */
	private void showLast() {
		Articulo a = (Articulo) ControladorArticulo
				.getInstance().findLast();
		showArticulo(a);
	}
	
	/**
	 * 
	 */
	private void showFirst() {
		Articulo a = (Articulo) ControladorArticulo
				.getInstance().findFirst();
		showArticulo(a);
	}
	
	/**
	 * 
	 * @param a
	 */
	private void showArticulo(Articulo a) {
		if (a != null) {
			this.jtfId.setText("" + a.getId());
			this.jtfCodigo.setText(a.getCodigo());
			this.jtfDescripcion.setText(a.getDescripcion());
			this.jtfStock.setText("" + a.getStock());
			this.jtfPrecio.setText("" + a.getPrecio());
			this.jtfColor.setText(a.getColor());
			
			// Seleccionamos al respectivo proveedor.
			for (int i = 0; i < this.jcbProveedor.getItemCount(); i++) {
				if (this.jcbProveedor.getItemAt(i).getId() == a.getId()) {
					this.jcbProveedor.setSelectedIndex(i);
				}
			}
			
			// Pintamos el panel del color del registro actual.
			try {
				if (a.getColor() != null) {
					Color color = Color.decode(a.getColor());
					this.panelArt.setBackground(color);
				} else {
					this.panelArt.setBackground(null);
					jtfColor.setText("");
				}
			} catch (NumberFormatException e) {
				this.panelArt.setBackground(null);
				jtfColor.setText("");
			}
		}
	}
	
	/**
	 * Método que carga TODOS los proveedores de la BBDD al JComboBox.
	 */
	private void loadAllProveedores() {
		List<Proveedor> proveedores = (List<Proveedor>) ControladorProveedor
				.getInstance().findAll();
		
		for (Proveedor proveedor : proveedores) {
			this.jcbProveedor.addItem(proveedor);
		}
	}

}
