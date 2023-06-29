package web.criterio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import java.time.LocalDate;

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
		
        LocalDate fechaA = LocalDate.of(2023, 6, 10); // Fecha A
        LocalDate fechaB = LocalDate.of(2023, 6, 10); // Fecha B

        boolean resultado = comparador.compararEntre(fechaA, fechaB);

        assertTrue(resultado);
        
        
    }
	
	
	@Test
	void testComparaFechasDiferentes() {
		
		// Se comparan 2 fechas diferentes.
		
		LocalDate fechaA = LocalDate.of(2023, 7, 10); // Fecha A
        LocalDate fechaB = LocalDate.of(2023, 6, 10); // Fecha B
        
        boolean resultado = comparador.compararEntre(fechaA, fechaB);
		
        assertFalse(resultado);  
	}
	
	
	
	

}
