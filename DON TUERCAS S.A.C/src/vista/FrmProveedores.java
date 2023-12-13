package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Proveedores;
import mantenimiento.GestionProveedoresDAO;
import utils.Validaciones;

public class FrmProveedores extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblMantenimientoDeProveedores;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JButton btnBuscar;
	private JLabel lblRazSocial;
	private JTextField txtRazSocial;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JLabel lblRuc;
	private JTextField txtRuc;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JTable tblProveedores;
	private JScrollPane scrollPane;

	// Instanciar objeto para definir la estructura de la tabla
	DefaultTableModel model = new DefaultTableModel();
	
	// 
	GestionProveedoresDAO gProve = new GestionProveedoresDAO();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProveedores frame = new FrmProveedores();
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
	public FrmProveedores() {
		setTitle("DON TUERCAS S.A.C.  -  Mantenimiento de Proveedores");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 753, 618);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMantenimientoDeProveedores = new JLabel("Mantenimiento de Proveedores");
		lblMantenimientoDeProveedores.setOpaque(true);
		lblMantenimientoDeProveedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeProveedores.setForeground(Color.WHITE);
		lblMantenimientoDeProveedores.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblMantenimientoDeProveedores.setBackground(Color.BLACK);
		lblMantenimientoDeProveedores.setBounds(0, 10, 739, 47);
		contentPane.add(lblMantenimientoDeProveedores);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblCodigo.setBounds(32, 76, 80, 20);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(32, 96, 96, 20);
		contentPane.add(txtCodigo);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(FrmProveedores.class.getResource("/img/34229_find_magnifier_search_zoom_icon.png")));
		btnBuscar.setOpaque(false);
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBounds(138, 84, 32, 32);
		contentPane.add(btnBuscar);
		
		lblRazSocial = new JLabel("Razon Social");
		lblRazSocial.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblRazSocial.setBounds(36, 126, 114, 21);
		contentPane.add(lblRazSocial);
		
		txtRazSocial = new JTextField();
		txtRazSocial.setColumns(10);
		txtRazSocial.setBounds(32, 147, 308, 20);
		contentPane.add(txtRazSocial);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblDireccion.setBounds(32, 177, 80, 19);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(32, 196, 308, 20);
		contentPane.add(txtDireccion);
		
		lblRuc = new JLabel("Ruc");
		lblRuc.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblRuc.setBounds(384, 76, 80, 21);
		contentPane.add(lblRuc);
		
		txtRuc = new JTextField();
		txtRuc.setColumns(10);
		txtRuc.setBounds(384, 96, 146, 20);
		contentPane.add(txtRuc);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTelefono.setBounds(384, 127, 80, 19);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(384, 147, 146, 20);
		contentPane.add(txtTelefono);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblCorreo.setBounds(384, 176, 80, 20);
		contentPane.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(384, 196, 195, 20);
		contentPane.add(txtCorreo);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FrmProveedores.class.getResource("/img/299068_add_sign_icon.png")));
		btnNuevo.setOpaque(false);
		btnNuevo.setContentAreaFilled(false);
		btnNuevo.setBorderPainted(false);
		btnNuevo.setBounds(571, 226, 32, 32);
		contentPane.add(btnNuevo);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(new ImageIcon(FrmProveedores.class.getResource("/img/285657_floppy_guardar_save_icon.png")));
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setBounds(613, 226, 32, 32);
		contentPane.add(btnGuardar);
		
		btnActualizar = new JButton("");
		btnActualizar.addActionListener(this);
		btnActualizar.setIcon(new ImageIcon(FrmProveedores.class.getResource("/img/46828_reload_refrsh_calculate_icon.png")));
		btnActualizar.setOpaque(false);
		btnActualizar.setContentAreaFilled(false);
		btnActualizar.setBorderPainted(false);
		btnActualizar.setBounds(655, 226, 32, 32);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(FrmProveedores.class.getResource("/img/7549103_user_interface_remove_delete_trash_icon.png")));
		btnEliminar.setOpaque(false);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBounds(697, 226, 32, 32);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 262, 719, 312);
		contentPane.add(scrollPane);
		
		tblProveedores = new JTable();
		tblProveedores.addMouseListener(this);
		tblProveedores.addKeyListener(this);
		scrollPane.setViewportView(tblProveedores);
		tblProveedores.setFillsViewportHeight(true);
		
		// Asignar columnas
		model.addColumn("Código");
		model.addColumn("Raz. Social");
		model.addColumn("Ruc");
		model.addColumn("Teléfono");
		model.addColumn("Dirección");
		model.addColumn("Correo");
		
		// Asignar modelo a la tabla
		tblProveedores.setModel(model);
		
		// Generar el codigo automatico
		txtCodigo.setText(""+getCodigoAuto());
		
		// Cargar data
		cargarData();
		
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
		// Variables
		String razSocial, direc, correo;
		int cod, ruc, telf;
		
		// Entradas
		cod = getCodigoAuto();
		razSocial = getRazSocial();
		ruc = getRuc();
		telf = getTelefono();
		direc = getDireccion();
		correo = getCorreo();
		
		// Controlar el ingreso de datos correctos en la tabla
		if(cod == 0 || razSocial == null || ruc == 0 || telf == 0 || direc == null || correo == null) {
			return;
		}else {
			// Crear un objeto de la clase proveedores
			Proveedores p = new Proveedores();
			
			// setear 
			p.setCodigo(cod);
			p.setRazonSocial(razSocial);
			p.setRuc(ruc);
			p.setTelefono(telf);
			p.setDireccion(direc);
			p.setCorreo(correo);
			
			// Invocar al método registrar
			int res = gProve.registrar(p);
			
			// Validar el resultado del método
			if(res == 0)
				mensajeError("Error en el registro");
			else {
				mensajeExito("Registro Exitoso");
				cargarData();
			}
		}
	}
	
	private int getCodigoAuto() {
		return gProve.generarCodigoProve();
	}

	private int getCodigo() {
		int codigo = 0;
		if(txtCodigo.getText().trim().length()==0) {
			mensajeError("Ingresar codigo del proveedor");
			txtCodigo.requestFocus();
		}
		else if (txtCodigo.getText().trim().matches(Validaciones.Codigo)) {
			codigo=Integer.parseInt(txtCodigo.getText().trim());
		}else {
			mensajeError("Formato incorrecto de codigo");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		}
		
		return codigo;
	}

	private String getRazSocial() {
		String razSocial = null;
		if(txtRazSocial.getText().trim().length() == 0) {
			mensajeError("Ingresar la Raz. Social del proveedor");
			txtRazSocial.requestFocus();
		}else if(txtRazSocial.getText().trim().matches(Validaciones.RazonSocial)) {
			razSocial = txtRazSocial.getText().trim();
		}else {
			mensajeError("Ingresar solo Texto");
			txtRazSocial.setText("");
			txtRazSocial.requestFocus();
		}
		return razSocial;
	}

	private int getRuc() {		
		int ruc= 0;
		if(txtRuc.getText().trim().length()==0) {
			mensajeError("Ingresar Ruc del proveedor");
			txtRuc.requestFocus();
		}
		else if (txtRuc.getText().trim().matches(Validaciones.RUC)) {
			ruc=Integer.parseInt(txtRuc.getText().trim());
		}else {
			mensajeError("Formato incorrecto de RUC");
			txtRuc.setText("");
			txtRuc.requestFocus();
		}
		return ruc;
	}

	private int getTelefono() {
		int telefono= 0;
		if(txtTelefono.getText().trim().length()==0) {
			mensajeError("Ingresar Telefono del proveedor");
			txtTelefono.requestFocus();
		}
		else if (txtTelefono.getText().trim().matches(Validaciones.Telefono)) {
			telefono=Integer.parseInt(txtTelefono.getText().trim());
		}else {
			mensajeError("Formato incorrecto de telefono, ingresar 9 números Ej. 962537465");
			txtTelefono.setText("");
			txtTelefono.requestFocus();
		}
		return telefono;
	}

	private String getDireccion() {
		String direccion= null;
		if(txtDireccion.getText().trim().length()==0) {
			mensajeError("Ingresar Direccion");
			txtDireccion.requestFocus();
		}
		else if (txtDireccion.getText().trim().matches(Validaciones.Direccion)) {
			direccion=txtDireccion.getText().trim();
		}else {
			mensajeError("Formato incorrecto de direccion, ingresar de 3 a 80 letras");
			txtDireccion.setText("");
			txtDireccion.requestFocus();
		}
		return direccion;
	}

	private String getCorreo() {
		String correo= null;
		if(txtCorreo.getText().trim().length()==0) {
			mensajeError("Ingresar correo del proveedor");
			txtCorreo.requestFocus();
		}
		else if (txtCorreo.getText().trim().matches(Validaciones.Correo)) {
			correo=txtCorreo.getText().trim();
		}else {
			mensajeError("Formato incorrecto del correo");
			txtCorreo.setText("");
			txtCorreo.requestFocus();
		}
		return correo;
	}

	// 1: Mensaje Error
	private void mensajeError(String msj) {
	JOptionPane.showMessageDialog(this, msj, "Error !!", 0);		
	}
	
	// 2: Mensaje Exito
	private void mensajeExito(String msj) {
	JOptionPane.showMessageDialog(this, msj,"Sistema", 1);			
	}
	
	
	
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarProveedores();
	}

	private void actualizarProveedores() {
		// Variables
		String razSocial, direc, correo;
		int cod, ruc, telf;
				
		// Entradas
		cod = getCodigo();
		razSocial = getRazSocial();
		ruc = getRuc();
		telf = getTelefono();
		direc = getDireccion();
		correo = getCorreo();
		
		// Validaciones
		if(cod == 0 || razSocial == null || ruc == 0 || telf == 0 || direc == null || correo == null) {
			return;
		}else {
		// Crear un objeto de la clase proveedores
		Proveedores p = new Proveedores();
						
		// setear 
		p.setCodigo(cod);
		p.setRazonSocial(razSocial);
		p.setRuc(ruc);
		p.setTelefono(telf);
		p.setDireccion(direc);
		p.setCorreo(correo);
		
		// Proceso de actualizacion
		int ok = gProve.actualizar(p);
		
		// Validar el resultado del proceso actualizar
		if(ok == 0) {
			mensajeError("Error en la Actualización");
		}else {
			mensajeExito("Proveedor Actualizado");
			cargarData();
		}
		}
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarProveedor();
	}

	private void eliminarProveedor() {
		
		int codigo;
		
		// Obtener el codigo ingresado en la GUI
		codigo = getCodigo();
		
		//Validar
		if(codigo == 0) {
			return;
		}else {
			// Mensaje de confirmacion
		int boton = JOptionPane.showConfirmDialog(this, "Seguro de eliminar?","Sistema", JOptionPane.YES_NO_OPTION);
			if(boton == 0){ // SI ---> 0 / NO ---> 1 / CANCELAR ---> 2 
				// proceso eliminar
				int ok = gProve.eliminar(codigo);
				// Validar el resultado del proceso eliminar
				if(ok == 0) {
				mensajeError("Código no existe");
				}else {
				mensajeExito("Proveedor Eliminado");
				cargarData();
				}
			}
		}
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarProveedorPorCodigo();
	}

	private void buscarProveedorPorCodigo() {
		int codigo;
		Proveedores prov;
		
		// Obtener los valores de la GUI
		codigo = getCodigo();
		prov = gProve.buscarProveedores(codigo);
		
		// Validar el resultado
		if(prov == null) {
			mensajeError("Código no existe");
		}else {
			txtRazSocial.setText(prov.getRazonSocial());
			txtRuc.setText(""+prov.getRuc());
			txtTelefono.setText(""+prov.getTelefono());
			txtDireccion.setText(prov.getDireccion());
			txtCorreo.setText(prov.getCorreo());
		}
		
	}
	
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		// Limpiar
		txtCodigo.setText("");
		txtRazSocial.setText("");
		txtRuc.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		txtCorreo.setText("");
		
		// Llamar al codigo autogenerado
		txtCodigo.setText(""+getCodigoAuto());
		
		// Fijar el cursor en la caja de texto Raz. Social
		txtRazSocial.requestFocus();
	}
	
	private void cargarData() {
		// Limpiar la tabla
		model.setRowCount(0);
				
		// 
		ArrayList<Proveedores> lista = gProve.listarProveedores();
				
		// Validar
		if(lista.size() == 0) {
			mensajeError("Lista Vacia");
		}else {// Bucle
			for (Proveedores prov : lista) {
				Object fila [] = {prov.getCodigo(),
								  prov.getRazonSocial(),
								  prov.getRuc(),
								  prov.getTelefono(),
								  prov.getDireccion(),
								  prov.getCorreo()
									};
				model.addRow(fila);
			}
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblProveedores) {
			keyReleasedTblProveedores(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblProveedores(KeyEvent e) {
		// Obtener el valor de la fila 
	    int posFila;
		posFila = tblProveedores.getSelectedRow();
		
		// Mostrar datos de la fila en las cajas de texto 
		mostrarData(posFila);
	}

	private void mostrarData(int posFila) {
		
		// Variables
		String cod, razSocial, ruc, telf, direc, correo;
		
		// Obtener datos de la tabla
		cod = tblProveedores.getValueAt(posFila, 0).toString();
		razSocial = tblProveedores.getValueAt(posFila, 1).toString();
		ruc = tblProveedores.getValueAt(posFila, 2).toString();
		telf = tblProveedores.getValueAt(posFila, 3).toString();
		direc = tblProveedores.getValueAt(posFila, 4).toString();
		correo = tblProveedores.getValueAt(posFila, 5).toString();
		
		// Enviar los datos obtenidos a las cajas de texto
		txtCodigo.setText(cod);
		txtRazSocial.setText(razSocial);
		txtRuc.setText(ruc);
		txtTelefono.setText(telf);
		txtDireccion.setText(direc);
		txtCorreo.setText(correo);
	
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblProveedores) {
			mouseClickedTblProveedores(e);
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
	protected void mouseClickedTblProveedores(MouseEvent e) {
		// Obtener el valor de la fila 
	    int posFila;
		posFila = tblProveedores.getSelectedRow();
		
		// Mostrar datos de la fila en las cajas de texto 
		mostrarData(posFila);
	}
}
