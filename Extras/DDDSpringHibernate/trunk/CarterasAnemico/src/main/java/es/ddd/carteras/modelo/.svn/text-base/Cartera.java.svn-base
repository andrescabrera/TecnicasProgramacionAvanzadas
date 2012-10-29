package es.ddd.carteras.modelo;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // esta anotaci—n se confunde con el concepto de entidad de DDD
public class Cartera  {

    @Id // detalles de persistencia que oscurecen el dominio
    @GeneratedValue // m‡s detalles de persistencia
    private Long id;
    private String nombre;

    // el fetch type es eager porque es un agregado. Una forma horrible implementar
    // la relaci—n que existe en el modelo.
    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cartera")
    private Collection<Inversion> inversiones = new ArrayList();

    // JPA me obliga a tener este constructor, me guste o no me guste
    protected Cartera() {}

    public Cartera(String nombre) {
        this.nombre = nombre;
    }

    public void nuevaInversion(Accion accion, Long unidades, EntidadFinanciera entidadFinanciera) {
        inversiones.add(new Inversion(unidades, this, accion, entidadFinanciera));
    }

    public Long saldo() {
        long saldo = 0;
        for (Inversion inversion : inversiones) {
            saldo+=inversion.saldo();
        }
        return saldo;
    }

    public Long id() {
        return id;
    }

    public Collection<Inversion> getInversiones() {
        return inversiones;
    }

}
