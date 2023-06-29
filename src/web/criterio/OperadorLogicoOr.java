package web.criterio;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import web.muestra.*;

public class OperadorLogicoOr implements OperadorLogico {
	
	public List<Muestra> juntarArrays(List<Muestra> xs, List<Muestra> ys){
		
        Set<Muestra> union = new HashSet<>();        
        union.addAll(xs);
        union.addAll(ys);
        
        List<Muestra> list = new ArrayList<>(union);
        
        return list;
    }
}
