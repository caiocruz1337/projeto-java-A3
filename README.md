# 📚 Projeto Java A3 - UniBH

Alunos:
Jonatas Natanael Antunes Oliveira - RA: 1232021950


Projeto desenvolvido para o trabalho A3 do UniBH, utilizando Java para simular um sistema simples de cadastro de alunos via terminal.

## 📌 Objetivo do projeto

O sistema foi criado com foco em praticar conceitos fundamentais de programação orientada a objetos, organização de classes, manipulação de dados e estruturação de projetos em Java.

O projeto possui funcionalidades básicas de gerenciamento de alunos, permitindo interação diretamente pelo terminal.

---

## 🛠 Tecnologias utilizadas

- Java
- SQL
- VS Code

---

## 📁 Estrutura do projeto

```bash
projeto-java-A3/
├── src/
│   ├── cadastroalunos/
│   │   ├── Aluno.java
│   │   ├── BancoDeDados.java
│   │   ├── Cadastravel.java
│   │   ├── GerenciadorAluno.java
│   │   ├── InteligenciaArtificial.java
│   │   ├── Pessoa.java
│   │   ├── Terminal.java
│   │   └── app.java
│   └── database/
│       └── schema.sql
├── bin/
├── .vscode/
├── .gitignore
└── README.md

⚙️ Funcionalidades
Cadastro de alunos
Consulta de informações
Atualização de cadastro
Remoção de alunos
Menu interativo no terminal

▶️ Como executar o projeto
1. Clonar o repositório
git clone https://github.com/caiocruz1337/projeto-java-A3.git
2. Entrar na pasta do projeto
cd projeto-java-A3
3. Compilar os arquivos Java
javac -d bin src/cadastroalunos/*.java
4. Executar o projeto
java -cp bin cadastroalunos.app

💻 Exemplo do menu
1 - Cadastrar Aluno
2 - Consultar Aluno
3 - Atualizar Cadastro
4 - Deletar Aluno
5 - Sair

👨‍🎓 Informações do aluno

Os alunos cadastrados possuem:

Nome
CPF
Idade
Matrícula
