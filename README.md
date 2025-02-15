# Teste de Programação em Java - INIFLEX/GUPY.IO

## Descrição

Código do teste do Gupy.IO.

Desenvolvedor: Miguel Assunção Queiroz (Bit.Raiden)

## Uso

Execute o arquivo `Main.java` com o JRE em um console (de preferência CMD do Windows), usando o comando:
`java Main.java`
Selecione uma das opções para executar as instruções pedidas e faça suas considerações.

## Script Original

1. **Classe Pessoa**:
   - Atributos: `nome` (String) e `data nascimento` (LocalDate).

2. **Classe Funcionário**:
   - Estende a classe Pessoa.
   - Atributos: `salário` (BigDecimal) e `função` (String).

3. **Classe Principal**:
   - Executa as seguintes ações:
     1. Inserir todos os funcionários, na mesma ordem e informações da tabela fornecida.
     2. Remover o funcionário “João” da lista.
     3. Imprimir todos os funcionários com todas suas informações, com as seguintes formatações:
        - Data no formato `dd/MM/yyyy`.
        - Valores numéricos com separador de milhar como ponto e decimal como vírgula.
     4. Aplicar um aumento de 10% no salário de todos os funcionários e atualizar a lista.
     5. Agrupar os funcionários por função em um `Map`, sendo a chave a “função” e o valor a “lista de funcionários”.
     6. Imprimir os funcionários, agrupados por função.
     7. Imprimir os funcionários que fazem aniversário nos meses de outubro (10) e dezembro (12).
     8. Imprimir o funcionário com a maior idade, exibindo os atributos: nome e idade.
     9. Imprimir a lista de funcionários em ordem alfabética.
     10. Imprimir o total dos salários dos funcionários.
     11. Imprimir quantos salários mínimos cada funcionário ganha, considerando que o salário mínimo é R$1212,00.

## Exemplo de Execução

```plaintext
java Main.java

Teste de Programação JAVA Iniflex/Gupy
------------------------

Digite o número da operação e aperte ENTER para continuar:

1 - Imprimir a Lista de Funcionários
2 - Immprimir e Agrupar por Função
3 - Lista de Aniversariantes [Outubro e Dezembro]
4 - O Funcionário mais Velho de Idade
5 - Imprimir [A a Z]
6 - Imprimir o Total dos Salários
7 - Imprimir [Quantidade de Salários Mínimos]

0 - Sair

Digite o código da operação:

