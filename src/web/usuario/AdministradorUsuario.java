package web.usuario;

import java.util.ArrayList;
import java.util.List;

import web.extras.*;
import web.administradorMuestra.*;

public class AdministradorUsuario {

	List<Usuario> usuarios = new ArrayList<>();
	
	public int cantidadDeUsuarios() {
		// TODO Auto-generated method stub
		return usuarios.size();
	}
		
	public void agregarOpinion(Opinion unaOpinion) {
		Usuario usuario = unaOpinion.getUsuario();
		usuario.agregarOpinion(unaOpinion);
		agregarUsuarioSiNoExiste(usuario);
	}
	
	public void agregarMuestra(Muestra unaMuestra) {
		Usuario usuario = unaMuestra.getUsuario();
		usuario.agregarMuestra(unaMuestra);
		agregarUsuarioSiNoExiste(usuario);
	}
	
	private void agregarUsuarioSiNoExiste(Usuario unUsuario) {
		if (!usuarios.contains(unUsuario)) {
			usuarios.add(unUsuario);
		}
	}
}
