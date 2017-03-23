package Model;


public class Login {

	public String idLogin;
	public String usuario;
	public String contraseña;
	public String tipoUsuario;
	
	
	/**
	 * Constructor al que le paso solo usuario y contraseña
	 * @param usuario
	 * @param contraseña
	 * @param id
	 */
	public Login(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		
	}

	
	/**
	 * Constructor que le paso ya todos los valores 
	 * @param idLogin
	 * @param usuario
	 * @param contraseña
	 * @param tipoUsuario
	 * */
	public Login(String idLogin, String usuario, String contraseña, String tipoUsuario) {
		super();
		this.idLogin = idLogin;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.tipoUsuario = tipoUsuario;
	}



	
	public String getTipoUsuario() {
		return tipoUsuario;
	}



	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	/**
	 * Mostramos parametros con toString
	 * */
	public String toString() {
		
		return tipoUsuario + usuario+" "+contraseña;
	}
	
}
