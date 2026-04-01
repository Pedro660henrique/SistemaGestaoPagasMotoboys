package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "bairros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do bairro é obrigatório")
    @Column(nullable = false, unique = true)
    private String nome;

    @Positive(message = "Valor da taxa deve ser positivo")
    @Column(name = "valor_taxa", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTaxa;

    public Bairro(Integer id, String nome, BigDecimal valorTaxa) {

        if (nome == null || nome.isBlank()) {
            throw new BairroInvalidoException("Nome do bairro inválido");
        }
        if (valorTaxa == null || valorTaxa.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BairroInvalidoException("Valor do bairro inválido");
        }
        this.nome = nome;
        this.valorTaxa = valorTaxa;
    }

    @Override
    public String toString() {
        return nome + " (R$ " + valorTaxa + ")";
    }
}