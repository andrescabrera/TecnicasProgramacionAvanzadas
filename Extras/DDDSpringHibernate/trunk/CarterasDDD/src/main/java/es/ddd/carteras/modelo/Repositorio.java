package es.ddd.carteras.modelo;

public interface Repositorio<T> {
    void guardar(T t);
    void borrarTodas();
    T getById(Long id);
}
