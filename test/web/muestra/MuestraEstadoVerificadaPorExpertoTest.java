package web.muestra;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import web.opinion.Opinion;
import web.opinion.TipoDeOpinion;
import web.ubicacion.Ubicacion;
import web.usuario.Usuario;






public class MuestraEstadoVerificadaPorExpertoTest 
{
	Muestra muestra;
	Usuario usuario;
	Usuario usuario2;
	Opinion opinion1;
	Opinion opinion2;
	Opinion opinion3;
	Ubicacion ubicacion;
	MuestraEstado estado;
	
	public void setUp() 
	{
		/*
		 mockea todas las clases que va a usar 
		 
		 */
		
		this.usuario = mock(Usuario.class);
		this.usuario2 = mock(Usuario.class);
		this.opinion1 = mock(Opinion.class);
		this.opinion2 = mock(Opinion.class);
		this.opinion3 = mock(Opinion.class);
		this.ubicacion = mock(Ubicacion.class);
		this.muestra = mock(Muestra.class);
		
		
		
		estado = new MuestraEstadoVerificadaPorExperto();
	}

	@Test
	public void devolverOpinionYEmpate() throws Exception 
	{
		
		
		when(muestra.getlistaDeOpiniones()).thenReturn(Arrays.asList(opinion2));  
		
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.IMAGENPOCOCLARA);  
		
		when(opinion2.getUsuario().esExperto()).thenReturn(true); 
	
		
		assertEquals(muestra.resultadoActual(), TipoDeOpinion.IMAGENPOCOCLARA);
		
		
		
		when(opinion1.getTipoDeOpinion()).thenReturn(TipoDeOpinion.VINCHUCAINFESTANS);  
		
		when(opinion1.getUsuario().esExperto()).thenReturn(true); 
		
		estado.agregarOpinion(opinion1, muestra);
		
		assertEquals(muestra.resultadoActual(), TipoDeOpinion.NODEFINIDO);
	}
	
	@Test
	public void intentarAgregarUnaOpinionNoValidadA() 
	{
		when(opinion1.getTipoDeOpinion()).thenReturn(TipoDeOpinion.VINCHUCAINFESTANS);  
		
		when(opinion1.getUsuario().esExperto()).thenReturn(false); 
		
		
		assertThrows(RuntimeException.class, () -> estado.agregarOpinion(opinion1, muestra));
	}
	
	
	
}


// verificar el throw exception, <>

// agregr opinion y cambie / empate

// que solo tome en cuenta las opiniones si son deexpertos