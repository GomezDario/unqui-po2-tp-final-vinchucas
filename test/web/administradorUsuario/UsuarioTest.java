package web.administradorUsuario;

import web.extras.*;
import web.administradorMuestra.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {

	Usuario usuario;
	EstadoUsuario estado;
	Opinion unaOpinion;
	Muestra unaMuestra;
	
	@BeforeEach
	void setUp() {
		//setup
		estado = mock(EstadoUsuario.class);
		unaOpinion = mock(Opinion.class);
		unaMuestra = mock(Muestra.class);
		
		//test double installation
		usuario = new Usuario("Gabriel Gomez");
	}
	
	// TEST DE GETTERS
	
	@Test
	void getNombreTest() {
		assertEquals(usuario.getNombre(), "Gabriel Gomez");
	}
	
//	@Test
//	void getEstadoTest() {
//		assertEquals(usuario.getEstado(), estado);
//	}
	
	@Test
	void getRegistroOpinionesTest() {
		assertEquals(usuario.getOpiniones().size(), 0);
	}
	
	@Test
	void getRegistroMuestraTest() {
		assertEquals(usuario.getMuestras().size(), 0);
	}
	
	//TEST DE SETTERS
	
	
	@Test
	void setNombreTest() {
		usuario.setNombre("Gabi"); // Cambio de nombre
		assertEquals(usuario.getNombre(), "Gabi");
	}
	
	
	@Test
	void setTipoTest() {
		EstadoUsuario estadoUserNuevo = mock(EstadoUsuario.class);
		usuario.setEstado(estadoUserNuevo);
		assertEquals(usuario.getEstado(), estadoUserNuevo);
	}
	
	@Test
	void setRegistroOpinionesTest() {
		
		ArrayList<Opinion> opiniones = new ArrayList<Opinion>();
		opiniones.add(mock(Opinion.class));
		opiniones.add(mock(Opinion.class));
		
		usuario.setOpiniones(opiniones);
		assertEquals(usuario.getOpiniones().size(), 2);
	}
	
	@Test
	void setRegistroMuestraTest() {
		ArrayList<Muestra> muestras = new ArrayList<Muestra>();
		muestras.add(mock(Muestra.class));
		muestras.add(mock(Muestra.class));
		
		usuario.setMuestras(muestras);
		assertEquals(usuario.getMuestras().size(), 2);
	}
	
	
	// METODOS
	
	@Test 
	
	void cambiarEstadoUsuario() {
		
		usuario.setEstado(new EstadoExperto());
		
		
		assertTrue(usuario.getEstado() instanceof EstadoExperto);
		
	}
	
	@Test
	void agregarOpinionTest_SiendoLaPrimerOpinion() {
		//setup
		int opinionesAntes = usuario.cantidadDeOpiniones();
		
		//exercise
		usuario.agregarOpinion(unaOpinion);
		int opinionesDespues = usuario.cantidadDeOpiniones();
		
		//verify
		assertEquals(0, opinionesAntes);
		assertEquals(1, opinionesDespues);
	}
	
	
	
	void agregarMuestraTest_SiendoLaPrimerMuestra() {
		//setup
		int muestrasAntes = usuario.cantidadDeMuestras();
		
		//exercise
		usuario.agregarOpinion(unaOpinion);
		int muestrasDespues = usuario.cantidadDeMuestras();
		
		//verify
		assertEquals(0, muestrasAntes);
		assertEquals(1, muestrasDespues);
	}
	
//	void cuandoUnUsuarioBasicoLLegaADiezMuestrasYVeinteRevisionesEnLosUltimosTreintaDiasSuEstadoCambiaAExperto() {
//		//setup
//		boolean esExpertoAntes = usuario.esExperto();
//		
//		//exercise
//		for (int i = 0; i < 10; i++) {
//			usuario.agregarMuestra(unaMuestra);
//		}
//		for (int i = 0; i < 20; i++) {
//			usuario.agregarOpinion(unaOpinion);
//		}
//		boolean esExpertoDespues = usuario.esExperto();
//		
//		//verify
//		assertEquals(10, usuario.cantidadDeMuestras());
//		assertEquals(10, usuario.cantidadDeMuestrasAMenosDeTreintaDias());
//		assertEquals(20, usuario.cantidadDeOpiniones());
//		assertEquals(20, usuario.cantidadDeOpinionesAMenosDeTreintaDias());
//		assertEquals(false, esExpertoAntes);
//		assertEquals(true, esExpertoDespues);
//		verify(usuario.getEstado(), times(2)).esExperto();
//	}
	
	
	void testFechaDeMuestras() {
		
		
		usuario.agregarMuestra(mock(Muestra.class));
		usuario.agregarMuestra(mock(Muestra.class));
		usuario.agregarMuestra(mock(Muestra.class));
		
		ArrayList<Muestra> muestras = usuario.getMuestras();
		
		
        usuario.fechasDeMuestrasPublicadas(usuario.getMuestras());
		
        assertEquals(usuario.getMuestras().size(), 3);
        
        for (Muestra muestra : muestras) {
            verify(muestra, times(1)).getFecha();
        }
	
        
	}
	
	void testFechaDeOpiniones() {
		
		usuario.agregarOpinion(mock(Opinion.class));
		usuario.agregarOpinion(mock(Opinion.class));
		usuario.agregarOpinion(mock(Opinion.class));
		
		ArrayList<Opinion> opiniones = usuario.getOpiniones();
		
		usuario.fechasDeOpiniones(usuario.getOpiniones());
		
		assertEquals(usuario.getOpiniones().size(), 3);
		
		for (Opinion opinion : opiniones) {
            verify(opinion, times(1)).getFecha();
        }
		
	}
	
	
	
	

}
