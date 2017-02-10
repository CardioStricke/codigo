package Control;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import Model.*;
import Vista.*;

;public class ControladorPrincipal implements ActionListener
{
	
	public JFrame ventanaControlada;
	public ManejadorDeFicheros mf;

	
	public ControladorPrincipal(JFrame win){
		ventanaControlada=win;
			}
	
	
	public void actionPerformed(ActionEvent e) {
		/*// Cambio el cursor por un relog
		Cursor cur = new Cursor(Cursor.WAIT_CURSOR);
        ventanaControlada.setCursor(cur);        
		 */
		
    	String cmd = (String)(e.getActionCommand());
        abrirVentana(cmd);
		
		/*// Dejo el cursor como estaba
		cur = new Cursor(Cursor.DEFAULT_CURSOR);
        ventanaControlada.setCursor(cur);        
   */ 
	} 
    
    public void abrirVentana(String cmd)
	{
		//Comprobar si estas seguro de abrir la ventana...
    	/*int respuesta=JOptionPane.showConfirmDialog(ventanaControlada, 
						"¿Seguro?", "¿Seguro?", JOptionPane.YES_NO_OPTION);
		if (respuesta==JOptionPane.YES_OPTION)
		*/
    	{
			
			//if (cmd.equals(ControladorPrincipal.LISTA)) {

				// Creo la ventana para representarlo
				VentanaMedico interna = new VentanaMedico();

				// Creo el controlador pasando la ventana
				LoginControl ic = new LoginControl(interna, this);
				
				// Le Asociamos el controlador a la ventana
				interna.addController(ic);
				interna.crearVista();

				// La añado a la ventana principal
				ventanaControlada.getContentPane().add(interna);
				try {
					interna.setSelected(true);
				} catch (Exception e) {
					System.out.println("Error tratando de seleccionar la ventana:"+ e.getMessage());
					return;
				}
				interna.toFront();
				
			//} else {
				
				// Mostrar Ventana para TABLA
			//}
			
		}
	}	

	public void cerrarVentana()
	{
		ventanaControlada.dispose();
		System.exit(0);
	}	

	public static void main(String args[])
	{
		System.out.println("Starting VentanaPrincipal...");
		
		// Leyendo el Properties --> QUE PROPIEDADES??????
		
		Properties appProps = new Properties();
		
		String usersPath="";
		
        try {
        	FileInputStream in = new FileInputStream("ejemplo.properties");
    		appProps.load(in);
        	in.close();
        
        	usersPath=appProps.getProperty("UsersPath");
        	
 		} catch (Exception e) { System.out.println(e.getMessage()); }
		
 		
		// Creo la ventana
		VentanaPrincipal vp = new VentanaPrincipal();
		
		// Creo el controlador pasando la ventana
		ControladorPrincipal cp=new ControladorPrincipal(vp);
		
		// Le Asociamos el controlador a la ventana
		vp.addController(cp);
		vp.crearVista();
		
		//Leer Usuarios LA HE LIADO***************************************************
 		cp.mf = new ManejadorDeFicheros();
 		int resulbusca = cp.mf.leerUsuarios("Ethan","Recalde","C:\\Users\\KATY\\workspace\\CardioStrikee\\Data\\usuarios2.txt", ";");
 		System.out.println("Resultado de buscar en el fichero:"+resulbusca);
 		
 			}
}
