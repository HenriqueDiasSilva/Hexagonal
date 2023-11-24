package hexagonal.viagens.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface BancoConexao {
    Connection pegarConexao() throws SQLException;
}
