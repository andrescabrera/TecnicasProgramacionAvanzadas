package es.ddd.carteras.infraestructura;

import es.ddd.carteras.modelo.Cartera;
import es.ddd.carteras.modelo.RepositorioDeCarteras;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RepositorioDeCarterasJPA extends RepositorioJPA<Cartera> implements RepositorioDeCarteras {

    @Override
    public Class claseAPersistir() {
        return Cartera.class;
    }

    
}
