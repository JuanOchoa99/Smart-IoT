package co.edu.usbbog.piico.piicows.repository.mongo;

import java.util.List;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.util.ArrayList;
import java.util.List;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import co.edu.usbbog.piico.piicows.config.ConexionMongo;
import co.edu.usbbog.piico.piicows.model.mongo.Station;


public class NodoDAO implements INodoDAO {
	
	private final ConexionMongo conexion;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Station> mongoCollection;
    private final CodecRegistry pojoCodecRegistry;
    
    

	public NodoDAO() {
		conexion = new ConexionMongo();
        pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
	}

	@Override
	public Station create(Station station) {
		try {
			conexion.conectar();
			mongoDatabase = conexion.getConnection().getDatabase(conexion.getDatabase());
			mongoCollection = mongoDatabase.getCollection("sen_p", Station.class).withCodecRegistry(pojoCodecRegistry);
            mongoCollection.insertOne(station);
			conexion.desconectar();
			return station;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Station edit(Station station) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Station remove(ObjectId objectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Station findByID(ObjectId objectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Station> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
