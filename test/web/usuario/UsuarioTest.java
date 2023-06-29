package web.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import web.muestra.Muestra;
import web.opinion.Opinion;

class UsuarioTest {

	Usuario usuario;
	EstadoUsuario estado;
	Opinion unaOpinion;
	Muestra unaMuestra;
	
	@BeforeEach
	void setUp() {
		//setup
		estado =  new EstadoBasico();
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
	
	@Test
	void getEstadoTest() {
		assertTrue(usuario.getEstado() instanceof EstadoBasico);
	}
	
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
	void agregarOpinionTest_SiendoLaPrimerOpinion(){
		// Crear una muestra mock
        Opinion opinionMock = mock(Opinion.class);

        // Agregar la muestra mock al usuario
        usuario.agregarOpinion(opinionMock);

        // Verificar que la muestra se agregó correctamente a la lista de muestras del usuario
        ArrayList<Opinion> opiniones = usuario.getOpiniones();
        assertEquals(1, opiniones.size());
        assertTrue(opiniones.contains(opinionMock));
        
	}
	
	@Test
	void agregarMuestraTest_SiendoLaPrimerMuestra() {
	
        // Crear una muestra mock
        Muestra muestraMock = mock(Muestra.class);

        // Agregar la muestra mock al usuario
        usuario.agregarMuestra(muestraMock);

        // Verificar que la muestra se agregó correctamente a la lista de muestras del usuario
        ArrayList<Muestra> muestras = usuario.getMuestras();
        assertEquals(1, muestras.size());
        assertTrue(muestras.contains(muestraMock));

	}

	
	@Test
	void testFechaDeOpiniones() {
		
		Opinion opinion1 = mock(Opinion.class);
        Opinion opinion2 = mock(Opinion.class);
        ArrayList<Opinion> opiniones = new ArrayList<Opinion>();
        
        opiniones.add(opinion1);
        opiniones.add(opinion2);
        
        LocalDate fecha1 = LocalDate.of(2023, 6, 28);
        LocalDate fecha2 = LocalDate.of(2023, 6, 29);
        when(opinion1.getFecha()).thenReturn(fecha1);
        when(opinion2.getFecha()).thenReturn(fecha2);
        
        ArrayList<LocalDate> fechas = usuario.fechasDeOpiniones(opiniones);

        ArrayList<LocalDate> fechasEsperadas = new ArrayList<LocalDate>();
        fechasEsperadas.add(fecha1);
        fechasEsperadas.add(fecha2);
        
        assertEquals(fechasEsperadas, fechas);
		
	}
	
	
	@Test
	void testFechaDeMuestras() {
		
		
		Muestra muestra1 = mock(Muestra.class);
        Muestra muestra2 = mock(Muestra.class);
        ArrayList<Muestra> muestras = new ArrayList<Muestra>();
        
        muestras.add(muestra1);
        muestras.add(muestra2);
        
        LocalDate fecha1 = LocalDate.of(2023, 6, 28);
        LocalDate fecha2 = LocalDate.of(2023, 6, 29);
        when(muestra1.getFecha()).thenReturn(fecha1);
        when(muestra2.getFecha()).thenReturn(fecha2);
        
        ArrayList<LocalDate> fechas = usuario.fechasDeMuestrasPublicadas(muestras);

        ArrayList<LocalDate> fechasEsperadas = new ArrayList<LocalDate>();
        fechasEsperadas.add(fecha1);
        fechasEsperadas.add(fecha2);
        
        assertEquals(fechasEsperadas, fechas);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
