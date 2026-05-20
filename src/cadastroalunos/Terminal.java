package cadastroalunos;

import java.util.Scanner;

public class Terminal {

    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao = 0;

        System.out.println("=================================================================");
        System.out.println("         Bem vindos ao sistema de cadastro de alunos             ");
        System.out.println("=================================================================");

        while (opcao != 5) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Consultar Aluno");
            System.out.println("3 - Atualizar Cadastro");
            System.out.println("4 - Deletar Aluno");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Curso: ");
                        String curso = scanner.nextLine();

                        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
                        String dataNascimento = scanner.nextLine();

                        System.out.print("Matricula: ");
                        String matricula = scanner.nextLine();

                    case 2:
                        System.out.print("Digite a matricula: ");
                        break;

                    case 3:
                        System.out.print("Digite a matricula do aluno a atualizar: ");
                        break;

                    case 4:
                        System.out.print("Digite a matricula do aluno a deletar: ");
                        break;

                    case 5:
                        System.out.println("Encerrando sistema! Ate logo!");
                        break;

                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                }

            } catch (Exception e) {
                System.out.println("Entrada invalida. Digite apenas numeros.");
                scanner.nextLine();
                opcao = 0;
            }
        }

        scanner.close();
    }
}