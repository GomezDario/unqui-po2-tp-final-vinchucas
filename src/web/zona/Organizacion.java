package web.zona;

import web.muestra.Muestra;

public class Organizacion implements ObservadorOrg {

	private TipoDeOrganizacion tipoDeOrganizacion;
	private FuncionExterna eventoNuevaMuestra;
	private FuncionExterna eventoValidacionMuestra;

	public Organizacion(TipoDeOrganizacion unTipoDeOrganizacion, FuncionExterna unEventoNuevaMuestra, 
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
		eventoNuevaMuestra.nuevoEvento(this, unaZonaDeCobertura, unaMuestra);
	}

	@Override
	public void funcionValidacionMuestra(ZonaDeCobertura unaZonaDeCobertura, Muestra unaMuestra) {
		// TODO Auto-generated method stub
		eventoValidacionMuestra.nuevoEvento(this, unaZonaDeCobertura, unaMuestra);
	}
	
}
