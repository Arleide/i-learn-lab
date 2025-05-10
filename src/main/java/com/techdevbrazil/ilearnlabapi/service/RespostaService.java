package com.techdevbrazil.ilearnlabapi.service;

import com.techdevbrazil.ilearnlabapi.model.Resposta;
import com.techdevbrazil.ilearnlabapi.repository.RespostaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaService {

    private final RespostaRepository respostaRepository;


    public RespostaService(RespostaRepository respostaRepository) {
        this.respostaRepository = respostaRepository;
    }

    public List<Resposta> listarTodas() {
        return respostaRepository.findAll();
    }

    public List<Resposta> listarPorPerguntaIde(Long perguntaId){
        return respostaRepository.listarPorPerguntaIde(perguntaId);
    }

    public Resposta buscarPorId(Long id) {
        return respostaRepository.findById(id).orElse(null);
    }

    public Resposta salvar(Resposta resposta) {
        return respostaRepository.save(resposta);
    }

    public void excluir(Long id) {
        respostaRepository.deleteById(id);
    }

}
