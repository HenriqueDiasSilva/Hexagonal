package hexagonal.viagens.adaptador.saida;

import hexagonal.viagens.database.DatabaseConnectionProvider;
import hexagonal.viagens.database.H2ConnectionProvider;
import hexagonal.viagens.dominio.Reserva;
import hexagonal.viagens.porta.saida.ReservaVooPortaDeSaida;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ReservaVooAdaptadorDeSaidaRelacional implements ReservaVooPortaDeSaida {
    private DatabaseConnectionProvider connectionProvider;

    public DatabaseConnectionProvider getConnectionProvider() {
        return connectionProvider;
    }

    public void connect(String banco) {
        Connection conn = null;
        Statement stmt = null;

        try {
            if ("H2".equals(banco)) {
                H2ConnectionProvider provider = new H2ConnectionProvider();
                connectionProvider = provider;
                conn = provider.getConnection();
                stmt = conn.createStatement();
                stmt.execute("CREATE TABLE IF NOT EXISTS reservas (" +
                        "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                        "codigoVoo VARCHAR(255), " +
                        "classeAssento VARCHAR(255), " +
                        "dataPartida VARCHAR(255))");
            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void salvarReserva(Reserva reserva) {
        String sql = "INSERT INTO reservas (codigoVoo, classeAssento, dataPartida) VALUES (?, ?, ?)";
        try (Connection conn = connectionProvider.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, reserva.getCodigoVoo());
            pstmt.setString(2, reserva.getClasseAssento());
            pstmt.setDate(3, new java.sql.Date(reserva.getDataPartida().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
