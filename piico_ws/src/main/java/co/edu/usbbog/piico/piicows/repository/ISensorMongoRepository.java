package co.edu.usbbog.piico.piicows.repository;

import co.edu.usbbog.piico.piicows.model.mongo.Sensor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ISensorMongoRepository extends MongoRepository<Sensor, ObjectId>{

}
