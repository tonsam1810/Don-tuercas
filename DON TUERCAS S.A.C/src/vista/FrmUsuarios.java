package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Cargo;
import entidad.Usuarios;
import mantenimiento.GestionCargoDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.Validaciones;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;



public class FrmUsuarios extends JInternalFrame implements ActionListener, MouseListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblNomrbe;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblClave;
	private JLabel lblCargo;
	private JComboBox cboCargo;
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnBuscar;

	
	// Instanciar objeto para definir la estructura de la tabla
	DefaultTableModel model = new DefaultTableModel();
	
	// Instanciar objeto 
	GestionCargoDAO gCar = new GestionCargoDAO();
	
	// Instanciar al objeto GestionUsuarioDao
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	
	private JPasswordField txtClave;
	private JTable tblUsuarios;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUsuarios frame = new FrmUsuarios();
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
	public FrmUsuarios() {
		setIconifiable(true);
		setClosable(true);
		setTitle("DON TUERCAS S.A.C.  -  Mantenimiento Usuarios  ");
		setBounds(100, 100, 693, 520);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblCodigo.setBounds(36, 64, 82, 20);
		contentPane.add(lblCodigo);
		
		lblNomrbe = new JLabel("Nombre");
		lblNomrbe.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNomrbe.setBounds(360, 64, 82, 20);
		contentPane.add(lblNomrbe);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(36, 81, 110, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(360, 81, 188, 19);
		contentPane.add(txtNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblApellido.setBounds(36, 110, 82, 20);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(36, 127, 178, 19);
		contentPane.add(txtApellido);
		
		lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblDni.setBounds(360, 110, 82, 20);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(360, 127, 139, 19);
		contentPane.add(txtDni);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblUsuario.setBounds(36, 156, 82, 20);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(36, 173, 110, 19);
		contentPane.add(txtUsuario);
		
		lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblClave.setBounds(360, 156, 82, 20);
		contentPane.add(lblClave);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblCargo.setBounds(36, 202, 82, 20);
		contentPane.add(lblCargo);
		
		cboCargo = new JComboBox();
		cboCargo.setBounds(36, 221, 178, 21);
		contentPane.add(cboCargo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 268, 659, 213);
		contentPane.add(scrollPane);
		
		tblUsuarios = new JTable();
		tblUsuarios.addKeyListener(this); 				
		tblUsuarios.addMouseListener(this);			
		tblUsuarios.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblUsuarios);
		
		btnNuevo = new JButton("");
		btnNuevo.setOpaque(false);
		btnNuevo.setContentAreaFilled(false);
		btnNuevo.setBorderPainted(false);
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(FrmUsuarios.class.getResource("/img/299068_add_sign_icon.png")));
		btnNuevo.setBounds(487, 223, 35, 35);
		contentPane.add(btnNuevo);
		
		btnGuardar = new JButton("");
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(new ImageIcon(FrmUsuarios.class.getResource("/img/285657_floppy_guardar_save_icon.png")));
		btnGuardar.setBounds(532, 223, 35, 35);
		contentPane.add(btnGuardar);
		
		btnActualizar = new JButton("");
		btnActualizar.setOpaque(false);
		btnActualizar.setContentAreaFilled(false);
		btnActualizar.setBorderPainted(false);
		btnActualizar.addActionListener(this);
		btnActualizar.setIcon(new ImageIcon(FrmUsuarios.class.getResource("/img/46828_reload_refrsh_calculate_icon.png")));
		btnActualizar.setBounds(577, 223, 35, 35);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("");
		btnEliminar.setOpaque(false);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(FrmUsuarios.class.getResource("/img/7549103_user_interface_remove_delete_trash_icon.png")));
		btnEliminar.setBounds(622, 223, 35, 35);
		contentPane.add(btnEliminar);
		
		btnBuscar = new JButton("");
		btnBuscar.setOpaque(false);
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(FrmUsuarios.class.getResource("/img/34229_find_magnifier_search_zoom_icon.png")));
		btnBuscar.setBounds(156, 64, 35, 35);
		contentPane.add(btnBuscar);
		
		// Determinar las columnas
		model.addColumn("Código");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Usuario");
		model.addColumn("Clave");
		model.addColumn("DNI");
		model.addColumn("Cargo");
				
		// Asignar Modelo a la Tabla
		tblUsuarios.setModel(model);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(360, 173, 139, 20);
		contentPane.add(txtClave);
		
		lblNewLabel = new JLabel("Mantenimiento Usuarios");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 10, 681, 34);
		contentPane.add(lblNewLabel);
		
		// Cargar data del ComboBox
		cargarDataComboBox();
			
		// Cargar data
		cargarData();
		
		// Generar codigo Automatico
		txtCodigo.setText(""+getCodigoAuto());
	}

	@SuppressWarnings("unchecked")
	private void cargarDataComboBox() {
		// Obtener la lista de tipo -- M�todo
		ArrayList<Cargo> lista = gCar.listarCargo();
		cboCargo.addItem("Seleccione");
		// Bucle para realizar el recorrido
		for(Cargo car : lista) {
			cboCargo.addItem(car.getIdCargo() + " - "+ car.getNombCargo());
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
		// Variables
		String nomb, ape, user, pass;
		int cod, dni, cargo;
		
		// Entradas
		cod = getCodigoAuto();
		nomb = getNombre();
		ape = getApellido();
		user = getUsuario();
		pass = getPassword();
		dni = getDni();
		cargo = getCargo();
		
		
		// Controlar el ingreso de datos correctos en la tabla
		if(cod == 0 || nomb == null || ape == null || user == null || pass == null || dni == 0 || cargo == 0) {
			return;
		}else {
			// crear un objeto de la clase usuario
			Usuarios u = new Usuarios();
			
			// Setear
			
			u.setCodigo(cod);
			u.setNombre(nomb);
			u.setApellido(ape);
			u.setUsuario(user);
			u.setClave(pass);
			u.setDni(dni);
			u.setCargo(cargo);
			
			// Invocar al método registrar
			int res = gUser.registrar(u);
			
			// Validar el resultado de método registrar
			if(res == 0)
				mensajeError("Error en el registro");
			else
				mensajeExito("Registro Exitoso");
			cargarData();
		}
		
	}

	private int getCodigoAuto() {
		return gUser.generarCodigoUsuario();
	}

	/*
	    private String getNomCargo() {
	
		return cboCargo.getSelectedItem().toString();
	}
	*/

	private int getCodigo() {
		int cod = 0;
		if(txtCodigo.getText().trim().length() == 0) {
			mensajeError("Ingrese el código");
			txtCodigo.requestFocus();
		}else if(txtCodigo.getText().trim().matches(Validaciones.Codigo)){
			cod = Integer.parseInt(txtCodigo.getText().trim());
		}else{			
				// Validar valores menores o iguales a 0				
					mensajeError("Formato incorrecto, el primer digito debera ser 9 seguido de tres números Ej. 9001");
					txtCodigo.setText("");
					txtCodigo.requestFocus();
					
				}
			
		
			
		return cod;
	}
	
	

	private String getNombre() {
		String nomb = null;
		if(txtNombre.getText().trim().length() == 0) {
			mensajeError("Ingresar el Nombre");
			txtNombre.requestFocus();
		}else if(txtNombre.getText().trim().matches(Validaciones.NOMBRE)) {
			nomb = txtNombre.getText().trim();
		}else {
			mensajeError("Ingresar solo Texto");
			txtNombre.setText("");
			txtNombre.requestFocus();
		}
		return nomb;
	}

	// 1: Mensaje Error
	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!", 0);
		
	}
	
	// 2: Mensaje Exito
		private void mensajeExito(String msj) {
			JOptionPane.showMessageDialog(this,msj);
			
		}

	private String getApellido() {
		String ape = null;
		if(txtApellido.getText().trim().length() == 0) {
			mensajeError("Ingrese el apellido");
		}else if (txtApellido.getText().trim().matches(Validaciones.APELLIDOS)) {
			ape = txtApellido.getText().trim();
		}else {
			mensajeError("Ingresar solo texto");
			txtApellido.setText("");
			txtApellido.requestFocus();
		}
		return ape;
	}

	private String getUsuario() {
		String user = null;
		if(txtUsuario.getText().trim().length() == 0) {
			mensajeError("Ingrese el Usuario");
		}else if (txtUsuario.getText().trim().matches(Validaciones.Usuario)) {
			user = txtUsuario.getText().trim();
		}else {
			mensajeError("Formato de Usuario incorrecto, Ej. CM123");
			txtUsuario.setText("");
			txtUsuario.requestFocus();
		}
		return user;
	}

	private String getPassword() {
		// Se va a completar la validaci�n 
		String pass = null;
		pass = encriptado(String.valueOf(txtClave.getPassword()));
		return pass;
	}

	private String encriptado(String pass) {
		StringBuilder encriptado = new StringBuilder();
		encriptado.append(pass);
		// Reemplazar las vocales
		// a->e, e->i, i->o, o->u, u->a
		for (int i = 0; i < encriptado.length(); i++) {
			switch (encriptado.charAt(i)) {
			case 'a':encriptado.setCharAt(i, 'e'); break;
			case 'e':encriptado.setCharAt(i, 'i'); break;
			case 'i':encriptado.setCharAt(i, 'o'); break;
			case 'o':encriptado.setCharAt(i, 'u'); break;
			case 'u':encriptado.setCharAt(i, 'a'); break;
			case '0':encriptado.setCharAt(i, '1'); break;
			case '1':encriptado.setCharAt(i, '2'); break;
			case '2':encriptado.setCharAt(i, '3'); break;
			case '3':encriptado.setCharAt(i, '4'); break;
			}
		}
		return encriptado.reverse().toString();
	}

	private int getDni() {
		int dni = 0;
		if(txtDni.getText().trim().length() == 0) {
			mensajeError("Ingrese número de DNI");
			txtDni.requestFocus();
		}else if(txtDni.getText().trim().matches(Validaciones.DNI)){
			dni = Integer.parseInt(txtDni.getText());
		}else{
			mensajeError("Ingresar solo valores númericos Ej.70274558");
			txtDni.setText("");
			txtDni.requestFocus();											
		}
		return dni;
	}

	private int getCargo() {
		int cargo = 0;
		cargo = cboCargo.getSelectedIndex();
		if(cargo == 0) {
			mensajeError("Selecione cargo del Usuario");
		}
		return cargo;
	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarUsuario();
	}
	private void actualizarUsuario() {
		
		// Declaración de variables
		String nomb, ape, user, pass;
		int cod, dni, cargo;
		
		// Obtener los datos de la GUI
		
		cod = getCodigo();
		nomb = getNombre();
		ape = getApellido();
		user = getUsuario();
		pass = getPassword();	
		dni = getDni();
		cargo = getCargo();
		
		// Validaciones
		if(cod == 0 || nomb == null || ape == null || user == null || pass == null || dni == 0 || cargo == 0) {
			return;
		}else {
		//Creamos un objeto Tipo usuarios
		Usuarios u = new Usuarios();
		
		// Setear "Enviar los valores de la GUI a los atributos privados"		
		u.setNombre(nomb);
		u.setApellido(ape);
		u.setUsuario(user);
		u.setClave(pass);
		u.setDni(dni);
		u.setCargo(cargo);	
		u.setCodigo(cod);
		
		// Proceso de actualización 
		int ok = gUser.actualizar(u);
		
		// Validar el resultado del proceso actualizar
		if(ok == 0) {
			mensajeError("Error en la actualización");
		}else {
			mensajeExito("Usuario Actualizado");
			cargarData();
		}			
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarUsuario();
	}
	private void eliminarUsuario() {
		int codigo;
		
		// Obtener el codigo ingresado en la GUI
		codigo = getCodigo();
		
		// Validar
		if(codigo == -1) {
			return;
		}else {
			// Mensaje de confirmación
		int boton = JOptionPane.showConfirmDialog(this, "Seguro de eliminar? ","Sistema", JOptionPane.YES_NO_OPTION);
			if(boton == 0) { // SI ---> 0 / NO ---> 1 / CANCELAR ---> 2 
				// Proceso Eliminar
				int ok = gUser.eliminar(codigo);
				// Validar el resultado del proceso eliminar
				if(ok == 0) {
					mensajeError("Código no existe");
				}else {
					mensajeExito("Usuario eliminado");
				}
			}
		}
		
	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		buscarUsuarioPorCodigo();		
	}
	private void buscarUsuarioPorCodigo() {
		int codigo;
		Usuarios user;
		// Obtener los valores de la GUI
		codigo = getCodigo();
		
		user = gUser.buscarUsuarios(codigo);
		
		// Validar el resultado 
		if(user == null) {
			mensajeError("Código no existe");
		}else {
			txtNombre.setText(user.getNombre());
			txtApellido.setText(user.getApellido());
			txtUsuario.setText(user.getUsuario());
			txtClave.setText(user.getClave());
			txtDni.setText(""+user.getDni());
			cboCargo.setSelectedIndex(user.getCargo());
		}
		
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		
		// limpiar
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		txtDni.setText("");
		cboCargo.setSelectedIndex(0);
		
		// Cursor activo en Nombre
		txtCodigo.setText(""+getCodigoAuto());
		txtNombre.requestFocus();
	}
	
	private void cargarData() {
		// Limpiar la tabla
		model.setRowCount(0);
		
		// Obtener el listado de usuarios --> listar usuarios  --> Mantenimiento
		ArrayList<Usuarios> lista = gUser.listarUsuarios();
		
		// Validar el resultado
		if(lista.size() == 0) {
			mensajeError("Lista vacia");
		}else {
			// Bucle
			for(Usuarios us : lista) {
				Object fila [] = {us.getCodigo(),
							 	  us.getNombre(),
							 	  us.getApellido(),
							 	  us.getUsuario(),
							 	  us.getClave(),
							 	  us.getDni(),
							 	  us.getCargo()						
								  };
				model.addRow(fila);
			}
		}
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblUsuarios) {
			mouseClickedTblUsuarios(e);
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
	protected void mouseClickedTblUsuarios(MouseEvent e) {
		// Obtener el valor de la fila 
	    int posFila;
		posFila = tblUsuarios.getSelectedRow();
		
		// Mostrar datos de la fila en las cajas de texto 
		mostrarData(posFila);
	}
	
	
	    private void mostrarData(int posFila) {
		
		// Variables
		String cod, nomb, ape, user, clave, dni; 
		int cargo;
		
		// Obtener datos de la tabla
		cod = tblUsuarios.getValueAt(posFila, 0).toString();
		nomb = tblUsuarios.getValueAt(posFila, 1).toString();
		ape = tblUsuarios.getValueAt(posFila, 2).toString();
		user = tblUsuarios.getValueAt(posFila, 3).toString();
		clave = tblUsuarios.getValueAt(posFila, 4).toString();
		dni = tblUsuarios.getValueAt(posFila, 5).toString();
		cargo = tblUsuarios.getValueAt(posFila, 6).hashCode();
		
		
		// Enviar los datos obtenidos a las cajas de texto
		txtCodigo.setText(cod);
		txtNombre.setText(nomb);
		txtApellido.setText(ape);
		txtUsuario.setText(user);
		txtClave.setText(clave);
		txtDni.setText(dni);
		cboCargo.setSelectedIndex(cargo);		
		
	}
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblUsuarios) {
			keyReleasedTblUsuarios(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblUsuarios(KeyEvent e) {
		// Obtener el valor de la fila 
				int posFila;
				posFila = tblUsuarios.getSelectedRow();
				
				// Mostrar datos de la fila en las cajas de texto 
				mostrarData(posFila);
	}
}
