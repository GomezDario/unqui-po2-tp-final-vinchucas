package web.Muestra;

import java.time.LocalDateTime;

public class Muestra {

	private LocalDateTime fecha;
	private LocalDateTime FechaUltimaVotacion;
	private EstadoMuestra estado;
	private TipoDeOpinion opinion;

	public LocalDateTime getFechaUltimaVotacion() {
		return FechaUltimaVotacion;
	}

	public void setFechaUltimaVotacion(LocalDateTime fechaUltimaVotacion) {
		FechaUltimaVotacion = fechaUltimaVotacion;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	 public EstadoMuestra getEstado() {
			return estado;
		}
	
	 
	 public TipoDeOpinion resultadoActual() {
		 
		 return opinion;
		 
	 }
	
	
}
