package web;

import web.administradorMuestra.AdministradorMuestra;
import web.administradorMuestra.Muestra;
import web.administradorUsuario.AdministradorUsuario;
import web.administradorZona.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class WebTest {
	
	Web web;
	AdministradorUsuario unAdministradorUsuario;
	AdministradorMuestra unAdministradorMuestra;
	AdministradorZona unAdministradorZona;
	ZonaDeCobertura unaZonaDeCobertura;
	Muestra unaMuestra;
	
	@Before
	public void setUp() {
		//setup
		unAdministradorUsuario = mock(AdministradorUsuario.class);
		unAdministradorMuestra = mock(AdministradorMuestra.class);
		unAdministradorZona = mock(AdministradorZona.class);		
		unaZonaDeCobertura = mock(ZonaDeCobertura.class);
		unaMuestra = mock(Muestra.class);
		
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
	
//	@Test
//	public void agregarNuevaMuestraTest() {
//		//exercise
//		web.agregarNuevaMuestra(unaMuestra);
//		
//		//verify
//		verify(unAdministradorMuestra, times(1)).agregarMuestra(unaZonaDeCobertura);
//	}
}
