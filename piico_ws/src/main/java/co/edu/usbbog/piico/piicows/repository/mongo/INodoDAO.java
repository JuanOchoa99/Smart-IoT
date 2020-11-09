package co.edu.usbbog.piico.piicows.repository.mongo;

import java.util.List;

import org.bson.types.ObjectId;

import co.edu.usbbog.piico.piicows.model.mongo.Station;

public interface INodoDAO {
	public Station create(Station station);
	public Station edit(Station station);
	public Station remove(ObjectId objectId);
	public Station findByID(ObjectId objectId);
	public List<Station> find();
}
