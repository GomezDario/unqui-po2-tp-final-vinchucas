package web.ubicacion;

import java.util.ArrayList;
import java.util.List;

public class Ubicacion {

	double latitud;
	double longitud;
	
	public Ubicacion(double unaLatitud, double unaLongitud) {
		// TODO Auto-generated constructor stub
		latitud = unaLatitud;
		longitud = unaLongitud;
	}

	public double getLatitud() {
		// TODO Auto-generated method stub
		return latitud;
	}
	
	public double getLongitud() {
		// TODO Auto-generated method stub
		return longitud;
	}

	public double distanciaEntre(Ubicacion unaUbicacion) {
		// TODO Auto-generated method stub
		
		// Convertir las coordenadas a radianes
		double latitud1 = Math.toRadians(latitud);
        double longitud1 = Math.toRadians(longitud);
        
        double latitud2 = Math.toRadians(unaUbicacion.getLatitud());
        double longitud2 = Math.toRadians(unaUbicacion.getLongitud());
		
		return haversine(latitud1, longitud1, latitud2, longitud2);
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

	public List<Ubicacion> ubicacionesAMenosDe(double unaDistancia, List<Ubicacion> ubicacionesAEvaluar) {
		// TODO Auto-generated method stub
		List<Ubicacion> ubicacionesCerca = new ArrayList<>();
		
		for(Ubicacion ubi : ubicacionesAEvaluar) {
			if(distanciaEntre(ubi) < unaDistancia) {
				ubicacionesCerca.add(ubi);
			}
		}
		
		return ubicacionesCerca;
	}
}
