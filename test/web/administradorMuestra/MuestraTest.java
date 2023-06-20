
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import web.administradorUsuario.Usuario;
import web.extras.Opinion;
import web.extras.TipoDeOpinion;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

public class TestMuestra 
{
	
	Muestra muestra;
	Usuario usuario;
	Usuario usuario2;
	MuestraEstado estado;
	Opinion opinion1;
	Opinion opinion2;
	Ubicacion ubicacion;
	
	
	public void setUp() 
	{
		/*
		 mockea todas las clases que va a usar 
		 
		 */
		
		this.usuario = mock(Usuario.class);
		this.usuario2 = mock(Usuario.class);
		this.estado = mock(MuestraEstadoNoVerificado.class);
		this.opinion1 = mock(Opinion.class);
		this.opinion2 = mock(Opinion.class);
		this.ubicacion = mock(Ubicacion);
		
		muestra = new Muestra(ubicacion, "test.jpg", ArrayList<Opinion>(opinion1, opinion2), estado, usuario);
		
	}
	
	public void verificacionDeUnaMuestra() 
	{
		when(usuario.esExperto()).thenReturn(false);
	    when(opinion2.getUsuario()).thenReturn(usuario);

	    muestra.agregarOpinion(opinion2, muestra);
	    
	    assert muestra.getEstado() instanceof MuestraEstadoNoVerificada;
		
	    when(usuario.esExperto()).thenReturn(true);
	    when(opinion1.getUsuario()).thenReturn(usuario);

	    muestra.agregarOpinion(opinion1, muestra);

	    assert muestra.getEstado() instanceof MuestraEstadoVerificadaPorExperto;
	    
	    
	    
	}
	
	public void exceptCuandoUnUsuarioNoPuedeOpinar() 
	{
		when(usuario.esExperto()).thenReturn(true);
	    when(opinion1.getUsuario()).thenReturn(usuario);

	    muestra.agregarOpinion(opinion1, muestra);

	    assert muestra.getEstado() instanceof MuestraEstadoVerificadaPorExperto;
	    
	    when(usuario.esExperto()).thenReturn(false);
	    when(opinion2.getUsuario()).thenReturn(usuario);

	    assertThrows(Exception.class, () -> {muestra.agregarOpinion(opinion2, muestra)});
	    
	    
	    
	}
	
	
	public void consultarIdentificacionFotoYUbicacion() 
	{
		assertEquals(ubicacion, muestra.getUbicacion());
		assertEquals("test.jpg", muestra.getFoto());
		assertEquals(usuario, muestra.getUsuario());
		
	}
	
	public void resultadoNoIdentificadoCuandoEmpate()
	{
		when(opinion1.getTipoDeOpinion()).thenReturn(TipoDeOpinion.VINCHUCAINFESTANS);
		muestra.agregarOpinion(opinion1, muestra);
		
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.PHTIA_CHINCHE);
		muestra.agregarOpinion(opinion2, muestra);
		
		assert muestra.resultadoActual() == TipoDeOpinion.NODEFINIDO;
	}
	
	
	public void muestraTomadaPorExpertoVerificadaDesdeInicio() 
	{
		when(usuario.esExperto()).thenReturn(true);
		
		assert muestra.getEstado()  instanceof MuestraEstadoVerificadaPorExperto;
	}
	
	
	
	
	
	
	/*
	  
	 - agregar una opinion y que el estado de esta cambie HECHO 
	 
	 - agregar una opinion de un usuario experto y que se bloquee para los demas usuarios HECHO
	 
	 - se debe poder consultar la identificacion de la persona que tomo la foto HECHO
	 
	 - tambien la foto, ubicaion HECHO
	 
	 - si hay un empate tiene que devolver la opcion de no identificada   HECHO 
	 
	 - 
	 
	*/
	
}
