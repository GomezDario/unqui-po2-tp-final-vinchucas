package main.java.usuarios;
import main.java.Muestra.*;
import main.java.Opinion.*;


import java.util.ArrayList;
import java.time.LocalDateTime;



public abstract class EstadoUsuario {

	public abstract void updateUsuario(Usuario usuario);
	
	
	public boolean puedeSerExperto(Usuario usuario) {
		
		ArrayList<Muestra> muestras = usuario.getMuestras();
		ArrayList<Opinion> opiniones = usuario.getOpiniones();
		
		return (tieneCantidadEnElMes(10, usuario.fechasDeMuestrasPublicadas(muestras), LocalDateTime.now())
				&& tieneCantidadEnElMes(20, usuario.fechasDeOpiniones(opiniones), LocalDateTime.now()));
	}
	
	
	
	private boolean tieneCantidadEnElMes(int cantidad,ArrayList<LocalDateTime> fechas,LocalDateTime unaFecha) {
		
		return fechas.stream().filter(f -> this.vieneDespuesDe(f, unaFecha)).count() > cantidad;
	}
	
	private boolean vieneDespuesDe(LocalDateTime fecha, LocalDateTime unaFecha) {
		
		LocalDateTime f1 = unaFecha.minusDays(30);
		
		return fecha.isAfter(f1);
	}
}





