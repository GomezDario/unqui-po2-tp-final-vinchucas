package web.criterio;

import java.time.LocalDate;

public class ComparadorFechasIguales implements ComparadorFechas {

	
	public boolean compararEntre(LocalDate fechaA, LocalDate fechaB) {
		
		return fechaA.equals(fechaB);
		
	}  
	
}
