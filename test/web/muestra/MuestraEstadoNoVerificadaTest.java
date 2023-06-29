package web.muestra;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import web.opinion.Opinion;
import web.opinion.TipoDeOpinion;
import web.ubicacion.Ubicacion;
import web.usuario.Usuario;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Arrays;





public class MuestraEstadoNoVerificadaTest 
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
		
		
		
		estado = new MuestraEstadoNoVerificada();
	}

	@Test
	public void cambiosDeResultadosCorrectos() throws Exception
	{
		when(muestra.getlistaDeOpiniones()).thenReturn(Arrays.asList(opinion2));  
		
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.IMAGENPOCOCLARA);  
		
		when(opinion2.getUsuario().esExperto()).thenReturn(false); 
		
		assertEquals(muestra.resultadoActual(), TipoDeOpinion.IMAGENPOCOCLARA);
		
		
		
		when(opinion1.getTipoDeOpinion()).thenReturn(TipoDeOpinion.VINCHUCAINFESTANS);  
		
		when(opinion1.getUsuario().esExperto()).thenReturn(false); 
		
		estado.agregarOpinion(opinion1, muestra);
		
		assertEquals(muestra.resultadoActual(), TipoDeOpinion.NODEFINIDO);
		
		
		
		when(opinion1.getTipoDeOpinion()).thenReturn(TipoDeOpinion.VINCHUCAINFESTANS);  
		
		when(opinion3.getUsuario().esExperto()).thenReturn(false); 
		
		estado.agregarOpinion(opinion3, muestra);
		
		assertEquals(muestra.resultadoActual(), TipoDeOpinion.VINCHUCAINFESTANS);
		
		
	}
	
	@Test
	public void cambiarDeEstado() throws Exception
	{
		
		when(muestra.getlistaDeOpiniones()).thenReturn(Arrays.asList(opinion2));  
		
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.IMAGENPOCOCLARA);  
		
		when(opinion2.getUsuario().esExperto()).thenReturn(true); 
		
		estado.agregarOpinion(opinion2, muestra);
		
		verify(muestra).cambiarEstado(Mockito.any(MuestraEstadoVerificadaPorExperto.class));

	}
}
