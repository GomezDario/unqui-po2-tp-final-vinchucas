package web.administradorZona;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import web.administradorMuestra.Muestra;

public class OrganizacionNoGubernamentalTest {

	OrganizacionNoGubernamental organizacionNoGubernamental;
	ZonaDeCobertura unaZonaDeCobertura;
	Muestra unaMuestra;
	FuncionExterna unaFuncionNuevaMuestra;
	FuncionExterna unaFuncionValidacionMuestra;
	
	@Before
	public void setUp() {
		//setup
		unaZonaDeCobertura = mock(ZonaDeCobertura.class);
		unaMuestra = mock(Muestra.class);
		unaFuncionNuevaMuestra = mock(FuncionDeImpresion.class);
		unaFuncionValidacionMuestra = mock(FuncionDeImpresion.class);
		
		//Test Double Installation
		organizacionNoGubernamental = new OrganizacionNoGubernamental(TipoDeOrganizacion.EDUCATIVA, unaFuncionNuevaMuestra, unaFuncionValidacionMuestra);
	}
	
	@Test
	public void funcionNuevaMuestraTest() {
		//exercise
		organizacionNoGubernamental.funcionNuevaMuestra(unaZonaDeCobertura, unaMuestra);
		
		//verify
		verify(unaFuncionNuevaMuestra, times(1)).nuevoEvento(unaZonaDeCobertura, unaMuestra, organizacionNoGubernamental);
		verify(unaFuncionValidacionMuestra, times(0)).nuevoEvento(unaZonaDeCobertura, unaMuestra, organizacionNoGubernamental);
	}
	
	@Test
	public void funcionValidacionMuestraTest() {
		//exercise
		organizacionNoGubernamental.funcionValidacionMuestra(unaZonaDeCobertura, unaMuestra);
		
		//verify
		verify(unaFuncionNuevaMuestra, times(0)).nuevoEvento(unaZonaDeCobertura, unaMuestra, organizacionNoGubernamental);
		verify(unaFuncionValidacionMuestra, times(1)).nuevoEvento(unaZonaDeCobertura, unaMuestra, organizacionNoGubernamental);
	}

}
