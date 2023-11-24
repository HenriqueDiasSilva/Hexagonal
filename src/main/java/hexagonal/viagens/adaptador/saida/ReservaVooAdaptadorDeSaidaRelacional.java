package hexagonal.viagens.adaptador.saida;

import hexagonal.viagens.database.BancoConexao;
import hexagonal.viagens.database.H2Conexao;
import hexagonal.viagens.database.SQLiteConexao;
import hexagonal.viagens.dominio.Reserva;
import hexagonal.viagens.porta.saida.ReservaVooPortaDeSaida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReservaVooAdaptadorDeSaidaRelacional implements ReservaVooPortaDeSaida {
    private BancoConexao conexao;

    @Override
    public void conectar(String banco) {

        if ("H2".equals(banco)) {
            H2Conexao provedor = new H2Conexao();
            conexao = provedor;
        } else {
            SQLiteConexao provedor = new SQLiteConexao();
            conexao = provedor;
        }

        try (Connection conn = conexao.pegarConexao();
                Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS reservas (" +
                    "id INTEGER PRIMARY KEY, " +
                    "codigoVoo VARCHAR(255), " +
                    "classeAssento VARCHAR(255), " +
                    "dataPartida VARCHAR(255))";
            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void salvarReserva(Reserva reserva) {
        String sql = "INSERT INTO reservas (id, codigoVoo, classeAssento, dataPartida) VALUES (?, ?, ?, ?)";
        try (Connection conn = conexao.pegarConexao();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reserva.getId());
            pstmt.setString(2, reserva.getCodigoVoo());
            pstmt.setString(3, reserva.getClasseAssento());
            pstmt.setString(4, reserva.getDataPartida());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reserva> procurarTodos() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservas";

        try (Connection conn = conexao.pegarConexao();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String codigoVoo = rs.getString("codigoVoo");
                String classeAssento = rs.getString("classeAssento");
                String dataPartida = rs.getString("dataPartida");

                Reserva reserva = new Reserva();
                reserva.setId(id);
                reserva.setCodigoVoo(codigoVoo);
                reserva.setClasseAssento(classeAssento);
                reserva.setDataPartida(dataPartida);

                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservas;
    }

    @Override
    public void deletarReserva(int id) {
        String sql = "DELETE FROM reservas WHERE id = ?";

        try (Connection conn = conexao.pegarConexao();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
