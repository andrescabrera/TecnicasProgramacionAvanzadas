package es.ddd.carteras.modelo;

public class Inversion {

    private Long unidades;
    private Accion accion;
    private EntidadFinanciera entidadFinanciera;

    public Inversion(Long unidades, Accion accion, EntidadFinanciera entidadFinanciera) {
        this.unidades = unidades;
        this.accion = accion;
        this.entidadFinanciera = entidadFinanciera;
    }

    void actualizar() {
        accion.actualizar();
        this.unidades = entidadFinanciera.saldoActualDe(accion);
    }

    Long saldo() {
        return accion.valorPara(unidades);
    }

    public Accion accion() {
        return accion;
    }

    public EntidadFinanciera entidadFinanciera() {
        return entidadFinanciera;
    }

    public Long unidades() {
        return unidades;
    }

}
