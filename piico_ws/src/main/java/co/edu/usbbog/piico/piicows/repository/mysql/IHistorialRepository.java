package co.edu.usbbog.piico.piicows.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.usbbog.piico.piicows.model.mysql.Historial;

@Repository
public interface IHistorialRepository extends JpaRepository<Historial, Integer> {

}
