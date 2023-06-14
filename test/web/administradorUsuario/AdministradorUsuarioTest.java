package web.administradorUsuario;

import web.extras.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class AdministradorUsuarioTest {

	Usuario user1;
	Usuario user2;
	Usuario user3;
	Usuario user4;
	Usuario user5;
	
	
@BeforeEach
	
	void setUp() {
	
	user1 = new Usuario("Gabriel Gomez");
	user2 = new Usuario("Juan Martínez");
	user3 = new Usuario("Alejandro Fernández");
	user4 = new Usuario("Guillermo González");
	user5 = new Usuario("Esteban López");
	

	
	
}


	@Test
	void testCantidadDeUsuarios() {
    
	AdministradorUsuario administrador = new AdministradorUsuario();

    administrador.agregarUsuario(user1);
    administrador.agregarUsuario(user2);
    administrador.agregarUsuario(user3);
    administrador.agregarUsuario(user4);
    administrador.agregarUsuario(user5);
    

    int cantidadUsuarios = administrador.cantidadDeUsuarios();

    assertEquals(5, cantidadUsuarios);
	
	
	}


	@Test
	void testAgregarOpinion() {
		AdministradorUsuario administrador = new AdministradorUsuario();

		Opinion opinion = mock(Opinion.class);

		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		administrador.agregarUsuario(user1);
		administrador.agregarUsuario(user2);
		administrador.agregarUsuario(user3);

		administrador.agregarOpinion(opinion);

		for (Usuario usuario : usuarios) {
    	
			assertTrue(usuario.getOpiniones().contains(opinion));
        
		}

		
	}
	
	
	
}
