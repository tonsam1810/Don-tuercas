package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Productos;
import mantenimiento.GestionProductoDAO;

public class DlgProducto extends JDialog implements ActionListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblProductos;
	private JTextField txtProductos;
	private JTable tblProductos;
	private JScrollPane scrollPane;
	
	// Instanciar un objeto para la tabla
	DefaultTableModel model = new DefaultTableModel();
	
	//
	GestionProductoDAO gProd = new GestionProductoDAO();
	private JButton btnOk;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgProducto dialog = new DlgProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgProducto() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblProductos = new JLabel("Productos:");
		lblProductos.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblProductos.setBounds(10, 21, 75, 13);
		contentPanel.add(lblProductos);
		
		txtProductos = new JTextField();
		txtProductos.addKeyListener(this);
		txtProductos.setBounds(95, 19, 310, 19);
		contentPanel.add(txtProductos);
		txtProductos.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 416, 168);
		contentPanel.add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProductos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("OK");
				btnOk.addActionListener(this);
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				btnCancelar = new JButton("Cancel");
				btnCancelar.addActionListener(this);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
		
		// Determinar las columnas
		model.addColumn("Código");
		model.addColumn("Descripción");
		model.addColumn("Precio");
		model.addColumn("Stock");
		
		// Asignar el modelo a la tabla
		tblProductos.setModel(model);				
	}
	
	private void listarProductos(String nomProd){
		// Limpiar tabla
		model.setRowCount(0);
		
		// Obtener método
		ArrayList<Productos> listarProd = gProd.buscarProductoXNombre(nomProd);
		
		// Bucle
		for (Productos pro : listarProd) {
			Object fila [] = {pro.getIdProducto(),
					 		  pro.getDescripcion(),
					 		  pro.getPrecio(),
					 		  pro.getStock()
							  };
			model.addRow(fila);
		}
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtProductos) {
			keyReleasedTxtProductos(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtProductos(KeyEvent e) {
		String nomProd;
		nomProd = txtProductos.getText().trim();
		listarProductos(nomProd);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnOk) {
			actionPerformedBtnOk(e);
		}
	}
	
	protected void actionPerformedBtnOk(ActionEvent e) {
		enviarDatos();
	}
	private void enviarDatos() {
		String cod, desc, precio, stock;
		int fila;
		
		// Obtener el valor de la fila seleccionada
		fila = tblProductos.getSelectedRow();
		
		// Obtener datos de la fila seleccionada
		cod = tblProductos.getValueAt(fila, 0).toString();
		desc = tblProductos.getValueAt(fila, 1).toString();
		precio = tblProductos.getValueAt(fila, 2).toString();
		stock = tblProductos.getValueAt(fila, 3).toString();
		
		// Mostrar los datos en la caja de texto de FrmBoleta
		FrmBoleta.txtCodProducto.setText(cod);
		FrmBoleta.txtDesProducto.setText(desc);
		FrmBoleta.txtPreProducto.setText(precio);
		FrmBoleta.txtStockProducto.setText(stock);
		
		// Cerrar la ventana
		this.dispose();
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		this.dispose();
	}
	
	
}
