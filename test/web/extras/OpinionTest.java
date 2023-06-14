package web.extras;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import web.administradorUsuario.Usuario;
import web.administradorMuestra.Muestra;

public class OpinionTest {
	
	@Test
	public void unaOpinionSeCreaConUnTipoDeOpinionUnUsarioYUnaMuestraTest() {
		//setup
		Usuario unUsuario = mock(Usuario.class);
		Muestra unaMuestra = mock(Muestra.class);
		
		//exercise
		Opinion opinion = new Opinion(TipoDeOpinion.VINCHUCASORDIDA, unUsuario, unaMuestra);
		
		//verify
		assertEquals(TipoDeOpinion.VINCHUCASORDIDA, opinion.getTipoDeOpinion());
		assertEquals(unUsuario, opinion.getUsuario());
		assertEquals(unaMuestra, opinion.getMuestra());
	}
	
	@Test
	public void unaOpinionCuandoSeCreaSeGuardaLaFechaDeCreacionTest() {
		//setup
		Usuario unUsuario = mock(Usuario.class);
		Muestra unaMuestra = mock(Muestra.class);
		LocalDate fechaEsperada = LocalDate.now();
		
		//exercise
		Opinion opinion = new Opinion(TipoDeOpinion.VINCHUCASORDIDA, unUsuario, unaMuestra);
		LocalDate fechaOpinion = opinion.getFecha();
		
		//verify
		assertEquals(fechaEsperada, fechaOpinion);
	}
}
