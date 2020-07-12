package com.usbbog.piico.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usbbog.piico.model.Usuarios;

public interface IUsuarios extends JpaRepository<Usuarios, String>{

}
