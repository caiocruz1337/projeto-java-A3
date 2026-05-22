package cadastroalunos;

import java.util.Scanner;

public class Terminal {

    private Scanner scanner = new Scanner(System.in);
    private GerenciadorAluno gerenciador = new GerenciadorAluno();

    public void exibirMenu() {
        int opcao = 0;

        gerenciador.getBanco().criarTabela();

        System.out.println("=================================================================");
        System.out.println("         Bem vindos ao sistema de cadastro de alunos             ");
        System.out.println("=================================================================");

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Consultar Aluno");
            System.out.println("3 - Atualizar Cadastro");
            System.out.println("4 - Deletar Aluno");
            System.out.println("5 - Sair");
            System.out.println("6 - Listar Todos os Alunos");
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

                    Aluno aluno = new Aluno(nome, cpf, telefone, "", curso, email, dataNascimento);
                    gerenciador.cadastrar(aluno); 
                    break;

                case 2:
                    System.out.print("Digite a matricula: ");
                    String matBusca = scanner.nextLine();
                     gerenciador.buscar(matBusca);
                    break;
                
                case 3:
                    System.out.print("Digite a matricula do aluno a atualizar: ");
                    String matAtualizar = scanner.nextLine();
                    Aluno existente = gerenciador.buscar(matAtualizar);

                    if (existente != null) {
                        System.out.println("\n--- O QUE DESEJA ATUALIZAR? ---");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Email");
                        System.out.println("3 - Curso");
                        System.out.println("4 - Telefone");
                        System.out.println("5 - Data de Nascimento");
                        System.out.print("Escolha uma opcao: ");

                        int opcaoAtualizar = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoAtualizar) {
                            case 1:
                                System.out.print("Novo nome: ");
                                existente.setNome(scanner.nextLine());
                                break;
                            case 2:
                                System.out.print("Novo email: ");
                                existente.setEmail(scanner.nextLine());
                                break;
                            case 3:
                                System.out.print("Novo curso: ");
                                existente.setCurso(scanner.nextLine());
                                break;
                            case 4:
                                System.out.print("Novo telefone: ");
                                existente.setTelefone(scanner.nextLine());
                                break;
                            case 5:
                                System.out.print("Nova data de nascimento (dd/mm/aaaa): ");
                                existente.setDataNascimento(scanner.nextLine());
                                break;
                            default:
                                System.out.println("Opcao invalida.");
                                break;
                        }

                        gerenciador.atualizar(existente);
                    }
                break;

                case 4:
                    System.out.print("Digite a matricula do aluno a deletar: ");
                    String matDeletar = scanner.nextLine();
                    gerenciador.deletar(matDeletar);
                    break;

                case 5:
                    System.out.println("Encerrando sistema! Ate logo!");
                    break;

                case 6:
                    gerenciador.getBanco().listarTodos();
                    break;

                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }

            } catch (Exception e) {
                System.out.println("Entrada invalida. Digite apenas numeros.");
                scanner.nextLine();
                opcao = 0;
                }
        } while(opcao!=5);

        scanner.close();
    }
}