package web.muestra;

import java.util.ArrayList;

import web.opinion.Opinion;
import web.opinion.TipoDeOpinion;

public interface MuestraEstado {

	 

	 public TipoDeOpinion resultadoActual(Muestra muestra);
	 public void agregarOpinion(Opinion opinion, Muestra muestra) throws Exception;
	 
	 
		
}
