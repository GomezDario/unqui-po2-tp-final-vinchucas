package web.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import web.muestra.Muestra;
import web.opinion.Opinion;

class EstadoBasicoTest {

	EstadoBasico estadoBasico;
    Usuario unUsuario;
    Usuario otroUsuario;
    EstadoExperto unEstadoExperto;
	
	@BeforeEach
	void setUp() {
		//doc
        unUsuario = new Usuario("unUsario");
        otroUsuario = new Usuario("otroUsuario");
        unEstadoExperto = mock(EstadoExperto.class);
        
        //sut
        estadoBasico = new EstadoBasico();    
	}
	
//	@Test
//	void updateUsuarioTest_CuandoCumple() {
//		//setup
//		when(unUsuario.cantidadDeMuestrasAMenosDeTreintaDias()).thenReturn(10);
//		when(unUsuario.cantidadDeOpinionesAMenosDeTreintaDias()).thenReturn(20);
//		
//		//exercise
//		estadoBasico.updateUsuario(unUsuario);
//		
//		//verify
//		verify(unUsuario, times(1)).setEstado(unEstadoExperto);
//	}
	
	@Test
	void usuarioBasicoNocumpleCondicionDeExpertoTest() {
		 // TEST DE UN USUARIO CON 8 OPINIONES, Y 5 MUESTRAS. NO CUMPLE CONDICION PARA SER EXPERTO
		 
		 ArrayList<Opinion> opiniones = new ArrayList<>();
		 ArrayList<Muestra> muestras = new ArrayList<>();

		 // Simulo tene opiniones y muestras en el mes actual
		 LocalDate fechaActual = LocalDate.now();
		    
	     for (int i = 0; i < 8; i++) {
	         Opinion opinion = mock(Opinion.class);
	         when(opinion.getFecha()).thenReturn(fechaActual);
	         opiniones.add(opinion);
	     }
	     
	     for (int i = 0; i < 5; i++) {
	         Muestra muestra = mock(Muestra.class);
	         when(muestra.getFecha()).thenReturn(fechaActual);
	         muestras.add(muestra);
	     }
	     
	     otroUsuario.setOpiniones(opiniones);
	     otroUsuario.setMuestras(muestras);
		 
         estadoBasico.updateUsuario(otroUsuario);
         assertFalse(estadoBasico.puedeSerExperto(otroUsuario));
		 
	 }
	 
	 
	 
	@Test 
	void actualizarUsuarioTest() {
		 
		
		// TEST DE UN USUARIO CON 21 OPINIONES, Y 11 MUESTRAS. CUMPLE CONDICION PARA SER EXPERTO
		
		    ArrayList<Opinion> opiniones = new ArrayList<>();
		    ArrayList<Muestra> muestras = new ArrayList<>();

		    // Simulo tener opiniones y muestras en el mes actual
		    LocalDate fechaActual = LocalDate.now();
		    
		    

		    for (int i = 0; i < 21; i++) {
		        Opinion opinion = mock(Opinion.class);
		        when(opinion.getFecha()).thenReturn(fechaActual);
		        opiniones.add(opinion);
		    }

		    for (int i = 0; i < 11; i++) {
		        Muestra muestra = mock(Muestra.class);
		        when(muestra.getFecha()).thenReturn(fechaActual);
		        muestras.add(muestra);
		    }
		    
		    otroUsuario.setOpiniones(opiniones);
		    otroUsuario.setMuestras(muestras);
		    
		    for (Opinion opinion : opiniones) {
		        LocalDate fechaOpinion = opinion.getFecha();
		        assertEquals(fechaActual.getMonth(), fechaOpinion.getMonth());
		        assertEquals(fechaActual.getYear(), fechaOpinion.getYear());
		    }
		    
		    
		    for (Muestra muestra : muestras) {
		        LocalDate fechaMuestra = muestra.getFecha();
		        assertEquals(fechaActual.getMonth(), fechaMuestra.getMonth());
		        assertEquals(fechaActual.getYear(), fechaMuestra.getYear());
		    }
	
		    

		    estadoBasico.updateUsuario(otroUsuario);
		    
		    assertTrue(estadoBasico.puedeSerExperto(otroUsuario));
		    assertTrue(otroUsuario.getEstado() instanceof EstadoExperto);
	    	

		    
	    } 
	
	@Test
	
	void usuarioBasicoNoCambiaSuEstadoAExpertoPorQueNoCumpleCondicion() {
		
		    ArrayList<Opinion> opiniones = new ArrayList<>();
		    ArrayList<Muestra> muestras = new ArrayList<>();

		    // Simulo tene opiniones y muestras en el mes actual
		    LocalDate fechaActual = LocalDate.now();
		    
		    

		    for (int i = 0; i < 5; i++) {
		        Opinion opinion = mock(Opinion.class);
		        when(opinion.getFecha()).thenReturn(fechaActual);
		        opiniones.add(opinion);
		    }

		    for (int i = 0; i < 4; i++) {
		        Muestra muestra = mock(Muestra.class);
		        when(muestra.getFecha()).thenReturn(fechaActual);
		        muestras.add(muestra);
		    }
		    
		    otroUsuario.setOpiniones(opiniones);
		    otroUsuario.setMuestras(muestras);
		
		    
		    estadoBasico.updateUsuario(otroUsuario);
		    assertTrue(otroUsuario.getEstado() instanceof EstadoBasico);
		    
		
		
	}
	
	
	
	
	

}
