package Model;


public class Login {

	public String usuario;
	public String contrase�a;
	/**
	 * @param nombre
	 * @param contrase�a
	 */
	public Login(String usuario, String contrase�a) {
	//	super();porque siempre hereda de object
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}
	/* 
	 * 
	 */
	public String toString() {
		
		return usuario+" "+contrase�a;
	}
	
	
	
	
}
