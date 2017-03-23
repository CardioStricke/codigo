package Vista;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import Control.LoginControl;
import Control.ManejadorDeFicheros;
import Model.GestionDatos;
import Model.Medico;
import Model.Paciente;
import Model.Sesion;
import Model.Tiempo;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	/**
	*Atributos de la VentanaPaciente
	*@param contentpane
	*@param controlador
	*@param txtBuscador
	*@param table
	*@param lblSlimuem
	*@param textArea
	*@param textNombre
	*@param textApellidos
	*@param textId
	*@param textFecha
	*@param paciente
	*@param fichero
	*@param modelo
	*@param tiempos
	*@param velocidades
	*@param altura
	*@param pulsaciones
	*@param sangre
	*/
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
	private Paciente paciente;
	private File fichero;
	private DefaultTableModel modelo;
	private ArrayList<Tiempo> tiempos;
	private ArrayList<Float> velocidades; 
	private ArrayList<Float> altura; 
	private ArrayList<Integer> pulsaciones; 
	private ArrayList<Integer> sangre; 
	
	
	/**
	 * Creamos la ventana en el constructor
	 */
	public VentanaPaciente(Paciente paciente) {
		this.paciente = paciente;
		//Maximizar
		setExtendedState(6);
		//titulo de cada paciente
		this.setTitle(paciente.getNombre()+" "+paciente.getApellidos());//titulo de la ventana
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//DISPOSE, al cerrar poder seguir probando logins
		setBounds(100, 100, 770, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//logo cardio strike
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\icono.png"));
		initComponents();
		}
	
	
		private void initComponents() {
			
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBounds(0, 0, 1914, 1001);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnPulsar = new JButton("PULSAR");
		btnPulsar.setBounds(470, 118, 97, 25);
		panel_1.add(btnPulsar);
		
		JLabel lblBuscar = new JLabel("BUSCAR:");
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblBuscar.setBounds(693, 349, 188, 49);
		panel_1.add(lblBuscar);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 25, 338, 300);
		panel_1.add(panel);
		panel.setLayout(null);
			
		//foto perfil
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
		btnBuscar.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent arg0) {
				//falta el buscador de sesiones
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBuscar.setBounds(1385, 349, 231, 49);
		panel_1.add(btnBuscar);
		
		txtBuscador = new JTextField();
		txtBuscador.setBounds(1028, 358, 285, 45);
		panel_1.add(txtBuscador);
		txtBuscador.setColumns(10);
		     
		
		
		JButton btnNuevaSesion = new JButton("Nueva Sesion");
		btnNuevaSesion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNuevaSesion.setBounds(885, 162, 256, 75);
		panel_1.add(btnNuevaSesion);

		btnNuevaSesion.addMouseListener(new MouseAdapter() {
			
			
		     	//accion del boton
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
			         
			         /*formato nombre fichero sesiones. 
			          * IdPaciente_IdSesion_Fecha_Hora*/
			         if(seleccion==JFileChooser.APPROVE_OPTION){
					 //selecciono el fichero
			        	 fichero=fc.getSelectedFile();
					 //llamo a manejador de ficheros
			        	 ManejadorDeFicheros mf = new ManejadorDeFicheros();
			        	 ArrayList<Sesion> sesiones = mf.buscaSesiones(fichero);
			        	 
					 //guardo en tiempos el metodo que contiene el tiempo de sesiones
			     		 tiempos = GestionDatos.obtenerTiempos(sesiones);
					 //guardo en pulsaciones el metodo que contiene las pulsaciones de sesiones
			     		 pulsaciones = GestionDatos.obtenerPulsaciones(sesiones); 
					  //guardo en altura el metodo que contiene la altitud de sesiones
			     		 altura = GestionDatos.obtenerDistancia(sesiones);
					  //guardo en sangre el metodo que contiene el porcentaje de oxigeno en sangre de sesiones
			     		 sangre = GestionDatos.obtenerOxigenoSangre(sesiones);
					  //guardo en velocidades el metodo que contiene las velocidades de sesiones
			     		 velocidades =  GestionDatos.obtenerVelocidades(sesiones);
			        	
			     		 //guardo el nombre del fichero
			     		 String nombreFichero = fichero.getName();
			        	 //guardo el numero de la sesion
					 String sesion = "Sesion "+Integer.parseInt(nombreFichero.substring(3,5));
			        	 //guardamos la fecha del fichero separada por posiciones dd:mm::aa
					 String fecha = nombreFichero.substring(6,8)+"/"+ nombreFichero.substring(8, 10)+"/"+nombreFichero.substring(10,14);
			        	 //guardo la hora de inicio de sesion
					 String hora = nombreFichero.substring(15,17)+":"+ nombreFichero.substring(17,19)+":"+nombreFichero.substring(19,21);
			        	
			        			}
		});
		
		
		JButton btnConsejos = new JButton("Consejos");
		btnConsejos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnConsejos.setBounds(1272, 162, 240, 75);
		panel_1.add(btnConsejos);
		btnConsejos.addMouseListener(new MouseAdapter() {
		
			//función para que el boton Consejos lleve a la Ventana Consejos
			
			public void mouseClicked(MouseEvent arg0) {
				VentanaConsejos vc = new VentanaConsejos();
				vc.setVisible(true);
				vc.toFront();
			
			
			}
		});
		FontUIResource font = new FontUIResource("Verdana", Font.PLAIN, 24);
        UIManager.put("Table.font", font);
        UIManager.put("Table.foreground", Color.RED);
       
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(693, 430, 923, 481);
		panel_1.add(scrollPane);
		
		table = new JTable(){
			//Evitar que sea editable la tabla
			 public boolean isCellEditable(int rowIndex, int vColIndex) {
	             return false;
	         }
		  };
	  
		table.addMouseListener(new MouseAdapter() {
	
			public void mouseClicked(MouseEvent evt) {
				 if(evt.getClickCount()==2){
		            	VentanaSesiones frame = new VentanaSesiones(tiempos, velocidades,altura,pulsaciones,sangre);
						frame.setVisible(true);
						frame.toFront();
					}
			}
		});
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		table.setRowHeight(50);
		table.setColumnSelectionAllowed(true);
		
		modelo = new DefaultTableModel(
				new Object[][] {
					{null, null, null},
				},
				new String[] {
					 "Sesion", "Fecha", "Hora"
				}
			) {
				Class[] columnTypes = new Class[] {
					Object.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			};
		table.setModel(modelo);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(190);
		table.getColumnModel().getColumn(1).setPreferredWidth(190);
		table.getColumnModel().getColumn(2).setPreferredWidth(190);
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
		
		JLabel lblID = new JLabel("N\u00BA Paciente");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblID.setForeground(Color.WHITE);
		lblID.setBounds(20, 716, 149, 37);
		panel_1.add(lblID);
		
		lblSlimuem = new JLabel("SlimUem");
		lblSlimuem.setIcon(new ImageIcon("C:\\Users\\alexcebrian368\\Desktop\\CardioStrikee\\src\\CardioStrike\\src\\imagenes\\logoSlimUem.jpg"));
		lblSlimuem.setBounds(693, 53, 225, 59);
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
		
		textNombre.setText(paciente.getNombre());
		textApellidos.setText(paciente.getApellidos());
		textId.setText(String.valueOf(paciente.getIdPaciente()));
		textFecha.setText(paciente.getFechaNacimiento());
	}
	
	public void addController (LoginControl lc){
	   	controlador = lc;
	}
}
