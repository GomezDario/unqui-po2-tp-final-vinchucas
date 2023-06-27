package web.zona;

import web.muestra.Muestra;

public interface Observador {

	public void funcionNuevaMuestra(ZonaDeCobertura zonaDeCobertura, Muestra unaMuestra);

	public void funcionValidacionMuestra(ZonaDeCobertura zonaDeCobertura, Muestra unaMuestra);

}
