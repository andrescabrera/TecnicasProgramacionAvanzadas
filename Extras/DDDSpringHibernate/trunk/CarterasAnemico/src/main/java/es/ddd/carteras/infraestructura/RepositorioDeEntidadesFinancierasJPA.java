package es.ddd.carteras.infraestructura;

import es.ddd.carteras.modelo.EntidadFinanciera;
import es.ddd.carteras.modelo.RepositorioDeEntidadesFinancieras;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDeEntidadesFinancierasJPA extends RepositorioJPA<EntidadFinanciera> implements RepositorioDeEntidadesFinancieras  {

    @Override
    public Class claseAPersistir() {
        return EntidadFinanciera.class;
    }


    
}
