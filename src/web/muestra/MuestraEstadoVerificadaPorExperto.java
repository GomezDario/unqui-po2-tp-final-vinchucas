package web.muestra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import web.opinion.Opinion;
import web.opinion.TipoDeOpinion;

public class MuestraEstadoVerificadaPorExperto implements MuestraEstado {

	public MuestraEstadoVerificadaPorExperto() {
	
	}
	  public TipoDeOpinion resultadoActual(Muestra muestra)
	    {
	    	 Map<TipoDeOpinion, Integer> frecuencias = new HashMap<>();
	    	
	    	 for (Opinion opinion : muestra.getlistaDeOpiniones()) 
	    	 {
	    		 if(opinion.getUsuario().esExperto())         
	    		 {
	    			 frecuencias.put(opinion.getTipoDeOpinion(), frecuencias.getOrDefault(opinion.getTipoDeOpinion(), 0) + 1); 
	    		 }
	             
	         }

	         // Encuentra el elemento con el recuento de frecuencia máximo
	    	 TipoDeOpinion elementoMasFrecuente = null;
	         int frecuenciaMaxima = 0;
	         boolean empate = false;

	         for (Map.Entry<TipoDeOpinion, Integer> entry : frecuencias.entrySet()) {
	             if (entry.getValue() > frecuenciaMaxima) {
	                 elementoMasFrecuente = entry.getKey();
	                 frecuenciaMaxima = entry.getValue();
	                 empate = false;
	             } else if (entry.getValue() == frecuenciaMaxima) {
	                 empate = true;
	             }
	         }
	        
	         if (empate) {
	             return TipoDeOpinion.NODEFINIDO;
	         } else {
	             return elementoMasFrecuente;
	         }
	         
	         // ESTOY REPITIENDO CODIGO PERO TAMPOCO CREO QUE SEA BUENA PRACTICA SUBIRLO A LA INTERFAZ, ESTOY DUDANDO TAMBIEN DE QUE SEA UN PATRON STRATEGY 
	         // AUNQUE REALMENTE ES UN ESTADO DE LA MUESTRA
	    }
	
	public void agregarOpinion(Opinion opinion, Muestra muestra) throws Exception
	{
		if (opinion.getUsuario().esExperto()) 
		{
			muestra.getlistaDeOpiniones().add(opinion);
		}
		else
		{
			throw new Exception("No se puede agregar la opinión. El usuario no es un experto.");
			  
		}
		
	}
	@Override
	public TipoDeOpinion resultadoActual(ArrayList<Opinion> listaDeOpiniones) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
