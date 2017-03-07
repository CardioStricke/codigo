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
import Model.CellEditable;
import Model.GestionDatos;
import Model.Login;
import javax.swing.GroupLayout.Alignment;
import javax.print.DocFlavor.URL;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
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
import Model.Medico;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author KATY
 */
public class VentanaMedico extends javax.swing.JFrame {

    /**
     * Creates new form VentanaMedico
     */                     
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
	private JTextArea txtInfoMedico;
	public String nombre;
	public String apellidos;
	public String id;
	public String fechaNacimiento;
	private String resulInfo;
	private JLabel lblSlimUem;
	private JLabel lblRellenaNom;
	private JLabel lblRellenaNº;
	private JLabel lblRellenaApell;
	private Medico medico;
	private JTextField textNombre;
	private JTextField textRellenaApellido;
	private JTextField textrellenaFecha;
	private JTextField textRellenaNº;
	private JLabel lblNewLabel;

		
	/**
	 * 
	 */
	public VentanaMedico(Medico medico) {
		this.medico = medico;
		
		setExtendedState(6);
		
		
		//icono CardioStrike
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\icono.png"));
    	    	
		
	
    	initComponents();
    	
    	setLocationRelativeTo(null);
    	panelfoto.setLayout(null);
    	
    	//foto medico
    	lblfoto = new JLabel("");
    	lblfoto.setBounds(-71, 0, 413, 425);
    	panelfoto.add(lblfoto);
    	lblfoto.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\logoMedico.png"));
    	this.repaint();
    	
    	//foto logo
    	ImageIcon imagen = new ImageIcon("src/imagenes/logoSlimUem.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblSlimUem.getWidth(),lblSlimUem.getHeight(),Image.SCALE_DEFAULT));
        lblSlimUem.setIcon(icono);
        this.repaint();
        
        //Redimensionar fotos campos
        ImageIcon imagen2 = new ImageIcon("src/Imagenes/txt_grande.png");
        this.repaint();
        
        textNombre.setText(medico.getNombre());
        textRellenaNº.setText(medico.getnColegiado());
        textRellenaApellido.setText(medico.getApellidos());
        textrellenaFecha.setText(medico.getFechaNacimiento());
        
	}
    
  //icono
	public Image getIconImage() {
    	   Image retValue = Toolkit.getDefaultToolkit().
    	         getImage(ClassLoader.getSystemResource("resources/icono.png"));


    	   return retValue;
    	}

    @SuppressWarnings("unchecked")
                             
    private void initComponents() {
    	
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    
        
        Object[][] contenidoModelo = new Object[medico.getPacientes().size()][3];
        for(int i = 0; i < medico.getPacientes().size(); i++){
        	contenidoModelo[i][0] = medico.getPacientes().get(i).getNombre();
        	contenidoModelo[i][1] = medico.getPacientes().get(i).getApellidos();
        }
        
        JPanel panelfondo = new JPanel();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(panelfondo, GroupLayout.DEFAULT_SIZE, 1914, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(panelfondo, GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
        );
                panelfondo.setLayout(null);
                
                JPanel panel = new JPanel();
                panel.setBounds(667, 85, 14, 862);
                panelfondo.add(panel);
                
                lblNewLabel = new JLabel("New label");
                lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\fotoBlanca.png"));
                panel.add(lblNewLabel);
                
                textNombre = new JTextField();
                textNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
                textNombre.setBorder(null);
                textNombre.setBounds(309, 417, 202, 16);
                panelfondo.add(textNombre);
                textNombre.setColumns(10);
                
                textrellenaFecha = new JTextField();
                textrellenaFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
                textrellenaFecha.setBorder(null);
                textrellenaFecha.setBounds(309, 881, 202, 16);
                panelfondo.add(textrellenaFecha);
                textrellenaFecha.setColumns(10);
                
                textRellenaNº = new JTextField();
                textRellenaNº.setFont(new Font("Tahoma", Font.PLAIN, 20));
                textRellenaNº.setBorder(null);
                textRellenaNº.setBounds(309, 725, 187, 16);
                panelfondo.add(textRellenaNº);
                textRellenaNº.setColumns(10);
                
                textRellenaApellido = new JTextField();
                textRellenaApellido.setFont(new Font("Tahoma", Font.PLAIN, 20));
                textRellenaApellido.setBorder(null);
                textRellenaApellido.setBounds(309, 567, 187, 16);
                panelfondo.add(textRellenaApellido);
                textRellenaApellido.setColumns(10);
                
                JLabel label_1 = new JLabel("");
                label_1.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\txt_grande.png"));
                label_1.setBounds(300, 864, 259, 50);
                panelfondo.add(label_1);
                
                lblRellenaApell = new JLabel("");
                lblRellenaApell.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\txt_grande.png"));
                lblRellenaApell.setBounds(300, 556, 249, 42);
                panelfondo.add(lblRellenaApell);
                
                lblRellenaNº = new JLabel("");
                lblRellenaNº.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\txt_grande.png"));
                lblRellenaNº.setBounds(300, 713, 259, 43);
                panelfondo.add(lblRellenaNº);
                
                lblRellenaNom = new JLabel("");
                lblRellenaNom.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\txt_grande.png"));
                lblRellenaNom.setBounds(300, 388, 242, 65);
                panelfondo.add(lblRellenaNom);
                	
                
                JLabel lblFechaNacimieto = new JLabel("Fecha nacimieto");
                lblFechaNacimieto.setFont(new Font("Tahoma", Font.PLAIN, 30));
                lblFechaNacimieto.setForeground(Color.WHITE);
                lblFechaNacimieto.setBounds(31, 864, 249, 42);
                panelfondo.add(lblFechaNacimieto);
                
                JLabel lblNidentificador = new JLabel("N\u00AAIdentificador");
                lblNidentificador.setFont(new Font("Tahoma", Font.PLAIN, 30));
                lblNidentificador.setForeground(Color.WHITE);
                lblNidentificador.setBounds(31, 703, 211, 53);
                panelfondo.add(lblNidentificador);
                
                JLabel lblApellidos = new JLabel("Apellidos");
                lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 30));
                lblApellidos.setForeground(Color.WHITE);
                lblApellidos.setBounds(31, 545, 135, 53);
                panelfondo.add(lblApellidos);
                
                JLabel lblNombre = new JLabel("Nombre");
                lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
                lblNombre.setForeground(Color.WHITE);
                lblNombre.setBounds(37, 385, 127, 48);
                panelfondo.add(lblNombre);
                
                lblSlimUem = new JLabel("");
                lblSlimUem.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\logoSlimUem.jpg"));
                lblSlimUem.setBounds(903, 47, 848, 152);
                panelfondo.add(lblSlimUem);
        
                lblBuscador = new javax.swing.JLabel();
                lblBuscador.setForeground(Color.WHITE);
                lblBuscador.setFont(new Font("Tahoma", Font.BOLD, 40));
                lblBuscador.setBounds(867, 260, 187, 80);
                panelfondo.add(lblBuscador);
                
                        lblBuscador.setText("BUSCAR");
        
        panelfoto = new JPanel();
        panelfoto.setBounds(37, 60, 267, 253);
        panelfondo.add(panelfoto);
        txtBuscador = new javax.swing.JTextField();
        txtBuscador.setBounds(1124, 279, 296, 42);
        panelfondo.add(txtBuscador);
        
        botonBuscador = new JButton("Buscar");
        botonBuscador.setBounds(1499, 279, 235, 42);
        panelfondo.add(botonBuscador);
        FontUIResource font = new FontUIResource("Verdana", Font.PLAIN, 24);
        UIManager.put("Table.font", font);
        UIManager.put("Table.foreground", Color.RED);
        scrollTabla = new javax.swing.JScrollPane();
        scrollTabla.setBorder(null);
        scrollTabla.setFont(scrollTabla.getFont().deriveFont(scrollTabla.getFont().getSize() + 40f));
        scrollTabla.setBounds(867, 400, 867, 547);
        panelfondo.add(scrollTabla);
        tblLista = new javax.swing.JTable();
        
        tblLista.setModel(new DefaultTableModel(
        		
            contenidoModelo,
            
            new String [] {
              "Nombre", "Apellidos"
            }
            
        ));
        tblLista.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        tblLista.setIntercellSpacing(new java.awt.Dimension(5, 5));
        
        tblLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            if(evt.getClickCount()==2){
            	VentanaPaciente frame = new VentanaPaciente();
				frame.setVisible(true);
				frame.toFront();
			}
				
           }
        });
        scrollTabla.setViewportView(tblLista);
        tblLista.setRowHeight(70);
     
       // tblLista myTable = new tblLista(new CellEditable());
                  	

        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\fondoMedico.jpg"));
        label.setBounds(0, 13, 1915, 1001);
        panelfondo.add(label);
        botonBuscador.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int pos = GestionDatos.buscarPaciente(txtBuscador.getText(), medico.getPacientes());
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

	
	
    
    public void addController (LoginControl lc){
	   	controlador = lc;
	}
}
