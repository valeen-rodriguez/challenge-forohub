package com.alura.foro_alura.service;

import com.alura.foro_alura.model.Topico;
import com.alura.foro_alura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico createTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    public Optional<Topico> getTopicoById(Long id) {
        return topicoRepository.findById(id);
    }

    public Topico updateTopico(Long id, Topico topicoDetails) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isEmpty()) {
            throw new RuntimeException("Tópico no encontrado");
        }

        Topico topico = topicoOptional.get();
        topico.setTitulo(topicoDetails.getTitulo());
        topico.setMensaje(topicoDetails.getMensaje());
        topico.setStatus(topicoDetails.getStatus());
        topico.setCurso(topicoDetails.getCurso());
        topico.setAutor(topicoDetails.getAutor());

        return topicoRepository.save(topico);
    }

    public void deleteTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("Tópico no encontrado");
        }
        topicoRepository.deleteById(id);
    }
}