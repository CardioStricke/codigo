package Vista;

import java.awt.BorderLayout;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Control.*;
import Model.Medico;
import Vista.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.Font;
import com.sun.awt.AWTUtilities;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import Model.Paciente;


/**
 * Esta clase crea la parte grafica del Login 
 *@author Ethan Recalde
 *@version 1.0
 */
public class VentanaPrincipal extends JFrame {
	
	private javax.swing.JButton botonEntrar;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtUsuario;
         
	private JPanel contentPane;
	public ControladorPrincipal controlador;
	public ManejadorDeFicheros mf;
	private Object resulbusca;
	private javax.swing.JLabel lblCardio;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel lblFondo;
	private int x,y;
	private JLabel lblLogoSlim;
	private ImageIcon imagen;
	private Icon icono;
	
	
	
	/**
	 *Main del programa, mayormente generado al utilizar windows builder y pasar el codigo de netbeans
	 *@author Ethan Recalde
	 */
	public static void main(String[] args) {
		  try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					   
				} catch (Exception e) {
					e.printStackTrace();
				}
				 new VentanaPrincipal().setVisible(true);
			}
		});
	}
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(525, 535));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(730, 380));

        jPanel1.setOpaque(false);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel1.setLayout(null);
		
		JLabel lblBonito = new JLabel("");
		lblBonito.setForeground(Color.WHITE);
		lblBonito.setBackground(Color.WHITE);
		lblBonito.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\txt_med.png"));
		lblBonito.setBounds(173, 128, 212, 39);
		jPanel1.add(lblBonito);
		txtPassword = new javax.swing.JPasswordField();
		txtPassword.setBorder(null);
		txtPassword.setBounds(180, 216, 173, 14);
		jPanel1.add(txtPassword);
		
			txtPassword.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					PasswordActionPerformed(evt);
				}
			});
		botonEntrar = new javax.swing.JButton();
		botonEntrar.setBounds(219, 251, 101, 37);
		jPanel1.add(botonEntrar);
		
				        botonEntrar.setText("Entrar");
				        
				        botonEntrar.addActionListener(new java.awt.event.ActionListener() {
				            public void actionPerformed(java.awt.event.ActionEvent evt) {
				                BotonEntrarActionPerformed(evt);
				            }
				        });
        
		//VentanaPrincipal 
		
		lblUsuario = new javax.swing.JLabel();
		lblUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(229, 103, 81, 14);
		jPanel1.add(lblUsuario);
		
			lblUsuario.setText("Usuario");
			lblContraseña = new javax.swing.JLabel();
			lblContraseña.setForeground(Color.WHITE);
			lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblContraseña.setBounds(219, 172, 111, 14);
			jPanel1.add(lblContraseña);
			
				lblContraseña.setText("Contrase\u00F1a");
			txtUsuario = new javax.swing.JTextField();
			txtUsuario.setBorder(null);
			txtUsuario.setBounds(180, 138, 168, 16);
			jPanel1.add(txtUsuario);
			
				txtUsuario.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						txtUsuarioActionPerformed(evt);
					}
				});
			
			JLabel lblExit = new JLabel("");
			lblExit.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\cerrar_44.png"));
			 lblExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		                lblExitMouseClicked(evt);
		            }
		        });
		        jPanel1.add(lblExit);
		        lblExit.setBounds(676, 11, 44, 46);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\txt_med.png"));
			label.setBounds(173, 196, 197, 50);
			jPanel1.add(label);
			
			lblLogoSlim = new JLabel("");
			lblLogoSlim.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\logoSlimUem.jpg"));
			lblLogoSlim.setBounds(195, 32, 138, 46);
			jPanel1.add(lblLogoSlim);
		       
			lblCardio = new javax.swing.JLabel();
			lblCardio.setBounds(0, 0, 730, 457);
			
			        lblCardio.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\cardiofondo.png"));
			        jPanel1.add(lblCardio);

        pack();
    }//fin initComponents                       

	 private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {                                     
	        System.exit(0);
	    }             
	
	
	//interfaz grafica
	public VentanaPrincipal() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
	
		this.setResizable(false);//bloquea maximizar
	
		
			initComponents();
	        this.setLocationRelativeTo(null);
	        AWTUtilities.setWindowOpaque(this, false);
	        
	        ImageIcon imagen = new ImageIcon("src/imagenes/logoSlimUem.jpg");
	        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblLogoSlim.getWidth(),lblLogoSlim.getHeight(),Image.SCALE_DEFAULT));
	        lblLogoSlim.setIcon(icono);
	        this.repaint();
	       
		
		//vista
		setTitle("VentanaPrincipalPrincipal");
				
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		        GroupLayout groupLayout = new GroupLayout(getContentPane());
		        groupLayout.setHorizontalGroup(
		        	groupLayout.createParallelGroup(Alignment.LEADING)
		        		.addGap(0, 730, Short.MAX_VALUE)
		        );
		        groupLayout.setVerticalGroup(
		        	groupLayout.createParallelGroup(Alignment.LEADING)
		        		.addGap(0, 535, Short.MAX_VALUE)
		        );
		        getContentPane().setLayout(groupLayout);
		        getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblContraseña, lblUsuario, txtUsuario, botonEntrar, txtPassword}));

		        pack();
		    }
	
	//controlador
	public void addController (ControladorPrincipal mc){
		controlador=mc;
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				System.exit(0);
			}
		});
	}
	
	public void crearVista (){
		setContentPane(new JDesktopPane());
		setVisible(true);
	}
	private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                           
    }                                          
    private void BotonEntrarActionPerformed(java.awt.event.ActionEvent evt) {      
                                      
    	String usuario = txtUsuario.getText();
        String contraseña = String.valueOf(txtPassword.getText());
        
    	// Creo el controlador pasando la VentanaPrincipal
		ControladorPrincipal cp=new ControladorPrincipal(this);//llamo al propio objeto de esta VentanaPrincipal principal
		
        //Leer Usuarios
 		cp.mf = new ManejadorDeFicheros();
 		resulbusca = cp.mf.buscaUsuario(txtUsuario.getText(),txtPassword.getText(),"C:\\Users\\ethan\\workspace\\CardioStrikee\\Data\\login.txt", ";");
 			
 		
    	if(resulbusca instanceof Paciente){
    		
    	//clase capaz de encolar eventos de forma asíncrona.
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					VentanaPaciente frame = new VentanaPaciente((Paciente)resulbusca);
					frame.setVisible(true);
					frame.toFront();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});dispose();
    	}
    	
    	if(resulbusca instanceof Medico){
    		
    		
    		EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					
    					VentanaMedico frame = new VentanaMedico((Medico)resulbusca);
    					
    					frame.setVisible(true);
    					frame.toFront();
    					frame.setTitle(((Medico)resulbusca).getNombre()+" "+((Medico)resulbusca).getApellidos());
    						
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});	dispose();
		}
    	
	    
	    		if(resulbusca == null){//mensaje de error
	    			JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta");
	    		
	    	
	    	
    	}
        
    
    }//fin accion boton entrar                                           
    
    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {                                         
    }
}//fin VentanaPrincipalPrincipal
