package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.LoginControl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Scrollbar;
import java.awt.Toolkit;

import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class VentanaPaciente extends JFrame {

	private JPanel contentPane;
	public LoginControl controlador;
	private JTextField txtBuscador;
	private JTable table;
	private JLabel lblSlimuem;
	
	
	/**
	 * Creaamos la ventana
	 */

	
	
	
	public VentanaPaciente() {
		this.setTitle("Paciente");//titulo de la ventana
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//DISPOSE, al cerrar poder seguir probando logins
		setBounds(100, 100, 770, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//logo cardio strike
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\alexcebrian368\\Desktop\\CardioStrikee\\src\\CardioStrike\\src\\imagenes\\icono.png"));
		
		
    	//reajuste de logo slim uem
		ImageIcon imagen = new ImageIcon("src/imagenes/logoSlimUem.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblSlimuem.getWidth(),lblSlimuem.getHeight(),Image.SCALE_DEFAULT));
        lblSlimuem.setIcon(icono);
        this.repaint();
    
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBounds(0, 0, 753, 493);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 25, 141, 167);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblFotoperfil = new JLabel("FotoPerfil");
		lblFotoperfil.setIcon(new ImageIcon("C:\\Users\\alexcebrian368\\Desktop\\foto-anonimo.png"));
		lblFotoperfil.setBounds(0, 0, 140, 168);
		panel.add(lblFotoperfil);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(485, 96, 89, 23);
		panel_1.add(btnBuscar);
		
		txtBuscador = new JTextField();
		txtBuscador.setText("Buscador");
		txtBuscador.setBounds(328, 97, 158, 20);
		panel_1.add(txtBuscador);
		txtBuscador.setColumns(10);
		
		JButton btnAbrirSesion = new JButton("Abrir Sesion");
		btnAbrirSesion.setBounds(283, 25, 125, 37);
		panel_1.add(btnAbrirSesion);
		
		JButton btnNuevaSesion = new JButton("Nueva Sesion");
		btnNuevaSesion.setBounds(442, 25, 125, 37);
		panel_1.add(btnNuevaSesion);
		
		JButton btnConsejos = new JButton("Consejos");
		btnConsejos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnConsejos.setBounds(595, 25, 125, 37);
		panel_1.add(btnConsejos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(283, 153, 436, 308);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "Sesion 1", "01/03/2017", "12:00"},
				{null, "Sesion 2", "02/03/2017", "13:21"},
				{null, "Sesion 3", "03/03/2017", "12:45"},
				{null, "Sesion 4", "04/03/2017", "10:15"},
				{null, "Sesion 5", "05/03/2017", "16:11"},
				{null, "Sesion 6", "07/03/2017", "17:33"},
				{null, "Sesion 7", "08/03/2017", "17:55"},
				{null, "Sesion 8", "09/03/2017", "18:02"},
				{null, "Sesion 9", "12/03/2017", "12:07"},
				{null, "Sesion 10", "14/03/2017", "21:14"},
				{null, "Sesion 11", "15/03/2017", "17:42"},
				{null, "Sesion 12", "16/03/2017", "16:58"},
				{null, "Sesion 13", "18/03/2017", "11:25"},
				{null, "Sesion 14", "19/03/2017", "15:48"},
				{null, "Sesion 15", "22/03/2017", "22:22"},
				{null, "Sesion 16", "23/03/2017", "23:19"},
				{null, "Sesion 17", "25/03/2017", "9:30"},
				{null, null, null, null},
			},
			new String[] {
				"", "Sesion", "Fecha", "Hora"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(54);
		table.getColumnModel().getColumn(1).setPreferredWidth(190);
		table.getColumnModel().getColumn(2).setPreferredWidth(190);
		table.getColumnModel().getColumn(3).setPreferredWidth(190);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(25, 221, 80, 28);
		panel_1.add(lblNombre);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFechaNacimiento.setForeground(Color.WHITE);
		lblFechaNacimiento.setBounds(25, 342, 89, 37);
		panel_1.add(lblFechaNacimiento);
		
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setBounds(25, 260, 89, 32);
		panel_1.add(lblApellidos);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblID.setForeground(Color.WHITE);
		lblID.setBounds(25, 303, 55, 28);
		panel_1.add(lblID);
		
		JLabel lblRellenonombre = new JLabel("RellenoNombre");
		lblRellenonombre.setBounds(132, 221, 99, 25);
		panel_1.add(lblRellenonombre);
		
		JLabel lblRellenoid = new JLabel("RellenoID");
		lblRellenoid.setBounds(132, 302, 99, 29);
		panel_1.add(lblRellenoid);
		
		JLabel lblRellenoapellido = new JLabel("RellenoApellido");
		lblRellenoapellido.setBounds(132, 260, 99, 28);
		panel_1.add(lblRellenoapellido);
		
		JLabel lblRellenofechanacimiento = new JLabel("RellenoFechaNacimiento");
		lblRellenofechanacimiento.setBounds(132, 342, 99, 28);
		panel_1.add(lblRellenofechanacimiento);
		
		lblSlimuem = new JLabel("SlimUem");
		lblSlimuem.setIcon(new ImageIcon("C:\\Users\\alexcebrian368\\Desktop\\CardioStrikee\\src\\CardioStrike\\src\\imagenes\\logoSlimUem.jpg"));
		lblSlimuem.setBounds(20, 402, 225, 59);
		panel_1.add(lblSlimuem);
		
		
	
		
		JLabel lblFondopantalla = new JLabel("FondoPantalla");
		lblFondopantalla.setBounds(0, 0, 753, 493);
		panel_1.add(lblFondopantalla);
		lblFondopantalla.setIcon(new ImageIcon("C:\\Users\\alexcebrian368\\Desktop\\imagenes\\Captura.PNG"));
		lblFondopantalla.setFont(new Font("Arial Black", Font.PLAIN, 14));
	}
	
	public void addController (LoginControl lc){
	   	controlador = lc;
	}
}
