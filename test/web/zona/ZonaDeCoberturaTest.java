package web.zona;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import web.muestra.Muestra;
import web.ubicacion.Ubicacion;

public class ZonaDeCoberturaTest {

	ZonaDeCobertura zonaDeCobertura;
	ZonaDeCobertura unaZonaDeCoberturaQueSolapa;
	ZonaDeCobertura otraZonaDeCoberturaQueSolapa;
	ZonaDeCobertura unaZonaDeCoberturaQueNoSolapa;
	Ubicacion unaUbicacionDeZonaDeCobertura;
	Ubicacion unaUbicacionDeMuestraDentro;
	Ubicacion unaUbicacionDeMuestraFuera;
	Muestra unaMuestraDentroDeZona;
	Muestra unaMuestraFueraDeZona;
	ObservadorOrg unObservadorOrg;
	ObservadorOrg otroObservadorOrg;

	@Before
	public void setUp() {
		//DOC
		unaUbicacionDeZonaDeCobertura = mock(Ubicacion.class);
		unaUbicacionDeMuestraDentro = mock(Ubicacion.class);
		unaUbicacionDeMuestraFuera = mock(Ubicacion.class);
		
		unaZonaDeCoberturaQueSolapa = mock(ZonaDeCobertura.class);
		otraZonaDeCoberturaQueSolapa = mock(ZonaDeCobertura.class);
		unaZonaDeCoberturaQueNoSolapa = mock(ZonaDeCobertura.class);
		
		unObservadorOrg = mock(ObservadorOrg.class);
		otroObservadorOrg = mock(ObservadorOrg.class);
		
		unaMuestraDentroDeZona = mock(Muestra.class);
		when(unaMuestraDentroDeZona.getUbicacion()).thenReturn(unaUbicacionDeMuestraDentro);
		when(unaUbicacionDeZonaDeCobertura.distanciaEntre(unaUbicacionDeMuestraDentro)).thenReturn(9.0);
		
		unaMuestraFueraDeZona = mock(Muestra.class);
		when(unaMuestraFueraDeZona.getUbicacion()).thenReturn(unaUbicacionDeMuestraFuera);
		when(unaUbicacionDeZonaDeCobertura.distanciaEntre(unaUbicacionDeMuestraFuera)).thenReturn(11.0);
		
		//SUT
		zonaDeCobertura = new ZonaDeCobertura(unaUbicacionDeZonaDeCobertura, 10.0, "Quilmes");
	}
	
	@Test
	public void cuandoUnaZonaDeCoberturaSeCreaEsConUnaUbicacionUnRadioUnNombreYNotieneObservadoresTest() {
		//verify
		assertEquals(unaUbicacionDeZonaDeCobertura, zonaDeCobertura.getUbicacion());
		assertEquals(10.0, zonaDeCobertura.getRadio(), 0);
		assertEquals("Quilmes", zonaDeCobertura.getNombre());
		assertEquals(0, zonaDeCobertura.cantidadDeObservadores());
	}
	
	@Test
	public void estaDentroDeZonaTest_ConUnaMuestraDentroDelRadio() {
		//exercise
		boolean estaDentro = zonaDeCobertura.estaDentroDeZona(unaMuestraDentroDeZona);
		
		//verify
		assertEquals(true, estaDentro);
		verify(unaMuestraDentroDeZona, times(1)).getUbicacion();
		verify(unaUbicacionDeZonaDeCobertura, times(1)).distanciaEntre(unaMuestraDentroDeZona.getUbicacion());
	}
	
	@Test
	public void estaDentroDeZonaTest_ConUnaMuestraFueraDelRadio() {
		//exercise
		boolean estaDentro = zonaDeCobertura.estaDentroDeZona(unaMuestraFueraDeZona);
		
		//verify
		assertEquals(false, estaDentro);
		verify(unaMuestraFueraDeZona, times(1)).getUbicacion();
		verify(unaUbicacionDeZonaDeCobertura, times(1)).distanciaEntre(unaMuestraFueraDeZona.getUbicacion());
	}
	
	@Test
	public void registrarTest_ConUnObserverInexistente() {
		//setup
		int observadoresAntes = zonaDeCobertura.cantidadDeObservadores();

		//exercise
		zonaDeCobertura.registrar(unObservadorOrg);
		int observadoresDespues = zonaDeCobertura.cantidadDeObservadores();

		//verify
		assertEquals(0, observadoresAntes);
		assertEquals(1, observadoresDespues);
	}
	
	@Test
	public void registrarTest_CuandoUnObserverYaExisteNoLoRegistra() {
		//setup
		zonaDeCobertura.registrar(unObservadorOrg);
		int observadoresAntes = zonaDeCobertura.cantidadDeObservadores();

		//exercise
		zonaDeCobertura.registrar(unObservadorOrg);
		int observadoresDespues = zonaDeCobertura.cantidadDeObservadores();

		//verify
		assertEquals(1, observadoresAntes);
		assertEquals(1, observadoresDespues);
	}

	@Test
	public void desregistrarTest_ConUnObserverExistente() {
		//setup
		zonaDeCobertura.registrar(unObservadorOrg);
		int observadoresAntes = zonaDeCobertura.cantidadDeObservadores();

		//exercise
		zonaDeCobertura.desregistrar(unObservadorOrg);
		int observadoresDespues = zonaDeCobertura.cantidadDeObservadores();

		//verify
		assertEquals(1, observadoresAntes);
		assertEquals(0, observadoresDespues);
	}
	
	@Test
	public void desregistrarTest_ConUnObserverInexistente() {
		//setup
		zonaDeCobertura.registrar(unObservadorOrg);
		int observadoresAntes = zonaDeCobertura.cantidadDeObservadores();

		//exercise
		zonaDeCobertura.desregistrar(otroObservadorOrg);
		int observadoresDespues = zonaDeCobertura.cantidadDeObservadores();

		//verify
		assertEquals(1, observadoresAntes);
		assertEquals(1, observadoresDespues);
	}
	
	@Test
	public void notificarNuevaMuestraSiEstaDentroDeZonaTest_CuandoEstaDentroDeZona() {
		//setup
		zonaDeCobertura.registrar(unObservadorOrg);
		
		//exercise
		zonaDeCobertura.notificarNuevaMuestraSiEstaDentroDeZona(unaMuestraDentroDeZona);
		
		//verify
		verify(unObservadorOrg, times(1)).funcionNuevaMuestra(zonaDeCobertura, unaMuestraDentroDeZona);
		verify(unaMuestraDentroDeZona, times(1)).registrar(zonaDeCobertura);
	}
	
	@Test
	public void notificarNuevaMuestraSiEstaDentroDeZonaTest_CuandoNoEstaDentroDeZona() {
		//setup
		zonaDeCobertura.registrar(unObservadorOrg);
		
		//exercise
		zonaDeCobertura.notificarNuevaMuestraSiEstaDentroDeZona(unaMuestraFueraDeZona);
		
		//verify
		verify(unObservadorOrg, times(0)).funcionNuevaMuestra(zonaDeCobertura, unaMuestraFueraDeZona);
		verify(unaMuestraFueraDeZona, times(0)).registrar(zonaDeCobertura);
	}
	
	@Test
	public void notificarMuestraValidadaTest_ATodosLosObservadoresRegistrados() {
		//setup
		zonaDeCobertura.registrar(unObservadorOrg);
		zonaDeCobertura.registrar(otroObservadorOrg);
		
		//exercise
		zonaDeCobertura.notificarMuestraValidada(unaMuestraDentroDeZona);
		
		//verify
		verify(unObservadorOrg, times(1)).funcionValidacionMuestra(zonaDeCobertura, unaMuestraDentroDeZona);
		verify(otroObservadorOrg, times(1)).funcionValidacionMuestra(zonaDeCobertura, unaMuestraDentroDeZona);
	}
	
	@Test
	public void solapaConTest_CuandoUnaZonaSolapaConOtra() {
		//setup
		when(unaZonaDeCoberturaQueSolapa.getUbicacion()).thenReturn(unaUbicacionDeMuestraDentro);
		when(unaUbicacionDeZonaDeCobertura.distanciaEntre(unaUbicacionDeMuestraDentro)).thenReturn(14.0);
		when(unaZonaDeCoberturaQueSolapa.getRadio()).thenReturn(5.0);
		
		//exercise
		boolean solapa = zonaDeCobertura.solapaCon(unaZonaDeCoberturaQueSolapa);
		
		//verify
		assertEquals(true, solapa);
		verify(unaZonaDeCoberturaQueSolapa, times(1)).getUbicacion();
		verify(unaUbicacionDeZonaDeCobertura, times(1)).distanciaEntre(unaUbicacionDeMuestraDentro);
		verify(unaZonaDeCoberturaQueSolapa, times(1)).getRadio();
	}
	
	@Test
	public void solapaConTest_CuandoUnaZonaNoSolapaConOtra() {
		//setup
		when(unaZonaDeCoberturaQueNoSolapa.getUbicacion()).thenReturn(unaUbicacionDeMuestraFuera);
		when(unaUbicacionDeZonaDeCobertura.distanciaEntre(unaUbicacionDeMuestraFuera)).thenReturn(16.0);
		when(unaZonaDeCoberturaQueNoSolapa.getRadio()).thenReturn(5.0);
		
		//exercise
		boolean solapa = zonaDeCobertura.solapaCon(unaZonaDeCoberturaQueNoSolapa);
		
		//verify
		assertEquals(false, solapa);
		verify(unaZonaDeCoberturaQueNoSolapa, times(1)).getUbicacion();
		verify(unaUbicacionDeZonaDeCobertura, times(1)).distanciaEntre(unaUbicacionDeMuestraFuera);
		verify(unaZonaDeCoberturaQueNoSolapa, times(1)).getRadio();
	}
	
	@Test
	public void zonasQueSolapanTest() {
		//setup
		when(unaZonaDeCoberturaQueSolapa.getUbicacion()).thenReturn(unaUbicacionDeMuestraDentro);
		when(unaUbicacionDeZonaDeCobertura.distanciaEntre(unaUbicacionDeMuestraDentro)).thenReturn(14.0);
		when(unaZonaDeCoberturaQueSolapa.getRadio()).thenReturn(5.0);
		
		when(otraZonaDeCoberturaQueSolapa.getUbicacion()).thenReturn(unaUbicacionDeMuestraDentro);
		when(unaUbicacionDeZonaDeCobertura.distanciaEntre(unaUbicacionDeMuestraDentro)).thenReturn(14.0);
		when(otraZonaDeCoberturaQueSolapa.getRadio()).thenReturn(5.0);
		
		when(unaZonaDeCoberturaQueNoSolapa.getUbicacion()).thenReturn(unaUbicacionDeMuestraFuera);
		when(unaUbicacionDeZonaDeCobertura.distanciaEntre(unaUbicacionDeMuestraFuera)).thenReturn(16.0);
		when(unaZonaDeCoberturaQueNoSolapa.getRadio()).thenReturn(5.0);
		
		Set<ZonaDeCobertura> zonasAEvaluar = new HashSet<>();
		zonasAEvaluar.add(unaZonaDeCoberturaQueSolapa);
		zonasAEvaluar.add(otraZonaDeCoberturaQueSolapa);
		zonasAEvaluar.add(unaZonaDeCoberturaQueNoSolapa);
		
		//exercise
		Set<ZonaDeCobertura> zonasResultantes = zonaDeCobertura.zonasQueSolapan(zonasAEvaluar);
		
		//verify
		assertEquals(2, zonasResultantes.size());
		assertTrue(zonasResultantes.contains(unaZonaDeCoberturaQueSolapa));
		assertTrue(zonasResultantes.contains(otraZonaDeCoberturaQueSolapa));
		assertFalse(zonasResultantes.contains(unaZonaDeCoberturaQueNoSolapa));
	}
}