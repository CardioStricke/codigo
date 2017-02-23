package Control;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.*;
import Vista.*;

/*
* Detectar y manejar eventos de acción
*/
public class LoginControl implements ActionListener
{
	public final static String SELECCIONAR="S";
	public final static String MODIFICAR="M";

	
	
	public Medico ventanaControlada;
	public ControladorPrincipal controlPrincipal;
	
	
	//constructor
	public LoginControl (Medico win, ControladorPrincipal cp)	{
		ventanaControlada = win;
		controlPrincipal = cp;
	}
	
	
	public void actionPerformed(ActionEvent e) {
	
    	String cmd = (String)(e.getActionCommand());
        if (cmd == LoginControl.MODIFICAR) {
        	Login user = (Login)ventanaControlada.usersList.getSelectedItem();
        	user.usuario=ventanaControlada.campoNombre.getText();
        	user.contraseña=ventanaControlada.campoApellido.getText();
        	
        	ventanaControlada.usersList.repaint(); //Para que se actualice el cambio en el combo
        	ventanaControlada.dispose();
		} else if (cmd==LoginControl.SELECCIONAR) {
        	Login user = (Login)ventanaControlada.usersList.getSelectedItem();
			
			ventanaControlada.campoNombre.setText(user.usuario);
			ventanaControlada.campoApellido.setText(user.contraseña);
			
		}
        
   } 
  

}