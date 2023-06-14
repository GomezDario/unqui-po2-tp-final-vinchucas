package web.Criterio.*;
import web.Muestra.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;


import static org.mockito.Mockito.mock;


class OperadorLogicoAndTest {

	OperadorLogicoAnd operadorAnd;
	
	
    Muestra muestra1;
    Muestra muestra2;
    Muestra muestra3;
    Muestra muestra4;
    Muestra muestra5;
    Muestra muestra6;
    
    ArrayList<Muestra> muestras1;
    ArrayList<Muestra> muestras2;
	
	
    @BeforeEach
    void setUp() {
    	
    	
    	
        muestra1 = mock(Muestra.class);
        muestra2 = mock(Muestra.class);
        muestra3 = mock(Muestra.class);
        muestra4 = mock(Muestra.class);
        muestra5 = mock(Muestra.class);
        muestra6 = mock(Muestra.class);
        
        muestras1 = new ArrayList<Muestra>();
        muestras1.add(muestra1);
        muestras1.add(muestra2);
        muestras1.add(muestra3); // Muestra3
        
        muestras2 = new ArrayList<Muestra>();
        muestras2.add(muestra3); // Muestra3
        muestras2.add(muestra4);
        muestras2.add(muestra5);
        muestras2.add(muestra6);
        
        operadorAnd = new OperadorLogicoAnd();
       

    }
    
    
    @Test
    
    void juntarArraysTestConOperador_AND() {
    	
    	// Genero un resultado con el que comparar.
    	ArrayList<Muestra> resultadoEsperado = new ArrayList<Muestra>();
    	resultadoEsperado.add(muestra3);
         
         
        assertEquals(operadorAnd.juntarArrays(muestras1,muestras2),resultadoEsperado);
    	
	
    }
	
	
	
	

}
