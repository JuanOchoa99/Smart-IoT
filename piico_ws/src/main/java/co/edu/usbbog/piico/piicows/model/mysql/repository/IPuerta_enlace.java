package co.edu.usbbog.piico.piicows.model.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import co.edu.usbbog.piico.piicows.modelo.mysql.PuertaDeEnlace;

@Repository
public interface IPuerta_enlace extends JpaRepository<PuertaDeEnlace, String> {

}
