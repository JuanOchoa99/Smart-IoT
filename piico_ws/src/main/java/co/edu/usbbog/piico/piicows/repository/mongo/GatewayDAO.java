package co.edu.usbbog.piico.piicows.repository.mongo;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.List;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import co.edu.usbbog.piico.piicows.config.ConexionMongo;
import co.edu.usbbog.piico.piicows.model.mongo.Gateway;
import co.edu.usbbog.piico.piicows.model.mongo.Station;

public class GatewayDAO implements IGatewayDAO{
	
	private final ConexionMongo conexion;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Gateway> mongoCollection;
    private final CodecRegistry pojoCodecRegistry;
    
    public GatewayDAO() {
		conexion = new ConexionMongo();
        pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    }

	@Override
	public Gateway create(Gateway gateway) {
		try {
			conexion.conectar();
			mongoDatabase = conexion.getConnection().getDatabase(conexion.getDatabase());
			mongoCollection = mongoDatabase.getCollection("sen_p", Gateway.class).withCodecRegistry(pojoCodecRegistry);
            mongoCollection.insertOne(gateway);
			conexion.desconectar();
			return gateway;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Gateway findById(ObjectId objectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gateway> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gateway edit(Gateway gateway) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gateway remove(Gateway gateway) {
		// TODO Auto-generated method stub
		return null;
	}
    

}
