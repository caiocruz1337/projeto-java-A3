package cadastroalunos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BancoDeDados {

    private static final String URL = "jdbc:sqlite:database/alunos.db";

   public Connection conectar() {
    Connection conn = null;
    try {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection(URL);
    } catch (Exception e) {
        System.out.println("Erro ao conectar ao banco: " + e.getMessage());
    }
    return conn;
}

    public boolean salvar(Aluno aluno) {
        String sql = "INSERT INTO alunos (matricula, nome, cpf, telefone, email, curso, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getCpf());
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getEmail());
            stmt.setString(6, aluno.getCurso());
            stmt.setString(7, aluno.getDataNascimento());
            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao salvar aluno: " + e.getMessage());
            return false;
        }
    }

    public Aluno buscarPorMatricula(String matricula) {
        String sql = "SELECT * FROM alunos WHERE matricula = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Aluno(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("matricula"),
                    rs.getString("curso"),
                    rs.getString("email"),
                    rs.getString("data_nascimento")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
        }
        return null;
    }

    public void atualizar(Aluno aluno) {
        String sql = "UPDATE alunos SET nome=?, cpf=?, telefone=?, email=?, curso=?, data_nascimento=? WHERE matricula=?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getCurso());
            stmt.setString(6, aluno.getDataNascimento());
            stmt.setString(7, aluno.getMatricula());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
        }
    }

    public void deletar(String matricula) {
        String sql = "DELETE FROM alunos WHERE matricula = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matricula);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao deletar aluno: " + e.getMessage());
        }
    }

    public void criarTabela() {
        String sql = """
                CREATE TABLE IF NOT EXISTS alunos (
                    matricula TEXT PRIMARY KEY,
                    nome TEXT NOT NULL,
                    cpf TEXT NOT NULL,
                    telefone TEXT,
                    email TEXT,
                    curso TEXT,
                    data_nascimento TEXT
                )
                """;
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void listarTodos() {
    String sql = "SELECT * FROM alunos";
    try (Connection conn = conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        ResultSet rs = stmt.executeQuery();
        int contador = 0;

        System.out.println("\n--- LISTA DE ALUNOS ---");

        for (ResultSet r = rs; r.next(); ) {
            String nome = r.getString("nome");

            if (nome == null || nome.isEmpty()) {
                continue; // pula alunos sem nome
            }

            contador++;
            System.out.println(contador + ". " + "Nome:" + nome + " \n — Matricula: " + r.getString("matricula") + "\n — Curso:" + r.getString("curso"));
        }

        if (contador == 0) {
            System.out.println("Nenhum aluno cadastrado.");
        }

        } catch (Exception e) {
        System.out.println("Erro ao listar alunos: " + e.getMessage());
        } finally {
        System.out.println("Consulta finalizada.");
        }
    }
}
