package web.extras;

import java.time.LocalDate;

import web.administradorMuestra.Muestra;
import web.administradorUsuario.Usuario;

public class Opinion {
	
	LocalDate fecha;
	TipoDeOpinion tipoDeOpinion;
	Usuario usuario;
	Muestra muestra;
	
	public Opinion(TipoDeOpinion vinchucasordida, Usuario unUsuario, Muestra unaMuestra) {
		// TODO Auto-generated constructor stub
		this.tipoDeOpinion = vinchucasordida;
		this.usuario = unUsuario;
		this.muestra = unaMuestra;
		fecha = LocalDate.now();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Muestra getMuestra() {
		return muestra;
	}

	public LocalDate getFecha() {
		// TODO Auto-generated method stub
		return fecha;
	}

	public TipoDeOpinion getTipoDeOpinion() {
		// TODO Auto-generated method stub
		return tipoDeOpinion;
	}

}
