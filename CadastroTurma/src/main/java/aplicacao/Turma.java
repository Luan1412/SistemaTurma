package aplicacao;

public class Turma {

    private Pessoa listPessoas[];

    Turma(int qntPessoa) {
        listPessoas = new Pessoa[qntPessoa];
    }


    void removerPessoa(String nome){
        boolean removeu = false;
        for (int i = 0; i < listPessoas.length; i++) {
            if (listPessoas[i] != null && listPessoas[i].getNome().equals(nome)) {
                listPessoas[i]=null;
                removeu=true; 
                break;               
            }    
        }
        if (removeu) {
                System.out.println("Pessoa"+nome+" removida com sucesso!.");
            }else{
                System.out.println("Erro: pessoa"+nome+"não encontrada.");
            }
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
