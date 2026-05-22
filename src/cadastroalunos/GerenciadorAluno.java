package cadastroalunos;

import java.text.Normalizer;
import java.time.Year;

public class GerenciadorAluno implements Cadastravel {

    private InteligenciaArtificial ia = new InteligenciaArtificial();
    private BancoDeDados banco = new BancoDeDados();

    public BancoDeDados getBanco() {
        return banco;
    }

    @Override
    public void cadastrar(Aluno aluno) {
        String resultado = ia.verificarInconsistencias(
            aluno.getNome(),
            aluno.getCurso(),
            aluno.getDataNascimento(),
            aluno.getCpf(),
            aluno.getTelefone(),
            aluno.getEmail()
        );

        if (!resultado.equalsIgnoreCase("OK")) {
            System.out.println("\nINCONSISTENCIA ENCONTRADA:");
            System.out.println(resultado);
            System.out.println("Cadastro cancelado. Corrija os dados e tente novamente.");
            return;
        }

        String matricula = gerarMatriculaUnica(aluno.getCurso());
        aluno.setMatricula(matricula);
        System.out.println("Matricula gerada: " + matricula);

        if (banco.salvar(aluno)) {
            System.out.println("Aluno cadastrado com sucesso!");
            System.out.println(aluno);
        } else {
            System.out.println("Cadastro nao realizado.");
        }
    }

    private String gerarMatriculaUnica(String curso) {
        String prefixo = Year.now().getValue() + gerarSiglaCurso(curso);

        for (int numero = 1; numero <= 9999; numero++) {
            String matricula = prefixo + String.format("%04d", numero);

            if (banco.buscarPorMatricula(matricula) == null) {
                return matricula;
            }
        }

        throw new RuntimeException("Nao existem matriculas disponiveis para o curso " + curso + " neste ano.");
    }

    private String gerarSiglaCurso(String curso) {
        if (curso == null || curso.isBlank()) {
            return "ALU";
        }

        String cursoSemAcento = Normalizer.normalize(curso, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
        String apenasLetras = cursoSemAcento.replaceAll("[^A-Za-z]", "").toUpperCase();

        if (apenasLetras.length() >= 3) {
            return apenasLetras.substring(0, 3);
        }

        return String.format("%-3s", apenasLetras).replace(' ', 'X');
    }

    @Override
    public Aluno buscar(String matricula) {
        Aluno aluno = banco.buscarPorMatricula(matricula);
        if (aluno != null) {
            System.out.println(aluno);
        } else {
            System.out.println("Aluno não encontrado.");
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

    @Override
    public void listarTodos() {
    banco.listarTodos();
    }
}

