package Model;


public class Login {

	public String usuario;
	public String contraseña;
	public String id;
	
	/**
	 * @param usuario
	 * @param contraseña
	 * @param id
	 */
	public Login(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		
	}
	/**
	 * @param usuario
	 * @param contraseña
	 * @param id
	 */
	public Login(String usuario, String contraseña, String id) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.id=id;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String toString() {
		
		return id + usuario+" "+contraseña;
	}
	
}
