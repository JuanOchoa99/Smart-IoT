package co.edu.usbbog.piico.piicows.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import co.edu.usbbog.piico.piicows.model.mongo.GPS;

public interface IGPSMongoRepository extends MongoRepository<GPS, ObjectId>{

}
