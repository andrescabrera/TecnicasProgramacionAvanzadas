package es.ddd.carteras.infraestructura;

import es.ddd.carteras.modelo.EntidadFinanciera;
import es.ddd.carteras.modelo.RepositorioDeEntidadesFinancieras;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RepositorioDeEntidadesFinancierasJPA implements RepositorioDeEntidadesFinancieras {

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void guardar(EntidadFinanciera entidadFinanciera) {
        EntidadFinancieraDS entidadFinancieraDS = new EntidadFinancieraDS(entidadFinanciera.nombre(),
                                                      entidadFinanciera.actualizador().nombre());
        entityManager.persist(entidadFinancieraDS);
        entidadFinanciera.Id(entidadFinancieraDS.id);
    }

    @Override
    @Transactional
    public void borrarTodas() {
        Query q = entityManager.createQuery("DELETE FROM " + EntidadFinancieraDS.class.getSimpleName());
        q.executeUpdate();
    }

    @Override
    public EntidadFinanciera getById(Long id) {
        throw new UnsupportedOperationException("sin implementar, no es necesario para el ejemplo");

    }

}
