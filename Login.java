package Model;


public class Login {

	public String usuario;
	public String contraseņa;
	/**
	 * @param nombre
	 * @param contraseņa
	 */
	public Login(String usuario, String contraseņa) {
	//	super();porque siempre hereda de object
		this.usuario = usuario;
		this.contraseņa = contraseņa;
	}
	/* 
	 * 
	 */
	public String toString() {
		
		return usuario+" "+contraseņa;
	}
	
	
	
	
}
