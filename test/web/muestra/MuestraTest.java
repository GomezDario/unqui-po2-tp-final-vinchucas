package web.muestra;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import web.opinion.Opinion;
import web.opinion.TipoDeOpinion;
import web.ubicacion.Ubicacion;
import web.usuario.Usuario;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
		
		muestra.agregarOpinion(opinion2);
		
		
		
	}
	
	public void verificacionDeUnaMuestra() throws Exception 
	{
		when(usuario.esExperto()).thenReturn(false);
	    when(opinion2.getUsuario()).thenReturn(usuario);

	    muestra.agregarOpinion(opinion2);
	    
	    assert muestra.getEstado() instanceof MuestraEstadoNoVerificada;
		
	    when(usuario.esExperto()).thenReturn(true);
	    when(opinion1.getUsuario()).thenReturn(usuario);

	    muestra.agregarOpinion(opinion1);

	    assert muestra.getEstado() instanceof MuestraEstadoVerificadaPorExperto;
	    
	    
	    
	}
	
	public void exceptCuandoUnUsuarioNoPuedeOpinar() throws Exception 
	{
		when(usuario.esExperto()).thenReturn(true);
	    when(opinion1.getUsuario()).thenReturn(usuario);

	    muestra.agregarOpinion(opinion1);

	    assert muestra.getEstado() instanceof MuestraEstadoVerificadaPorExperto;
	    
	    when(usuario.esExperto()).thenReturn(false);
	    when(opinion2.getUsuario()).thenReturn(usuario);

	    //assertThrows(Exception.class, () -> {muestra.agregarOpinion(opinion2);});
	    
	    
	    
	}
	
	
	public void consultarIdentificacionFotoYUbicacion() 
	{
		assertEquals(ubicacion, muestra.getUbicacion());
		assertEquals("test.jpg", muestra.getFoto());
		assertEquals(usuario, muestra.getUsuario());
		
	}
	
	public void resultadoNoIdentificadoCuandoEmpate() throws Exception
	{
		when(opinion1.getTipoDeOpinion()).thenReturn(TipoDeOpinion.VINCHUCAINFESTANS);
		muestra.agregarOpinion(opinion1);
		
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIA_CHINCHE);
		muestra.agregarOpinion(opinion2);
		
		assert muestra.resultadoActual() == TipoDeOpinion.NODEFINIDO;
	}
	
	
	public void muestraTomadaPorExpertoVerificadaDesdeInicio() 
	{
		when(usuario.esExperto()).thenReturn(true);
		
		assert muestra.getEstado()  instanceof MuestraEstadoVerificadaPorExperto;
	}
	
	
	
	
	
	

}
