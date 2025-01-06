package com.alura.foro_alura.service;

import com.alura.foro_alura.model.Usuario;
import com.alura.foro_alura.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //crear nuevo usuario
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //obtiene usuario por id
    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    //actualizar los detalles de un usuario
    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Usuario usuario = usuarioOptional.get();
        usuario.setLogin(usuarioDetails.getLogin());
        usuario.setClave(usuarioDetails.getClave());
        usuario.setPerfil(usuarioDetails.getPerfil());

        return usuarioRepository.save(usuario);
    }

    //eliminar usuario por id
    public void deleteUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    //obtiene usuario por login
    public Optional<Usuario> getUsuarioByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    //obtiene usuario por correo electronico
    public Optional<Usuario> getUsuarioByCorreoElectronico(String correoElectronico) {
        return usuarioRepository.findByCorreoElectronico(correoElectronico);
    }

    //obtiene lista de usuarios por perfil
    public List<Usuario> getUsuariosByPerfilId(Long perfilId) {
        return usuarioRepository.findByPerfilId(perfilId);
    }
}