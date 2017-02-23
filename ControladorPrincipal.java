package Control;
import java.awt.Cursor;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
/*import javax.swing.JmedlFrame;*/
import javax.swing.JOptionPane;

import Model.*;
import Vista.*;
import java.awt.List;

public class ControladorPrincipal implements ActionListener
{
	
	public JFrame ventanaControlada;
	public ManejadorDeFicheros mf;
	public JComboBox <Login> usersList;
	private List list1;
	
	public ControladorPrincipal(JFrame win){
		ventanaControlada=win;
			}
	
	
	public void actionPerformed(ActionEvent e) {
		
    	String cmd = (String)(e.getActionCommand());
        abrirVentana(cmd);
		
	} 
    
    public void abrirVentana(String cmd)
	{
    	// Creo la ventana para representarlo
		Medico med = new Medico(null);

		// Creo el controlador pasando la ventana
		LoginControl lc = new LoginControl(med, this);
				
		// Le Asociamos el controlador a la ventana
		med.addController(lc);
			
		// La añado a la ventana principal
		ventanaControlada.getContentPane().add(med);
		med.toFront();
				
	}	

	public void cerrarVentana()
	{
		ventanaControlada.dispose();
		System.exit(0);
	}	

/*	public static void main(String args[])
	{
		System.out.println("Starting VentanaPrincipal...");
		
		// Leyendo el Properties 
		Properties appProps = new Properties();
		
		try {
        	FileInputStream in = new FileInputStream("ejemplo.properties");
    		appProps.load(in);
        	in.close();
        	
 		} catch (Exception e) { System.out.println(e.getMessage()); }
		
 		
		// Creo la ventana
		VentanaPrincipal vp = new VentanaPrincipal();
		
		// Creo el controlador pasando la ventana
		ControladorPrincipal cp=new ControladorPrincipal(vp);
		
		// Le Asociamos el controlador a la ventana
		vp.addController(cp);
		vp.crearVista();
		
	}
	*/
}//fin ControladorPrincipal
