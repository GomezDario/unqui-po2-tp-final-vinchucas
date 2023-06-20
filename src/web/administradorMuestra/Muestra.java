
package web.administradorMuestra;

import java.time.LocalDate;

import web.administradorUsuario.Usuario;
import web.administradorZona.ArrayList;
import web.administradorZona.MuestraEstado;
import web.administradorZona.Opinion;
import web.extras.TipoDeOpinion;
import web.extras.Ubicacion;

public class Muestra {
	
	private Ubicacion ubicacion;
	private String foto;
	private ArrayList<Opinion> listaDeOpiniones;
	private MuestraEstado estado;
	private LocalDate fecha;
	private Usuario usuarioQueLaRecolecto;


	public Muestra(Ubicacion ubicacion, String foto, Opinion opinion, Usuario usuariousuarioQueLaRecolecto ) 
	{
		this.ubicacion = ubicacion;
        this.foto = foto;
        this.listaDeOpiniones.add(opinion) ;
        this.estadoInicial(usuariousuarioQueLaRecolecto);
        this.fecha = LocalDate.now();       
        this.usuarioQueLaRecolecto = usuariousuarioQueLaRecolecto;
 	}
	
	public Ubicacion getUbicacion() {

		return this.ubicacion;
	}

	public TipoDeOpinion resultadoActual() 
	{

		return estado.resultadoActual(this.listaDeOpiniones);
	}

	public LocalDate getFecha() {
	
		return this.fecha;
	}
	
	public String getFoto() {
		return this.foto;
	}
	
	public void agregarOpinion(Opinion opinion) 
	{
		estado.agregarOpinion(opinion, this);
	}

	public MuestraEstado getEstado() {
		
		return this.estado;
	}
	
	public Usuario getUsuario() 
	{
		return this.usuarioQueLaRecolecto;
	}

	public ArrayList<Opinion> getlistaDeOpiniones()
	{
		return this.listaDeOpiniones;
	}
	
	public void cambiarEstado(MuestraEstado estado) 
	{
		this.estado = estado;
		
		/*
		Esto lo hago porque en java no tengo forma de pasar la referencia de la variable estado de esta clase por un metodo de la instancia de estaod  
		 
		Si fuese c# pasaria como referencia la variable estado de esta clase asi estado.agregarOpinion(opinion, REF this);  
		
		No creo una clase contenedor ya que de todas formas deberia llamar a un metodo en esta clase 
		
		
		 
		*/
		
	}
	
	private void estadoInicial(Usuario usuarioQueLaRecolecta) 
	{
		if(usuarioQueLaRecolecta.esExperto()) 
		{
			this.estado = new MuestraEstadoVerificadaPorExperado();
		}
		else
		{
			this.estado = new MUestraEstadoNoVerificada();
		}
	}

}