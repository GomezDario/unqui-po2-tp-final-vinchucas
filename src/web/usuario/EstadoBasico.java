package web.usuario;

import java.time.LocalDate;
import java.util.ArrayList;

import web.muestra.*;
import web.opinion.*;

public class EstadoBasico implements EstadoUsuario{ 

	@Override
	
	public void nivelarUsuario(Usuario usuario) {
		
		
		if (puedeSerExperto(usuario)) {
			
			usuario.setEstado(new EstadoExperto());
			
		} else {
			
			usuario.setEstado(this);
			
		}
		
	}
	
	
	
	public boolean tieneCantidadEnElMes(int cantidad,ArrayList<LocalDate> fechas,LocalDate unaFecha) {
		return fechas.stream().filter(f -> this.vieneDespuesDe(f, unaFecha)).count() > cantidad;
	}
	
	public boolean vieneDespuesDe(LocalDate fecha, LocalDate unaFecha) {
		LocalDate f1 = unaFecha.minusDays(30);
		
		return fecha.isAfter(f1);
	}
	
	
	public boolean puedeSerExperto(Usuario usuario) {
		ArrayList<Muestra> muestras = usuario.getMuestras(); 
		ArrayList<Opinion> opiniones = usuario.getOpiniones();

		return (tieneCantidadEnElMes(10, usuario.fechasDeMuestrasPublicadas(muestras), LocalDate.now())
				&& tieneCantidadEnElMes(20, usuario.fechasDeOpiniones(opiniones), LocalDate.now()));
	}
	
	
	
	
	
	@Override
	public boolean esExperto() {
		// TODO Auto-generated method stub
		return false;
	}
}

