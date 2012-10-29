package es.ddd.carteras.infraestructura;

import es.ddd.carteras.modelo.Cartera;
import es.ddd.carteras.modelo.Inversion;
import es.ddd.carteras.modelo.RepositorioDeCarteras;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RepositorioDeCarterasJPA implements RepositorioDeCarteras {

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
    public void guardar(Cartera cartera) {

        CarteraDS carteraDS = new CarteraDS();
        carteraDS.nombre = cartera.nombre();

        for (Inversion inversion : cartera.inversiones()) {
            carteraDS.inversiones.add(createInversionDSFrom(inversion, carteraDS));
        }
        
        entityManager.persist(carteraDS);


    }

    private InversionDS createInversionDSFrom(Inversion inversion, CarteraDS carteraDS) {
        InversionDS inversionDS = new InversionDS();
        inversionDS.unidades = inversion.unidades();
        inversionDS.cartera = carteraDS;
        inversionDS.fkIdAccion = inversion.accion().id();
        inversionDS.fkIdEntidadFinanciera = inversion.entidadFinanciera().id();
        return inversionDS;
    }

    @Override
    @Transactional
    public void borrarTodas() {
        Query q = entityManager.createQuery("DELETE FROM " + CarteraDS.class.getSimpleName());
        q.executeUpdate();

    }

    @Override
    public Cartera getById(Long id) {
        throw new UnsupportedOperationException("sin implementar, no es necesario para el ejemplo");
    }

}
