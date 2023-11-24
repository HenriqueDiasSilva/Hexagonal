package hexagonal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hexagonal.viagens.adaptador.saida.ReservaVooAdaptadorDeSaidaRelacional;
import hexagonal.viagens.adaptador.saida.ReservaVooAdaptadorDeSaidaNaoRelacional;
import hexagonal.viagens.dominio.Reserva;

public class ReservaVooAdaptadorDeSaidaTest {
    private ReservaVooAdaptadorDeSaidaRelacional adaptador;

    @BeforeEach
    public void setUp() throws Exception {
        adaptador = new ReservaVooAdaptadorDeSaidaRelacional();
        adaptador.conectar("SQLite");
    }

    @Test
    public void testSalvarReserva() throws Exception {
        Reserva reserva = new Reserva();
        reserva.setId(0);
        reserva.setCodigoVoo("Voo123");
        reserva.setClasseAssento("Economica");
        reserva.setDataPartida("22/12/2023");

        Reserva reserva1 = new Reserva();
        reserva1.setId(1);
        reserva1.setCodigoVoo("Voo1");
        reserva1.setClasseAssento("Ec");
        reserva1.setDataPartida("22/12/2029");

        adaptador.salvarReserva(reserva);
        adaptador.salvarReserva(reserva1);

        // testSalvarReserva();
    }

    @Test
    void testProcurarTodos() throws Exception {
        // testSalvarReserva();

        List<Reserva> reservas = adaptador.procurarTodos();

        assertFalse(reservas.isEmpty());

        assertEquals(2, reservas.size());

        Reserva reservaTeste = reservas.get(0);
        assertEquals("Voo123", reservaTeste.getCodigoVoo());
        assertEquals("Economica", reservaTeste.getClasseAssento());
    }

    @Test
    void testDeletarReserva() throws Exception {
        adaptador.deletarReserva(0);

        // testProcurarTodos();
    }
}
