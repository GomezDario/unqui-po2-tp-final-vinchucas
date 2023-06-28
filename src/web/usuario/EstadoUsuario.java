package web.usuario;

import java.time.LocalDate;
import java.util.ArrayList;

import web.muestra.Muestra;
import web.opinion.Opinion;

public interface EstadoUsuario {

//	public boolean puedeSerExperto(Usuario unUsuario) {
//		return unUsuario.cantidadDeMuestrasAMenosDeTreintaDias() >= 10 &&
//				unUsuario.cantidadDeOpinionesAMenosDeTreintaDias() >= 20;
//	}
	public abstract void nivelarUsuario(Usuario usuario);
	
	public abstract boolean esExperto();
	
	public abstract boolean tieneCantidadEnElMes(int cantidad,ArrayList<LocalDate> fechas,LocalDate unaFecha);
	
	public abstract boolean vieneDespuesDe(LocalDate fecha, LocalDate unaFecha);
}




