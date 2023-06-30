package web.zona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import web.muestra.Muestra;

public class OrganizacionTest {

	Organizacion organizacion;
	ZonaDeCobertura unaZonaDeCobertura;
	Muestra unaMuestra;
	FuncionExterna unaFuncionNuevaMuestra;
	FuncionExterna unaFuncionValidacionMuestra;
	
	@Before
	public void setUp() {
		//DOC
		unaZonaDeCobertura = mock(ZonaDeCobertura.class);
		unaMuestra = mock(Muestra.class);
		unaFuncionNuevaMuestra = mock(FuncionExterna.class);
		unaFuncionValidacionMuestra = mock(FuncionExterna.class);
		
		//SUT
		organizacion = new Organizacion(TipoDeOrganizacion.EDUCATIVA, unaFuncionNuevaMuestra, unaFuncionValidacionMuestra);
	}
	
	@Test
	public void cuandoUnaOrganizacionNoGubernamentalSeCreaEsConUnTipoDeOrganizacionYDosFuncionesExternasTest() {
		//verify
		assertEquals(TipoDeOrganizacion.EDUCATIVA, organizacion.getTipoDeOrganizacion());
		assertEquals(unaFuncionNuevaMuestra, organizacion.getFuncionNuevaMuestra());
		assertEquals(unaFuncionValidacionMuestra, organizacion.getFuncionValidacionMuestra());
	}
	
	@Test
	public void funcionNuevaMuestraTest() {
		//exercise
		organizacion.funcionNuevaMuestra(unaZonaDeCobertura, unaMuestra);
		
		//verify
		verify(unaFuncionNuevaMuestra, times(1)).nuevoEvento(organizacion, unaZonaDeCobertura, unaMuestra);
		verify(unaFuncionValidacionMuestra, times(0)).nuevoEvento(organizacion, unaZonaDeCobertura, unaMuestra);
	}
	
	@Test
	public void funcionValidacionMuestraTest() {
		//exercise
		organizacion.funcionValidacionMuestra(unaZonaDeCobertura, unaMuestra);
		
		//verify
		verify(unaFuncionNuevaMuestra, times(0)).nuevoEvento(organizacion, unaZonaDeCobertura, unaMuestra);
		verify(unaFuncionValidacionMuestra, times(1)).nuevoEvento(organizacion, unaZonaDeCobertura, unaMuestra);
		}

}
