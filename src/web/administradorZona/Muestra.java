
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDate;
import java.lang.String;

//package web.administradorZona;

public class Muestra 
{
	
	// el estado cambia cuando el usuario agrega una opinion, en el metodo de agregar una opinion hay que poner un if que si el usuario que agrega es verificado cambia el estado de la muestra
	
    private Ubicacion ubicacion;
    private String foto;
    private Usuario usuario;
    private ArrayList<Opinion> historialDeVotaciones;
    private LocalDate fecha;
    private MuestraEstado estado;

    public Muestra(Ubicacion ubicacion, String foto, Usuario usuario, Opinion opinionInicial, LocalDate fecha) 
    {
        this.ubicacion = ubicacion;
        this.foto = foto;
        this.usuario = usuario;
        this.historialDeVotaciones = new ArrayList<>();
        this.historialDeVotaciones.add(opinionInicial);
        this.fecha = fecha;
        this.estado = new MuestraEstadoNoVerificada();
    }

    private void cambiarEstado(MuestraEstado estado) 
    {
    	this.estado = estado;
    }
    
    public TipoDeOpinion resultadoActual() 
    {
    	 return estado.resultadoActual(historialDeVotaciones);
    }
    
    public LocalDate getFecha() 
    {
        return fecha;
    }
    
    public Ubicacion getUbicacion() {
    	return ubicacion;
    }
    
    public String getFoto() {
    	return foto;
    }
    
    public Usuario getUsuario() {
    	return usuario;
    }
    
}
