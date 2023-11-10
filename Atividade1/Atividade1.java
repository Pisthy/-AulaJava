package atividade1;
import java.util.Scanner;
public class verificaNumeroPrimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número inteiro para verificar se ele é primo ou não: ");
        int numeroVer = scanner.nextInt();

        if (verificaNumeroPrimo(numeroVer) == 1) {
            System.out.println(numeroVer + " (1) - é um número primo.");
        } else {
            System.out.println(numeroVer + " (0) não é um número primo.");
        }
        scanner.close();
    }
    public static int verificaNumeroPrimo (Integer n){
        if (n<=1){
            return 0;     
        }
        if (n<=3){
            return 1;
        }
        if (n % 2 == 0 || n % 3 ==0){
            return 0;
        }

        for (int i = 5; i * i<= n; i+=6){
            if (n%i == 0 || n%(i + 2)==0){
                return 0;
            }

        }
            return 1;
    }
    
}