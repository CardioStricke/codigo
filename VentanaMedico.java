package Vista;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Control.ControladorPrincipal;
import Control.LoginControl;
import Control.ManejadorDeFicheros;
import Model.GestionDatos;
import Model.Login;
import javax.swing.GroupLayout.Alignment;
import javax.print.DocFlavor.URL;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.JTextArea;
import java.awt.Frame;

/**
 *
 * @author KATY
 */
public class VentanaMedico extends javax.swing.JFrame {

    /**
     * Creates new form VentanaMedico
     */
	private ArrayList<String[]> pacientes;                     
    private javax.swing.JButton botonBuscador;
    private javax.swing.JLabel lblBuscador;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tblLista;
    private javax.swing.JTextField txtBuscador;
	public LoginControl controlador;
	public JComboBox <Login> usersList; 
	public JTextField campoNombre;
	public JTextField campoApellido;
	private JPanel panelfoto;
	private JLabel lblfoto;
	private JLabel lblseparador;
	private JTextArea txtInfoMedico;
	public String nombre;
	public String apellidos;
	public String id;
	public String fechaNacimiento;
	private String resulInfo;
	private JLabel lblSlimUem;
	private JLabel lblRellenaNom;
	private JLabel lblApell;
	private JLabel lblNº;
	private JLabel lblFecha;

	/*public void VentanaMedico(String nombre,String apellidos,String id,String cumpleaños){
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.id=id;
		this.cumpleaños=cumpleaños;
	}*/
	
	
	/**
	 * 
	 */
	public VentanaMedico(ArrayList<String[]> pacientes) {
		setExtendedState(6);
		this.pacientes = pacientes;
		
		//icono CardioStrike
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\icono.png"));
    	    	
		
	
    	initComponents();
    	setLocationRelativeTo(null);
    	//setResizable(false);
    	//setTitle();
    	
    	lblfoto = new JLabel("");
    	lblfoto.setBounds(0, 0, 235, 172);
    	panelfoto.add(lblfoto);
    	lblfoto.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\logoMedico.png"));
    	this.repaint();
    	
    	ImageIcon imagen = new ImageIcon("src/imagenes/logoSlimUem.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblSlimUem.getWidth(),lblSlimUem.getHeight(),Image.SCALE_DEFAULT));
        lblSlimUem.setIcon(icono);
        this.repaint();
    }
    
  
	public Image getIconImage() {
    	   Image retValue = Toolkit.getDefaultToolkit().
    	         getImage(ClassLoader.getSystemResource("resources/icono.png"));


    	   return retValue;
    	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	 //this.setExtendedState(MAXIMIZED_BOTH);
    	 //this.setUndecorated(true);
    	  
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
       
       
        //tabla.setDefaultRenderer(Object.class, new Render());

        //JButton botonSelect = new JButton("Seleccionar");
        
       // DefaultTableModel d= new DefaultTableModel();
        
        Object[][] contenidoModelo = new Object[pacientes.size()][3];
        for(int i = 0; i < pacientes.size(); i++){
        	contenidoModelo[i][0] =null;
		//frame.setVisible(true);
		//	frame.toFront();;//Imagenes Crear clase Render que sea implementada
        	contenidoModelo[i][1] = pacientes.get(i)[0];
        	contenidoModelo[i][2] = pacientes.get(i)[1];
        }
        
        JPanel panelfondo = new JPanel();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(panelfondo, GroupLayout.PREFERRED_SIZE, 1295, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(panelfondo, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
                panelfondo.setLayout(null);
                
                JButton botonInfoMedico = new JButton("VER INFO MEDICO");
                botonInfoMedico.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
                		
                		/*
                		File archivo = new File("C:\\Users\\ethan\\workspace\\CardioStrikee\\Data\\infoMedico.txt");
                		try {
            				BufferedReader leerInfoMedico = new BufferedReader(new FileReader(archivo));
            				VentanaMedico vm;
            				String linea = leerInfoMedico.readLine();
            				while(linea!=null){
            			
	            					for(int i=0;i<4;i++){
		            				if(linea != ";"){
			            				txtInfo.append(linea+"\n");
			            				linea = leerInfoMedico.readLine();
		            				}
	            				}
            				}
            			} catch (Exception ex) {
            				
            				ex.printStackTrace();
            			}*/
                		
                	}
                });
                
                lblNº = new JLabel("");
                lblNº.setBounds(198, 495, 149, 28);
                panelfondo.add(lblNº);
                
                lblApell = new JLabel("New label");
                lblApell.setBounds(198, 438, 122, 39);
                panelfondo.add(lblApell);
                
                lblRellenaNom = new JLabel("");
                lblRellenaNom.setBounds(198, 379, 106, 35);
                panelfondo.add(lblRellenaNom);
                
                lblFecha = new JLabel("New label");
                lblFecha.setBounds(208, 553, 156, 37);
                panelfondo.add(lblFecha);
                	
                
                JLabel lblFechaNacimieto = new JLabel("Fecha nacimieto");
                lblFechaNacimieto.setFont(new Font("Tahoma", Font.PLAIN, 20));
                lblFechaNacimieto.setForeground(Color.WHITE);
                lblFechaNacimieto.setBounds(37, 547, 183, 42);
                panelfondo.add(lblFechaNacimieto);
                
                JLabel lblNidentificador = new JLabel("N\u00AAIdentificador");
                lblNidentificador.setFont(new Font("Tahoma", Font.PLAIN, 20));
                lblNidentificador.setForeground(Color.WHITE);
                lblNidentificador.setBounds(37, 481, 135, 53);
                panelfondo.add(lblNidentificador);
                
                JLabel lblApellidos = new JLabel("Apellidos");
                lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
                lblApellidos.setForeground(Color.WHITE);
                lblApellidos.setBounds(37, 440, 85, 28);
                panelfondo.add(lblApellidos);
                
                JLabel lblNombre = new JLabel("Nombre");
                lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
                lblNombre.setForeground(Color.WHITE);
                lblNombre.setBounds(37, 369, 85, 45);
                panelfondo.add(lblNombre);
                
                lblSlimUem = new JLabel("");
                lblSlimUem.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\logoSlimUem.jpg"));
                lblSlimUem.setBounds(632, 94, 452, 80);
                panelfondo.add(lblSlimUem);
                botonInfoMedico.setBounds(37, 634, 221, 25);
                panelfondo.add(botonInfoMedico);
                
                lblseparador = new JLabel("");
                lblseparador.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\linea.png"));
                lblseparador.setBounds(447, 160, 23, 331);
                panelfondo.add(lblseparador);
        
                lblBuscador = new javax.swing.JLabel();
                lblBuscador.setForeground(Color.WHITE);
                lblBuscador.setFont(new Font("Tahoma", Font.BOLD, 22));
                lblBuscador.setBounds(575, 239, 99, 35);
                panelfondo.add(lblBuscador);
                
                        lblBuscador.setText("BUSCAR");
        
        panelfoto = new JPanel();
        panelfoto.setBounds(37, 60, 267, 253);
        panelfondo.add(panelfoto);
        txtBuscador = new javax.swing.JTextField();
        txtBuscador.setBounds(687, 248, 288, 25);
        panelfondo.add(txtBuscador);
        
        botonBuscador = new JButton("Buscar");
        botonBuscador.setBounds(1006, 248, 116, 25);
        panelfondo.add(botonBuscador);
        scrollTabla = new javax.swing.JScrollPane();
        scrollTabla.setBounds(575, 287, 547, 372);
        panelfondo.add(scrollTabla);
        tblLista = new javax.swing.JTable();
        
        tblLista.setModel(new DefaultTableModel(
            contenidoModelo,
            new String [] {
                "Imagen", "Nombre", "Apellidos"
            }
        ));
       
       /* TableColumn agregarColumn;
        agregarColumn = tblLista.getColumnModel().getColumn(5);
        agregarColumn.setCellEditor(new myeditor(tblLista));
        agregarColumn.setCellRenderer(new Render(true));
        */
        scrollTabla.setViewportView(tblLista);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\fondoMedico.jpg"));
        label.setBounds(0, 0, 1295, 700);
        panelfondo.add(label);
        botonBuscador.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int pos = GestionDatos.buscarPaciente(txtBuscador.getText(), pacientes);
        		if(pos != GestionDatos.NOENCONTRADO){
        			tblLista.getSelectionModel().setSelectionInterval (pos, pos);
        			Rectangle rect = tblLista.getCellRect(pos, 0, true);
        			
        			tblLista.scrollRectToVisible(rect);
        		}else{
        			
        			JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        		}
        	}
        });
        getContentPane().setLayout(layout);
        
        

        pack();
    }// </editor-fold>                        

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	//NO ME SALE HACERLO MODELO VISTA CONTROLADOR
	/*private void botonInfoMedicoActionPerformed(java.awt.event.ActionEvent evt){
		ControladorPrincipal cp=new ControladorPrincipal(this);//llamo al propio objeto de esta VentanaPrincipal principal
		
        //Leer info
 		cp.mf = new ManejadorDeFicheros();
 		resulInfo = cp.mf.infoMedico("C:\\Users\\ethan\\workspace\\CardioStrikee\\Data\\infoMedico.txt", ";");
 	
		
		if(resulInfo == resultado){
    		
	    	//clase capaz de encolar eventos de forma asíncrona.
	    	EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						File archivo = new File("C:\\Users\\ethan\\workspace\\CardioStrikee\\Data\\infoMedico.txt");
						BufferedReader leerInfoMedico = new BufferedReader(new FileReader(archivo));
        				String linea = leerInfoMedico.readLine();
        				while(linea!=null){
        				//	VentanaMedico vm = new VentanaMedico();
        				
        				txtInfo.append(linea+"\n");
        				linea = leerInfoMedico.readLine();
        				}
					
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	    	}
	}*/
    
    public void addController (LoginControl lc){
	   	controlador = lc;
	}
}