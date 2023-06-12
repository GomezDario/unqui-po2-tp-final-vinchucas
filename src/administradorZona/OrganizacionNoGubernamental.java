package administradorZona;

public class OrganizacionNoGubernamental implements Observador {

	private TipoDeOrganizacion tipoDeOrganizacion;

	public OrganizacionNoGubernamental(TipoDeOrganizacion unTipoDeOrganizacion) {
		// TODO Auto-generated constructor stub
		tipoDeOrganizacion = unTipoDeOrganizacion;
	}

	@Override
	public void funcionNuevaMuestra(ZonaDeCobertura zonaDeCobertura, Muestra unaMuestra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void funcionValidacionMuestra(ZonaDeCobertura zonaDeCobertura, Muestra unaMuestra) {
		// TODO Auto-generated method stub
		
	}
	
}
