package web.zona;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import web.muestra.Muestra;
import web.ubicacion.Ubicacion;

public class ZonaDeCobertura implements ObservableOrg, ObservadorZona{
	
	private Ubicacion ubicacion;
	private double radio; 
	private String nombre;
	private Set<ObservadorOrg> observadores = new HashSet<>();
	
	public ZonaDeCobertura(Ubicacion unaUbicacion, double unRadio, String unNombre) {
		// TODO Auto-generated constructor stub
		ubicacion = unaUbicacion;
		radio = unRadio;
		nombre = unNombre;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public double getRadio() {
		return radio;
	}
	
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	public void registrar(ObservadorOrg unObservador) {
		// TODO Auto-generated method stub
		observadores.add(unObservador);		
	}
	
	public void desregistrar(ObservadorOrg unObservador) {
		// TODO Auto-generated method stub
		observadores.remove(unObservador);
	}
	
	public int cantidadDeObservadores() {
		// TODO Auto-generated method stub
		return observadores.size();
	}

	public boolean estaDentroDeZona(Muestra unaMuestra) {
		// TODO Auto-generated method stub
		double distancia = this.ubicacion.distanciaEntre(unaMuestra.getUbicacion());
		return distancia <= radio;
	}
	
	public void notificarNuevaMuestraSiEstaDentroDeZona(Muestra unaMuestra) {
		// TODO Auto-generated method stub
		if(estaDentroDeZona(unaMuestra)) {
			notificarNuevaMuestra(unaMuestra);
		}
	}

	private void notificarNuevaMuestra(Muestra unaMuestra) {
		// TODO Auto-generated method stub
		for(ObservadorOrg observador : observadores) {
			observador.funcionNuevaMuestra(this, unaMuestra);
			registrarAMuestra(unaMuestra);
		}
	}
	
	private void registrarAMuestra(Muestra unaMuestra) {
		unaMuestra.registrar(this);
	}

	public void notificarMuestraValidada(Muestra unaMuestra) {
		// TODO Auto-generated method stub
		for(ObservadorOrg observador : observadores) {
			observador.funcionValidacionMuestra(this, unaMuestra);
		}
	}	
	
	public boolean solapaCon(ZonaDeCobertura otraZonaDeCobertura) {
		// TODO Auto-generated method stub
        double distancia = ubicacion.distanciaEntre(otraZonaDeCobertura.getUbicacion());
        // Verificar si la distancia es menor o igual a la suma de los radios
        return distancia <= (this.radio + otraZonaDeCobertura.getRadio());
	}

	public Set<ZonaDeCobertura> zonasQueSolapan(Set<ZonaDeCobertura> zonas) {
		Set<ZonaDeCobertura> zonasQueSolapan = zonas.stream()
				.filter(zona -> this.solapaCon(zona))
				.collect(Collectors.toSet());
		
		return zonasQueSolapan;
	}
	
}
