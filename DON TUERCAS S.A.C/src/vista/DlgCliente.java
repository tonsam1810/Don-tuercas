package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import entidad.Cliente;
import mantenimiento.GestionClienteDAO;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCliente extends JDialog implements KeyListener, ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTable tblClientes;
	private JTextField txtCliente;

	// Instanciar un objeto para la tabla
	DefaultTableModel model = new DefaultTableModel();
	
	// Instanciar 
	GestionClienteDAO gCli = new GestionClienteDAO();
	private JButton okButton;
	private JButton cancelButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCliente dialog = new DlgCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCliente() {
		setTitle("Consultar Producto");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 57, 416, 165);
			contentPanel.add(scrollPane);
			{
				tblClientes = new JTable();
				tblClientes.setFillsViewportHeight(true);
				scrollPane.setViewportView(tblClientes);
			}
		}
		{
			JLabel lblCliente = new JLabel("Cliente:");
			lblCliente.setBounds(10, 25, 63, 13);
			contentPanel.add(lblCliente);
		}
		
		txtCliente = new JTextField();
		txtCliente.addKeyListener(this);
		txtCliente.setBounds(77, 22, 349, 19);
		contentPanel.add(txtCliente);
		txtCliente.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		// Determinar Columnas
		model.addColumn("Código");
		model.addColumn("Razon Social");
		model.addColumn("Teléfono");
		
		
		// Asignar el modelo a la tabla 
		tblClientes.setModel(model);	
		
		TableColumnModel tabla = tblClientes.getColumnModel();
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		
		render.setHorizontalAlignment(SwingConstants.CENTER);
		
		tabla.getColumn(0).setCellRenderer(render);
		tabla.getColumn(1).setCellRenderer(render);
		tabla.getColumn(2).setCellRenderer(render);
		
		
		
		
	}
	
	private void listarClientes(String razSocial) {
		// 1. Limpiar tabla
		model.setRowCount(0);
		
		// 2. Obtener M�todo 
		ArrayList<Cliente> listaCli = gCli.buscarClienteXRazSocial(razSocial);
		// bucle
		for (Cliente cli : listaCli) {
			Object fila [] = {cli.getCodCliente(),
							  cli.getRazSocial(),
							  cli.getTelefono()						      					
							  };
			model.addRow(fila);
			
		}
		
	}
	
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtCliente) {
			keyReleasedTxtCliente(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtCliente(KeyEvent e) {
		String razSocial;
		razSocial = txtCliente.getText().trim();
		listarClientes(razSocial);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			actionPerformedCancelButton(e);
		}
		if (e.getSource() == okButton) {
			actionPerformedOkButton(e);
		}
	}
	protected void actionPerformedOkButton(ActionEvent e) {
		enviarDatos();
	}

	private void enviarDatos() {
		String cod, razSocial, telf;
		int fila;
		
		//Obtener el valor de la fila selecionada
		fila = tblClientes.getSelectedRow();
		
		// Obtener datos de la fila seleccionada
		cod = tblClientes.getValueAt(fila, 0).toString();
		razSocial = tblClientes.getValueAt(fila, 1).toString();
		telf = tblClientes.getValueAt(fila, 2).toString();
		
		
		//Mostrar los datos en la caja de texto de FrmBoleta
		FrmBoleta.txtCodCliente.setText(cod);
		FrmBoleta.txtRazSocial.setText(razSocial);
		FrmBoleta.txtTelfCliente.setText(telf);
				
		
		// Cerrar la ventana
		this.dispose();
		
	}
	protected void actionPerformedCancelButton(ActionEvent e) {
		this.dispose();
	}
}
