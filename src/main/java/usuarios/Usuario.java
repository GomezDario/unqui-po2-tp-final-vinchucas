package main.java.usuarios;
import main.java.Muestra.*;
import main.java.Opinion.*;
import main.java.SitioWeb.*;


import java.time.LocalDateTime;
import java.util.ArrayList;



public class Usuario {

	private Web sitio;
	private String nombre;
	private EstadoUsuario estadoUsuario;
	private ArrayList<Muestra> muestras;
	private ArrayList<Opinion> opiniones;
	
	
	// CONSTRUCTOR
	public Usuario(String nombre, Web sitio) {
		
		this.nombre = nombre;
		this.estadoUsuario = new EstadoBasico();
		this.muestras  = new ArrayList<Muestra>();
		this.opiniones = new ArrayList<Opinion>();
		this.sitio = sitio;
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
	
	public Web getSitio() {
		return sitio;
	}


	public void setSitio(Web sitio) {
		this.sitio = sitio;
	}

	
	// -------------Metodos----------------- //
	
	
	public ArrayList<LocalDateTime> fechasDeOpiniones(ArrayList<Opinion> opiniones){
		
		
		ArrayList<LocalDateTime> fechas = new ArrayList<>();
		
		for (Opinion opinion : opiniones) {
			
			fechas.add(opinion.getFecha());
			
		}
		
		return fechas;
		
	}
	
	public  ArrayList<LocalDateTime> fechasDeMuestrasPublicadas(ArrayList<Muestra> muestras){
		
		ArrayList<LocalDateTime> fechas = new ArrayList<>();
		
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
