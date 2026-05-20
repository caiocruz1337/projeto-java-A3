package cadastroalunos;

import java.util.Scanner;

public class Terminal {
   Scanner scanner = new Scanner(System.in);
   public void exibirMenu(){
   int opcao = 0;

System.out.println("=================================================================");
System.out.println("          Bem vindos ao sistema de cadastro alunos                 ");
System.out.println("=================================================================");

while (opcao !=5) {
   System.out.println("--- MENU PRINCIPAL ---");
   System.out.println("1 - Cadastrar Aluno");
   System.out.println("2 - Consultar Aluno");
   System.out.println("3 - Atualizar Cadastro");
   System.out.println("4 - Deletar Aluno");
   System.out.println("5 - Sair ");
   System.out.println("Escolha uma opção: ");

   opcao = scanner.nextInt();
   scanner.nextLine();

switch (opcao) {
   case 1: 
   System.out.println("NOME: ");
   String nome = scanner.nextLine();
   
   System.out.println("CPF: ");
   String cpf = scanner.nextLine();
   
   System.out.println("Idade: ");
   String idade = scanner.nextLine();
   break;

   case 2: 
   System.out.println("Digite o Numero da Matricula: ");
   break;  

   case 3:
   System.out.println("Qual dado deseja atualizar?");
   break;

   case 4:
   System.out.println("Digite o nome do aluno que deseja deletar: ");
   break;

   case 5:
   System.out.println(" Encerrando sistema! Desligando... ");
   break;



}
   }
}

}
