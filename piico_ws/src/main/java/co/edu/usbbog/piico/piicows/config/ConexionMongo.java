package co.edu.usbbog.piico.piicows.config;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;

public class ConexionMongo {
    private final String host;
    private final int port;
    private final String database;
    private final String user;
    private final String password;
    private MongoClient connection;

    public ConexionMongo() {
        this.host = "localhost";
        this.port = 27017;
        this.database = "piico_db";
        this.user = "";
        this.password = "";
        this.connection = null;
    }

    public MongoClient conectar() {
        try {
            String path = "mongodb://"
                    + user
                    + ":"
                    + password
                    + "@"
                    + host
                    + ":"
                    + port
                    + "/?authSource="
                    + database
                    + "&authMechanism=SCRAM-SHA-1";
            //roboMongoClientURI uri = new MongoClientURI(path);
            //connection = new MongoClient(uri);
            connection = new MongoClient(host, port);
            System.out.println("Se conecto");
        } catch (Exception ex) {
            System.out.println("No se conecto");
            System.out.println("Exception: " + ex.getMessage());
        }
        return connection;
    }
    
    public void desconectar() {
        try {
            this.connection.close();
            System.out.println("Se desconecto");
        } catch (Exception ex) {
            System.out.println("No se desconecto");
            System.out.println("Exception: " + ex.getMessage());
        }
        this.connection = null;
    }

    public MongoClient getConnection() {
        return connection;
    }    

    public String getDatabase() {
        return database;
    }    
}
