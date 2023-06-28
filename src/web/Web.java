package web;

import web.muestra.AdministradorMuestra;
import web.muestra.Muestra;
import web.usuario.Usuario;
import web.zona.AdministradorZona;
import web.zona.ZonaDeCobertura;
import web.opinion.Opinion;

public class Web {

	Usuario usuario;
	AdministradorMuestra administradorMuestra;
	AdministradorZona administradorZona;
	
	public Web(Usuario unUsuario, AdministradorMuestra unAdministradorMuestra,
			AdministradorZona unAdministradorZona) {
		// TODO Auto-generated constructor stub
		usuario = unUsuario;
		administradorMuestra = unAdministradorMuestra;
		administradorZona = unAdministradorZona;
	}


	public void agregarNuevaZonaDeCobertura(ZonaDeCobertura unaZonaDeCobertura) {
		// TODO Auto-generated method stub
		administradorZona.agregarZona(unaZonaDeCobertura);
	}

	public void agregarNuevaMuestra(Muestra unaMuestra) {
		// TODO Auto-generated method stub
		administradorMuestra.agregarMuestra(unaMuestra);
		usuario.agregarMuestra(unaMuestra);
		administradorZona.agregarMuestra(unaMuestra);
	}

	public void agregarNuevaOpinion(Opinion unaOpinion) {
		// TODO Auto-generated method stub
		Muestra muestra = unaOpinion.getMuestra();
		boolean muestraVerificada = muestra.estaVerificada();
		if(administradorMuestra.agregarOpinion(unaOpinion)) {
			usuario.agregarOpinion(unaOpinion);
			if(!muestraVerificada) {
				if(muestra.estaVerificada()) {
					administradorZona.muestraValidada(muestra);
				}
			}
		}
	}
	
}
