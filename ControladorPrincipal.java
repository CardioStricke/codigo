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
	/**
	 * Atributos del controlador
	 * @param ventanaControlada
	 * @param mf
	 * @param userlist
	 * @param list1
	 * */
	public JFrame ventanaControlada;
	public ManejadorDeFicheros mf;
	
	//Es un componente Swing que muestra una lista desplegable de opciones y permite al usuario seleccionar un elemento de la lista.
	public JComboBox <Login> usersList;
	private List list1;
	
	/**
	 * Asiganmos el control a la ventana
	 * */
	public ControladorPrincipal(JFrame win){
		ventanaControlada=win;
			}
	
	/**
	 * Definimos el evento 
	 * */
	public void actionPerformed(ActionEvent e) {
		
    	String cmd = (String)(e.getActionCommand());
        abrirVentana(cmd);
		
	} 
    /**
     * asignamos el control al medico
     * */
    public void abrirVentana(String cmd)
	{
    	// Creo la ventana para representarlo
		VentanaMedico med = new VentanaMedico(null);

		// Creo el controlador pasando la ventana
		LoginControl lc = new LoginControl(med, this);
				
		// Le Asociamos el controlador a la ventana
		med.addController(lc);
			
		// La añado a la ventana principal
		ventanaControlada.getContentPane().add(med);
		med.toFront();
				
	}	

    /**
     * Metodo que permite cerrar la ventana
     * */
	public void cerrarVentana()
	{
		ventanaControlada.dispose();
		System.exit(0);
	}	


}//fin ControladorPrincipal
