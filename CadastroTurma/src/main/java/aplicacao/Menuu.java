package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menuu {
    

    private Turma adicionarPessoas(Scanner sc){
       int quantidade = 0;

        // Loop para garantir número válido
        while (true) {
            try {
                System.out.println("Quantas pessoas você quer cadastrar?");
                quantidade = sc.nextInt();
                sc.nextLine(); // limpa o buffer

                if (quantidade <= 0) {
                    System.out.println("Erro: Digite um número maior que zero!");
                    continue;
                }
                break; // sai do loop se deu tudo certo

            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números inteiros!");
                sc.nextLine(); // limpa buffer
            }
        }

        Turma t1 = new Turma(quantidade);

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\n--- Cadastro " + (i + 1) + " ---");
            System.out.print("Nome da pessoa: ");
            String nome = sc.nextLine();

            int idade;
            while (true) {
                try {
                    System.out.print("Idade da pessoa: ");
                    idade = sc.nextInt();
                    sc.nextLine();

                    if (idade<=0) {
                        System.out.println("Digite um número maior que zero!");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Digite um número inteiro para idade!");
                    sc.nextLine();
                }
            }

            double altura;
            while (true) {
                try {
                    System.out.print("Altura da pessoa: ");
                    altura = sc.nextDouble();
                    sc.nextLine();

                    if (altura<=0) {
                        System.out.println("Digite um número maior que zero!");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Digite um número válido para altura (ex: 1.75)!");
                    sc.nextLine();
                }
            }

            t1.addPessoa(nome, idade, altura);
            System.out.println("Turma criada com sucesso! Pessoas cadastradas:"+quantidade);
        }

        return t1;
    }

    void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int quantidade = 0, escolha=0;
        boolean continuar = true;
        Turma t1 = null;
        do {
           
            try {
                 
            System.out.println("\n=== Bem-vindo ao menu ===");
            System.out.println("Escolha o que você deseja fazer:");
            System.out.println("1 - Adicionar pessoa");
            System.out.println("2 - Mostrar lista");
            System.out.println("3 - Calcular média");
            System.out.println("4 - Contar maiores/menores");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            escolha = sc.nextInt();
            sc.nextLine();
                   
            } catch (java.util.InputMismatchException e) {
                System.out.println("Escolha uma opção válida do menu!");
                sc.nextLine();
                continue;
            }
    
            switch (escolha) {

                case 0:
                    continuar = false;
                    break;

                case 1:


                    if (t1!=null) {
                        System.out.println("Já existe uma turma adicionada, deseja adicionar e subscrever uma nova?(S/N)");
                        String resp = sc.nextLine();
                        if(!resp.equals("s")&&resp.equals("sim"))break;
                    }
                    t1 = adicionarPessoas(sc);
                        break;

                case 2:
                    if (t1 != null) {
                        t1.mostrarListaPessoa();
                    } else
                        System.out.println("Lista vazia, adicione pessoas para mostrar a turma.");
                    break;

                case 3:
                    if (t1 != null) {
                        t1.calcularMediaIdade();
                    } else
                        System.out.println("Crie uma turma primeiro.");

                    break;

                case 4:
                    if (t1 != null) {
                        t1.qntdMaiorMenorIdade();
                    } else
                        System.out.println("Crie uma turma primeiro.");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    System.out.println("-------------------------------");
            }
        } while (continuar);
        System.out.println("Programa encerrado.");
        sc.close();
    }

}