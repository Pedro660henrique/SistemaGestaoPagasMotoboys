package Model;

import Exceptions.BairroInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class CadastrarBairro {
    private List<Bairro> bairros = new ArrayList<>();

    public CadastrarBairro() {
        // bairros fixos por enquanto
        bairros.add(new Bairro(1, "Centro", 10.0));
        bairros.add(new Bairro(2, "Bairro Alto", 12.0));
        bairros.add(new Bairro(3, "Jardim", 15.0));
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
