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




class CriterioFechaCreacionTest {

	CriterioFechaCreacion criterioFechaCreacion;
	ComparadorFechas comparador;
    
    ArrayList<Muestra> muestras;
    
    
    
    
    LocalDateTime fecha1;
    LocalDateTime fecha2;
    
    @BeforeEach
    
    void setUp() {
    	
    	comparador = mock(ComparadorFechas.class);
    	
    	
        fecha1 = LocalDateTime.of(2023, 8, 10, 10, 0);
    	
        muestras = new ArrayList<Muestra>();
    	
        criterioFechaCreacion = new CriterioFechaCreacion(comparador, fecha1);
        
        
        
    }
    
    @Test
    public void buscarEn_DebeFiltrarMuestrasSegunComparador() {
    	
       
        Muestra muestra1 = mock(Muestra.class);
        when(muestra1.getFecha()).thenReturn(fecha1.minusDays(1));
        muestras.add(muestra1);

        Muestra muestra2 = mock(Muestra.class);
        when(muestra2.getFecha()).thenReturn(fecha1);
        muestras.add(muestra2);

        Muestra muestra3 = mock(Muestra.class);
        when(muestra3.getFecha()).thenReturn(fecha1.plusDays(1));
        muestras.add(muestra3);

        when(comparador.compararEntre((fecha1.minusDays(1)),fecha1))
                .thenReturn(true); // Muestra 1 cumple el criterio

        when(comparador.compararEntre(fecha1, fecha1))
                .thenReturn(true); // Muestra 2 cumple el criterio

        

        List<Muestra> resultado = criterioFechaCreacion.buscarEn(muestras);

        
        /**
         * Se agregaron las 3 muestras en la lista
         * Pero solo 2 cumplieron con la condicion
         * Por lo que el size() a resultado se espera que sea 2.
         * */
        
        assertEquals(2, resultado.size()); 
    }
    
    
    
    
    
    
    
    
    
    
    
    /*void realizarBusqueda() {
        //Armo el resultado
        List<Muestra> muestrasEsperadas = new ArrayList<Muestra>();
        muestrasEsperadas.add(muestra1);

        //Caso no querido
        EstadoMuestra tipoDeMuestraNoQuerido = mock(EstadoMuestra.class);

        //Respuestas del mock
        when(muestra1.getFecha()).thenReturn(fecha1);
        when(muestra2.getFecha()).thenReturn(fecha2);
        
        when(comparador.compararEntre(fecha1, fecha2)).thenReturn(true);

        assertEquals(muestrasEsperadas, criterioFechaCreacion.buscarEn(muestras));
    }*/

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	

}
