# Sistema de Cadastro de Alunos

Projeto desenvolvido para a atividade A3 da disciplina de Programação Orientada a Objetos.

## Integrantes

- Caio Augusto Vicente da Cruz
- Mauricio Cosme Abraham Lavin
- Vinicius Henrique Santos Mendes
- Jonatas Natanael Antunes Oliveira
- João Lucas Queiroz

## Descrição

O sistema permite realizar o cadastro e gerenciamento de alunos por meio de um menu no terminal. Os dados são armazenados em um banco SQLite e podem ser consultados, alterados ou removidos posteriormente.

Além disso, o projeto utiliza a API da Groq para auxiliar na validação das informações cadastradas.

## Funcionalidades

- Cadastrar aluno
- Consultar aluno pela matrícula
- Atualizar cadastro
- Excluir aluno
- Listar alunos cadastrados
- Gerar matrícula automaticamente

## Tecnologias utilizadas

- Java
- SQLite
- JDBC
- API Groq

## Estrutura do projeto

```text
src/
├── Aluno.java
├── Pessoa.java
├── GerenciadorAluno.java
├── BancoDeDados.java
├── InteligenciaArtificial.java
├── Terminal.java
└── app.java
```

## Como executar

Clone o repositório:

```bash
git clone https://github.com/caiocruz1337/projeto-java-A3.git
```

Acesse a pasta do projeto:

```bash
cd projeto-java-A3
```

Compile os arquivos:

```bash
javac -d bin -cp "lib/*" src/cadastroalunos/*.java
```

Execute a aplicação:

```bash
java -cp "bin;lib/*" cadastroalunos.app
```

## Banco de dados

O projeto utiliza SQLite para armazenar os dados dos alunos. A tabela é criada automaticamente na primeira execução do sistema.

## Objetivos da atividade

Durante o desenvolvimento foram aplicados conceitos de:

- Programação Orientada a Objetos
- Herança
- Encapsulamento
- Interfaces
- Persistência de dados
- Consumo de API externa

## Observações

Este projeto foi desenvolvido para fins acadêmicos como parte da atividade A3, com o objetivo de praticar os conteúdos estudados durante a disciplina.
