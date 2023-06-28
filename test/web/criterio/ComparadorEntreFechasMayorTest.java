package web.criterio;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
class ComparadorEntreFechasMayorTest {

	private ComparadorEntreFechasMayor comparador;
	
    @BeforeEach
	
    void setUp() {
		
		comparador = new ComparadorEntreFechasMayor();
		 
	}
	
    @Test
	
    void testCompararEntre_FechaAMenorQueFechaB() {
		
		// Se compara la fechaA siendo menor Que la fechaB
		
        LocalDate fechaA = LocalDate.of(2023, 6, 10); // Fecha A (10 de junio de 2023)
        LocalDate fechaB = LocalDate.of(2023, 7, 10); // Fecha B (10 de julio de 2023)

        
        boolean resultado = comparador.compararEntre(fechaA, fechaB);

        assertTrue(resultado);
        
        
    }
    
    @Test
    
    void testCompararEntre_FechaAMayorQueFechaB() {
    	
    	// Se compara la fechaA siendo mayor que la fechaB, debe devolver falso.
    	
    	LocalDate fechaA = LocalDate.of(2023, 8, 10); // Fecha A (10 de agosto de 2023)
        LocalDate fechaB = LocalDate.of(2023, 6, 10); // Fecha B (10 de junio de 2023)
        
        
        
        boolean resultado = comparador.compararEntre(fechaA, fechaB);
        
        assertFalse(resultado);
    	
    	
    }
    
    
    @Test 
    
    void testComparaEntre_FechaAIGualAFechaB() {
    	
    	// Se compara la fechaA siendo igual a la fechaB, debe devolver falso. Ya que se usa el comparador entreFechasMayor().
    	
    	LocalDate fechaA = LocalDate.of(2023, 6, 10); // Fecha A (10 de junio de 2023)
        LocalDate fechaB = LocalDate.of(2023, 6, 10); // Fecha B (10 de junio de 2023)
        
        boolean resultado = comparador.compararEntre(fechaA, fechaB);
        
        assertFalse(resultado);
    	
    	
    }
    
    
	

}
