package cadastroalunos;

public interface Cadastravel {
    void cadastrar(Aluno aluno);
    Aluno buscar(String matricula);
    void atualizar(Aluno aluno);
    void deletar(String matricula);
    void listarTodos();
}
