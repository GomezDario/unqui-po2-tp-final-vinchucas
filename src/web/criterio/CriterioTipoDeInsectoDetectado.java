package web.criterio;

import web.muestra.*;
import web.opinion.*;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
 

public class CriterioTipoDeInsectoDetectado implements Criterio {
	
	private TipoDeOpinion tipoABuscar;
	
	public CriterioTipoDeInsectoDetectado(TipoDeOpinion opinionATenerEnCuenta) {
		
        tipoABuscar = opinionATenerEnCuenta;
        
    }
	
	public TipoDeOpinion getTipoABuscar(){
		
        return tipoABuscar;
        
    }
	
	public List<Muestra> buscarEn(ArrayList<Muestra> muestras){
		
    	List<Muestra> resultado = muestras.stream()
    			.filter(m-> m.resultadoActual().equals(this.getTipoABuscar()))
    			.collect(Collectors.toList());
    	
    	return resultado;
    	
    }
	
}
