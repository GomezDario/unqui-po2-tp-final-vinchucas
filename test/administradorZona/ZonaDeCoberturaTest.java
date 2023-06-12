package administradorZona;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ZonaDeCoberturaTest {

	ZonaDeCobertura zonaDeCobertura;
	ZonaDeCobertura otraZonaDeCobertura;
	Ubicacion unaUbicacion;
	Ubicacion otraUbicacion;
	Muestra unaMuestra;
	Observador unaOrganizacionNoGubernamental;
	
	@Before
	public void setUp() {
		//setup
		unaUbicacion = mock(Ubicacion.class);
		otraUbicacion = mock(Ubicacion.class);
		unaMuestra = mock(Muestra.class);
		otraZonaDeCobertura = mock(ZonaDeCobertura.class);
		unaOrganizacionNoGubernamental = mock(OrganizacionNoGubernamental.class);
		
		//test double installation
		zonaDeCobertura = new ZonaDeCobertura(unaUbicacion, 10.0, "Quilmes");
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
		when(unaUbicacion.distanciaEntre(otraUbicacion)).thenReturn((float) 9);
		
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
		when(unaUbicacion.distanciaEntre(otraUbicacion)).thenReturn((float) 11);
		
		//exercise
		boolean estaDentro = zonaDeCobertura.estaDentroDeZona(unaMuestra);
		
		//verify
		assertEquals(false, estaDentro);
		verify(unaMuestra, times(1)).getUbicacion();
		verify(unaUbicacion, times(1)).distanciaEntre(unaMuestra.getUbicacion());
	}
	
	@Test
	public void zonasQueSolapanTest() {
		//setup
	    zonaDeCobertura.agregarZona(otraZonaDeCobertura);
		
		//exercise
		List<ZonaDeCobertura> zonasQueSolapan = zonaDeCobertura.getZonasQueSolapan();
		
		//verify
		assertEquals(otraZonaDeCobertura, zonasQueSolapan.get(0));
	}
	
	@Test
	public void agregarZonaTest() {
		//setup
		int cantidadDeZonasAntes = zonaDeCobertura.cantidadDeZonasQueSolapan();
		
		//exercise
		zonaDeCobertura.agregarZona(otraZonaDeCobertura);
		int cantidadDeZonasDespues = zonaDeCobertura.cantidadDeZonasQueSolapan();
		
		//verify
		assertEquals(0, cantidadDeZonasAntes);
		assertEquals(1, cantidadDeZonasDespues);
	}
	
	@Test
	public void solapaConTest_CuandoUnaZonaSolapaConOtra() {
		//setup
		when(otraZonaDeCobertura.getUbicacion()).thenReturn(otraUbicacion);
		
		when(unaUbicacion.getLatitud()).thenReturn(-34.6037);
		when(unaUbicacion.getLongitud()).thenReturn(-58.3816);
		
		when(otraUbicacion.getLatitud()).thenReturn(-34.6074);
		when(otraUbicacion.getLongitud()).thenReturn(-58.3862);
		when(otraZonaDeCobertura.getRadio()).thenReturn(10.0);
		
		//exercise
		boolean solapa = zonaDeCobertura.solapaCon(otraZonaDeCobertura);
		
		//verify
		assertEquals(true, solapa);
		verify(otraZonaDeCobertura, times(1)).getUbicacion();
		verify(otraZonaDeCobertura, times(1)).getRadio();
		verify(otraUbicacion, times(1)).getLatitud();
		verify(otraUbicacion, times(1)).getLongitud();
		verify(unaUbicacion, times(1)).getLatitud();
		verify(unaUbicacion, times(1)).getLongitud();
	}
	
	@Test
	public void solapaConTest_CuandoUnaZonaNoSolapaConOtra() {
		//setup
		when(otraZonaDeCobertura.getUbicacion()).thenReturn(otraUbicacion);
		
		when(unaUbicacion.getLatitud()).thenReturn(-34.6037);
		when(unaUbicacion.getLongitud()).thenReturn(-58.3816);
		
		when(otraUbicacion.getLatitud()).thenReturn(-28.6074);
		when(otraUbicacion.getLongitud()).thenReturn(-60.3862);
		when(otraZonaDeCobertura.getRadio()).thenReturn(1.0);
		
		//exercise
		boolean solapa = zonaDeCobertura.solapaCon(otraZonaDeCobertura);
		
		//verify
		assertEquals(false, solapa);
		verify(otraZonaDeCobertura, times(1)).getUbicacion();
		verify(otraZonaDeCobertura, times(1)).getRadio();
		verify(otraUbicacion, times(1)).getLatitud();
		verify(otraUbicacion, times(1)).getLongitud();
		verify(unaUbicacion, times(1)).getLatitud();
		verify(unaUbicacion, times(1)).getLongitud();
	}
	
	@Test
	public void registrarTest() {
		//setup
		int observadoresAntes = zonaDeCobertura.cantidadDeObservadores();
		
		//exercise
		zonaDeCobertura.registrar(unaOrganizacionNoGubernamental);
		int observadoresDespues = zonaDeCobertura.cantidadDeObservadores();
		
		//verify
		assertEquals(0, observadoresAntes);
		assertEquals(1, observadoresDespues);
	}
	
	@Test
	public void desregistrarTest() {
		//setup
		zonaDeCobertura.registrar(unaOrganizacionNoGubernamental);
		int observadoresAntes = zonaDeCobertura.cantidadDeObservadores();
		
		//exercise
		zonaDeCobertura.desregistrar(unaOrganizacionNoGubernamental);
		int observadoresDespues = zonaDeCobertura.cantidadDeObservadores();
		
		//verify
		assertEquals(1, observadoresAntes);
		assertEquals(0, observadoresDespues);
	}
	
	@Test
	public void cuandoSeAgregaUnaNuevaMuestraSeNotificaATodosLosObservadores() {
		//setup
		zonaDeCobertura.registrar(unaOrganizacionNoGubernamental);
		
		//exercise
		zonaDeCobertura.agregarMuestra(unaMuestra);
		
		//verify
		verify(unaOrganizacionNoGubernamental, times(1)).funcionNuevaMuestra(zonaDeCobertura, unaMuestra);
	}
	
}