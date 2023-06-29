package web;

import java.util.HashSet;
import java.util.Set;

import web.muestra.Muestra;
<<<<<<< HEAD
=======
import web.usuario.Usuario;
import web.zona.AdministradorZona;
>>>>>>> branch 'main' of https://github.com/GomezDario/unqui-po2-tp-final-vinchucas.git
import web.zona.ZonaDeCobertura;
import web.opinion.Opinion;
import web.usuario.Usuario;

public class Web {

	Set<ZonaDeCobertura> zonasDeCobertura = new HashSet<>();
	Set<Usuario> usuarios = new HashSet<>();
	Set<Muestra> muestras = new HashSet<>();



	public void agregarNuevaMuestra(Muestra unaMuestra) {
		// TODO Auto-generated method stub
		if(!muestras.contains(unaMuestra)) {
			muestras.add(unaMuestra);
			for(ZonaDeCobertura unaZona : zonasDeCobertura) {
				unaZona.notificarNuevaMuestraSiEstaDentroDeZona(unaMuestra);
			}			
		}
	}

	public void agregarNuevaOpinion(Opinion unaOpinion) {
		
		
		Muestra muestra = unaOpinion.getMuestra();
		muestra.agregarOpinion(unaOpinion);
		Usuario unUsuario = unaOpinion.getUsuario();
		unUsuario.agregarOpinion(unaOpinion);
		
		
		
		
	}
	
	//ZONAS
	
	public void agregarNuevaZonaDeCobertura(ZonaDeCobertura unaZonaDeCobertura) {
		// TODO Auto-generated method stub
		if(!zonasDeCobertura.contains(unaZonaDeCobertura)) {
			zonasDeCobertura.add(unaZonaDeCobertura);		
		}
	}
	
	public int cantidadDeZonasDeCobertura() {
		// TODO Auto-generated method stub
		return zonasDeCobertura.size();
	}

	public int cantidadDeUsuarios() {
		// TODO Auto-generated method stub
		return usuarios.size();
	}

	public int cantidadDeMuestras() {
		// TODO Auto-generated method stub
		return muestras.size();
	}
	
}
