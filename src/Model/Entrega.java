package Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "entregas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Comanda é obrigatória")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comanda_id", nullable = false)
    private Comanda comanda;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fechamento_id")
    @JsonIgnore
    private FechamentoMotoboy fechamento;

    public Entrega(Comanda comanda) {
        if (comanda == null) {
            throw new EntregaInvalidaException("Comanda não pode ser nula");
        }
        this.comanda = comanda;
        this.valor = comanda.getBairro().getValorTaxa();
    }
    
    @Override
    public String toString() {
        return comanda + " | Valor: R$ " + valor;
    }
}