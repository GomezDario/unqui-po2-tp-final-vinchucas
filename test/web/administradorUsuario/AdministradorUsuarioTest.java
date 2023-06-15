package web.administradorUsuario;

import web.extras.*;
import web.administradorMuestra.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdministradorUsuarioTest {

	AdministradorUsuario administradorUsuario;
	Usuario unUsuario;
	Usuario otroUsuario;
	Opinion unaOpinion;
	Opinion otraOpinion;
	Muestra unaMuestra;
	Muestra otraMuestra;
	
	@BeforeEach
	void setUp() {
		//setup
		unUsuario = mock(Usuario.class);
		otroUsuario = mock(Usuario.class);
		unaOpinion = mock(Opinion.class);
		otraOpinion = mock(Opinion.class);
		unaMuestra = mock(Muestra.class);
		otraMuestra = mock(Muestra.class);

		//test double installation
		administradorUsuario = new AdministradorUsuario();
	}

	@Test
	void testAgregarOpinion_ConUnUsuarioNuevo() {
		//setup
		when(unaOpinion.getUsuario()).thenReturn(unUsuario);
		int cantidadDeUsuariosAntes = administradorUsuario.cantidadDeUsuarios();
		
		//exercise
		administradorUsuario.agregarOpinion(unaOpinion);
		int cantidadDeUsuariosDespues = administradorUsuario.cantidadDeUsuarios();
		
		//verify
		assertEquals(0, cantidadDeUsuariosAntes);
		assertEquals(1, cantidadDeUsuariosDespues);
		assertEquals(unUsuario, administradorUsuario.usuarios.get(0));
		verify(unUsuario, times(1)).agregarOpinion(unaOpinion);
	}
	
	@Test
	void testAgregarOpinion_ConUnUsuarioViejo() {
		//setup
		when(unaOpinion.getUsuario()).thenReturn(unUsuario);
		when(otraOpinion.getUsuario()).thenReturn(unUsuario);
		administradorUsuario.agregarOpinion(unaOpinion);
		int cantidadDeUsuariosAntes = administradorUsuario.cantidadDeUsuarios();
		
		//exercise
		administradorUsuario.agregarOpinion(otraOpinion);
		int cantidadDeUsuariosDespues = administradorUsuario.cantidadDeUsuarios();
		
		//verify
		assertEquals(1, cantidadDeUsuariosAntes);
		assertEquals(1, cantidadDeUsuariosDespues);
		assertEquals(unUsuario, administradorUsuario.usuarios.get(0));
		verify(unUsuario, times(1)).agregarOpinion(unaOpinion);
		verify(unUsuario, times(1)).agregarOpinion(otraOpinion);
	}
	
	@Test
	void testAgregarMuestra_ConUnUsuarioNuevo() {
		//setup
		when(unaMuestra.getUsuario()).thenReturn(unUsuario);
		int cantidadDeUsuariosAntes = administradorUsuario.cantidadDeUsuarios();
		
		//exercise
		administradorUsuario.agregarMuestra(unaMuestra);
		int cantidadDeUsuariosDespues = administradorUsuario.cantidadDeUsuarios();
		
		//verify
		assertEquals(0, cantidadDeUsuariosAntes);
		assertEquals(1, cantidadDeUsuariosDespues);
		assertEquals(unUsuario, administradorUsuario.usuarios.get(0));
		verify(unUsuario, times(1)).agregarMuestra(unaMuestra);
	}
	
	@Test
	void testAgregarMuestra_ConUnUsuarioViejo() {
		//setup
		when(unaMuestra.getUsuario()).thenReturn(unUsuario);
		when(otraMuestra.getUsuario()).thenReturn(unUsuario);
		administradorUsuario.agregarMuestra(unaMuestra);
		int cantidadDeUsuariosAntes = administradorUsuario.cantidadDeUsuarios();
		
		//exercise
		administradorUsuario.agregarMuestra(otraMuestra);
		int cantidadDeUsuariosDespues = administradorUsuario.cantidadDeUsuarios();
		
		//verify
		assertEquals(1, cantidadDeUsuariosAntes);
		assertEquals(1, cantidadDeUsuariosDespues);
		assertEquals(unUsuario, administradorUsuario.usuarios.get(0));
		verify(unUsuario, times(1)).agregarMuestra(unaMuestra);
		verify(unUsuario, times(1)).agregarMuestra(otraMuestra);
	}
}
