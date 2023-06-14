package web.administradorUsuario;

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
	
	
	public void agregarUsuario(Usuario unUsuario) {
		
			usuarios.add(unUsuario);
		
		
	}
	
	public void agregarOpinion(Opinion unaOpinion) {
		
			
				for (Usuario usuario : usuarios) {
					
					usuario.agregarOpinion(unaOpinion);
					
				}
		
		
	}
	
	
	public void agregarMuestra(Muestra unaMuestra) {
		
		for (Usuario usuario : usuarios) {
			
			usuario.agregarMuestra(unaMuestra);
			
		}
		
		
		
	}
	
	
	
}
