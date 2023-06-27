package web.zona;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import web.muestra.Muestra;

public class FuncionDeImpresionTest {

	FuncionDeImpresion unaFuncionDeImpresion;
	ZonaDeCobertura unaZonaDeCobertura;
	Muestra unaMuestra;
	OrganizacionNoGubernamental unaOrganizacionNoGubernamental;

	@Before
	public void setUp() {
		//DOC
		unaZonaDeCobertura = mock(ZonaDeCobertura.class);
		unaMuestra = mock(Muestra.class);
		unaOrganizacionNoGubernamental = mock(OrganizacionNoGubernamental.class);
		
		//SUT
		unaFuncionDeImpresion = new FuncionDeImpresion();
	}

	@Test
	public void nuevoEventoTest() {
		//exercise
		unaFuncionDeImpresion.nuevoEvento(unaZonaDeCobertura, unaMuestra, unaOrganizacionNoGubernamental);
		
		//verify
		verify(unaZonaDeCobertura, times(1)).getNombre();
		verify(unaMuestra, times(1)).resultadoActual();
		verify(unaOrganizacionNoGubernamental, times(1)).getTipoDeOrganizacion();
	}

}
