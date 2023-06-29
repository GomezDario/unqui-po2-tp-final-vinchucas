package web.criterio;

import java.util.List;

import web.muestra.*;
 
public class OperadorLogicoAnd implements OperadorLogico {
	
	public List<Muestra> juntarArrays(List<Muestra> xs, List<Muestra> ys){
		
        xs.retainAll(ys);
        
        return xs;
    }

}
