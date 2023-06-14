package web.Criterio.*;
import web.Muestra.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CriterioTipoDeInsectoDetectadoTest {

	CriterioTipoDeInsectoDetectado criterioInsectoDetectado;
	
	TipoDeOpinion tipoDeInsecto;
    EstadoMuestra estadoMuestra;
	
    ArrayList<Muestra> muestras;
    Muestra muestra1;
    Muestra muestra2;
    Muestra muestra3;
    Muestra muestra4;
	
	
    @BeforeEach
    void setUp() {
    	
    	tipoDeInsecto = TipoDeOpinion.ChincheFoliada;
    	estadoMuestra = mock(EstadoMuestra.class);
    	
    	muestra1 =  mock(Muestra.class);
        muestra2 =  mock(Muestra.class);
        muestra3 =  mock(Muestra.class);
        muestra4 =  mock(Muestra.class);
    	
        muestras = new ArrayList<Muestra>();
        muestras.add(muestra1);
        muestras.add(muestra2);
        muestras.add(muestra3);
        muestras.add(muestra4);
    	
    	
        criterioInsectoDetectado = new CriterioTipoDeInsectoDetectado(tipoDeInsecto);
    	
    	
    	
    }
    
    
    @Test
    void busquedaDeUnaMuestraConUn_TipoDeInsecto_Especifico() {
    	
    	

        //Genero un tipo de opinion no querido
        TipoDeOpinion tipoDeInsectoNoQuerido = TipoDeOpinion.VinchucaGuasayana;

        //Establezco las respuestas del mock
        when(muestra1.resultadoActual()).thenReturn(tipoDeInsectoNoQuerido);
        when(muestra2.resultadoActual()).thenReturn(tipoDeInsecto);
        when(muestra3.resultadoActual()).thenReturn(tipoDeInsecto);
        when(muestra4.resultadoActual()).thenReturn(tipoDeInsectoNoQuerido);
        
        //Genero el resultado deseado para comparar
        List<Muestra> muestrasEsperadas = new ArrayList<Muestra>();
        muestrasEsperadas.add(muestra2);
        muestrasEsperadas.add(muestra3);

        assertEquals(muestrasEsperadas,criterioInsectoDetectado.buscarEn(muestras));
    	
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
	
}
