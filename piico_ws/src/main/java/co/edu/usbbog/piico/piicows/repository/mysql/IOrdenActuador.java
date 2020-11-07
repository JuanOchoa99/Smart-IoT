package co.edu.usbbog.piico.piicows.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.usbbog.piico.piicows.model.mysql.Ordenactuador;
import co.edu.usbbog.piico.piicows.model.mysql.OrdenactuadorPK;


@Repository
public interface IOrdenActuador extends JpaRepository<Ordenactuador, OrdenactuadorPK>{
 
}
