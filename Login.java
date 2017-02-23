package Model;


public class Login {

	public String usuario;
	public String contraseņa;
	public String id;
	
	/**
	 * @param usuario
	 * @param contraseņa
	 * @param id
	 */
	public Login(String usuario, String contraseņa) {
		this.usuario = usuario;
		this.contraseņa = contraseņa;
		
	}
	/**
	 * @param usuario
	 * @param contraseņa
	 * @param id
	 */
	public Login(String usuario, String contraseņa, String id) {
		this.usuario = usuario;
		this.contraseņa = contraseņa;
		this.id=id;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String toString() {
		
		return id + usuario+" "+contraseņa;
	}
	
}
