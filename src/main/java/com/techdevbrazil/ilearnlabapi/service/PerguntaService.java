package com.techdevbrazil.ilearnlabapi.service;

import com.techdevbrazil.ilearnlabapi.model.Pergunta;
import com.techdevbrazil.ilearnlabapi.repository.PerguntaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaService {

    private PerguntaRepository perguntaRepository;

    public PerguntaService(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    public List<Pergunta> listtarTodas(){
        return perguntaRepository.findAll();
    }

    public Pergunta buscarPorId(Long id){
        return perguntaRepository.findById(id).orElse(null);
    }

    public Pergunta salvar(Pergunta pergunta){
        return perguntaRepository.save(pergunta);
    }

    public void excluir(Long id){
        perguntaRepository.deleteById(id);
    }
}
