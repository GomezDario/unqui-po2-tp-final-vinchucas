package administradorZona;

import java.util.ArrayList;
import java.util.List;

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
		float distancia = this.ubicacion.distanciaEntre(unaMuestra.getUbicacion());
		
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
		// Convertir las coordenadas a radianes
		double latitud1 = Math.toRadians(this.ubicacion.getLatitud());
        double longitud1 = Math.toRadians(this.ubicacion.getLongitud());
        Ubicacion ubiZona = otraZonaDeCobertura.getUbicacion();
        double latitud2 = Math.toRadians(ubiZona.getLatitud());
        double longitud2 = Math.toRadians(ubiZona.getLongitud());
        
        // Calcular la distancia entre los puntos utilizando la fórmula de haversine
        double distancia = haversine(latitud1, longitud1, latitud2, longitud2);
        // Verificar si la distancia es menor o igual a la suma de los radios
        return distancia <= (this.radio + otraZonaDeCobertura.getRadio());
	}
	
	// Calcular la distancia entre dos puntos utilizando la fórmula de haversine
    private double haversine(double latitud1, double longitud1, double latitud2, double longitud2) {
        double dlat = latitud2 - latitud1;
        double dlon = longitud2 - longitud1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(latitud1) * Math.cos(latitud2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distancia = 6371 * c; // Radio promedio de la Tierra en kilómetros
        return distancia;
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
	
}
