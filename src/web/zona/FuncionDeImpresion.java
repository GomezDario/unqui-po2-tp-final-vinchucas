package web.zona;

import web.muestra.Muestra;

public class FuncionDeImpresion implements FuncionExterna {

	@Override
	public void nuevoEvento(Organizacion unaOrganizacion, ZonaDeCobertura unaZonaDeCobertura, 
			Muestra unaMuestra) {
		// TODO Auto-generated method stub
		unaOrganizacion.getTipoDeOrganizacion();
		unaZonaDeCobertura.getNombre();
		unaMuestra.resultadoActual();
//		System.out.println("Una organizacion " + unaOrganizacionNoGubernamental.getTipoDeOrganizacion());
//		System.out.println("Realiza la impresión debido a cambios en: " + unaZonaDeCobertura.getNombre());
//		System.out.println("Respecto a una muestra con resultado de: " + unaMuestra.resultadoActual());
	}

}
