package industria;

import java.time.LocalDate;

// Classe base Pessoa com nome e data de nascimento
public class Pessoa {

    // Atributos (características) da pessoa
    private String nome;
    private LocalDate dataNascimento;

    // Construtor: método especial chamado ao criar um objeto
    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    // Getters: métodos para acessar os atributos privados
    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    // Setters: métodos para alterar os atributos privados
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}