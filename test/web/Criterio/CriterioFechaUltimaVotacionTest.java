package web.Criterio.*;
import web.Muestra.*;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;



import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CriterioFechaUltimaVotacionTest {
	
	CriterioFechaUltimaVotacion criterioFechaUltimaVotacion;
	ComparadorFechas comparador;
	
	LocalDateTime fecha;
    
	Muestra muestra1;
    Muestra muestra2;
    Muestra muestra3;
	
    ArrayList<Muestra> muestras;
    
    
    
    @BeforeEach
    void setUp() {
    	
    	// Mockeo el comparador
    	comparador = mock(ComparadorFechas.class);    	
    	
    	fecha = LocalDateTime.of(2023, 6, 10, 10, 0);
    	
        muestras = new ArrayList<Muestra>();
        
        criterioFechaUltimaVotacion = new CriterioFechaUltimaVotacion(comparador, fecha);

    	
    }
	
    @Test
    
    void buscarEn_DebeRetornarListaFiltradaCorrecta() {
    	
        muestra1 = mock(Muestra.class);
        when(muestra1.getFechaUltimaVotacion()).thenReturn(fecha.minusDays(1));
        muestras.add(muestra1);

        muestra2 = mock(Muestra.class);
        when(muestra2.getFechaUltimaVotacion()).thenReturn(fecha);
        muestras.add(muestra2);

        muestra3 = mock(Muestra.class);
        when(muestra3.getFechaUltimaVotacion()).thenReturn(fecha.plusDays(1));
        muestras.add(muestra3);

        when(comparador.compararEntre((fecha.minusDays(1)),fecha))
                .thenReturn(true); // Muestra 1 cumple el criterio

        when(comparador.compararEntre(fecha, fecha))
                .thenReturn(true); // Muestra 2 cumple el criterio

        
        List<Muestra> resultado = criterioFechaUltimaVotacion.buscarEn(muestras);
    	
    	
    	
        assertEquals(2, resultado.size());
    	
    	
    	
    }
    

}
