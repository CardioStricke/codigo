package Vista;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Control.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;

public class VentanaPrincipal extends JFrame {
	
	private javax.swing.JButton BotonEntrar;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtUsuario;
         
	private JPanel contentPane;
	public ControladorPrincipal controlador;
	public ManejadorDeFicheros mf;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * creo mi interfaz gráfica
	 */
	public VentanaPrincipal() {
		
		        lblUsuario = new javax.swing.JLabel();
		        lblContraseña = new javax.swing.JLabel();
		        txtUsuario = new javax.swing.JTextField();
		        Password = new javax.swing.JPasswordField();
		        BotonEntrar = new javax.swing.JButton();
		        jButton1 = new javax.swing.JButton();

		     // Creamos la vista 
				setSize(600, 600);
				setTitle("VentanaPrincipal");
				
		        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		        lblUsuario.setText("Usuario");

		        lblContraseña.setText("Contraseña:");

		        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                txtUsuarioActionPerformed(evt);
		            }
		        });

		        Password.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                PasswordActionPerformed(evt);
		            }
		        });

		        BotonEntrar.setText("Entrar");
		        BotonEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		                BotonEntrarMouseClicked(evt);
		            }
		        });
		        BotonEntrar.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                BotonEntrarActionPerformed(evt);
		            }
		        });

		        jButton1.setText("Salir");
		        jButton1.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButton1ActionPerformed(evt);
		            }
		        });

		        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		        layout.setHorizontalGroup(
		        	layout.createParallelGroup(Alignment.LEADING)
		        		.addGroup(layout.createSequentialGroup()
		        			.addGap(78)
		        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
		        				.addComponent(lblContraseña)
		        				.addComponent(lblUsuario))
		        			.addGap(18)
		        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
		        				.addComponent(txtUsuario)
		        				.addGroup(layout.createSequentialGroup()
		        					.addComponent(BotonEntrar)
		        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        					.addComponent(jButton1))
		        				.addComponent(Password, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
		        			.addContainerGap(24, Short.MAX_VALUE))
		        );
		        layout.setVerticalGroup(
		        	layout.createParallelGroup(Alignment.LEADING)
		        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
		        			.addContainerGap(80, Short.MAX_VALUE)
		        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		        				.addComponent(lblUsuario)
		        				.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		        			.addGap(18)
		        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		        				.addComponent(lblContraseña)
		        				.addComponent(Password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		        			.addGap(19)
		        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
		        				.addComponent(BotonEntrar)
		        				.addComponent(jButton1))
		        			.addGap(106))
		        );
		        getContentPane().setLayout(layout);

		        pack();
		    }
	
	/*
	 * 
	 */
	public void addController (ControladorPrincipal mc)
	{
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
	
	public void crearVista ()
	{

		
		setContentPane(new JDesktopPane());
		setVisible(true);
	}
	
	
	private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void BotonEntrarMouseClicked(java.awt.event.MouseEvent evt) {                                         
        String Usuario = txtUsuario.getText();
        String Contraseña = String.valueOf(Password.getText());
        
    	// Creo el controlador pasando la ventana
		ControladorPrincipal cp=new ControladorPrincipal(vp);
		
        //Leer Usuarios LA HE LIADO***************************************************
 		cp.mf = new ManejadorDeFicheros();
 		int resulbusca = cp.mf.leerUsuarios("Ethan","Recalde","C:\\Users\\KATY\\workspace\\CardioStrikee\\Data\\usuarios2.txt", ";");
 		System.out.println("Resultado de buscar en el fichero:"+resulbusca);
 		
  
     }                                        

    private void BotonEntrarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        //Medico MED = new igMedico();
        //MED.setVisible(true);
        //dispose();
    	
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPaciente frame = new VentanaPaciente();
					frame.setVisible(true);
					frame.toFront();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
// TODO add your handling code here:
    }                                           

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);        // TODO add your handling code here:
    }                                        

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }

	/*    private void BotonInstruccActionPerformed(java.awt.event.ActionEvent evt) {                                              
        Instrucciones INS = new Instrucciones();
        INS.setVisible(true);
        dispose();
   } */                                            

   /* private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        Informacion INF= new Informacion();
        INF.setVisible(true);
        dispose();
       
    }  */               

}
