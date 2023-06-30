package web.criterio;
import web.muestra.*;

import java.util.ArrayList;
import java.util.List;

 

public class CriterioCombinado implements Criterio{

	private OperadorLogico conector;
    private Criterio criterio1;
    private Criterio criterio2;
    
    public CriterioCombinado(OperadorLogico conectorAPoner, Criterio criterioAPoner1, Criterio criterioAPoner2) {
        conector = conectorAPoner;
        criterio1 = criterioAPoner1;
        criterio2 = criterioAPoner2;
    }
    
    public OperadorLogico getOperador() {
        return this.conector;
    }
    
    public Criterio getCriterio1() {
    	return this.criterio1;
    }
    
    public Criterio getCriterio2() {
    	return this.criterio2;
    }


    public List<Muestra> buscarEn(ArrayList<Muestra> muestras) {
        List<Muestra> resultadoDelCriterio1 = this.getCriterio1().buscarEn(muestras);
        
        List<Muestra> resultadoDelCriterio2 = this.getCriterio2().buscarEn(muestras);
        
        return this.getOperador().juntarArrays(resultadoDelCriterio1,resultadoDelCriterio2);
    }
    
    
    
}
