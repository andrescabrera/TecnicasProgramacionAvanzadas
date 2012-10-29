package es.ddd.carteras.modelo;

public class Accion {

    private Long id;
    private String nombre;
    private Long ultimaCotizacionDisponible;
    private ServicioActualizacionCotizaciones actualizadorCotizacion;

    public Accion(String nombre, Long ultimaCotizacionDisponible, ServicioActualizacionCotizaciones actualizadorCotizacion) {
        this.nombre = nombre;
        this.ultimaCotizacionDisponible = ultimaCotizacionDisponible;
        this.actualizadorCotizacion = actualizadorCotizacion;
    }

    void actualizar() {
        ultimaCotizacionDisponible = actualizadorCotizacion.nuevaCotizacionPara(this);
    }

    Long valorPara(Long unidades) {
        return unidades*ultimaCotizacionDisponible;
    }

    public String nombre() {
        return nombre;
    }

    public Long ultimaCotizacionDisponible() {
        return ultimaCotizacionDisponible;
    }

    public void id(Long id) {
        this.id = id;
    }

    public Long id() {
        return id;
    }
}
