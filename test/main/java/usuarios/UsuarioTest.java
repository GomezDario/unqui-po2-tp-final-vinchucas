package main.java.usuarios;


import main.java.Muestra.*;
import main.java.SitioWeb.*;
import main.java.Opinion.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



	


class UsuarioTest {

	Usuario user1;
	
	
	
	
	EstadoUsuario estado;
	Web web;
	
	@BeforeEach
	
	void setUp() {
		
		
		estado = mock(EstadoUsuario.class);
		web = mock(Web.class);
		
		
		user1 = new Usuario("Gabriel Gomez", web);
		user1.setEstadoUsuario(estado);
		

	}
	
	
	// TEST DE GETTERS
	
	

	@Test
	void getNombreTest() {
		assertEquals(user1.getNombre(), "Gabriel Gomez");
	}
	
	
	@Test
	void getSitioTest() {
		assertEquals(user1.getSitio(), web);
	}
	
	@Test
	void getEstadoTest() {
		assertEquals(user1.getEstadoUsuario(), estado);
	}
	
	@Test
	void getRegistroOpinionesTest() {
		assertEquals(user1.getOpiniones().size(), 0);
	}
	
	@Test
	void getRegistroMuestraTest() {
		assertEquals(user1.getMuestras().size(), 0);
	}
	
	//TEST DE SETTERS
	
	
	@Test
	void setNombreTest() {
		user1.setNombre("Gabi"); // Cambio de nombre
		assertEquals(user1.getNombre(), "Gabi");
	}
	
	
	@Test
	void setSitioTest() {
		Web vinchucaWeb = mock(Web.class);
		user1.setSitio(vinchucaWeb);
		assertEquals(user1.getSitio(), vinchucaWeb);
	}
	
	@Test
	void setTipoTest() {
		EstadoUsuario estadoUserNuevo = mock(EstadoUsuario.class);
		user1.setEstadoUsuario(estadoUserNuevo);
		assertEquals(user1.getEstadoUsuario(), estadoUserNuevo);
	}
	
	@Test
	void setRegistroOpinionesTest() {
		
		ArrayList<Opinion> opiniones = new ArrayList<Opinion>();
		opiniones.add(mock(Opinion.class));
		opiniones.add(mock(Opinion.class));
		
		user1.setOpiniones(opiniones);
		assertEquals(user1.getOpiniones().size(), 2);
	}
	
	@Test
	void setRegistroMuestraTest() {
		ArrayList<Muestra> muestras = new ArrayList<Muestra>();
		muestras.add(mock(Muestra.class));
		muestras.add(mock(Muestra.class));
		
		user1.setMuestras(muestras);
		assertEquals(user1.getMuestras().size(), 2);
	}
	
	
	// METODOS
	
	@Test 
	
	void cambiarEstadoUsuario() {
		
		user1.setEstadoUsuario(new EstadoExperto());
		
		
		assertTrue(user1.getEstadoUsuario() instanceof EstadoExperto);
		
	}
	
	@Test
	
	void agregarOpinionTest() {
		
		user1.agregarOpinion(mock(Opinion.class));
		user1.agregarOpinion(mock(Opinion.class));
		user1.agregarOpinion(mock(Opinion.class));
		
		assertEquals(user1.getOpiniones().size(), 3);
		
		verify(user1.getEstadoUsuario(), times(3)).updateUsuario(user1);
		
	}
	
	
	
	void agregarMuestraTest() {
		
		user1.agregarMuestra(mock(Muestra.class));
		user1.agregarMuestra(mock(Muestra.class));
		user1.agregarMuestra(mock(Muestra.class));
		
		
		assertEquals(user1.getMuestras().size(), 3);
		
		verify(user1.getEstadoUsuario(), times(3)).updateUsuario(user1);
		
		
	}
	
	
	void testFechaDeMuestras() {
		
		
		user1.agregarMuestra(mock(Muestra.class));
		user1.agregarMuestra(mock(Muestra.class));
		user1.agregarMuestra(mock(Muestra.class));
		
		ArrayList<Muestra> muestras = user1.getMuestras();
		
		
        ArrayList<LocalDateTime> result = user1.fechasDeMuestrasPublicadas(user1.getMuestras());
		
        assertEquals(user1.getMuestras().size(), 3);
        
        for (Muestra muestra : muestras) {
            verify(muestra, times(1)).getFecha();
        }
	
        
	}
	
	void testFechaDeOpiniones() {
		
		user1.agregarOpinion(mock(Opinion.class));
		user1.agregarOpinion(mock(Opinion.class));
		user1.agregarOpinion(mock(Opinion.class));
		
		ArrayList<Opinion> opiniones = user1.getOpiniones();
		
		ArrayList<LocalDateTime> result = user1.fechasDeOpiniones(user1.getOpiniones());
		
		assertEquals(user1.getOpiniones().size(), 3);
		
		for (Opinion opinion : opiniones) {
            verify(opinion, times(1)).getFecha();
        }
		
	}
	
	
	
	

}
