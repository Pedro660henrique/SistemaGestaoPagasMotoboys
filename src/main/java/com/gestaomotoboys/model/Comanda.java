package com.gestaomotoboys.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Table(name = "comandas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "numeroComanda")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "Número da comanda deve ser positivo")
    @Column(name = "numero_comanda", nullable = false, unique = true)
    private Integer numeroComanda;

    @NotNull(message = "Bairro é obrigatório")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bairro_id", nullable = false)
    private Bairro bairro;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    public Comanda(Integer numeroComanda, Bairro bairro) {

        if (numeroComanda == null || numeroComanda <= 0) {
            throw new IllegalArgumentException("Número da comanda inválido");
        }
        if (bairro == null) {
            throw new IllegalArgumentException("Bairro não informado");
        }
        this.numeroComanda = numeroComanda;
        this.bairro = bairro;
    }

    public void alterarBairro(Bairro novoBairro) {
        if (novoBairro == null)
            throw new IllegalArgumentException("Novo bairro inválido");
        this.bairro = novoBairro;
    }

    @Override
    public String toString() {
        return "Comanda " + numeroComanda +
                " | Bairro: " + bairro +
                (observacao != null ? " | Obs: " + observacao : "");
    }
}