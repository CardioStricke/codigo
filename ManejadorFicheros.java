package Control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

import Model.*;

public class ManejadorDeFicheros {
	String fichero;
	String separador;

	/*public void escribirUsuarios(Vector<Login> lista) {

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fichero)));
			for (int i = 0; i < lista.size(); i++) {

				Login l = (Login)lista.get(i);
				out.println(l.usuario+";"+l.contraseña);
				out.flush();
			}
		} catch (IOException e) {
			System.out.println("Error escribiendo el fichero de usuarios");
		}
	}*/

	public int leerUsuarios(String usuario, String contraseña,String fichero, String separador) {
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
					String tipo= st.nextToken();//guardo en tipo el primer caracter antes del separador
					nuevo = new Login(st.nextToken(), st.nextToken());// usuario;contraseña
					
					/*comparo el usuario y contra del txt con el que le paso por parametro al iniciar sesion
					*si es correcto me fijo en la letra primera si es m(medico) y si es p(paciente)
					*devuelvo 1(medico), 2(paciente) y 0 Error
					*/
					if(nuevo.usuario.equals(usuario) && nuevo.contraseña.equals(contraseña)){
						if(tipo.equals("m")){
							return 1;
						}else{
							if(tipo.equals("p")){
								return 2;
							}
						}
					}
				}
				
			} while (line != null);
		} catch (Exception e) {
			System.out.println("ERROR:" + e.getMessage());
		}

		return 0;
	}
}
