package es.ddd.carteras.infraestructura;

import es.ddd.carteras.modelo.Accion;
import es.ddd.carteras.modelo.RepositorioDeAcciones;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RepositorioDeAccionesJPA implements RepositorioDeAcciones {

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
    public void guardar(Accion accion) {
        AccionDS accionDS = new AccionDS(accion.nombre(), accion.ultimaCotizacionDisponible());
        entityManager.persist(accionDS);
        accion.id(accionDS.id);
    }

    @Override
    @Transactional
    public void borrarTodas() {
        Query q = entityManager.createQuery("DELETE FROM " + AccionDS.class.getSimpleName());
        q.executeUpdate();
    }

    @Override
    public Accion getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
