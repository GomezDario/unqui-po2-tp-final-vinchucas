package web.muestra;

import web.opinion.Opinion;
import web.opinion.TipoDeOpinion;
import web.ubicacion.Ubicacion;
import web.usuario.Usuario;

import static org.mockito.Mockito.when;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class MuestraTest 
{
	
	Muestra muestra;
	Usuario usuario;
	Usuario usuario2;
	MuestraEstado estado;
	Opinion opinion1;
	Opinion opinion2;
	Ubicacion ubicacion;
	
	
	public void setUp() throws Exception 
	{
		/*
		 mockea todas las clases que va a usar 
		 
		 */
		
		this.usuario = mock(Usuario.class);
		this.usuario2 = mock(Usuario.class);
		this.estado = mock(MuestraEstadoNoVerificada.class);
		this.opinion1 = mock(Opinion.class);
		this.opinion2 = mock(Opinion.class);
	
		this.ubicacion = mock(Ubicacion.class);
		
		muestra = new Muestra(ubicacion, "test.jpg", opinion1, usuario);
		
		
		
		
		
	}
	
	@Test
	public void verificacionDeUnaMuestra() throws Exception 
	{
		setUp();
		
		when(opinion1.getUsuario()).thenReturn(usuario);
		when(usuario.esExperto()).thenReturn(false);
	    when(opinion2.getUsuario()).thenReturn(usuario2);
	    when(usuario2.esExperto()).thenReturn(true);
	    

	    
	    
	    assert muestra.getEstado() instanceof MuestraEstadoNoVerificada;
		
	   

	    muestra.agregarOpinion(opinion2);

	    assert muestra.getEstado() instanceof MuestraEstadoVerificadaPorExperto;
	    
	    
	    
	}
	
	@Test
	public void exceptCuandoUnUsuarioNoPuedeOpinar() throws Exception 
	{
		
		setUp();
		
		
		
		when(usuario.esExperto()).thenReturn(true);
		when(opinion1.getUsuario()).thenReturn(usuario);
	    
	    when(usuario2.esExperto()).thenReturn(false);
	    when(opinion2.getUsuario()).thenReturn(usuario2);

	    muestra = new Muestra(ubicacion, "test.jpg", opinion1, usuario);
	    
	   

	    assert muestra.getEstado() instanceof MuestraEstadoVerificadaPorExperto;
	    
	   

	    
	    org.junit.jupiter.api.Assertions.assertThrows(Exception.class, () -> muestra.agregarOpinion(opinion2));

	    //assertThrows(Exception.class, () -> muestra.agregarOpinion(opinion2));
	 
	}
	
	@Test
	public void consultarIdentificacionFotoYUbicacion() throws Exception 
	{
		setUp();
		
		assertEquals(ubicacion, muestra.getUbicacion());
		assertEquals("test.jpg", muestra.getFoto());
		assertEquals(usuario, muestra.getUsuario());
		
	}
	
	@Test
	public void resultadoNoIdentificadoCuandoEmpate() throws Exception
	{
		setUp();
		
		when(opinion1.getTipoDeOpinion()).thenReturn(TipoDeOpinion.VINCHUCAINFESTANS);
		when(opinion1.getUsuario()).thenReturn(usuario);
		
		
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIA_CHINCHE);
		when(opinion2.getUsuario()).thenReturn(usuario2);
		muestra.agregarOpinion(opinion2);
		
		assertEquals(muestra.resultadoActual(), TipoDeOpinion.NODEFINIDO);
	}
	
	@Test
	public void muestraTomadaPorExpertoVerificadaDesdeInicio() throws Exception 
	{
		
		this.usuario = mock(Usuario.class);
		
		when(usuario.esExperto()).thenReturn(true);
		
		muestra = new Muestra(ubicacion, "test.jpg", opinion1, usuario);
		
		
		assert muestra.getEstado() instanceof MuestraEstadoVerificadaPorExperto;
	}
	
	
	
	
	
	

}
