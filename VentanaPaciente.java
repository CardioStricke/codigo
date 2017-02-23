package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.LoginControl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPaciente extends JFrame {

	private JPanel contentPane;
	public LoginControl controlador;
	
	
	/**
	 * Creaamos la ventana
	 */
	public VentanaPaciente() {
		this.setTitle("Paciente");//titulo de la ventana
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//DISPOSE, al cerrar poder seguir probando logins
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}
	
	public void addController (LoginControl lc){
	   	controlador = lc;
	}
	
}
