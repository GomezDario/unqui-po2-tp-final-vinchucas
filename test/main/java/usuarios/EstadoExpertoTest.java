package main.java.usuarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



import java.time.LocalDateTime;
import java.util.ArrayList;

import main.java.Muestra.*;
import main.java.SitioWeb.*;
import main.java.Opinion.*;

import org.junit.jupiter.api.BeforeEach;



class EstadoExpertoTest {

	    Usuario user;
	    Usuario user1;
	  
	 
	
	    EstadoBasico tipoBasico;
	    EstadoExperto tipoExperto;
	    Web web;
	   
	    @BeforeEach
	    
		void setUp() {
		        user = mock(Usuario.class);
		        web = mock(Web.class);
		        
		        tipoBasico = new EstadoBasico();
		        tipoExperto = new EstadoExperto();
		        
		      
		        user1 = new Usuario("Gabriel Gomez", web);
		        
		        when(user.getSitio()).thenReturn(web);
		        
		        
		        
		        

		    }
	    
	    @Test
	    
	    void usuarioExpertoCumpleCondicionDeSerExperto() {
	    	
	    	ArrayList<Opinion> opiniones = new ArrayList<>();
		    ArrayList<Muestra> muestras = new ArrayList<>();

		    // Simulo tene opiniones y muestras en el mes actual
		    LocalDateTime fechaActual = LocalDateTime.now();
		    
		    

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
		    
		    tipoExperto.updateUsuario(user1);
		    assertTrue(tipoExperto.puedeSerExperto(user1));
		    
		    
	    	
	    	
	    	
	    }
	    
	
	@Test
	
	void usuarioExpertoSeNoCumpleCondicionDeSerExperto() {
		
		ArrayList<Opinion> opiniones = new ArrayList<>();
	    ArrayList<Muestra> muestras = new ArrayList<>();

	    // Simulo tene opiniones y muestras en el mes actual
	    LocalDateTime fechaActual = LocalDateTime.now();
	    
	    

	    for (int i = 0; i < 5; i++) {
	        Opinion opinion = mock(Opinion.class);
	        when(opinion.getFecha()).thenReturn(fechaActual);
	        opiniones.add(opinion);
	    }

	    for (int i = 0; i < 2; i++) {
	        Muestra muestra = mock(Muestra.class);
	        when(muestra.getFecha()).thenReturn(fechaActual);
	        muestras.add(muestra);
	    }
	    
	    user1.setOpiniones(opiniones);
	    user1.setMuestras(muestras);
		
	    
	    assertFalse(tipoExperto.puedeSerExperto(user1));
		
		
	}
	
	
	@Test
	
	void usuarioExpertoCambiaSuEstadoABasicoAlNoCumplirCondicion() {
		
		
		ArrayList<Opinion> opiniones = new ArrayList<>();
	    ArrayList<Muestra> muestras = new ArrayList<>();

	    // Simulo tene opiniones y muestras en el mes actual
	    LocalDateTime fechaActual = LocalDateTime.now();
	    
	    

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
		
	    tipoExperto.updateUsuario(user1);
	   
	    assertTrue(user1.getEstadoUsuario() instanceof EstadoBasico);
	    
		
		
		
	}
	
	
	@Test
	
	void usuarioExpertoMantieneSuEstadoAlCumplirCondicion() {
		
		
		ArrayList<Opinion> opiniones = new ArrayList<>();
	    ArrayList<Muestra> muestras = new ArrayList<>();

	    // Simulo tene opiniones y muestras en el mes actual
	    LocalDateTime fechaActual = LocalDateTime.now();
	    
	    

	    for (int i = 0; i < 25; i++) {
	        Opinion opinion = mock(Opinion.class);
	        when(opinion.getFecha()).thenReturn(fechaActual);
	        opiniones.add(opinion);
	    }

	    for (int i = 0; i < 28; i++) {
	        Muestra muestra = mock(Muestra.class);
	        when(muestra.getFecha()).thenReturn(fechaActual);
	        muestras.add(muestra);
	    }
	    
	    user1.setOpiniones(opiniones);
	    user1.setMuestras(muestras);
		
	    tipoExperto.updateUsuario(user1);
	   
	    assertTrue(user1.getEstadoUsuario() instanceof EstadoExperto);
		
		
	}
	
	
	
}
