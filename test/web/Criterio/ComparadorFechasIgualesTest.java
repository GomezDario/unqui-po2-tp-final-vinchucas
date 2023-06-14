package web.Criterio.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertTrue;





class ComparadorFechasIgualesTest {

	ComparadorFechasIguales comparador;
	
	@BeforeEach
	
    void setUp() {
		
		comparador = new ComparadorFechasIguales();
		
	}
	
	@Test
	void testCompararFechasIguales() {
		
		// Se comparan 2 fechas iguales.
		
        LocalDateTime fechaA = LocalDateTime.of(2023, 6, 10, 10, 0); // Fecha A
        LocalDateTime fechaB = LocalDateTime.of(2023, 6, 10, 10, 0); // Fecha B

        boolean resultado = comparador.compararEntre(fechaA, fechaB);

        assertTrue(resultado);
        
        
    }
	
	
	@Test
	void testComparaFechasDiferentes() {
		
		// Se comparan 2 fechas diferentes.
		
		LocalDateTime fechaA = LocalDateTime.of(2023, 7, 10, 10, 0); // Fecha A
        LocalDateTime fechaB = LocalDateTime.of(2023, 6, 10, 10, 0); // Fecha B
        
        boolean resultado = comparador.compararEntre(fechaA, fechaB);
		
        assertFalse(resultado);  
	}
	
	
	
	

}
