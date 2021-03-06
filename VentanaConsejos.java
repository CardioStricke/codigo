package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

/**
*
* Esta clase crea una ventana en la que habrán una serie de consejos ordenados en una jtable
* @author Alejandro Cebrian
* @param contentpane donde estarán todos los componentes de la ventana
* @param table_1 será una jtable dentro de un scrollpane donde se localizarán todos los consejos
*/


public class VentanaConsejos extends JFrame {

	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConsejos frame = new VentanaConsejos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaConsejos() {
	
	        //Establece el icono de cardio strike en la esquina superior izquierda
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\alexcebrian368\\Desktop\\CardioStrikee\\src\\CardioStrike\\src\\imagenes\\icono.png"));
		
	
		//titulo para la ventana
		this.setTitle("Consejos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//subpanel que contendrá un textArea, un label de titulo, y un label de fondo 
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(231, 63, 331, 294);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//textarea del sub panel
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 62, 311, 221);
		panel_1.add(textArea);
		
		//label del titulo para el sub panel
		JLabel lblTitulo = new JLabel(" CONSEJO");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitulo.setBounds(10, 6, 311, 45);
		panel_1.add(lblTitulo);
		
		//Label del color del fondo para el sub panel
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\alexcebrian368\\Desktop\\CardioStrikee\\src\\CardioStrike\\src\\imagenes\\images.jpg"));
		lblNewLabel.setBounds(0, 0, 331, 294);
		panel_1.add(lblNewLabel);
		
		//método para que reajuste automaticamente el fondo del label del sub panel a un tamaño acorde.
		ImageIcon imagen = new ImageIcon("C:\\Users\\alexcebrian368\\Desktop\\CardioStrikee\\src\\CardioStrike\\src\\imagenes\\images.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_DEFAULT));
        lblNewLabel.setIcon(icono);
        this.repaint();
		
		
		//panel que contendrá a la jtable
		JPanel panel = new JPanel();
		panel.setBounds(10, 63, 211, 294);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//le añadimos un scrollpane para que tenga una barra de scroll
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 211, 294);
		panel.add(scrollPane);
		
		//jtable con sus columnas y titulo designado
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Consejo 1"},
				{"Consejo 2"},
				{"Consejo 3"},
				{"Consejo 4"},
				{"Consejo 5"},
				{null},
			},
			new String[] {
				"Consejos"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(132);
		scrollPane.setViewportView(table_1);
		table_1.setRowHeight(50);
		
	
		
		//label del logo SLIM UEM
		JLabel lblSlimuem = new JLabel("SlimUem");
		lblSlimuem.setBounds(170, 11, 211, 41);
		contentPane.add(lblSlimuem);
		
		//Reajuste del logo de SlimUem al tamaño adecuado del label en el que está introducido
		ImageIcon imagen1 = new ImageIcon("C:\\Users\\alexcebrian368\\Desktop\\CardioStrikee\\src\\CardioStrike\\src\\imagenes\\logoSlimUem.jpg");
        Icon icono1 = new ImageIcon(imagen1.getImage().getScaledInstance(lblSlimuem.getWidth(),lblSlimuem.getHeight(),Image.SCALE_DEFAULT));
        lblSlimuem.setIcon(icono1);
        
		
        //label donde se introducirá el fondo de pantalla de toda la ventana general
        JLabel lblFondopantalla = new JLabel("FondoPantalla");
        lblFondopantalla.setIcon(new ImageIcon("C:\\Users\\alexcebrian368\\Desktop\\CardioStrikee\\src\\CardioStrike\\src\\imagenes\\fondoMedico.jpg"));
        lblFondopantalla.setBounds(0, 0, 572, 379);
        contentPane.add(lblFondopantalla);
        this.repaint();
	}
}

