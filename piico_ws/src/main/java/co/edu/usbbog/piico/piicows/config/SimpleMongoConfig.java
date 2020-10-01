package co.edu.usbbog.piico.piicows.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


public class SimpleMongoConfig {

    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/piico_db");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
          .applyConnectionString(connectionString)
          .build();
        
        return MongoClients.create(mongoClientSettings);
    }
 

    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "piico_db");
    }
}

