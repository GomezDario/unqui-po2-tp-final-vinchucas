package web.administradorZona;

import java.util.ArrayList;
import java.util.List;

import web.administradorMuestra.Muestra;
import web.extras.Ubicacion;

public class ZonaDeCobertura {
	
	Ubicacion ubicacion;
	double radio; 
	String nombre;
	List<Muestra> muestras = new ArrayList<>();
	List<ZonaDeCobertura> zonasQueSolapan = new ArrayList<>();
	List<Observador> observadores = new ArrayList<>();
	
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

	public boolean estaDentroDeZona(Muestra unaMuestra) {
		// TODO Auto-generated method stub
		double distancia = this.ubicacion.distanciaEntre(unaMuestra.getUbicacion());
		
		return distancia <= radio;
	}

	public void agregarMuestra(Muestra unaMuestra) {
		// TODO Auto-generated method stub
		muestras.add(unaMuestra);
		this.notificarNuevaMuestra(unaMuestra);
	}

	public int cantidadDeMuestras() {
		// TODO Auto-generated method stub
		return muestras.size();
	}

	public boolean solapaCon(ZonaDeCobertura otraZonaDeCobertura) {
		// TODO Auto-generated method stub
        double distancia = ubicacion.distanciaEntre(otraZonaDeCobertura.getUbicacion());
        // Verificar si la distancia es menor o igual a la suma de los radios
        return distancia <= (this.radio + otraZonaDeCobertura.getRadio());
	}

	public void agregarZona(ZonaDeCobertura otraZonaDeCobertura) {
		// TODO Auto-generated method stub
		zonasQueSolapan.add(otraZonaDeCobertura);
		
	}

	public List<ZonaDeCobertura> getZonasQueSolapan() {
		// TODO Auto-generated method stub
		return zonasQueSolapan;
	}

	public int cantidadDeZonasQueSolapan() {
		// TODO Auto-generated method stub
		return zonasQueSolapan.size();
	}

	public int cantidadDeObservadores() {
		// TODO Auto-generated method stub
		return observadores.size();
	}

	public void registrar(Observador unObservador) {
		// TODO Auto-generated method stub
		observadores.add(unObservador);
	}

	public void desregistrar(Observador unaOrganizacionNoGubernamental) {
		// TODO Auto-generated method stub
		observadores.remove(unaOrganizacionNoGubernamental);
	}

	private void notificarNuevaMuestra(Muestra unaMuestra) {
		// TODO Auto-generated method stub
		for(Observador observador : observadores) {
			observador.funcionNuevaMuestra(this, unaMuestra);
		}
	}

	public void notificarMuestraValidada(Muestra unaMuestra) {
		// TODO Auto-generated method stub
		for(Observador observador : observadores) {
			observador.funcionValidacionMuestra(this, unaMuestra);
		}
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
