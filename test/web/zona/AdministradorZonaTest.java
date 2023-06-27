package web.zona;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import web.muestra.Muestra;

public class AdministradorZonaTest {

	ZonaDeCobertura unaZonaDeCobertura;
	ZonaDeCobertura otraZonaDeCobertura;
	Muestra unaMuestra;
	AdministradorZona administradorZona;

	@Before
	public void setUp() {
		//DOC
		unaZonaDeCobertura = mock(ZonaDeCobertura.class);
		otraZonaDeCobertura = mock(ZonaDeCobertura.class);
		unaMuestra = mock(Muestra.class);
		
		//SUT
		administradorZona = new AdministradorZona();
	}
	
	@Test
	public void cuandoUnAdministradorDeZonaSeCreaNoTieneNingunaZonaTest() {
		//exercise
		int cantidad = administradorZona.cantidadDeZonasDeCobertura();
				
		//verify
		assertEquals(0, cantidad);
	}
	
	@Test
	public void agregarZonaTest_CuandoEsLaPrimerZona() {
		//setup
		int cantidadDeZonasAntes = administradorZona.cantidadDeZonasDeCobertura();
		
		//exercise
		administradorZona.agregarZona(unaZonaDeCobertura);
		int cantidadDeZonasDespues = administradorZona.cantidadDeZonasDeCobertura();
		
		//verify
		assertEquals(0, cantidadDeZonasAntes);
		assertEquals(1, cantidadDeZonasDespues);
	}
	
	@Test
	public void agregarZonaTest_CuandoSolapaConOtraZona() {
		//setup
		administradorZona.agregarZona(unaZonaDeCobertura);
		when(unaZonaDeCobertura.solapaCon(otraZonaDeCobertura)).thenReturn(true);
		
		//exercise
		administradorZona.agregarZona(otraZonaDeCobertura);
		
		//verify
		verify(unaZonaDeCobertura, times(1)).solapaCon(otraZonaDeCobertura);
		verify(unaZonaDeCobertura, times(1)).agregarZonaQueSolapa(otraZonaDeCobertura);
		verify(otraZonaDeCobertura, times(1)).agregarZonaQueSolapa(unaZonaDeCobertura);
	}
	
	@Test
	public void agregarZonaTest_CuandoNoSolapaConOtraZona() {
		//setup
		administradorZona.agregarZona(unaZonaDeCobertura);
		when(unaZonaDeCobertura.solapaCon(otraZonaDeCobertura)).thenReturn(false);
		
		//exercise
		administradorZona.agregarZona(otraZonaDeCobertura);
		
		//verify
		verify(unaZonaDeCobertura, times(1)).solapaCon(otraZonaDeCobertura);
		verify(unaZonaDeCobertura, times(0)).agregarZonaQueSolapa(otraZonaDeCobertura);
		verify(otraZonaDeCobertura, times(0)).agregarZonaQueSolapa(unaZonaDeCobertura);
	}
	
	@Test
	public void agregarMuestraTest_ConUnaMuestraDentroDeLaZona() {
		//setup
		administradorZona.agregarZona(unaZonaDeCobertura);
		when(unaZonaDeCobertura.estaDentroDeZona(unaMuestra)).thenReturn(true);
		
		//exercise
		administradorZona.agregarMuestra(unaMuestra);
		
		//verify
		verify(unaZonaDeCobertura, times(1)).estaDentroDeZona(unaMuestra);
		verify(unaZonaDeCobertura, times(1)).agregarMuestra(unaMuestra);
	}
	
	@Test
	public void agregarMuestraTest_ConUnaMuestraFueraDeLaZona() {
		//setup
		administradorZona.agregarZona(unaZonaDeCobertura);
		when(unaZonaDeCobertura.estaDentroDeZona(unaMuestra)).thenReturn(false);
		
		//exercise
		administradorZona.agregarMuestra(unaMuestra);
		
		//verify
		verify(unaZonaDeCobertura, times(1)).estaDentroDeZona(unaMuestra);
		verify(unaZonaDeCobertura, times(0)).agregarMuestra(unaMuestra);
	}
	
	@Test
	public void muestraValidadaTest_CuandoLaMuestraPerteneceAUnaZona() {
		//setup
		administradorZona.agregarZona(unaZonaDeCobertura);
		when(unaZonaDeCobertura.estaDentroDeZona(unaMuestra)).thenReturn(true);			
		administradorZona.agregarMuestra(unaMuestra);
		
		//exercise
		administradorZona.muestraValidada(unaMuestra);
		
		//verify
		verify(unaZonaDeCobertura, times(1)).notificarMuestraValidada(unaMuestra);
	}
	
	@Test
	public void muestraValidadaTest_CuandoLaMuestraNoPerteneceAUnaZona() {
		//setup
		administradorZona.agregarZona(unaZonaDeCobertura);
		when(unaZonaDeCobertura.estaDentroDeZona(unaMuestra)).thenReturn(false);			
		administradorZona.agregarMuestra(unaMuestra);
		
		//exercise
		administradorZona.muestraValidada(unaMuestra);
		
		//verify
		verify(unaZonaDeCobertura, times(0)).notificarMuestraValidada(unaMuestra);
	}
}
