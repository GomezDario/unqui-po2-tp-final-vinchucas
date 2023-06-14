package web.extras;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UbicacionTest {

	Ubicacion ubicacion;
	Ubicacion unaUbicacion;
	Ubicacion otraUbicacion;
	
	@Before
	public void setUp() {
		//setup
		unaUbicacion = mock(Ubicacion.class);
		otraUbicacion = mock(Ubicacion.class);
		
		//test double installation
		ubicacion = new Ubicacion(5000.0, 3000.0);
	}
	
	@Test
	public void cuandoUnaUbicacionSeCreaEsConUnaLatitudYLongitudTest() {
		//verify
		assertEquals(5000.0, ubicacion.getLatitud());
		assertEquals(3000.0, ubicacion.getLongitud());
	}

	@Test
	public void distanciaEntreTest() {
		//setup
		when(unaUbicacion.getLatitud()).thenReturn(5000.0);
		when(unaUbicacion.getLongitud()).thenReturn(3000.0);
		
		//exercise
		double distancia = ubicacion.distanciaEntre(unaUbicacion);
		
		//verify
		assertEquals(0, distancia);
	}
	
	public void ubicacionesAMenosDeTest() {
		//setup
		when(unaUbicacion.getLatitud()).thenReturn(5000.0);
		when(unaUbicacion.getLongitud()).thenReturn(3000.0);
		when(otraUbicacion.getLatitud()).thenReturn(6000.0);
		when(otraUbicacion.getLongitud()).thenReturn(8000.0);
		List<Ubicacion> ubicacionesAEvaluar = new ArrayList<>(Arrays.asList(unaUbicacion, otraUbicacion));
		
		//exercise
		List<Ubicacion> ubicaciones = ubicacion.ubicacionesAMenosDe(10, ubicacionesAEvaluar);
		
		//verify
		assertEquals(1, ubicaciones.size());
	}
}
