package industria;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {

        // ============================================================
        // 3.1 – INSERIR TODOS OS FUNCIONÁRIOS
        // ============================================================
        // Criamos uma lista que vai guardar objetos do tipo Funcionario
        List<Funcionario> funcionarios = new ArrayList<>();

        // Adicionamos cada funcionário com: nome, data (ano, mês, dia), salário, função
        // LocalDate.of(ano, mês, dia) cria uma data
        // new BigDecimal("valor") cria um número de precisão exata para dinheiro
        funcionarios.add(new Funcionario("Maria",   LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"),  "Operador"));
        funcionarios.add(new Funcionario("João",    LocalDate.of(1990, 5,  12), new BigDecimal("2284.38"),  "Operador"));
        funcionarios.add(new Funcionario("Caio",    LocalDate.of(1961, 5,  2),  new BigDecimal("9836.14"),  "Coordenador"));
        funcionarios.add(new Funcionario("Miguel",  LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice",   LocalDate.of(1995, 1,  5),  new BigDecimal("2234.68"),  "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor",  LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"),  "Operador"));
        funcionarios.add(new Funcionario("Arthur",  LocalDate.of(1993, 3,  31), new BigDecimal("4071.84"),  "Contador"));
        funcionarios.add(new Funcionario("Laura",   LocalDate.of(1994, 7,  8),  new BigDecimal("3017.45"),  "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5,  24), new BigDecimal("1606.85"),  "Eletricista"));
        funcionarios.add(new Funcionario("Helena",  LocalDate.of(1996, 9,  2),  new BigDecimal("2799.93"),  "Gerente"));

        // ============================================================
        // 3.2 – REMOVER O FUNCIONÁRIO "JOÃO"
        // ============================================================
        // removeIf percorre a lista e remove quem satisfizer a condição
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        System.out.println("=======================================================");
        System.out.println(" 3.3 – LISTA DE FUNCIONÁRIOS");
        System.out.println("=======================================================");

        // ============================================================
        // 3.3 – IMPRIMIR TODOS OS FUNCIONÁRIOS FORMATADOS
        // ============================================================
        // Formatador de data: dd/MM/yyyy → ex: 18/10/2000
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Formatador de número: separador de milhar ponto, decimal vírgula (padrão Brasil)
        NumberFormat formatoNumero = NumberFormat.getInstance(new Locale("pt", "BR"));
        formatoNumero.setMinimumFractionDigits(2);
        formatoNumero.setMaximumFractionDigits(2);

        for (Funcionario f : funcionarios) {
            String dataNasc  = f.getDataNascimento().format(formatoData);
            String salarioFmt = formatoNumero.format(f.getSalario());
            System.out.println("Nome: " + f.getNome()
                    + " | Nascimento: " + dataNasc
                    + " | Salário: R$ " + salarioFmt
                    + " | Função: " + f.getFuncao());
        }

        // ============================================================
        // 3.4 – AUMENTO DE 10% NO SALÁRIO
        // ============================================================
        System.out.println("\n=======================================================");
        System.out.println(" 3.4 – SALÁRIOS APÓS AUMENTO DE 10%");
        System.out.println("=======================================================");

        for (Funcionario f : funcionarios) {
            // multiply(1.10) multiplica o salário por 1,10 (ou seja, acrescenta 10%)
            BigDecimal novoSalario = f.getSalario().multiply(new BigDecimal("1.10"));
            f.setSalario(novoSalario);
            System.out.println(f.getNome() + " → Novo salário: R$ " + formatoNumero.format(f.getSalario()));
        }

        // ============================================================
        // 3.5 – AGRUPAR POR FUNÇÃO EM UM MAP
        // ============================================================
        // Collectors.groupingBy agrupa automaticamente pela função
        // O Map terá: chave = "Operador", valor = [lista de operadores], etc.
        Map<String, List<Funcionario>> porFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // ============================================================
        // 3.6 – IMPRIMIR AGRUPADOS POR FUNÇÃO
        // ============================================================
        System.out.println("\n=======================================================");
        System.out.println(" 3.6 – FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO");
        System.out.println("=======================================================");

        // entrySet() retorna cada par (chave, valor) do Map
        for (Map.Entry<String, List<Funcionario>> entrada : porFuncao.entrySet()) {
            System.out.println("\n[ " + entrada.getKey() + " ]");
            for (Funcionario f : entrada.getValue()) {
                System.out.println("  - " + f.getNome()
                        + " | Nascimento: " + f.getDataNascimento().format(formatoData)
                        + " | Salário: R$ " + formatoNumero.format(f.getSalario()));
            }
        }

        // ============================================================
        // 3.8 – FUNCIONÁRIOS QUE FAZEM ANIVERSÁRIO NOS MESES 10 E 12
        // ============================================================
        System.out.println("\n=======================================================");
        System.out.println(" 3.8 – ANIVERSARIANTES DOS MESES 10 (OUT) E 12 (DEZ)");
        System.out.println("=======================================================");

        for (Funcionario f : funcionarios) {
            int mes = f.getDataNascimento().getMonthValue(); // getMonthValue() retorna número do mês
            if (mes == 10 || mes == 12) {
                System.out.println(f.getNome() + " – " + f.getDataNascimento().format(formatoData));
            }
        }

        // ============================================================
        // 3.9 – FUNCIONÁRIO MAIS VELHO
        // ============================================================
        System.out.println("\n=======================================================");
        System.out.println(" 3.9 – FUNCIONÁRIO COM MAIOR IDADE");
        System.out.println("=======================================================");

        // Comparamos as datas: a menor data = pessoa mais velha
        Funcionario maisVelho = funcionarios.get(0); // começa assumindo que o primeiro é o mais velho
        for (Funcionario f : funcionarios) {
            if (f.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = f;
            }
        }

        // Period.between calcula a diferença entre duas datas e getYears() pega os anos
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("Nome: " + maisVelho.getNome() + " | Idade: " + idade + " anos");

        // ============================================================
        // 3.10 – LISTA ALFABÉTICA
        // ============================================================
        System.out.println("\n=======================================================");
        System.out.println(" 3.10 – FUNCIONÁRIOS EM ORDEM ALFABÉTICA");
        System.out.println("=======================================================");

        // Criamos uma cópia da lista para não alterar a original
        List<Funcionario> listaAlfabetica = new ArrayList<>(funcionarios);
        // sort + Comparator.comparing ordena pelo critério dado (nome)
        listaAlfabetica.sort(Comparator.comparing(Funcionario::getNome));

        for (Funcionario f : listaAlfabetica) {
            System.out.println(f.getNome());
        }

        // ============================================================
        // 3.11 – TOTAL DOS SALÁRIOS
        // ============================================================
        System.out.println("\n=======================================================");
        System.out.println(" 3.11 – TOTAL DOS SALÁRIOS");
        System.out.println("=======================================================");

        BigDecimal totalSalarios = BigDecimal.ZERO; // começa do zero
        for (Funcionario f : funcionarios) {
            totalSalarios = totalSalarios.add(f.getSalario()); // vai somando cada salário
        }
        System.out.println("Total: R$ " + formatoNumero.format(totalSalarios));

        // ============================================================
        // 3.12 – QUANTOS SALÁRIOS MÍNIMOS CADA UM GANHA
        // ============================================================
        System.out.println("\n=======================================================");
        System.out.println(" 3.12 – SALÁRIOS MÍNIMOS POR FUNCIONÁRIO");
        System.out.println("=======================================================");

        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        for (Funcionario f : funcionarios) {
            // divide o salário do funcionário pelo mínimo, com 2 casas decimais
            BigDecimal qtdSalarios = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " → " + formatoNumero.format(qtdSalarios) + " salários mínimos");
        }
    }
}