package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Usuarios;
import mantenimiento.GestionUsuarioDAO;
import utils.HiloTiempo;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class Logueo extends JFrame implements WindowListener, ActionListener {
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	public static Logueo frame;
	private JButton btnAceptar;
	private JLabel lblMensaje;
	public static JLabel lblTiempo;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblCerrar;
	private JPanel panel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	
	// Intanciar
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	
	// Usuarios a publico para poder acceder desde otras clases
	public static Usuarios u = new Usuarios();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Logueo();
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
	public Logueo() {
		setUndecorated(true);
		addWindowListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 359);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		lblMensaje = new JLabel("Esta ventana se cerrar\u00E1 en");
		lblMensaje.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblMensaje.setBounds(120, 336, 190, 13);
		contentPane.add(lblMensaje);
		
		lblTiempo = new JLabel("30s");
		lblTiempo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblTiempo.setBounds(307, 336, 45, 13);
		contentPane.add(lblTiempo);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(88, 121, 259, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsuario.getText().equals("Usuario")) {
					txtUsuario.setText("");
				}else {
					txtUsuario.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsuario.getText().equals(""))
					txtUsuario.setText("Usuario");
			}
		});
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setBounds(10, 10, 142, 22);
		panel.add(txtUsuario);
		txtUsuario.setText("Usuario");
		txtUsuario.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Logueo.class.getResource("/img/403022_business man_male_user_avatar_profile_icon.png")));
		lblNewLabel.setBounds(217, 2, 32, 30);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBounds(88, 171, 259, 40);
		contentPane.add(panel_1);
		
		txtClave = new JPasswordField();
		txtClave.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtClave.getText().equals("Contraseña")) {
					txtClave.setEchoChar('●');
					txtClave.setText("");	
				}else {
					txtClave.selectAll();
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtClave.getText().equals("")) {
					txtClave.setText("Contraseña");
					txtClave.setEchoChar((char)0);
				}
					
			}
		});
		txtClave.setBackground(Color.WHITE);
		txtClave.setBounds(10, 10, 140, 20);
		txtClave.setEchoChar((char)0);
		panel_1.add(txtClave);
		txtClave.setText("Contraseña");
		txtClave.setToolTipText("");
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Logueo.class.getResource("/img/9004738_lock_security_padlock_secure_icon.png")));
		lblNewLabel_1.setBounds(217, 0, 32, 30);
		panel_1.add(lblNewLabel_1);
		
		lblCerrar = new JLabel("X");
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//if(JOptionPane.showConfirmDialog(null, "Esta seguro de cerrar la aplicación?", "Confirmación", JOptionPane.YES_NO_OPTION) == 0);
					Logueo.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrar.setForeground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblCerrar.setForeground(Color.WHITE);
			}
		});
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setForeground(Color.WHITE);
		lblCerrar.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblCerrar.setBounds(435, 0, 28, 23);
		contentPane.add(lblCerrar);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(47, 79, 79));
		panel_2.setBounds(120, 234, 211, 47);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnAceptar = new JButton("Iniciar Sesión");
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		btnAceptar.setBounds(64, 10, 124, 29);
		panel_2.add(btnAceptar);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Logueo.class.getResource("/img/379501_key_icon.png")));
		lblNewLabel_3.setBounds(10, 10, 32, 30);
		panel_2.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("Don Tuercas S.A.C.");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 19));
		lblNewLabel_2.setBounds(0, 47, 463, 29);
		contentPane.add(lblNewLabel_2);
		btnAceptar.addActionListener(this);
	}
	
		void iniciarTiempo() {
			// llamar proceso
			HiloTiempo h = new HiloTiempo(lblTiempo, this);
			// iniciar proceso
			h.start();
			
		}
	
	public void windowActivated(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowClosing(WindowEvent e) {
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}
	protected void windowOpenedThis(WindowEvent e) {
		iniciarTiempo();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {		
		validarAcceso();		
	}

	private void validarAcceso() {
		String user, clave;
		
		// Obtener los valores ingresados en la GUI
		user = getUsuario();
		clave = getClave();
		
		// Validar
		if(user == null || clave == null) {
			return;
		}else { // Validar si el usuario y la clave ingresados existen en la BD
			u = gUser.validarAcceso(user, clave);
			
			// Validar el resultado de la consulta
			if(u == null) {
				mensajeError("Usuario y/o clave incorrectos");
			}else {
				cargarBarraProgreso();
			}
		}
		
	}

	private void cargarBarraProgreso() {
		FrmPreLoader v = new FrmPreLoader();
		v.setVisible(true);
		v.setLocationRelativeTo(this);
		this.dispose();
		
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!", 0);
		
	}

	private String getUsuario() {
		String user = null;
		if(txtUsuario.getText().trim().length() == 0) {
			mensajeError("Ingrese el usuario");
			txtUsuario.requestFocus();
		}else {
			user = txtUsuario.getText().trim();
		}
		return user;
	}

	private String getClave() {
		String clave = null;
		if(txtClave.getText().trim().length() == 0) {
			mensajeError("Ingresar Clave");
			txtClave.requestFocus();
		}else {
			clave = String.valueOf(txtClave.getPassword()).trim();	
			}	
		return clave;
	}
}
