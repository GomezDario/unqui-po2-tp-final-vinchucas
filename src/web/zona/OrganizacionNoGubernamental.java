package web.zona;

import web.muestra.Muestra;

public class OrganizacionNoGubernamental implements Observador {

	private TipoDeOrganizacion tipoDeOrganizacion;
	private FuncionExterna eventoNuevaMuestra;
	private FuncionExterna eventoValidacionMuestra;

	public OrganizacionNoGubernamental(TipoDeOrganizacion unTipoDeOrganizacion, FuncionExterna unEventoNuevaMuestra, 
			FuncionExterna unEventoValidacionMuestra) {
		// TODO Auto-generated constructor stub
		tipoDeOrganizacion = unTipoDeOrganizacion;
		eventoNuevaMuestra = unEventoNuevaMuestra;
		eventoValidacionMuestra = unEventoValidacionMuestra;
	}
	
	public TipoDeOrganizacion getTipoDeOrganizacion() {
		// TODO Auto-generated method stub
		return tipoDeOrganizacion;
	}

	public FuncionExterna getFuncionNuevaMuestra() {
		// TODO Auto-generated method stub
		return eventoNuevaMuestra;
	}

	public FuncionExterna getFuncionValidacionMuestra() {
		// TODO Auto-generated method stub
		return eventoValidacionMuestra;
	}

	@Override
	public void funcionNuevaMuestra(ZonaDeCobertura unaZonaDeCobertura, Muestra unaMuestra) {
		// TODO Auto-generated method stub
		eventoNuevaMuestra.nuevoEvento(unaZonaDeCobertura, unaMuestra, this);
	}

	@Override
	public void funcionValidacionMuestra(ZonaDeCobertura unaZonaDeCobertura, Muestra unaMuestra) {
		// TODO Auto-generated method stub
		eventoValidacionMuestra.nuevoEvento(unaZonaDeCobertura, unaMuestra, this);
	}
}
