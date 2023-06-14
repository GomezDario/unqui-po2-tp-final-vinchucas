package web;

import web.administradorMuestra.AdministradorMuestra;
import web.administradorUsuario.AdministradorUsuario;
import web.administradorZona.AdministradorZona;
import web.administradorZona.ZonaDeCobertura;

public class Web {

	AdministradorUsuario administradorUsuario;
	AdministradorMuestra administradorMuestra;
	AdministradorZona administradorZona;
	
	public Web(AdministradorUsuario unAdministradorUsuario, AdministradorMuestra unAdministradorMuestra,
			AdministradorZona unAdministradorZona) {
		// TODO Auto-generated constructor stub
		administradorUsuario = unAdministradorUsuario;
		administradorMuestra = unAdministradorMuestra;
		administradorZona = unAdministradorZona;
	}

	public void agregarNuevaZona(ZonaDeCobertura unaZonaDeCobertura) {
		// TODO Auto-generated method stub
		administradorZona.agregarZona(unaZonaDeCobertura);
	}
	
}
