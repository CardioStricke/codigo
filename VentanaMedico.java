package Vista;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Model.*;
import Control.*;
import javax.swing.JTextField;

public class VentanaMedico extends JInternalFrame {

	private JPanel contentPane;
	public LoginControl controlador;
	public JComboBox <Login> usersList; 
	public JTextField campoNombre;
	public JTextField campoApellido;


	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMedico frame = new VentanaMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaMedico() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		campoNombre = new JTextField();
		contentPane.add(campoNombre, BorderLayout.CENTER);
		campoNombre.setColumns(10);
		
		campoApellido = new JTextField();
		contentPane.add(campoApellido, BorderLayout.EAST);
		campoApellido.setColumns(10);
	}
	
	/*
	 * De momento la vista estará vacía para la primera entrega
	 */
	public void crearVista() {}
	 	public void addController (LoginControl lc)
	 	{
	    	
	    	controlador = lc;
		}

}
