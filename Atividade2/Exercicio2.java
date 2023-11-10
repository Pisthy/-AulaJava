package atividade2;

import java.util.Scanner;

public class exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bem-Vindo ao conversor de temperatura\n\n");
        int tipoConversor = 0;
        System.out.print("1-Converter Celsius p/Fahrenheit.\t 2-Converter Fahrenheit p/Celsius: ");
        tipoConversor = scanner.nextInt();
        int Celsius = 0, Fahrenheit = 0;
        float calculoCelsius = 0, calculoFah = 0, constante = (float) 1.8;

        switch (tipoConversor) {
            case 1:
                System.out.print("Informe a temperatura em Celsius: ");
                Celsius = scanner.nextInt();
                calculoFah = converteCelsfah(Celsius, constante);
                System.out.println("A temperatura em Fahrenheit é: " + calculoFah);
                break;

            case 2:
                System.out.print("Informe a temperatura em Fahrenheit: ");
                Fahrenheit = scanner.nextInt();
                calculoCelsius = convertefahcels(Fahrenheit, constante); 
                System.out.println("A temperatura em Celsius é: " + calculoCelsius);
                break;

            default:
                System.out.println("Opção inválida.");
        }

        scanner.close();
    }

    public static float converteCelsfah(int Celsius, float constante) {
        return (Celsius * constante + 32);
    }

    public static float convertefahcels(int Fahrenheit, float constante) {
        return ((Fahrenheit - 32) / constante);
    }
} //