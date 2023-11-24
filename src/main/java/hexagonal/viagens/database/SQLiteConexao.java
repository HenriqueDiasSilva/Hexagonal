package hexagonal.viagens.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConexao implements BancoConexao {
    private static final String JDBC_URL = "jdbc:sqlite:SQLiteBD.db";

    @Override
    public Connection pegarConexao() throws SQLException {
        return DriverManager.getConnection(JDBC_URL);
    }
}