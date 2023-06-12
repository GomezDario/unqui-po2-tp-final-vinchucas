package administradorZona;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class OrganizacionNoGubernamentalTest {

	OrganizacionNoGubernamental organizacionNoGubernamental;
	ZonaDeCobertura unaZonaDeCobertura;
	Muestra unaMuestra;
	
	@Before
	public void setup() {
		//setup
		unaZonaDeCobertura = mock(ZonaDeCobertura.class);
		unaMuestra = mock(Muestra.class);
		
		//Test Double Installation
		organizacionNoGubernamental = new OrganizacionNoGubernamental(TipoDeOrganizacion.EDUCATIVA);
	}
	
	@Test
	public void agregarFuncionExternaParaNuevaMuestraTest() {
		
	}
	
	@Test
	public void funcionNuevaMuestraTest() {
		//setup
		
		
		//exercise
		organizacionNoGubernamental.funcionNuevaMuestra(unaZonaDeCobertura, unaMuestra);
		
		//verify
		
	}

}
