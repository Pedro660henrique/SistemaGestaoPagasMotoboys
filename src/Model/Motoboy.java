package Model;

public class Motoboy {

    private int id;
    private String nome;

    public Motoboy(int id, String nome) {

        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome do motoboy inválido");

        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}