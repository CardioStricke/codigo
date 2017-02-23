package Model;


public class Login {

	public String usuario;
	public String contrase�a;
	public String id;
	
	/**
	 * @param usuario
	 * @param contrase�a
	 * @param id
	 */
	public Login(String usuario, String contrase�a) {
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		
	}
	/**
	 * @param usuario
	 * @param contrase�a
	 * @param id
	 */
	public Login(String usuario, String contrase�a, String id) {
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.id=id;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String toString() {
		
		return id + usuario+" "+contrase�a;
	}
	
}
