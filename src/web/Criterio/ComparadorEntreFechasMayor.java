package web.Criterio;

import java.time.LocalDateTime;

public class ComparadorEntreFechasMayor implements ComparadorFechas{

	public boolean compararEntre(LocalDateTime fechaA, LocalDateTime fechaB) {
		
		return fechaA.isBefore(fechaB);
		
	}
	
}
