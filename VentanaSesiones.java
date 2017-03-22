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
import Control.GraficaO2Sangre;

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

public class VentanaSesiones extends JFrame {

	private JPanel PanePreviaVentanaSesioness;
	private ArrayList<Tiempo> tiempos;
	private ArrayList<Float> velocidades;

	/*public static void main(String[]args){
		try{
			VentanaSesiones vs = new VentanaSesiones();
			vs.setVisible(true);
			vs.toFront();
		}catch(NullPointerException e){
			System.out.print(e.getMessage());
		}
	}*/
	
	public VentanaSesiones(ArrayList<Tiempo> tiempos, ArrayList<Float> velocidades) {
		this.tiempos = tiempos;
		this.velocidades = velocidades;
		initComponents();
		
	}	
	
	private void initComponents() {
		setExtendedState(6);
		setTitle("SESIONES");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			
		setBounds(100, 100, 739, 489);
		PanePreviaVentanaSesioness = new JPanel();
		PanePreviaVentanaSesioness.setBackground(new Color(224, 255, 255));
		PanePreviaVentanaSesioness.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanePreviaVentanaSesioness);
		PanePreviaVentanaSesioness.setLayout(null);
		
		JButton btnO2Sangre = new JButton("O2 SANGRE");
		btnO2Sangre.setBounds(181, 406, 212, 60);
		PanePreviaVentanaSesioness.add(btnO2Sangre);
		btnO2Sangre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GraficaO2Sangre fco2 = new GraficaO2Sangre("");
				fco2.setVisible(true);
				
			}
		});
		
		JButton btnPulsaciones = new JButton("PULSACIONES");
		btnPulsaciones.setBounds(1136, 406, 235, 66);
		PanePreviaVentanaSesioness.add(btnPulsaciones);
		btnPulsaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FreeChartPulsaciones fcp = new FreeChartPulsaciones("");
				fcp.setVisible(true);
				fcp.toFront();
				
			}
		});
								
		JButton btnVelocidad = new JButton("VELOCIDAD");
		btnVelocidad.setBounds(154, 810, 286, 70);
		PanePreviaVentanaSesioness.add(btnVelocidad);
		btnVelocidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FreeChartVelocidad fcv = new FreeChartVelocidad("", tiempos, velocidades);
				fcv.setVisible(true);
				fcv.toFront();	
				
			}
		});
		
		
		JButton btnAltitud = new JButton("ALTITUD");
		btnAltitud.setBounds(1136, 821, 259, 70);
		PanePreviaVentanaSesioness.add(btnAltitud);
		btnAltitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FreeChartAltura fca = new FreeChartAltura("");
				fca.setVisible(true);
				fca.toFront();	
			
			}
		});
		
		
		JButton btnComentariosDeLaSesion = new JButton("COMENTARIOS DE LA SESION");
		btnComentariosDeLaSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComentariosDeLaSesion.setBounds(653, 372, 207, 78);
		PanePreviaVentanaSesioness.add(btnComentariosDeLaSesion);
		
		JPanel VentanaSesionesVelocidad = new JPanel();
		VentanaSesionesVelocidad.setBounds(37, 490, 540, 307);
		PanePreviaVentanaSesioness.add(VentanaSesionesVelocidad);
		VentanaSesionesVelocidad.setLayout(null);
		
		JLabel lblVelocidad = new JLabel("");
		lblVelocidad.setBounds(0, 50, 540, 290);
		VentanaSesionesVelocidad.add(lblVelocidad);
		lblVelocidad.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\Grafica.jpg"));
		
		
		//Foto grafica
	
		ImageIcon imagen = new ImageIcon("src/imagenes/Grafica.jpg");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblVelocidad.getWidth(),lblVelocidad.getHeight(),Image.SCALE_DEFAULT));
		lblVelocidad.setIcon(icono);
	    this.repaint();
	    
		
		JPanel VentanaSesionesO2Sangre = new JPanel();
		VentanaSesionesO2Sangre.setBounds(67, 67, 490, 326);
		PanePreviaVentanaSesioness.add(VentanaSesionesO2Sangre);
		VentanaSesionesO2Sangre.setLayout(null);
		
		JLabel lblSangre = new JLabel("");
		lblSangre.setBounds(0, 0, 490, 326);
		VentanaSesionesO2Sangre.add(lblSangre);
		lblSangre.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\WhatsApp Image 2017-03-21 at 17.11.56.jpeg"));
		
		//Foto grafica
		ImageIcon imagen1 = new ImageIcon("src/imagenes/Grafica.jpg");
		Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(lblSangre.getWidth(),lblSangre.getHeight(),Image.SCALE_DEFAULT));
		lblSangre.setIcon(icono);
        this.repaint();
		
		JPanel VentanaSesionesPulsaciones = new JPanel();
		VentanaSesionesPulsaciones.setBounds(975, 60, 557, 330);
		PanePreviaVentanaSesioness.add(VentanaSesionesPulsaciones);
		VentanaSesionesPulsaciones.setLayout(null);
		
		JLabel lblPulsaciones = new JLabel("");
		lblPulsaciones.setBounds(0, 0, 557, 330);
		VentanaSesionesPulsaciones.add(lblPulsaciones);
		lblPulsaciones.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\Grafica.jpg"));
	
		
		//Foto grafica
		ImageIcon imagen2 = new ImageIcon("src/imagenes/Grafica.jpg");
		Icon icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(lblPulsaciones.getWidth(),lblPulsaciones.getHeight(),Image.SCALE_DEFAULT));
		lblPulsaciones.setIcon(icono);
        this.repaint();
		
		JPanel VentanaSesionesAltitud = new JPanel();
		VentanaSesionesAltitud.setBounds(936, 508, 573, 300);
		PanePreviaVentanaSesioness.add(VentanaSesionesAltitud);
		VentanaSesionesAltitud.setLayout(null);
		
		JLabel lblAltitud = new JLabel("");
		lblAltitud.setBounds(0, 51, 573, 302);
		VentanaSesionesAltitud.add(lblAltitud);
		lblAltitud.setIcon(new ImageIcon("C:\\Users\\ethan\\workspace\\CardioStrikee\\src\\Imagenes\\Grafica.jpg"));
		
		
		//Foto grafica
		ImageIcon imagen3 = new ImageIcon("src/imagenes/Grafica.jpg");
		Icon icono3 = new ImageIcon(imagen3.getImage().getScaledInstance(lblAltitud.getWidth(),lblAltitud.getHeight(),Image.SCALE_DEFAULT));
		lblAltitud.setIcon(icono);
        this.repaint();
	}
	


}
