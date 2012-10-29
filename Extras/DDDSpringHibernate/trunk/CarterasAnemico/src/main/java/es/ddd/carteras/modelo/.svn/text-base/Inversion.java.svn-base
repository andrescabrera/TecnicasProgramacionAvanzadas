package es.ddd.carteras.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Inversion {

    @Id @GeneratedValue
    private Long id;
    private Long unidades;

    @ManyToOne
    @JoinColumn(name="fkIdCartera", nullable = false)
    private Cartera cartera;

    @ManyToOne
    @JoinColumn(name="fkIdAccion", nullable = false)
    private Accion accion;

    @ManyToOne
    @JoinColumn(name="fkIdEntidadFinanciera", nullable = false)
    private EntidadFinanciera entidadFinanciera;

    public Inversion() {
    }

    public Inversion(Long unidades, Cartera cartera, Accion accion, EntidadFinanciera entidadFinanciera) {
        this.unidades = unidades;
        this.cartera = cartera;
        this.accion = accion;
        this.entidadFinanciera = entidadFinanciera;
    }
    

    public Long saldo() {
        return unidades*accion.ultimaCotizacionDisponible();
    }

    public Accion getAccion() {
        return accion;
    }

    public EntidadFinanciera getEntidadFinanciera() {
        return entidadFinanciera;
    }

    public void setUnidades(Long unidades) {
        this.unidades = unidades;
    }

    
}
