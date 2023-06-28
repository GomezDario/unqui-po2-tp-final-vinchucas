package web.administradorMuestra;

import web.administradorUsuario.Usuario;
import web.extras.Opinion;
import web.extras.TipoDeOpinion;



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
		this.ubicacion = mock(Ubicacion);
		this.muestra = mock(Muestra.class);
		
		
		
		estado = new MuestraEstadoNoVerificada();
	}

	@Test
	private void cambiosDeResultadosCorrectos()
	{
		when(muestra.getlistaDeOpiniones()).thenReturn(ArrayList<Opinion>(opinion2));  
		
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.IMAGENPOCOCLARA);  
		
		when(opinion2.getUsuario().esExperto())).thenReturn(false); 
		
		assert(muestra.resultadoActual(), TipoDeOpinion.IMAGENPOCOCLARA)
		
		
		
		when(opinion1.getTipoDeOpinion()).thenReturn(TipoDeOpinion.VINCHUCAINFESTANS);  
		
		when(opinion1.getUsuario().esExperto())).thenReturn(false); 
		
		estado.agregarOpinion(opinion1, muestra);
		
		assert(muestra.resultadoActual(), TipoDeOpinion.NODEFINIDO);
		
		
		
		when(opinion1.getTipoDeOpinion()).thenReturn(TipoDeOpinion.VINCHUCAINFESTANS);  
		
		when(opinion3.getUsuario().esExperto()).thenReturn(false); 
		
		estado.agregarOpinion(opinion3, muestra);
		
		assert(muestra.resultadoActual(), TipoDeOpinion.VINCHUCAINFESTANS);
		
		
	}
	
	@Test
	private void cambiarDeEstado()
	{
		
		when(muestra.getlistaDeOpiniones()).thenReturn(ArrayList<Opinion>(opinion1));  
		
		when(opinion2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.IMAGENPOCOCLARA);  
		
		when(opinion2.getUsuario().esExperto()).thenReturn(true); 
		
		estado.estado.agregarOpinion(opinion2, muestra);
		
		verify(muestra).cambiarEstado(Mockito.any(MuestraEstadoVerificadaPorExperto.class)));

	}
}
