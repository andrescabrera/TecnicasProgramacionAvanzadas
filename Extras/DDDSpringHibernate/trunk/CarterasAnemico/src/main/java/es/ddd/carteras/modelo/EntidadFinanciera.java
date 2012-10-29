package es.ddd.carteras.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EntidadFinanciera {

    @Id @GeneratedValue
    private Long id;
    private String nombre;
    private String servicioDeActualizacion;

    public EntidadFinanciera() {}

    public EntidadFinanciera(String nombre, String servicioDeActualizacion) {
        this.nombre = nombre;
        this.servicioDeActualizacion = servicioDeActualizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getServicioDeActualizacion() {
        return servicioDeActualizacion;
    }

    

}
