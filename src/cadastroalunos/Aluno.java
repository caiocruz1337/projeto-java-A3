package cadastroalunos;

public class Aluno extends Pessoa {

    private String matricula;
    private String curso;
    private String email;
    private String dataNascimento;

    public Aluno(String nome, String cpf, String telefone,
                 String matricula, String curso,
                 String email, String dataNascimento) {
        super(nome, cpf, telefone);
        this.matricula = matricula;
        this.curso = curso;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    @Override
    public String toString() {
        return "\n--- DADOS DO ALUNO ---" +
               "\nNome: "            + getNome() +
               "\nCPF: "             + getCpf() +
               "\nTelefone: "        + getTelefone() +
               "\nEmail: "           + email +
               "\nCurso: "           + curso +
               "\nMatricula: "       + matricula +
               "\nData Nascimento: " + dataNascimento;
    }
}
 

