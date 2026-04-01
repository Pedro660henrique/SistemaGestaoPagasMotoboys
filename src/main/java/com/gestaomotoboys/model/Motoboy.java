package com.gestaomotoboys.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "motoboys")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Motoboy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do motoboy é obrigatório")
    @Column(nullable = false)
    private String nome;

    public Motoboy(int id, String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do motoboy inválido");
        }
        this.nome = nome;
    }
}