package web.Criterio;

import java.time.LocalDateTime;

public class ComparadorEntreFechasMenor implements ComparadorFechas {

	public boolean compararEntre(LocalDateTime fechaA, LocalDateTime fechaB) {
		
		return fechaA.isAfter(fechaB);
		
	}
	
	
}
