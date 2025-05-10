package com.techdevbrazil.ilearnlabapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "respostas")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String texto;

    private boolean correta;

    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Pergunta pergunta;

}
