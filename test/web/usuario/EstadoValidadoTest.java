package web.usuario;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import web.muestra.Muestra;
import web.opinion.Opinion;

class EstadoValidadoTest {

	Usuario user;
    Usuario user1;
  
  

    EstadoBasico tipoBasico;
    EstadoExperto tipoExperto;
    EstadoValidado tipoValidado;
   
    @BeforeEach
    
	void setUp() {
	        user = mock(Usuario.class);
	        
	        tipoBasico = new EstadoBasico();
	        tipoExperto = new EstadoExperto();
	        tipoValidado = new EstadoValidado();
	        
	      
	        user1 = new Usuario("Gabriel Gomez");

	    }
    
    
   
	@Test
	
	
	void usuarioValidadoMantieneSuEstado() {
		
		// Mantiene su estado sin cambiar. Sin importar la cantidad de Muestras publicadas u opiniones realizadas.
		
		ArrayList<Opinion> opiniones = new ArrayList<>();
	    ArrayList<Muestra> muestras = new ArrayList<>();

	    
	    LocalDate fechaActual = LocalDate.now();
	    
	    

	    for (int i = 0; i < 8; i++) {
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
	    
	    
	    tipoValidado.nivelarUsuario(user1);
	    
	    assertTrue(user1.getEstado() instanceof EstadoValidado);
		
		
	}
	
	@Test
	
	void unUsuarioValidadoEsUnTipoDeExperto() {
		
		tipoValidado.nivelarUsuario(user1);
		assertTrue(user1.esExperto());
		
	}
	
	
	

}
