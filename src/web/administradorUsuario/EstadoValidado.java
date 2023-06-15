package web.administradorUsuario;

public class EstadoValidado extends EstadoUsuario {

	@Override
	public void updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuario.setEstado(this);
	}

	@Override
	public boolean esExperto() {
		// TODO Auto-generated method stub
		return true;
	}
}
