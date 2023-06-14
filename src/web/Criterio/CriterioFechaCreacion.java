package web.Criterio;

import web.Muestra.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CriterioFechaCreacion implements Criterio {

	 private LocalDateTime fecha;
	 private ComparadorFechas comparador;
	 
	 
	  public CriterioFechaCreacion(ComparadorFechas comparador, LocalDateTime fechaAver) {
	        
		    this.comparador = comparador;
	    	this.fecha = fechaAver;
	    	
	    }
	 
	 public ComparadorFechas getComparador() {
	    	return this.comparador;
	    }
	 
	 
	 public LocalDateTime getFecha(){
	        return this.fecha;
	    }
	 
	 
	 public List<Muestra> buscarEn(ArrayList<Muestra> muestras){ 
	    	List<Muestra> resultado = muestras.stream()
					.filter(m -> comparador.compararEntre(m.getFecha(), fecha))
					.collect(Collectors.toList());
	    	
	    	
			return resultado;
	    }
	 
	 
}
