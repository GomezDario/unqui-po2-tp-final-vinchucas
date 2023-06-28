package web.criterio;

import web.muestra.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
 

public class CriterioFechaCreacion implements Criterio {

	 private LocalDate fecha;
	 private ComparadorFechas comparador;
	 
	 
	  public CriterioFechaCreacion(ComparadorFechas comparador, LocalDate fechaAver) {
	        
		    this.comparador = comparador;
	    	this.fecha = fechaAver;
	    	
	    }
	 
	 public ComparadorFechas getComparador() {
	    	return this.comparador;
	    }
	 
	 
	 public LocalDate getFecha(){
	        return this.fecha;
	    }
	 
	 
	 public List<Muestra> buscarEn(ArrayList<Muestra> muestras){ 
	    	List<Muestra> resultado = muestras.stream()
					.filter(m -> comparador.compararEntre(m.getFecha(), fecha))
					.collect(Collectors.toList());
	    	
	    	
			return resultado;
	    }
	 
	 
}
