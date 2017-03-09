package Control;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JLabel;

import Model.*;
import Vista.*;

/**
 * @author ethan
 *
 */
public class ManejadorDeFicheros {
	String fichero;
	String separador;
	File archivo;
	private JLabel lblRellenaNom;
	private JLabel lblApell;
	private JLabel lblNº;
	private JLabel lblFecha;

	public Object buscaUsuario(String usuario, String contraseña,String fichero, String separador) {
		this.fichero = fichero;
		this.separador = separador;

		File f = new File(fichero);
		String line;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));
			Login nuevo;
			do {
				line = lector.readLine();
				
				if (line != null) {
					StringTokenizer st = new StringTokenizer(line, separador);//permite separar
					String id = st.nextToken();
					nuevo = new Login(st.nextToken(), st.nextToken());// usuario;contraseña
					nuevo.setTipoUsuario(st.nextToken());
					//valido los parametros de entrada y distingo los usuarios
					if(nuevo.usuario.equals(usuario) && nuevo.contraseña.equals(contraseña)){
						if(nuevo.tipoUsuario.equals("medico")){
							return buscaMedico("C:\\Users\\ethan\\workspace\\CardioStrikee\\Data\\infoMedicos.txt", id);
						}else{
							if(nuevo.tipoUsuario.equals("paciente")){
								return buscaPaciente("C:\\Users\\ethan\\workspace\\CardioStrikee\\Data\\infoPacientes.txt", id);
							}
						}
					}
				}
				
			} while (line != null);
			lector.close();
		} catch (Exception e) {
			
			System.out.println("ERROR:" + e.getMessage());
			//solo en caso de que no compile el codigo del try se ejecuta el catch
		}
		//no encuentra usuario
		
		return null;
	}
	
	
	//El fichero que hay que pasarle es infoMedicos.txt y el idLogin viene de login.txt
	public Medico buscaMedico(String fichero, String idLogin){
		this.fichero = fichero;
		this.separador = separador;

		File f = new File(fichero);
		String line;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));
			do {
				line = lector.readLine();
				
				if (line != null) {
					StringTokenizer st = new StringTokenizer(line, separador);//permite separar
					String idMedico = st.nextToken();
					String nombre = st.nextToken();
					String apellidos = st.nextToken();
					String fechaNacimiento = st.nextToken();
					String nColegiado = st.nextToken();
					String id = st.nextToken();
					//valido los parametros de entrada y distingo los usuarios
					if(id.equals(idLogin)){
						Medico m = new Medico(Integer.parseInt(idMedico), nombre, apellidos, fechaNacimiento, nColegiado);
						buscaPacientesMedico("C:\\Users\\ethan\\workspace\\CardioStrikee\\Data\\infoPacientes.txt", m);
						return m;
					}
				}
				
			} while (line != null);
			lector.close();

		}catch (Exception e) {
			
			System.out.println("ERROR:" + e.getMessage());
			//solo en caso de que no compile el codigo del try se ejecuta el catch
		}
		return null;
	}

	//El fichero que hay que pasarle es infoPacientes.txt y el idLogin viene de login.txt
	public Paciente buscaPaciente(String fichero, String idLogin){
		this.fichero = fichero;
		this.separador = separador;

		File f = new File(fichero);
		String line;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));
			do {
				line = lector.readLine();
				
				if (line != null) {
					StringTokenizer st = new StringTokenizer(line, separador);//permite separar
					String idPaciente = st.nextToken();
					String nombre = st.nextToken();
					String apellidos = st.nextToken();
					String fechaNacimiento = st.nextToken();
					String peso = st.nextToken();
					String altura = st.nextToken();
					String imc = st.nextToken();
					String id = st.nextToken();
					//valido los parametros de entrada y distingo los usuarios
					if(id.equals(idLogin)){
						String idMedico = st.nextToken();
						return new Paciente(Integer.parseInt(idPaciente), nombre, apellidos, fechaNacimiento, Float.parseFloat(peso), 
								Float.parseFloat(altura), Float.parseFloat(imc), Integer.parseInt(idMedico));
					}
				}
				
			} while (line != null);
			lector.close();

		}catch (Exception e) {
			
			System.out.println("ERROR:" + e.getMessage());
			//solo en caso de que no compile el codigo del try se ejecuta el catch
		}
		return null;
	}
	//El fichero que hay que pasarle es infoPacientes.txt y el idMedico viene de la ventana de validacion y depende del medico que
	//ha validado
	public void buscaPacientesMedico(String fichero, Medico medico){
		this.fichero = fichero;
		this.separador = separador;

		File f = new File(fichero);
		String line;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));
			do {
				line = lector.readLine();
				
				if (line != null) {
					StringTokenizer st = new StringTokenizer(line, separador);//permite separar
					String idPaciente = st.nextToken();
					String nombre = st.nextToken();
					String apellidos = st.nextToken();
					String fechaNacimiento = st.nextToken();
					String peso = st.nextToken();
					String altura = st.nextToken();
					String imc = st.nextToken();
					String idLogin = st.nextToken();
					String id = st.nextToken();
					//valido los parametros de entrada y distingo los usuarios
					if(id.equals(String.valueOf(medico.getidMedico()))){
						medico.setPaciente((new Paciente(Integer.parseInt(idPaciente), nombre, apellidos, fechaNacimiento, Float.parseFloat(peso), 
								Float.parseFloat(altura), Float.parseFloat(imc), Integer.parseInt(id))));
					}
				}
				
			} while (line != null);
			lector.close();

		}catch (Exception e) {
			
			System.out.println("ERROR:" + e.getMessage());
			//solo en caso de que no compile el codigo del try se ejecuta el catch
		}
		
	}
	
	
	
	public ArrayList<String[]> listaUsuarios(String fichero, String separador) {
		this.fichero = fichero;
		this.separador = separador;
		File f = new File(fichero);
		ArrayList<String[]> resultado = new ArrayList<String[]>();
		
		String line;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));
			do {
				line = lector.readLine();
				
				if (line != null) {
					StringTokenizer st = new StringTokenizer(line, separador);//permite separar
					
					
					String usuario = st.nextToken();
					String contrasenia = st.nextToken();
					String nombre = st.nextToken();
					String apellidos = st.nextToken();
					String id = st.nextToken();
				
					
					if(id.equals("paciente")){
						String[] nombreApellidos = new String[2];
						nombreApellidos[0] = nombre;
						nombreApellidos[1] = apellidos;
						resultado.add(nombreApellidos);
					}
					
					
				}
				
			} while (line != null);
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
			//solo en caso de que no compile el codigo del try se ejecuta el catch
		}
		return resultado;
	}
	/*
	private void abrir (){
		FileReader fr = new FileReader("datos.txt");
			

		BufferedReader bf = new BufferedReader(new FileReader("infoMedico.txt"));
		
		while((sCadena = bf.readLine())!=null) {
			for(int i=0;i<sCadena.size();i++){
				if(sCadena = "Nombre:"){
					lblRellenaNom = nombre;
				}
			}
		}
	*/	
	
}
