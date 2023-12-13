package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.x.Ok;

import entidad.Categorias;
import entidad.EstadoProducto;
import entidad.Productos;
import entidad.Proveedores;
import mantenimiento.GestionComboBoxDAO;
import mantenimiento.GestionProductoDAO;
import utils.Validaciones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class FrmProductos extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblTitulo;
	private JLabel lblCodigo;
	private JTextField txtCodigoProd;
	private JLabel lblDescripcion;
	private JTextField txtDescripcion;
	private JLabel lblCategoria;
	private JComboBox cboCategoria;
	private JLabel lblStock;
	private JTextField txtStock;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private JLabel lblProveedores;
	private JComboBox cboProveedor;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnNuevo;
	private JButton btnEliminar;
	private JTable tblProductos;
	private JScrollPane scrollPane;
	private JButton btnBuscar;

	
	
	//Instanciar el objeto para definir la estructura de la tabla
	DefaultTableModel model = new DefaultTableModel();
	
	//
	GestionComboBoxDAO gComb = new GestionComboBoxDAO();
	
	//
	GestionProductoDAO gProd = new GestionProductoDAO();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProductos frame = new FrmProductos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmProductos() {
		setClosable(true);
		setIconifiable(true);
		setTitle("DON TUERCAS S.A.C. - Mantenimiento Productos");
		setBounds(100, 100, 1089, 545);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Productos");
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setBounds(0, 23, 1077, 41);
		contentPane.add(lblTitulo);
		
		lblCodigo = new JLabel("Cod Producto:");
		lblCodigo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblCodigo.setBounds(10, 76, 115, 34);
		contentPane.add(lblCodigo);
		
		txtCodigoProd = new JTextField();
		txtCodigoProd.setColumns(10);
		txtCodigoProd.setBounds(118, 86, 95, 21);
		contentPane.add(txtCodigoProd);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblDescripcion.setBounds(10, 123, 108, 34);
		contentPane.add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(118, 127, 245, 21);
		contentPane.add(txtDescripcion);
		
		lblCategoria = new JLabel("Categoría:");
		lblCategoria.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblCategoria.setBounds(10, 167, 89, 34);
		contentPane.add(lblCategoria);
		
		cboCategoria = new JComboBox();
		cboCategoria.setBounds(118, 177, 245, 21);
		contentPane.add(cboCategoria);
		
		lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblStock.setBounds(10, 211, 89, 34);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(118, 221, 141, 21);
		contentPane.add(txtStock);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPrecio.setBounds(10, 258, 89, 34);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(118, 268, 141, 21);
		contentPane.add(txtPrecio);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblEstado.setBounds(10, 302, 89, 34);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(118, 312, 245, 21);
		contentPane.add(cboEstado);
		
		lblProveedores = new JLabel("Proveedor:");
		lblProveedores.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblProveedores.setBounds(10, 346, 97, 29);
		contentPane.add(lblProveedores);
		
		cboProveedor = new JComboBox();
		cboProveedor.setBounds(118, 353, 245, 21);
		contentPane.add(cboProveedor);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(this);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setOpaque(false);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setIcon(new ImageIcon(FrmProductos.class.getResource("/img/285657_floppy_guardar_save_icon.png")));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnGuardar.setBounds(137, 426, 33, 33);
		contentPane.add(btnGuardar);
		
		btnActualizar = new JButton("");
		btnActualizar.addActionListener(this);
		btnActualizar.setContentAreaFilled(false);
		btnActualizar.setOpaque(false);
		btnActualizar.setBorderPainted(false);
		btnActualizar.setIcon(new ImageIcon(FrmProductos.class.getResource("/img/46828_reload_refrsh_calculate_icon.png")));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnActualizar.setBounds(180, 426, 33, 33);
		contentPane.add(btnActualizar);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(this);
		btnNuevo.setContentAreaFilled(false);
		btnNuevo.setOpaque(false);
		btnNuevo.setBorderPainted(false);
		btnNuevo.setIcon(new ImageIcon(FrmProductos.class.getResource("/img/299068_add_sign_icon.png")));
		btnNuevo.setBounds(94, 426, 33, 33);
		contentPane.add(btnNuevo);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(this);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setOpaque(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setIcon(new ImageIcon(FrmProductos.class.getResource("/img/7549103_user_interface_remove_delete_trash_icon.png")));
		btnEliminar.setBounds(223, 426, 33, 33);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(373, 88, 692, 411);
		contentPane.add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.addMouseListener(this);
		tblProductos.addKeyListener(this);
		tblProductos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProductos);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(this);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setOpaque(false);
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setIcon(new ImageIcon(FrmProductos.class.getResource("/img/34229_find_magnifier_search_zoom_icon.png")));
		btnBuscar.setBounds(223, 84, 33, 33);
		contentPane.add(btnBuscar);
		
		// Determinar las columnas
		model.addColumn("Código");
		model.addColumn("Descripción");
		model.addColumn("Cod. Proveedor");
		model.addColumn("Stock");
		model.addColumn("Precio");
		model.addColumn("Cod. Categoria");
		model.addColumn("Cod. Estado");
		
		// Asignar
		tblProductos.setModel(model);
		
		// Cargar data de los comboBox
		cargarComboBoxProveedores();
		cargarComboBoxCategorias();
		cargarComboBoxEstados();
		
		// Generar codigo correlativo
		txtCodigoProd.setText(""+getCodigo());
		
		// Cargar data de la tabla Productos
		cargarData();
	}

	
	@SuppressWarnings("unchecked")
	private void cargarComboBoxEstados() {
		// Obtener la lista de Proveedores
		ArrayList<EstadoProducto> lista = gComb.listarEstadoProd();
		cboEstado.addItem("Seleccione");
		// Bucle
		for (EstadoProducto estado : lista) {
			cboEstado.addItem(estado.getCodEstado()+" - "+estado.getNombEstado());
		}
		
	}

	@SuppressWarnings("unchecked")
	private void cargarComboBoxCategorias() {
		// Obtener la lista de Proveedores
		ArrayList<Categorias> lista = gComb.listarCategorias();
		cboCategoria.addItem("Seleccione");
		// Bucle
		for (Categorias cate : lista) {
			cboCategoria.addItem(cate.getCodCategoria()+" - "+cate.getNombCategoria());
		}
		
	}

	@SuppressWarnings("unchecked")
	private void cargarComboBoxProveedores() {
		// Obtener la lista de Proveedores
		ArrayList<Proveedores> lista = gComb.listarProveedor();
		cboProveedor.addItem("Seleccione");
		// Bucle
		for (Proveedores prov : lista) {
			cboProveedor.addItem(prov.getCodigo()+" - "+prov.getRazonSocial());
		}
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		registrarDatos();
	}

	private void registrarDatos() {
		// Atributos
		String desc;
		int idProd, idProve, stock, cate, estado;
		double precio;
		
		// Entradas
		idProd = getCodigo();
		desc = getDescripcion();
		idProve = getProveedor();
		stock = getStock();
		precio = getPrecio();
		cate = getCategoria();
		estado = getEstado();
		
		// Controlar el ingreso de datos correctos en la tabla
		if(idProd == 0 || desc == null || idProve == 0 || stock == -1 || precio == -1 || cate == 0 || estado == 0) {
			return;
		}else {
			// crear un objeto de la clase libros
			Productos p = new Productos();
			// setear
			p.setIdProducto(idProd);
			p.setDescripcion(desc);
			p.setProveedores(idProve);
			p.setStock(stock);
			p.setPrecio(precio);
			p.setIdCategoria(cate);
			p.setEstadoProd(estado);
			
			// Invocar el resultado del metodo
			int res = gProd.registrar(p);
			
			// Validar el resultado del metodo
			if(res == 0)
				mensajeError("Error en el registro");
			else {
				mensajeExito("Registro Exitoso");
				cargarData();
			}
		}
	}

	
    private int getCodigo() {		
		return gProd.generarCodigoProd();
	}

	// 1: Mensaje Error
 	private void mensajeError(String msj) {
 		JOptionPane.showMessageDialog(this, msj, "Error !!", 0);		
 	}
 	// 2: Mensaje Exito
 	private void mensajeExito(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Sistema", 1);
		
	}

	private String getDescripcion() {
		String desc = null;
		// validar caja de texto vacia
		if (txtDescripcion.getText().trim().length() == 0) {
			mensajeError("Ingresar descripcion del Producto");
			txtDescripcion.requestFocus();			
		} else if (txtDescripcion.getText().trim().matches(Validaciones.TEXTO)) {
			desc = txtDescripcion.getText().trim();
		} else {
			mensajeError("Formato de la descripcion no valido !!");
			txtDescripcion.setText("");
			txtDescripcion.requestFocus();
		} 

		return desc;
	}

	private int getProveedor() {
		int idprove;
		idprove = cboProveedor.getSelectedIndex();
		if(idprove == 0) {
			mensajeError("Seleccione el Proveedor");
		}
		return idprove;
	}

	private int getStock() {
		int stock = -1;
		if(txtStock.getText().trim().length() == 0) {
			mensajeError("Ingrese la cantidad de Stock");
			txtStock.requestFocus();
		}else {
			try {
				stock = Integer.parseInt(txtStock.getText());
				// Validar valores menores o iguales a 0
				if(stock <= 0) {
					mensajeError("Ingrese valores númericos mayores a 0");
					txtStock.setText("");
					txtStock.requestFocus();
					stock = -1;
				} // Validar que solo se ingresen valores con formato numerico				
			} catch (NumberFormatException e) {
				mensajeError("Ingrese solo valores númericos");
				txtStock.setText("");
				txtStock.requestFocus();
			}
		}		
		return stock;
	}

	private double getPrecio() {
		double precio = -1;
		if(txtPrecio.getText().trim().length() == 0) {
			mensajeError("Ingrese el precio de los productos");
			txtPrecio.requestFocus();
		}else {
			try {
				precio = Double.parseDouble(txtPrecio.getText());
				// Validar valores menores o iguales a 0
				if(precio <= 0) {
					mensajeError("Ingrese valores númericos mayores a 0");
					txtPrecio.setText("");
					txtPrecio.requestFocus();
					precio = -1;
				} // Validar que solo se ingresen valores con formato numerico				
			} catch (NumberFormatException e) {
				mensajeError("Ingrese solo valores númericos");
				txtPrecio.setText("");
				txtPrecio.requestFocus();
			}
		}
			
		return precio;
	}

	private int getCategoria() {
		int cate;
		cate = cboCategoria.getSelectedIndex();
		if(cate == 0) {
			mensajeError("Seleccione categoria del producto");
		}
		return cate;
	}

	private int getEstado() {
		int estado;
		estado = cboEstado.getSelectedIndex();
		if(estado == 0) {
			mensajeError("Selecione estado del producto");
		}
		return estado;
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarProducto();
	}

	private void actualizarProducto() {
		// Variables
		String desc;
		int idProd, idProve, stock, cate, estado;
		double precio; 
		
		// Obtener los datos de la GUI
		idProd = getCodigoActu();
		desc = getDescripcion();
		idProve = getProveedor();
		stock = getStock();
		precio = getPrecio();
		cate = getCategoria();
		estado = getEstado();
		
		// Validaciones
		if(idProd == 0 || desc == null || idProve == 0 || stock == -1 || precio == -1 || cate == 0 || estado == 0) {
			return;
		}else {
		// crear un objeto del tipo productos
		Productos p = new Productos();
		
		// Setear 
		p.setDescripcion(desc);
		p.setProveedores(idProve);
		p.setStock(stock);
		p.setPrecio(precio);
		p.setIdCategoria(cate);
		p.setEstadoProd(estado);
		p.setIdProducto(idProd);
		
		// Invocar el resultado del metodo
		int res = gProd.actualizar(p);
		
		// Validar el resultado del proceso actualizar
		if(res == 0)
			mensajeError("Error en la actualizacion");
		else {
			mensajeExito("Producto Actualizado");
			cargarData();
		}		
	  }	
	}

	
	// Método para obtener el codigo y actualizar el producto
	private int getCodigoActu() {
		int idProd = 0;
		if(txtCodigoProd.getText().trim().length() == 0) {
			mensajeError("Ingresar el código de los productos");
			txtCodigoProd.requestFocus();
		}else if(txtCodigoProd.getText().trim().matches(Validaciones.Codigo)){
			idProd = Integer.parseInt(txtCodigoProd.getText());
		}else {
			mensajeError("Formato del codigo Incorrecto");
			txtCodigoProd.setText("");
			txtCodigoProd.requestFocus();
		}
		
		return idProd;
	}  
	
	
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarProductos();
	}

	private void eliminarProductos() {
		int cod;
		
		// obtener el codigo ingresado en la GUI
		cod = getCodigoActu();
		
		// validar 
		if(cod == -1) {
			return;
		}else {
			// Mensaje de confirmacion
		int boton = JOptionPane.showConfirmDialog(this, "Seguro de eliminar","Sistema",JOptionPane.YES_NO_OPTION);
			if(boton == 0) { // SI ---> 0 / NO ---> 1 / CANCELAR ---> 2 
				int ok = gProd.eliminar(cod);
				// validar el resultado del proceso eliminar
				if(ok == 0) {
					mensajeError("Código no existe");
				}else {
					mensajeExito("Producto Eliminado");
					cargarData();
				}
			}
		}
	}
	
	
	
	
	
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarProductoPorCodigo();
	}

	private void buscarProductoPorCodigo() {
		int cod;
		Productos prod;
		// Obtenemos los valores de la GUI
		cod = getCodigoActu();
		
		prod = gProd.buscarProducto(cod);
		
		// validar el resultado
		if(prod == null) {
			mensajeError("Codigo no existe");
		}else {txtDescripcion.setText(prod.getDescripcion());
			   cboProveedor.setSelectedIndex(prod.getProveedores());
			   txtStock.setText(""+prod.getStock());
			   txtPrecio.setText(""+prod.getPrecio());
			   cboCategoria.setSelectedIndex(prod.getIdCategoria());
			   cboEstado.setSelectedIndex(prod.getEstadoProd());
		}
	}
	
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		
		// Limpiar 
		txtCodigoProd.setText("");
		txtDescripcion.setText("");
		cboProveedor.setSelectedIndex(0);
		txtStock.setText("");
		txtPrecio.setText("");
		cboCategoria.setSelectedIndex(0);
		cboEstado.setSelectedIndex(0);
		
		// llamar al codigo autogenerado
		txtCodigoProd.setText(""+getCodigo());
		txtDescripcion.requestFocus();
	}
	
	private void cargarData() {
		// limpiar la tabla
		model.setRowCount(0);
		
		//
		ArrayList<Productos> lista = gProd.listarProductos();
		
		// Validar
		if(lista.size() == 0) {
			mensajeError("Lista Vacia");
		}else {
			//Bucle
			for (Productos prod : lista) {
				Object fila [] = {prod.getIdProducto(),
								  prod.getDescripcion(),
								  prod.getProveedores(),
								  prod.getStock(),
								  prod.getPrecio(),
								  prod.getIdCategoria(),
								  prod.getEstadoProd()
								  };
				model.addRow(fila);
			}
		}
	}
	
	
	
	
	
	
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblProductos) {
			keyReleasedTblProductos(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblProductos(KeyEvent e) {
		int posFila;
		posFila = tblProductos.getSelectedRow();
		
		// Mostrar datos
		mostrarData(posFila);
	}

	private void mostrarData(int posFila) {
		// Variables
		String cod, desc, stock, precio;
		int prov, cate, estado;
		
		// Obtener los datos de la tabla
		cod = tblProductos.getValueAt(posFila, 0).toString();
		desc = tblProductos.getValueAt(posFila, 1).toString();
		prov = tblProductos.getValueAt(posFila, 2).hashCode();
		stock = tblProductos.getValueAt(posFila, 3).toString();
		precio = tblProductos.getValueAt(posFila, 4).toString();
		cate = tblProductos.getValueAt(posFila, 5).hashCode();
		estado = tblProductos.getValueAt(posFila, 6).hashCode();
		
		// Enviar los datos obtenidos a las cajas de texto
		txtCodigoProd.setText(cod);
		txtDescripcion.setText(desc);
		cboProveedor.setSelectedIndex(prov);
		txtStock.setText(stock);
		txtPrecio.setText(precio);
		cboCategoria.setSelectedIndex(cate);
		cboEstado.setSelectedIndex(estado);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblProductos) {
			mouseClickedTblProductos(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblProductos(MouseEvent e) {
		int posFila;
		posFila = tblProductos.getSelectedRow();
		
		// Mostrar datos
		mostrarData(posFila);
	}
}
