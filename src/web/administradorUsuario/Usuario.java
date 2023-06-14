package web.administradorUsuario;

import web.extras.*;
import web.administradorMuestra.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {

	private String nombre;
	private EstadoUsuario estadoUsuario;
	private ArrayList<Muestra> muestras;
	private ArrayList<Opinion> opiniones;

	// CONSTRUCTOR
	public Usuario(String nombre) {
		
		this.nombre = nombre;
		this.estadoUsuario = new EstadoBasico();
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

	public EstadoUsuario getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
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
		this.getEstadoUsuario().updateUsuario(this);
		
	}
	
	public void agregarMuestra(Muestra muestra) {
		
		muestras.add(muestra);
		this.getEstadoUsuario().updateUsuario(this);
	}
	
	public void validacionExterna() {
		
		this.setEstadoUsuario(new EstadoValidado());
		 
	}
	
	
	
	
	
	
}
