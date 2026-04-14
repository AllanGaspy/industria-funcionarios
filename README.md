# 🏭 Indústria - Gestão de Funcionários

Projeto Java desenvolvido como **teste prático** de programação, com o objetivo de gerenciar uma lista de funcionários de uma indústria, aplicando conceitos de orientação a objetos e manipulação de dados.

---

## 📋 Sobre o Projeto

O sistema realiza diversas operações sobre uma lista de funcionários, como inserção, remoção, agrupamento, ordenação e cálculos salariais.

---

## 🗂️ Estrutura das Classes

| Classe | Descrição |
|---|---|
| `Pessoa` | Classe base com os atributos `nome` e `dataNascimento` |
| `Funcionario` | Estende `Pessoa`, adicionando `salário` e `função` |
| `Principal` | Classe main — executa todas as operações do sistema |

---

## ⚙️ Funcionalidades Implementadas

- ✅ Inserção de todos os funcionários conforme tabela fornecida
- ✅ Remoção de funcionário específico da lista
- ✅ Listagem formatada (data em dd/MM/yyyy e salário com separador brasileiro)
- ✅ Aumento de 10% no salário de todos os funcionários
- ✅ Agrupamento de funcionários por função usando `Map`
- ✅ Impressão dos funcionários agrupados por função
- ✅ Filtro de aniversariantes nos meses de outubro e dezembro
- ✅ Identificação do funcionário mais velho com sua idade
- ✅ Listagem em ordem alfabética
- ✅ Cálculo do total de salários
- ✅ Cálculo de quantos salários mínimos cada funcionário recebe

---

## 🛠️ Tecnologias Utilizadas

- Java 11+
- `LocalDate` para manipulação de datas
- `BigDecimal` para precisão nos cálculos de salário
- `ArrayList` e `Map` para estruturas de dados
- `Stream API` para agrupamento e ordenação

---

## ▶️ Como Executar

1. Clone ou baixe os arquivos do projeto
2. Abra o Eclipse (ou a IDE de sua preferência)
3. Crie um novo projeto Java e um pacote chamado `industria`
4. Adicione os 3 arquivos `.java` dentro do pacote
5. Execute a classe `Principal.java` como **Java Application**

