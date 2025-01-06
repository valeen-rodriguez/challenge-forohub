package com.alura.foro_alura.repository;

import com.alura.foro_alura.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    //busca perfil por nombre
    Optional<Perfil> findByNombre(String nombre);

    //busca perfil por id
    Optional<Perfil> findById(Long id);

    //elimina perfil por nombre
    void deleteByNombre(String nombre);

    @Query("SELECT p FROM Perfil p ORDER BY p.nombre ASC")
    List<Perfil> findAllOrderedByNombre();
}