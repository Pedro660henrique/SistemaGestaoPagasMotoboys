package Model.Repository;

import Model.Bairro;
import Model.Exceptions.BairroInvalidoException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CadastrarBairro {
    private List<Bairro> bairros = new ArrayList<>();

    public CadastrarBairro() {
        // bairros fixos por enquanto
        bairros.add(new Bairro(1, "Centro", new BigDecimal("10.00")));
        bairros.add(new Bairro(2, "Bairro Alto", new BigDecimal("10.00")));
        bairros.add(new Bairro(3, "Jardim", new BigDecimal("10.00")));
    }

    public void listarBairros() {
        for (Bairro b : bairros) {
            System.out.println(b.getId() + " - " + b);
        }
    }

    public Bairro buscarPorId(int id) {
        return bairros.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new BairroInvalidoException("Bairro inválido. ID: " + id));
    }
}
