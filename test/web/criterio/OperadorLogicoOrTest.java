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
        muestra4 = mock(Muestra.class);
        muestra5 = mock(Muestra.class);
        muestra6 = mock(Muestra.class);
       
        
        listaMuestras1 = new ArrayList<Muestra>();
        listaMuestras1.add(muestra1);
        listaMuestras1.add(muestra2);
        listaMuestras1.add(muestra3);
        
        
        listaMuestras2 = new ArrayList<Muestra>();
        listaMuestras2.add(muestra4);
        listaMuestras2.add(muestra5);
        listaMuestras2.add(muestra6);
        
        
        operadorOr = new OperadorLogicoOr();
	
    }
	
    
    @Test
    
     void juntarArraysTestConOperador_OR() {
	 
	 ArrayList<Muestra> resultadoEsperado = new ArrayList<Muestra>();
	 
	 resultadoEsperado.add(muestra1);
	 resultadoEsperado.add(muestra2);
	 resultadoEsperado.add(muestra3);
	 resultadoEsperado.add(muestra4);
	 resultadoEsperado.add(muestra5);
	 resultadoEsperado.add(muestra6);
     

     assertEquals(operadorOr.juntarArrays(listaMuestras1,listaMuestras2),resultadoEsperado);

 }
    
    
    @Test
    void testAgregarSiNoEsta_CuandoMuestraNoEstaEnElLaLista_DeberiaAgregarla() {
    	

        
        ArrayList<Muestra> lista = new ArrayList<>();
        
        // Llamar al método agregarSiNoEsta
        operadorOr.agregarSiNoEsta(lista, muestra1);
        
        // Verificar que el mock se haya agregado a la lista
        assertEquals(1, lista.size());
        assertTrue(lista.contains(muestra1));
        
        
    }	
    
    
    @Test
    void testAgregarSiNoEsta_CuandoUnaMuestraYaEstaPresenteNoSeAgregarNuevamente() {
    	
    	
    	// Crear una lista
        List<Muestra> lista = new ArrayList<>();
        lista.add(muestra1); // Se agregar muestra1
        
        // Llamar al método agregarSiNoEsta
        operadorOr.agregarSiNoEsta(lista, muestra1); // No se deberia agregar
        
        // Verificar que el mock se haya agregado a la lista
        assertEquals(1, lista.size());
        assertTrue(lista.contains(muestra1));
    	
    	
    	
    	
    	
    	
    }
    	
    
    
    
    
    
    
    
    
}
