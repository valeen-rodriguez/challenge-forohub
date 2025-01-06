package com.alura.foro_alura.repository;

import com.alura.foro_alura.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    //busca curso por nombre
    Optional<Curso> findByNombre(String nombre);

    //busca cursos por categoria
    Page<Curso> findByCategoriaContainingIgnoreCase(String categoria, Pageable pageable);

    //busca curso por id
    Optional<Curso> findById(Long id);

    //busca cursos con nombre que tengan una palabra clave
    Page<Curso> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);

    //elimina curso por nombre
    void deleteByNombre(String nombre);

    @Query("SELECT c FROM Curso c WHERE c.categoria = ?1 ORDER BY c.nombre ASC")
    List<Curso> findByCategoriaOrderedByNombre(String categoria);
}