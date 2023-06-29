package web.criterio;

import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

import web.muestra.*;
 
public class CriterioNivelVerificacion implements Criterio {

	private MuestraEstado estadoBuscado;
	
	public CriterioNivelVerificacion (MuestraEstado estado) {
		
        this.estadoBuscado = estado;
        	
        
    }

	
	public MuestraEstado getEstadoBuscado(){
		
        return this.estadoBuscado;
        
        
    }
	
	
	public List<Muestra> buscarEn(ArrayList<Muestra> muestras){
		
    	List<Muestra> resultado = muestras.stream()
    			.filter(m-> m.getEstado().equals(this.getEstadoBuscado()))
    			.collect(Collectors.toList());
    	
    	return resultado;
    }
	
	
}
