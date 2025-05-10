package com.techdevbrazil.ilearnlabapi.repository;

import com.techdevbrazil.ilearnlabapi.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {


    @Query("SELECT item FROM Resposta item where item.pergunta.id = :perguntaId ")
    public List<Resposta> listarPorPerguntaIde(Long perguntaId);

}
