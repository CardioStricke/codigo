package Model;

import java.util.ArrayList;

public class GestionDatos {
	public static final int NOENCONTRADO = -1;
	public static int buscarPaciente(String nombreCompleto, ArrayList<Paciente> pacientes){
		boolean encontrado = false;
		int i= 0;
		int pos = NOENCONTRADO;
		while(!encontrado && i < pacientes.size()){
			if(nombreCompleto.equals(pacientes.get(i).getNombre())||nombreCompleto.equals(pacientes.get(i).getNombre() +" "+pacientes.get(i).getApellidos())){
				encontrado = true;
				pos = i;
			}
			i++;
		}
		return pos;
	}
	public static ArrayList<Tiempo> obtenerTiempos(ArrayList<Sesion> sesiones){
		ArrayList<Tiempo> tiempos = new ArrayList<Tiempo>();
		for(Sesion s: sesiones){
			tiempos.add(s.getTiempo());
		}
		return tiempos;
	}
	
	public static ArrayList<Float> obtenerVelocidades(ArrayList<Sesion> sesiones){
		ArrayList<Float> velocidades = new ArrayList<Float>();
		for(Sesion s: sesiones){
			velocidades.add(new Float(s.getVelocidad()));
		}
		return velocidades;
	}

}
