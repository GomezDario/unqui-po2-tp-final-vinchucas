package web.administradorZona;

public class FuncionDeImpresion implements FuncionExterna {

	@Override
	public void nuevoEvento(ZonaDeCobertura unaZonaDeCobertura, Muestra unaMuestra,
			OrganizacionNoGubernamental unaOrganizacionNoGubernamental) {
		// TODO Auto-generated method stub
		System.out.println("Una organizacion " + unaOrganizacionNoGubernamental.getTipoDeOrganizacion());
		System.out.println("Realiza la impresión debido a cambios en: " + unaZonaDeCobertura.getNombre());
		System.out.println("Respecto a una muestra con resultado de: " + unaMuestra.resultadoActual());
	}

}
