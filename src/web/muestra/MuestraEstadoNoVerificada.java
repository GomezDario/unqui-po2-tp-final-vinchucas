package web.muestra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import web.opinion.Opinion;
import web.opinion.TipoDeOpinion;


public class MuestraEstadoNoVerificada implements  MuestraEstado
{
	public MuestraEstadoNoVerificada()
	{
		
	}
	
	public TipoDeOpinion resultadoActual(Muestra muestra) 
    {
    	 Map<TipoDeOpinion, Integer> frecuencias = new HashMap<>();
    	
    	 for (Opinion opinion : muestra.getlistaDeOpiniones()) 
    	 {
             frecuencias.put(opinion.getTipoDeOpinion(), frecuencias.getOrDefault(opinion.getTipoDeOpinion(), 0) + 1);
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
    }

	@Override
	public void agregarOpinion(Opinion opinion, Muestra muestra) 
	{
		muestra.getlistaDeOpiniones().add(opinion);
		
		if (opinion.getUsuario().esExperto()) 
		{
			muestra.cambiarEstado(new MuestraEstadoVerificadaPorExperto()); // error de imports creo, arreglar despues
		}
		
	}

	@Override
	public TipoDeOpinion resultadoActual(ArrayList<Opinion> listaDeOpiniones) {
		// TODO Auto-generated method stub
		return null;
	}


   
    
    
}