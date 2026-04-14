package industria;

import java.math.BigDecimal;
import java.time.LocalDate;

// Funcionario ESTENDE Pessoa → herda nome e dataNascimento
public class Funcionario extends Pessoa {

    // Atributos adicionais do funcionário
    private BigDecimal salario;
    private String funcao;

    // Construtor chama o construtor da classe pai (Pessoa) via super()
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento); // chama o construtor de Pessoa
        this.salario = salario;
        this.funcao = funcao;
    }

    // Getters e Setters
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}