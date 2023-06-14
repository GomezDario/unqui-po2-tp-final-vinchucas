package web.Criterio;

import web.Muestra.*;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class CriterioFechaUltimaVotacion implements Criterio {

	private ComparadorFechas comparador;
	private LocalDateTime fecha;
	
	public CriterioFechaUltimaVotacion(ComparadorFechas comparador, LocalDateTime fecha) {
		
    	this.comparador = comparador;
    	this.fecha = fecha;
    	
    }
	
	public ComparadorFechas getComparador() {
		
    	return this.comparador;
    	
    }
	
	
	 public LocalDateTime getFecha() {
	    	return this.fecha;
	 }
	
	 
	 public List<Muestra> buscarEn(ArrayList<Muestra> muestras) { 
			
		 List<Muestra> resultado = muestras.stream()
				    .filter(m -> comparador.compararEntre(m.getFechaUltimaVotacion(), fecha))
					.collect(Collectors.toList());
		 
			return resultado;
			
		}
	
}
