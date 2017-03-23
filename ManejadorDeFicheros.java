/**
*Clase manejador de ficheros, donde se lee y se devuelve la informacion de cada fichero
*@author Ethan Recalde
*@version 1
*/

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
	
	/**
	 * Atributos de la clase Control.ManejadorFicheros
	 * @param fichero
	 * @param separador
	 * @param archivo
	 * @param lblRellenaNom
	 * @param lblApell
	 * @param lblNº
	 * @param lblFecha
	 * @param PRIMERASESION
	 * @param LINEASCABECERA
	 * */
	private String fichero;
	private String separador;
	private File archivo;
	private JLabel lblRellenaNom;
	private JLabel lblApell;
	private JLabel lblNº;
	private JLabel lblFecha;
	private final int PRIMERASESION = 5;
	private final int LINEASCABECERA = 4;

	/**
	 * Metodo buscaUsuario en un fichero para el login
	 * @param usuario
	 * @param contraseña
	 * @param fichero
	 * @param separador
	 * @return metodo buscaMedico, metodo buscaPaciente y null.
	 * */
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
	
	/**
	 * Metodo buscaMedico en el fichero a partir de su ID
	 * @param fichero
	 * @param idLogin
	 * @return metodo buscaPacientesMedico y null
	 * */
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
	/**
	 * Metodo buscaPaciente del fichero a partir de su ID
	 * @param fichero
	 * @param idLogin
	 * @return 
	 * */
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
	/**
	 * Metodo busca los pacientes de cada medico. El fichero que  hay que pasarle es infoPacientes.txt y 
	 * el idMedico viene de la ventana de validacion y depende del medico que ha validado
	 * @param fichero
	 * @param medico
	 * 
	 * */
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
	
	
	/**
	 * Metodo listaUsuarios, es un Array de Strigns 
	 * @param fichero
	 * @param separador
	 * @return resultado ( nombre y apellidos del paciente)
	 * */
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
	
	/**
	 * Metodo buscar sesiones, lee mi archivo de sesiones del paciente y guarda los datos en 'sesions s'
	 * @param f
	 * @return sesiones 
	 * */
	public ArrayList<Sesion> buscaSesiones(File f) {
		
		this.separador = ";";
		
		ArrayList<Sesion> sesiones = new ArrayList<Sesion>();
		
		
		String line;
		int cont = 0;

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));
			do {
				line = lector.readLine();
				
				cont++;
				if (line != null && cont>=PRIMERASESION) {
					StringTokenizer st = new StringTokenizer(line, separador);//permite separar
					
					String t = st.nextToken();
					Tiempo tiempo = new Tiempo(Integer.parseInt(t.substring(0,2)), Integer.parseInt(t.substring(3,5)), Integer.parseInt(t.substring(6)));
					String latitud= st.nextToken();
					String longitud = st.nextToken();
					String altitud = st.nextToken();
					String velocidad = st.nextToken();
					String distancia= st.nextToken();
					String pulsaciones= st.nextToken();
					String oxigeno= st.nextToken();
					Sesion s = new Sesion(tiempo, Float.parseFloat(latitud), Float.parseFloat(longitud), Float.parseFloat(altitud), 
							Float.parseFloat(velocidad),Float.parseFloat(distancia), Integer.parseInt(pulsaciones), Integer.parseInt(oxigeno));
					sesiones.add(s);
				}
				
			} while (line != null);
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
			//solo en caso de que no compile el codigo del try se ejecuta el catch
		}
		return sesiones;
	}
	
	/**
	 * Metodo devolver cabecera del fichero, 
	 * lee solo las 4 primeras lineas del fichero [ID, PESO,ESTADO(0,1,2),COMENTARIO]
	 * @param fichero
	 * @return cabecera con esos 4 datos
	 * */
	public CabeceraSesion devolverCabecera(String fichero){
		this.fichero = fichero;
		File f = new File(fichero);
		
		String line;
		int cont = 0;
		int idPaciente=0;
		float peso=0;
		String estado="";
		String comentario="";

		try {
			BufferedReader lector = new BufferedReader(new FileReader(f));
			do {
				line = lector.readLine();
				cont++;
				
				if (line != null){
					switch(cont){
					case 1: 
						idPaciente = Integer.parseInt(line);
						break;
					case 2: 
						peso = Float.parseFloat(line);
						break;
					case 3: 
						estado = line;
						break;
					case 4: 
						comentario = line;
						break;
					}
				}
			} while (line != null && cont < PRIMERASESION);
			
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
			
			//solo en caso de que no compile el codigo del try se ejecuta el catch
		}	
		CabeceraSesion c = new CabeceraSesion(idPaciente, peso, estado, comentario);
		System.out.println(c);
		return c;
		
	}
}
