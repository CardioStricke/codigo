package Model;
import java.util.ArrayList;
/**
 * Esta clase contiene y define la info relativa al medico 
 *@author Bruno Matiacci
 *@version 1.0
 * Siguiendo el orden del fichero : 
 *@param idMedico codigo del médico
 *@param nombre nombre del médico
 *@param apellidos apellidos del médico
 *@param fecha fecha de nacimiento del médico
  * */

//Juan;Rodriguez;15/11/1965;0012134
public class Medico {

	private int idMedico;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String nColegiado;
	private ArrayList<Paciente> pacientes;
	
	
	public Medico(int idMedico, String nombre, String apellidos, String fechaNacimiento, String nColegiado) {
		this.idMedico = idMedico;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.nColegiado = nColegiado;
		this.pacientes = new ArrayList<Paciente>();
	}

	public int getidMedico() {
		return idMedico;
	}
	public void setidMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getnColegiado() {
		return nColegiado;
	}
	public void setnColegiado(String nColegiado) {
		this.nColegiado = nColegiado;
	}	
	public Paciente getPaciente(int pos){
		return pacientes.get(pos);
	}
	public void setPaciente(Paciente p){
		pacientes.add(p);
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}
	

	
}

