
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


	public Muestra(Ubicacion ubicacion, String foto, Opinion opinion, MuestraEstado estado, Usuario usuariousuarioQueLaRecolecto ) 
	{
		this.ubicacion = ubicacion;
        this.foto = foto;
        this.listaDeOpiniones.add(opinion) ;
        this.estado = estado;
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

	public MuestraEstado getEstado() {
		
		return this.estado;
	}
	
	public Usuario getUsuarioQueLaRecolecto() 
	{
		return this.usuarioQueLaRecolecto;
	}

	

}