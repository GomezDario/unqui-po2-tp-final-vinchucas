package web.administradorMuestra;

import java.util.ArrayList;



import web.extras.TipoDeOpinion;

public interface MuestraEstado {

	 

	 public TipoDeOpinion resultadoActual(Muestra muestra);
	 public void agregarOpinion(Opinion opinion, Muestra muestra);
	
	 
		
}
