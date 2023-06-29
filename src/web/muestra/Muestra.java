package web.muestra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import web.opinion.Opinion;
import web.opinion.TipoDeOpinion;
import web.ubicacion.Ubicacion;
import web.usuario.Usuario;
import web.zona.ZonaDeCobertura;

public class Muestra {
	
	private Ubicacion ubicacion;
	private String foto;
	private List<Opinion> listaDeOpiniones = new ArrayList<Opinion>();
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

		return estado.resultadoActual(this);
	}

	public LocalDate getFecha() {
	
		return this.fecha;
	}
	
	public String getFoto() {
		return this.foto;
	}
	
	public void agregarOpinion(Opinion opinion) throws Exception 
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

	public List<Opinion> getlistaDeOpiniones()
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
			this.estado = new MuestraEstadoVerificadaPorExperto();
		}
		else
		{
			this.estado = new MuestraEstadoNoVerificada();
		}
	}
	
	public LocalDate getFechaUltimaVotacion() 
	{
		Opinion opinion = listaDeOpiniones.get(listaDeOpiniones.size()-1);
				
		return opinion.getFecha();
	}

	public void registrar(ZonaDeCobertura zonaDeCobertura) {

	}
	
	public boolean  esteUsuarioYaOpino(Usuario usuario) {
		
		return listaDeOpiniones.stream().anyMatch(opinion -> opinion.getUsuario().equals(usuario));
		
	}
}