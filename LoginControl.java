package Control;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import Model.*;
import Vista.*;

;/**
*
 */
public class LoginControl implements ActionListener
{
	public final static String SELECCIONAR="S";
	public final static String MODIFICAR="M";

	
	
	public VentanaMedico ventanaControlada;
	public ControladorPrincipal controlPrincipal;
	
	
	public LoginControl (VentanaMedico win, ControladorPrincipal cp)	{
		ventanaControlada = win;
		controlPrincipal = cp;
	}
	
	
	public void actionPerformed(ActionEvent e) {
	
		
/*		Cambio el cursor por un relog
		Cursor cur = new Cursor(Cursor.WAIT_CURSOR);
        ventanaControlada.setCursor(cur);  */      

    	String cmd = (String)(e.getActionCommand());
        if (cmd == LoginControl.MODIFICAR) {
        	Login user = (Login)ventanaControlada.usersList.getSelectedItem();
        	user.usuario=ventanaControlada.campoNombre.getText();
        	user.contraseña=ventanaControlada.campoApellido.getText();
        	
        	ventanaControlada.usersList.repaint(); //Para que se actualice el cambio en el combo
        	//controlPrincipal.mf.escribirUsuarios(controlPrincipal.listaUsuarios);
        	ventanaControlada.dispose();
		} else if (cmd==LoginControl.SELECCIONAR) {
        	Login user = (Login)ventanaControlada.usersList.getSelectedItem();
			
			ventanaControlada.campoNombre.setText(user.usuario);
			ventanaControlada.campoApellido.setText(user.contraseña);
			
		}
        
       /* // Dejo el cursor como estaba
		cur = new Cursor(Cursor.DEFAULT_CURSOR);
        ventanaControlada.setCursor(cur);        
    
    */
   } 
    
    public void mostrar(String mensaje)
	{
		JOptionPane.showMessageDialog(ventanaControlada, mensaje);	
	}	

}