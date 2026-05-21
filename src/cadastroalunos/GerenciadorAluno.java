package cadastroalunos;

public class GerenciadorAluno implements Cadastravel {

    private BancoDeDados banco = new BancoDeDados();

    public BancoDeDados getBanco() {
        return banco;
    }

    @Override
    public void cadastrar(Aluno aluno) {
        banco.salvar(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
        System.out.println(aluno);
    }

    @Override
    public Aluno buscar(String matricula) {
        Aluno aluno = banco.buscarPorMatricula(matricula);
        if (aluno != null) {
            System.out.println(aluno);
        } else {
            System.out.println("Aluno nao encontrado.");
        }
        return aluno;
    }

    @Override
    public void atualizar(Aluno aluno) {
        banco.atualizar(aluno);
        System.out.println("Cadastro atualizado com sucesso!");
    }

    @Override
    public void deletar(String matricula) {
        banco.deletar(matricula);
        System.out.println("Aluno removido com sucesso!");
    }
}

