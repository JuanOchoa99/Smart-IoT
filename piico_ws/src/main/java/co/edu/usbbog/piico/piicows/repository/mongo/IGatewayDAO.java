package co.edu.usbbog.piico.piicows.repository.mongo;

import java.util.List;

import org.bson.types.ObjectId;

import co.edu.usbbog.piico.piicows.model.mongo.Gateway;

public interface IGatewayDAO {
	public Gateway create(Gateway gateway);
	public Gateway findById(ObjectId objectId);
	public List<Gateway> find();
	public Gateway edit(Gateway gateway);
	public Gateway remove(Gateway gateway);
}
