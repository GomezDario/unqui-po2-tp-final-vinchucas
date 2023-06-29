package web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import web.muestra.Muestra;
import web.opinion.Opinion;
import web.zona.ZonaDeCobertura;

public class WebTest {
	
	Web web;
	Muestra unaMuestra;
	Opinion unaOpinion;
	ZonaDeCobertura unaZonaDeCobertura;
	ZonaDeCobertura otraZonaDeCobertura;
	
	@Before
	public void setUp() {
		//DOC
		unaMuestra = mock(Muestra.class);
		unaOpinion = mock(Opinion.class);
		unaZonaDeCobertura = mock(ZonaDeCobertura.class);
		otraZonaDeCobertura = mock(ZonaDeCobertura.class);
		
		//SUT
		web = new Web();
	}
	
	//ZONAS
	
	@Test
	public void cuandoUnaWebSeCreaNoTieneNingunaZonaNiMuestrasNiUsuariosTest() {
		//exercise
		int cantidadZonas = web.cantidadDeZonasDeCobertura();
		int cantidadUsuarios = web.cantidadDeUsuarios();
		int cantidadMuestras = web.cantidadDeMuestras();
				
		//verify
		assertEquals(0, cantidadZonas);
		assertEquals(0, cantidadUsuarios);
		assertEquals(0, cantidadMuestras);
	}
	
	@Test
	public void agregarNuevaZonaDeCoberturaTest_CuandoEsLaPrimerZona() {
		//setup
		int cantidadDeZonasAntes = web.cantidadDeZonasDeCobertura();
		
		//exercise
		web.agregarNuevaZonaDeCobertura(unaZonaDeCobertura);
		int cantidadDeZonasDespues = web.cantidadDeZonasDeCobertura();
		
		//verify
		assertEquals(0, cantidadDeZonasAntes);
		assertEquals(1, cantidadDeZonasDespues);
	}
	
	@Test
	public void agregarNuevaZonaDeCoberturaTest_CuandoEsLaSegundaZonaYNoSeRepite() {
		//setup
		web.agregarNuevaZonaDeCobertura(unaZonaDeCobertura);
		int cantidadDeZonasAntes = web.cantidadDeZonasDeCobertura();
		
		//exercise
		web.agregarNuevaZonaDeCobertura(otraZonaDeCobertura);
		int cantidadDeZonasDespues = web.cantidadDeZonasDeCobertura();
		
		//verify
		assertEquals(1, cantidadDeZonasAntes);
		assertEquals(2, cantidadDeZonasDespues);
	}
	
	@Test
	public void agregarNuevaZonaDeCoberturaTest_CuandoEsLaSegundaZonaYSeRepite() {
		//setup
		web.agregarNuevaZonaDeCobertura(unaZonaDeCobertura);
		int cantidadDeZonasAntes = web.cantidadDeZonasDeCobertura();
		
		//exercise
		web.agregarNuevaZonaDeCobertura(unaZonaDeCobertura);
		int cantidadDeZonasDespues = web.cantidadDeZonasDeCobertura();
		
		//verify
		assertEquals(1, cantidadDeZonasAntes);
		assertEquals(1, cantidadDeZonasDespues);
	}
	
	@Test
	public void agregarNuevaMuestraTest_CuandoEsLaPrimerMuestra() {
		//setup
		int cantidadDeMuestrasAntes = web.cantidadDeMuestras();
		
		//exercise
		web.agregarNuevaMuestra(unaMuestra);
		int cantidadDeMuestrasDespues = web.cantidadDeMuestras();
		
		//verify
		assertEquals(0, cantidadDeMuestrasAntes);
		assertEquals(1, cantidadDeMuestrasDespues);
	}
	
}
