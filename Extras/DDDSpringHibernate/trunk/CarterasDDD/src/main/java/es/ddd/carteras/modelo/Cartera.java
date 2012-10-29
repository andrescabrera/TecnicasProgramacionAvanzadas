package es.ddd.carteras.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Cartera {

    private Collection<Inversion> inversiones;
    private String nombre;

    public Cartera(Collection<Inversion> inversiones, String nombre) {
        this.inversiones = inversiones;
        this.nombre = nombre;
    }

    public Cartera(String nombre) {
        this.nombre = nombre;
        this.inversiones = new ArrayList();
    }

    public void actualizar() {
        for (Inversion inversion : inversiones) {
            inversion.actualizar();
        }
    }

    public Long saldo() {
        long saldo = 0;
        for (Inversion inversion : inversiones) {
            saldo+=inversion.saldo();
        }
        return saldo;
    }

    public void nuevaInversion(Accion Yahoo, long l, EntidadFinanciera bankOfAmerica) {
        inversiones.add(new Inversion(l, Yahoo, bankOfAmerica));
    }

    public String nombre() {
        return nombre;
    }

    public Collection<Inversion> inversiones() {
        return Collections.unmodifiableCollection(inversiones);
    }

}
