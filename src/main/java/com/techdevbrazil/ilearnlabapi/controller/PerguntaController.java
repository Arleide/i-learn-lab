package com.techdevbrazil.ilearnlabapi.controller;

import com.techdevbrazil.ilearnlabapi.model.Pergunta;
import com.techdevbrazil.ilearnlabapi.service.PerguntaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Perguntas")
@RestController
@RequestMapping("perguntas")
public class PerguntaController {

    private final PerguntaService perguntaService;

    public PerguntaController(PerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }


    @GetMapping
    public ResponseEntity<List<Pergunta>> listarTodas() {
        return ResponseEntity.ok(perguntaService.listtarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pergunta> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(perguntaService.buscarPorId(id));
    }

    @PostMapping
    public  ResponseEntity<Pergunta> salvar(@RequestBody Pergunta pergunta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perguntaService.salvar(pergunta));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        perguntaService.excluir(id);
    }

}
