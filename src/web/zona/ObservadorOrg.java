package web.zona;

import web.muestra.Muestra;

public interface ObservadorOrg {

	public void funcionNuevaMuestra(ZonaDeCobertura zonaDeCobertura, Muestra unaMuestra);

	public void funcionValidacionMuestra(ZonaDeCobertura zonaDeCobertura, Muestra unaMuestra);

}
