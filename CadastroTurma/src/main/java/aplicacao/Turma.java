package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Turma {

    private Pessoa listPessoas[];

    Turma(int qntPessoa) {
        listPessoas = new Pessoa[qntPessoa];
    }

    boolean editarPessoa(String nome,Scanner sc){
        boolean encontrouPessoa=false;
        int escolha=0;
        for (int i = 0; i < listPessoas.length; i++) {
            if (listPessoas[i] != null && listPessoas[i].getNome().equals(nome)) {
               
                encontrouPessoa= true;

                boolean continuarEditando= true;
                while (continuarEditando) {
                    try {
              
                    System.out.println("\n=== Bem-vindo ao modo edição ===");
                    System.out.println("O que do(a) "+listPessoas[i].getNome()+" você quer editar?");
                    System.out.println("Escolha o que você deseja fazer:");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Idade");
                    System.out.println("3 - Altura");
                    System.out.println("0 - Sair da Edição");
                    System.out.print("Opção: ");

                    escolha = sc.nextInt();
                    sc.nextLine();
                    
                    switch (escolha) {
                        
                        case 0:
                        System.out.println("Saindo do modo edição...");
                        continuarEditando=false;
                        break;
                        
                        case 1:
                            System.out.println("\n=== Você escolheu editar o nome ====");
                            System.out.println("Edite o nome");
                            System.out.println("Nome: ");
                            String nomeEditado = sc.nextLine();
                            listPessoas[i].setNome(nomeEditado);
                            break;
                        case 2:
                            while (true) {
                                
                            try {
                
                            System.out.println("\n=== Você escolheu editar a idade ====");
                            System.out.println("Digite a nova idade");
                            System.out.println("Idade: ");
                            int idade = sc.nextInt();
                            sc.nextLine();
                            
                            if(idade<=0){
                                System.out.println("Erro: A idade deve ser maior que zero!");
                                continue;
                            }

                            listPessoas[i].setIdade(idade);
                            System.out.println("Idade editada.");
                            break;

                             } catch (InputMismatchException e) {
                                System.out.println("Erro: Digite apenas números inteiros!");
                                sc.nextLine();
                            } 
                        }
                            break;
                         case 3:

                            while (true) {
                                
                            try {
        
                            System.out.println("\n=== Você escolheu editar a altura ====");
                            System.out.println("Edite a altura");
                            System.out.println("Altura: ");

                            double altura = sc.nextDouble();
                            if(altura<=0){
                                System.out.println("Erro: Altura deve ser acima de zero.");
                                continue;
                            }
                            listPessoas[i].setAltura(altura);
                            System.out.println("Altura editada com sucesso!");
                            break;

                            } catch (InputMismatchException e) {
                                System.out.println("Erro: Digite apenas números!");
                                sc.nextLine();
                            } 
                        }  
                        break;

                        default:
                            System.out.println("Digite uma opção válida");
                            continue;
                            
                    }
                     }  catch (InputMismatchException e) {
                            System.out.println("Erro: Digite apenas números inteiros!");
                            sc.nextLine();
                    }    
                }
                break;        
            } 
        }

        return encontrouPessoa;
    }

    boolean removerPessoa(String nome){
        boolean removeu = false;
        for (int i = 0; i < listPessoas.length; i++) {
            if (listPessoas[i] != null && listPessoas[i].getNome().equals(nome)) {
                listPessoas[i]=null;
                removeu=true; 
                break;               
            }    
        }
        return removeu;
    }

    void addPessoa(String nome, int idade, double altura) {

        boolean adicionou = false; // flag para saber se a pessoa foi adicionada
        for (int i = 0; i < listPessoas.length; i++) {
            if (listPessoas[i] == null) {
                listPessoas[i] = new Pessoa(nome, idade, altura);
                adicionou = true; // marca que conseguiu adicionar
                break; // sai do loop, porque já adicionou
            }

        }
        if (!adicionou) { // se percorreu todo o array e não encontrou espaço
            System.out.println("Turma cheia!");
        }
    }
    

    void mostrarListaPessoa() {
        for (int i = 0; i < listPessoas.length; i++) {
            if (listPessoas[i] != null) {
                listPessoas[i].apresentar();
                if (listPessoas[i].maiorIdade()) {
                    System.out.println("Sou maior de idade");
                } else {
                    System.out.println("Sou menor de idade");
                }
            } else {
                System.out.println("Pessoa não encontrada");
            }

        }

    }

    void calcularMediaIdade() {
        int acumuladorIdade = 0, idades = 0;
        for (int i = 0; i < listPessoas.length; i++) {
            if (listPessoas[i] != null) {
                acumuladorIdade = acumuladorIdade + listPessoas[i].getIdade();
            idades++;
            }else{
                System.out.println("Idades não encontadas");
                break;
            }
            
        }
        if (idades>0) {
            double media = (double) acumuladorIdade / idades;
            System.out.println("A média de idade é:" + media);
        }else{
            System.out.println("Erro no calculo, tente novamente!");
        }
       
    }

    void qntdMaiorMenorIdade() {
        int contadormenor = 0, contadormaior = 0;
        for (int i = 0; i < listPessoas.length; i++) {
            if (listPessoas[i] != null) {
               if (listPessoas[i].maiorIdade()) {
                contadormaior++;
            }else{
                 contadormenor++;
            }
                
            }else{
                System.out.println("Idade não encontrada");
               
            }
        }
        System.out.println("Total de pessoas maiores de idade:" + contadormaior);
        System.out.println("Total de pessoas menores de idade:" + contadormenor);
    }
}
