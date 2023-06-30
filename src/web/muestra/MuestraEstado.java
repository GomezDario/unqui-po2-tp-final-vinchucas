package web.muestra;

import web.opinion.Opinion;
import web.opinion.TipoDeOpinion;
import web.zona.ObservadorZona;
import web.zona.ZonaDeCobertura;

public interface MuestraEstado {

	 public TipoDeOpinion resultadoActual(Muestra muestra);
	 
	 public void agregarOpinion(Opinion opinion, Muestra muestra) throws Exception;
	

	 
}
