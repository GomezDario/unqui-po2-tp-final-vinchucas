package main.java.usuarios;

public class EstadoExperto extends EstadoUsuario{

	@Override
	
	public void updateUsuario(Usuario usuario) {
		if (!this.puedeSerExperto(usuario)) {
			usuario.setEstadoUsuario(new EstadoBasico());
		}
		else {
			
			usuario.setEstadoUsuario(this);
			
			}
	}

	
	
}
