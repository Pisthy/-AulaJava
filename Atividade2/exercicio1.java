package atividade2;
import java.util.Scanner;
public class exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("bem vindo a calculadora em java\n\n");
        System.out.print("Digite o primeiro numero da operação: ");
        int numeroUm = scanner.nextInt();
        System.out.print("Digite o sinal de qual operação você deseja fazer: ");
        char operacao = scanner.next().charAt(0);
        System.out.print("Digite o segundo numero da operação: ");
        int numeroDois = scanner.nextInt();
        int resultado=0;

       switch (operacao) {
        case '+':
        resultado = numeroUm + numeroDois;    
        System.out.print("O resultado da soma é: " + resultado);
            break;
       case '-':
        resultado = numeroUm - numeroDois;    
        System.out.print("O resultado da subtração é: " + resultado);
            break;
        case '*':
        resultado = numeroUm * numeroDois;    
        System.out.print("O resultado da multiplicação é: " + resultado);
        break;
        case '/':
        resultado = numeroUm / numeroDois;    
        System.out.print("O resultado da divisão é: " + resultado);
        break;
        default:
        System.out.print("Operação inválida");
            break;
       }
        
        
    
    }

}