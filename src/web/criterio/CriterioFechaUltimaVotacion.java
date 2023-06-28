package web.criterio;

import web.muestra.*;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
 
public class CriterioFechaUltimaVotacion implements Criterio {

	private ComparadorFechas comparador;
	private LocalDate fecha;
	
	public CriterioFechaUltimaVotacion(ComparadorFechas comparador, LocalDate fecha) {
		
    	this.comparador = comparador;
    	this.fecha = fecha;
    	
    }
	
	public ComparadorFechas getComparador() {
		
    	return this.comparador;
    	
    }
	
	
	 public LocalDate getFecha() {
	    	return this.fecha;
	 }
	
	 
	 public List<Muestra> buscarEn(ArrayList<Muestra> muestras) { 
			
		 List<Muestra> resultado = muestras.stream()
				    .filter(m -> comparador.compararEntre(m.getFechaUltimaVotacion(), fecha))
					.collect(Collectors.toList());
		 
			return resultado;
			
		}
	
}
