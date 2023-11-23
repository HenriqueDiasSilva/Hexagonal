package hexagonal;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hexagonal.viagens.adaptador.saida.ReservaVooAdaptadorDeSaidaRelacional;
import hexagonal.viagens.dominio.Reserva;;

public class ReservaVooAdaptadorDeSaidaTest {
    private ReservaVooAdaptadorDeSaidaRelacional adaptador;

    @BeforeEach
    public void setUp() throws Exception {
        adaptador = new ReservaVooAdaptadorDeSaidaRelacional();
        adaptador.connect("H2");
    }

    @Test
    public void testSaveReserve() throws Exception {
        Reserva reserva = new Reserva();
        reserva.setCodigoVoo("Voo123");
        reserva.setClasseAssento("Economica");
        reserva.setDataPartida(new Date());

        adaptador.salvarReserva(reserva);
    }
}
