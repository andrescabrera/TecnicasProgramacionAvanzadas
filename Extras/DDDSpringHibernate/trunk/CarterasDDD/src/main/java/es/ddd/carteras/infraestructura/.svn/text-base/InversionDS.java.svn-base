package es.ddd.carteras.infraestructura;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="inversion")
public class InversionDS {

    @Id @GeneratedValue
    protected Long id;
    protected Long unidades;
    protected Long fkIdAccion;
    protected Long fkIdEntidadFinanciera;

    @ManyToOne
    @JoinColumn(name="fkIdCartera", nullable = false)
    protected CarteraDS cartera;
    


}
