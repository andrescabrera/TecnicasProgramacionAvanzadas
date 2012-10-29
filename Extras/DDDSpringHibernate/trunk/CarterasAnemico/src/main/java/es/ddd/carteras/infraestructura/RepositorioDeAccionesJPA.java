package es.ddd.carteras.infraestructura;

import es.ddd.carteras.modelo.Accion;
import es.ddd.carteras.modelo.RepositorioDeAcciones;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDeAccionesJPA extends RepositorioJPA<Accion> implements RepositorioDeAcciones  {

    @Override
    public Class claseAPersistir() {
        return Accion.class;
    }



    
}
