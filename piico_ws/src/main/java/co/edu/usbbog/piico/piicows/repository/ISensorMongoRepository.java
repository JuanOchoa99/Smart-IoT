package co.edu.usbbog.piico.piicows.repository;

import co.edu.usbbog.piico.piicows.model.mongo.Sensor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISensorMongoRepository extends MongoRepository<Sensor, ObjectId>{

}
