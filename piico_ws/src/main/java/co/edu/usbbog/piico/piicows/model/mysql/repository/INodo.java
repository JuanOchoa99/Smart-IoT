package co.edu.usbbog.piico.piicows.model.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import co.edu.usbbog.piico.piicows.model.mysql.Nodo;

@Repository
public interface INodo extends JpaRepository<Nodo, String>{

}
