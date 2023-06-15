package web.administradorUsuario;

public class EstadoValidado extends EstadoUsuario {

	@Override
	public void updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
		usuario.setEstadoUsuario(this);
		
	}

	public boolean esExperto() {
		
		return true;
		
	}
	
	
}
