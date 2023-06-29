package web.muestra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import web.opinion.Opinion;
import web.opinion.TipoDeOpinion;
import web.zona.ObservableZona;
import web.zona.ObservadorZona;


public class MuestraEstadoNoVerificada implements  MuestraEstado, ObservableZona
{
	public MuestraEstadoNoVerificada()
	{
		
	}
	
	ArrayList<ObservadorZona> zonasObservadoras = new ArrayList<>();
	
	@Override
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
	public void agregarOpinion(Opinion opinion, Muestra muestra) throws Exception 
	{
		if(muestra.esteUsuarioYaOpino(opinion.getUsuario())) 
		{
			throw new Exception("No se puede agregar la opinión. El usuario ya opino en esta muestra");
		}
		
		muestra.getlistaDeOpiniones().add(opinion);
		
		if (opinion.getUsuario().esExperto()) 
		{
			muestra.cambiarEstado(new MuestraEstadoVerificadaPorExperto()); // error de imports creo, arreglar despues
			
			for (ObservadorZona zona : this.zonasObservadoras )
			{
				zona.notificarMuestraValidada(muestra);
			}
		
		}
		
	}


	@Override
	public void registrar(ObservadorZona observador) 
	{
		
		zonasObservadoras.add(observador);
	}

	@Override
	public void desregistrar(ObservadorZona observador) 
	{
		
		zonasObservadoras.remove(observador);
	}
    
    
}

