package es.ddd.carteras.integration;

import es.ddd.carteras.modelo.Cartera;
import es.ddd.carteras.modelo.Accion;
import es.ddd.carteras.modelo.EntidadFinanciera;
import es.ddd.carteras.modelo.RepositorioDeAcciones;
import es.ddd.carteras.modelo.RepositorioDeCarteras;
import es.ddd.carteras.modelo.RepositorioDeEntidadesFinancieras;
import es.ddd.carteras.modelo.ServicioActualizacionCotizaciones;
import es.ddd.carteras.modelo.ServicioActualizacionMovimientos;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@ContextConfiguration("classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ActualizacionCarteraTest {
    public static final String EUROBITS = "eurobits";
    public static final String YOODLE = "yoodle";

    @Autowired private RepositorioDeCarteras repositorioCarteras;
    @Autowired private RepositorioDeAcciones repositorioAcciones;
    @Autowired private RepositorioDeEntidadesFinancieras repositorioDeEntidadesFinancieras;

    private ServicioActualizacionCotizaciones reuters = mock(ServicioActualizacionCotizaciones.class);
    private ServicioActualizacionMovimientos eurobits = mock(ServicioActualizacionMovimientos.class);
    private ServicioActualizacionMovimientos yoodle = mock(ServicioActualizacionMovimientos.class);

    private EntidadFinanciera bankinter = new EntidadFinanciera("bankinter", eurobits);
    private EntidadFinanciera bankOfAmerica = new EntidadFinanciera("Bank of America", yoodle);

    private Accion Yahoo = new Accion("Yahoo", 30l, reuters);
    private Accion Google = new Accion("Google", 35l, reuters);
  
    @Before
    public void setUp() {
       repositorioCarteras.borrarTodas();
       repositorioAcciones.borrarTodas();
       repositorioDeEntidadesFinancieras.borrarTodas();

       insertarAcciones(Yahoo, Google);
       insertarEntidadesFinancieras(bankOfAmerica, bankinter);

       when(eurobits.nombre()).thenReturn(EUROBITS);
       when(yoodle.nombre()).thenReturn(YOODLE);
    }

    @Test
    public void actualizacion_de_carteras() {

        Cartera tecnologicas = new Cartera("tecnologicas");
        tecnologicas.nuevaInversion(Yahoo, 10L, bankOfAmerica);
        tecnologicas.nuevaInversion(Google, 40L, bankinter);
        repositorioCarteras.guardar(tecnologicas);

        when(reuters.nuevaCotizacionPara(Yahoo)).thenReturn(35L);
        when(reuters.nuevaCotizacionPara(Google)).thenReturn(45L);

        when(yoodle.saldoActualDe(Yahoo)).thenReturn(10L);
        when(eurobits.saldoActualDe(Google)).thenReturn(45L);

        tecnologicas.actualizar();

        assertThat(tecnologicas.saldo(), is(2375L));

    }

    private void insertarAcciones(Accion...accion) {
        for (Accion unaAccion : accion) {
            repositorioAcciones.guardar(unaAccion);
        }
    }

    private void insertarEntidadesFinancieras(EntidadFinanciera...entidadFinanciera) {
        for (EntidadFinanciera unaEntidadFinanciera : entidadFinanciera) {
            repositorioDeEntidadesFinancieras.guardar(unaEntidadFinanciera);
        }
    }

}
