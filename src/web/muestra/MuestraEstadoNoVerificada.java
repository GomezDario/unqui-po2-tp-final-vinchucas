package web.muestra;
import java.util.ArrayList;
import java.util.Map;

import web.extras.TipoDeOpinion;

import java.time.LocalDate;
import java.lang.String;
import java.util.HashMap;


public class MuestraEstadoNoVerificada implements  MuestraEstado
{
	public MuestraEstadoNoVerificada()
	{
		
	}
	
	@Override
    public TipoDeOpinion resultadoActual(Muestra muestra) 
    {
    	 Map<TipoDeOpinion, Integer> frecuencias = new HashMap<>();
    	
    	 for (Opinion opinion : muestra.getlistaDeOpiniones()) 
    	 {
             frecuencias.put(opinion.getTipo(), frecuencias.getOrDefault(opinion.getTipo(), 0) + 1);
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


   
    
    
}
