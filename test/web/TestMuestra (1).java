
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

public class TestMuestra 
{

	private Usuario usuario = mock(Usuario.class);
	
	
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Usuario usuarioTest = Mockito.spy(new Usuario());
	}
	
	public void testUserAddOpinion()
	{
		when(usuario.añadirOpinion()).thenReturn(TipoDeOpinion VincuchGuasayana)
	}
	
	
	
	
	
	/*
	  
	 - agregar una opinion y que el estado de esta cambie
	 
	 - agregar una opinion de un usuario experto y que se bloquee para los demas usuarios
	 
	 - se debe poder consultar la identificacion de la persona que tomo la foto
	 
	 - tambien la foto, ubicaion
	 
	*/
	
}
