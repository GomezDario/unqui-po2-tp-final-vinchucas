package web.administradorZona;

public interface Observador {

	public void funcionNuevaMuestra(ZonaDeCobertura zonaDeCobertura, Muestra unaMuestra);

	public void funcionValidacionMuestra(ZonaDeCobertura zonaDeCobertura, Muestra unaMuestra);

}
