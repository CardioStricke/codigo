package Model;

import java.util.ArrayList;

public class GestionDatos {
	public static final int NOENCONTRADO = -1;
	public static int buscarPaciente(String nombreCompleto, ArrayList<String> pacientes){
		boolean encontrado = false;
		int i= 0;
		int pos = NOENCONTRADO;
		while(!encontrado && i < pacientes.size()){
			if(nombreCompleto.equals(pacientes.get(i))){
				encontrado = true;
				pos = i;
			}
			i++;
		}
		return pos;
	}

}
