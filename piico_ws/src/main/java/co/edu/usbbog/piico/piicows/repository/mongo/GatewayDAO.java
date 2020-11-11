package co.edu.usbbog.piico.piicows.repository.mongo;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import com.mongodb.Block;
import com.mongodb.DBCursor;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import co.edu.usbbog.piico.piicows.config.ConexionMongo;
import co.edu.usbbog.piico.piicows.model.mongo.Gateway;
import co.edu.usbbog.piico.piicows.model.mongo.Station;
import co.edu.usbbog.piico.piicows.model.mysql.Nodo;

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
		try {
			conexion.conectar();
			mongoDatabase = conexion.getConnection().getDatabase(conexion.getDatabase());
			mongoCollection = mongoDatabase.getCollection("sen_p", Gateway.class).withCodecRegistry(pojoCodecRegistry);
            System.out.println(objectId);
			Gateway gateway = mongoCollection.find(Filters.eq("_id", objectId)).first();
			conexion.desconectar();
			return gateway;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Gateway> find() {
		try {
			conexion.conectar();
			mongoDatabase = conexion.getConnection().getDatabase(conexion.getDatabase());
			mongoCollection = mongoDatabase.getCollection("sen_p", Gateway.class).withCodecRegistry(pojoCodecRegistry);
			List<Gateway> gateways = mongoCollection.find().into(new ArrayList<Gateway>());
			conexion.desconectar();
			return gateways;
		} catch (Exception e) {
			System.out.println("error");
			return new ArrayList<Gateway>();
		}
	}
	
	public List<Gateway> findByNodo(String stationID) {
		try {
			conexion.conectar();
			mongoDatabase = conexion.getConnection().getDatabase(conexion.getDatabase());
			mongoCollection = mongoDatabase.getCollection("sen_p", Gateway.class).withCodecRegistry(pojoCodecRegistry);
			List<Gateway> gateways = mongoCollection.find(Filters.eq("nodos.node_id", stationID)).into(new ArrayList<Gateway>());
			conexion.desconectar();
			System.out.println(""+stationID);
			return gateways;
		} catch (Exception e) {
			System.out.println("error");
			return new ArrayList<Gateway>();
		}
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
