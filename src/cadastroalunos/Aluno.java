package cadastroalunos;
public class Aluno {

    private static int geradorMatricula = 1000; // Gera matrículas automaticamente
    
    private int matricula;
    private String nome;
    private String cpf;
    private int idade;

    public Aluno(String nome, String cpf, int idade) {
        this.matricula = geradorMatricula++; // Cada aluno ganha um número único
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    // Getters e Setters (para podermos acessar e alterar os dados com segurança)
    public int getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
};
