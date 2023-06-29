package web.usuario;

import java.time.LocalDate;
import java.util.ArrayList;

public class EstadoValidado implements EstadoUsuario {

	
	public void nivelarUsuario(Usuario usuario) {
		
		usuario.setEstado(this);
		
	}
	
	public boolean tieneCantidadEnElMes(int cantidad,ArrayList<LocalDate> fechas,LocalDate unaFecha) {
		return fechas.stream().filter(f -> this.vieneDespuesDe(f, unaFecha)).count() > cantidad;
	}

	public boolean vieneDespuesDe(LocalDate fecha, LocalDate unaFecha) {
		LocalDate f1 = unaFecha.minusDays(30);
		
		return fecha.isAfter(f1);
		
	}
	
	@Override
	public boolean esExperto() {
		// TODO Auto-generated method stub
		return true;
	}
}
