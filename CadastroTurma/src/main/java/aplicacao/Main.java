package aplicacao;


public class Main {
    public static void main(String[] args) {

        /* Scanner sc = new Scanner(System.in);
        System.out.println("Quantas pessoas você quer cadastrar?");
        int quantidade = sc.nextInt();
        sc.nextLine();
        Turma t1 = new Turma(quantidade);

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Nome da pessoa: ");
            String nome = sc.nextLine();

            System.out.println("Idade da pessoa: ");
            int idade = sc.nextInt();
            sc.nextLine();

            System.out.println("Altura da pessoa: ");
            double altura = sc.nextDouble();
            sc.nextLine();

            t1.addPessoa(nome, idade, altura);
        }

        t1.mostrarListaPessoa();
        t1.calcularMediaIdade();
        t1.qntdMaiorMenorIdade(); */

        //sc.close();

        Menuu menu = new Menuu();
        menu.mostrarMenu();
    }
}