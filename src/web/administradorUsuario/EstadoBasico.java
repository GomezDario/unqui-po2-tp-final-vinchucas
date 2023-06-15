package web.administradorUsuario;

public class EstadoBasico extends EstadoUsuario{

	@Override
	public void updateUsuario(Usuario usuario) {
		if(puedeSerExperto(usuario)) {
			usuario.setEstado(new EstadoExperto());
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
