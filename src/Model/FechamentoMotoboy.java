package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fechamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class FechamentoMotoboy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Motoboy é obrigatório")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motoboy_id", nullable = false)
    private Motoboy motoboy;

    @Column(name = "hora_entrada", nullable = false)
    private LocalTime horaEntrada;

    @Column(name = "hora_saida", nullable = false)
    private LocalTime horaSaida;

    @PositiveOrZero(message = "Paga deve ser positivo ou zero")
    @Column(name = "paga", nullable = false, precision = 10, scale = 2)
    private BigDecimal paga;

    @OneToMany(mappedBy = "fechamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Entrega> entregas;

    @Column(name = "fechado", nullable = false)
    private boolean fechado;

    public FechamentoMotoboy(
            Motoboy motoboy,
            LocalTime horaEntrada,
            LocalTime horaSaida,
            BigDecimal paga) {

        this.motoboy = motoboy;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.paga = paga;
        this.entregas = new ArrayList<>();
        this.fechado = false;
    }

    public void adicionarEntrega(Entrega entrega) {
        if (fechado)
            throw new IllegalStateException("Fechamento já encerrado");
        entregas.add(entrega);
    }

    public void alterarPaga(BigDecimal novaPaga) {
        this.paga = novaPaga;
    }

    public void fechar() {
        if (entregas.isEmpty())
            throw new IllegalStateException("Não é possível fechar sem entregas");
        this.fechado = true;
    }

    public int getQuantidadeEntregas() {
        return entregas.size();
    }

    public BigDecimal totalEntregas() {
        return entregas.stream()
                .map(Entrega::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal totalGeral() {
        return totalEntregas().add(paga);
    }

    public void imprimirRelatorio() {

        System.out.println("\nMotoboy: " + motoboy.getNome());
        System.out.println("Horário: " + horaEntrada + " às " + horaSaida);
        System.out.println("Entregas: " + getQuantidadeEntregas());

        entregas.forEach(System.out::println);

        System.out.println("Total entregas: R$ " + totalEntregas());
        System.out.println("Paga turno: R$ " + paga);
        System.out.println("TOTAL GERAL: R$ " + totalGeral());
    }
}