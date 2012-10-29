package es.ddd.carteras.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Accion {

    @Id @GeneratedValue
    private Long id;
    private String nombre;
    private Long ultimaCotizacionDisponible;

    public Accion() {}

    public Accion(String nombre, Long ultimaCotizacionDisponible) {
        this.nombre = nombre;
        this.ultimaCotizacionDisponible = ultimaCotizacionDisponible;
    }

    Long ultimaCotizacionDisponible() {
        return ultimaCotizacionDisponible;
    }

    public void setUltimaCotizacionDisponible(Long ultimaCotizacionDisponible) {
        this.ultimaCotizacionDisponible = ultimaCotizacionDisponible;
    }

    

}
