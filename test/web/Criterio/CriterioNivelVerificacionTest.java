package web.Criterio.*;
import web.Muestra.*;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;




class CriterioNivelVerificacionTest {

	
	CriterioNivelVerificacion criterioNivelDeVerificacion;
	
	TipoDeOpinion tipoDeOpinion;
    EstadoMuestra estadoMuestra;
    
    ArrayList<Muestra> muestras;
    Muestra muestra1;
    Muestra muestra2;
    Muestra muestra3;
    Muestra muestra4;
    
	
    @BeforeEach
    void setUp() {
    	
    	
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
        
        
        criterioNivelDeVerificacion = new CriterioNivelVerificacion(estadoMuestra);
    	
    }
	
	@Test
	
	void busquedaDeUnaMuestraConUnNivelDeVerificacionEspecifico() {
		
		

        //Genero un estado que no es el deseado.
        EstadoMuestra estadoMuestraNoQuerido = mock(EstadoMuestra.class);

        //Establezco la respuesta del mock.
        when(muestra1.getEstado()).thenReturn(estadoMuestraNoQuerido);
        when(muestra2.getEstado()).thenReturn(estadoMuestra);
        when(muestra3.getEstado()).thenReturn(estadoMuestra);
        when(muestra4.getEstado()).thenReturn(estadoMuestraNoQuerido);
        
        //Genero el resultado deseado para comparar.
        List<Muestra> muestrasEsperadas = new ArrayList<Muestra>();
        muestrasEsperadas.add(muestra2);
        muestrasEsperadas.add(muestra3);
        

        assertEquals(muestrasEsperadas,criterioNivelDeVerificacion.buscarEn(muestras));
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
