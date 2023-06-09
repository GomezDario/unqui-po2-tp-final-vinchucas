package web.usuario;

import java.time.LocalDate;
import java.util.ArrayList;

public interface EstadoUsuario {

	public abstract void nivelarUsuario(Usuario usuario);
	
	public abstract boolean esExperto();
	
	public abstract boolean tieneCantidadEnElMes(int cantidad,ArrayList<LocalDate> fechas,LocalDate unaFecha);
	
	public abstract boolean vieneDespuesDe(LocalDate fecha, LocalDate unaFecha);
}




