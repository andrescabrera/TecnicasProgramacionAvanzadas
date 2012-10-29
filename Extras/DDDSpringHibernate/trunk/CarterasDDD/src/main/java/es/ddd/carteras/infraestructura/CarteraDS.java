package es.ddd.carteras.infraestructura;

import es.ddd.carteras.modelo.Accion;
import es.ddd.carteras.modelo.EntidadFinanciera;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cartera")
public class CarteraDS  {

    @Id 
    @GeneratedValue 
    protected Long id;
    protected String nombre;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cartera")
    protected Collection<InversionDS> inversiones = new ArrayList();

    
   
}
