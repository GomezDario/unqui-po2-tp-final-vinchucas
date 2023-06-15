package web.administradorUsuario;

public class EstadoExperto extends EstadoUsuario{

	@Override
	
	public void updateUsuario(Usuario usuario) {
		if (!this.puedeSerExperto(usuario)) {
			usuario.setEstado(new EstadoBasico());
		} else {
			usuario.setEstado(this);
		}
	}
	
	@Override
	public boolean esExperto() {
		// TODO Auto-generated method stub
		return false;
	}
}
