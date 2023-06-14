package web.Criterio;

import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

import web.Muestra.*;

public class CriterioNivelVerificacion implements Criterio {

	private EstadoMuestra estadoBuscado;
	
	public CriterioNivelVerificacion (EstadoMuestra estado) {
		
        this.estadoBuscado = estado;
        	
        
    }

	
	public EstadoMuestra getEstadoBuscado(){
		
        return this.estadoBuscado;
        
        
    }
	
	
	public List<Muestra> buscarEn(ArrayList<Muestra> muestras){
		
    	List<Muestra> resultado = muestras.stream()
    			.filter(m-> m.getEstado().equals(this.getEstadoBuscado()))
    			.collect(Collectors.toList());
    	
    	return resultado;
    }
	
	
}
