package co.edu.usbbog.piico.piicows.repository.mongo;

import java.util.List;

import org.bson.types.ObjectId;

import co.edu.usbbog.piico.piicows.model.mongo.Nodo;

public interface INodoDAO {
	public Nodo create(Nodo nodo);
	public Nodo edit(Nodo nodo);
	public Nodo remove(ObjectId objectId);
	public Nodo findByID(ObjectId objectId);
	public List<Nodo> find();
}
