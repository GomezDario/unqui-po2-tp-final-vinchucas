package web.administradorMuestra;
import java.util.ArrayList;
import java.util.List;

public class Ubicacion {

	

	public float getLatitud() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public float getLongitud() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getRadio() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	 public float distanciaEntre(Ubicacion otraUbicacion) 
	 {
	        float latitudOtra = otraUbicacion.getLatitud();
	        float longitudOtra = otraUbicacion.getLongitud();

	        // Fórmula para calcular la distancia entre dos puntos en coordenadas geográficas
	        // Puedes utilizar otra fórmula más precisa según tus necesidades
	        double radioTierra = 6371; // Radio de la Tierra en kilómetros
	        double dLatitud = Math.toRadians(latitudOtra - latitud);
	        double dLongitud = Math.toRadians(longitudOtra - longitud);
	        double a = Math.sin(dLatitud / 2) * Math.sin(dLatitud / 2) +
	                Math.cos(Math.toRadians(latitud)) * Math.cos(Math.toRadians(latitudOtra)) *
	                        Math.sin(dLongitud / 2) * Math.sin(dLongitud / 2);
	        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	        double distancia = radioTierra * c;

	        return (float) distancia;
	    }

	    public List<Ubicacion> ubicacionesAMenosDe(float distanciaMaxima, ArrayList<Ubicacion> ubicaciones) 
	    {
	        List<Ubicacion> ubicacionesCercanas = new ArrayList<>();

	        for (Ubicacion ubicacion : ubicaciones) {
	            float distancia = distanciaEntre(ubicacion);
	            if (distancia < distanciaMaxima) {
	                ubicacionesCercanas.add(ubicacion);
	            }
	        }

	        return ubicacionesCercanas;
	    }

}
