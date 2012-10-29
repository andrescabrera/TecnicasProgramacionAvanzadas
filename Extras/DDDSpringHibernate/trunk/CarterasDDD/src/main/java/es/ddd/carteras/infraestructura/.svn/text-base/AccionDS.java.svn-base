package es.ddd.carteras.infraestructura;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accion")
public class AccionDS {

    @Id @GeneratedValue
    protected Long id;
    protected String nombre;
    protected Long ultimaCotizacionDisponible;

    public AccionDS() {}

    public AccionDS(String nombre, Long ultimaCotizacionDisponible) {
        this.nombre = nombre;
        this.ultimaCotizacionDisponible = ultimaCotizacionDisponible;
    }

    
}
