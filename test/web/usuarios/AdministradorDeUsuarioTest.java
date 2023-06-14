package web.usuarios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import web.*;
import web.Muestra.*;
import web.Opinion.*;
import web.usuarios.AdministradorDeUsuario;
import web.usuarios.Usuario;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;


class AdministradorDeUsuarioTest {

	Usuario user1;
	Usuario user2;
	Usuario user3;
	Usuario user4;
	Usuario user5;
	
	Web web;
	
	
@BeforeEach
	
	void setUp() {
	
	web = mock(Web.class);
	
	user1 = new Usuario("Gabriel Gomez", web);
	user2 = new Usuario("Juan Martínez", web);
	user3 = new Usuario("Alejandro Fernández", web);
	user4 = new Usuario("Guillermo González", web);
	user5 = new Usuario("Esteban López", web);
	

	
	
}


	@Test
	void testCantidadDeUsuarios() {
    
	AdministradorDeUsuario administrador = new AdministradorDeUsuario();

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
		AdministradorDeUsuario administrador = new AdministradorDeUsuario();

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
