package web.administradorZona;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import web.administradorMuestra.Muestra;


public class FuncionDeImpresionTest {

	FuncionDeImpresion unaFuncionDeImpresion;
	ZonaDeCobertura unaZonaDeCobertura;
	Muestra unaMuestra;
	OrganizacionNoGubernamental unaOrganizacionNoGubernamental;

	@Before
	public void setUp() {
		//setup
		unaZonaDeCobertura = mock(ZonaDeCobertura.class);
		unaMuestra = mock(Muestra.class);
		unaOrganizacionNoGubernamental = mock(OrganizacionNoGubernamental.class);
		
		//test double installation
		unaFuncionDeImpresion = new FuncionDeImpresion();
	}

	@Test
	public void nuevoEventoTest() {
		//setup
		when(unaZonaDeCobertura.getNombre()).thenReturn("Quilmes");
		when(unaMuestra.resultadoActual()).thenReturn("Vinchuca");
		when(unaOrganizacionNoGubernamental.getTipoDeOrganizacion()).thenReturn(TipoDeOrganizacion.EDUCATIVA);
		
		//exercise
		unaFuncionDeImpresion.nuevoEvento(unaZonaDeCobertura, unaMuestra, unaOrganizacionNoGubernamental);
		
		//verify
		verify(unaZonaDeCobertura, times(1)).getNombre();
		verify(unaMuestra, times(1)).resultadoActual();
		verify(unaOrganizacionNoGubernamental, times(1)).getTipoDeOrganizacion();
	}

}
