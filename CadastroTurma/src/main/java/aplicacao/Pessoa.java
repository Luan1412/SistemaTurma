package aplicacao;

public class Pessoa {

     private String nome;
     private int idade;
     private double altura;

    void apresentar(){
        System.out.println("Olá, meu nome é: " +getNome()+" e tenho " +getIdade() + " anos e tenho: "+ getAltura() +" de altura");
     }

     boolean maiorIdade(){
        return idade >= 18;
     }

     public String getNome(){
        return nome;
     }

     public void setNome(String nome){
        this.nome = nome;
     }

     public int getIdade(){
        return idade;
     }
     
     public void setIdade(int idade){
        this.idade = idade;
     }

     public double getAltura(){
        return altura;
     }
     public void setAltura(double altura){
        this.altura = altura;
     }

     Pessoa(String nome, int idade, double altura){
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
     }

}
