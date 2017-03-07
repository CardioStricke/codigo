package Model;

public class Paciente {
	
	/*En el fichero el orden es: 
	 * idPaciente
	 * nombre
	 * apellidos
	 * fecha
	 * peso
	 * altura
	 * imc
	 * idUsuario -> en el fichero de login
	 * idMedico
	 * */
	private int idPaciente;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private float peso;
	private float altura;
	private float imc;
	private int idMedico;
	

	public Paciente(int idPaciente, String nombre, String apellidos, String fechaNacimiento, float peso, float altura,
			float imc, int idMedico) {
		this.idPaciente = idPaciente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.peso = peso;
		this.altura = altura;
		this.imc = imc;
		this.idMedico = idMedico;
	}
	public int getidPaciente() {
		return idPaciente;
	}
	public void setidPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
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
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getImc() {
		return imc;
	}
	public void setImc(float imc) {
		this.imc = imc;
	}
	public int getidMedico() {
		return idMedico;
	}
	public void setidMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	
	

}
