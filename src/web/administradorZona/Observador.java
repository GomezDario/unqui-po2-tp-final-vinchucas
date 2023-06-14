package web.administradorZona;

import web.administradorMuestra.Muestra;

public interface Observador {

	public void funcionNuevaMuestra(ZonaDeCobertura zonaDeCobertura, Muestra unaMuestra);

	public void funcionValidacionMuestra(ZonaDeCobertura zonaDeCobertura, Muestra unaMuestra);

}
