package web.Criterio;

import java.util.ArrayList;
import java.util.List;

import web.Muestra.*;

public class OperadorLogicoAnd implements OperadorLogico {
	
	public List<Muestra> juntarArrays(List<Muestra> xs, List<Muestra> ys){
		
        List<Muestra> muestrasEnComun = new ArrayList<>();
        
        for (int i = 0; i < ys.size(); i++) {
            
        	if(xs.contains(ys.get(i)) && ! muestrasEnComun.contains(ys.get(i))){
                muestrasEnComun.add(ys.get(i));
                
            }
        	
        }
        
        return muestrasEnComun;
        
    }

	

}
