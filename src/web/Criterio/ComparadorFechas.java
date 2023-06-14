package web.Criterio;

import java.time.LocalDateTime;

public interface ComparadorFechas {

	boolean compararEntre(LocalDateTime ultimaVotacion, LocalDateTime fecha);

}
