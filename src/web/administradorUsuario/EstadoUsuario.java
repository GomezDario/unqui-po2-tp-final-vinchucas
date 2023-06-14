package web.administradorUsuario;

import web.extras.*;
import web.administradorMuestra.*;

import java.util.ArrayList;
import java.time.LocalDate;

public abstract class EstadoUsuario {

	public abstract void updateUsuario(Usuario usuario);
	
	
	public boolean puedeSerExperto(Usuario usuario) {
		
		ArrayList<Muestra> muestras = usuario.getMuestras();
		ArrayList<Opinion> opiniones = usuario.getOpiniones();
		
		return (tieneCantidadEnElMes(10, usuario.fechasDeMuestrasPublicadas(muestras), LocalDate.now())
				&& tieneCantidadEnElMes(20, usuario.fechasDeOpiniones(opiniones), LocalDate.now()));
	}
	
	
	
	private boolean tieneCantidadEnElMes(int cantidad,ArrayList<LocalDate> fechas,LocalDate unaFecha) {
		
		return fechas.stream().filter(f -> this.vieneDespuesDe(f, unaFecha)).count() > cantidad;
	}
	
	private boolean vieneDespuesDe(LocalDate fecha, LocalDate unaFecha) {
		
		LocalDate f1 = unaFecha.minusDays(30);
		
		return fecha.isAfter(f1);
	}
}





