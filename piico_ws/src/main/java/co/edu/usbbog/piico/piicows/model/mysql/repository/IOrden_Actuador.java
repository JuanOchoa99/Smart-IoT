package co.edu.usbbog.piico.piicows.model.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrden_Actuador extends JpaRepository<IOrden_Actuador, String>{
 
}
