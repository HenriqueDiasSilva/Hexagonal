package hexagonal.viagens.porta.saida;

import hexagonal.viagens.dominio.Reserva;

public interface ReservaVooPortaDeSaida {
    void connect(String banco);

    void salvarReserva(Reserva reserva);

    // void findAll();

    // void Delete(Reserva reserva);
}
