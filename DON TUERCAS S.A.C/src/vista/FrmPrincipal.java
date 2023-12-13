package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import utils.HiloReloj;

public class FrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSistema;
	private JMenu mnMantenimiento;
	private JMenu mnReportes;
	private JMenu mnPedido;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProductos;
	private JMenuItem mntmUsuarios;
	private JMenuItem mntmProveedores;
	private JMenuItem mntmIngresoDePedidos;
	private JMenuItem mntmSalir;
	private JMenuItem mntmReporteDePedidos;
	private JMenuItem mntmVentas;
	private JDesktopPane escritorio;
	private JLabel lblReloj;
	private JMenuItem mntmNewMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setResizable(false);
		setTitle("DON TUERCAS S.A.C - "+Logueo.u.getNombre()+" "+Logueo.u.getApellido());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1550, 878);
		setExtendedState(MAXIMIZED_BOTH);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imgBn/216162 - cog outline.png")));
		menuBar.add(mnMantenimiento);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mntmClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/2620528 - choose employee job seeker unemployee work.png")));
		mnMantenimiento.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mntmProductos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/49590_boxes_customers_inventory_products_icon.png")));
		mnMantenimiento.add(mntmProductos);
		
		mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.addActionListener(this);
		mntmUsuarios.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/85409_users_icon.png")));
		mnMantenimiento.add(mntmUsuarios);
		
		mntmProveedores = new JMenuItem("Proveedores");
		mntmProveedores.addActionListener(this);
		mntmProveedores.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/4172394_goods_merchandise_stock_supply_vendibles_icon.png")));
		mnMantenimiento.add(mntmProveedores);
		
		mnPedido = new JMenu("Pedido");
		mnPedido.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/1814092 - box files storag.png")));
		menuBar.add(mnPedido);
		
		mntmIngresoDePedidos = new JMenuItem("Ingreso de Pedidos");
		mntmIngresoDePedidos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/2620529 - checklist employee job seeker unemployee work.png")));
		mnPedido.add(mntmIngresoDePedidos);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/2620509 - employee job note seeker unemployee work.png")));
		menuBar.add(mnReportes);
		
		mntmReporteDePedidos = new JMenuItem("Reporte de Pedidos");
		mntmReporteDePedidos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/2620507 - employee job print seeker unemployee work.png")));
		mnReportes.add(mntmReporteDePedidos);
		
		mntmVentas = new JMenuItem("Ventas");
		mntmVentas.addActionListener(this);
		mntmVentas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/465074_cart_purchase_shopping_basket_buy_icon.png")));
		mnReportes.add(mntmVentas);
		
		mntmNewMenuItem = new JMenuItem("Lista de Productos");
		mntmNewMenuItem.addActionListener(this);
		mntmNewMenuItem.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/2620529 - checklist employee job seeker unemployee work.png")));
		mnReportes.add(mntmNewMenuItem);
		
		mnSistema = new JMenu("Sistema");
		mnSistema.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/3440838_computer_desktop_monitor_pc_screen_icon (1).png")));
		menuBar.add(mnSistema);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_MASK));
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/1564506_close_exit_logout_power_icon.png")));
		mnSistema.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		escritorio = new JDesktopPane();
		escritorio.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		escritorio.setBackground(SystemColor.activeCaption);	
		escritorio.setBounds(0, 0, 1538, 802);		
		contentPane.add(escritorio);
		escritorio.setLayout(null);
		
		lblReloj = new JLabel("");
		lblReloj.setBounds(1372, 763, 156, 29);
		lblReloj.setForeground(Color.BLACK);
		lblReloj.setFont(new Font("Tahoma", Font.BOLD, 20));
		escritorio.add(lblReloj);
		
		mostrarReloj();
		
		// Permisos de acuerdo a los cargos
		restringirPermisos();
	}
	
	private void restringirPermisos() {
		switch (Logueo.u.getCargo()) {
		case 1: // Vendedor
			mnMantenimiento.setEnabled(false);
			
			break;

//		default:
//			break;
		}
		
	}

	void mostrarReloj() {
		//
		HiloReloj hr = new HiloReloj(lblReloj);
		//
		hr.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
		if (e.getSource() == mntmProductos) {
			actionPerformedMntmProductos(e);
		}
		if (e.getSource() == mntmProveedores) {
			actionPerformedMntmProveedores(e);
		}
		if (e.getSource() == mntmUsuarios) {
			actionPerformedMntmUsuarios(e);
		}
		if (e.getSource() == mntmClientes) {
			actionPerformedMntmClientes(e);
		}
		if (e.getSource() == mntmVentas) {
			actionPerformedMntmVentas(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {	
		dispose();
	}
	protected void actionPerformedMntmProductos(ActionEvent e) {
		FrmProductos prod = new FrmProductos();
		prod.setVisible(true);
		//setLocationRelativeTo(null);
		escritorio.add(prod);
	}
		protected void actionPerformedMntmVentas(ActionEvent e) {
		FrmBoleta bol = new FrmBoleta();
		bol.setVisible(true);
		escritorio.add(bol);
	}
	
	
	protected void actionPerformedMntmClientes(ActionEvent e) {
		FrmRegistroClientes reg = new FrmRegistroClientes();
		reg.setVisible(true);
		//setLocationRelativeTo(null );
		escritorio.add(reg);
	}
	protected void actionPerformedMntmUsuarios(ActionEvent e) {
		FrmUsuarios user = new FrmUsuarios();
		user.setVisible(true);
		//setLocationRelativeTo(null );
		escritorio.add(user);
	}
	protected void actionPerformedMntmProveedores(ActionEvent e) {
		FrmProveedores pro = new FrmProveedores();
		pro.setVisible(true);
		//setLocationRelativeTo(null );
		escritorio.add(pro);
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		FrmLstProductos pro = new FrmLstProductos();
		pro.setVisible(true);
		//setLocationRelativeTo(null );
		escritorio.add(pro);
	}
}

	