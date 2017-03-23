
package Vista;

import java.awt.BorderLayout;
import Model.Tiempo;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.FreeChartAltura;
import Control.FreeChartPulsaciones;
import Control.FreeChartVelocidad;
import Control.FreeChartO2;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;


/**
 * Esta clase crea una ventana en la que se pueden abrir tanto las graficas de la sesion como los comentarios de la sesion
 *@author Guillermo Roiguez
 *@author Ethan Recalde
 *@parameter JPanel crea el panel de la ventana
 *@parameter tiempos array de tiempos en la sesion
 *@parameter velocidades array de velocidades en la sesion
 *@parameter altura array de alturas en la sesion
 *@parameter pulsaciones array de pulsaciones en la sesion
 *@parameter sangre array de eneteros (o2 sangre) en la sesion
 *@version 2.0
 */
public class VentanaSesiones extends JFrame {

	private JPanel PanePreviaVentanaSesioness;
	private ArrayList<Tiempo> tiempos;
	private ArrayList<Float> velocidades;
	private ArrayList<Float> altura; 
	private ArrayList<Integer> pulsaciones; 
	private ArrayList<Integer> sangre; 
	
	
	
	public VentanaSesiones(ArrayList<Tiempo> tiempos, ArrayList<Float> velocidades,ArrayList<Float> altura,
		ArrayList<Integer> pulsaciones,	ArrayList<Integer> sangre) {
		
		this.tiempos = tiempos;
		this.velocidades = velocidades;
		this.altura=altura;
		this.pulsaciones=pulsaciones;
		this.sangre=sangre;
		
		initComponents();
		
	}	
	
	/**
	 * Este metodo contiene la parte grafica de la ventana sesiones (botones, imagenes, etc)
	 *@author Guillermo Roiguez
	 *@author Ethan Recalde
	 *@version 2.0
	 */
	private void initComponents() {
		setExtendedState(6);//tamaño maximo
		setTitle("SESIONES");//titulo
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//no cerrar todo cuando se cierra la ventana
		
		//panel general
		setBounds(100, 100, 739, 489);
		PanePreviaVentanaSesioness = new JPanel();
		PanePreviaVentanaSesioness.setBackground(new Color(224, 255, 255));
		PanePreviaVentanaSesioness.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanePreviaVentanaSesioness);
		PanePreviaVentanaSesioness.setLayout(null);
		
		//Botón de O2 sangre
		JButton btnO2Sangre = new JButton("O2 SANGRE");
		btnO2Sangre.setBounds(181, 406, 212, 60);
		PanePreviaVentanaSesioness.add(btnO2Sangre);
		btnO2Sangre.addActionListener(new ActionListener() {
			
			//acción del botón para que al pulsarlo lleve a la freechart(gráfica) de O2 Sangre
			public void actionPerformed(ActionEvent arg0) {
				FreeChartO2 fco2 = new FreeChartO2("",tiempos,sangre);
				fco2.setVisible(true);
				
			}
		});
		//Boton de pulsaciones
		JButton btnPulsaciones = new JButton("PULSACIONES");
		btnPulsaciones.setBounds(1136, 406, 235, 66);
		PanePreviaVentanaSesioness.add(btnPulsaciones);
		btnPulsaciones.addActionListener(new ActionListener() {
			
			//acción del botón para que al pulsarlo lleve a la freechart(gráfica) de pulsaciones
			public void actionPerformed(ActionEvent arg0) {
				FreeChartPulsaciones fcp = new FreeChartPulsaciones("",tiempos,pulsaciones);
				fcp.setVisible(true);
				fcp.toFront();
				
			}
		});
		//boton de velocidad						
		JButton btnVelocidad = new JButton("VELOCIDAD");
		btnVelocidad.setBounds(154, 810, 286, 70);
		PanePreviaVentanaSesioness.add(btnVelocidad);
		btnVelocidad.addActionListener(new ActionListener() {
			
			//acción del botón para que al pulsarlo lleve a la freechart(gráfica) de velocidad
			public void actionPerformed(ActionEvent arg0) {
				FreeChartVelocidad fcv = new FreeChartVelocidad("", tiempos, velocidades);
				fcv.setVisible(true);
				fcv.toFront();	
				
			}
		});
		
		//boton de altitud
		JButton btnAltitud = new JButton("ALTITUD");
		btnAltitud.setBounds(1136, 821, 259, 70);
		PanePreviaVentanaSesioness.add(btnAltitud);
		btnAltitud.addActionListener(new ActionListener() {
			
			//acción del botón para que al pulsarlo lleve a la freechart(gráfica) de altura
			public void actionPerformed(ActionEvent arg0) {
				FreeChartAltura fca = new FreeChartAltura("",tiempos,altura);
				fca.setVisible(true);
				fca.toFront();	
			
			}
		});
		
		//Botón de comentarios de la sesion
		JButton btnComentariosDeLaSesion = new JButton("COMENTARIOS DE LA SESION");
		btnComentariosDeLaSesion.addActionListener(new ActionListener() {
			
			//acción del botón para que al pulsarlo lleve a la ventana de comentarios de sesion
			public void actionPerformed(ActionEvent e) {
				VentanaComentarios cs= new VentanaComentarios();
				cs.setVisible(true);
				cs.toFront();
			}
		});
		btnComentariosDeLaSesion.setBounds(653, 372, 207, 78);
		PanePreviaVentanaSesioness.add(btnComentariosDeLaSesion);
		
		
		//Panel de velocidad
		JPanel VentanaSesionesVelocidad = new JPanel();
		VentanaSesionesVelocidad.setBounds(37, 490, 540, 307);
		PanePreviaVentanaSesioness.add(VentanaSesionesVelocidad);
		VentanaSesionesVelocidad.setLayout(null);
		
		//Label donde estará la imagen de una gráfica de velocidad
		JLabel lblVelocidad = new JLabel("");
		lblVelocidad.setBounds(0, 50, 540, 290);
		VentanaSesionesVelocidad.add(lblVelocidad);
		lblVelocidad.setIcon(new ImageIcon("src/Imagenes/Grafica.jpg"));
		
		
		//Foto grafica reajsutada al tamaño
	        ImageIcon imagen = new ImageIcon("src/imagenes/Grafica.jpg");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblVelocidad.getWidth(),lblVelocidad.getHeight(),Image.SCALE_DEFAULT));
		lblVelocidad.setIcon(icono);
	    this.repaint();
	    
		
		//Panel de o2 sangre
		JPanel VentanaSesionesO2Sangre = new JPanel();
		VentanaSesionesO2Sangre.setBounds(67, 67, 490, 326);
		PanePreviaVentanaSesioness.add(VentanaSesionesO2Sangre);
		VentanaSesionesO2Sangre.setLayout(null);
		
		//Label donde estará la imagen de una gráfica de O2 Sangre
		JLabel lblSangre = new JLabel("");
		lblSangre.setBounds(0, 0, 490, 326);
		VentanaSesionesO2Sangre.add(lblSangre);
		lblSangre.setIcon(new ImageIcon("src/Imagenes/WhatsApp Image 2017-03-21 at 17.11.56.jpeg"));
		
		//Foto grafica reajsutada al tamaño
		ImageIcon imagen1 = new ImageIcon("src/imagenes/Grafica.jpg");
		Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(lblSangre.getWidth(),lblSangre.getHeight(),Image.SCALE_DEFAULT));
		lblSangre.setIcon(icono);
        this.repaint();
		
		
		//Panel de pulsaciones
		JPanel VentanaSesionesPulsaciones = new JPanel();
		VentanaSesionesPulsaciones.setBounds(975, 60, 557, 330);
		PanePreviaVentanaSesioness.add(VentanaSesionesPulsaciones);
		VentanaSesionesPulsaciones.setLayout(null);
		
		//Label donde estará la imagen de una gráfica de pulsaciones
		JLabel lblPulsaciones = new JLabel("");
		lblPulsaciones.setBounds(0, 0, 557, 330);
		VentanaSesionesPulsaciones.add(lblPulsaciones);
		lblPulsaciones.setIcon(new ImageIcon("src/Imagenes/Grafica.jpg"));
	
		
		//Foto grafica reajsutada al tamaño
		ImageIcon imagen2 = new ImageIcon("src/imagenes/Grafica.jpg");
		Icon icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(lblPulsaciones.getWidth(),lblPulsaciones.getHeight(),Image.SCALE_DEFAULT));
		lblPulsaciones.setIcon(icono);
        this.repaint();
		
		
		//Panel de altitud
		JPanel VentanaSesionesAltitud = new JPanel();
		VentanaSesionesAltitud.setBounds(936, 508, 573, 300);
		PanePreviaVentanaSesioness.add(VentanaSesionesAltitud);
		VentanaSesionesAltitud.setLayout(null);
		
		//Label donde estará la imagen de una gráfica de altitud
		JLabel lblAltitud = new JLabel("");
		lblAltitud.setBounds(0, 51, 573, 302);
		VentanaSesionesAltitud.add(lblAltitud);
		lblAltitud.setIcon(new ImageIcon("src/Imagenes/Grafica.jpg"));
		
		
		//Foto grafica reajsutada al tamaño
		ImageIcon imagen3 = new ImageIcon("src/imagenes/Grafica.jpg");
		Icon icono3 = new ImageIcon(imagen3.getImage().getScaledInstance(lblAltitud.getWidth(),lblAltitud.getHeight(),Image.SCALE_DEFAULT));
		lblAltitud.setIcon(icono);
        this.repaint();
	}
	


}
