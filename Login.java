package Model;


public class Login {

	public String usuario;
	public String contraseña;
	/**
	 * @param nombre
	 * @param contraseña
	 */
	public Login(String usuario, String contraseña) {
	//	super();porque siempre hereda de object
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	/* 
	 * 
	 */
	public String toString() {
		
		return usuario+" "+contraseña;
	}
	
	
	
	
}
