package hexagonal.viagens.porta.saida;

import java.util.List;

import hexagonal.viagens.dominio.Reserva;

public interface ReservaVooPortaDeSaida {
    void conectar(String banco);

    void salvarReserva(Reserva reserva);

    List<Reserva> procurarTodos();

    void deletarReserva(int id);
}
