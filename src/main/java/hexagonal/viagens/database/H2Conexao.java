package hexagonal.viagens.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Conexao implements BancoConexao {
    private static final String JDBC_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";

    @Override
    public Connection pegarConexao() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, "sa", "");
    }
}