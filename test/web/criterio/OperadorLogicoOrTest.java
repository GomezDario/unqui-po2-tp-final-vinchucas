package web.criterio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import web.muestra.*;

import org.junit.jupiter.api.BeforeEach;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

 

class OperadorLogicoOrTest {

	
	OperadorLogicoOr operadorOr;
	
	
    Muestra muestra1;
    Muestra muestra2; 
    Muestra muestra3;
    Muestra muestra4;
    Muestra muestra5;
    Muestra muestra6;
    
    
    ArrayList<Muestra> listaMuestras1;
    ArrayList<Muestra> listaMuestras2;
    
    @BeforeEach
    void setUp() {	
        muestra1 = mock(Muestra.class);
        muestra2 = mock(Muestra.class);
        muestra3 = mock(Muestra.class);
        
        listaMuestras1 = new ArrayList<Muestra>();
        listaMuestras1.add(muestra1);
        listaMuestras1.add(muestra1);
        
        
        listaMuestras2 = new ArrayList<Muestra>();
        listaMuestras2.add(muestra2);
        listaMuestras2.add(muestra2);
        listaMuestras2.add(muestra3);
        
        operadorOr = new OperadorLogicoOr();
	
    }
	
    @Test
    void juntarArraysTestConOperador_OR() {
		List<Muestra> resultado = operadorOr.juntarArrays(listaMuestras1, listaMuestras2);
	     
	    assertEquals(3, resultado.size());
	    assertTrue(resultado.contains(muestra1));
	    assertTrue(resultado.contains(muestra2));
	    assertTrue(resultado.contains(muestra3));
    }
}
