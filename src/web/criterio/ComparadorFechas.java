package web.criterio;

import java.time.LocalDate;

public interface ComparadorFechas {

	boolean compararEntre(LocalDate ultimaVotacion, LocalDate fecha);

} 
