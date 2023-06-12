package administradorZona;

import java.util.ArrayList;
import java.util.List;

public class AdministradorZona {

	List<ZonaDeCobertura> zonasDeCobertura = new ArrayList<>();
	
	public int cantidadDeZonasDeCobertura() {
		// TODO Auto-generated method stub
		return zonasDeCobertura.size();
	}

	public void agregarZona(ZonaDeCobertura unaZonaDeCobertura) {
		// TODO Auto-generated method stub
		for(ZonaDeCobertura zona : zonasDeCobertura) {
			if(zona.solapaCon(unaZonaDeCobertura)) {
				zona.agregarZona(unaZonaDeCobertura);
				unaZonaDeCobertura.agregarZona(zona);
			}
		}
		zonasDeCobertura.add(unaZonaDeCobertura);
	}

	public void agregarMuestra(Muestra unaMuestra) {
		// TODO Auto-generated method stub
		for(ZonaDeCobertura unaZona : zonasDeCobertura) {
			if(unaZona.estaDentroDeZona(unaMuestra)) {
				unaZona.agregarMuestra(unaMuestra);
			}
		}
	}

	public void muestraValidada(Muestra unaMuestra) {
		// TODO Auto-generated method stub
		for(ZonaDeCobertura zona : zonasDeCobertura) {
			if(zona.estaDentroDeZona(unaMuestra)) {
				zona.notificarMuestraValidada(unaMuestra);
			}
		}
	}

}
