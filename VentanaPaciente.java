package Vista;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import Control.LoginControl;
import Model.Paciente;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.Toolkit;

import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class VentanaPaciente extends JFrame {

	private JPanel contentPane;
	public LoginControl controlador;
	private JTextField txtBuscador;
	private JTable table;
	private JLabel lblSlimuem;
	private JTextArea textArea;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textId;
	private JTextField textFecha;
	
	/**
	 * Creamos la ventana
	 */
  
	
	public VentanaPaciente() {
		setExtendedState(6);
		this.setTitle("Paciente");//titulo de la ventana
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//DISPOSE, al cerrar poder seguir probando logins
		setBounds(100, 100, 770, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//logo cardio strike
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\alexcebrian368\\Desktop\\CardioStrikee\\src\\CardioStrike\\src\\imagenes\\icono.png"));
		
		
    	/*
		textNombre.setText(paciente.getNombre());
        textApellidos.setText(paciente.getApellidos());
        textFecha.setText(paciente.getFechaNacimiento());
		*/
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBounds(0, 0, 1914, 1001);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBuscar = new JLabel("BUSCAR:");
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblBuscar.setBounds(693, 349, 188, 49);
		panel_1.add(lblBuscar);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 25, 338, 300);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblFotoPerfil = new JLabel("FotoPerfil");
		lblFotoPerfil.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\logoLogin.jpg"));
		lblFotoPerfil.setBounds(0, 0, 338, 300);
		panel.add(lblFotoPerfil);
		
		textNombre = new JTextField();
		textNombre.setBounds(181, 411, 293, 53);
		panel_1.add(textNombre);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(181, 548, 293, 49);
		panel_1.add(textApellidos);
		textApellidos.setColumns(10);
		
		textId = new JTextField();
		textId.setBounds(181, 704, 293, 49);
		panel_1.add(textId);
		textId.setColumns(10);
		
		textFecha = new JTextField();
		textFecha.setBounds(181, 831, 293, 49);
		panel_1.add(textFecha);
		textFecha.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBuscar.setBounds(1385, 349, 231, 49);
		panel_1.add(btnBuscar);
		
		txtBuscador = new JTextField();
		txtBuscador.setBounds(1028, 358, 285, 45);
		panel_1.add(txtBuscador);
		txtBuscador.setColumns(10);
		
		JButton btnAbrirSesion = new JButton("Abrir Sesion");
		btnAbrirSesion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnAbrirSesion.setBounds(693, 162, 265, 75);
		panel_1.add(btnAbrirSesion);
		     
		
		
		JButton btnNuevaSesion = new JButton("Nueva Sesion");
		btnNuevaSesion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNuevaSesion.setBounds(1057, 162, 256, 75);
		panel_1.add(btnNuevaSesion);
		btnNuevaSesion.addMouseListener(new MouseAdapter() {
			@Override
			
		
			
			public void mouseClicked(MouseEvent arg0) {
			     
			       //Creamos el objeto JFileChooser
			         JFileChooser fc=new JFileChooser();
			          
			         //Indicamos que podemos seleccionar varios ficheros
			         fc.setMultiSelectionEnabled(true);
			          
			         //Indicamos lo que podemos seleccionar
			         fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			          
			          
			         //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
			         int seleccion=fc.showOpenDialog(contentPane);
			          
			         //Si el usuario, pincha en aceptar
			         if(seleccion==JFileChooser.APPROVE_OPTION){
			          
			             //Seleccionamos el fichero
			             File[] ficheros=fc.getSelectedFiles();
			          
			             for(int i=0;i<ficheros.length;i++){
			                 try(FileReader fr=new FileReader(ficheros[i])){
			                     String cadena="";
			                     int valor=fr.read();
			                     while(valor!=-1){
			                         cadena=cadena+(char)valor;
			                         valor=fr.read();
			                     }
			                     textArea.append(cadena+"\n");
			                 } catch (IOException e1) {
			                     e1.printStackTrace();
			                 }
			             }
			         }
			  
			     
			 
			}
		});
		
		
		JButton btnConsejos = new JButton("Consejos");
		btnConsejos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnConsejos.setBounds(1385, 162, 240, 75);
		panel_1.add(btnConsejos);
		btnConsejos.addMouseListener(new MouseAdapter() {
			@Override
			
			//función para que el boton Consejos lleve a la Ventana Consejos
			
			public void mouseClicked(MouseEvent arg0) {
				VentanaConsejos vc = new VentanaConsejos();
				vc.setVisible(true);
				vc.toFront();
			
				//VentanaPaciente vp = new VentanaPaciente();
				//vp.dispose();
			}
		});
		FontUIResource font = new FontUIResource("Verdana", Font.PLAIN, 24);
        UIManager.put("Table.font", font);
        UIManager.put("Table.foreground", Color.RED);
       
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(693, 430, 923, 481);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				 if(evt.getClickCount()==2){
		            	Sesiones frame = new Sesiones();
						frame.setVisible(true);
						frame.toFront();
					}
			}
		});
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		table.setRowHeight(50);
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
		 table.setRowHeight(70);
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(25, 411, 128, 53);
		panel_1.add(lblNombre);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblFechaNacimiento.setForeground(Color.WHITE);
		lblFechaNacimiento.setBounds(25, 834, 117, 37);
		panel_1.add(lblFechaNacimiento);
		
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setBounds(25, 548, 141, 49);
		panel_1.add(lblApellidos);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblID.setForeground(Color.WHITE);
		lblID.setBounds(20, 716, 105, 37);
		panel_1.add(lblID);
		
		lblSlimuem = new JLabel("SlimUem");
		lblSlimuem.setIcon(new ImageIcon("C:\\Users\\alexcebrian368\\Desktop\\CardioStrikee\\src\\CardioStrike\\src\\imagenes\\logoSlimUem.jpg"));
		lblSlimuem.setBounds(20, 402, 225, 59);
		panel_1.add(lblSlimuem);
		
		ImageIcon imagen = new ImageIcon("C:\\Users\\alexcebrian368\\Desktop\\CardioStrikee\\src\\CardioStrike\\src\\imagenes\\logoSlimUem.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblSlimuem.getWidth(),lblSlimuem.getHeight(),Image.SCALE_DEFAULT));
        lblSlimuem.setIcon(icono);
        this.repaint();
    
		
		
	
		
		JLabel lblFondopantalla = new JLabel("");
		lblFondopantalla.setBounds(0, 0, 1915, 1002);
		panel_1.add(lblFondopantalla);
		lblFondopantalla.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\fondoMedico.jpg"));
		lblFondopantalla.setFont(new Font("Arial Black", Font.PLAIN, 14));
	}
	
	public void addController (LoginControl lc){
	   	controlador = lc;
	}
}
