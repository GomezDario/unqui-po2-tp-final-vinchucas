package web.administradorUsuario;

import web.extras.*;
import web.administradorMuestra.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {

	private String nombre;
	private EstadoUsuario estado;
	private ArrayList<Muestra> muestras;
	private ArrayList<Opinion> opiniones;

	// CONSTRUCTOR
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.estado = new EstadoBasico();
		this.muestras  = new ArrayList<Muestra>();
		this.opiniones = new ArrayList<Opinion>();
	}

	// GET´S Y SET´S
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EstadoUsuario getEstado() {
		return estado;
	}

	public void setEstado(EstadoUsuario estado) {
		this.estado = estado;
	}

	public ArrayList<Muestra> getMuestras() {
		return muestras;
	}

	public void setMuestras(ArrayList<Muestra> muestras) {
		this.muestras = muestras;
	}

	public ArrayList<Opinion> getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(ArrayList<Opinion> opiniones) {
		this.opiniones = opiniones;
		
	}

	// -------------Metodos----------------- //
	
	
	public ArrayList<LocalDate> fechasDeOpiniones(ArrayList<Opinion> opiniones){
		
		 
		ArrayList<LocalDate> fechas = new ArrayList<>();
		
		for (Opinion opinion : opiniones) {
			
			fechas.add(opinion.getFecha());
			
		}
		
		return fechas;
		
	}
	
	public  ArrayList<LocalDate> fechasDeMuestrasPublicadas(ArrayList<Muestra> muestras){
		
		ArrayList<LocalDate> fechas = new ArrayList<>();
		
		for (Muestra muestra : muestras) {
			
			fechas.add(muestra.getFecha());
			
		}
		
		return fechas;
	}
	

	public void agregarOpinion(Opinion opinion) {
		opiniones.add(opinion);
		this.getEstado().updateUsuario(this);
		
	}
	
	public void agregarMuestra(Muestra muestra) {
		
		muestras.add(muestra);
		this.getEstado().updateUsuario(this);
	}
	
	public void validacionExterna() {
		
		this.setEstado(new EstadoValidado());
		 
	}

	public int cantidadDeOpiniones() {
		// TODO Auto-generated method stub
		return opiniones.size();
	}

	public int cantidadDeMuestras() {
		// TODO Auto-generated method stub
		return muestras.size();
	}

	public boolean esExperto() {
		// TODO Auto-generated method stub
		return estado.esExperto();
	}

//	public Integer cantidadDeMuestrasAMenosDeTreintaDias() {
//		// TODO Auto-generated method stub
//		LocalDate fechaActual = LocalDate.now();
//		List<Muestra> muestrasAMenos = new ArrayList<>();
//		
//		for (Muestra muestra : muestras) {
//            long diferenciaDias = ChronoUnit.DAYS.between(muestra.getFecha(), fechaActual);
//            if (diferenciaDias < 30) {
//                muestrasAMenos.add(muestra);
//            }
//        }
//		
//		return muestrasAMenos.size();
//	}
//
//	public Integer cantidadDeOpinionesAMenosDeTreintaDias() {
//		// TODO Auto-generated method stub
//		LocalDate fechaActual = LocalDate.now();
//		List<Opinion> opinionesAMenos = new ArrayList<>();
//		
//		for (Opinion opinion : opiniones) {
//            long diferenciaDias = ChronoUnit.DAYS.between(opinion.getFecha(), fechaActual);
//            if (diferenciaDias < 30) {
//            	opinionesAMenos.add(opinion);
//            }
//        }
//		
//		return opinionesAMenos.size();
//	}
	
	
	
	
	
	
}