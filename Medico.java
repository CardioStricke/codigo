package Vista;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import Control.LoginControl;
import Model.Login;
import Model.GestionDatos;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.Icon;

import java.awt.Color;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

/**
 *
 * @author KATY
 */
public class Medico extends JFrame {
	private JList list1 = null;
	private DefaultListModel modelo;
	private JPanel contentPane;
	private LoginControl controlador;
	public JComboBox <Login> usersList; 
	public JTextField campoNombre;
	public JTextField campoApellido;
	private JFrame vp;
	private ImageIcon imagen;
	private Icon icono;
	private ArrayList<String> pacientes;
	private JScrollPane scrollLista;
	private JTextField txtBuscar;
	 /**
     * Creates new form Medico
     */
    public Medico(ArrayList<String> pacientes) {
    	getContentPane().setBackground(SystemColor.activeCaption);
    	getContentPane().setForeground(Color.WHITE);
    	this.pacientes = pacientes;
        initComponents();
        
       
    }
    
    public void addController (LoginControl lc){
	   	controlador = lc;
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
     
        DefaultListModel modelo = new DefaultListModel();
        
        for(String s: pacientes)
        	modelo.addElement(s);
        //list1.setSize(new java.awt.Dimension(221,292));
        scrollLista = new JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        JLabel label = new JLabel("Pacientes");
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int pos = GestionDatos.buscarPaciente(txtBuscar.getText(), pacientes);
        		if(pos != GestionDatos.NOENCONTRADO){
        			list1.setSelectedIndex(pos);
        		}else{
        			
        			JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        		}
        	}
        });
        
        txtBuscar = new JTextField();
        txtBuscar.setColumns(10);
        
        JPanel panel = new JPanel();
        
        JPanel panel_1 = new JPanel();
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(23)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(label)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(txtBuscar)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(btnBuscar))
        						.addComponent(scrollLista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        					.addGap(43))))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(40)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(label)
        						.addComponent(btnBuscar)
        						.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(scrollLista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        			.addGap(34))
        );
        
                list1 = new JList();
                panel_1.add(list1);
                list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                list1.setBackground(SystemColor.controlHighlight);
                list1.setBorder(null);
                list1.setModel(modelo);
        panel.setLayout(null);
        
        JLabel lblFotoMedico = new JLabel("");
        lblFotoMedico.setFont(new Font("Arial Black", Font.BOLD, 30));
        lblFotoMedico.setIcon(new ImageIcon("C:\\Users\\KATY\\workspace\\CardioStrikee\\src\\Imagenes\\logoMedico.png"));
        lblFotoMedico.setBounds(0, 0, 109, 71);
        panel.add(lblFotoMedico);
        getContentPane().setLayout(groupLayout);

        pack();
    }
}
