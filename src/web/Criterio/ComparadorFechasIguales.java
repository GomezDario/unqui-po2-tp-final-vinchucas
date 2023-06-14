package web.Criterio;

import java.time.LocalDateTime;

public class ComparadorFechasIguales implements ComparadorFechas {

	
	public boolean compararEntre(LocalDateTime fechaA, LocalDateTime fechaB) {
		
		return fechaA.equals(fechaB);
		
	}
	
}
