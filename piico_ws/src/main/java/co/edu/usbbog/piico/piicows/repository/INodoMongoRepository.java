package co.edu.usbbog.piico.piicows.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.usbbog.piico.piicows.model.mongo.Nodo;
@Repository
public interface INodoMongoRepository extends MongoRepository<Nodo, ObjectId>{

}
