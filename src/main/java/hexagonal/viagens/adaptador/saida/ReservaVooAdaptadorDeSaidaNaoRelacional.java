package hexagonal.viagens.adaptador.saida;

import hexagonal.viagens.database.MongodbConexao;
import hexagonal.viagens.dominio.Reserva;
import hexagonal.viagens.porta.saida.ReservaVooPortaDeSaida;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ReservaVooAdaptadorDeSaidaNaoRelacional implements ReservaVooPortaDeSaida {

    private MongoDatabase database;

    @Override
    public void conectar(String banco) {
        database = MongodbConexao.pegarConexao();
    }

    @Override
    public void salvarReserva(Reserva reserva) {
        MongoCollection<Document> colecao = database.getCollection("reservas");
        Document doc = new Document("id", reserva.getId())
                .append("codigoVoo", reserva.getCodigoVoo())
                .append("classeAssento", reserva.getClasseAssento())
                .append("dataPartida", reserva.getDataPartida());
        colecao.insertOne(doc);
    }

    @Override
    public List<Reserva> procurarTodos() {
        List<Reserva> reservas = new ArrayList<>();
        MongoCollection<Document> colecao = database.getCollection("reservas");

        for (Document doc : colecao.find()) {
            Reserva reserva = new Reserva();
            reserva.setId(doc.getInteger("id"));
            reserva.setCodigoVoo(doc.getString("codigoVoo"));
            reserva.setClasseAssento(doc.getString("classeAssento"));
            reserva.setDataPartida(doc.getString("dataPartida"));
            reservas.add(reserva);
        }

        return reservas;
    }

    @Override
    public void deletarReserva(int id) {
        MongoCollection<Document> colecao = database.getCollection("reservas");
        colecao.deleteOne(new Document("id", id));
    }
}
