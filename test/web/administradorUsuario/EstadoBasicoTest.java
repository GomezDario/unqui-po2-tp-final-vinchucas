package web.administradorUsuario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;

import web.extras.*;
import web.administradorMuestra.*;

class EstadoBasicoTest {

	    Usuario user;
	    Usuario user1;
	  
	 
	
	    EstadoBasico tipoBasico;
	    EstadoExperto tipoExperto;
	   
	
	@BeforeEach
	    
	void setUp() {
	        user = mock(Usuario.class);
	        
	        tipoBasico = new EstadoBasico();
	        tipoExperto = new EstadoExperto();
	        
	      
	        user1 = new Usuario("Gabriel Gomez");          

	    }
	
	
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
		    
		    user1.setOpiniones(opiniones);
		    user1.setMuestras(muestras);
		 	
		 
		 
		 
	        tipoBasico.updateUsuario(user1);
	        assertFalse(tipoBasico.puedeSerExperto(user1));
		 
		 
	 }
	 
	 
	 
	@Test 
	void actualizarUsuarioTest() {
		 
		
		// TEST DE UN USUARIO CON 21 OPINIONES, Y 11 MUESTRAS. CUMPLE CONDICION PARA SER EXPERTO
		
		    ArrayList<Opinion> opiniones = new ArrayList<>();
		    ArrayList<Muestra> muestras = new ArrayList<>();

		    // Simulo tene opiniones y muestras en el mes actual
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
		    
		    user1.setOpiniones(opiniones);
		    user1.setMuestras(muestras);
		    
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
	
		    

		    tipoBasico.updateUsuario(user1);
		    
		    assertTrue(tipoBasico.puedeSerExperto(user1));
		    assertTrue(user1.getEstadoUsuario() instanceof EstadoExperto);
	    	

		    
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
		    
		    user1.setOpiniones(opiniones);
		    user1.setMuestras(muestras);
		
		    
		    tipoBasico.updateUsuario(user1);
		    assertTrue(user1.getEstadoUsuario() instanceof EstadoBasico);
		    
		
		
	}
	
	
	
	
	

}
