package web;

import web.administradorMuestra.AdministradorMuestra;
import web.administradorMuestra.Muestra;
import web.administradorUsuario.AdministradorUsuario;
import web.administradorZona.*;
import web.extras.Opinion;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class WebTest {
	
	Web web;
	AdministradorUsuario unAdministradorUsuario;
	AdministradorMuestra unAdministradorMuestra;
	AdministradorZona unAdministradorZona;
	ZonaDeCobertura unaZonaDeCobertura;
	Muestra unaMuestra;
	Opinion unaOpinion;
	
	@Before
	public void setUp() {
		//setup
		unAdministradorUsuario = mock(AdministradorUsuario.class);
		unAdministradorMuestra = mock(AdministradorMuestra.class);
		unAdministradorZona = mock(AdministradorZona.class);		
		unaZonaDeCobertura = mock(ZonaDeCobertura.class);
		unaMuestra = mock(Muestra.class);
		unaOpinion = mock(Opinion.class);
		
		//test double installation
		web = new Web(unAdministradorUsuario, unAdministradorMuestra, unAdministradorZona);
	}
	
	@Test
	public void agregarNuevaZonaTest() {
		//exercise
		web.agregarNuevaZona(unaZonaDeCobertura);
		
		//verify
		verify(unAdministradorZona, times(1)).agregarZona(unaZonaDeCobertura);
	}
	
	@Test
	public void agregarNuevaMuestraTest() {
		//exercise
		web.agregarNuevaMuestra(unaMuestra);
		
		//verify
		verify(unAdministradorMuestra, times(1)).agregarMuestra(unaMuestra);
		verify(unAdministradorUsuario, times(1)).agregarMuestra(unaMuestra);
		verify(unAdministradorZona, times(1)).agregarMuestra(unaMuestra);
	}
	
	@Test
	public void agregarNuevaOpinionTest_ConOpinionDeUsuarioExpertoAMuestraNoValidada() {
		//setup
		when(unAdministradorMuestra.agregarOpinion(unaOpinion)).thenReturn(true);
		when(unaOpinion.getMuestra()).thenReturn(unaMuestra);
		when(unaMuestra.estaVerificada()).thenReturn(false, true);
		
		//exercise
		web.agregarNuevaOpinion(unaOpinion);
		
		//verify
		verify(unAdministradorMuestra, times(1)).agregarOpinion(unaOpinion);
		verify(unAdministradorUsuario, times(1)).agregarOpinion(unaOpinion);
		verify(unAdministradorZona, times(1)).muestraValidada(unaMuestra);		
	}
	
	@Test
	public void agregarNuevaOpinionTest_ConOpinionDeUsuarioBasicoAMuestraNoValidada() {
		//setup
		when(unAdministradorMuestra.agregarOpinion(unaOpinion)).thenReturn(true);
		when(unaOpinion.getMuestra()).thenReturn(unaMuestra);
		when(unaMuestra.estaVerificada()).thenReturn(false, false);
		
		//exercise
		web.agregarNuevaOpinion(unaOpinion);
		
		//verify
		verify(unAdministradorMuestra, times(1)).agregarOpinion(unaOpinion);
		verify(unAdministradorUsuario, times(1)).agregarOpinion(unaOpinion);
		verify(unAdministradorZona, times(0)).muestraValidada(unaMuestra);		
	}
	
	@Test
	public void agregarNuevaOpinionTest_ConOpinionDeUsuarioBasicoAMuestraValidada() {
		//setup
		when(unAdministradorMuestra.agregarOpinion(unaOpinion)).thenReturn(false);
		when(unaOpinion.getMuestra()).thenReturn(unaMuestra);
		when(unaMuestra.estaVerificada()).thenReturn(true, true);
		
		//exercise
		web.agregarNuevaOpinion(unaOpinion);
		
		//verify
		verify(unAdministradorMuestra, times(1)).agregarOpinion(unaOpinion);
		verify(unAdministradorUsuario, times(0)).agregarOpinion(unaOpinion);
		verify(unAdministradorZona, times(0)).muestraValidada(unaMuestra);		
	}
	
	@Test
	public void agregarNuevaOpinionTest_ConOpinionDeUsuarioExpertoAMuestraValidada() {
		//setup
		when(unAdministradorMuestra.agregarOpinion(unaOpinion)).thenReturn(true);
		when(unaOpinion.getMuestra()).thenReturn(unaMuestra);
		when(unaMuestra.estaVerificada()).thenReturn(true, true);
		
		//exercise
		web.agregarNuevaOpinion(unaOpinion);
		
		//verify
		verify(unAdministradorMuestra, times(1)).agregarOpinion(unaOpinion);
		verify(unAdministradorUsuario, times(1)).agregarOpinion(unaOpinion);
		verify(unAdministradorZona, times(0)).muestraValidada(unaMuestra);		
	}
}
