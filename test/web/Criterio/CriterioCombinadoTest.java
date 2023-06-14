package web.Criterio.*;

import web.Muestra.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;


import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


class CriterioCombinadoTest {

	CriterioCombinado criterioCombinado;
	
	ArrayList<Muestra> muestras;
	
	LocalDateTime fecha;
	
	Criterio c1;
    Criterio c2;
    
    Muestra muestra1;
    Muestra muestra2;
	
    TipoDeOpinion tipoDeOpinion;
    EstadoMuestra estadoMuestra;
    
    OperadorLogico operadorLogico;
    
   
    @BeforeEach
    
    void setUp() {
    	
    	tipoDeOpinion = TipoDeOpinion.ChincheFoliada;
    	estadoMuestra = mock(EstadoMuestra.class);
    	
    	fecha = LocalDateTime.of(2023, 8, 10, 10, 0); // (10 de agosto de 2023)
    	
    	muestras = new ArrayList<Muestra>();
    	
    	muestra1 =  mock(Muestra.class);
        muestra2 =  mock(Muestra.class);
        
        c1 =  mock(Criterio.class);
        c2 =  mock(Criterio.class);
        
        operadorLogico = mock(OperadorLogico.class);
        
        muestras.add(muestra1);
        muestras.add(muestra2);
        
        criterioCombinado = new CriterioCombinado(operadorLogico,c1,c2);
    		
    	
    }
     
    
    @Test
    void getConector() {
    	
        assertEquals(operadorLogico,criterioCombinado.getOperador());
        
    }
    
    
    @Test
    void busquedaConCriterioCombinado() {
    	
    	criterioCombinado.buscarEn(muestras);
        //Verificar que a ambos criterios les llega.
        verify(c1).buscarEn(muestras);
        verify(c2).buscarEn(muestras);

        
        List<Muestra> resultadoc1 = new ArrayList<>();
        when(c1.buscarEn(muestras)).thenReturn(resultadoc1);

        List<Muestra> resultadoc2 = new ArrayList<>();
        when(c2.buscarEn(muestras)).thenReturn(resultadoc2);

        verify(operadorLogico).juntarArrays(resultadoc1, resultadoc2);

        //Creo un resultado con el cual comparar
        List<Muestra> resultado = new ArrayList<>();
        when(operadorLogico.juntarArrays(resultadoc1,resultadoc2)).thenReturn(resultado);

        
        assertEquals(resultado,criterioCombinado.buscarEn(muestras));
        
        
    }
    
	

}
