package com.alura.foro_alura.repository;

import com.alura.foro_alura.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
    
    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);
}