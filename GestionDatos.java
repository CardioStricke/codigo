package Model;

import java.util.ArrayList;

/**
 * Esta clase gestiona los datos de los ficheros
 *@author Ethan Recalde
 *@version 2.0
 */

public class GestionDatos {
   
	/**
     * Este metodo busca pacientes en el array de pacientes, se utiliza para el buscador el login medico
     * @author Ethan Recalde
     * @param NOENCONTRADO inicializa la posicion como no encontrado (por eso es -1)
     * @param nombreCompleto nombre completo del paciente
     * @param pacientes array en el que se encuentran los pacientes
     * @param i contador utilizado en el bucle
     * @return pos devuelve la posicion en la que se encuentra el paciente 
     * @version 2.0
     */
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
	
	/**
     * Este metodo obtiene los tiempos de la sesion en un array de tiempos
     * @author Ethan Recalde
     * @return tiempos devuelve el array de tiempos
     * @version 1.0
     */
	public static ArrayList<Tiempo> obtenerTiempos(ArrayList<Sesion> sesiones){
		ArrayList<Tiempo> tiempos = new ArrayList<Tiempo>();
		for(Sesion s: sesiones){
			tiempos.add(s.getTiempo());
		}
		return tiempos;
	}
	
	/**
     * Este metodo obtiene las velocidades de la sesion en un array de velocidades, se utiliza en FreeChartVelocidad para pintar la grafica
     * @author Ethan Recalde
     * @return velocidades devuelve el array de velocidades
     * @version 1.0
     */
	public static ArrayList<Float> obtenerVelocidades(ArrayList<Sesion> sesiones){
		ArrayList<Float> velocidades = new ArrayList<Float>();
		for(Sesion s: sesiones){
			velocidades.add(new Float(s.getVelocidad()));
		}
		return velocidades;
	}
	

	/**
     * Este metodo obtiene las alturas de la sesion en un array de distancias, se utiliza en FreeChartAltura para pintar la grafica
     * @author Ethan Recalde
     * @return altura devuelve el array de alturas
     * @version 1.0
     */
	public static ArrayList<Float> obtenerDistancia(ArrayList<Sesion> sesiones){
		ArrayList<Float> altura = new ArrayList<Float>();
		for(Sesion s: sesiones){
			altura.add(new Float(s.getDistancia()));
		}
		return altura;
	}
	
	/**
     * Este metodo obtiene las pulsaciones en la sesion en un array de pulsaciones, se utiliza en FreeChartPulsaciones para pintar la grafica
     * @author Ethan Recalde
     * @return pulsaciones devuelve el array de pulsaciones
     * @version 1.0
     */
	public static ArrayList<Integer> obtenerPulsaciones(ArrayList<Sesion> sesiones){
		ArrayList<Integer> pulsaciones = new ArrayList<Integer>();
		for(Sesion s: sesiones){
			pulsaciones.add(new Integer(s.getPulsaciones()));
		}
		return pulsaciones;
	}
	
	/**
     * Este metodo obtiene el nivel de oxigeno en sangre en la sesion en un array de enteros (o2 sangre), se utiliza en FreeChartO2Sangre para pintar la grafica
     * @author Ethan Recalde
     * @return sangre devuelve el array de enteros(o2 sangre)
     * @version 1.0
     */
	public static ArrayList<Integer> obtenerOxigenoSangre(ArrayList<Sesion> sesiones){
		ArrayList<Integer> sangre = new ArrayList<Integer>();
		for(Sesion s: sesiones){
			sangre.add(new Integer(s.getOxigeno()));
		}
		return sangre;
	}
}
