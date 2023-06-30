package web.criterio;

import java.time.LocalDate;

public class ComparadorEntreFechasMenor implements ComparadorFechas {

	public boolean compararEntre(LocalDate fechaA, LocalDate fechaB) {
		
		return fechaA.isAfter(fechaB);
		 
	}
	
	
}
