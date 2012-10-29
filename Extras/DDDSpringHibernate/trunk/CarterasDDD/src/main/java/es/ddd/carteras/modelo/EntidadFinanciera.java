package es.ddd.carteras.modelo;

public class EntidadFinanciera {

    private Long id;
    private String nombre;
    private ServicioActualizacionMovimientos actualizadorMovimientos;

    public EntidadFinanciera(String nombre, ServicioActualizacionMovimientos actualizadorMovimientos) {
        this.nombre = nombre;
        this.actualizadorMovimientos = actualizadorMovimientos;
    }

    Long saldoActualDe(Accion accion) {
        return actualizadorMovimientos.saldoActualDe(accion);
    }

    public ServicioActualizacionMovimientos actualizador() {
        return actualizadorMovimientos;
    }

    public String nombre() {
        return nombre;
    }

    public void Id(Long id) {
        this.id = id;
    }

    public Long id() {
        return id;
    }

}
