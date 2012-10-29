package es.ddd.carteras.infraestructura;

import es.ddd.carteras.modelo.Cartera;
import es.ddd.carteras.modelo.Repositorio;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

public abstract class RepositorioJPA<T> implements Repositorio<T> {

    private Class<T> persistentClass;
    private EntityManager entityManager;

    public RepositorioJPA() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                        .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void guardar(T t) {
        entityManager.persist(t);
    }

    @Override
    @Transactional
    public void borrarTodas() {
        Query q = entityManager.createQuery("DELETE FROM " + claseAPersistir().getSimpleName());
        q.executeUpdate();
    }

    @Override
    @Transactional
    public T getById(Long id) {
        return entityManager.find(persistentClass, id);
    }

    public abstract Class claseAPersistir();
   

}
