package es.ddd.carteras.infraestructura;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="entidadfinanciera")
public class EntidadFinancieraDS {

    @Id @GeneratedValue
    protected Long id;
    protected String nombre;
    protected String servicioDeActualizacion;

    public EntidadFinancieraDS() {}

    EntidadFinancieraDS(String nombre, String servicioDeActualizacion) {
        this.nombre = nombre;
        this.servicioDeActualizacion = servicioDeActualizacion;
    }

    
}
