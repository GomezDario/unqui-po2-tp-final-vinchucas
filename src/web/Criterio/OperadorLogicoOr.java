package web.Criterio;

import java.util.List;
import web.Muestra.*;

public class OperadorLogicoOr implements OperadorLogico {
	
	public List<Muestra> juntarArrays(List<Muestra> xs, List<Muestra> ys){
		
        for(int i = 0;i<ys.size();i++){
        	
            this.agregarSiNoEsta(xs,ys.get(i));
            
        }
        
        return xs;
    }
	
	public void agregarSiNoEsta(List<Muestra> array, Muestra m) {
	    
		boolean estaPresente = false;
	    for (Muestra muestra : array) {
	        if (muestra.equals(m)) {
	            estaPresente = true;
	            break;
	        }
	    }
	    
	    if (!estaPresente) {
	        array.add(m);
	    }
	}
	

}
