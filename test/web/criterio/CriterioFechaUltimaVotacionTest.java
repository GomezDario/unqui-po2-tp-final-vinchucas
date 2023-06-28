package web.criterio;
import web.muestra.*;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;



import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// Muestra deberia tener un metodo para saber la fecha de su ultima votacion

class CriterioFechaUltimaVotacionTest {
	
	CriterioFechaUltimaVotacion criterioFechaUltimaVotacion1;
	CriterioFechaUltimaVotacion criterioFechaUltimaVotacion2;
	CriterioFechaUltimaVotacion criterioFechaUltimaVotacion3;
	
	ComparadorFechas comparadorFechaMenor;
	ComparadorFechas comparadorFechasIguales;
	ComparadorFechas comparadorFechaMayor;
	
	LocalDate fecha;
    
	Muestra muestra1;
    Muestra muestra2;
    Muestra muestra3;
	
    ArrayList<Muestra> muestras;
    
     
    
    @BeforeEach
    void setUp() { 
    	
    	// Mockeo el comparador
    	comparadorFechaMenor = new ComparadorEntreFechasMenor();  	
    	comparadorFechasIguales = new ComparadorFechasIguales();
    	comparadorFechaMayor = new ComparadorEntreFechasMayor();
    	
    	fecha = LocalDate.of(2023, 6, 10);
    	
        muestras = new ArrayList<Muestra>();
        
        criterioFechaUltimaVotacion1 = new CriterioFechaUltimaVotacion(comparadorFechasIguales, fecha);
        criterioFechaUltimaVotacion2 = new CriterioFechaUltimaVotacion(comparadorFechaMenor, fecha);
        criterioFechaUltimaVotacion3 = new CriterioFechaUltimaVotacion(comparadorFechaMayor, fecha);
    	
    }
    
    @Test
    void buscarMuestrasConFechaDeUltimaVotacionIgualesALaDada() {
    	
    	
    	muestra1 = mock(Muestra.class);
        when(muestra1.getFechaUltimaVotacion()).thenReturn(fecha);
        muestras.add(muestra1);

        muestra2 = mock(Muestra.class);
        when(muestra2.getFechaUltimaVotacion()).thenReturn(fecha);
        muestras.add(muestra2);

        muestra3 = mock(Muestra.class);
        when(muestra3.getFechaUltimaVotacion()).thenReturn(fecha.plusDays(1)); 
        muestras.add(muestra3);
        
        List<Muestra> resultado = criterioFechaUltimaVotacion1.buscarEn(muestras);
    	
        assertEquals(2, resultado.size());
    	
    		
    	
    }
    
    @Test
    void buscarMuestrasConFechaDeUltimaVotacionMenorALaDada() {
    	
    	muestra1 = mock(Muestra.class);
        when(muestra1.getFechaUltimaVotacion()).thenReturn(fecha.minusDays(1));
        muestras.add(muestra1);

        muestra2 = mock(Muestra.class);
        when(muestra2.getFechaUltimaVotacion()).thenReturn(fecha);
        muestras.add(muestra2);

        muestra3 = mock(Muestra.class);
        when(muestra3.getFechaUltimaVotacion()).thenReturn(fecha.plusDays(1)); 
        muestras.add(muestra3);
        
        List<Muestra> resultado = criterioFechaUltimaVotacion2.buscarEn(muestras);
    	
        assertEquals(1, resultado.size());
    	
    	
    	
    	
    }
    
	@Test
	void buscarMuestrasConFechaUltimaVotacionMayorALaDada() {
		
		muestra1 = mock(Muestra.class);
        when(muestra1.getFechaUltimaVotacion()).thenReturn(fecha.plusDays(1));
        muestras.add(muestra1);

        muestra2 = mock(Muestra.class);
        when(muestra2.getFechaUltimaVotacion()).thenReturn(fecha);
        muestras.add(muestra2);

        muestra3 = mock(Muestra.class);
        when(muestra3.getFechaUltimaVotacion()).thenReturn(fecha.plusDays(1)); 
        muestras.add(muestra3);

        List<Muestra> resultado = criterioFechaUltimaVotacion2.buscarEn(muestras);
    	
        assertEquals(2, resultado.size());
    	
		
	}

    

}
