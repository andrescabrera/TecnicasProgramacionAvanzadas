package es.ddd.carteras.modelo;

public class ServicioActualizacionCartera {

    private final ServicioActualizacionCotizaciones reuters;
    private final ServicioActualizacionMovimientos eurobits;
    private final ServicioActualizacionMovimientos yoodle;

    public ServicioActualizacionCartera(ServicioActualizacionCotizaciones reuters, ServicioActualizacionMovimientos eurobits, ServicioActualizacionMovimientos yoodle) {
        this.reuters = reuters;
        this.eurobits = eurobits;
        this.yoodle = yoodle;
    }

    public void actualizar(Cartera carteraAActualizar) {
        for (Inversion inversion : carteraAActualizar.getInversiones()) {
            // actualizar los movimientos
            String tipoActualizador = inversion.getEntidadFinanciera().getServicioDeActualizacion();
            Long saldoActual = actualizadorTipo(tipoActualizador).saldoActualDe(inversion.getAccion());
            inversion.setUnidades(saldoActual);

            // actualizar las cotizaciones
            Accion accion = inversion.getAccion();
            Long nuevaCotizacion = reuters.nuevaCotizacionPara(accion);
            accion.setUltimaCotizacionDisponible(nuevaCotizacion);
        }
    }

    private ServicioActualizacionMovimientos actualizadorTipo(String tipo) {
        if ("eurobits".equals(tipo)) {
            return eurobits;

        } else if ("yoodle".equals(tipo)) {
            return yoodle;
        }
        
        throw new RuntimeException("no existe el actualizador: " + tipo);
    }
}
