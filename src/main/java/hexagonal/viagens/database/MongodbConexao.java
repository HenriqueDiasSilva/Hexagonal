package hexagonal.viagens.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongodbConexao {
    private static final String connectionString = "mongodb+srv://henriquedias:FkNFXxDvUVKsQtdg@cluster0.qhkauqb.mongodb.net/?retryWrites=true&w=majority";
    private static final String DATABASE_NAME = "reservasDb";

    public static MongoDatabase pegarConexao() {
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        MongoClient mongoClient = MongoClients.create(settings);
        return mongoClient.getDatabase(DATABASE_NAME);
    }
}
