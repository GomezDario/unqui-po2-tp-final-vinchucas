package web.zona;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import web.muestra.Muestra;
import web.ubicacion.Ubicacion;

public class ZonaDeCoberturaTest {

	ZonaDeCobertura zonaDeCobertura;
	ZonaDeCobertura otraZonaDeCobertura;
	Ubicacion unaUbicacion;
	Ubicacion otraUbicacion;
	Muestra unaMuestra;
	Observador unObserver;
	Observador otroObserver;

	@Before
	public void setUp() {
		//DOC
		unaUbicacion = mock(Ubicacion.class);
		otraUbicacion = mock(Ubicacion.class);
		unaMuestra = mock(Muestra.class);
		otraZonaDeCobertura = mock(ZonaDeCobertura.class);
		unObserver = mock(Observador.class);
		otroObserver = mock(Observador.class);
		
		//SUT
		zonaDeCobertura = new ZonaDeCobertura(unaUbicacion, 10.0, "Quilmes");
	}
	
	@Test
	public void cuandoUnaZonaDeCoberturaSeCreaEsConUnaUbicacionUnRadioYUnNombreTest() {
		//verify
		assertEquals(unaUbicacion, zonaDeCobertura.getUbicacion());
		assertEquals(10.0, zonaDeCobertura.getRadio(), 0);
		assertEquals("Quilmes", zonaDeCobertura.getNombre());
	}
	
	@Test
	public void cuandoUnaZonaDeCoberturaSeCreaNoTieneMuestrasNiZonasQueSolapanNiObservadoresRegistradasTest() {
		//verify
		assertEquals(0, zonaDeCobertura.cantidadDeMuestras());
		assertEquals(0, zonaDeCobertura.cantidadDeZonasQueSolapan());
		assertEquals(0, zonaDeCobertura.cantidadDeObservadores());
	}

	@Test
	public void agregarMuestraTest() {
		//setup
		int cantidadDeMuestrasAntes = zonaDeCobertura.cantidadDeMuestras();
		
		//exercise
		zonaDeCobertura.agregarMuestra(unaMuestra);
		int cantidadDeMuestrasDespues = zonaDeCobertura.cantidadDeMuestras();
		
		//verify
		assertEquals(0, cantidadDeMuestrasAntes);
		assertEquals(1, cantidadDeMuestrasDespues);
	}
	
	@Test
	public void estaDentroDeZonaTest_ConUnaMuestraDentroDelRadio() {
		//setup
		when(unaMuestra.getUbicacion()).thenReturn(otraUbicacion);
		when(unaUbicacion.distanciaEntre(otraUbicacion)).thenReturn(9.0);
		
		//exercise
		boolean estaDentro = zonaDeCobertura.estaDentroDeZona(unaMuestra);
		
		//verify
		assertEquals(true, estaDentro);
		verify(unaMuestra, times(1)).getUbicacion();
		verify(unaUbicacion, times(1)).distanciaEntre(unaMuestra.getUbicacion());
	}
	
	@Test
	public void estaDentroDeZonaTest_ConUnaMuestraFueraDelRadio() {
		//setup
		when(unaMuestra.getUbicacion()).thenReturn(otraUbicacion);
		when(unaUbicacion.distanciaEntre(otraUbicacion)).thenReturn(11.0);
		
		//exercise
		boolean estaDentro = zonaDeCobertura.estaDentroDeZona(unaMuestra);
		
		//verify
		assertEquals(false, estaDentro);
		verify(unaMuestra, times(1)).getUbicacion();
		verify(unaUbicacion, times(1)).distanciaEntre(unaMuestra.getUbicacion());
	}
	
	@Test
	public void agregarZonaQueSolapaTest() {
		//setup
		int cantidadDeZonasAntes = zonaDeCobertura.cantidadDeZonasQueSolapan();
		
		//exercise
		zonaDeCobertura.agregarZonaQueSolapa(otraZonaDeCobertura);
		int cantidadDeZonasDespues = zonaDeCobertura.cantidadDeZonasQueSolapan();
		List<ZonaDeCobertura> zonasQueSolapan = zonaDeCobertura.getZonasQueSolapan();
		
		//verify
		assertEquals(0, cantidadDeZonasAntes);
		assertEquals(1, cantidadDeZonasDespues);
		assertEquals(otraZonaDeCobertura, zonasQueSolapan.get(0));
	}
	
	@Test
	public void solapaConTest_CuandoUnaZonaSolapaConOtra() {
		//setup
		when(otraZonaDeCobertura.getUbicacion()).thenReturn(otraUbicacion);
		when(unaUbicacion.distanciaEntre(otraUbicacion)).thenReturn(14.0);
		when(otraZonaDeCobertura.getRadio()).thenReturn(5.0);
		
		//exercise
		boolean solapa = zonaDeCobertura.solapaCon(otraZonaDeCobertura);
		
		//verify
		assertEquals(true, solapa);
		verify(otraZonaDeCobertura, times(1)).getUbicacion();
		verify(unaUbicacion, times(1)).distanciaEntre(otraUbicacion);
		verify(otraZonaDeCobertura, times(1)).getRadio();
	}
	
	@Test
	public void solapaConTest_CuandoUnaZonaNoSolapaConOtra() {
		//setup
		when(otraZonaDeCobertura.getUbicacion()).thenReturn(otraUbicacion);
		when(unaUbicacion.distanciaEntre(otraUbicacion)).thenReturn(16.0);
		when(otraZonaDeCobertura.getRadio()).thenReturn(5.0);
		
		//exercise
		boolean solapa = zonaDeCobertura.solapaCon(otraZonaDeCobertura);
		
		//verify
		assertEquals(false, solapa);
		verify(otraZonaDeCobertura, times(1)).getUbicacion();
		verify(unaUbicacion, times(1)).distanciaEntre(otraUbicacion);
		verify(otraZonaDeCobertura, times(1)).getRadio();
	}

	@Test
	public void registrarTest_ConUnObserverInexistente() {
		//setup
		int observadoresAntes = zonaDeCobertura.cantidadDeObservadores();

		//exercise
		zonaDeCobertura.registrar(unObserver);
		int observadoresDespues = zonaDeCobertura.cantidadDeObservadores();

		//verify
		assertEquals(0, observadoresAntes);
		assertEquals(1, observadoresDespues);
	}
	
	@Test
	public void registrarTest_CuandoUnObserverYaExisteNoLoRegistra() {
		//setup
		zonaDeCobertura.registrar(unObserver);
		int observadoresAntes = zonaDeCobertura.cantidadDeObservadores();

		//exercise
		zonaDeCobertura.registrar(unObserver);
		int observadoresDespues = zonaDeCobertura.cantidadDeObservadores();

		//verify
		assertEquals(1, observadoresAntes);
		assertEquals(1, observadoresDespues);
	}

	@Test
	public void desregistrarTest_ConUnObserverExistente() {
		//setup
		zonaDeCobertura.registrar(unObserver);
		int observadoresAntes = zonaDeCobertura.cantidadDeObservadores();

		//exercise
		zonaDeCobertura.desregistrar(unObserver);
		int observadoresDespues = zonaDeCobertura.cantidadDeObservadores();

		//verify
		assertEquals(1, observadoresAntes);
		assertEquals(0, observadoresDespues);
	}
	
	@Test
	public void desregistrarTest_ConUnObserverInexistente() {
		//setup
		zonaDeCobertura.registrar(unObserver);
		int observadoresAntes = zonaDeCobertura.cantidadDeObservadores();

		//exercise
		zonaDeCobertura.desregistrar(otroObserver);
		int observadoresDespues = zonaDeCobertura.cantidadDeObservadores();

		//verify
		assertEquals(1, observadoresAntes);
		assertEquals(1, observadoresDespues);
	}
	
	@Test
	public void agregarMuestraTest_SeNotificaATodosLosObservadoresRegistrados() {
		//setup
		zonaDeCobertura.registrar(unObserver);
		
		//exercise
		zonaDeCobertura.agregarMuestra(unaMuestra);
		
		//verify
		verify(unObserver, times(1)).funcionNuevaMuestra(zonaDeCobertura, unaMuestra);
		verify(otroObserver, times(0)).funcionNuevaMuestra(zonaDeCobertura, unaMuestra);
	}
	
	@Test
	public void notificarMuestraValidadaTest_ATodosLosObservadoresRegistrados() {
		//setup
		zonaDeCobertura.registrar(unObserver);
		
		//exercise
		zonaDeCobertura.notificarMuestraValidada(unaMuestra);
		
		//verify
		verify(unObserver, times(1)).funcionValidacionMuestra(zonaDeCobertura, unaMuestra);
		verify(otroObserver, times(0)).funcionValidacionMuestra(zonaDeCobertura, unaMuestra);
	}
	
}