package com.techdevbrazil.ilearnlabapi.controller;

import com.techdevbrazil.ilearnlabapi.model.Resposta;
import com.techdevbrazil.ilearnlabapi.service.RespostaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Respostas")
@RestController
@RequestMapping("/respostas")
public class RespostaController {

    private final RespostaService respostaService;

    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }

    @GetMapping
    public ResponseEntity<List<Resposta>> listarTodas(){
        return  ResponseEntity.ok(respostaService.listarTodas());
    }

    @GetMapping("/pergunta/{id}")
    public ResponseEntity<List<Resposta>> listarPorPerguntaId(@PathVariable Long id){
        return  ResponseEntity.ok(respostaService.listarPorPerguntaIde(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resposta> buscarPorId(@PathVariable Long id){
        return  ResponseEntity.ok(respostaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Resposta> salvar(@RequestBody Resposta resposta){
        return  ResponseEntity.status(HttpStatus.CREATED).body(respostaService.salvar(resposta));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void excluir(@PathVariable Long id){
        respostaService.excluir(id);
    }


}
