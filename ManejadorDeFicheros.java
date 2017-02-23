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

import Model.*;

public class ManejadorDeFicheros {
	String fichero;
	String separador;

	public int buscaUsuario(String usuario, String contraseña,String fichero, String separador) {
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
					
					nuevo = new Login(st.nextToken(), st.nextToken());// usuario;contraseña;id
					String nombre = st.nextToken();
					String apellido = st.nextToken();
					nuevo.setId(st.nextToken());
					//valido los parametros de entrada y distingo los usuarios
					if(nuevo.usuario.equals(usuario) && nuevo.contraseña.equals(contraseña)){
						if(nuevo.id.equals("medico")){
							return 1;
						}else{
							if(nuevo.id.equals("paciente")){
								return 2;
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
		
		return 0;
	}
	
	public ArrayList<String> listaUsuarios(String fichero, String separador) {
		this.fichero = fichero;
		this.separador = separador;
		File f = new File(fichero);
		ArrayList<String> resultado = new ArrayList<String>();

		
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
						resultado.add(nombre + " "+apellidos);
					}
					
					
				}
				
			} while (line != null);
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
			//solo en caso de que no compile el codigo del try se ejecuta el catch
		}
		//no encuentra usuario
		/*ArrayList<String> pacientes = new ArrayList<String>();
		pacientes.add("Hola");*/
		return resultado;
	}
}
