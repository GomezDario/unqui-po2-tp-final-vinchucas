package main.java.usuarios;

public class EstadoBasico extends EstadoUsuario{

	
	@Override
	public void updateUsuario(Usuario usuario) {
		
		if (this.puedeSerExperto(usuario)) {
			usuario.setEstadoUsuario(new EstadoExperto());
		}
		else {
			
			usuario.setEstadoUsuario(this);
			
		}
	}
	

	
	
}
