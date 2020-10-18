package co.edu.usbbog.piico.piicows.repository;

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
import co.edu.usbbog.piico.piicows.model.mongo.Nodo;


public class NodoDAO implements INodoDAO {
	
	private final ConexionMongo conexion;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Nodo> mongoCollection;
    private final CodecRegistry pojoCodecRegistry;
    
    

	public NodoDAO() {
		conexion = new ConexionMongo();
        pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
	}

	@Override
	public Nodo create(Nodo nodo) {
		try {
			conexion.conectar();
			mongoDatabase = conexion.getConnection().getDatabase(conexion.getDatabase());
			mongoCollection = mongoDatabase.getCollection("sen_p", Nodo.class).withCodecRegistry(pojoCodecRegistry);
            mongoCollection.insertOne(nodo);
			conexion.desconectar();
			return nodo;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Nodo edit(Nodo nodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nodo remove(ObjectId objectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nodo findByID(ObjectId objectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nodo> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
