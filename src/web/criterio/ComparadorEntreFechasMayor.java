package web.criterio;

import java.time.LocalDate;

public class ComparadorEntreFechasMayor implements ComparadorFechas{

	public boolean compararEntre(LocalDate fechaA, LocalDate fechaB) {
		
		return fechaA.isBefore(fechaB);
		
	} 
	
}
