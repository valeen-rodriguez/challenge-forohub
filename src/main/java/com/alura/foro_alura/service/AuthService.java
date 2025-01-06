package com.alura.foro_alura.service;

import com.alura.foro_alura.dto.AuthRequest;
import com.alura.foro_alura.dto.AuthResponse;
import com.alura.foro_alura.model.Usuario;
import com.alura.foro_alura.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AuthResponse authenticate(AuthRequest authRequest) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreoElectronico(authRequest.getEmail());

        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        //verifica la clave
        if (!passwordEncoder.matches(authRequest.getPassword(), usuario.getClave())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        //genera el token jwt
        String token = jwtService.generateToken(usuario);

        return new AuthResponse(token);
    }
}