package com.alura.foro_alura.repository;

import com.alura.foro_alura.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //buscar usuario por correo electrónico
    Optional<Usuario> findByCorreoElectronico(String correoElectronico);

    //buscar usuario por login
    Optional<Usuario> findByLogin(String login);

    //buscar usuario por id
    Optional<Usuario> findById(Long id);

    //buscar usuarios asociados a un perfil
    @Query("SELECT u FROM Usuario u WHERE u.perfil.id = ?1")
    List<Usuario> findByPerfilId(Long perfilId);

    //eliminar usuario por login
    void deleteByLogin(String login);

    boolean existsByLogin(String login);
}